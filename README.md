# HA_Benchmark

面向 SAST（静态应用安全测试）工具的**深度导向**测试集：在覆盖面之外，更看重
**长链路、跨文件跨模块的污点流**，以及**行级精确、动态验证过**的标答。

中文 | [English](README.en.md)

---

## 为什么做这个

现有的 Java 靶场（WebGoat、Benchmark 之类）广度是够的——漏洞种类多、编号齐全。
问题在深度：**source 与 sink 常常落在同一个文件里、相隔两三次调用**。
这样的样本测出来的其实是"工具认不认识这个危险 API"，而不是"工具能不能把数据流跟到底"。
可真实项目里的漏洞恰恰是另一副样子：请求参数在 controller 收下，经过若干层 service、
写进字段、塞进集合、跨模块调用、最后在某个 dao 里进入 SQL。

这个测试集补的就是这一维：

* **链路是长的、散的** —— 单条污点链路平均跨 7.4 个文件、穿越 11.4 层方法调用、
  经过 27.7 条传播语句，最长的一条跨 15 个文件、21 层调用
* **标答是验证过的，不是声称的** —— 每条用例都被真实跑过：攻击载荷能否到达 sink、
  到达时是否还有攻击语义、调用链实际多深，全部是运行时实测
* **写法不重复** —— 每个 sink / 净化器 / 传播算子都有若干等价写法，一半的类走
  Spring 依赖注入、一半是静态工具类。没有哪一条正则能通吃

它能回答的问题是这一类：「工具 X 的跨过程分析在第几层断链」「静态字段传播会不会让它丢链路」
「它能不能分辨有效净化与看着有效的净化」。
它**不**回答「工具 X 在真实项目上的召回率是多少」——见文末「测什么、不测什么」。

## 覆盖矩阵

用例 412 条（vulnerable 276 / safe 136），其中 85 组逐行配对的正负样本。

| CWE | 漏洞 | sink 形态 | 用例 | vulnerable | safe | 配对组 |
|---|---|---|---:|---:|---:|---:|
| CWE-89 | SQL 注入 | JDBC 字符串拼接 | 78 | 52 | 26 | 18 |
| CWE-89 | SQL 注入 | MyBatis XML `${}` | 59 | 41 | 18 | 8 |
| CWE-917 | 表达式注入 | SpEL 求值 | 85 | 54 | 31 | 17 |
| CWE-78 | 命令注入 | `Runtime.exec` / `ProcessBuilder` | 73 | 45 | 28 | 20 |
| CWE-918 | 服务端请求伪造 | URL 抓取 | 65 | 47 | 18 | 13 |
| CWE-22 | 路径穿越 | 文件读取 | 52 | 37 | 15 | 9 |
| | | **合计** | **412** | **276** | **136** | **85** |

5 类 CWE、6 种 sink 形态。CWE-89 拆成两种是有意的：JDBC 那批的危险行在 `.java` 里，
MyBatis 那批的危险行在 **XML** 里，Java 侧看不到任何拼接（见下文）。

配对组指逐行相同、只差一个 sanitizer 的正负样本对，用来测「配对判别力」。

## 规模与形态

| | 平均 | 最大 | 说明 |
|---|---:|---:|---|
| 跨文件数 | 7.4 | 15 | 污点路径经过的不同文件 |
| 调用帧数 | 11.4 | 21 | 穿越的方法调用层数 |
| 路径节点 | 27.7 | 61 | 参与传播的语句条数 |
| 跨模块数 | 2.4 | 3 | 经过的 Maven 模块（共 4 个模块，路径落在 web/service/dao 三层） |

三者的比例是 **3.7 : 1.5 : 1**（语句 : 方法 : 文件）。这个梯度是刻意的：早期版本三个数
几乎相等，等于"一条语句一个方法一个文件"，一眼就能看出是生成的。

注意三个量互相锁死：一个文件至少装一个方法，一个方法至少装一条语句，所以恒有
**跨文件数 ≤ 调用帧数 ≤ 路径节点数**。想要高跨文件度，链路就不可能短。

