# 📅 Day 25 (Mon 16 Nov): normal 2-hour plan is back

![Week](https://img.shields.io/badge/Week-4-blue) ![Day](https://img.shields.io/badge/Day-25-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h-green) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Both push days are done (12 Nov and 15 Nov), so the **normal plan returns**: Spring about 50 min, DSA about 35, buggy about 15, then the **evening redos** (cap 2). One item per track. Progress decides, not the calendar: Spring stays on Chapter 2, DSA moves to the next Stack problem only because every earlier one is ✅, and Buggy finishes its open sentence before any new round.

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
| 90-105 | 🐞 | **`Day04LargestRectangle` empty-stack width**: one sentence + 3-line ASCII (chat) | graded 7+ → a new buggy round may start |
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

### 🐞 3. Buggy: `Day04LargestRectangle` empty-stack width (15 min, in chat)

No new buggy round: this one is still open (see [day20.md](day20.md#-day04largestrectangle-empty-stack-width-optional-chat)). Code is ✅ 36/36; the geometry sentence is the gap.

- [ ] One sentence: when you pop a bar, which index is its **left** limit and which its **right** limit, and therefore why is the width `i` when the stack is empty and `i - stack.peek() - 1` otherwise?
- [ ] A 3-line ASCII of `[2, 1, 2]` marking the left and right limits for the bar of height `1`.

> [!CAUTION]
> Graded 7+ → the next Stack buggy round is assigned. Below 7 → one more short round on this sentence. Optional if time is left: write the three symptom groups for `Day00BuggyExample` (still absent).

### 🔁 Evening redos (cap 2, most overdue first, 20-30 min each, cold)

| Redo | File (blank stub) | Tests | Gap | Why now |
|---|---|---|---|---|
| 🧩 `ScoreOfParentheses` | `src/main/java/com/prashant/dailytests/redo/ScoreOfParenthesesRedoNov16.java` | `mvn test -Dtest=ScoreOfParenthesesRedoNov16Test` (0/37) | +1, due 26 Oct | most overdue (first redo ever) |
| 🧩 `RemoveKAdjacentDuplicates` | `src/main/java/com/prashant/dailytests/redo/RemoveKAdjacentDuplicatesRedoNov16.java` | `mvn test -Dtest=RemoveKAdjacentDuplicatesRedoNov16Test` (0/26) | +1 (reset), due 30 Oct | conceptual miss on the O(n) quiz |

- [ ] Cold: do **not** open `dsa/stack/ScoreOfParentheses` or `dsa/stack/RemoveKAdjacentDuplicates`.
- [ ] Each starts with a **pattern line + time and space comments** (one sentence each saying where the cost comes from), then 3-5 lines of pseudocode, then code. 25-minute timer.
- [ ] Push at the end of each, even if red.

### 📦 Carried backlog (not for today)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) still open | 🧩 | 🟡 IN_PROGRESS |
| 2 | B2 interview Q3 and Q6, plus "why the catch-all hid Spring's own answers" | 🌱 | ⬜ NOT_STARTED |
| 3 | Banking module 1 step 1, Drills 2 and 3 (parked; Spring slot is `spring-boot-labs`) | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 4 | `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED (comes with the redo) |
| 5 | Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| 6 | `DailyTemperatures` pseudocode / brute-force comments | 🧩 | 🟡 IN_PROGRESS (this morning's DSA item is the place to show the habit) |
| 7 | Chapter 2 Tasks 4-6 (Task 6 carries the Chapter 2 interview question) | 🌱 | ⬜ NOT_STARTED (after Tasks 2-3) |

- [ ] Scopes grid recalled in chat
- [ ] Chapter 2 Tasks 2 and 3 pushed on `my-solutions`
- [ ] `GenerateParentheses` pseudocode + code pushed
- [ ] LargestRect sentence + ASCII answered in chat
