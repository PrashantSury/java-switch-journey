# 📅 Day 11 (Mon 2 Nov): carried work only, finish what is open

![Week](https://img.shields.io/badge/Week-2-blue) ![Day](https://img.shields.io/badge/Day-11-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Program](https://img.shields.io/badge/program-day%202-purple)

> [!IMPORTANT]
> Progress decides the work, not the calendar. Every track still has an open item, so **no new material today**: the same three items as yesterday, in the same order. The full specs are already written and are linked, not copied: Part B2 in [day10.md](day10.md#-day-04-part-b2-problemdetail-in-every-error-response), `CarFleet` and `Day04LargestRectangle` in [day09.md](day09.md).

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Tick the `- [ ]` boxes as you go.

## 🌅 Morning

> [!NOTE]
> Checked at 6 AM on `5e49e42` (JDK 21, Maven): no pushes from you since `bc6df22` (1 Nov, 08:43 IST). `course-practice` 11/15 (the same 4 old `$.error` / `$.name` assertions), `CarFleetTest` 2/37, `Day04LargestRectangleTest` 15/36, `Day02RpnEvaluatorRedoNov01Test` 0/44, `ValidParenthesesRedoNov01Test` 0/18. Nothing to review, no cosmetic fixes, no new mistakes.

> [!WARNING]
> **Why today is shaped this way.** `CarFleet` has now been on the list for five sessions and `Day04LargestRectangle` for four, without a first push. The block is starting, not solving. So each item below has a **first 10-minute step that ends in a push**, even if the suite is still red. A red-but-honest commit (pattern line, a failing test, a symptom table) counts as progress in the evening review; an untouched stub does not.

### ⏱️ Time plan (120 min)
| Minutes | Track | Item | First 10-minute step (push it) | Spec |
|---|---|---|---|---|
| 0-5 | 🔥 Revise first | Read the *Notes* part of the amortised O(n) pack, then close it | | [pack](day10.md#-weak-topic-pack-amortised-on-for-stack-solutions) |
| 5-55 | 🌱 Spring | Day 04 Part B2 items 1-6 | write `malformedJsonReturnsProblemDetail`, watch it fail (400, empty body) | [Part B2 §7](day10.md#-day-04-part-b2-problemdetail-in-every-error-response) |
| 55-90 | 🧩 DSA | `CarFleet` (NeetCode 150, Stack) | pattern line + time/space as comments, and the example `target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]` sorted by position by hand with each car's arrival time | [Car Fleet](day09.md#-car-fleet-dsa) |
| 90-105 | 🐞 Buggy | `Day04LargestRectangle` | a table of the 21 failing tests grouped by symptom, as a comment block at the top of `Day04LargestRectangle.java` (no code change yet) | [Day04LargestRectangle](day09.md#-day04largestrectangle-buggy-round) |
| 105-120 | Buffer | Finish whichever item ran over; `mvn test`; push | | |

### 🌱 Spring (~50 min)
- [ ] Part B2 in `spring-boot/course-practice`, items 1-6 of [section 7](day10.md#-day-04-part-b2-problemdetail-in-every-error-response): the red `malformedJsonReturnsProblemDetail` test, then the `HttpMessageNotReadableException` handler (with the log line), the 4 moved assertions and the other 2 tests. Contract and tests in **one** commit.
- ✅ Done when `mvn test` there shows **18 tests, 0 failures**, every error body is `application/problem+json`, and `StudentController`, `StudentServiceImpl` and the repository are unchanged.

> [!TIP]
> Senior angle for the evening score: a client sends `{"amount": "12,50"}` to a payments endpoint. Which exception does Spring raise, at which step, and what may the `detail` field say without leaking the Jackson message or the class name?

### 🧩 DSA (~35 min)
- [ ] `src/main/java/com/prashant/dsa/stack/CarFleet.java`. ✅ Done when `mvn test -Dtest=CarFleetTest` is **37/37** on your pushed code, with the pattern line and complexity at the top. The optimised approach stays inside the collapsed **Open only after your attempt** block in the spec; open it only after your attempt or a hint.

### 🐞 Buggy (~15 min)
- [ ] `src/main/java/com/prashant/dailytests/Day04LargestRectangle.java`. ✅ Done when `mvn test -Dtest=Day04LargestRectangleTest` is **36/36** with only logical fixes in the main code (tests unchanged, no rewrite). Read the failing tests, localise, smallest change per group.

### 🔁 Due redos (2, in the 🌙 evening after the review and pending work)
The blank stubs from 1 Nov are still in place, untouched; their test classes were verified against a correct version.

| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🐞 `Day02RpnEvaluator` | `src/main/java/com/prashant/dailytests/redo/Day02RpnEvaluatorRedoNov01.java` | `Day02RpnEvaluatorRedoNov01Test` 0/44 | +1 (reset 31 Oct, 1 day late) | 20-30 min, cold |
| 🧩 `ValidParentheses` | `src/main/java/com/prashant/dailytests/redo/ValidParenthesesRedoNov01.java` | `ValidParenthesesRedoNov01Test` 0/18 | +1 (9 days late) | 20-30 min, cold |

> [!WARNING]
> Cold means cold: don't open `Day02RpnEvaluator*`, `ValidParentheses.java` or old redos. Three comment lines first (pattern, time, space). If they slip again tonight, the 10 PM check moves the whole queue one more day; `MinStack` and `ScoreOfParentheses` are next in line (3 Nov).

### 📦 Carried backlog (not for this morning)
| Item | Track | Status | When |
|---|---|---|---|
| Count-stack O(n) re-ask (3/5) | 🧩 | 🔴 REVISION_REQUIRED | evening, in chat, before the pack's other parts |
| `Day00BuggyExample` warm-up (4/10) | 🐞 | ⬜ NOT_STARTED | after `Day04LargestRectangle` is ✅ |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after the re-ask |
| Day 02 Q1, Q3 and Day 03 Q1, Q2 re-answers | 🌱 | 🟡 IN_PROGRESS | after Part B2 |
| Banking module 1 (AuthN / AuthZ) | 🏦 | ⬜ NOT_STARTED | starts when Part B2 is ✅ ([spec](day09.md#-banking-module-1-authn--authz-foundation)) |

### ✅ How it's verified
| Item | Check | Status at 6 AM |
|---|---|---|
| Part B2 | `mvn test` in `spring-boot/course-practice` (18 tests), handler read | 🟡 IN_PROGRESS (11/15) |
| `CarFleet` | `CarFleetTest` 37/37 | ⬜ NOT_STARTED (2/37, by accident) |
| `Day04LargestRectangle` | `Day04LargestRectangleTest` 36/36 | ⬜ NOT_STARTED (15/36) |
| `Day02RpnEvaluatorRedoNov01` | 44/44, cold | 🟡 IN_PROGRESS (0/44) |
| `ValidParenthesesRedoNov01` | 18/18, cold | 🟡 IN_PROGRESS (0/18) |

```bash
git pull
(cd spring-boot/course-practice && mvn test)
mvn test -Dtest='CarFleetTest,Day04LargestRectangleTest,*RedoNov01Test'
```