按调用链长度分层，各档样本量均衡，可以直接画「检出率 vs 链路深度」的衰减曲线：

| 调用链长度 | ≤7 层 | 8-10 层 | 11-13 层 | 14 层以上 |
|---|---:|---:|---:|---:|
| 用例数 | 80 | 112 | 97 | 123 |

工程本身是 Java 11 + Spring Boot 2.7 + Maven 四模块（web → service → dao → common），
3789 个业务类、59 个 MyBatis XML mapper。

## 怎么用

```bash
mvn -DskipTests compile
```

需要编译的工具先跑这一步（不需要也可以直接扫源码）。然后：

1. 用你的 SAST 工具扫描本目录，导出 SARIF
2. 把报告与 `groundtruth/<用例 id>.json` 对照——`sink` 是主位置，`source` 与 `path` 用来
   判断工具是否真做了数据流分析
3. 按 L1 / L2 / L3 三级统计，再加一项配对判别力（见「建议的评分方式」）

`manifest.json` 是用例清单，带每条的规模指标，可以直接用来切片统计。

## 标答格式

每个 `groundtruth/<id>.json`：

| 字段 | 含义 |
|---|---|
| `verdict` | `vulnerable` / `safe` —— 该用例是否真存在漏洞 |
| `cwe` | 漏洞类型 |
| `entry` | HTTP 入口（controller 方法）位置 |
| `source` | 污点入口位置（`file` + 1-based `line`） |
| `sink` | 危险调用位置 |
| `sanitizer` | 净化点位置；无净化时为 `null` |
| `sanitizer_kind` | 净化器种类（见下表），`none` 表示无净化 |
| `path` | source→sink 的完整传播路径，含两端，按执行顺序；每个节点的 `expr` 是该行上流动的污点表达式 |
| `metrics.call_depth` | **调用链长度**：穿越的方法调用帧数（运行时实测校验过） |
| `metrics.chain_len` | 路径节点数：污点经过的语句位置数 |
| `metrics.files_crossed` | 路径经过的不同文件数 |
| `metrics.modules_crossed` | 路径经过的不同 Maven 模块数 |
| `metrics.features` | source / sink / 传播算子标签，用于按能力切片统计 |
| `paired_negative` | 配对负样本的用例 id |
| `http` | PoC 请求信息：方法、路径、参数名/头名/Cookie 名、载体 |
| `verification` | 动态验证结果：探针是否命中（`reached`）、载荷是否完整（`tainted`）、是否被安全写法中和（`neutralized`）、实测调用链长度（`call_depth_observed`） |
| `verification.control` | 良性载荷正对照（只有 safe 用例有），见下 |

`file` 是相对本目录的正斜杠路径，`line` 从 1 开始。

## 标答是被验证过的，不是声称的

多数测试集的标答靠人工标注，那条路径可能根本不可达。这里每个 sink 之前都埋了探针
（`common/.../AuditTrail.java`），发布前会把工程真的跑起来、按载体（query / path /
header / cookie）发 PoC 请求，再核对：

* `vulnerable` —— 必须命中探针，且攻击载荷到达 sink 时仍然完整
* `safe` —— 攻击载荷必须没能完整到达 sink，**并且**良性载荷必须走通整条链路

验证的是**可达性 + 可控性**，不是"利用成功"：探针埋在真实危险调用之前，
所以 h2 里没有那张表、机器上没有 `/bin/sh` 都不影响结论。

### safe 用例还要做一次正对照

safe 的判据是**缺席**——"攻击载荷没有完整到达 sink"。麻烦在于"请求被容器拒掉""代码在
半路崩了"同样满足这个判据，现象一模一样（探针无记录）。也就是说，一整批 safe 用例
可以在链路根本没被走通的情况下报告全部通过。

所以每条 safe 用例都会**再发一轮良性载荷**：换一个能通过该净化器的正常输入
（`whitelist_regex` → `abc123`，`command_allowlist` → `status`，
`path_canonical_check` → `notes.txt`，`ssrf_host_allowlist` → `api.internal.example`），
这一轮探针**必须**命中，且实测调用链长度与标注一致。命中即证明这条链路本来是通的，
上一轮"没命中"才真的是净化器拦下来的。结果记在 `verification.control`。

