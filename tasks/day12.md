# 📅 Day 12 (Tue 3 Nov): carried work only, finish what is open

![Week](https://img.shields.io/badge/Week-2-blue) ![Day](https://img.shields.io/badge/Day-12-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Program](https://img.shields.io/badge/program-day%203-purple)

> [!IMPORTANT]
> Progress decides the work, not the calendar. Every track still has an open item, so **no new material today** and no new stubs: the same three items, in the same order. The full specs are already written and linked, not copied: Part B2 in [day10.md](day10.md#-day-04-part-b2-problemdetail-in-every-error-response) and the [late push review](day11.md#-late-push-review-2-nov-2235-ist), `CarFleet` and `Day04LargestRectangle` in [day09.md](day09.md).

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Tick the `- [ ]` boxes as you go.

## 🌅 Morning

> [!NOTE]
> Checked at 6 AM on `a302cd8` (JDK 21, Maven). Your only code push since the last session is `0600df2` (2 Nov, 22:35 IST, Part B2); with Lumi's minor fixes `3d85c55`, `course-practice` is **18/18**. The late-push review is in [day11.md](day11.md#-late-push-review-2-nov-2235-ist) (Spring 6/10). Untouched and re-run this morning: `CarFleetTest` **2/37**, `Day04LargestRectangleTest` **15/36**, `Day02RpnEvaluatorRedoNov01Test` **0/44**, `ValidParenthesesRedoNov01Test` **0/18**. No new cosmetic fixes and no new mistakes since the late-push review.

> [!WARNING]
> **Why today is shaped this way.** The Spring track moved last night, and that is the first push in two days: well done. DSA and buggy have not moved: `CarFleet` is in its seventh session and `Day04LargestRectangle` in its sixth. So `CarFleet` goes **first**, as a 10-minute step that ends in a push, even if the suite is still red. Nothing else is opened before it is pushed.

### ⏱️ Time plan (120 min)
| Minutes | Track | Item | First step (push it) | Spec |
|---|---|---|---|---|
| 0-10 | 🧩 DSA | `CarFleet` first step | the pattern line and time/space as comments at the top of `CarFleet.java`, plus the example `target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]` sorted by position by hand with each car's arrival time. **Push it, even if red** | [Car Fleet](day09.md#-car-fleet-dsa) |
| 10-15 | 🔥 Revise first | Read the *Notes* part of the amortised O(n) pack, then close it | | [pack](day10.md#-weak-topic-pack-amortised-on-for-stack-solutions) |
| 15-55 | 🌱 Spring | Finish Day 04 Part B2: the catch-all handler, one test, then Q3 and Q6 out loud | answer the three guiding questions of conceptual mistake 1 in a comment or in chat, before touching the code | [late push review](day11.md#-late-push-review-2-nov-2235-ist) |
| 55-90 | 🧩 DSA | `CarFleet` code to 37/37 | run the suite, read the first failing tests | [Car Fleet](day09.md#-car-fleet-dsa) |
| 90-105 | 🐞 Buggy | `Day04LargestRectangle` | a table of the 21 failing tests grouped by symptom, as a comment block at the top of `Day04LargestRectangle.java` (no code change yet) | [Day04LargestRectangle](day09.md#-day04largestrectangle-buggy-round) |
| 105-120 | Buffer | Finish whichever item ran over; `mvn test`; push | | |

### 🌱 Spring (~40 min of the slot, B2 is nearly done)
- [ ] The `@ExceptionHandler(Exception.class)` catch-all in `GlobalExceptionHandler.java` (conceptual mistake 1 of the [late push review](day11.md#-late-push-review-2-nov-2235-ist)). Answer its three guiding questions first, then fix or remove the handler so that 405, 415 and a non-numeric id keep their own status, the client gets a fixed generic `detail` for a real bug, and the full cause is logged.
- [ ] One test that proves a 415 or a 405 keeps its status, and the spec's sixth assertion on `malformedJsonReturnsProblemDetail` (no `Unexpected`, `JsonParseException` or `com.fasterxml` in the body).
- [ ] Q3 and Q6 of the B2 interview questions, answered out loud in chat (graded tonight).
- ✅ Done when `mvn test` in `spring-boot/course-practice` is **green with the new test (19 or more, 0 failures)**, every error body is `application/problem+json`, and the handler has been read in review. Part B2 turns ✅ only then; banking module 1 starts after it.

> [!TIP]
> Senior angle for the evening score: a client sends `{"amount": "12,50"}` to a payments endpoint. Which exception does Spring raise, at which step, and what may the `detail` field say without leaking the Jackson message or the class name? The same question for an unexpected `NullPointerException` in a service: what do the client and the log each get?

### 🧩 DSA (~35 min)
- [ ] `src/main/java/com/prashant/dsa/stack/CarFleet.java`. First step as in the time plan. ✅ Done when `mvn test -Dtest=CarFleetTest` is **37/37** on your pushed code, with the pattern line and complexity at the top. The optimised approach stays inside the collapsed **Open only after your attempt** block in the spec; open it only after your attempt or a hint.

### 🐞 Buggy (~15 min)
- [ ] `src/main/java/com/prashant/dailytests/Day04LargestRectangle.java`. ✅ Done when `mvn test -Dtest=Day04LargestRectangleTest` is **36/36** with only logical fixes in the main code (tests unchanged, no rewrite). Read the failing tests, localise, smallest change per group.

### 🔁 Due redos (2, in the 🌙 evening after the review and pending work)
The blank stubs from 1 Nov are still in place, untouched; their test classes were verified against a correct version.

| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🐞 `Day02RpnEvaluator` | `src/main/java/com/prashant/dailytests/redo/Day02RpnEvaluatorRedoNov01.java` | `Day02RpnEvaluatorRedoNov01Test` 0/44 | +1 (reset 31 Oct, 2 days late) | 20-30 min, cold |
| 🧩 `ValidParentheses` | `src/main/java/com/prashant/dailytests/redo/ValidParenthesesRedoNov01.java` | `ValidParenthesesRedoNov01Test` 0/18 | +1 (10 days late) | 20-30 min, cold |

> [!WARNING]
> Cold means cold: don't open `Day02RpnEvaluator*`, `ValidParentheses.java` or old redos. Three comment lines first (pattern, time, space). If they slip again tonight, the 10 PM check moves the whole queue one more day; `MinStack` and `ScoreOfParentheses` are next in line (4 Nov).

### 📦 Carried backlog (not for this morning)
| Item | Track | Status | When |
|---|---|---|---|
| Count-stack O(n) re-ask (3/5) | 🧩 | 🔴 REVISION_REQUIRED | evening, in chat, before the pack's other parts |
| `Day00BuggyExample` warm-up (4/10) | 🐞 | ⬜ NOT_STARTED | after `Day04LargestRectangle` is ✅ |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after the re-ask |
| Day 02 Q1, Q3 and Day 03 Q1, Q2 re-answers | 🌱 | 🟡 IN_PROGRESS | after Part B2 is ✅ |
| Banking module 1 (AuthN / AuthZ) | 🏦 | ⬜ NOT_STARTED | starts when Part B2 is ✅ ([spec](day09.md#-banking-module-1-authn--authz-foundation)) |

### ✅ How it's verified
| Item | Check | Status at 6 AM |
|---|---|---|
| Part B2 | `mvn test` in `spring-boot/course-practice`, handler read | 🟡 IN_PROGRESS (18/18 green, catch-all open) |
| `CarFleet` | `CarFleetTest` 37/37 | ⬜ NOT_STARTED (2/37, by accident) |
| `Day04LargestRectangle` | `Day04LargestRectangleTest` 36/36 | ⬜ NOT_STARTED (15/36) |
| `Day02RpnEvaluatorRedoNov01` | 44/44, cold | 🟡 IN_PROGRESS (0/44) |
| `ValidParenthesesRedoNov01` | 18/18, cold | 🟡 IN_PROGRESS (0/18) |

```bash
git pull
(cd spring-boot/course-practice && mvn test)
mvn test -Dtest='CarFleetTest,Day04LargestRectangleTest,*RedoNov01Test'
```

## 🕔 Midday push review (3 Nov, 17:37 IST)

![Slot](https://img.shields.io/badge/slot-midday%20push-yellow) ![Spring](https://img.shields.io/badge/Spring-not%20scored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-7%2F10-yellow) ![Buggy](https://img.shields.io/badge/Buggy-not%20scored-lightgrey)

> [!NOTE]
> Reviewed `91cb817` ("CarFleet Java", 17:37 IST), after the 6 AM session commit `bc4c245`. One file changed: `src/main/java/com/prashant/dsa/stack/CarFleet.java`. JDK 21, Maven. Earlier today, in chat, you answered the 3 `CarFleet` knowledge checks 3/3 and built the algorithm with hints: sort by position descending, compare each car's time with the slowest fleet ahead, and compare times exactly by cross-multiplying with `long`. Several hints were needed (the pairing and the exact comparison), so this counts as a **pass with a hint** for the redo ladder.

### 🧪 Test results
| Suite | Before | After | Note |
|---|---|---|---|
| `CarFleetTest` | 2/37 | **37/37** ✅ | all validation rules, input not modified, 100 000 cars, exact ties |
| `course-practice` (`mvn test`) | 18/18 | 18/18 | untouched; catch-all handler still open |
| `Day04LargestRectangleTest` | 15/36 | 15/36 | untouched (15 failures + 6 errors reported, same as before) |
| `Day02RpnEvaluatorRedoNov01Test` | 0/44 | 0/44 | blank stub |
| `ValidParenthesesRedoNov01Test` | 0/18 | 0/18 | blank stub |

### 🔧 Minor fixes done by Lumi (commit "Lumi: minor fixes on 91cb817")
| File:line | Fix |
|---|---|
| `CarFleet.java:86` | removed the stale `// TODO: implement` |
| `CarFleet.java:86-87` | `if(position == null ||  speed == null ){` → `if (position == null || speed == null) {` (spacing, double space) |
| `CarFleet.java:87` | exception message `"Illegal argument passed"` → `"position and speed must not be null"` (the other guards already say what is wrong) |

No logic was changed; `CarFleetTest` is still 37/37 after the fixes.

### 🧠 Conceptual issues
> [!NOTE]
> None in the pushed code: the stack holds `long[]{dist, speed}` and the check `dist * aheadSpeed > aheadDist * speed` uses `long`, which cannot overflow here (both factors are below 2^31, so the product is below 2^62). Two things to do yourself:

1. **Missing deliverable (not code):** the "Done when" of this task asks for the **pattern line and time/space complexity at the top** of `CarFleet.java`. They are not there yet. Write the three comment lines yourself, and be ready to defend the O(n log n) and the O(n) space in 60 seconds. *Hint:* which step dominates, and what does the stack hold in the worst case?
2. **Follow-up for tonight's interview angle:** the code only ever reads the top of the stack. *Hint:* what single pair of values would replace the stack, and why is the result the same? Say it in chat; no need to code it unless you want to.

Logged in [mistakes/dsa.md](../revision/mistakes/dsa.md): in chat you first wrote `long time = (target - pos) / spd;` (integer division drops the fraction), the same root cause as Q3.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))
| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **not scored** | no new Spring work; B2 still 18/18 with the catch-all open |
| 🧩 DSA | **7/10** (🟡 Moderate) | 🧠 concept **8**: 3/3 on the knowledge checks, the merge rule and "meeting at the target is one fleet" are right. 🛠️ implementation **8**: 37/37 on your own pushed code, clean, exact `long` comparison, input copied not sorted in place; two cosmetic slips only, and the complexity comments are missing. 🧩 problem solving **6**: the table and pseudocode were right but took about an hour and several hints (pairing the arrays, the exact comparison). ⏱️ complexity not scored: not stated yet. Debugging and interview dimensions did not apply |
| 🐞 Buggy | **not scored** | `Day04LargestRectangle` untouched |

> [!NOTE]
> Midday score, provisional. The evening review re-scores DSA if the comment lines and the O(1) follow-up land by then.

### 🔁 Status after this review
| Item | Status |
|---|---|
| 🧩 `CarFleet` | ✅ COMPLETED (3 Nov, 37/37, with hints); joins the redo ladder at +1 as 🔶 (hint-assisted); owed: 3 comment lines |
| 🌱 Day 04 Part B2 | 🟡 IN_PROGRESS, unchanged: catch-all, one 415/405 test, Q3 and Q6 |
| 🐞 `Day04LargestRectangle` | ⬜ NOT_STARTED, 15/36, symptom table still to write |
| 🔁 Redos | `Day02RpnEvaluatorRedoNov01` and `ValidParenthesesRedoNov01` still blank |

> [!IMPORTANT]
> **Next step for you:** (1) push the 3 comment lines on `CarFleet`; (2) Part B2: the catch-all and one test, then Q3 and Q6 in chat; (3) `Day04LargestRectangle` symptom table; (4) tonight: the count-stack O(n) re-ask, then the two cold redos. `CarFleet` itself is not redone until its slot on Tue 10 Nov.

