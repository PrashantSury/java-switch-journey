# 📅 Day 14 (Thu 5 Nov): carried work only, one push per item

![Week](https://img.shields.io/badge/Week-2-blue) ![Day](https://img.shields.io/badge/Day-14-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Progress decides the work, not the calendar. There was no push after `80d98f1` (3 Nov, 23:15 IST), so every item of [day13.md](day13.md) is still open and **nothing new is added today**: no new stub, no new Stack problem, no new buggy round. This file only re-orders the open items into smaller steps. **Each step ends in a push, even if red.** The order below is the order to work in.

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🏦 banking · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Run `git pull` first. Nothing changed in the repo since your last code push, so the figures from 4 Nov still stand: `course-practice` 19/19 (`SpringDefaultsDrillTest` red, 3 stubs), `CarFleetTest` 37/37, `Day04LargestRectangleTest` 15/36, `Day02RpnEvaluatorRedoNov01Test` 0/44, `ValidParenthesesRedoNov01Test` 0/18, `AuthSchemaIT` 2 red stubs.

## 🌅 Morning

> [!WARNING]
> **Why the plan is smaller this time.** Yesterday's morning list had seven items and none was pushed. Today the list is the same seven items in five short steps, with the quick, certain wins first (comment lines, then the one small Spring drill that closes Part B2). The long steps (RPN redo, module 1) come after, so a short morning still ends with pushes. Ask for a hint after **15 minutes** on any step; a red push counts.

### ⏱️ Time plan (120 min)
| Minutes | Track | Item | Push it |
|---|---|---|---|
| 0-5 | 🧩 DSA | `CarFleet`: pattern, time, space as 3 comment lines | yes, first; `CarFleetTest` stays 37/37 |
| 5-25 | 🌱 Spring | **Drill 1** (closes Part B2): `/abc` → 400, unknown path → 404, 405 keeps `Allow` | yes; `course-practice` **22 tests, 0 failures** |
| 25-30 | 🧩 DSA | Count-stack O(n) re-ask, answered in chat | graded tonight |
| 30-55 | 🔁🧩 DSA | Cold redo `Day02RpnEvaluatorRedoNov01` (0/44), timed 25 min | yes, even if red |
| 55-70 | 🐞 Buggy | `Day04LargestRectangle`: symptom table and blank hand trace, no code change | yes |
| 70-110 | 🏦 Banking | **Module 1, step 1**: five design decisions, then `V2__create_auth_tables.sql` by hand and `AuthSchemaIT` | yes, once V2 is complete |
| 110-120 | Buffer | `mvn test`, push whatever is left | |

> [!TIP]
> Spring gets 60 of the 120 minutes (Drill 1 plus module 1 step 1). If Drill 1 takes longer than 25 minutes, stop it, push what you have and move on; the unfinished part goes to tonight's list.

---

## 1️⃣ 🧩 `CarFleet`: three comment lines (5 min, **push first**)
Spec and hints: [day13.md](day13.md#1️⃣-carfleet-three-comment-lines-5-10-min-push-first).

- [ ] At the top of `src/main/java/com/prashant/dsa/stack/CarFleet.java`: one comment line each for the pattern, the time and the space, with the reason in one sentence next to each cost.
- [ ] `mvn test -Dtest=CarFleetTest` is still **37/37**. Push.

> [!TIP]
> One question each. Time: which step costs the most, the sort or the single pass over the stack? Space: in the worst case how many fleets can the stack hold, and what else did you allocate (the sorted copy)?

## 2️⃣ 🌱 Drill 1: Spring defaults vs the catch-all (about 20 min)
Full 12-part spec: [day13.md, Drill 1](day13.md#-drill-1-spring-defaults-vs-the-catch-all-about-15-min). Stub: `spring-boot/course-practice/src/test/java/com/prashant/coursepractice/controller/SpringDefaultsDrillTest.java` (3 red tests).

> [!IMPORTANT]
> ✅ Done when `mvn test` in `spring-boot/course-practice` shows **22 tests, 0 failures** and you can say in one sentence why the catch-all hid Spring's own answers. This closes Part B2.

Do it in this order, so nothing is added before you know what is missing:
| Step | What you do | Minutes |
|---|---|---|
| 1 | Run the app (or write test 1 first) and read what `GET /api/students/abc` and `GET /api/nothing` answer today. Write the two answers next to what Spring answers by itself (400 and 404). | 5 |
| 2 | Ask: which exception is each one, and which resolver would have handled it if the catch-all had not matched first? Write the two exception class names. | 3 |
| 3 | Add **only** the handlers that are missing for those two exceptions (or change the catch-all so they pass through). 3-5 lines of plain-English pseudocode first. | 7 |
| 4 | Fill in the 3 tests (400, 404, 405 with `Allow`). Push. | 5 |

## 3️⃣ 🧩 Count-stack O(n) re-ask (5 min, in chat)
Answer in 3-4 lines: `RemoveKAdjacentDuplicates` keeps a stack of (character, count). A run can be popped many times. Why is the total still O(n)?

> [!TIP]
> (1) How many times can one character be **pushed** in total? (2) How many times can one entry be **popped**? (3) So what is the most work the whole loop can do, and where does that cost come from, in one sentence?

## 4️⃣ 🔁 Cold redo `Day02RpnEvaluatorRedoNov01` (25 min)
| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🐞 `Day02RpnEvaluator` | `src/main/java/com/prashant/dailytests/redo/Day02RpnEvaluatorRedoNov01.java` | `Day02RpnEvaluatorRedoNov01Test` 0/44 | +1 (reset 31 Oct, 4 days late) | 25 min, cold |

- [ ] Before any Java: 3 comment lines (pattern, time, space) and 3-5 lines of plain-English pseudocode: a number token, an operator token, the end check.
- [ ] Cold means cold: do not open `Day02RpnEvaluator*` or older redos. Set a 25-minute timer. Push at the end, even if red.

> [!WARNING]
> Ladder rule: 44/44 with no peeking moves it up; a pass that needed a hint repeats the gap; a conceptual slip (operand order, the `-3` token, the end check, the null guard) resets it to day 1. If it fails, the [RPN weak-topic pack](day13.md#️-weak-topic-pack-rpn-evaluation-new-tonight) is the next step.

## 5️⃣ 🐞 `Day04LargestRectangle`: symptom table (15 min)
Both tables and the method are in [day13.md](day13.md#-buggy-day04largestrectangle-symptom-table-15-min); spec in [day09.md](day09.md#-day04largestrectangle-buggy-round).

- [ ] A comment block at the top of `Day04LargestRectangle.java` with table 1 (failing tests by group, what the wrong answers share) and table 2 (a blank hand trace on `[2, 1, 2]`, expected 3). **No code change today.** Push.

## 6️⃣ 🏦 Banking module 1, step 1 (about 40 min)
Step 1 only: [day13.md, module 1 step 1](day13.md#-banking-module-1-step-1-the-v2-auth-migration-and-its-test-about-40-min). Full 12-part module spec: [day09.md](day09.md#-banking-module-1-authn--authz-foundation).

| Part | Minutes | What |
|---|---|---|
| a | 10 | Decide the five points (tables and join tables, key type, case-insensitive username, password column, `BaseEntity` columns) in writing on paper or in chat |
| b | 25 | Write `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` by hand, the five decisions as comment lines at the top |
| c | 5 | Fill in the two `AuthSchemaIT` tests |

> [!CAUTION]
> Flyway checksums a migration the first time it runs. Do **not** start the app or run `AuthSchemaIT` against a database until V2 is complete, and never edit V2 afterwards (add V3 or reset the dev database). No password, hash or seed user in the file.

- [ ] V2 pushed. `v2CreatesFiveAuthTables` and `usernameIsUniqueIgnoringCase` pass with Docker Desktop running, or the push is red and tonight's review reads the file.

---

## 🌙 Evening plan (60 min)
| Order | Item | Track |
|---|---|---|
| 1 | Review and score each track out of 10 | all |
| 2 | Finish whatever is pending from the morning, in the order above | all |
| 3 | In chat: Q3 and Q6 of the B2 interview questions (graded) and the `CarFleet` single-pair follow-up | 🌱🧩 |
| 4 | 🔁 cold redo `ValidParenthesesRedoNov01` (0/18), 20 min, pattern note and complexity first | 🧩 |

## 📦 Carried backlog (not for this morning)
| Item | Track | Status | When |
|---|---|---|---|
| Part B2 | 🌱 | 🟡 IN_PROGRESS (19/19; closes with Drill 1, then ✅ after review) | today, step 2 |
| Drill 2 (`@Valid` and 400) and Drill 3 (a MockMvc happy-path plus error test) | 🌱 | ⬜ NOT_STARTED | after Drill 1, 15 min each |
| Count-stack O(n) re-ask (3/5) | 🧩 | 🔴 REVISION_REQUIRED | today, step 3 |
| `CarFleet` single-pair follow-up | 🧩 | ⬜ NOT_STARTED | tonight, in chat |
| `Day00BuggyExample` warm-up (4/10) | 🐞 | ⬜ NOT_STARTED | after `Day04LargestRectangle` is ✅ |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after the re-ask |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | evenings with spare time |
| Next new Stack problem | 🧩 | ⬜ not assigned | only when the `CarFleet` comments and the re-ask are done |
| Redos queued: `MinStack`, `ScoreOfParentheses` (6 Nov), `RemoveKAdjacentDuplicates`, `Day03NextGreaterIndex` (7 Nov) | 🔁 | 🟡 IN_PROGRESS | [redo-schedule.md](../revision/redo-schedule.md), cap 2 a day |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.

---

## 🌙 Evening (5 Nov): review, scores and tonight's work

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-60%20min-blue) ![Spring](https://img.shields.io/badge/Spring-7%2F10-yellow) ![DSA](https://img.shields.io/badge/DSA-8%2F10-brightgreen) ![Buggy](https://img.shields.io/badge/Buggy-7%2F10-yellow)

> [!NOTE]
> Checked at 8 PM on `d8306e2` (JDK 21, Maven). Four pushes today: `1c9c6aa` (Drill 1 and the `CarFleet` comment lines, 15:53), `800ad4f` (cold RPN redo, 16:20), `d8306e2` (`Day04LargestRectangle`, 18:43) and Lumi's minor fixes `7b7c725` (stale comments, one extra assertion, not logged). Suites: `course-practice` **23/23**, `Day02RpnEvaluatorRedoNov01Test` **44/44**, `Day04LargestRectangleTest` **36/36**, `CarFleetTest` **37/37**, `ValidParenthesesRedoNov01Test` 0/18 (not attempted yet). **No new conceptual mistake**, so nothing is added to the logs; the redo cells of the RPN and count-stack rows in [mistakes/dsa.md](../revision/mistakes/dsa.md) are marked ✅.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **7/10** (🟡 Moderate) | concept 7: the lesson of the last three days landed: you added **only** the two handlers that were missing (type mismatch → 400, no resource → 404), left the catch-all untouched and last, and `405` still keeps its `Allow` header. Implementation 7: 23/23 on your own code, clean `ProblemDetail`s with `errorCode`, but the 404 test only checks that `errorCode` exists, not its value, and the one-sentence "why the catch-all hid Spring's answers" is not in the repo. Problem solving 7: the right exceptions named. Interview readiness 6: Q3 and Q6 of the B2 questions are still unanswered |
| 🧩 DSA | **8/10** (🟢 Strong for the track, 🟡 for RPN until a second clean pass) | concept 8: the count-stack re-ask is right (each character is pushed at most once and popped at most once, so at most 2n steps). Implementation 9: the cold RPN redo is **44/44 on the first push, no hint**, and none of the three 31 Oct slips came back (pop order, whole-token operator check, `size()` end check, null guards, `Math.*Exact`). Problem solving 7: no new problem today. Complexity 7: the numbers are right (`stack`, `O(nlogn)`, `O(n)` on `CarFleet`), but the comment lines still carry **no reason sentence** next to each cost, which was half of the task. Interview readiness 7 |
| 🐞 Buggy | **7/10** (🟡 Moderate) | `Day04LargestRectangle` went from 15/36 to **36/36 in one push with three small, exact changes**, which is real debugging skill: concept 7, implementation 9. Debugging 7, not higher, because the symptom table and the `[2, 1, 2]` hand trace were skipped, so there is no written proof that you localised each cause from the failing tests (and I cannot see from the repo or chat whether you used a hint; if you did, tell me and I will lower it by one). Interview readiness 6: you have not yet said out loud why the empty-stack case behaves differently from the non-empty one |

> [!TIP]
> One note on commit hygiene: `d8306e2` is titled "cold rpn for nov1 pushed", the same text as `800ad4f`. Name a commit after what it changed (`Fix Day04LargestRectangle: zero heights, empty-stack width, long area`); an interviewer reading your history does read this.

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 Catch-all handler and Spring defaults (Part B2) | 🟡 Moderate, **closed** (B2 ✅ COMPLETED, 5 Nov) | only the missing handlers added; Strong needs the one-sentence "why it hid Spring's answers" and Q6 |
| 🧩🐞 RPN evaluation | 🟡 Moderate (was 🔴 Weak) | clean cold 44/44, no hint; a second clean pass on Sun 8 Nov (+3) makes it 🟢 Strong. Pack from 4 Nov stays on file |
| 🧩 Amortised O(n) for stack solutions | 🟡 Moderate (was 🔴 Weak) | re-ask correct; but the `CarFleet` comments have no "where the cost comes from" sentence yet |
| 🧩 `CarFleet` | 🟡 Moderate (carried) | 37/37 with hints; comment lines in, reasons and the single-pair follow-up owed |
| 🐞 `Day04LargestRectangle` | ✅ code verified, 🟡 write-up pending | 36/36; symptom table and hand trace owed; joins the redo ladder at +1 (queued 13 Nov) |
| 🏦 Banking module 1 (AuthN / AuthZ) and Drills 2 and 3 | ⬜ Pending, **parked** | the Spring slot moves to `spring-boot-labs` on Fri 6 Nov; nothing is deleted |
| 🌱 HTTP semantics, `ResponseEntity` vs `@ResponseStatus`, `@PathVariable` / `@RequestParam` / `@RequestBody` | 🔴 Weak (carried, no work today) | Day 02 and Day 03 re-answers still pending; their packs are generated when those re-answers are picked up (spare evenings), as agreed on 1 Nov |
| ⛔ Blocked | none | nothing outside your control is stopping any task |

No topic became newly Weak today, so no new weak-topic pack is generated.

### 🐞 Debugging write-up for `Day04LargestRectangle` (the part that was skipped)

On the **original** code (`0a9a400`) these 21 tests fail. Group them by what the wrong answers share (error type, size of the gap, which input shapes), then match each group to the one change in `d8306e2` that fixed it.

| Test | Expected | Actual on `0a9a400` |
|---|---|---|
| `single` / `singleOne` / `singleMax` | 5 / 1 / 2147483647 | 0 / 0 / 0 |
| `twoEqual` · `allEqual` · `lowWide` | 4 · 9 · 3 | 2 · 6 · 2 |
| `decreasing` · `leftEdge` · `wholeRange` | 9 · 10 · 16 | 6 · 5 · 12 |
| `largeFlat` | 200000 | 199999 |
| `twoMax` · `billionTimesThree` · `manyMax` | 4294967294 · 3000000000 · 214748364700000 | 2147483647 · 2000000000 · 2147483647 |
| `largeIncreasing` · `largeDecreasing` | 10000100000 each | 2147427742 · 2147387388 |
| `singleZero` · `allZeros` · `zeroSplits` · `zeroEdges` · `zeroTie` · `randomCrossCheck` | 0 or the area | `IllegalArgumentException: invalid height: 0` |

- [ ] Table 1: your groups (a name for each group, the tests in it, one sentence on what their wrong answers share).
- [ ] Table 2: a blank hand trace on `[2, 1, 2]` (expected **3**) on the **fixed** code: `i`, `current`, stack before, what is popped, `height`, `width`, `area`, `best`. Say in one sentence why the width is `i` when the stack is empty and `i - stack.peek() - 1` otherwise.
- [ ] Put both as a comment block at the top of `Day04LargestRectangle.java`. No code change. Push with a real commit message.

### ⏳ Pending morning work = tonight's work (in this order, 60 min)

> [!IMPORTANT]
> The morning list is done except the write-up and module 1 step 1. Module 1 step 1 (40 min) does not fit tonight and is **parked** (see the classification above), so tonight is short and finishable. Push after each step; a red push counts.

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 15 | `Day04LargestRectangle` symptom table and `[2, 1, 2]` hand trace (above) | 🐞 | one commit on `main`, no code change |
| 2 | 20 | 🔁 cold `ValidParenthesesRedoNov01` (0/18): blank file, 3 comment lines, 3-5 lines of plain-English pseudocode (open bracket, close bracket, end check) before any Java. The suite is strict: empty, `null`, non-bracket characters, 100 000 characters | 🧩 | 18/18, cold, pushed |
| 3 | 10 | `CarFleet`: one reason sentence next to each of the 3 comment lines (hint: which step is `O(nlogn)`, and what is the stack's worst-case size?), then the single-pair follow-up in chat | 🧩 | pushed; `CarFleetTest` still 37/37 |
| 4 | 10 | In chat: Q3 of the B2 questions, and one sentence on why the catch-all hid Spring's own 400 and 404 | 🌱 | graded 7+ |

> [!NOTE]
> Redo cap: the RPN redo counts as today's first, so `ValidParenthesesRedoNov01` is the second and last. [redo-schedule.md](../revision/redo-schedule.md) is updated: RPN +1 → +3 (due Sun 8 Nov), `Day04LargestRectangle` joins at +1 (queued Fri 13 Nov), `ValidParentheses` stays due tonight. If tonight's redo is a clean 18/18 it moves to +3 (the Mon 9 Nov slot already holds it).

- [ ] `Day04LargestRectangle` write-up pushed
- [ ] `ValidParenthesesRedoNov01` pushed (cold)
- [ ] `CarFleet` reasons pushed and single-pair follow-up answered
- [ ] Q3 and the catch-all sentence answered

### 🎯 Tomorrow's focus (Fri 6 Nov), from tonight's assessment

| Track | Focus | Why |
|---|---|---|
| 🌱 Spring | First chapter of `spring-boot-labs` (the Spring slot moves there on 6 Nov). Bring one habit from Drill 1: before adding anything, ask what Spring already does, then add only what is missing. Banking module 1 step 1, Drills 2 and 3 and Q6 wait in Pending | the lowest Spring dimension today was interview readiness (6): Q3 and Q6 still unanswered; the new repo is a fresh start, so the habit matters more than the content |
| 🧩 DSA | The next new Stack problem is allowed now (suggested: Daily Temperatures, a monotonic stack that reuses what `Day03NextGreaterIndex` and `Day04LargestRectangle` practised). 3-5 lines of plain-English pseudocode before any Java, and for every cost one sentence saying where it comes from | RPN and the re-ask are closed and clean, so the blocker on new Stack work is gone; the weakest DSA dimension today was complexity (7): right numbers, no reasons |
| 🐞 Buggy | `Day00BuggyExample` warm-up (4/10): read the failing tests and group them by symptom **before** touching the code, then fix each group with the smallest change | debugging was the lowest buggy dimension (7): the fixes were exact, but no written localisation |
| 🔁 Redos (evening) | `MinStack` and `ScoreOfParentheses` (+1, both more than 10 days overdue) | cap of 2 a day, most overdue first |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.