**当前 412 条用例每一条都有正向运行时证据**：276 条 vulnerable 命中探针，
136 条 safe 的良性载荷全部走通整条链路。

这条检查不是摆设：引入它的当天就抓出 73 条 safe 用例的链路其实走不通——传播链路上的
字符串拼接会给值加前缀，等它流到字符白名单或 host 白名单守卫时必然被拒，
于是那些 controller 对**任何**输入都是死的。现在拼接只用白名单字符集，
整值比对型守卫的链路里也不允许出现会改写值的算子，生成阶段直接拦下。

无效净化的差别可以直观看出来 —— 同样发 `zz' OR 1=1--`：

| 用例 | 到达 sink 时的 SQL |
|---|---|
| 无净化 | `... WHERE name = 'zz' OR 1=1--'` |
| 只剥单引号 | `... WHERE name = 'zz OR 1=1--'` ← 仍可注入 |
| 白名单校验 | 未到达（而良性输入 `abc123` 到达了） |

## 净化器：惯用正确修复 vs 典型错误修复

safe 用例不是简单地"加个过滤函数"，而是按每类漏洞的**惯用修复方式**写的——工具的规则库
恰恰是照这些写法调的。同时配了真实世界里常见的**错误修复**：看着做了防护，实际可绕过。

| 净化器 | 适用 sink | 有效 | 用例 | 说明 |
|---|---|:---:|---:|---|
| `whitelist_regex` | 全部 | ✔ | 62 | 字符白名单 `^[A-Za-z0-9_]{1,64}$` |
| `sql_parameterized` | jdbc_concat | ✔ | 14 | `PreparedStatement` 参数绑定，CWE-89 的正解 |
| `command_allowlist` | runtime_exec | ✔ | 9 | 取值必须落在固定集合内 |
| `exec_no_shell` | runtime_exec | ✔ | 9 | `ProcessBuilder` 传参数数组，不经 shell |
| `path_canonical_check` | file_read | ✔ | 7 | `normalize()` 后校验前缀，CWE-22 的正解 |
| `spel_restricted_context` | spel_eval | ✔ | 16 | `SimpleEvaluationContext` 只读绑定，禁止类型引用 |
| `ssrf_host_allowlist` | url_fetch | ✔ | 10 | 解析出 host 再查白名单，CWE-918 的正解 |
| `mybatis_parameterized` | mybatis_dollar | ✔ | 9 | XML 里改用 `#{}`，值不进 SQL 文本 |
| `incomplete_quote_strip` | jdbc / mybatis | ✘ | 17 | 只剥单引号，注释符与关键字仍可通过 |
| `metachar_strip_semicolon` | runtime_exec | ✘ | 3 | 只删分号，`$( )`、反引号、`\|`、`&&` 一概不管 |
| `traversal_replace_once` | file_read | ✘ | 9 | 单次替换 `../`，`....//` 会被还原 |
| `spel_strip_type_ref` | spel_eval | ✘ | 9 | 单次替换 `T(`，`TT((` 会被还原 |
| `ssrf_host_denylist` | url_fetch | ✘ | 13 | 只按名字拒绝 `localhost`，`127.0.0.1` 照过 |
| `none` | —— | —— | 225 | 无净化 |

**五种无效净化的绕过都是动态证实的**：PoC 载荷经过它们之后仍完整到达 sink。
四种落在 sink 自身的有效净化（参数化、不经 shell、受限求值上下文、MyBatis `#{}`）
则记为 `neutralized`——污点确实到了那个 API，只是不再具有攻击语义。
标答里 `verification.neutralized` 区分了"没到达"与"到达但已失效"这两种安全。

净化器与 sink 的对应关系在生成阶段强制校验，`verdict` 由净化器是否有效唯一决定，
不允许人为标注——给路径穿越配"剥离单引号"这种没有意义的组合会直接报错。

## 污点入口：5 种 source × 4 种载体

