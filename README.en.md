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
effective*. It does **not** answer *what is tool X's recall on real projects* — see
"Scope" at the end.

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
side contains no concatenation at all (see below).

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
| `sanitizer_kind` | which sanitizer (see table below); `none` if absent |
| `path` | full source→sink propagation path, both ends included, in execution order; each node's `expr` is the tainted expression on that line |
| `metrics.call_depth` | **call chain length**: frames traversed (cross-checked at runtime) |
| `metrics.chain_len` | number of path nodes |
| `metrics.files_crossed` | distinct files on the path |
| `metrics.modules_crossed` | distinct Maven modules on the path |
| `metrics.features` | source / sink / propagation-operator tags for slicing |
| `paired_negative` | id of the paired negative case |
| `http` | PoC request: method, path, parameter/header/cookie name, carrier |
| `verification` | dynamic result: probe hit (`reached`), payload intact (`tainted`), neutralised by a safe idiom (`neutralized`), measured call depth (`call_depth_observed`) |
| `verification.control` | benign-payload positive control (safe cases only), see below |

`file` paths are relative to this directory with forward slashes; `line` is 1-based.

## The ground truth is verified, not asserted

Most suites label by hand, and the labelled path may not even be reachable. Here a
probe sits in front of every sink (`common/.../AuditTrail.java`). Before release the
project is actually started, PoC requests are sent over the appropriate carrier
(query / path / header / cookie), and the outcome is checked:

* `vulnerable` — the probe must fire, and the payload must still be intact at the sink
* `safe` — the attack payload must **not** arrive intact, **and** a benign payload
  must walk the whole chain

What is verified is **reachability plus controllability**, not successful
exploitation: the probe sits before the real dangerous call, so a missing table in h2
or the absence of `/bin/sh` does not affect the conclusion.

### Safe cases also get a positive control

A safe verdict rests on an **absence** — "the attack payload did not arrive intact".
The trouble is that "the container rejected the request" and "the code died halfway"
satisfy that same criterion, and look identical (no probe record). A whole batch of
safe cases can therefore report success while nothing was ever exercised.

So every safe case receives a **second, benign request**: an ordinary input that
passes its sanitizer (`whitelist_regex` → `abc123`, `command_allowlist` → `status`,
`path_canonical_check` → `notes.txt`, `ssrf_host_allowlist` →
`api.internal.example`). On that round the probe **must** fire, with a measured call
depth matching the annotation. A hit proves the chain is walkable, which is what makes
the first round's miss attributable to the sanitizer. The result is stored in
`verification.control`.

**All 412 cases now carry positive runtime evidence**: 276 vulnerable cases hit the
probe, and all 136 safe cases had their benign payload walk the entire chain.

This check is not decorative: on the day it was introduced it exposed 73 safe cases
whose chain was not walkable at all — string concatenation along the path prefixed the
value, so a character allowlist or host allowlist further down rejected *every*
possible input, leaving those controllers dead for any request. Concatenation now uses
only allowlisted characters, and whole-value comparison guards may not sit downstream
of a value-rewriting operator; the generator rejects such combinations outright.

Ineffective sanitizers are visible directly — same payload `zz' OR 1=1--`:

| Case | SQL at the sink |
|---|---|
| no sanitizer | `... WHERE name = 'zz' OR 1=1--'` |
| single quotes stripped | `... WHERE name = 'zz OR 1=1--'` ← still injectable |
| character allowlist | never arrives (while benign `abc123` does) |

## Sanitizers: idiomatic fixes vs typical broken fixes

Safe cases are not "some filter function was added": each is written the way that
vulnerability class is idiomatically fixed — which is exactly what vendor rule sets
are tuned against. Alongside them are the broken fixes seen in the wild: they look
like protection but can be bypassed.

| Sanitizer | Applies to | Effective | Cases | Notes |
|---|---|:---:|---:|---|
| `whitelist_regex` | all | ✔ | 62 | character allowlist `^[A-Za-z0-9_]{1,64}$` |
| `sql_parameterized` | jdbc_concat | ✔ | 14 | `PreparedStatement` binding, the CWE-89 fix |
| `command_allowlist` | runtime_exec | ✔ | 9 | value must be in a fixed set |
| `exec_no_shell` | runtime_exec | ✔ | 9 | `ProcessBuilder` with an argv array, no shell |
| `path_canonical_check` | file_read | ✔ | 7 | prefix check after `normalize()`, the CWE-22 fix |
| `spel_restricted_context` | spel_eval | ✔ | 16 | `SimpleEvaluationContext`, no type references |
| `ssrf_host_allowlist` | url_fetch | ✔ | 10 | parse the host, then check the allowlist |
| `mybatis_parameterized` | mybatis_dollar | ✔ | 9 | `#{}` in XML: the value never enters SQL text |
| `incomplete_quote_strip` | jdbc / mybatis | ✘ | 17 | only quotes stripped; comments and keywords pass |
| `metachar_strip_semicolon` | runtime_exec | ✘ | 3 | only `;` removed; `$( )`, backticks, `\|`, `&&` pass |
| `traversal_replace_once` | file_read | ✘ | 9 | single `../` replacement; `....//` collapses back |
| `spel_strip_type_ref` | spel_eval | ✘ | 9 | single `T(` replacement; `TT((` collapses back |
| `ssrf_host_denylist` | url_fetch | ✘ | 13 | rejects the name `localhost`; `127.0.0.1` walks in |
| `none` | — | — | 225 | no sanitizer |

