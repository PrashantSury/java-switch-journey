# 📅 Day 09 (31 Oct): two cold Stack redos

![Week](https://img.shields.io/badge/Week-2-blue) ![Day](https://img.shields.io/badge/Day-09-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!IMPORTANT]
> Redo day: the `Day01ArrayStack` day-7 redo (overdue since 30 Oct) and the cold `Day02RpnEvaluator` day-7 redo (due today). Both are written from memory, no peeking. Day 04 Q3 moves to the next free slot.

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
- [ ] Run `mvn test -Dtest=Day02RpnEvaluatorRedo7Test` until 44/44 pass. It's **43/44** after your second push: only `nullArray` fails, see the warning below.

> [!WARNING]
> ⚠️ Last time this redo passed only after re-reading the original, so it stayed 🟠 Attempted. This one counts only if it's written cold.

> [!TIP]
> Think about which pop is the right operand, tokens that only *start* like an operator, and every arithmetic op that can overflow.

> [!WARNING]
> 🔴 **Needs correction (31 Oct review):** the operator fall-through (`else`) and the end check (`stack.size() != 1`) are fixed, and an empty array is rejected. One bug is left: `evaluate(null)` throws `NullPointerException` because the `for` loop runs on a `null` array; add a `tokens == null` check at the top that throws `IllegalArgumentException`, then re-run for 44/44. Logged in [revision/mistakes/dsa.md](../revision/mistakes/dsa.md), redo on 3 Nov.

### 🔁 Small item (~15 min): Day01ArrayStack day-7 redo, cold (carried from Day 08)
- [x] Without opening `Day01ArrayStack.java` or `Day01ArrayStackRedo.java`, write `src/main/java/com/prashant/dailytests/redo/Day01ArrayStackRedo7.java` (spec in its Javadoc).
- [x] Run `mvn test -Dtest=Day01ArrayStackRedo7Test` until 17/17 pass. Done: 17/17 (31 Oct).

> [!TIP]
> The three Day 01 traps: when exactly is the array full, what does "empty" mean, and what does doubling a capacity of 0 give you?

### ✅ How it's verified
| Item | Check | Status |
|---|---|---|
| `Day02RpnEvaluatorRedo7` | `mvn test -Dtest=Day02RpnEvaluatorRedo7Test` 44/44, written cold | 🔴 Needs correction (43/44, checked 31 Oct, fe6827d) |
| `Day01ArrayStackRedo7` | `mvn test -Dtest=Day01ArrayStackRedo7Test` 17/17, written cold | ✅ Completed and verified (17/17, checked 31 Oct, d5c0ee9) |

## 📌 Carried backlog
| Item | Where | Status |
|---|---|---|
| Day 04 **Q3** (`ProblemDetail`, 409 vs 400, why the exists check isn't enough) | [interview-answers.md](../interview-answers.md), answer in chat | ⬜ Pending, next free slot |
| Day 04 Part B2 (`ProblemDetail` in every handler, malformed JSON 400, +3 tests) | `spring-boot/course-practice` | ⬜ Not started, after the backlog shrinks |
| SQL 03 **Q1** | `sql/day03.sql`, answer in `sql/day03-answers.md` | ⬜ Not started, this evening |
| SQL learn lesson 03 | `sql/learn/lesson03.md` | ⬜ Not started, this evening |
| `CarFleet` | DSA, 2/37 | ⬜ Not started |
| `Day04LargestRectangle` | 🐞 buggy round, 15/36 | ⬜ Not started |
| Count-stack O(n) quiz re-ask | chat | 🔵 due 1 Nov |