| source | 载体 | 取值方式 | 用例 |
|---|---|---|---:|
| `servlet_header` | header | `HttpServletRequest.getHeader()` | 116 |
| `spring_path_variable` | path | `@PathVariable` | 101 |
| `spring_request_param` | query | `@RequestParam` | 94 |
| `spring_cookie_value` | cookie | `@CookieValue` | 53 |
| `spring_request_header` | header | `@RequestHeader` | 48 |

请求头刻意分成两种：同一个载体，一种走 Servlet API、一种走 Spring 的注解绑定。
工具的 source 规则常常只覆盖其中一种，分开才看得出来。

头名与 Cookie 名都按用例派生成业务化的名字（`X-Order-Trace`、`bundle_ref`），
不会出现 `payload` 这类把答案写在 HTTP 层的词。

Cookie 载体的 PoC 载荷是**另一套**：RFC 6265 的 cookie 值不含空格，带空格的载荷会被
Tomcat 直接 400，而百分号编码到不了 sink（Tomcat 不解码 cookie 值）。所以那批用例改用
等价的无空格写法——SQL 用 `/**/` 当空白（`zz'/**/OR/**/1=1--`），SpEL 的 `+` 两侧本来
就不需要空格。攻击语义不变。

## 跨 Java → XML 的污点流

MyBatis 那批用例（`JAVA-MYBATIS-*`）和别的不一样：Java 侧看不到任何拼接，
危险的那一行根本不在 `.java` 里。

```java
// service/…/CatalogGateway.java —— Java 侧只是把值交出去
public void enrich(String value) {
    try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
        register(session.getMapper(CatalogMapper.class), value);
    } catch (RuntimeException e) { … }
}

private void register(CatalogMapper mapper, String value) {
    mapper.register(value);
}
```

```xml
<!-- service/src/main/resources/…/CatalogMapper.xml —— 污点在这里进入 SQL -->
<select id="register" resultType="map">
  SELECT id, total
    FROM orders
   WHERE name = '${tariffRef}'
</select>
```

所以这批用例的 `sink` 指向的是一个 **XML 文件的行号**，`path` 的最后一跳是 Java → XML。
工具要报出它，必须同时读懂 mapper 接口、XML 里的语句 id 与 `${}` 的语义；
只扫 `.java` 的工具在这批上是零召回。配对负样本只差一个字符：`${}` 换成 `#{}`。

**这一批的 `neutralized` 是实测出来的**：探针在语句下发前读一眼 XML 渲染出的最终 SQL，
看参数值是否被拼了进去。`${}` 会把值直接拼进语句，`#{}` 只留一个 `?` 占位符——
这是 Java 侧看不出来、只有跨过 XML 才能得到的结论。

## 写法不重复

如果每条用例的 sink 都是逐字符相同的一句 `Runtime.getRuntime().exec(argv)`，
一条正则就能把整批命令注入拿满分，测出来的是"认不认得出这份模板"，不是分析能力。

所以每个片段都备了若干**语义等价、写法不同**的版本，按用例 id 确定性选取：

| 片段 | 等价写法 |
|---|---|
| 拼串（进 SQL / 命令 / 路径 / URL / 表达式 前那一步） | `+` 拼接、`String.format`、`StringBuilder.append`、`String.concat` |
| 命令执行 | `Runtime.getRuntime().exec(argv)`、`new ProcessBuilder(argv).start()`、`ProcessBuilder(List)` |
| 文件读取 | `Files.readAllBytes`、`Files.readAllLines`、`Files.newInputStream` |
| SQL 执行 | `Statement.executeQuery(sql)`、`Statement.execute(sql)`，连接取法也分两种 |
| SpEL 求值 | 链式 `parseExpression(t).getValue()`、先取出 `Expression` 再求值、匿名 parser |
| URL 抓取 | `openStream()`、`openConnection().getInputStream()`、先拿 `URLConnection` 再取流 |
| 局部传递 | 直接赋值、`final` 赋值、`String.valueOf`、`new StringBuilder(v).toString()` |
| 集合传递 | `HashMap.get`、`LinkedHashMap.getOrDefault`、`ArrayList.add/get` |
| 剥字符型净化 | `replace`、`replaceAll`、三目 `contains ? replace : 原值`、`if` 块内替换 |
| 白名单校验 | 静态 `Pattern` + `matcher().matches()`、`String.matches`、先取 `Matcher` 再判 |
| 取值白名单 | `HashSet.contains`、`Collections.unmodifiableList`、`Arrays.asList(...).contains` |

