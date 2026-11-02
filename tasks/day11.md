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

## 🌙 Evening (2 Nov): review, scores and tonight's work

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-60%20min-blue) ![Spring](https://img.shields.io/badge/Spring-not%20scored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-not%20scored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-not%20scored-lightgrey)

> [!NOTE]
> Checked at 8 PM on `f1dd0e5` with JDK 21 and Maven. There are **no pushes from you today**; the only commit is the 6 AM morning session. The last code push is still `f4cb8b9` (1 Nov, 08:38 IST). Test results are unchanged from the morning: `course-practice` **11/15**, `CarFleetTest` **2/37**, `Day04LargestRectangleTest` **15/36**, `Day02RpnEvaluatorRedoNov01Test` **0/44**, `ValidParenthesesRedoNov01Test` **0/18**. No answers were given in chat today. Nothing to grade, so no cosmetic fixes and no new entries in the mistake logs.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **can't be scored yet** | no Spring work today: Part B2 is where `f4cb8b9` left it (11/15, malformed-body handler and 3 tests missing). Yesterday's 7/10 stands as the last score |
| 🧩 DSA | **can't be scored yet** | no DSA work today: `CarFleet` is still the stub (2/37 by accident) |
| 🐞 Buggy | **can't be scored yet** | no buggy work today: `Day04LargestRectangle` is unchanged at 15/36 |

> [!WARNING]
> 📌 **The honest read.** This is the second day in a row without a push, and `CarFleet` is now in its sixth session, `Day04LargestRectangle` in its fifth. At lead level the skill gap here is small; the gap is **starting**. That is why tonight's list opens with a 10-minute item whose only goal is a red-but-honest push. One pushed comment block tonight is worth more to the score than a perfect plan for tomorrow.

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 §5 `ProblemDetail` error contract (Part B2) | 🟡 Moderate (carried) | last scored 7/10 on 1 Nov; no new evidence. Finish items 1-6 |
| 🧩 `CarFleet` | ⬜ Pending | not attempted (2/37) |
| 🐞 `Day04LargestRectangle` | ⬜ Pending | not attempted (15/36) |
| 🔁 `Day02RpnEvaluator` and `ValidParentheses` cold redos | ⬜ Pending | stubs 0/44 and 0/18, due tonight |
| 🧩 Amortised O(n) reasoning for stack solutions | 🔴 Weak (carried) | count-stack quiz 3/5 on 29 Oct, re-ask still open. The pack is already in [day10.md](day10.md#-weak-topic-pack-amortised-on-for-stack-solutions); nothing new is generated tonight |
| ⛔ Blocked | none | nothing outside your control is stopping any task |

> [!NOTE]
> No topic scored Weak **tonight**, because nothing was graded. The other 🔴 Weak rows in [PROGRESS.md](../PROGRESS.md#-weak-topics) come from older answers; their packs are made when each is picked up.

### ⏳ Pending morning work = tonight's work (in this order)

> [!IMPORTANT]
> Pending morning work first, redos only after. Stop where your 60 minutes end and push what you have, even if it is red. The 10 PM check counts a pushed first step as progress.

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 10 | `CarFleet` first step: the pattern line, time/space as comments, and the example `target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]` sorted by position by hand with each car's arrival time. **Push it.** | 🧩 | one commit on `main`, suite may still be red |
| 2 | 25 | Part B2 items 1-6 ([checklist in section 7](day10.md#-day-04-part-b2-problemdetail-in-every-error-response)): `malformedJsonReturnsProblemDetail` first (red), then the handler with the log line, the 4 moved assertions and the other 2 tests, in one commit | 🌱 | `course-practice` **18 tests, 0 failures** |
| 3 | 15 | `CarFleet` code, from the hand-sorted example | 🧩 | `CarFleetTest` 37/37 on your pushed code |
| 4 | 5 | Count-stack O(n) re-ask, in chat | 🧩 | graded 4/5 or better |
| 5 | 5 | `Day04LargestRectangle` first step: the 21 failing tests grouped by symptom as a comment block, no code change | 🐞 | one commit on `main` |
| 6 | if time | 🔁 cold redos `Day02RpnEvaluatorRedoNov01` (0/44) and `ValidParenthesesRedoNov01` (0/18) | 🔁 | 44/44 and 18/18, cold |

> [!NOTE]
> If the redos slip again, the 10 PM check moves the queue one more day (`MinStack` and `ScoreOfParentheses` behind them). [redo-schedule.md](../revision/redo-schedule.md) is unchanged tonight because no redo was graded.

- [ ] `CarFleet` first step pushed
- [ ] B2 18/18 pushed
- [ ] `CarFleet` 37/37 pushed
- [ ] count-stack re-ask answered in chat
- [ ] `Day04LargestRectangle` symptom table pushed
- [ ] the two cold redos pushed (if time)

### 🎯 Tomorrow's focus (Tue 3 Nov), from tonight's assessment

| Track | Focus | Why |
|---|---|---|
| 🌱 Spring | Finish B2 if still open (contract and tests in one commit), then answer B2 interview questions 3 and 6 out loud. Banking module 1 starts only when B2 is ✅ | last measured weakness was implementation (6/10); module 1 waits behind B2 by plan |
| 🧩 DSA | `CarFleet` to 37/37. If tonight's first step is pushed, go straight to code; if not, the morning opens with that 10-minute step and nothing else until it is pushed | no DSA scored since 31 Oct; the block is starting, not solving |
| 🐞 Buggy | `Day04LargestRectangle`: symptom table first, then the smallest fix per group | debugging is what this round scores, and it has not been attempted |
| 🔁 Redos (evening) | `Day02RpnEvaluator` and `ValidParentheses` if not done tonight, otherwise `MinStack` and `ScoreOfParentheses` | cap of 2 a day, most overdue first |

> [!TIP]
> Reply in chat when something is pushed, or when you want the re-ask or the B2 interview questions graded. Each answer is graded and recorded the same night.

## 🌃 End of day (2 Nov, 10 PM check)

![slot](https://img.shields.io/badge/slot-10%20PM%20check-yellow)

| Item | Outcome |
|---|---|
| 🌱 Day 04 Part B2 | 🟡 IN_PROGRESS · `course-practice` 11/15 (4 old assertions), malformed-body handler and +3 tests open · carried |
| 🧩 `CarFleet` | ⬜ NOT_STARTED (2/37, no first-step push) · carried |
| 🧩 Count-stack O(n) re-ask | 🔴 REVISION_REQUIRED (not answered in chat) · carried |
| 🐞 `Day04LargestRectangle` | ⬜ NOT_STARTED (15/36, no symptom table) · carried |
| 🔁 `Day02RpnEvaluatorRedoNov01` / `ValidParenthesesRedoNov01` | 🟡 IN_PROGRESS (0/44, 0/18, not attempted) · moved to Tue 3 Nov evening, the rest of the queue shifts one more day |

> [!NOTE]
> No commits from Prashant after the 8 PM evening review (the last one is still `f4cb8b9`, 1 Nov 08:38 IST), and no answers in chat, so there was nothing new to test. No new mistakes and no cosmetic fixes. [redo-schedule.md](../revision/redo-schedule.md) is rewritten for the two missed redos (last graduation now Thu 31 Dec).

> [!IMPORTANT]
> **First task tomorrow (Tue 3 Nov, 6 AM):** 🧩 the `CarFleet` first 10-minute step from [day09.md](day09.md#-car-fleet-dsa): the pattern line and time/space as comments at the top of `CarFleet.java`, plus the example `target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]` sorted by position by hand with each car's arrival time, **pushed even if red**. Then 🌱 Part B2 items 1-6 to 18/18 in one commit, 🧩 `CarFleet` code to 37/37, and 🐞 the `Day04LargestRectangle` symptom table. 🌙 Evening: the count-stack re-ask, then the redos `Day02RpnEvaluatorRedoNov01` and `ValidParenthesesRedoNov01`.

## 🌌 Late push review (2 Nov, 22:35 IST)

![Slot](https://img.shields.io/badge/slot-late%20push-yellow) ![Spring](https://img.shields.io/badge/Spring-6%2F10-yellow) ![DSA](https://img.shields.io/badge/DSA-not%20scored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-not%20scored-lightgrey)

> [!NOTE]
> Reviewed `0600df2` ("Added Part B - Handler Methods and Test Cases", 22:35 IST) and its merge `9c60f91`, both after the 10 PM check `af18eeb`. Two files changed, both in `spring-boot/course-practice`: `GlobalExceptionHandler.java` and `StudentControllerTest.java`. Nothing else was pushed. JDK 21, Maven.

### 🧪 Test results

| Suite | Before (10 PM check) | As pushed (`9c60f91`) | After Lumi's minor fixes (`3d85c55`) |
|---|---|---|---|
| `course-practice` (Part B2) | 11/15 | **16/18** | **18/18** |
| `CarFleetTest` | 2/37 | 2/37 | 2/37 (untouched) |
| `Day04LargestRectangleTest` | 15/36 | 15/36 | 15/36 (untouched) |
| `Day02RpnEvaluatorRedoNov01Test` | 0/44 | 0/44 | 0/44 (untouched) |
| `ValidParenthesesRedoNov01Test` | 0/18 | 0/18 | 0/18 (untouched) |

### 🔧 Minor fixes done by Lumi (`3d85c55`, "Lumi: minor fixes on 0600df2")

Line numbers refer to the files as they are in `3d85c55`.

| # | Where | What was wrong | Fix |
|---|---|---|---|
| 1 | `StudentControllerTest.java:175` | test named `notFoundIdProblemDetail`; the spec asks for `notFoundIsProblemDetail` | renamed |
| 2 | `StudentControllerTest.java:177-178` | the 404 test asserted `isBadRequest()` (and `$.status` 404 in the same test), plus a stray `.param("name", ...)` and a `Content-Type` on a GET | `isNotFound()`, request reduced to `GET /api/students/99999` |
| 3 | `StudentControllerTest.java:181` | `$.detail` expected `Student Not Found` (that is the title); real detail is `Student not found: 99999` | expected value corrected |
| 4 | `StudentControllerTest.java:189-195` | `validationErrorsAreListed` posted **no body** (`.param("", "")` with `application/problem+json`), so it hit the malformed-body handler (red: title `Malformed Request`); the expected texts `Student 'name' not found` were not what the handler produces | request body `{"name":"A","email":"not-an-email"}` as `application/json` as in the spec; `$.errors.name` and `$.errors.email` now `exists()` as in the spec |
| 5 | `StudentControllerTest.java:165-166` | `malformedJsonReturnsProblemDetail` posted no body with `application/problem+json`; it was green only because a missing body throws the same exception | request is now the spec's `{"name":` as `application/json` |
| 6 | `StudentControllerTest.java:162, 174, 186` | `@DisplayName` text copy-pasted ("... 400 with matches"), missing blank lines between tests | display names say what the test proves, blank lines added |
| 7 | `StudentControllerTest.java:199` | `createStudent` indented by 8 spaces | re-indented |
| 8 | `GlobalExceptionHandler.java:76-77` | `handleDuplicateEmail` built the `ProblemDetail` in a second layout (spec item 3) | same layout as the other handlers |

Already right in your push, no change needed: the unused `ResponseStatus` import is gone, the malformed-body handler returns the fixed `detail` and `MALFORMED_REQUEST`, the 4 old assertions moved to `$.errors.*` and `$.detail`, the three test names match the spec.

### 🧠 Conceptual mistakes (not touched, yours to fix)

**1. The `Exception.class` catch-all (`GlobalExceptionHandler.java:103-115`).** Symptom: ask the running app for something that is not a 500 and you get a 500. I probed three requests on your pushed code (a scratch test, not committed): `POST /api/students` with `text/plain`, `PATCH /api/students`, and `GET /api/students/abc`. All three came back **500**. The body also says "Required json body is bad or empty." with `errorCode` `BAD_JSON_OR_EMPTY_JSON`, which is the message of a different failure, and nothing is logged. No test fails, so the green suite does not show it; the failing-test names would be the ones you write for it.

Guiding questions:
- Which resolver runs first when an `@ExceptionHandler(Exception.class)` exists, yours or `DefaultHandlerExceptionResolver`? Re-read section 5 gotcha in [the B2 spec](day10.md#-day-04-part-b2-problemdetail-in-every-error-response).
- What should a client of a banking API read after a genuine bug: the real cause, or a fixed generic sentence? Where does the real cause go then, and at which log level?
- Is the catch-all required today? Item 7 was optional. If you keep it, what keeps 405 and 415 as they are, and how will you prove it with a test?

**2. Test intent (conceptual in effect, fixed above as a minor).** Two of the three new tests did not send the request they claim to test, and one passed only because both situations throw the same exception. Question to answer in your own words: for `malformedJsonReturnsProblemDetail`, which assertion would still pass if the handler leaked the parser message? (The spec's sixth assertion on `Unexpected`, `JsonParseException` and `com.fasterxml` is not in your test yet.)

**3. Logging detail (hint only).** `log.warn(ex.getMessage())` keeps the text but loses the exception and its cause chain. Which `warn` overload keeps both, and why is it not a format-string risk to pass a message that contains `{}`?

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **6/10** (🟡 Moderate) | 🧠 concept **6**: the exception-per-step model is right (new handler for `HttpMessageNotReadableException`, fixed text to the client, cause to the log), but the catch-all swallows 405 and 415 and the rule from the spec's section 5 was missed. 🛠️ implementation **6**: 16/18 as pushed; two tests did not exercise the request they were named for and one asserted the wrong status; code itself is clean (import removed, log field, `errorCode` on every handler). Problem solving, debugging and interview dimensions did not apply: no answers given and no failing run was worked through |
| 🧩 DSA | **not scored** | no DSA work: `CarFleet` still 2/37; no chat answer to the count-stack re-ask |
| 🐞 Buggy | **not scored** | no buggy work: `Day04LargestRectangle` still 15/36; redos still 0/44 and 0/18 |

### 🔁 Status after this review
| Item | Status |
|---|---|
| 🌱 Day 04 Part B2 | 🟡 IN_PROGRESS: `course-practice` **18/18** green, but not ✅ until the catch-all is fixed or removed and the handler is read again |
| 🧩 `CarFleet`, 🐞 `Day04LargestRectangle`, count-stack re-ask, both redos | unchanged, carried to Tue 3 Nov as set by the 10 PM check |

> [!IMPORTANT]
> **Next step for you (Spring, ~15 min):** answer the three questions under conceptual mistake 1, fix or remove the catch-all, add one test that proves a 415 or 405 keeps its status, and push. Then Q3 and Q6 of the B2 interview questions out loud, and banking module 1 can start. Everything else stays as in the 10 PM check: `CarFleet` first step first.
