# Ha_benchmark

面向 SAST（静态应用安全测试）工具的测试集：多 source、多 sink、跨文件跨模块、长链路，
每条用例附带经过**动态验证**的标答。

* 用例 277 条（vulnerable 186 / safe 91），其中 70 组逐行配对的正负样本
* 覆盖 CWE-22 / CWE-78 / CWE-89；Java 11 + Spring Boot 2.7 + Maven 多模块
* 传播路径平均 12.3 个节点，最长 25 个；单条链路最多跨 19 个文件、3 个模块
* 全部通过动态验证：每条 `vulnerable` 用例的攻击载荷都被证实能到达 sink 且保持攻击语义；
  每条 `safe` 用例都被证实到不了 sink

## 内容

```
pom.xml                Maven 父工程
modules/               web -> service -> dao -> common，依赖方向与污点流向一致
groundtruth/<id>.json  每条用例的标答
manifest.json          用例清单与规模指标
```

## 怎么用

```bash
mvn -DskipTests compile
```

需要编译的工具先跑上面这步，然后用你的 SAST 工具扫本目录、导出 SARIF，
再把结果和 `groundtruth/` 对照。

## 标答格式

每个 `groundtruth/<id>.json`：

| 字段 | 含义 |
|---|---|
| `verdict` | `vulnerable` / `safe` —— 该用例是否真存在漏洞 |
| `cwe` | 漏洞类型 |
| `source` | 污点入口位置（`file` + 1-based `line`） |
| `sink` | 危险调用位置 |
| `sanitizer` | 净化点位置；无净化时为 `null` |
| `path` | source→sink 的完整传播路径，含两端，按执行顺序 |
| `metrics.chain_len` | 路径节点数（链路深度） |
| `metrics.files_crossed` | 路径经过的不同文件数 |
| `metrics.modules_crossed` | 路径经过的不同 Maven 模块数 |
| `metrics.features` | 用到的 source / sink / 传播算子标签，用于按能力切片统计 |
| `paired_negative` | 配对负样本的用例 id（见下） |
| `verification` | 动态验证结果：探针是否命中、载荷到达 sink 时是否完整 |

`file` 是相对本目录的正斜杠路径，`line` 从 1 开始。

## 标答是被验证过的，不是声称的

多数测试集的标答靠人工标注，可能那条路径其实根本不可达。这里每个 sink 之前都埋了探针
（`modules/common/.../TaintOracle.java`），发布前会把工程真的跑起来、按载体
（query / path / header）发 PoC 请求，再核对：

* `vulnerable` 用例 —— 必须命中探针，且攻击载荷到达 sink 时仍然完整
* `safe` 用例 —— 必须不命中探针，或命中但载荷已失去攻击语义

验证的是**可达性 + 可控性**，不是"利用成功"：探针埋在真实危险调用之前，
所以 h2 里没有 `orders` 表、机器上没有 `/bin/sh` 都不影响结论。

无效净化的用例可以直观看出差别 —— 同样发 `zz' OR 1=1--`：

| 用例 | 到达 sink 时的 SQL |
|---|---|
| `JAVA-SQLI-0001`（无净化） | `... WHERE name = 'zz' OR 1=1--'` |
| `JAVA-SQLI-0005`（只剥单引号） | `... WHERE name = 'zz OR 1=1--'` ← 仍可注入 |
| `JAVA-SQLI-0001-N`（白名单校验） | 未到达 |

## 建议的评分方式

只看召回率会被"见到危险函数就报"的工具刷满分。建议至少分三级：

| 级别 | 判定 | 说明 |
|---|---|---|
| L1 | 报告位置命中 `sink`（同文件 ±2 行） | 主指标：是否报出了这个漏洞 |
| L2 | `source` 和 `sink` 都命中 | 是否真把两端连上了 |
| L3 | 报告的数据流路径对 `path` 的覆盖率 | 是否做了全程数据流分析 |

匹配时把工具报告里的主位置和数据流路径上的所有位置合在一起比对；
文件路径用后缀匹配（工具报的路径常带绝对前缀）。

再加一个**配对判别力**：

```
DR = |检出正样本 且 未报其 paired_negative| / 配对数
```

配对的正负样本除了一处 sanitizer 之外逐行相同，所以 DR 能直接暴露模式匹配型工具——
它们在这项上是 0%。

## 这个测试集测什么

**测**：SAST 工具的分析能力边界。链路能跟多深、哪些传播载体（实例字段、静态字段、
集合元素、接口多态、跨模块调用）会让它断链、能否区分有效净化与无效净化、
报出的是完整数据流还是只是 sink 处的模式匹配。

**不测**：工具在某个真实项目上的表现。这里的代码是生成的，不追求真实世界代表性，
也不包含真实 CVE 样本。

所以结论应当这样读：「工具 X 在跨模块的静态字段传播上失效」是成立的；
「工具 X 在真实项目上的召回率是 Y%」不是本测试集能回答的问题。

## 说明

`modules/common/.../TaintOracle.java` 是动态验证用的探针，属于测试基础设施，
不是被测语义的一部分——工具在这个文件里报出的问题请忽略。
