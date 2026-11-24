# 📅 Day 25 (Mon 16 Nov): normal 2-hour plan is back

![Week](https://img.shields.io/badge/Week-4-blue) ![Day](https://img.shields.io/badge/Day-25-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h-green) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Both push days are done (12 Nov and 15 Nov), so the **normal plan returns**: Spring about 50 min, DSA about 35, buggy about 15, then the **evening redos** (cap 2). One item per track. Progress decides, not the calendar: Spring stays on Chapter 2, DSA moves to the next Stack problem only because every earlier one is ✅, and the 15-min buggy slot is the missing `DailyTemperatures` comments (`Day04LargestRectangle` width sentence closed 15 Nov night).

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first. In `spring-boot-labs` stay on `my-solutions`.
>
> State at 6 AM on tip `c54a877`: no student commits after `1ded3b3` (labs `my-solutions`, 15 Nov 8:35 AM IST) and `d6ca103` (this repo, 12 Nov). Last verified: labs `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **3/19** (Task 1). New stubs in this repo are red by design: `GenerateParenthesesTest` 0/17, `ScoreOfParenthesesRedoNov16Test` 0/37, `RemoveKAdjacentDuplicatesRedoNov16Test` 0/26.

## 🌅 Morning

### ⏱️ Time plan (120 min morning + evening redos)

| Minutes | Track | Item | Done when |
|---|---|---|---|
| 0-3 | 🌱 | `git pull` both repos. Say the **scopes grid** from memory in chat (1 min) | grid right first try → scopes ✅ Strong |
| 3-55 | 🌱 | **Chapter 2 Task 2 and Task 3** (`GET /accounts`, `GET /accounts/{number}/masked`) | `task2a`, `task2b`, `task3a`, `task3b` green on pushed `my-solutions` → Chapter 2 **7/19** |
| 55-90 | 🧩 | **Generate Parentheses** (new Stack problem) | pseudocode first, then `GenerateParenthesesTest` **17/17** pushed |
| 90-105 | 🐞 | **`DailyTemperatures` comments**: add brute-force + 3-5 lines of pseudocode on the existing file | comment-only push |
| 105-120 | — | Push, buffer, hint requests | nothing left unpushed |
| Evening (cap 2) | 🔁 | `ScoreOfParentheses` then `RemoveKAdjacentDuplicates`, cold, 20-30 min each | see the redo table below |

> [!TIP]
> Stuck 15 minutes on any step? Ask for a hint. Push after each item, even if red.

### 🌱 1. Chapter 2, Tasks 2 and 3 (~50 min)

Where: [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs), branch `my-solutions`, file `chapters/02-first-spring-boot-app/src/main/java/ledgerly/AccountController.java`. The stubs and the `// Task N` comments are already there, so nothing new is added to that repo. Tests: `mvn -pl chapters/02-first-spring-boot-app test`.

#### 1️⃣ Why it matters
Every client (branch app, mobile app, partner gateway) asks the same backend. Task 2 returns data as JSON, Task 3 reads a value out of the URL. Between them they cover the first two things a retail-banking API does all day: return a list, return something for one id. They also bring back the 🔴 HTTP-semantics weak topic (`@PathVariable`, status, body).

#### 2️⃣ What Spring gives you, and what you add

| Need | Spring already does | You write |
|---|---|---|
| Task 2: `List<Account>` as the answer | status, JSON writing, `Content-Type` | the URL mapping and the return |
| Task 3: `{number}` from the path | reads it from the path, converts to the parameter type | the mapping, the binding and the masking |
| Wrong path / wrong method | 404 / 405 with the standard body | nothing (Task 1 showed this) |

> [!WARNING]
> **Before any code, write one line each:** (a) *what does Spring already give a `List` return: status code, body format?* (b) *what ties `{number}` in the URL to the Java parameter?* If you can't answer (b), read the "Path variables" part of the chapter README first.

#### 3️⃣ Task 2: list the accounts
`GET /accounts` → `200`, a JSON list of the four accounts in `ACCOUNTS` order, each as `{"number":...,"holder":...,"balance":...}`. Do **not** edit `ACCOUNTS`.

#### 4️⃣ Task 3: mask the number
`GET /accounts/{number}/masked` → plain text: six stars + the **last four characters** of the number. `1000234567` → `******4567`. Keep `number` a `String`; check what `0000123456` should give before you pick a type.

#### 5️⃣ Plan before code (3-5 lines, plain English)
For each task write: URL + method → what comes in → what goes out → what Spring handles. Then code.

#### 6️⃣ Expected result
`task2a_list`, `task2b_orderAndFields`, `task3a_masked`, `task3b_leadingZeros` green. Then run the app and call both URLs with `curl -i`:

```bash
mvn -pl chapters/02-first-spring-boot-app spring-boot:run
curl -i localhost:8081/accounts
curl -i localhost:8081/accounts/1000234567/masked
curl -i -X POST localhost:8081/accounts          # predict the status first
```

#### 7️⃣ 🎒 HTTP-semantics mini pack (weak topic, 20 min inside the slot)

| Part | Item |
|---|---|
| 1. Note | Status by who decided: `404` no handler · `405` handler exists, wrong method · `400` value can't convert · `500` your code threw. One line each: which one is the client's fault, which is yours? |
| 2. Question (chat) | `GET /accounts/abc/masked` and `GET /accounts/masked`: what does each return, and why are they different? |
| 3. Implementation | Tasks 2 and 3 above |
| 4. Debugging (chat, 10 min) | The snippet below compiles and the app starts. `GET /branches/blr01` returns a `500`. Say what the log will show and what you'd change. |
| 5. Interview scenario (chat, 5 min) | A partner says "your `/accounts` returns 200 with `[]` for a customer who has accounts". Name three places you'd look, in order. |

```java
@GetMapping("/branches/{code}")
String branch(@PathVariable String id) {
  return "Branch " + id.toUpperCase();
}
```

#### 8️⃣ Knowledge check
1. `GET /accounts` returns a `List<Account>`. What turns it into JSON, and what `Content-Type` does the client see? (A) your method builds the string (B) Spring's message converter picks JSON from the return type (C) the browser converts it (D) `text/plain`
2. `{number}` and the Java parameter are `number`. Rename one only: what happens, a compile error, a 400, a 404 or a 500?
3. Why is `String` the right type for the masked number even though it is digits?

### 🧩 2. DSA: Generate Parentheses (~35 min)

![Type](https://img.shields.io/badge/type-DSA%20Stack-blue) ![Tests](https://img.shields.io/badge/GenerateParenthesesTest-17-lightgrey) ![Stub](https://img.shields.io/badge/stub-0%2F17-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/stack/GenerateParentheses.java` · tests `GenerateParenthesesTest` (17). ✅ Done when all 17 pass on your pushed code, with **3-5 lines of pseudocode and a brute-force comment before any Java**, plus pattern / time / space lines that each say where the cost comes from. (Next Stack problem because Valid Parentheses, Min Stack, Daily Temperatures and Car Fleet are ✅; Evaluate RPN and Largest Rectangle were done as buggy rounds.)

#### 1️⃣ Why it matters
It tests whether you turn a validity rule into counters that **prune** a branch before it exists. At lead level the follow-ups are about how many strings come out and why the cost isn't 2^(2n).

#### 2️⃣ The variants

| Approach | Idea | Cost (you fill in the reasons) |
|---|---|---|
| Brute force | Build all strings of `(` and `)` of length 2n, keep the balanced ones | ? |
| Pruned backtracking | Add a character only while it can still lead to a valid string | ? |

#### 3️⃣ Worked example
`n = 3` → `["((()))", "(()())", "(())()", "()(())", "()()()"]` (any order). `n = 1` → `["()"]`.

#### 4️⃣ Approach (brute force only, write this first)
Write 3-5 plain-English lines: generate every string, test each with the Valid Parentheses idea, keep the good ones. Then answer in a comment: *how many strings does that build for n = 3?*

#### 5️⃣ Rules the suite enforces
- `n < 1` → `IllegalArgumentException`.
- Every string has length `2n`, is balanced, appears exactly once; counts for n = 1..8 are 1, 2, 5, 14, 42, 132, 429, 1430.
- Order doesn't matter (the tests sort).
- n = 10 and n = 12 are timed: pruning is required.

#### 6️⃣ Java stub
Already in the repo (`throw new UnsupportedOperationException("TODO")`), signature `List<String> generateParenthesis(int n)`.

#### 7️⃣ Complexity
Brute force: state it yourself in the comment. For your final version, state time and space after your attempt, with one sentence on where each cost comes from (what is the output size, and what extra space does the recursion depth need?).

#### 8️⃣ Interview follow-ups
1. At a given moment, when can you add `(`? When can you add `)`? Say each rule as one condition.
2. How many results for n = 4, and why can't the time be better than that count?
3. Where is the "stack" in your solution?

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Idea.** Build the string left to right and track `open` and `close` counts. Add `(` while `open < n`. Add `)` only while `close < open` (there is an unmatched `(` to close). When the length reaches `2n`, record it. Undo the last character after each branch.

**Dry run, n = 2** (state is `string, open, close`):

| Step | State | Action |
|---|---|---|
| 1 | `"", 0, 0` | only `(` allowed |
| 2 | `"(", 1, 0` | `(` or `)` allowed |
| 3 | `"((", 2, 0` | `open == n`, only `)` |
| 4 | `"(()", 2, 1` → `"(())", 2, 2` | length 4 → record `(())` |
| 5 | back at `"(", 1, 0` → `")"` → `"()", 1, 1` | `(` allowed |
| 6 | `"()(", 2, 1` → `"()()", 2, 2` | record `()()` |

**Cost.** Time and output are both about the Catalan number C(n) times 2n characters (roughly 4^n / n^(1/2) strings); pruning stops a branch the moment it can no longer become valid. Space: recursion depth 2n plus the output.

**Answers.** (1) `(` while `open < n`; `)` while `close < open`. (2) 14; every result must be written out, so time ≥ output size. (3) The recursion call stack holds the current prefix, and the `StringBuilder` push/pop of one character per level is the stack behaviour.

</details>

- [ ] 3-5 lines of plain-English pseudocode **and** a brute-force comment before any Java.
- [ ] Pattern / time / space comment lines with reason sentences.
- [ ] `mvn test -Dtest=GenerateParenthesesTest` → **17/17**. Push.

### 🐞 3. Buggy slot: `DailyTemperatures` comments (15 min)

> [!NOTE]
> `Day04LargestRectangle` empty-stack width is ✅ **closed** (15 Nov night, ~10:00-10:27 PM IST). Sentence **8/10** after a correction; buggy score stays **7**. Height must come from the popped bar, not the current one ([mistakes/dsa.md](../../revision/mistakes/dsa.md)). No new buggy round today.

The 15 minutes go to a pending comment-only follow-up. `DailyTemperatures` code is already ✅ 18/18 (`d6ca103`). Open the existing file and, **above the Java**, add:

- a short brute-force comment (what a re-scan / naive pass would do)
- 3-5 lines of plain-English pseudocode

📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java`

- [x] LargestRect sentence + ASCII (closed 15 Nov night)
- [ ] Brute-force + 3-5 pseudocode lines added; push (comments only is enough)

> [!TIP]
> This is the same write-first habit as Generate Parentheses this morning. Optional if time is left: the three symptom groups for `Day00BuggyExample` (still absent).

### 🔁 Evening redos (cap 2, most overdue first, 20-30 min each, cold)

| Redo | File (blank stub) | Tests | Gap | Why now |
|---|---|---|---|---|
| 🧩 `ScoreOfParentheses` | `src/main/java/com/prashant/dailytests/redo/ScoreOfParenthesesRedoNov16.java` | `mvn test -Dtest=ScoreOfParenthesesRedoNov16Test` (0/37) | +1, due 26 Oct | most overdue (first redo ever) |
| 🧩 `RemoveKAdjacentDuplicates` | `src/main/java/com/prashant/dailytests/redo/RemoveKAdjacentDuplicatesRedoNov16.java` | `mvn test -Dtest=RemoveKAdjacentDuplicatesRedoNov16Test` (0/26) | +1 (reset), due 30 Oct | conceptual miss on the O(n) quiz |

- [ ] Cold: do **not** open `dsa/stack/ScoreOfParentheses` or `dsa/stack/RemoveKAdjacentDuplicates`.
- [ ] Each starts with a **pattern line + time and space comments** (one sentence each saying where the cost comes from), then 3-5 lines of pseudocode, then code. 25-minute timer.
- [x] Push at the end of each, even if red. (`d94f802`, 4:29 PM IST; but see the afternoon check: not cold)

### 📦 Carried backlog (not for today)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) still open | 🧩 | 🟡 IN_PROGRESS |
| 2 | B2 interview Q3 and Q6, plus "why the catch-all hid Spring's own answers" | 🌱 | ⬜ NOT_STARTED |
| 3 | Banking module 1 step 1, Drills 2 and 3 (parked; Spring slot is `spring-boot-labs`) | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 4 | `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED (comes with the redo) |
| 5 | Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| 6 | ~~`DailyTemperatures` pseudocode / brute-force comments~~ | 🧩🐞 | 🟡 IN_PROGRESS — moved to this morning's 15-min buggy slot above |
| 7 | Chapter 2 Tasks 4-6 (Task 6 carries the Chapter 2 interview question) | 🌱 | ⬜ NOT_STARTED (after Tasks 2-3) |

- [x] Scopes grid recalled in chat (~9:05 PM IST, 10/10)
- [x] Chapter 2 Tasks 2 and 3 pushed on `my-solutions` (`8f48e9b`, **7/19**, graded 8/10 below)
- [ ] `GenerateParentheses` pseudocode + code pushed
- [x] LargestRect sentence + ASCII (closed 15 Nov night)
- [ ] `DailyTemperatures` brute-force + pseudocode comments pushed

## 🕓 Afternoon check (16 Nov, ~4:35 PM IST): `8f48e9b` + `d94f802`

> [!IMPORTANT]
> Two pushes landed: labs `my-solutions` `8f48e9b` "completed chapter2- task 2 & 3" (4:30 PM IST, 1 file) and this repo `d94f802` "RemoveKAdjacentDuplicatesRedoNov16, ScoreOfParenthesesRedoNov16 completed" (4:29 PM IST, 2 files). Both verified on fresh clones. `GenerateParentheses.java` and `DailyTemperatures.java` were **not** touched (still 0/17 and comments missing).

| Item | Tests | Grade | Why |
|---|---|---|---|
| 🌱 Ch 2 Task 2 `GET /accounts` + Task 3 `GET /accounts/{number}/masked` | `Chapter02CheckTest` **7/19** (was 3/19): task1a-c, task2a, task2b, task3a, task3b ✅ | **8/10** | Target hit. No extra handlers, Spring writes the JSON and the 200; `{number}` stays a String so `0000123456` keeps its zeros. Minus 2: a premature, wrong Task 4 mapping and small formatting slips |
| 🔁 `ScoreOfParenthesesRedoNov16` | **37/37** | **2/10** (🔶, not cold) | The method body is character-for-character the original `dsa/stack/ScoreOfParentheses` (same comments, e.g. `// Base score for the current level`). Complexity lines have no "why"; no pseudocode |
| 🔁 `RemoveKAdjacentDuplicatesRedoNov16` | **26/26** | **2/10** (🔶, not cold) | Method body + `Pair` class identical to the original, and the file even imports `com.prashant.dsa.stack.RemoveKAdjacentDuplicates` (unused). The O(n) "why" (the 29 Oct conceptual miss) is still not written; no pseudocode |

### 🌱 Code feedback, `AccountController.java`
- ✅ `@GetMapping("/accounts")` + `return ACCOUNTS;`: right. `List.of` is immutable, so returning it directly is safe.
- ✅ `@GetMapping("/accounts/{number}/masked")` + `@PathVariable("number") String number`: right. The explicit `"number"` is optional here (Boot compiles with `-parameters`), harmless.
- 🟡 `lastFour` helper: fine and defensive (`length() <= 4` returns the whole string). Nothing in the tests needed it; a one-liner `"******" + number.substring(number.length() - 4)` was enough. Also add a blank line between `masked` and the helper.
- 🔴 Task 4: `@GetMapping("/accounts/above?balance=N")`. A query string is **not** part of a path pattern: Spring matches only the path `/accounts/above`, and in a pattern `?` means "any one character". So this mapping never matches `/accounts/above?balance=10000` (task4a-d still 404). For Task 4: `@GetMapping("/accounts/above")` + `@RequestParam int balance`. Don't add a mapping before the task is done.
- 🟡 Style: `@GetMapping ("/accounts")` has a stray space; `return ACCOUNTS;` is indented 5 spaces.
- No 404 handling needed: the README asks only to mask the path value, not to look the account up.

### 🔁 Redo grading and next dates
Both pass every test, but neither was cold: the code is the original solution copied in. Rule 3 in [redo-schedule.md](../../revision/redo-schedule.md): passed after re-reading the original = 🔶, **repeat the same gap (+1)**. Counted from today, due Tue 17 Nov; the cap of 2 (17-21 Nov are already full with older items) queues them on **Sun 22 Nov** as `RemoveKAdjacentDuplicatesRedoNov22` then `ScoreOfParenthesesRedoNov22`, blank files. Before any code: pattern line, time **and the reason**, space **and the reason**, then 3-5 pseudocode lines. For RemoveK the reason sentence is the point: each character is pushed once and popped at most once, so the total work is O(n) even with the inner removals.

### ⏳ Still open today
- [ ] Scopes grid from memory in chat (warm-up, not done)
- [ ] `GenerateParentheses` pseudocode + code → 17/17 (0/17)
- [ ] `DailyTemperatures` brute-force + pseudocode comments


## 🌙 Evening (16 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-8%2F10-yellowgreen) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Evening review at ~8:00 PM IST on tip `4b1d6a3` (this repo) and `828c168` (labs `my-solutions`). No student commits after the afternoon check: the last student pushes are still `8f48e9b` (labs, 4:30 PM IST) and `d94f802` (this repo, 4:29 PM IST). **Re-verified tonight** on fresh clones (JDK 21, Maven): labs `Chapter02CheckTest` **7/19** (task1a-c, task2a-b, task3a-b green; 12 red = Tasks 4-6), `ScoreOfParenthesesRedoNov16Test` **37/37**, `RemoveKAdjacentDuplicatesRedoNov16Test` **26/26**, `GenerateParenthesesTest` **0/17** (stub untouched). The afternoon grades stand and are **not counted twice**. The redo ladder was already updated by `4b1d6a3`, so [redo-schedule.md](../../revision/redo-schedule.md) has no change tonight. Cosmetic fix: the unused `import com.prashant.dsa.stack.RemoveKAdjacentDuplicates;` was removed from `RemoveKAdjacentDuplicatesRedoNov16` (not logged). One new conceptual entry in [mistakes/spring.md](../../revision/mistakes/spring.md): query string written into a path pattern.

### 📝 Scores (rubric in [PROGRAM.md](../../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **8/10** (concept 7 · implementation 9 · problem solving 8 · debugging n/a · complexity n/a · interview readiness 7) | Tasks 2-3 exact (`8f48e9b`, 7/19, target hit): `List` returned and left to Spring for JSON and 200, `{number}` kept a `String` so leading zeros survive, no extra handler for the second time running. Concept drops to 7 for the premature Task 4 line `@GetMapping("/accounts/above?balance=N")`: a query string is not part of a path pattern. Interview readiness 7: the 1-minute scopes recall was skipped again |
| 🧩 DSA | **unscored** (no independent work) | `GenerateParentheses` untouched (0/17). The two redos pass (37/37, 26/26) but each body is the original solution copied in, with no complexity reasons and no pseudocode; graded **2/10** each as redo items this afternoon. Copied code says nothing about recall, so it is not enough evidence for a track score. Last DSA score stays **8** (12 Nov) |
| 🐞 Buggy | **unscored** (no work) | The 15-min slot (`DailyTemperatures` brute-force + pseudocode comments) was not pushed. Last buggy score stays **7** |

> [!WARNING]
> **About the redos, plainly:** a redo only works if it is done from memory. Copying the original makes the tests green but trains nothing, and the ladder treats it as a 🔶 repeat, so the same two problems come back on Sun 22 Nov. If memory runs out, write what you remember, push it red, and ask for a hint. A red honest attempt is worth more than a green copy.

> [!TIP]
> The Spring work was good: two endpoints in one go, and you trusted Spring's defaults without being reminded. Keep that, and add the one habit that slipped today: **read the task line as a URL, not as text to paste** (see the weak-topic pack below).

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 Return a list as JSON (`GET /accounts`) | ✅ Strong | task2a-b green first push, no extra code |
| 🌱 `@PathVariable` binding as `String` (`/accounts/{number}/masked`) | ✅ Strong | task3a-b green; chose `String` for leading zeros |
| 🌱 `@RequestParam` / query string vs path pattern | 🔴 Weak | wrote `?balance=N` into `@GetMapping`; carries the old 🔴 `@PathVariable` / `@RequestParam` row (Day 02 Q1 5/10). Pack below |
| 🌱 HTTP semantics (idempotency, PUT vs PATCH, status codes) | 🔴 Weak (carried) | no new evidence today (Day 02 Q3, Day 03 Q1 5/10). Short pack below |
| 🌱 `ResponseEntity` vs `@ResponseStatus`, `Location` header | 🔴 Weak (carried) | no new evidence today (Day 03 Q2 5/10). Short pack below |
| 🌱 Trusting Spring defaults (no extra handlers) | ✅ Strong | second day in a row (15 Nov Task 1, 16 Nov Tasks 2-3) |
| 🌱 Maven scopes grid | 🟡 Moderate | recall retry still not done |
| 🌱 labs Chapter 2 Tasks 4-6 | ⬜ Pending | not started (Task 4 has a wrong mapping line only) |
| 🧩 Cold recall: `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` | ⬜ Pending | no evidence: copied, re-queued Sun 22 Nov |
| 🧩 Amortised O(n) reasoning | 🟡 Moderate | answered in chat 5 Nov, but both redo files today say `O(n)` with no reason; the RemoveK "why" is still unwritten |
| 🧩 `GenerateParentheses` (backtracking with open/close counts) | ⬜ Pending | 0/17, not started |
| 🐞 `DailyTemperatures` brute-force + pseudocode comments | ⬜ Pending | not pushed |
| ⛔ Blocked | none | nothing outside your control is stopping the work |

### 🔴 Weak-topic pack 1: `@RequestParam` vs the path pattern (main pack)

**Why it matters.** Every search or filter endpoint in a bank (`/accounts/above?balance=`, `/transactions?from=&to=`) reads the query string. If the mapping is wrong, the endpoint is a silent 404 and nobody notices until a client calls it.

**The concept in two sentences.** `@GetMapping` matches only the **path** (`/accounts/above`); everything after `?` is the query string, and Spring hands each piece to a `@RequestParam` parameter. Inside a path pattern `?` is a wildcard for **one character**, so `?balance=N` is read as part of the path, not as a parameter.

**Small example** (the 4 accounts in `AccountController`, request `GET /accounts/above?balance=10000`):

```diff
- @GetMapping("/accounts/above?balance=N")      // path must literally be "/accounts/above" + 1 char + "balance=N"
- List<Account> above(int balance)               // never matched -> 404
+ @GetMapping("/accounts/above")                 // path only
+ List<Account> above(@RequestParam int balance) // ?balance=10000 -> 10000
```

| Request | Wrong mapping | Right mapping |
|---|---|---|
| `/accounts/above?balance=10000` | 404 (path `/accounts/above` doesn't match the pattern) | 200, Asha Rao + Neha Iyer |
| `/accounts/above?balance=lots` | 404 | 400 (`int` conversion fails, Spring answers) |
| `/accounts/above` (no balance) | 404 | 400 (a plain `@RequestParam` is required) |

> [!WARNING]
> **Gotchas.** ① The task comment shows the **URL a client calls**, not the text for the annotation. ② `@RequestParam` is required by default; optional needs `required = false` or `defaultValue = "false"` (Task 5's `express`). ③ A primitive `int`/`boolean` cannot be `null`, so an optional primitive without `defaultValue` fails when it is missing. ④ Don't add a mapping before the task is done: a half-written line is easy to forget.

- ❓ **Conceptual question.** In `GET /accounts/1000234567/masked?format=short`, which part does `@GetMapping` match, which part binds to `@PathVariable`, and which to `@RequestParam`? Then: why is a missing required param a 400 and not a 404?
- 🛠️ **Implementation exercise.** This is your next labs task, not new material: Chapter 2 Task 4. Write one line first, "the path is ___, the param is ___ as ___", then fix the mapping and make task4a-d green.
- 🐞 **Debugging exercise.** A teammate adds `@GetMapping("/accounts/{number}")` next to `@GetMapping("/accounts/above")`. A client calls `/accounts/above?balance=5`. Which method runs, and why? What would change if the second mapping didn't exist? (Hint: more specific patterns win over `{variable}`.)
- 🎤 **Interview scenario.** "Our transaction search endpoint `GET /transactions?from=&to=&status=` returns 400 for some mobile clients and 200 for others. Walk me through how Spring binds those params, which errors come from Spring itself, and how you'd make `status` optional with a safe default."

### 🔴 Weak-topic pack 2: HTTP semantics (carried, short)

**Why it matters.** A payment retried by a flaky network must not move money twice; that depends on which methods are idempotent. **Concept:** idempotent means "doing it twice leaves the server in the same state as doing it once": GET, PUT and DELETE are idempotent, POST is not, PATCH is not guaranteed. **Example:** `DELETE /beneficiaries/7` twice → first 204, second 404 (or 204); either way beneficiary 7 is gone once, so it is still idempotent. **Gotcha:** idempotent is about server state, not about returning the same status code.

- ❓ Is `PATCH /accounts/1 {"balance": +100}` idempotent? What about `PUT /accounts/1 {"balance": 600}`? One sentence each.
- 🛠️ For the five Chapter 2 endpoints, write the method, status on success and status for "not found" in a 3-column table (comment in your notes, no code).
- 🐞 A `POST /transfers` retried after a timeout created two transfers. Name the HTTP reason and one fix (idempotency key).
- 🎤 "The client retries every request after 5 seconds. Which of our endpoints are safe to retry, and what do you add to the ones that aren't?"

### 🔴 Weak-topic pack 3: `ResponseEntity` vs `@ResponseStatus`, `Location` (carried, short)

**Why it matters.** A `POST /accounts` should answer **201 Created** and say where the new account lives, so the client doesn't have to guess the URL. **Concept:** `@ResponseStatus(CREATED)` fixes one status for every call; `ResponseEntity` lets the method choose status, headers and body per call. **Example:** `ResponseEntity.created(URI.create("/accounts/1000234567")).body(account)` → `201`, header `Location: /accounts/1000234567`, the account as JSON. **Gotcha:** `@ResponseStatus` can't add a `Location` header that depends on the new id.

- ❓ When is `@ResponseStatus` enough, and when do you need `ResponseEntity`? One example each.
- 🛠️ Write (in notes) the `return` line for "create account → 201 + Location".
- 🐞 A controller returns `ResponseEntity.ok(null)` when an account is missing. What does the client see, and what should it be?
- 🎤 "Why return 201 with a `Location` header instead of 200 with the body?"

### ⏳ Tonight's evening-slot work (pending from this morning)

No new material tonight. The two redos for today are done (🔶, re-queued Sun 22 Nov), so the cap of 2 is used and no other redo runs tonight.

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 1 | Scopes grid from memory in chat (`compile` / `provided` / `runtime` / `test` × compile cp / test cp / jar) | 🌱 | grid right first try → scopes ✅ Strong |
| 2 | 35 | `GenerateParentheses`: 3-5 lines of plain-English pseudocode + brute-force comment first, then code | 🧩 | `GenerateParenthesesTest` **17/17** pushed (or pushed red with a hint request after 15 min) |
| 3 | 15 | `DailyTemperatures` brute-force + 3-5 pseudocode comment lines | 🐞 | comment-only push |

- [ ] Scopes grid recalled in chat
- [ ] `GenerateParentheses` pseudocode + code pushed
- [ ] `DailyTemperatures` comments pushed

### 🎯 Tomorrow's focus (Tue 17 Nov)

| Track | Focus | Why (from tonight's assessment) |
|---|---|---|
| 🌱 Spring | Chapter 2 **Task 4** (`GET /accounts/above`, `@RequestParam int balance`): fix the wrong mapping line first, after one line "path is ___, param is ___". Then Task 5 (`/fee`, optional `express`) if time is left. Scopes recall first if not done tonight | the one concept miss today is query param vs path; Task 4 is the natural test of pack 1 |
| 🧩 DSA | `GenerateParentheses` to 17/17 if not done tonight, pseudocode first; nothing new until it is ✅ | progress decides: still 🟡 |
| 🐞 Buggy | `DailyTemperatures` comments if not done tonight; no new round until it lands | open since 12 Nov |
| 🔁 Redos (evening) | `Day03NextGreaterIndex` (+1, late) + `AsteroidCollision` (+1, late), **cold on blank files**. Don't open `dailytests/Day03...` or `dsa/stack/AsteroidCollision`; write pattern, time + reason, space + reason, pseudocode, then code | from [redo-schedule.md](../../revision/redo-schedule.md); after today's copies, a cold honest attempt (even red) is the priority |

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Pushes](https://img.shields.io/badge/student%20pushes%20today-2-brightgreen) ![Scopes](https://img.shields.io/badge/scopes%20grid-10%2F10-brightgreen)

> [!NOTE]
> 10 PM check on tip `cab0978`. No student commits after the 8 PM evening review: `spring-boot-labs` `my-solutions` is still `8f48e9b` / `828c168` (merge) and this repo's last student code is `d94f802`, so no suite changed and no tests needed re-running (labs `Chapter02CheckTest` **7/19**, `GenerateParenthesesTest` 0/17). One chat answer landed ~9:05 PM IST: the Maven scopes grid from memory, all 12 cells right (**10/10**, yesterday's `provided`/`runtime` swap fixed). The follow-up MCQ (a WAR on an external Tomcat with the servlet API left at `compile`) was answered C; the answer is B, duplicate servlet-api copies can clash. Logged in [mistakes/spring.md](../../revision/mistakes/spring.md). Redo ladder unchanged.

| Item | Track | Outcome | Status |
|---|---|---|---|
| Chapter 2 Tasks 2-3 | 🌱 | `8f48e9b`, 7/19, **8/10** | ✅ COMPLETED |
| Scopes grid recall | 🌱 | chat ~9:05 PM IST, 12/12 cells, **10/10**; WAR MCQ ❌ (C, answer B) | ✅ COMPLETED (grid); WAR `provided` case logged |
| Chapter 2 Task 4 (`/accounts/above`) | 🌱 | wrong premature mapping still in place (task4a-d 404) | ⬜ NOT_STARTED |
| `GenerateParentheses` | 🧩 | untouched, 0/17 | 🟡 IN_PROGRESS |
| `DailyTemperatures` comments | 🐞 | not pushed | 🟡 IN_PROGRESS |
| 🔁 `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` | 🔁 | 37/37 and 26/26 but copied, 2/10 each | 🟡 IN_PROGRESS (re-queued Sun 22 Nov, blank files) |

> [!IMPORTANT]
> **First task tomorrow (Tue 17 Nov, 6 AM):** `git pull` both repos, then labs Chapter 2 **Task 4** on `my-solutions`. Before any code write one line: "the path is ___, the param is ___ as ___". Then change `@GetMapping("/accounts/above?balance=N")` to a path-only mapping with `@RequestParam int balance`. ✅ Done when `task4a`-`task4d` are green on the pushed branch (Chapter 2 **11/19**). Next: `GenerateParentheses` with 3-5 lines of pseudocode first (DSA slot), then the `DailyTemperatures` comments (buggy slot). Evening redos: `Day03NextGreaterIndex` + `AsteroidCollision`, cold on blank files. Ask for a hint after 15 minutes on any step.