**Every bypass of the five broken fixes is dynamically confirmed**: the PoC payload
still reaches the sink intact. The four effective fixes that live at the sink itself
(parameter binding, no shell, restricted evaluation context, MyBatis `#{}`) are
recorded as `neutralized` — the taint did reach that API, it simply no longer carries
attack semantics. `verification.neutralized` distinguishes "never arrived" from
"arrived but was defused".

Sanitizer/sink pairings are enforced at generation time and `verdict` is derived
solely from whether the sanitizer is effective — no hand labelling. A meaningless
combination such as quote-stripping for path traversal is rejected outright.

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

## Taint flow across Java → XML

The MyBatis cases (`JAVA-MYBATIS-*`) differ from the rest: the Java side contains no
concatenation, and the dangerous line is not in `.java` at all.

```java
// service/…/CatalogGateway.java — the Java side just hands the value over
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
<!-- service/src/main/resources/…/CatalogMapper.xml — the taint enters SQL here -->
<select id="register" resultType="map">
  SELECT id, total
    FROM orders
   WHERE name = '${tariffRef}'
</select>
```

For these cases `sink` points at a **line in an XML file** and the last hop of `path`
is Java → XML. To report them a tool must understand the mapper interface, the
statement id in the XML, and the semantics of `${}`; a tool that only reads `.java`
scores zero recall here. The paired negative differs by a single character: `${}`
becomes `#{}`.

**Here `neutralized` is measured, not asserted**: the probe reads the final SQL
rendered from the XML just before the statement is issued and checks whether the
parameter value was inlined. `${}` splices the value into the statement, `#{}` leaves
a `?` placeholder — a conclusion invisible on the Java side.

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

## Engineering shape

Classes along the chain are wired in one of two ways, and a single chain may mix them:

* **Spring beans** — `@Service` / `@Component` / `@Repository` with constructor
  injection; the call site reads `this.xxx.method(v)` and never names the target
  class. The interface-dispatch tier injects a `Map<String, Strategy>` and picks an
  implementation by a constant bean name — the strategy-registry pattern real projects use
* **Static utility classes** — `public final class` with static methods; the call site
  names the target class

159 of the 412 cases are injected end to end; the rest are mixed, injected at the front
and static further down (a static method cannot obtain a bean, so injection only ever
appears as a prefix of the chain). 48% of business classes are beans. **Both styles
consume exactly the same number of call frames**, so `metrics.call_depth` matches the
runtime measurement either way.

Other things that make it read like a maintained project rather than a test suite: the
package is `com.northwind` (a fictional order platform) and the word "benchmark"
appears nowhere in the code; classes carry business Javadoc and about half have an
slf4j logger; half the controllers lift the common prefix into a class-level
`@RequestMapping` and half return `ResponseEntity`; comments in sanitizers give
business reasons only, never "this fix is ineffective".

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

## Scope

**In scope**: the analysis limits of a SAST tool — how deep it follows a chain, which
propagation carriers break it (instance fields, static fields, collection elements,
interface polymorphism, dependency injection, cross-module calls, Java→XML), whether it
distinguishes effective from ineffective sanitization, and whether it reports a full
dataflow or merely a pattern match at the sink.

**Out of scope**: how a tool performs on any real project. The code here is generated;
it does not aim at real-world representativeness and contains no real CVE samples.

So read results this way: "tool X loses the flow on cross-module static field
propagation" is supported; "tool X has Y% recall on real projects" is not a question
this suite can answer.

## Note

`AuditTrail.java`, `StatementAudit.java` and `MapperSessions.java` under
`common/src/main/java/com/northwind/platform/` are the verification probe and session
factory — test infrastructure, not part of the semantics under test. Ignore findings
reported inside those files.

They are deliberately not named `TaintOracle` / `reached()` / `neutralized()`: such
names would print the answer in front of every sink. Case ids never appear in the code
either — the probe derives its key from the call stack.

## License

MIT, see [LICENSE](LICENSE).