字面量同样按用例散开：表名、投影列、WHERE 列、库名、文件根目录、shell 命令、
URL 路径、SpEL 前缀、异常类型。

## 工程形态

调用链上的类有两种装配方式，同一条链路里可以混着用：

* **Spring bean** —— `@Service` / `@Component` / `@Repository` + 构造器注入，
  调用点上只有 `this.xxx.method(v)`，看不到目标类名；接口派发那一档注入的是
  `Map<String, 策略接口>`，靠一个常量 bean 名取出实现——真实工程里最常见的策略注册表
* **静态工具类** —— `public final class` + 静态方法，调用点上写着目标类名

412 条里 159 条整条链都走注入，其余是"前半截注入、后半截静态工具类"的混合形态
（静态方法拿不到容器里的 bean，所以注入只出现在链路前缀）。业务类里 48% 是 bean。
**两种风格的调用帧数完全一致**，所以 `metrics.call_depth` 与运行时实测在两种风格下都对得上。

其余让它更像一个在维护中的工程、而不是一份测试集的地方：包名是 `com.northwind`
（一个虚构的订单平台），代码里没有任何 benchmark 字样；类上有业务口径的 Javadoc，
约一半的类有 slf4j 日志；controller 一半把公共前缀提到类上的 `@RequestMapping`，
返回值一半是 `ResponseEntity`；净化器里的注释只讲业务理由，不写"这是无效净化"。

## 建议的评分方式

只看召回率会被"见到危险函数就报"的工具刷满分。建议至少分三级：

| 级别 | 判定 | 说明 |
|---|---|---|
| L1 | 报告位置命中 `sink`（同文件 ±2 行） | 主指标：是否报出了这个漏洞 |
| L2 | `source` 和 `sink` 都命中 | 是否真把两端连上了 |
| L3 | 报告的数据流路径对 `path` 的覆盖率 | 是否做了全程数据流分析 |

匹配时把工具报告里的主位置与数据流路径上的所有位置合在一起比对；
文件路径用后缀匹配（工具报的路径常带绝对前缀）。
能力画像建议按 `metrics.call_depth` 分桶，而不是按路径节点数——跨过程分析的深度限制
是按调用边计的。

再加一个**配对判别力**：

```
DR = |检出正样本 且 未报其 paired_negative| / 配对组数
```

配对的正负样本除了一处 sanitizer 之外逐行相同，所以 DR 能直接暴露模式匹配型工具——
它们在这项上是 0%。

## 这个测试集测什么、不测什么

**测**：SAST 工具的分析能力边界。链路能跟多深、哪些传播载体（实例字段、静态字段、
集合元素、接口多态、依赖注入、跨模块调用、Java→XML）会让它断链、能否区分有效净化与
无效净化、报出的是完整数据流还是只是 sink 处的模式匹配。

**不测**：工具在某个真实项目上的表现。这里的代码是生成的，不追求真实世界代表性，
也不包含真实 CVE 样本。

所以结论应当这样读：「工具 X 在跨模块的静态字段传播上失效」是成立的；
「工具 X 在真实项目上的召回率是 Y%」不是本测试集能回答的问题。

## 说明

`common/src/main/java/com/northwind/platform/` 下的 `AuditTrail.java`、
`StatementAudit.java`、`MapperSessions.java` 是动态验证用的探针与会话工厂，
属于测试基础设施，不是被测语义的一部分——工具在这几个文件里报出的问题请忽略。

它们刻意不叫 `TaintOracle` / `reached()` / `neutralized()`：那样的命名等于在每个 sink
前面写明答案。代码里也不出现用例 id——探针从调用栈自取包段作为标识。

## 许可

MIT，见 [LICENSE](LICENSE)。
