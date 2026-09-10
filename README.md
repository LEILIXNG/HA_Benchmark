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
它**不**回答「工具 X 在真实项目上的召回率是多少」：这里的代码是生成的，
不追求真实世界代表性，也不含真实 CVE 样本。

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
MyBatis 那批的危险行在 **XML** 里，Java 侧看不到任何拼接——`path` 的最后一跳
是 Java → XML，只扫 `.java` 的工具在那 59 条上是零召回。

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
| `sanitizer_kind` | 净化器种类；`none` 表示无净化。有效净化对应 `safe`，无效净化（看着做了防护、实际可绕过）仍然是 `vulnerable` |
| `path` | source→sink 的完整传播路径，含两端，按执行顺序；每个节点的 `expr` 是该行上流动的污点表达式 |
| `metrics.call_depth` | **调用链长度**：穿越的方法调用帧数（运行时实测校验过） |
| `metrics.chain_len` | 路径节点数：污点经过的语句位置数 |
| `metrics.files_crossed` | 路径经过的不同文件数 |
| `metrics.modules_crossed` | 路径经过的不同 Maven 模块数 |
| `metrics.features` | source / sink / 传播算子标签，用于按能力切片统计 |
| `paired_negative` | 配对负样本的用例 id |
| `http` | PoC 请求信息：方法、路径、参数名/头名/Cookie 名、载体 |
| `verification` | 动态验证结果：探针是否命中（`reached`）、载荷是否完整（`tainted`）、是否被安全写法中和（`neutralized`）、实测调用链长度（`call_depth_observed`） |
| `verification.control` | 良性载荷正对照（只有 safe 用例有）：换一个能通过净化器的正常输入再发一次，探针必须命中——命中才证明这条链路本来是通的，攻击载荷「未到达」才真的是净化器的功劳 |

`file` 是相对本目录的正斜杠路径，`line` 从 1 开始。

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
