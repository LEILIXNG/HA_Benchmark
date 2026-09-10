# HA_Benchmark

A **depth-oriented** benchmark for SAST tools: beyond breadth of vulnerability
classes, it emphasises **long, cross-file, cross-module taint flows** with
**line-precise, dynamically verified** ground truth.

[中文](README.md) | English

---

## Why this exists

Existing Java test suites (WebGoat, OWASP Benchmark and friends) have breadth —
many vulnerability classes, well catalogued. What they lack is depth: **source and
sink usually sit in the same file, two or three calls apart**. A sample like that
measures whether a tool recognises a dangerous API, not whether it can follow data
across a program. Real defects look different: a request parameter enters a
controller, passes through several service layers, is stored in a field, put into a
collection, handed across a module boundary, and finally reaches SQL in some dao.

That is the axis this suite adds:

* **Flows are long and spread out** — a single taint flow crosses 7.4 files,
  11.4 call frames and 27.7 propagation statements on average; the longest crosses
  15 files and 21 frames
* **Ground truth is verified, not asserted** — every case is actually executed:
  whether the payload reaches the sink, whether it still carries attack semantics
  when it gets there, and how deep the call chain really is, are all measured at runtime
* **No repeated boilerplate** — every sink, sanitizer and propagation operator has
  several equivalent spellings; half the classes use Spring dependency injection,
  half are static utility classes. No single regex covers the suite

Questions it answers: *at what call depth does tool X lose the flow*, *does a static
field break it*, *can it tell an effective sanitizer from one that only looks
effective*. It does **not** answer *what is tool X's recall on real projects*: the
code here is generated, it does not aim at real-world representativeness and contains
no real CVE samples.

## Coverage matrix

412 cases (276 vulnerable / 136 safe), 85 of them line-by-line paired positives and
negatives.

| CWE | Class | Sink form | Cases | Vulnerable | Safe | Pairs |
|---|---|---|---:|---:|---:|---:|
| CWE-89 | SQL injection | JDBC string concatenation | 78 | 52 | 26 | 18 |
| CWE-89 | SQL injection | MyBatis XML `${}` | 59 | 41 | 18 | 8 |
| CWE-917 | Expression injection | SpEL evaluation | 85 | 54 | 31 | 17 |
| CWE-78 | Command injection | `Runtime.exec` / `ProcessBuilder` | 73 | 45 | 28 | 20 |
| CWE-918 | Server-side request forgery | URL fetch | 65 | 47 | 18 | 13 |
| CWE-22 | Path traversal | File read | 52 | 37 | 15 | 9 |
| | | **Total** | **412** | **276** | **136** | **85** |

Five CWEs, six sink forms. CWE-89 is deliberately split in two: for the JDBC cases
the dangerous line is in `.java`, for the MyBatis cases it is in **XML** — the Java
side contains no concatenation at all. The last hop of `path` is Java → XML, so a tool
that only reads `.java` scores zero recall on those 59 cases.

A pair is a positive and a negative case that are identical line by line except for
one sanitizer; pairs drive the discrimination metric.

## Scale and shape

| | Average | Max | Meaning |
|---|---:|---:|---|
| Files crossed | 7.4 | 15 | distinct files on the taint path |
| Call frames | 11.4 | 21 | method invocation frames traversed |
| Path nodes | 27.7 | 61 | propagation statements |
| Modules crossed | 2.4 | 3 | Maven modules (four in the build; paths run through web/service/dao) |

The ratio is **3.7 : 1.5 : 1** (statements : methods : files). The gradient is
deliberate: early versions had all three nearly equal — one statement per method per
file — which reads as generated at a glance.

The three quantities are geometrically locked: a file holds at least one method, a
method at least one statement, so **files ≤ frames ≤ nodes** always holds. High
cross-file spread and short chains are not simultaneously achievable.

Cases are stratified by call depth, so the detection-rate-versus-depth curve can be
plotted directly:

| Call depth | ≤7 | 8-10 | 11-13 | 14+ |
|---|---:|---:|---:|---:|
| Cases | 80 | 112 | 97 | 123 |

The project itself is Java 11 + Spring Boot 2.7, a four-module Maven build
(web → service → dao → common) with 3789 business classes and 59 MyBatis XML mappers.

## How to use it

```bash
mvn -DskipTests compile
```

Run that first if your tool needs compiled classes (source-only scanning works too).
Then:

1. Scan this directory with your SAST tool and export SARIF
2. Compare the report against `groundtruth/<case id>.json` — `sink` is the primary
   location; `source` and `path` show whether the tool really did dataflow analysis
3. Score at three levels (L1/L2/L3) plus pair discrimination — see "Scoring"

`manifest.json` lists every case with its scale metrics, ready for slicing.

## Ground truth format

Each `groundtruth/<id>.json`:

| Field | Meaning |
|---|---|
| `verdict` | `vulnerable` / `safe` |
| `cwe` | vulnerability class |
| `entry` | HTTP entry point (controller method) |
| `source` | taint entry location (`file` + 1-based `line`) |
| `sink` | dangerous call location |
| `sanitizer` | sanitizer location, `null` when there is none |
| `sanitizer_kind` | which sanitizer; `none` if absent. An effective one makes the case `safe`; an ineffective one (protection that can be bypassed) leaves it `vulnerable` |
| `path` | full source→sink propagation path, both ends included, in execution order; each node's `expr` is the tainted expression on that line |
| `metrics.call_depth` | **call chain length**: frames traversed (cross-checked at runtime) |
| `metrics.chain_len` | number of path nodes |
| `metrics.files_crossed` | distinct files on the path |
| `metrics.modules_crossed` | distinct Maven modules on the path |
| `metrics.features` | source / sink / propagation-operator tags for slicing |
| `paired_negative` | id of the paired negative case |
| `http` | PoC request: method, path, parameter/header/cookie name, carrier |
| `verification` | dynamic result: probe hit (`reached`), payload intact (`tainted`), neutralised by a safe idiom (`neutralized`), measured call depth (`call_depth_observed`) |
| `verification.control` | benign-payload positive control (safe cases only): an ordinary input that passes the sanitizer is sent a second time and the probe must fire — only that proves the chain is walkable, which is what makes the attack payload's absence attributable to the sanitizer |

`file` paths are relative to this directory with forward slashes; `line` is 1-based.

## Taint entry: 5 sources × 4 carriers

| Source | Carrier | How the value is read | Cases |
|---|---|---|---:|
| `servlet_header` | header | `HttpServletRequest.getHeader()` | 116 |
| `spring_path_variable` | path | `@PathVariable` | 101 |
| `spring_request_param` | query | `@RequestParam` | 94 |
| `spring_cookie_value` | cookie | `@CookieValue` | 53 |
| `spring_request_header` | header | `@RequestHeader` | 48 |

Headers are deliberately split in two: one carrier, one variant through the Servlet
API and one through Spring's annotation binding. Tools' source rules often cover only
one of them, and only splitting them makes that visible.

Header and cookie names are derived per case into business-looking names
(`X-Order-Trace`, `bundle_ref`) — never words like `payload`, which would print the
answer at the HTTP layer.

Cookie payloads are a **separate set**: RFC 6265 cookie values contain no spaces, so
Tomcat rejects a spaced payload with 400, and percent-encoding never reaches the sink
(Tomcat does not decode cookie values). Those cases use equivalent space-free forms —
`/**/` as whitespace for SQL (`zz'/**/OR/**/1=1--`), and SpEL's `+` needs no spaces
anyway. The attack semantics are unchanged.

## No repeated boilerplate

If every case's sink were the same character-for-character
`Runtime.getRuntime().exec(argv)`, one regex would score full marks on the whole
command-injection batch, measuring template recognition rather than analysis.

So each fragment has several **semantically equivalent but differently written**
versions, selected deterministically per case:

| Fragment | Equivalent spellings |
|---|---|
| String building (the step before SQL / command / path / URL / expression) | `+`, `String.format`, `StringBuilder.append`, `String.concat` |
| Command execution | `Runtime.getRuntime().exec(argv)`, `new ProcessBuilder(argv).start()`, `ProcessBuilder(List)` |
| File read | `Files.readAllBytes`, `Files.readAllLines`, `Files.newInputStream` |
| SQL execution | `Statement.executeQuery(sql)`, `Statement.execute(sql)`, two ways of obtaining the connection |
| SpEL evaluation | chained `parseExpression(t).getValue()`, extracting `Expression` first, anonymous parser |
| URL fetch | `openStream()`, `openConnection().getInputStream()`, via a `URLConnection` local |
| Local propagation | plain assignment, `final` assignment, `String.valueOf`, `new StringBuilder(v).toString()` |
| Collection propagation | `HashMap.get`, `LinkedHashMap.getOrDefault`, `ArrayList.add/get` |
| Character-stripping sanitizers | `replace`, `replaceAll`, ternary `contains ? replace : value`, replacement inside an `if` |
| Allowlist validation | static `Pattern` + `matcher().matches()`, `String.matches`, `Matcher` local |
| Value allowlist | `HashSet.contains`, `Collections.unmodifiableList`, `Arrays.asList(...).contains` |

Literals vary per case as well: table names, projections, WHERE columns, database
names, file roots, shell commands, URL paths, SpEL prefixes, exception types.

## Scoring

Recall alone is maxed out by tools that report every dangerous function they see. Use
at least three levels:

| Level | Criterion | Meaning |
|---|---|---|
| L1 | reported location hits `sink` (same file, ±2 lines) | primary: was the finding reported at all |
| L2 | both `source` and `sink` hit | were the two ends actually connected |
| L3 | coverage of `path` by the reported dataflow | was there end-to-end dataflow analysis |

When matching, pool the report's primary location with every location on its dataflow
path, and match file paths by suffix (tools usually emit absolute prefixes). Bucket the
capability profile by `metrics.call_depth` rather than by node count — interprocedural
depth limits are counted in call edges.

Add a **pair discrimination rate**:

```
DR = |positives detected AND their paired_negative not reported| / number of pairs
```

Paired cases are identical line by line except for one sanitizer, so DR exposes
pattern-matching tools immediately: they score 0%.
