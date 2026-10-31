# 📅 Day 09 (31 Oct): two cold Stack redos

![Week](https://img.shields.io/badge/Week-2-blue) ![Day](https://img.shields.io/badge/Day-09-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!IMPORTANT]
> Redo day: the `Day01ArrayStack` day-7 redo (overdue since 30 Oct) and the cold `Day02RpnEvaluator` day-7 redo (due today). Both are written from memory, no peeking. Day 04 Q1-Q3 were answered on 31 Oct (15/30), so they are re-answered by Tue 3 Nov.

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🔥 revise first · ⬜ not started · 🟡 in progress · 🟠 attempted · 🔴 needs correction · 🔵 ready for revision · ✅ done · ⚠️ gotcha. Tick the `- [ ]` boxes as you finish each item.

## 🌅 Morning: cold redos (Stack pattern)

> [!NOTE]
> Backlog day, no new material. Nothing is in Needs correction, so redos due today come first (they rank above pending Q&A). No new buggy round (`Day04LargestRectangle` is unattempted and two redos are open) and no new Spring task: §5 Validation & error handling is still active and Part B2 is next once the backlog shrinks.

> [!TIP]
> ✅ Great late-night push yesterday: **Part B1 is verified (15/15)**, **`AsteroidCollision` 28/28** and **SQL learn lesson 02 5/5** are all ✅ Completed and verified in `PROGRESS.md`.

### 📚 Revise first (~5 min)
| Topic | What to recall |
|---|---|
| 🔥 | Read the Day 01 and Day 02 rows in [revision/mistakes/dsa.md](../revision/mistakes/dsa.md), then close it before you start coding. |

### 🅰️ Main task (~30 min): Day02RpnEvaluator day-7 redo, cold
- [x] Without opening `Day02RpnEvaluator.java` or `Day02RpnEvaluatorRedo.java`, write `src/main/java/com/prashant/dailytests/redo/Day02RpnEvaluatorRedo7.java` (spec in its Javadoc).
- [x] Run `mvn test -Dtest=Day02RpnEvaluatorRedo7Test` until 44/44 pass. Done: 44/44 (31 Oct, after the fall-through, end-check and null-guard fixes).

> [!WARNING]
> ⚠️ Last time this redo passed only after re-reading the original, so it stayed 🟠 Attempted. This one counts only if it's written cold.

> [!TIP]
> Think about which pop is the right operand, tokens that only *start* like an operator, and every arithmetic op that can overflow.

> [!TIP]
> ✅ **Fixed (31 Oct):** the operator fall-through (`else`), the end check (`stack.size() != 1`) and the null/empty guard are all in. The mistake is logged in [revision/mistakes/dsa.md](../revision/mistakes/dsa.md); redo again on 3 Nov and 7 Nov.

### 🔁 Small item (~15 min): Day01ArrayStack day-7 redo, cold (carried from Day 08)
- [x] Without opening `Day01ArrayStack.java` or `Day01ArrayStackRedo.java`, write `src/main/java/com/prashant/dailytests/redo/Day01ArrayStackRedo7.java` (spec in its Javadoc).
- [x] Run `mvn test -Dtest=Day01ArrayStackRedo7Test` until 17/17 pass. Done: 17/17 (31 Oct).

> [!TIP]
> The three Day 01 traps: when exactly is the array full, what does "empty" mean, and what does doubling a capacity of 0 give you?

### ✅ How it's verified
| Item | Check | Status |
|---|---|---|
| `Day02RpnEvaluatorRedo7` | `mvn test -Dtest=Day02RpnEvaluatorRedo7Test` 44/44, written cold | ✅ Completed and verified (44/44, checked 31 Oct, 37f6c11 + Lumi's indentation clean-up; first push 15/44, fixed in 3 rounds) |
| `Day01ArrayStackRedo7` | `mvn test -Dtest=Day01ArrayStackRedo7Test` 17/17, written cold | ✅ Completed and verified (17/17, checked 31 Oct, d5c0ee9) |

## 📌 Carried backlog
| Item | Where | Status |
|---|---|---|
| Day 04 **Q1-Q3** (JSON → DTO, DTOs vs entity, `ProblemDetail` and the race condition) | [day04-answers.md](../spring-boot/interview-answers/day04-answers.md), re-answer in chat | 🔴 Needs correction · answered 31 Oct, 15/30 (5 / 4 / 6) · re-answer by Tue 3 Nov |
| Day 04 Part B2 (`ProblemDetail` in every handler, malformed JSON 400, +3 tests) | `spring-boot/course-practice` | ⬜ Not started, after the backlog shrinks |
| SQL 03 **Q1** | `sql/day03.sql`, answer in `sql/day03-answers.md` | ⬜ Not started, this evening |
| SQL learn lesson 03 | `sql/learn/lesson03.md` | ⬜ Not started, this evening |
| `CarFleet` | DSA, 2/37 | ⬜ Not started |
| `Day04LargestRectangle` | 🐞 buggy round, 15/36 | ⬜ Not started |
| Count-stack O(n) quiz re-ask | chat | 🔵 due 1 Nov |

## 🌙 Evening (~55 min): backlog only

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-~55%20min-blue)

> [!NOTE]
> Checked at 8 PM with `mvn test`: `CarFleetTest` 2/37 (both pass by accident on the stub), `sql/learn/lesson03-exercises.sql` still empty, no `sql/day03-answers.md`. With `CarFleet` and `Day04LargestRectangle` ⬜ Not started and 5 SQL files unanswered, tonight is backlog only: the oldest DSA stub and the next SQL lesson. No new stub, no new SQL file.

### 🧩 DSA (~35 min): Car Fleet (LeetCode 853, NeetCode 150 Stack)
- 📂 `src/main/java/com/prashant/dsa/stack/CarFleet.java` (tests in `CarFleetTest`, 2/37 right now)
- 📌 Cars drive one lane towards `target` and can't pass each other; a faster car that catches a slower one joins its fleet (also exactly at the target). Return how many fleets arrive.
- 📌 Repo rules: `null` arrays, unequal lengths, `target <= 0`, positions outside `[0, target)`, speed `<= 0` and duplicate positions all throw `IllegalArgumentException`; no cars returns 0; don't modify the input; compare arrival times **exactly** (values go up to `Integer.MAX_VALUE`); aim for O(n log n).

- [ ] Implement `carFleet(int target, int[] position, int[] speed)`.
- [ ] `mvn test -Dtest=CarFleetTest` shows 37/37.

> [!TIP]
> Think about which car you should look at first, and what "exactly equal arrival time" means when a division would round.

### 🎓 SQL (~20 min): learn lesson 03, aggregates, GROUP BY, HAVING
- 📂 Read `sql/learn/lesson03.md`, run `sql/learn/lesson03-setup.sql` in pgAdmin, write your 5 queries in `sql/learn/lesson03-exercises.sql`.
- 📌 Covers `COUNT(*)` vs `COUNT(col)` vs `COUNT(DISTINCT col)`, how `SUM`/`AVG` treat NULLs, `WHERE` vs `HAVING`, and `ROUND`.

- [ ] Write the 5 queries under the `-- @ex N` markers.
- [ ] `mvn test -Dtest=SqlLessonCheckTest -Dlesson=03` shows 5 `[PASS]`.

> [!TIP]
> Exercise 3 has a branch where every balance is NULL. Predict what `SUM` returns there before you run it.

> [!NOTE]
> `sql/day03.sql` Q1 (branch max with ties, empty branches kept) needs both GROUP BY (lesson 03) and LEFT JOIN (lesson 04), so it now follows lesson 04 instead of being re-assigned a fifth time cold. It stays ⬜ in `PROGRESS.md`.

### 📌 Still open

| Item | Path | Status |
|---|---|---|
| 🎤 Day 04 Q1-Q3 re-answer | in chat | 🔴 Needs correction · by Tue 3 Nov |
| 🗄️ SQL 03 Q1 | `sql/day03.sql` → `sql/day03-answers.md` | ⬜ Not started · after lesson 04 |
| 🐞 `Day04LargestRectangle` | `src/main/java/com/prashant/dailytests/` | ⬜ Not started (15/36) |
| 🌱 Day 04 Part B2 | `spring-boot/course-practice` | ⬜ Not started, after the backlog shrinks |
| 🔁 Redos due Sun 1 Nov | `Day02RpnEvaluator` (+1, reset), `ValidParentheses` (+1, late) | ⬜ see [redo-schedule.md](../revision/redo-schedule.md) |

> [!IMPORTANT]
> ✅ Done when `CarFleetTest` is 37/37 and the lesson 03 checker prints `LESSON 03 COMPLETE` on your pushed code. `git pull` first, run `mvn test`, and reply in chat when you're ready for grading.

## 🌃 End of day (10 PM check)

| Item | Outcome |
|---|---|
| 🔁 `Day02RpnEvaluatorRedo7` (day-7 redo, cold) | ✅ Completed and verified (44/44, 37f6c11) · passed after 3 conceptual fixes, so reset to day 1, redo 1 Nov |
| 🔁 `Day01ArrayStackRedo7` (day-7 redo, cold) | ✅ Completed and verified (17/17, d5c0ee9) · clean pass, next redo 7 Nov |
| 🎤 Day 04 Q1-Q3 | 🔴 Needs correction (graded 15/30: 5 / 4 / 6) · re-answer by Tue 3 Nov |
| 🧩 `CarFleet` | ⬜ Not started (2/37, no push after the 8 PM assignment) · carried |
| 🎓 SQL learn lesson 03 | ⬜ Not started (exercises still empty) · carried |
| 🗄️ SQL 03 Q1 | ⬜ Not started · now follows learn lesson 04 |
| 🐞 `Day04LargestRectangle` | ⬜ Not started (15/36) · carried |
| 🌱 Day 04 Part B2 | ⬜ Not started · after the backlog shrinks |

> [!NOTE]
> No pushes from Prashant after the 8 PM evening assignment, so nothing new to test tonight. No new mistakes and no cosmetic fixes needed.

> [!IMPORTANT]
> **Next task (Sun 1 Nov, 6 AM):** the two cold redos due on 1 Nov, `Day02RpnEvaluator` (+1, reset) and `ValidParentheses` (+1, late), then re-answer Day 04 Q1-Q3 in chat by Tue 3 Nov. `CarFleet` (2/37) and SQL learn lesson 03 carry to the evening.
