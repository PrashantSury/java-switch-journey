# 📅 Day 10 (Sun 1 Nov): first day of the three-track program, all on carried work

![Week](https://img.shields.io/badge/Week-2-blue) ![Day](https://img.shields.io/badge/Day-10-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Program](https://img.shields.io/badge/program-day%201-purple)

> [!IMPORTANT]
> Progress decides the work, not the calendar. Every track still has an open item, so **no new material today**: each track works its first open item from the pending table in [day09.md](day09.md#-what-is-pending-now). The full specs (12-part Spring, 8-part DSA, buggy round) are already written there and are linked below, not copied.

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Tick the `- [ ]` boxes as you go.

## 🌅 Morning

> [!NOTE]
> Checked at 6 AM: no pushes from you since the 31 Oct evening (the latest commits are the 1 Nov restructure). `CarFleetTest` 2/37 and `Day04LargestRectangleTest` 15/36 are unchanged, Part B2 has no code yet, Day 04 Q1-Q3 are still 🔴.

### ⏱️ Time plan (120 min)
| Minutes | Track | Item | Spec |
|---|---|---|---|
| 0-5 | 🔥 Revise first | Read the Day 04 rows in [mistakes/spring.md](../revision/mistakes/spring.md), then close it | |
| 5-20 | 🌱 Spring | Re-answer Day 04 Q1-Q3 in chat (definition → difference → when to use → example, plus a production angle) | [Re-answer cards](day09.md#-re-answer-cards) |
| 20-55 | 🌱 Spring | Day 04 Part B2: `ProblemDetail` in every error response, malformed JSON → 400, +3 tests | [Part B2](day09.md#-day-04-part-b2-problemdetail-in-every-error-response) |
| 55-90 | 🧩 DSA | `CarFleet` (NeetCode 150, Stack): pattern line and complexity first, then code | [Car Fleet](day09.md#-car-fleet-dsa) |
| 90-105 | 🐞 Buggy | `Day04LargestRectangle` (monotonic stack): make the suite pass without changing tests | [Day04LargestRectangle](day09.md#-day04largestrectangle-buggy-round) |
| 105-120 | Buffer | Finish whichever item ran over; push | |

### 🌱 Spring (~50 min)
- [ ] Re-answer Day 04 Q1, Q2, Q3 in chat (status stays 🔴 until each is graded 7 or more).
- [ ] Part B2 in `spring-boot/course-practice`: `ProblemDetail` for every error, `HttpMessageNotReadableException` → 400, +3 tests. Done when `mvn test` is green there and the review reads the handler.

> [!TIP]
> Senior angle to have ready for scoring: in a banking API, what must **never** appear in a `ProblemDetail` `detail` field, and where does the full cause go instead?

### 🧩 DSA (~35 min)
- [ ] `src/main/java/com/prashant/dsa/stack/CarFleet.java`. Done when `mvn test -Dtest=CarFleetTest` is 37/37 on your pushed code, with the pattern line and complexity at the top. The optimised approach stays in the collapsed **Open only after your attempt** block in the spec.

### 🐞 Buggy (~15 min)
- [ ] `src/main/java/com/prashant/dailytests/Day04LargestRectangle.java`. Done when `mvn test -Dtest=Day04LargestRectangleTest` is 36/36 with only logical fixes in the main code. Read the failing tests, localise, fix with the smallest change.

### 🔁 Due redos (2, run in the 🌙 evening after the review, per [PROGRAM.md](../docs/PROGRAM.md))
Blank stubs are ready; each test class was checked against a correct version (all green) and fails on the empty stub.

| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🐞 `Day02RpnEvaluator` | `src/main/java/com/prashant/dailytests/redo/Day02RpnEvaluatorRedoNov01.java` | `Day02RpnEvaluatorRedoNov01Test` 0/44 | +1 (reset after 31 Oct) | 20-30 min, cold |
| 🧩 `ValidParentheses` | `src/main/java/com/prashant/dailytests/redo/ValidParenthesesRedoNov01.java` | `ValidParenthesesRedoNov01Test` 0/18 | +1 (8 days late) | 20-30 min, cold |

> [!WARNING]
> Cold means cold: don't open `Day02RpnEvaluator*`, `ValidParentheses.java` or old redos. Write the three comment lines (pattern, time, space) before any code. The new `ValidParentheses` suite is stricter than the 2-test starter: empty string, closers on an empty stack, non-bracket characters, `null`, deep nesting and a 100 000-character input.

### 📦 Carried backlog (not for this morning)
| Item | Track | Status | When |
|---|---|---|---|
| `Day00BuggyExample` warm-up (4/10) | 🐞 | ⬜ NOT_STARTED | after `Day04LargestRectangle` is ✅ |
| Count-stack O(n) re-ask (3/5) | 🧩 | 🔴 REVISION_REQUIRED | evening, in chat |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after the re-ask |
| Day 02 Q1, Q3 and Day 03 Q1, Q2 re-answers | 🌱 | 🟡 IN_PROGRESS | after Day 04 re-answers |
| Banking module 1 (AuthN / AuthZ) | 🏦 | ⬜ NOT_STARTED | starts when Part B2 is ✅ |

### ✅ How it's verified
| Item | Check | Status |
|---|---|---|
| Day 04 Q1-Q3 | graded in chat, 7+ each | 🔴 REVISION_REQUIRED |
| Part B2 | `mvn test` in `spring-boot/course-practice`, code read | ⬜ NOT_STARTED |
| `CarFleet` | `CarFleetTest` 37/37 | ⬜ NOT_STARTED (2/37) |
| `Day04LargestRectangle` | `Day04LargestRectangleTest` 36/36 | ⬜ NOT_STARTED (15/36) |
| `Day02RpnEvaluatorRedoNov01` | 44/44, cold | 🟡 IN_PROGRESS (0/44) |
| `ValidParenthesesRedoNov01` | 18/18, cold | 🟡 IN_PROGRESS (0/18) |

```bash
git pull
mvn test -Dtest='CarFleetTest,Day04LargestRectangleTest,*RedoNov01Test'
```
