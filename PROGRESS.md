# 📈 Progress Log

## 🟢 Now (Tue 24 Nov, Day 33)

| Track | Open now | Status | Next |
|---|---|---|---|
| 🌱 Spring | Ch 3 interview re-answer (written answer was 5/10) | 🔴 | graded ≥ 7 → Chapter 4 |
| 🧩 DSA | Group Anagrams (A&H 4 of 9), 0/22 | ⬜ | Top K Frequent next · verified **10** of 45-50 |
| 🐞 Buggy | `Day06FirstUniqueCode` 16/20 (last loop) | 🔴 | 20/20 → Friday's round |
| 🔁 Redos | `AsteroidCollisionRedoNov17` 0/28, `CarFleetRedoNov20` 0/37 | ⬜ | cold, cap 2 a day |

| Scores this week (/10) | 🌱 Spring | 🧩 DSA | 🐞 Buggy |
|---|---|---|---|
| Sun 22 Nov | unscored | unscored | unscored |
| Mon 23 Nov | unscored | 6 (Two Sum 19/19; from the evening review, row not yet in the log) | unscored |
| Last scored | 7 (21 Nov) | 6 (23 Nov) | 5 (21 Nov, Day06 16/20) |

**Today's plan:** [tasks/day33.md](tasks/day33.md) · **All problems:** [PROBLEMS.md](PROBLEMS.md) · Full history and detail below.

![Program](https://img.shields.io/badge/program-Senior%20Java%20Backend%20Mentor-purple) ![Started](https://img.shields.io/badge/started-23%20Oct%202026-informational) ![Tracks](https://img.shields.io/badge/tracks-Spring%20%C2%B7%20DSA%20%C2%B7%20Buggy-blue) ![Restructured](https://img.shields.io/badge/restructured-1%20Nov%202026-yellow)

> [!IMPORTANT]
> The single progress tracker, organised around the three tracks of [docs/PROGRAM.md](docs/PROGRAM.md): 🏦 Spring Boot banking project, 🧩 DSA (NeetCode by pattern) and 🐞 buggy problems, plus spaced repetition. Nothing is ✅ COMPLETED unless my own work is in the repo and verified. Progress, not the calendar, decides the next task.

> [!NOTE]
> **Legend:** ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED` · 🔥 active · 🧩 DSA · 🐞 buggy · 🏦 banking · 🌱 Spring · 🔁 redo. Old names map: Completed and verified → COMPLETED; Needs correction → REVISION_REQUIRED; Attempted / In progress / Ready for revision → IN_PROGRESS; Not started → NOT_STARTED. The Log at the bottom keeps the words it was written with.

## 🧭 Overall status

> [!IMPORTANT]
> **New DSA/buggy pace from Tue 17 Nov 2026 (agreed 16 Nov, 10:37 PM IST).** One new NeetCode problem every weekday (5 a week; an unfinished problem carries over with stronger hints, never open more than 2 days). Buggy rounds on Tuesday and Friday, on that week's pattern. No new DSA on weekends (carry-overs, redos, review). Redos are cold only: a blank file, no peeking; a redo copied from the original does not pass. Target: about 45–50 DSA problems verified by mid-January 2027 (7 verified as of 16 Nov; 8 with `GenerateParentheses` on 17 Nov). Reason: the measured pace of about 2 DSA and 1.5 buggy a week would reach only 12–25 of the NeetCode 150 by mid-January.

| Track | Status | Verified so far | Open now | Next |
|---|---|---|---|---|
| 🏦 **Spring Boot banking** | 🟡 IN_PROGRESS | foundation: `course-practice` Part A, B1 and **B2 ✅ (5 Nov, `1c9c6aa` + Lumi `7b7c725`, 23/23)**; Day 04 Q1-Q3 re-answers ✅ (26/30); banking setup (milestone 0) ✅; **0 of 10 modules** started; Spring slot in [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) | Q3 and Q6 of the B2 questions; module 1 step 1 and Drills 2 and 3 **parked**; **labs Chapter 1 tasks ✅ 19/19** (`4384b9c` on `main`, 12 Nov 10:26 PM IST; fix after `5c366dc` 18/19); **Ch 1 ✅ closed** (tasks 19/19 + interview **7/10**); **Ch 2 Task 1 ✅ 3/19** on `my-solutions` `1ded3b3` (15 Nov 8:35 AM IST, Spring **9/10**); **Ch 2 Tasks 2-5 ✅ 15/19** (`8f48e9b`; `393608c` + fix `00bd2eb`, 17 Nov 9:33 PM IST; Spring **7/10** on 17 Nov); **Ch 2 Task 6 ✅ 19/19** (`b4a3717`, 19 Nov 11:59 AM IST, day 3 with the skeleton hint) → **Chapter 2 code complete**, Spring **6/10**; **Task 6 interview 7/10** in chat (21 Nov 9:38-9:40 PM IST, after two corrections) → **Chapter 2 ✅ COMPLETED**; **Ch 3 (beans and the application context) code ✅ 15/15** (`e619f82`, 20 Nov 1:04 PM IST, all six tasks on the first push, no hint; planned was Tasks 1-2); Ch 3 written interview answer **5/10** 🔴 (singleton thread-safety fix wrong, logged); Spring **7/10** (20 Nov) | [day33.md](tasks/day33.md#1--spring-chapter-3-re-answer-in-writing-25-min) · **Tue 24 Nov:** Ch 3 re-answer **written** in interview-answers.md (warm-ups first; or in chat), Q2/Q3 + floor-vs-cap; ≥ 7 opens Chapter 4. No graded answer on record from Mon 23 Nov. Earlier: [day32.md](tasks/day32.md) · **Mon 23 Nov (catch-up, first task):** Ch 3 re-answer part 2 + part 3 and senior Q2/Q3 + floor-vs-cap in chat (≥ 7 unlocks Chapter 4); Sun 22 Nov had no student work. Earlier plan: **Sun 22 Nov, first:** the Ch 3 interview re-answer in chat (why a singleton field races: fields on the shared heap vs locals on each thread's stack, plus two real fixes) + senior Q2/Q3 + floor-vs-cap line; **no Chapter 4 yet**; B2 Q3/Q6 still pending |
| 🧩 **DSA, Arrays & Hashing** (Stack ✅ closed 17 Nov) | 🟡 IN_PROGRESS | Stack: all **7 NeetCode Stack problems** have a verified solve (5 as DSA problems incl. **`GenerateParentheses` ✅ 17/17, `221069b`, 9/10**; Evaluate RPN and Largest Rectangle as buggy rounds) plus 2 extras; RPN redo ✅ 44/44; Lumi CarFleet comment PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) open; **Arrays & Hashing: `ContainsDuplicate` ✅ 17/17 (`eeb8bb9`, skeleton 🔶), `ValidAnagram` ✅ 18/18 (`97dbc9f`, after a char-sum conceptual miss); DSA 6/10 (19 Nov); **`TwoSum` ✅ 19/19 (`3a620f4`, 23 Nov 6:11 PM IST, near-full skeleton 🔶, reasons on every complexity line)** | single-pair CarFleet follow-up; `DailyTemperatures` pseudocode/brute-force comments still not written | [day33.md](tasks/day33.md#2--dsa-group-anagrams-new-arrays--hashing-4-of-9-40-min) · **Tue 24 Nov:** **Group Anagrams** (new, A&H 4 of 9, 0/22): pseudocode + brute force + key choice first; carries to Wed with guiding questions then a partial skeleton if open. Verified DSA count **10 of 45-50**. Earlier: [day32.md](tasks/day32.md#-2-dsa-two-sum-arrays--hashing-3-of-9-carry-over-with-a-near-full-skeleton-35-min) · **Mon 23 Nov:** Two Sum **carry-over** (not new) with a near-full skeleton (two blank lines), then retyped from blank → 19/19; **Group Anagrams (A&H 4 of 9) the day after**. Verified DSA count **9 of the 45-50 target** (needs about 5-5.5 a week). Earlier plan: **Sun 22 Nov (no new problem):** **Two Sum guided walkthrough** (0/19, past the 2-day limit), retyped from a blank method → 19/19; then the frequency-counting debugging exercise (10 min) + Valid Anagram checks; a "because" on every complexity line |
| 🐞 **Buggy rounds** | 🟡 IN_PROGRESS | 5 rounds with code ✅ (`Day00BuggyExample` **10/10**, `c0f5d64`, 6 Nov; `Day04LargestRectangle` 36/36); LargestRect write-up **graded in chat 7 Nov (supported)**; empty-stack width sentence ✅ **closed 15 Nov night** (**8/10** after a correction; buggy score stays 7); **`Day05DecodeString` ✅ 25/25** (`c61da8e`, 19 Nov, three minimal fixes + overflow-safe `k`; Buggy **7/10**) | Day00 symptom groups still absent; **Fri 20 Nov buggy round `Day06FirstUniqueCode`** 🔴 **16/20** (`41abb48`, 21 Nov 9:21 PM IST: 2 of 3 fixes right, the third a conceptual miss, alphabet index vs string position; Buggy **5/10**) | [day33.md](tasks/day33.md#3--buggy-slot-day06firstuniquecode-last-loop-15-min) · **Tue 24 Nov: no new round** (`Day06` still 🔴 16/20, not touched on 23 Nov): last loop with the first trace rows filled → 20/20 + symptom groups + per-fix comments; Friday's round only once `Day06` is ✅. Earlier: [day32.md](tasks/day32.md#-3-buggy-slot-monday-no-new-round-day06firstuniquecode-last-loop-15-min) · **Mon 23 Nov (no buggy round on Mondays):** buggy slot = `Day06` last loop only → 20/20 + symptom-group comment + one comment per fix; next buggy round **Tue 24 Nov** only if `Day06` is ✅. Earlier plan: **Sun 22 Nov:** `Day06FirstUniqueCode` **guided walkthrough** (past the 2-day limit) → 20/20 with the symptom-group comment + one comment per fix; `DailyTemperatures` comments (5 min) |
| 🔁 **Spaced repetition** | 🟡 IN_PROGRESS | 6 cold redos ✅ (12 Nov: `ValidParenthesesRedoNov08` **18/18** and `MinStackRedoNov01` **10/10**, both clean → +3); 16 Nov pair 🔶 (copied, 2/10 each); **19 Nov `Day03NextGreaterIndexRedoNov17` ✅ 37/37 clean cold (`2c0c2fb`) → +3** | `AsteroidCollisionRedoNov17` (0/28, not attempted 17-21 Nov) and `CarFleetRedoNov20` (0/37, not attempted 20-21 Nov) → **Sun 22 Nov** first, cold only; the queue moved one more slot at the 21 Nov 10 PM check (LargestRect + Day01 Mon 23, MinStack + RemoveK Thu 26, ScoreOf + `GenerateParentheses` Fri 27, Day03 + Asteroid (+3) Sat 28 Nov; last graduation Fri 29 Jan 2027) | **Tue 24 Nov:** Mon 23 pair not attempted → `AsteroidCollisionRedoNov17` cold in the morning (80-105), `CarFleetRedoNov20` cold in the evening ([day33.md](tasks/day33.md#-redos-cold-cap-2)); queue moved one day. Earlier: **Mon 23 Nov:** `AsteroidCollisionRedoNov17` cold in the morning (80-105), `CarFleetRedoNov20` cold in the evening ([day32.md](tasks/day32.md#-redos-cap-2-most-overdue-first-cold-only)) · [redo-schedule.md](revision/redo-schedule.md) · [day28.md redos](archive/tasks/day28.md#-evening-redos-cap-2-most-overdue-first-cold) |
| 🎤 **Interview Q&A** | 🟡 IN_PROGRESS | Day 02-04 graded (5/7/5, 5/5/7, 5/4/6); Day 04 re-answers 8/9/9 (26/30) ✅; **labs Ch 1 ✅ 7/10** (15 Nov); **labs Ch 2 Task 6 ✅ 7/10** (21 Nov, chat); labs Ch 3 Q1 🔴 5/10 (re-answer Sun 22 Nov) | `ScoreOfParentheses` follow-ups; B2 Q3/Q6; Day 02 and Day 03 re-answers | [interview-answers.md](interview-answers.md) · [day24.md interview](archive/tasks/day24.md#-chapter-1-interview-grade-807-815-am-ist) |

> [!TIP]
> The day is 2 h morning (all new work: Spring about 50 min, DSA about 35, buggy about 15) plus 1 h evening (review and score each track out of 10, finish pending work, then redos). Details: [docs/PROGRAM.md](docs/PROGRAM.md). **Today's plan: [tasks/day33.md](tasks/day33.md) (Tue 24 Nov, Day 33: Two Sum ✅ 19/19 reviewed; Ch 3 re-answer in writing, Group Anagrams new 0/22, `Day06` last loop (no new buggy round while it is 🔴), Asteroid cold; CarFleet cold in the evening; verified DSA 10 of 45-50).** Previous: [tasks/day32.md](tasks/day32.md) (Mon 23 Nov, Day 32, catch-up Monday: Ch 3 re-answer + Q2/Q3 in chat, Two Sum carry-over with a near-full skeleton, `Day06` last loop in the buggy slot, Asteroid cold; CarFleet cold in the evening; no Chapter 4 and no new A&H problem until these close; verified DSA 9 of 45-50).** Previous: [tasks/day31.md](tasks/day31.md) (Sun 22 Nov, Day 31, weekend catch-up: Ch 3 re-answer + Q2/Q3, Day06 and Two Sum guided, Asteroid + CarFleet cold; evening review and 10 PM check: all tracks unscored, nothing landed; Mon 23 Nov stays a catch-up day, first task the Ch 3 re-answer in chat)** End of day: [day30.md](tasks/day30.md#-end-of-day) (Ch 2 ✅, `Day06` 16/20 🔴; Sun 22 Nov first task: the Ch 3 re-answer). Previous: [tasks/day29.md](tasks/day29.md) (Fri 20 Nov). Previous: [tasks/day28.md](archive/tasks/day28.md) (Thu 19 Nov), [tasks/day27.md](archive/tasks/day27.md) (Wed 18 Nov). Older pointers, kept as history: [tasks/day20.md](archive/tasks/day20.md) (11 Nov morning, **lighter day** after three days with no pushes: one must-do = labs Ch 1 **Task 1, the coordinates** (`com.ledgerly : ledgerly-core : 0.1.0-SNAPSHOT`), pushed on `my-solutions` by 6:20 AM even if red; optional: Task 2+ → DailyTemperatures pseudocode comments → LargestRect width sentence; evening redos ValidParen (blank Nov08) + MinStack). Spring slot: [`spring-boot-labs` Chapter 1](https://github.com/PrashantSury/spring-boot-labs/tree/main/chapters/01-maven-and-the-pom). Last student code: `3019054` (7 Nov 14:11 IST) / tip `9e7058c` (10 Nov 10 PM check); 11 Nov 6 AM re-run unchanged (514 run, 46 red = the three untouched stubs; labs `Chapter01CheckTest` 1/19, no `my-solutions`). 11 Nov 8 PM evening review: no push (fourth day with no work), re-run unchanged, all tracks unscored → **one-slot days from Thu 12 Nov** (one 45-min block: labs Ch 1 Task 1). Note: day16-day19 called Task 1 "the parent"; in the chapter it is the coordinates, Task 2 is the parent. **12 Nov morning: [tasks/day21.md](archive/tasks/day21.md)**, first one-slot day: one 45-min block, labs Ch 1 Task 1 on `my-solutions` (Task 2 only if time); DSA, buggy and redos resting; no student commits since `3019054` at 6 AM (tip `0979813`). 12 Nov 8 PM evening review: no push (fifth day with no work), re-run unchanged (514 run, 46 red), all tracks unscored → Fri 13 Nov stays one-slot but **15 minutes**: Task 1 only. 12 Nov late pushes: labs `5c366dc` **18/19** (Spring 7/10) and `d6ca103` (DailyTemperatures 18/18, DSA 8/10; both redos clean, `mvn test` 514/0 red). **Fri 13 Nov first task:** labs `task1c` version → `0.1.0-SNAPSHOT`, 19/19. 12 Nov 10:26 PM: `4384b9c` fixed it, **19/19**. **13 Nov morning: [tasks/day22.md](archive/tasks/day22.md)**, still one slot (15-30 min): Chapter 1 interview question in chat (must-do); optional Chapter 2 Task 1 on `my-solutions`; DSA, buggy and redos resting; a push today brings the normal plan back Sat 14 Nov. 13 Nov: nothing landed. **14 Nov morning: [tasks/day23.md](archive/tasks/day23.md)**, one slot again (15 min): Chapter 1 interview question in chat; optional Chapter 2 Task 1; second push day still needed, then the normal plan returns the next day. 14 Nov evening and 10 PM: nothing landed (no commits, no chat answer); last scores Spring 8, DSA 8, Buggy 7. **15 Nov morning: [tasks/day24.md](archive/tasks/day24.md)**, one slot: interview Q answered in chat ~8:07-8:15 AM IST and graded **7/10** → **Chapter 1 ✅ closed** (tasks already 19/19). Spring score stays 8/10. A chat answer is not a push day; next push is Chapter 2 Task 1 on `my-solutions`. **15 Nov 8:35 AM IST:** labs `my-solutions` `1ded3b3` Chapter 2 Task 1, `Chapter02CheckTest` **3/19** (task1a/b/c green; POST 405 from Spring default), Task 1 **9/10** — this is the **second push day**, so the normal 2-hour plan returns **Mon 16 Nov**. Next: Ch 2 Task 2 (`GET /accounts`). 15 Nov evening: Spring 8/10 for the day; plan projection refreshed (overall W10-W15). **15 Nov ~10:00-10:27 PM IST:** scopes grid taught (not graded as recall; retry is today's warm-up); LargestRect empty-stack width ✅ closed (sentence **8/10** after a correction; buggy score stays 7). **Mon 16 Nov:** 1-minute scopes-grid recall, Ch 2 Tasks 2-3, Generate Parentheses, then the 15-min buggy slot is the missing `DailyTemperatures` comments. **Tue 17 Nov morning: [tasks/day26.md](archive/tasks/day26.md)**, first day of the new pace: `GenerateParentheses` ✅ 9/10 (`221069b`, 5:00 AM IST) closes the Stack pattern; 🌱 labs Ch 2 Task 4 (carried over) + Task 5; 🧩 Contains Duplicate (Arrays & Hashing 1 of 9); 🐞 Tuesday buggy round `Day05DecodeString`; evening: `DailyTemperatures` comments, then cold redos `Day03NextGreaterIndex` + `AsteroidCollision`.

```bash
mvn test          # root project: DSA and buggy rounds
```

## 🗂️ Layout
| | Path | What |
|---|---|---|
| 🧭 | `docs/PROGRAM.md`, `docs/STYLE-GUIDE.md` | operating model; markdown and spec style |
| 🧩 | `src/main/java/com/prashant/dsa/<pattern>/` | DSA solutions, tests in `src/test/java/...` |
| 🐞 | `src/main/java/com/prashant/dailytests/` and `.../redo/` | buggy rounds and redos, tests in `src/test/java/...` |
| 🏦 | `archive/banking-app/` (🅿️ parked, moved 24 Nov) | the banking project ([design](archive/banking-app/project-architecture.md)) |
| 🌱 | `archive/spring-boot/` (moved 24 Nov) | `course-practice` (foundation ✅ B2), revision workbook, graded answers — **active Spring slot from 6 Nov:** [`PrashantSury/spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) |
| 📋 | `tasks/` | one file per day, `dayNN.md`; last 5 days only, older in [`archive/tasks/`](archive/tasks) |
| 🔁 | `revision/` | `redo-schedule.md`, `mistakes/dsa.md`, `mistakes/spring.md`, index `mistake-log.md` |
| 🗄️ | `archive/` | retired SQL and the early `day02-05-morning` files ([archive/README.md](archive/README.md)) |

## 🏦 Spring Boot track
### 🧱 Banking modules (the project)
> [!NOTE]
> Order follows the concepts each module introduces ([project-architecture.md](archive/banking-app/project-architecture.md)). A module is ✅ COMPLETED only after its tests pass and the review has read the code. Milestone 0 (setup: Docker Postgres 5433, Flyway V1, health UP) is ✅ COMPLETED (24 Oct).

| # | Module | Concepts introduced | Status |
|---|---|---|---|
| 0 | Setup | Docker, Flyway V1, two DB roles, Testcontainers | ✅ COMPLETED |
| 1 | AuthN / AuthZ | Flyway V2, password hashing, JWT issue and verify, `@PreAuthorize` | ⬜ NOT_STARTED (starts after Part B2 is ✅) |
| 2 | Customer | JPA entities, validation, KYC maker-checker | ⬜ NOT_STARTED |
| 3 | Account | `NUMERIC` money, ownership checks, `@Version`, pagination | ⬜ NOT_STARTED |
| 4 | Beneficiary | uniqueness rules, soft delete, `Clock` | ⬜ NOT_STARTED |
| 5 | Transactions | `@Transactional`, optimistic vs pessimistic locking | ⬜ NOT_STARTED |
| 6 | Fund Transfers | lock ordering, idempotency, conflicts | ⬜ NOT_STARTED |
| 7 | Transaction History | projections, keyset pagination, N+1 | ⬜ NOT_STARTED |
| 8 | Notifications | domain events, `@TransactionalEventListener`, async | ⬜ NOT_STARTED |
| 9 | Statements / Reports | scheduling, batch reads, file generation | ⬜ NOT_STARTED |
| 10 | Audit / Compliance | append-only audit, trigger, `REVOKE` | ⬜ NOT_STARTED |

### 🌱 Foundation: `course-practice` and the Spring sections
| Section | Status | Evidence |
|---|---|---|
| `1 Core: IoC, DI, beans | 🟡 IN_PROGRESS | Day 02 answers 5/7/5; revision pending |
| `2 Request flow | 🟡 IN_PROGRESS | Day 04 Q1 5/10, re-answered 8/10 on 1 Nov ✅ |
| `3 Request mapping | 🟡 IN_PROGRESS | code verified 28 Oct, `course-practice` 12/12; Q3 7/10; revision pending |
| `4 HTTP semantics | 🟡 IN_PROGRESS | code verified 28 Oct; Day 03 Q1/Q2 5/10; revision pending |
| 🔥 `5 Validation and error handling | ✅ COMPLETED (5 Nov) | Part B1 ✅ (31 Oct, 15/15); **B2 ✅ (5 Nov, `1c9c6aa` + Lumi `7b7c725`)**: `course-practice` **23/23** (`StudentControllerTest` 19 + `SpringDefaultsDrillTest` 3 + context 1); `/abc` → 400 `INVALID_PARAMETER`, unknown path → 404 `RESOURCE_NOT_FOUND`, 405 keeps `Allow`; Day 04 Q1-Q3 re-answered 26/30 ✅. Q3 and Q6 of the B2 questions are still unanswered (interview side, in Pending) |
| `6 JPA · `7 Testing · `8 Config | ⬜ NOT_STARTED | taught inside the banking modules (JPA with modules 2-3, testing with every module, config with module 1); their workbook sections are answered when each is reached |

| `course-practice` task | Status | Notes |
|---|---|---|
| Day 02 endpoints | ✅ COMPLETED | rolled into Part A, verified with it |
| Day 03 / Day 04 Part A (endpoint fixes) | ✅ COMPLETED (28 Oct) | 11dfcc8 → 27b70d6 → bddf14c → af4f8e7 → 6e3d6be → c047571; `course-practice` 12/12; see [day06.md](archive/tasks/day06.md) |
| Day 04 Part B1 (`@Size` message, `exists...` queries, 409, +2 tests) | ✅ COMPLETED (31 Oct) | 71a5f07 + c344203; `course-practice` 15/15 (`StudentControllerTest` 14 + context 1). Open note: no unique constraint on `email` yet (the race), a JPA topic |
| Day 04 Part B2 (`ProblemDetail` everywhere, malformed JSON 400, +3 tests) | ✅ COMPLETED (5 Nov) | [spec](archive/tasks/day10.md#-day-04-part-b2-problemdetail-in-every-error-response). `f4cb8b9` → `0600df2` → `ff79dbf` (+ Lumi's tidy-ups) → **`1c9c6aa` (5 Nov, 15:53 IST, Drill 1)**: `MethodArgumentTypeMismatchException` → 400 `INVALID_PARAMETER`, `NoResourceFoundException` → 404 `RESOURCE_NOT_FOUND`, catch-all left last and untouched, 3 drill tests written by hand; Lumi's minor fixes `7b7c725` (stale comments, one extra assertion). **23/23.** Open note: the 404 test only asserts that `errorCode` exists, not its value |

## 🧩 DSA track (NeetCode 150 by pattern)
> [!NOTE]
> Pattern order from [neetcode.io/practice](https://neetcode.io/practice). The next pattern starts only when every problem of the current one is ✅ COMPLETED. Stub tests that pass by accident (an empty-input case on an empty method) do not count.

| Pattern | Status | Detail |
|---|---|---|
| 🔥 **Arrays & Hashing** (current, from 17 Nov) | 🟡 IN_PROGRESS | NeetCode order: Contains Duplicate ✅ (19 Nov, 17/17, day-3 skeleton 🔶) · Valid Anagram ✅ (19 Nov, 18/18 after a char-sum fix) · Two Sum ✅ (23 Nov, 19/19, `3a620f4`, near-full skeleton 🔶) · **Group Anagrams 🟡 stub + 22 tests pushed 24 Nov (0/22)** · Top K Frequent · Encode/Decode Strings · Product Except Self · Valid Sudoku · Longest Consecutive |
| Two Pointers · Sliding Window | ⬜ NOT_STARTED | skipped at the start (the program began at Stack); next after Arrays & Hashing |
| **Stack** | ✅ COMPLETED (17 Nov) | Valid Parentheses ✅ · Min Stack ✅ · Car Fleet ✅ (3 Nov, with hints) · Daily Temperatures ✅ (12 Nov, 18/18) · **Generate Parentheses** ✅ (17 Nov, 17/17, 9/10) · Evaluate RPN ✅ and Largest Rectangle ✅ as buggy rounds (`Day02RpnEvaluator`, `Day04LargestRectangle`); all stay on the redo ladder |

| Problem | Tests | My commit | Status | Notes |
|---|---|---|---|---|
| ValidParentheses | 2/2 | starter | ✅ COMPLETED | on the redo ladder |
| MinStack | 10/10 | 156a339 | ✅ COMPLETED | on the redo ladder |
| ScoreOfParentheses | 37/37 | c909bb8 | ✅ COMPLETED | follow-up questions ⬜ NOT_STARTED (answers pending) |
| RemoveKAdjacentDuplicates (Day 01) | 26/26 | 2d36911 | ✅ COMPLETED (29 Oct) | O(n) quiz 3/5 (missed the push/pop-once reasoning) → re-ask ✅ answered 5 Nov (each character pushed at most once, popped at most once, so at most 2n steps); problem itself still due its +1 redo on 7 Nov |
| AsteroidCollision (Day 02) | 28/28 | 6ddde32 + Lumi's cosmetic clean-up | ✅ COMPLETED (31 Oct) | O(n) stack, `long` for `Integer.MIN_VALUE`, input not modified |
| GenerateParentheses | **17/17** | 221069b (merge c50293d) | ✅ COMPLETED (17 Nov, 5:00 AM IST) | **9/10**: pseudocode + brute-force comment first, pruned backtracking (`open < n`, `close < open`), time/space lines with reasons; concept MCQs B B A all right; 1 off because `main` printed nothing (Lumi made it print, cosmetic); joins the redo ladder at +1 · [day25.md](archive/tasks/day25.md#-2-dsa-generate-parentheses-35-min) |
| ContainsDuplicate (Arrays & Hashing 1) | **17/17** | eeb8bb9 | ✅ COMPLETED (19 Nov, 1:50 PM IST, solved with hints 🔶 on day 3) | HashSet, early exit, null → IAE, input untouched, 10^6 in time; `contains` + `add` (two lookups) where `add`'s boolean return answers it in one; pseudocode + brute force written; pattern line "unique element" (should name hash-set membership) and time line without a reason; knowledge checks not answered; joins the redo ladder at +1 · [day28.md evening](archive/tasks/day28.md#-evening-19-nov-review-scores-tonight-and-tomorrow) |
| ValidAnagram (Arrays & Hashing 2) | **18/18** | 97dbc9f (+ b207444 pattern line; test a4bd5b6 by Lumi) | ✅ COMPLETED (19 Nov, 5:55 PM IST, after a fix) | first push (`eeb8bb9`) compared character **sums**: passed the 17 shipped tests but is wrong for `ac`/`bb` (conceptual, [mistakes/dsa.md](revision/mistakes/dsa.md)); fixed to an `int[26]` +1/-1 count with an every-slot-is-0 check; length check first; time/space lines without reasons; brute-force cost for 10^6 not stated; knowledge checks 1-3 not answered; 🔴 weak-topic pack in [day28.md evening](archive/tasks/day28.md#-weak-topic-pack-frequency-counting-counts-not-sums) |
| TwoSum (Arrays & Hashing 3) | **19/19** | 3a620f4 (+ Lumi cosmetic re-indent, 24 Nov) | ✅ COMPLETED (23 Nov, 6:11 PM IST, solved with the near-full skeleton 🔶 on day 4) | one-pass value → index map, `long` complement + range check, check-before-store, null/no-pair → IAE; pseudocode, brute-force cost (5 × 10^11) and pattern/time/space **with reasons** written; no conceptual issue; `put` overwrites duplicates (harmless here, follow-up question in chat); joins the redo ladder at +1 · [day33.md review](tasks/day33.md#-since-yesterday) |
| GroupAnagrams (Arrays & Hashing 4) | 0/22 | — (stub + tests by Lumi, 24 Nov) | ⬜ NOT_STARTED (assigned Tue 24 Nov, [day33.md](tasks/day33.md#2--dsa-group-anagrams-new-arrays--hashing-4-of-9-40-min)) | group by a canonical key (sorted letters or separator-joined counts); 22 tests incl. sum collision `ac`/`bb`, count-key delimiter collision, duplicates, empty strings, invalid chars, 20 000 × 100 within 2 s |
| CarFleet (Day 04) | 37/37 | 91cb817 + Lumi's minor fixes; comment lines in `1c9c6aa` | ✅ COMPLETED (3 Nov, with hints) | sort by position descending, cross-multiplied `long` comparison, `Deque<long[]>`; hint-assisted (pairing, exact comparison). The 3 comment lines are in; **time and space reasons accepted in chat** (5–6 Nov); Lumi refined comments on PR #1 (open, not on `main`); single-pair follow-up still owed · [review](archive/tasks/day12.md#-midday-push-review-3-nov-1737-ist) |
| DailyTemperatures (Day 15) | **18/18** | d6ca103 | ✅ COMPLETED (12 Nov, 9:01 PM IST) | decreasing stack of indices, `answer[j] = i - j`, null → IAE; time line gives the amortised reason (each index pushed once, popped at most once); brute force / re-scan question / 3-5 pseudocode lines **not written** (optional comment-only follow-up); joins the redo ladder at +1 (due 13 Nov, queued Wed 18 Nov) · [review](archive/tasks/day21.md#-late-push-review-12-nov-901-pm-ist-dailytemperatures--both-redos) |

## 🐞 Buggy problems (on the week's pattern: Arrays & Hashing this week)
| Round or redo | Type | Tests | My commit | Status | Notes |
|---|---|---|---|---|---|
| Day01ArrayStack | 🐞 buggy | 17/17 | 71ae03f | ✅ COMPLETED | fixed with hints; on the redo ladder |
| Day02RpnEvaluator | 🐞 buggy | 44/44 | 1f1be84 | ✅ COMPLETED | fixed with a hint on `-3`; on the redo ladder (reset to +1) |
| Day03NextGreaterIndex | 🐞 buggy | 37/37 | 2d36911 + bcb37f3 | ✅ COMPLETED (29 Oct) | both bugs found; stray `main()` repeated and removed |
| Day04LargestRectangle | 🐞 buggy | 36/36 | d8306e2 | ✅ COMPLETED (5 Nov) | three exact, minimal changes took 15/36 to 36/36 in one push; symptom table + `[2, 1, 2]` hand trace **graded in chat 7 Nov (supported)** — sentinel rows corrected after feedback, max 3 accepted; empty-stack width sentence ✅ **closed 15 Nov night** (8/10 after a correction; first trace used current height not popped height, logged in `revision/mistakes/dsa.md`); buggy score stays 7; joins the redo ladder at +1 · [late chat](archive/tasks/day24.md#-late-chat-1000-1027-pm-ist-scopes-grid--largestrect) |
| Day05DecodeString | 🐞 buggy | **25/25** | c61da8e | ✅ COMPLETED (19 Nov, 1:10 PM IST, day 3 with hint questions) | three minimal fixes: multi-digit `k = k*10 + d` (clamped with `long` so a huge count cannot overflow), `k = 0` after `[`, saved outer text goes **in front** at `]`; no symptom-group comment and no one-line comment per fix (the debugging write-up the task asked for); joins the redo ladder at +1 after Friday's round |
| Day06FirstUniqueCode | 🐞 buggy (Fri 20 Nov, Arrays & Hashing) | **16/20** (6/20 as shipped) | 41abb48 (21 Nov, 9:21 PM IST) | 🔴 REVISION_REQUIRED | first index whose code appears exactly once, `int[26]` counting. Fixes: validation `&&` → `\|\|` ✅, counting loop from `i = 0` ✅; third change ❌ conceptual: last loop iterates `letter` 0..25 and returns `letter` after checking `count[codes.charAt(letter) - 'a']` (alphabet index mixed with string position) → `allRepeat`, `empty`, `twoEqual` throw `StringIndexOutOfBoundsException`, `large` expected 999998 got -1; no symptom-group or per-fix comments; commit message said "completed", it isn't ([mistakes/dsa.md](revision/mistakes/dsa.md)); Sun 22 Nov guided walkthrough → 20/20 · [spec](tasks/day29.md#3b-friday-buggy-round-day06firstuniquecode-arrays--hashing-13-min-may-continue-saturday) |
| Day00BuggyExample (warm-up) | 🐞 buggy | **10/10** | c0f5d64 | ✅ COMPLETED (6 Nov) | null/empty → IAE, `Integer.MIN_VALUE` seed, loop from 0; no written symptom groups; joins redo ladder at +1 · [spec](archive/tasks/day09.md#-day00buggyexample-buggy-warm-up) |
| Day01ArrayStackRedo | 🔁 redo (day 3) | 17/17 | af4f8e7 | ✅ COMPLETED (cold, 28 Oct) | |
| Day01ArrayStackRedo7 | 🔁 redo (day 7) | 17/17 | d5c0ee9 | ✅ COMPLETED (31 Oct) | clean cold pass; Lumi removed stale TODO comments |
| Day02RpnEvaluatorRedo | 🔁 redo (day 3) | 44/44 | bddf14c | 🟡 IN_PROGRESS | passes, but done by re-reading the original, not from memory |
| Day02RpnEvaluatorRedo7 | 🔁 redo (day 7) | 44/44 | 37f6c11 | ✅ COMPLETED (31 Oct) | fixed after 3 review rounds (fall-through, end check, null guard); logged in `revision/mistakes/dsa.md`; reset to +1 |
| Day02RpnEvaluatorRedoNov01 | 🔁 redo (+1) | 44/44 | 800ad4f | ✅ COMPLETED (cold, 5 Nov) | clean cold pass, no hint: 3 comment lines, exact-match operators, `size() < 2` guard before the pops, `a` below `b`, `size() != 1` end check, null guards, `Math.*Exact`; none of the 31 Oct slips came back; moves +1 → +3 (due Sun 8 Nov) |
| ValidParenthesesRedoNov01 | 🔁 redo (+1) | **18/18** | c0f5d64 (body) · **3019054** null→IAE **in the redo** (tip `f61c7d3`) | 🟡 IN_PROGRESS 🔶 | 7 Nov post-feedback **18/18**; **not** cold-clean — same +1 gap; the cold retry is `ValidParenthesesRedoNov08` |
| MinStackRedoNov01 | 🔁 redo (+1) | **10/10** | d6ca103 | ✅ COMPLETED (cold, 12 Nov) | clean cold pass: parallel min stack, duplicates and `MIN_VALUE` safe, `IllegalStateException` on empty, O(1) with reasons; moves +1 → +3 (due Sun 15 Nov, queued Thu 19 Nov) |
| ValidParenthesesRedoNov08 | 🔁 redo (+1, repeated) | **18/18** | d6ca103 | ✅ COMPLETED (cold, 12 Nov) | clean cold pass on the blank file: null → IAE first try (7 Nov miss not repeated); complexity lines lack the one-sentence reasons (cosmetic); moves +1 → +3 (due Sun 15 Nov, queued Thu 19 Nov) |

> [!IMPORTANT]
> 🔁 Every DSA problem and buggy round is redone cold, and each result sets the next gap (clean pass 1 → 3 → 7 → 14 → 30; hint or fix repeats the gap; conceptual miss resets to day 1), at most 2 a day. A problem keeps ✅ COMPLETED for its first verified solve; the calendar and next due dates are in [redo-schedule.md](revision/redo-schedule.md).

## 🎤 Interview Q&A (see [interview-answers.md](interview-answers.md))
| Set | Status | Detail |
|---|---|---|
| Day 01 | ⬜ NOT_STARTED | no graded record |
| Day 02 | 🟡 IN_PROGRESS | 5 / 7 / 5; re-answer Q1, Q3 |
| Day 03 | 🟡 IN_PROGRESS | 17/30 (5 / 5 / 7); re-answer Q1, Q2 · [day03-answers.md](archive/spring-boot/interview-answers/day03-answers.md) |
| Day 04 | ✅ COMPLETED (1 Nov) | first attempt 15/30 (5 / 4 / 6); re-answers 26/30 (Q1 8, Q2 9, Q3 9), graded in chat · [day04-answers.md](archive/spring-boot/interview-answers/day04-answers.md) |
| Score of Parentheses follow-up | ⬜ NOT_STARTED | answers pending |
| labs Chapter 2 Task 6 (`@SpringBootApplication`) | ✅ COMPLETED (21 Nov) | code 19/19 (19 Nov); interview **7/10** in chat 21 Nov 9:38-9:40 PM IST: part 1 ✅; part 2 "gets scanned" → corrected to "not scanned → 404"; part 3 first explained why auto-config applies, then `--debug =true` (accepted) → **Chapter 2 closed** · [interview-answers.md](interview-answers.md) · [day30.md end of day](tasks/day30.md#-end-of-day) · [day28.md Task 6](archive/tasks/day28.md#-1-chapter-2-task-6-interview-the-application-class-17-min--15-min-interview) |
| labs Chapter 3 Task 6 (singleton beans, `@Component` vs `@Bean`) | 🔴 REVISION_REQUIRED (20 Nov) | written in `interview-answer.md` (`e619f82`): **5/10**, part 1 exact, part 2 fix wrong (deep copies), part 3 missing the why; re-answer + senior Q2/Q3 not given 21 Nov → **Sun 22 Nov, first task** · [interview-answers.md](interview-answers.md) · [day29.md evening](tasks/day29.md#-evening-20-nov-review-scores-tonight-and-tomorrow) |
| labs Chapter 1 (BOM / parent bump / scopes) | ✅ COMPLETED (15 Nov) | **7/10** in chat (~8:07-8:15 AM IST): part 1 BOM after a hint, part 2 upgrade risk + tests after a hint, part 3 scopes corrected then H2=`runtime` / Tomcat=`provided`. Chapter 1 closed. · [day24.md](archive/tasks/day24.md#-chapter-1-interview-grade-807-815-am-ist) |

## 📌 Pending
> [!NOTE]
> Everything not ✅ COMPLETED, in the order to work it. Pending work never disappears until it is verified. Full specs: [tasks/day09.md](archive/tasks/day09.md). Re-confirmed by the 11 Nov 6 AM session ([day20.md](archive/tasks/day20.md)): no pushes since 7 Nov, every item still open. **Next recommended (lighter day):** item 1 **Task 1 only** (the coordinates, three lines) pushed on `my-solutions` by 6:20 AM, even if red, is the one must-do; then, optional, Task 2 (parent) onward, item 2 as pseudocode comments only, item 3 in chat; evening item 4 (ValidParen first if only one fits).

> [!IMPORTANT]
> **24 Nov morning (Day 33): still 10 pending items** — 1j `TwoSum` ✅ closed (19/19, `3a620f4`), Group Anagrams opened as the new 1n. Order today: 1m Ch 3 re-answer + Q2/Q3 (🔴, written in interview-answers.md) · 1n `GroupAnagrams` (⬜ 0/22) · 1k `Day06FirstUniqueCode` (🔴 16/20, buggy slot; no new Tuesday round) · 10 redos (Asteroid morning, CarFleet evening) · then 2, 5, 6, 8, 9, 7. Spec: [day33.md](tasks/day33.md).
>
> **23 Nov morning (Day 32): still 10 pending items**, no change (no student work on 22 Nov). Order today: 1m Ch 3 re-answer + Q2/Q3 (🔴, first) · 1j `TwoSum` (⬜ 0/19, near-full skeleton) · 1k `Day06FirstUniqueCode` (🔴 16/20, buggy slot) · 10 redos (Asteroid morning, CarFleet evening) · then 2, 5, 6, 8, 9, 7 as below. Spec: [day32.md](tasks/day32.md).
>
> **21 Nov 10 PM check: 10 pending items** (1h closed tonight). In order: 1m Ch 3 re-answer + Q2/Q3 (🔴, Sun 22 first) · 1k `Day06FirstUniqueCode` (🔴 16/20, guided walkthrough) · 1j `TwoSum` (⬜ 0/19, guided walkthrough) · 10 redos (Asteroid + CarFleet Sun 22) · 2 `DailyTemperatures` comments · 5 CarFleet follow-up · 6 B2 Q3/Q6 · 8 `ScoreOfParentheses` follow-ups · 9 Day 02/03 re-answers · 7 banking module 1 (parked).

| # | Item | Track | Status |
|---|---|---|---|
| 1 | ~~`spring-boot-labs` Chapter 1 (Maven / pom, 6 tasks + interview Q)~~ | 🌱 | ✅ COMPLETED (15 Nov): tasks **19/19** on `main` `4384b9c`; interview **7/10** in chat |
| 1a | ~~`spring-boot-labs` Chapter 2 Task 1 (`GET /status` → 200, `Ledgerly is open`; POST 405 is free) on `my-solutions`~~ | 🌱 | ✅ COMPLETED (15 Nov `1ded3b3`): **3/19**, task1a/b/c green; Task 1 **9/10** |
| 1b | ~~`spring-boot-labs` Chapter 2 Tasks 2-3 (`GET /accounts`, `GET /accounts/{number}/masked`) on `my-solutions`~~ | 🌱 | ✅ COMPLETED (16 Nov `8f48e9b`): **7/19** re-verified in the evening; **8/10** |
| 1c | ~~`spring-boot-labs` Chapter 2 Tasks 4-5 (`/accounts/above`, `/fee`)~~ | 🌱 | ✅ COMPLETED (17 Nov: Task 4 exact in `393608c`; Task 5 after the `Math.min` → `Math.max` fix in `00bd2eb`, 9:33 PM IST) → **15/19**; Spring **7/10** |
| 1h | ~~`spring-boot-labs` Chapter 2 **Task 6** (application class) + its interview question~~ | 🌱 | ✅ COMPLETED (21 Nov): code 19/19 `b4a3717` (19 Nov) + interview **7/10** in chat (9:38-9:40 PM IST, after two corrections) → **Chapter 2 closed**. The 3 Ch 3 knowledge checks were not answered; they stay with item 1m |
| 1d | ~~Maven scopes grid recall (1 min, chat)~~ | 🌱 | ✅ COMPLETED (16 Nov ~9:05 PM IST, chat): grid **10/10** first try, all 12 cells; follow-up WAR MCQ missed → [mistakes/spring.md](revision/mistakes/spring.md) |
| 1e | ~~`GenerateParentheses` pseudocode + code~~ | 🧩 | ✅ COMPLETED (17 Nov `221069b`, 17/17, **9/10**) |
| 1f | ~~`ContainsDuplicate` (Arrays & Hashing 1 of 9)~~ | 🧩 | ✅ COMPLETED (19 Nov `eeb8bb9`, 17/17, solved with hints; knowledge checks still unanswered) |
| 1i | ~~`ValidAnagram` (Arrays & Hashing 2 of 9)~~ | 🧩 | ✅ COMPLETED (19 Nov `97dbc9f`, 18/18 after a char-sum fix); knowledge checks 1-3 owed in chat; weak-topic pack (frequency counting) open |
| 1g | ~~`Day05DecodeString` Tuesday buggy round~~ | 🐞 | ✅ COMPLETED (19 Nov `c61da8e`, 25/25; Friday's round unlocked) |
| 1j | ~~`TwoSum` (Arrays & Hashing 3 of 9)~~ | 🧩 | ✅ COMPLETED (23 Nov `3a620f4`, 19/19, near-full skeleton 🔶; reviewed 24 Nov morning, no conceptual issue) |
| 1n | `GroupAnagrams` (Arrays & Hashing 4 of 9) | 🧩 | ⬜ NOT_STARTED (assigned Tue 24 Nov, 0/22, [day33.md](tasks/day33.md#2--dsa-group-anagrams-new-arrays--hashing-4-of-9-40-min)) |
| 1k | `Day06FirstUniqueCode` Friday buggy round | 🐞 | 🔴 REVISION_REQUIRED (`41abb48`, 21 Nov 9:21 PM IST: **16/20**, 2 of 3 fixes right, third a conceptual miss: the last loop walks alphabet slots, not string positions; logged; no symptom-group/per-fix comments → **Sun 22 Nov guided walkthrough** → 20/20) |
| 1l | ~~`spring-boot-labs` Chapter 3 Tasks 1-5 (code)~~ | 🌱 | ✅ COMPLETED (20 Nov `e619f82`, **15/15** on a fresh clone, first push, no hint) |
| 1m | `spring-boot-labs` Chapter 3 Task 6 interview answer + senior Q2/Q3 + Ch 3 knowledge checks | 🌱 | 🔴 REVISION_REQUIRED (written answer 5/10: thread-safety fix wrong, logged in [mistakes/spring.md](revision/mistakes/spring.md); not re-answered 21 Nov → **Sun 22 Nov first task**, in chat; weak-topic pack in [day29.md evening](tasks/day29.md#-weak-topic-pack-singleton-beans-and-shared-mutable-state)) |
| 2 | `DailyTemperatures` pseudocode comments (brute force, re-scan question, 3-5 lines) | 🧩🐞 | 🟡 IN_PROGRESS (code ✅ 18/18 `d6ca103`; still not pushed at the 21 Nov 10 PM check → Sun 22 Nov, 5 min) |
| 3 | ~~Empty-stack width geometric sentence + ASCII for LargestRect `[2,1,2]`~~ | 🐞 | ✅ COMPLETED (15 Nov night, sentence **8/10** after a correction; buggy score stays 7) |
| 4 | ~~Cold `ValidParenthesesRedoNov08` then `MinStackRedoNov01`~~ | 🔁 | ✅ COMPLETED (12 Nov `d6ca103`: 18/18 and 10/10, both clean → +3) |
| 5 | `CarFleet` single-pair follow-up in chat; written reasons await PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) merge | 🧩 | 🟡 IN_PROGRESS |
| 6 | Q3 and Q6 of the B2 interview questions, and the one-sentence "why the catch-all hid Spring's own answers" | 🌱 | ⬜ NOT_STARTED |
| 7 | Banking module 1 step 1, Drills 2 and 3: **parked** (Spring slot is `spring-boot-labs`); nothing is deleted | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 8 | `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED |
| 9 | Day 02 and Day 03 re-answers (Q1, Q3 / Q1, Q2) | 🌱 | 🟡 IN_PROGRESS |
| 10 | Redos: 16 Nov `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` done but **copied, not cold** (🔶, 2/10 each) → re-queued (blank `...RedoNov23` stubs still to be created); `Day03NextGreaterIndexRedoNov17` ✅ **37/37 clean cold 19 Nov** (`2c0c2fb`); `AsteroidCollisionRedoNov17` (0/28) not attempted 17-21 Nov → **Sun 22 Nov**, cold, with `CarFleetRedoNov20` (blank stub, 0/37, not attempted 20-21 Nov); re-queued pair now **Thu 26 Nov** (RemoveK) and **Fri 27 Nov** (ScoreOf) | 🔁 | 🟡 IN_PROGRESS |

## 🎯 Weak topics
> [!NOTE]
> Classified from graded evidence so far, using the rubric in [docs/PROGRAM.md](docs/PROGRAM.md) (Strong 8-10, Moderate 6-7, Weak 0-5). The first scored evening review refreshes this table; a **weak-topic pack** (notes, 1 conceptual question, 1 implementation, 1 debugging, 1 interview scenario) is generated for each 🔴 Weak row when it is picked up.

| Track | Topic | Evidence | Class | Pack |
|---|---|---|---|---|
| 🌱 | DTO vs entity (what leaks, mass assignment) | Day 04 Q2 4/10, re-answer 9/10 (1 Nov) | 🟢 Strong | ⬜ not generated |
| 🌱 | JSON → validated DTO: which exception at which step | Day 04 Q1 5/10, re-answer 8/10 (1 Nov) | 🟢 Strong | ⬜ not generated |
| 🌱 | HTTP semantics: idempotency, DELETE twice, PUT vs PATCH, status codes | Day 02 Q3 5/10, Day 03 Q1 5/10 | 🔴 Weak | ✅ short pack 16 Nov ([day25.md evening](archive/tasks/day25.md#-weak-topic-pack-2-http-semantics-carried-short)) |
| 🌱 | `ResponseEntity` vs `@ResponseStatus`, `Location` header | Day 03 Q2 5/10 | 🔴 Weak | ✅ short pack 16 Nov ([day25.md evening](archive/tasks/day25.md#-weak-topic-pack-3-responseentity-vs-responsestatus-location-carried-short)) |
| 🌱 | `@PathVariable` / `@RequestParam` / `@RequestBody` | Day 02 Q1 5/10; 16 Nov: `@PathVariable String` right (task3a-b), but `@GetMapping("/accounts/above?balance=N")` put the query string into the path pattern ([mistakes/spring.md](revision/mistakes/spring.md)) | 🟡 Moderate (was 🔴 Weak; 17 Nov Task 4 exact: path-only mapping + `@RequestParam int balance`, `>`; Task 5 optional flag first via `required = false` on a primitive, then `defaultValue = "false"` in `00bd2eb`) | ✅ generated 16 Nov ([day25.md evening](archive/tasks/day25.md#-weak-topic-pack-1-requestparam-vs-the-path-pattern-main-pack)); Task 4 passed it |
| 🌱 | Race on unique data: check-then-save vs a DB constraint | Day 04 Q3 6/10, re-answer 9/10 (1 Nov) | 🟢 Strong | ⬜ not generated |
| 🧩 | Amortised O(n) reasoning for stack solutions | count-stack quiz 3/5 (29 Oct); re-ask answered 5 Nov: pushed at most once, popped at most once, at most 2n steps; CarFleet time/space reasons accepted in chat 5–6 Nov; written comments await PR #1 merge | 🟡 Moderate (was 🔴 Weak; 16 Nov redos wrote `O(n)` with no reason again, watch it) | ✅ generated 1 Nov ([day10.md evening](archive/tasks/day10.md#-weak-topic-pack-amortised-on-for-stack-solutions)); re-use it if it slips again |
| 🧩🐞 | RPN evaluation: operand order, `"-3"` token, end check, null guard | 3 conceptual misses on 31 Oct (day-7 redo); **5 Nov cold redo 44/44, no hint, none of the 3 misses repeated** (`800ad4f`) | 🟡 Moderate (was 🔴 Weak; Strong after a second clean pass at +3 on 8 Nov) | ✅ generated 4 Nov ([day13.md evening](archive/tasks/day13.md#️-weak-topic-pack-rpn-evaluation-new-tonight)), kept for the +3 redo |
| 🐞 | Array-backed stack boundaries (grow check, empty, capacity 0) | clean cold redo 28 Oct and 31 Oct | 🟢 Strong | none needed |
| 🐞 | Largest-rectangle empty-stack width (`width = i` vs `i - peek - 1`) | 7 Nov write-up supported; **15 Nov night closed** (sentence 8/10 after a correction). First trace used the current bar's height, not the popped bar's ([mistakes/dsa.md](revision/mistakes/dsa.md)) | 🟡 Moderate (item closed; habit still to watch on the next histogram / monotonic-stack trace) | none (Moderate) |
| 🌱 | `5 `ProblemDetail` error contract (Part B2) | 1 Nov evening 7/10: four handlers clean, but the contract changed without its tests (`main` 11/15) and the malformed-body handler is missing | 🟡 Moderate (weakest: implementation 6) | none (Moderate) |
| 🌱 | Catch-all `@ExceptionHandler(Exception.class)` and what it swallows (405, 415, type mismatch, unknown path) | 2 Nov: 500 for 405, 415 and a bad id; 3 Nov: 405/415 fixed; **5 Nov Drill 1 (`1c9c6aa`): added only the two missing handlers (type mismatch → 400, no resource → 404), catch-all untouched and last, 23/23** | 🟡 Moderate (concept 7, closed; Strong needs the one-sentence "why it hid Spring's answers" and Q6) | none (Moderate) |
| 🌱 | Maven dependency scopes (classpath grid: `runtime` vs `provided`) | 15 Nov Ch 1 interview 7/10: classpaths reversed first, then right. 15 Nov night: asked what was expected and was shown the full grid — **not graded as recall**; retry skipped in the morning, then **16 Nov ~9:05 PM IST recall 10/10** (swap fixed). Follow-up MCQ (WAR on external Tomcat, servlet API at `compile`) answered C, answer B: duplicate servlet-api copies can clash | 🟡 Moderate (grid solid; applying `provided` to a WAR deploy is the gap; Strong after one clean applied question) | none (Moderate); one applied question at the next check |
| 🧩 | Frequency counting: counts, not sums (Valid Anagram) | 19 Nov first push compared character sums (`ac`/`bb` collide); fixed after review to `int[26]` ([mistakes/dsa.md](revision/mistakes/dsa.md)). **21 Nov `Day06FirstUniqueCode` (`41abb48`): second pass walked the 26 alphabet slots and used the slot as a string index** (alphabet index vs string position), 16/20, logged | 🔴 Weak (19 Nov; missed again 21 Nov, so it stays Weak) | ✅ generated 19 Nov ([day28.md evening](archive/tasks/day28.md#-weak-topic-pack-frequency-counting-counts-not-sums)) |
| 🌱 | `@SpringBootApplication` = configuration + auto-configuration + component scan | 19 Nov Task 6 green (one annotation, day-3 skeleton); **21 Nov interview 7/10** in chat: annotations right; package-above case first wrong ("gets scanned"), corrected to not scanned → 404; `--debug` given after first answering a different question | 🟡 Moderate (7/10 after two corrections; scan boundaries are the gap) | none (Moderate) |
| 🌱 | Singleton beans and shared mutable state (thread-safety) | 20 Nov Ch 3 written answer: "not thread-safe" right, fix "deep copies of the mutable fields" wrong ([mistakes/spring.md](revision/mistakes/spring.md)) | 🔴 Weak (new 20 Nov) | ✅ generated 20 Nov ([day29.md evening](tasks/day29.md#-weak-topic-pack-singleton-beans-and-shared-mutable-state)) |
| 🌱 | Registering beans (`@Component`, `@Bean`, names, `@Primary`, prototype scope) | 20 Nov `Chapter03CheckTest` 15/15 first push, no hint; explaining `@Component` vs `@Bean` still misses "needs code to build" | 🟢 Strong (code) · 🟡 Moderate (explanation) | none needed |
| 🧩 | Complexity lines with a "because" | 19 Nov: ContainsDuplicate, ValidAnagram and the Day03 redo all wrote `O(n)` / `O(1)` with no reason (same habit as 16 Nov) | 🟡 Moderate (recurring) | none (Moderate) |

### 📝 Evening scores (out of 10, rubric in [PROGRAM.md](docs/PROGRAM.md#-evening-scoring-rubric))
> [!NOTE]
> Older evening scores (1–21 Nov) are in [archive/progress-2026-11.md](archive/progress-2026-11.md#-evening-scores-121-nov-2026). New rows go at the bottom of this table.

| Date | 🌱 Spring | 🧩 DSA | 🐞 Buggy | Evidence |
|---|---|---|---|---|
| Sun 22 Nov, evening review (~8:00 PM IST) | **unscored** (no work today; last 7) | **unscored** (no work today; last 6) | **unscored** (no work today; last 5) | No student commits today in either repo (this repo still `c85379f`, labs `my-solutions` still `e619f82`) and no chat answers; 21 Nov 10 PM re-run stands at 795 run / 88 red (`TwoSum` 0/19, `Day06` 16/20, redo stubs 0/28 + 0/37). No new mistakes or weak topics · [day31.md evening](tasks/day31.md#-evening-22-nov-review-scores-tonight-and-tomorrow) |
| Sun 22 Nov, 10 PM check | **unscored** (nothing after the review; last 7) | **unscored** (last 6) | **unscored** (last 5) | No student commits after the 8 PM review in either repo (this repo `c85379f`, labs `my-solutions` `e619f82`) and no chat answers; nothing to re-test (795 run / 88 red stands). Asteroid + CarFleet missed again → Mon 23 Nov, queue moved one slot · [day31.md end of day](tasks/day31.md#-end-of-day) |

## 📅 Weekly reviews

### 📆 Weekly review · 15–21 Nov 2026

![Week](https://img.shields.io/badge/window-15%E2%80%9321%20Nov%202026-blue) ![As of](https://img.shields.io/badge/as%20of-21%20Nov%202026%2014%3A30%20IST-yellow) ![Tracks](https://img.shields.io/badge/tracks-Spring%20%C2%B7%20DSA%20%C2%B7%20Buggy-blue) ![SQL](https://img.shields.io/badge/SQL-retired-lightgrey)

> [!IMPORTANT]
> Third dated weekly performance review under [docs/PROGRAM.md](docs/PROGRAM.md). Window **Sat 14 Nov ~14:11 IST (after `7325500`) → Sat 21 Nov ~14:30 IST**; no student work landed on 14 Nov after the cut-off, so in practice this is Sun 15–Sat 21 Nov. Sources only: commits in this repo and in [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs), this file, [redo-schedule.md](revision/redo-schedule.md), [mistakes/dsa.md](revision/mistakes/dsa.md), [mistakes/spring.md](revision/mistakes/spring.md), the Morning, Evening and End of day sections of `tasks/day24.md`–`day30.md`, and graded chat answers already recorded there. SQL stays retired and out of scope. **Data is thin for DSA and buggy:** each was scored on only one or two nights.

> [!NOTE]
> **Legend:** ✅ verified this week · 🔶 redo needed hint/fix or was not cold · ❌ missed / not attempted · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED` · tip = mentor/session commit · student = Prashant's code. **Last week** = the [8–14 Nov review](archive/progress-2026-11.md#-weekly-review--814-nov-2026). Commits in the window: this repo **35** (7 student: `d94f802`, `221069b`, `c61da8e`, `eeb8bb9`, `2c0c2fb`, `97dbc9f`, `b207444`; 2 merges; 1 Lumi test `a4bd5b6`; 25 session records), `spring-boot-labs` **8** (6 student on `my-solutions`: `1ded3b3`, `8f48e9b`, `393608c`, `00bd2eb`, `b4a3717`, `e619f82`; 1 merge; 1 mentor README `4ea21de`). The 20 Nov evening review / 10 PM notes and the 21 Nov morning session were written but are not on `main` yet (their push approvals lapsed); their graded results are used here.

#### 📊 Verified items this week vs last week

| Track | Last week (8–14 Nov) | This week (15–21 Nov, through ~14:30 IST) | Evening-score trend (scored nights only) |
|---|---|---|---|
| 🌱 Spring Boot | **1** verified: labs Ch 1 tasks 19/19 (interview open) | **Ch 1 ✅ closed** (interview **7/10** in chat, 15 Nov, two hints) · **Ch 2 code ✅ 19/19** over five pushes (`1ded3b3` 15 Nov → `8f48e9b` → `393608c` + fix `00bd2eb` → `b4a3717` 19 Nov, Task 6 on day 3 with the skeleton hint); Ch 2 stays 🟡 for the Task 6 interview + 3 checks, **unanswered since 19 Nov** · **Ch 3 code ✅ 15/15** (`e619f82`, 20 Nov, all six tasks first push, no hint); Ch 3 interview **5/10** 🔴 · scopes grid recall **10/10** (16 Nov) | last week 7 → 8 (12 Nov) · this week **9** (15 Nov Task 1) / **8** for the day → **8** (16 Nov) → **6** (17 Nov) → **7** (17 Nov after the fix) → unscored 18 Nov → **6** (19 Nov) → **7** (20 Nov). Code scores 8–10 every night; the interview dimension was **not answered** (19 Nov) and **5** (20 Nov) |
| 🧩 DSA | **1** verified: `DailyTemperatures` 18/18 | **3** verified: `GenerateParentheses` **17/17** (`221069b`, 17 Nov, 9/10) → **Stack ✅ closed**; Arrays & Hashing `ContainsDuplicate` **17/17** (`eeb8bb9`, 19 Nov, day 3 with the skeleton 🔶); `ValidAnagram` **18/18** (`97dbc9f`, 19 Nov, after a char-sum conceptual miss). `TwoSum` 0/19 open (day 2 of 2 today) | last week 8 (12 Nov) · this week unscored 15–16 Nov (copied redos are not evidence) → **8** (17 Nov) → unscored 18 Nov → **6** (19 Nov: problem solving 5, complexity 5, interview 5) → unscored 20 Nov. **8 → 6** on two scored nights |
| 🐞 Buggy | **0** | **1** round: `Day05DecodeString` **25/25** (`c61da8e`, 19 Nov, Tuesday's round on day 3) · LargestRect empty-stack width sentence ✅ closed (15 Nov, **8/10** after a correction). Friday's `Day06FirstUniqueCode` 6/20 open | last week unscored all week (last 7) · this week **7** (19 Nov: debugging 6, interview 5); flat at 7 |
| 🔁 Cold redos (separate) | 2 clean (ValidParen 18/18, MinStack 10/10) | **1 clean**: `Day03NextGreaterIndexRedoNov17` **37/37** (`2c0c2fb`, 19 Nov) → +3 · **2 🔶 not cold**: `ScoreOfParenthesesRedoNov16` 37/37 + `RemoveKAdjacentDuplicatesRedoNov16` 26/26 (`d94f802`, 16 Nov, bodies identical to the originals, 2/10 each) → repeat +1 · **❌ missed**: Asteroid (4 evenings, 17–20 Nov), CarFleet (20 Nov) | The 15 Nov projection planned **14** redos for 16–22 Nov; **1** clean cold pass so far |
| **Total** | **2** verified + 2 clean redos | **8** (Spring: Ch 1 closed, Ch 2 code, Ch 3 code, scopes recall · DSA 3 · buggy 1 round) + 1 clean redo; the LargestRect sentence closed an old write-up | suite on the 21 Nov morning re-run: **795 run, 98 red** = exactly the four open stubs (TwoSum 0/19, Day06 6/20, Asteroid redo 0/28, CarFleet redo 0/37) |

> [!NOTE]
> **Activity:** student commits on **5 of 6 full days** (Sun 15, Mon 16, Tue 17, Thu 19, Fri 20) against 1 of 6 last week. Wed 18 Nov had only a chat answer (where Task 6 lives, a findability question). Sat 21 Nov: nothing through ~14:30 IST. DSA and buggy code landed on **2 days only** (17 Nov 5:00 AM, 19 Nov); Fri 20 was labs only.

#### 🔁 Redo results

| Result | Problems | Evidence |
|---|---|---|
| ✅ Clean cold | `Day03NextGreaterIndex` (+1 → +3) | 19 Nov `2c0c2fb`, 37/37 on the blank stub, own names and messages, no hint |
| 🔶 Not cold (counts as a fail) | `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` (repeat +1) | 16 Nov `d94f802`: method bodies identical to the `dsa/stack/` originals (RemoveK imports the original class); re-queued Wed 25 Nov |
| ❌ Missed / not attempted | `AsteroidCollision` (17, 18, 19, 20 Nov), `CarFleet` (20 Nov) | 5 missed redo slots; the queue moved one day at each 10 PM check; both first on Sat 21 Nov, still 0/28 and 0/37 |
| Keep resetting / slipping | `ScoreOfParentheses` (no cold pass since its 25 Oct first solve), `RemoveKAdjacentDuplicates` (since 29 Oct), `AsteroidCollision` (never redone, due 1 Nov), `CarFleet` (never redone, due 4 Nov) | No problem reset to day 1 through a redo this week; `ValidAnagram` joins the ladder at day 1 because its first push was a conceptual miss |

#### 🧠 Recurring themes (showed up more than once)

> [!NOTE]
> Six conceptual rows were logged this week (last week: none): [mistakes/dsa.md](revision/mistakes/dsa.md) 15 Nov (LargestRect) and 19 Nov (ValidAnagram); [mistakes/spring.md](revision/mistakes/spring.md) 16 Nov (query string in a path pattern), 16 Nov (servlet API scope in a WAR), 17 Nov (`Math.min` for a floor), 20 Nov (singleton thread-safety). More work means more graded evidence, so the jump is partly a good sign.

| Theme | Where it showed (≥2 times) | Status now |
|---|---|---|
| The code encodes a different rule from the spec, and the shipped tests did not catch it | 15 Nov LargestRect trace took the height from the **current** bar, not the popped one; 17 Nov `Math.min(amount / 100, 10)` for a fee that must be **at least** 10 (commit said "completed" with `task5a`-`c` red); 19 Nov ValidAnagram compared **sums** of character codes (`ac`/`bb` collide) | 🟡 all three fixed after review; floor-vs-cap redo and the frequency-counting 🔴 pack still open |
| Explaining it lags writing it (interview dimension) | Ch 1 interview 7/10 with two hints (15 Nov); Ch 2 Task 6 interview unanswered 19 → 21 Nov; Ch 3 code 15/15 first push but written answer 5/10 (20 Nov); interview dimension **5** in all three tracks on 19 Nov and in Spring on 20 Nov; knowledge checks for `ContainsDuplicate`, `ValidAnagram` and Ch 2 unanswered | 🔴 same dimension missed twice → Weak by the rubric; Ch 3 re-answer is item 1m |
| Shared mutable state under concurrency | 20 Nov: "deep copies" given as the singleton thread-safety fix; earlier echo 31 Oct Day 04 Q3: check-then-save race left unanswered | 🔴 singleton pack in day29.md; watch it in the Ch 3 re-answer |
| Skipping the written step (carried from last week) | 16 Nov copied redos; 19 Nov DecodeString without a symptom-group write-up; 19 Nov ContainsDuplicate and ValidAnagram time lines without a reason; `DailyTemperatures` comments still not pushed | 🟡 active; the 17 Nov `GenerateParentheses` (pseudocode + brute force first, reasons on time/space, 9/10) shows the habit works when it is done |

#### 🐢 Where he's lagging

| Item | Status | Evidence |
|---|---|---|
| 🔴 `REVISION_REQUIRED` / ⛔ `BLOCKED` | 1 🔴, 0 ⛔ | Ch 3 Task 6 interview + senior Q2/Q3 (item 1m, 5/10). Blockers table empty. 🔴 Weak topics: HTTP semantics, `ResponseEntity`, singleton shared state, frequency counting (counts not sums) |
| Ch 2 Task 6 interview + 3 knowledge checks | 🟡 day 3 | code 19/19 on 19 Nov; asked at every session since; the only thing keeping Chapter 2 open |
| `TwoSum` / `Day06FirstUniqueCode` | ⬜ day 2 of 2 | assigned Fri 20 Nov; 0/19 and 6/20 at the 21 Nov morning re-run |
| `DailyTemperatures` pseudocode comments | 🟡 carried since 9 Nov | still not pushed (two weekly reviews running) |
| Redos | 🟡 behind | 1 clean of 14 planned for 16–22 Nov; Asteroid missed 4 evenings; 2 copied |
| Days with little or no activity | — | Wed 18 Nov (chat only), Sat 21 Nov so far; DSA/buggy idle on 15, 16, 18, 20 Nov |
| Older carried backlog | 🟡 / ⬜ | `CarFleet` single-pair follow-up + PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1); B2 Q3/Q6; `ScoreOfParentheses` follow-ups; Day 02/03 re-answers; banking module 1 + Drills 2–3 parked |
| vs Plan projection (15 Nov refresh + 16 Nov pace) | 🔻 DSA and buggy behind; Spring code on pace this week, closures behind | **DSA:** target 5 a week from 17 Nov; **3** verified this week (9 of the NeetCode 150 now: the 7 Stack problems + 2 Arrays & Hashing); 45–50 by mid-January needs about 5 a week from here. `ContainsDuplicate` closed on day 3 (over the 2-day rule). **Buggy:** 2 a week (Tue + Fri); **1** done. **Spring:** two chapters of code in a week (Ch 3 in one push is the 1-slot-a-chapter pace the W12 case needs), but only Ch 1 is closed; at about 2 chapters a week the remaining 38 would take about 19 weeks, past W15 |

#### 🛠️ Two or three concrete improvements for next week

| # | Improvement | Tied evidence | Suggested time-split |
|---|---|---|---|
| 1 | **Rule check before every push.** One comment line: "the rule is X; my code guarantees X because Y", plus one input of your own that would break a shortcut (`ac`/`bb`, an amount where the floor must win, the popped bar) | 3 rule-mismatch mistakes this week (15, 17, 19 Nov), each passing some tests; the 17 Nov commit said "completed" with red tests | ~3 min at the end of each slot |
| 2 | **Close the chapter the same day: answer the interview question before new code.** Say it out loud in 90 seconds, then type it in chat; no Chapter 4 until Ch 2 and Ch 3 answers are in | Ch 2 answer owed 3 days; Ch 3 15/15 vs 5/10; interview dimension 5 or unanswered on 19–20 Nov | First 10 min of the Spring slot |
| 3 | **One cold redo in the morning, not left for the evening.** Blank file, 25-min timer, before DSA; never open the original | Asteroid missed 4 evenings in a row; 1 clean of 14 planned; the 16 Nov pair was copied | ~25 min (see split) |

> [!TIP]
> **Time-split suggestion (not a schedule change):** this week the bottleneck moved. Spring code landed on 5 days; DSA and buggy on 2, and redos on 2 (one of them copied). For next week, about **Spring 40 / DSA 40 / buggy 15 / one cold redo 25** minutes of the morning (buggy only Tue and Fri; on other days its 15 minutes go to the redo or the owed write-ups), with the evening hour for review, scoring and the second redo. Revisit at the next weekly review.

> [!NOTE]
> Older weekly reviews (1–7 and 8–14 Nov) are in [archive/progress-2026-11.md](archive/progress-2026-11.md#-weekly-reviews-114-nov-2026).

## 🔁 Revision schedule
Full calendar and rules: [revision/redo-schedule.md](revision/redo-schedule.md). Conceptual mistakes: [mistakes/dsa.md](revision/mistakes/dsa.md), [mistakes/spring.md](revision/mistakes/spring.md) (no single mistakes file).

| Date | Redo 1 | Redo 2 |
|---|---|---|
| Thu 5 Nov | `Day02RpnEvaluator` (+1, late) ✅ clean 44/44 → +3 (queued 10 Nov) | `ValidParentheses` (+1) not attempted → moved to 6 Nov |
| Fri 6 Nov | `ValidParentheses` (+1) 🔶 17/18 post-feedback → stays +1 | `MinStack` (+1) not attempted → both due **7 Nov** |
| Sat 7 Nov | `ValidParentheses` (+1) 🔶 **18/18** post-feedback → same +1 | `MinStack` (+1) ❌ not attempted → both **8 Nov** |
| Sun 8 Nov | `ValidParentheses` (+1, 🔶 re-queue) ❌ not attempted | `MinStack` (+1, late) ❌ not attempted → both **9 Nov** |
| Mon 9 Nov | `ValidParentheses` (+1, blank `ValidParenthesesRedoNov08`) ❌ not attempted | `MinStack` (+1, late) ❌ not attempted → both **10 Nov** |
| Tue 10 Nov | `ValidParentheses` (+1, blank `ValidParenthesesRedoNov08`) ❌ not attempted | `MinStack` (+1, late) ❌ not attempted → both **11 Nov** |
| Wed 11 Nov | `ValidParentheses` (+1, blank `ValidParenthesesRedoNov08`) ❌ not attempted | `MinStack` (+1, late) ❌ not attempted → on hold |
| Thu 12 Nov | `ValidParentheses` (+1) ✅ **clean cold 18/18** (`ValidParenthesesRedoNov08`, `d6ca103`) → +3 | `MinStack` (+1, late) ✅ **clean cold 10/10** (`d6ca103`) → +3 |
| Fri 13 Nov | on hold (one-slot day) | on hold |
| Sat 14 Nov | on hold (one-slot day, no redos) | on hold |
| Sun 15 Nov | on hold (one-slot day, no redos) | on hold |
| Mon 16 Nov | `ScoreOfParentheses` (+1, late) 🔶 37/37 copied, not cold → repeat +1 (queued Sun 22 Nov) | `RemoveKAdjacentDuplicates` (+1, late) 🔶 26/26 copied, not cold → repeat +1 (queued Sun 22 Nov) |
| Tue 17 Nov | `Day03NextGreaterIndex` (+1, late) ❌ not attempted → Wed 18 Nov | `AsteroidCollision` (+1, late) ❌ not attempted → Wed 18 Nov |
| Wed 18 Nov | `Day03NextGreaterIndex` (+1, late) ❌ not attempted → Thu 19 Nov | `AsteroidCollision` (+1, late) ❌ not attempted → Thu 19 Nov |
| **Thu 19 Nov** | `Day03NextGreaterIndex` (+1, late) ✅ **clean cold 37/37** (`2c0c2fb`) → +3 | `AsteroidCollision` (+1, late) ❌ not attempted → Fri 20 Nov |
| **Fri 20 Nov** | `AsteroidCollision` (+1, late) ❌ not attempted (0/28) → Sat 21 Nov | `CarFleet` (+1, late) ❌ not attempted (0/37) → Sat 21 Nov |
| **Sat 21 Nov** | `AsteroidCollision` (+1, late) ❌ not attempted (0/28) → Sun 22 Nov | `CarFleet` (+1, late) ❌ not attempted (0/37) → Sun 22 Nov |
| **Sun 22 Nov** | `AsteroidCollision` (+1, late) ❌ not attempted (0/28) → Mon 23 Nov | `CarFleet` (+1, late) ❌ not attempted (0/37) → Mon 23 Nov |
| **Mon 23 Nov** | `AsteroidCollision` (+1, late) ❌ not attempted (0/28) → Tue 24 Nov | `CarFleet` (+1, late) ❌ not attempted (0/37) → Tue 24 Nov |
| Tue 24 Nov | `AsteroidCollision` (+1, late) · same blank `redo/AsteroidCollisionRedoNov17` (morning) | `CarFleet` (+1, late) · same blank `redo/CarFleetRedoNov20` (evening) |
| Wed 25 Nov | `Day04LargestRectangle` (+1, late) | `Day01ArrayStack` (+7, late) |
| Thu 26 Nov | `Day00BuggyExample` (+1, late) | `Day02RpnEvaluator` (+3, late) |
| Fri 27 Nov | `DailyTemperatures` (+1, late) | `ValidParentheses` (+3, late) |
| Sat 28 Nov | `MinStack` (+3, late) | `RemoveKAdjacentDuplicates` (+1 repeat, late) |
| Sun 29 Nov | `ScoreOfParentheses` (+1 repeat, late) | `GenerateParentheses` (+1, late) |
| Mon 30 Nov | `Day03NextGreaterIndex` (+3, late) | `AsteroidCollision` (+3, late) |

> [!WARNING]
> Redos run in the 🌙 evening, after the review and after pending morning work. The 8-11 Nov pairs were not attempted; on 12 Nov (a one-slot day) Prashant did both on his own, clean (`d6ca103`). One-slot days don't schedule redos; Sat 14 and Sun 15 Nov had none. The second push day landed 15 Nov (`1ded3b3`), so the queue resumes **Mon 16 Nov** with `ScoreOfParentheses` + `RemoveKAdjacentDuplicates`. Other dates stay as scheduled (`DailyTemperatures` Wed 18 Nov, ValidParen + MinStack Thu 19 Nov; last graduation Wed 13 Jan at the earliest, full ladder in [redo-schedule.md](revision/redo-schedule.md); **as of the 21 Nov 10 PM check: 69 redos from 22 Nov, last graduation Fri 29 Jan 2027**). The cap of 2 still applies, so `CarFleet` and `Day04LargestRectangle` (also listed on Mon 16) wait behind this pair.

## ⛔ Blockers
| Blocker | Since | Needs |
|---|---|---|
| none | | |

> [!NOTE]
> Waiting is not blocking: banking module 1 starts when Part B2 is ✅ (a dependency in the plan, not an outside obstacle). Open decisions for Prashant: where the `Beneficiary`, `Notification` and `Report` features live in the package layout (before module 4), and whether the cap of 2 redos a day stays when the evening is short.

## ▶️ Next recommended tasks

> **Tue 24 Nov, Day 33 morning ([day33.md](tasks/day33.md)):** one student commit since Day 32's session: `3a620f4` (Two Sum, 23 Nov 6:11 PM IST) → **19/19 ✅ COMPLETED** (🔶 near-full skeleton; reasons on every complexity line; no conceptual issue); no Day 32 evening review / 10 PM check on record, no graded Ch 3 answer, labs `my-solutions` still `e619f82`. Re-run 795 run / 69 red before today's files, **817 / 91** after (Group Anagrams stub 22 + Day06 4 + Asteroid 28 + CarFleet 37). Today: `git pull` → 🌱 Ch 3 re-answer **written** in interview-answers.md (warm-ups first) → 🧩 **Group Anagrams** (new, 0/22) → 🐞 `Day06` last loop (no new Tuesday round while it is 🔴) → 🔁 `AsteroidCollisionRedoNov17` cold; evening `CarFleetRedoNov20` cold. **Wed 25 Nov:** Top K Frequent (A&H 5 of 9) only once `GroupAnagramsTest` is 22/22 (otherwise Group Anagrams carries with a partial skeleton); Friday's buggy round only once `Day06` is ✅; Chapter 4 only once Ch 3 is ≥ 7. Minimum if short on time: the `Day06` last loop, pushed. DSA verified **10 of 45-50**.

> **Mon 23 Nov, Day 32 morning ([day32.md](tasks/day32.md)):** fresh-clone re-run at ~6:15 AM IST unchanged (no student commits since `41abb48`, labs `my-solutions` still `e619f82`; 795 run / 88 red = the four open files). Catch-up Monday: `git pull` → 🌱 Ch 3 re-answer part 2 + 3, senior Q2/Q3 and the floor-vs-cap line in chat (≥ 7 opens Chapter 4) → 🧩 **Two Sum carry-over** with the near-full skeleton, retyped from blank → 19/19 → 🐞 buggy slot (no round on Mondays): `Day06` last loop → 20/20 + symptom groups → 🔁 `AsteroidCollisionRedoNov17` cold (25 min) → buffer: `DailyTemperatures` comments, frequency pack. Evening: `CarFleetRedoNov20` cold. **Tue 24 Nov:** Group Anagrams (A&H 4 of 9) and the Tuesday buggy round only once Two Sum and `Day06` are ✅; Chapter 4 only once Ch 3's answer is ≥ 7. Minimum if short on time: the `Day06` last loop, pushed. DSA verified **9 of 45-50**.

> **Sun 22 Nov, evening review ([day31.md evening](tasks/day31.md#-evening-22-nov-review-scores-tonight-and-tomorrow)):** nothing landed today in either repo (this repo `c85379f`, labs `e619f82`), so all three tracks are **unscored** (no invented numbers); suite stands at 795 run / 88 red. The Day 31 morning file (push expired at 6 AM) is recreated in this commit. **Tonight:** Ch 3 re-answer part 2 in chat → `Day06` last loop → 20/20 → Two Sum guiding questions 1-3 → one cold redo if time. **Mon 23 Nov:** catch-up day, **no Chapter 4 and no new A&H problem** until Ch 3 re-answer (≥ 7), Two Sum 19/19 (near-full skeleton) and `Day06` 20/20 close; then Asteroid cold.

> **Sun 22 Nov, first task (from the 21 Nov 10 PM check, [day30.md end of day](tasks/day30.md#-end-of-day)):** `git pull` both repos. 🌱 **First:** the **Ch 3 interview re-answer** in chat: why a singleton bean's field races (fields live on the heap, shared by every request thread; locals live on each thread's own stack) + **two real fixes** (stateless bean with state in locals / request / DB; or a thread-safe type or lock for the read-modify-write, a DB `UPDATE ... SET total = total + ?` when it must survive several instances), the *why* for `@Component` vs `@Bean`, then senior Q2/Q3 + the floor-vs-cap line; no Chapter 4 yet. 🐞 **`Day06FirstUniqueCode` guided walkthrough** (16/20 → 20/20: the second pass walks string positions, not alphabet slots; symptom-group comment + one comment per fix). 🧩 **Two Sum guided walkthrough** → 19/19, then the frequency-counting exercise. 🔁 Evening: `AsteroidCollisionRedoNov17` + `CarFleetRedoNov20`, cold. Chapter 2 ✅ closed tonight (7/10). **Pending: 10.**

> **Sat 21 Nov, evening review ([day30.md evening](tasks/day30.md#-evening-21-nov-review-scores-tonight-and-tomorrow)):** nothing landed today, so all three tracks are **unscored** (no invented numbers). **Tonight:** Ch 2 Task 6 answer in chat → Two Sum guiding answers + pseudocode + brute force (push even if red) → `Day06` group A → Asteroid cold redo if time. **Sun 22 Nov:** still no Chapter 4; Ch 3 re-answer + Q2/Q3 + floor-vs-cap; **Two Sum and `Day06` close with a guided walkthrough** (past the 2-day limit), then retyped from blank and pushed; Asteroid + CarFleet first in the redo queue if missed tonight (10 PM check sets the pair).

> **Sat 21 Nov, Day 30 morning ([day30.md](tasks/day30.md)):** fresh-clone re-run at ~6:10 AM IST unchanged (no student commits or chat answers since the 20 Nov evening review; suite 795 run / 98 red = the four open stubs). Weekend: no new problem, no new buggy round, no Chapter 4. `git pull` both repos. 🌱 **First:** Ch 2 Task 6 interview answer + Ch 3 checks 1-3 in chat (closes Chapter 2), then the Ch 3 re-answer (parts 2-3) + senior Q2/Q3, then the floor-vs-cap line. 🧩 **Two Sum** day 2 of 2: guiding questions, then the partial skeleton → 19/19. 🐞 **`Day06FirstUniqueCode`** day 2: failing tests given in three symptom groups → 20/20 with one comment per fix. 🔁 `AsteroidCollisionRedoNov17` + `CarFleetRedoNov20`, cold. 📆 Weekly review ~2 PM IST. **Mon 23 Nov:** the next new DSA problem (NeetCode order) only after Two Sum is 19/19; Chapter 4 only after both interview answers are graded. **Pending: 11.**

> **Sat 21 Nov, first task (from the 20 Nov 10 PM check, [day29.md end of day](tasks/day29.md#-end-of-day)):** `git pull` both repos. 🌱 **First:** the Chapter 2 Task 6 interview answer in chat (~10 min: the three annotations inside `@SpringBootApplication` and what each does, a controller in a package above the application class, how to see why an auto-configuration did or didn't apply) + Ch 3 knowledge checks 1-3 (letters only) → closes Chapter 2. Then the Ch 3 interview re-answer (what really makes a singleton safe) + senior Q2/Q3; no Chapter 4 yet. 🧩 **Two Sum** carry-over (day 2 of 2, stronger hints), then the frequency-counting exercise + Valid Anagram checks. 🐞 `Day06FirstUniqueCode` with stronger hints + `DailyTemperatures` comments. 🔁 `AsteroidCollisionRedoNov17` + `CarFleetRedoNov20`, cold. 📆 Weekly review ~2 PM IST. **Pending: 11.**

> **Fri 20 Nov, evening review ([day29.md evening](tasks/day29.md#-evening-20-nov-review-scores-tonight-and-tomorrow)):** scores Spring **7** (Ch 3 15/15, interview answer 5/10), DSA and Buggy **unscored** (no work). **Tonight:** Ch 2 Task 6 answer + Ch 3 checks in chat → Two Sum pseudocode + brute force (push even if red) → `DailyTemperatures` comments → Asteroid cold redo if time. **Sat 21 Nov:** no Chapter 4 yet; Ch 3 interview re-answer (what makes a singleton safe) + senior Q2/Q3; Two Sum and `Day06FirstUniqueCode` carry-overs with stronger hints; frequency-counting exercise; redos most overdue first (Asteroid + CarFleet if missed); weekly review ~2 PM IST.

> **Fri 20 Nov, Day 29 morning ([day29.md](tasks/day29.md)):** fresh-clone re-run at ~6:20 AM IST unchanged (no student commits or chat answers since the 19 Nov 10 PM check). `git pull` both repos. 🌱 **First:** Ch 2 Task 6 interview answer + checks 1-3 in chat (closes Chapter 2), then **Ch 3 Tasks 1-2** (`Chapter03CheckTest` 0/15 → 4/15; stretch Tasks 3 + 5 together). 🧩 10-min weak-pack debugging exercise + Valid Anagram checks, then **Two Sum** (0/19) with a "because" on every complexity line. 🐞 `DailyTemperatures` comments, then **`Day06FirstUniqueCode`** (6/20 as shipped), symptom groups before any fix. 🔁 Evening: `AsteroidCollisionRedoNov17` + `CarFleetRedoNov20`, cold. Weekend (no new problems): carry-overs, B2 Q3/Q6, weak-pack parts 1, 2, 4, redos per the schedule.

> **Fri 20 Nov, first task (from the 19 Nov 10 PM check, [day28.md end of day](archive/tasks/day28.md#-end-of-day)):** `git pull` both repos. 🌱 **First:** the Task 6 interview answer in chat (the three annotations inside `@SpringBootApplication` and what each does, a controller in a package above the application class, plus the `--debug` add-on) and knowledge checks 1-3 → closes Chapter 2; then **Chapter 3**, starting with "Spring Boot already ___, so I only add ___". 🧩 10-min frequency-counting debugging exercise, Valid Anagram knowledge checks, then **Two Sum** with a "because" on every complexity line. 🐞 `DailyTemperatures` comments, then Friday's Arrays & Hashing round, symptom groups first. 🔁 `AsteroidCollisionRedoNov17` + `CarFleet`, cold. **Pending: 8.**

> Previous (19 Nov evening): **Thu 19 Nov, evening review ([day28.md evening](archive/tasks/day28.md#-evening-19-nov-review-scores-tonight-and-tomorrow)):** scores Spring **6**, DSA **6**, Buggy **7**; Day03 redo ✅ clean. **Tonight:** Task 6 interview answer in chat → `AsteroidCollisionRedoNov17` cold → `DailyTemperatures` comments → Valid Anagram knowledge checks. **Fri 20 Nov:** 🌱 Chapter 3 only after the Task 6 answer is graded (else that answer first); 🧩 10-min frequency-counting warm-up, then **Two Sum**; 🐞 Arrays & Hashing buggy round, symptom groups first; 🔁 CarFleet + LargestRect.

> [!IMPORTANT]
> **Thu 19 Nov, Day 28 morning ([day28.md](archive/tasks/day28.md)):** fresh-clone re-run at 6:10 AM IST unchanged (no student commits since the 10 PM check). `git pull` both repos. 🌱 **First:** Ch 2 **Task 6** (day 3, skeleton hint: one import + one annotation, the README's interview question names it) → **19/19**, run the curls, interview question in chat; then B2 Q3/Q6 + the catch-all sentence. 🧩 **Contains Duplicate** closes with the visible skeleton → 17/17, then **Valid Anagram** (pseudocode + brute force first) → 17/17. 🐞 `DailyTemperatures` comments, then `Day05DecodeString` with the symptom table + hint questions → 25/25. 🔁 Evening: cold `Day03NextGreaterIndexRedoNov17` + `AsteroidCollisionRedoNov17`. **Fri 20 Nov:** if Ch 2 is ✅, labs **Chapter 3** with the full 12-part spec; Friday buggy round (Arrays & Hashing) only if `Day05DecodeString` is ✅; next new DSA (Two Sum) only if Valid Anagram is ✅.
>
> Previous (18 Nov 10 PM): **Thu 19 Nov (from the 18 Nov 10 PM check, [day27.md end of day](archive/tasks/day27.md#-end-of-day)):** `git pull` both repos. 🌱 **First task:** labs Chapter 2 **Task 6** in `chapters/02-first-spring-boot-app/src/main/java/ledgerly/LedgerlyApplication.java` (on `my-solutions`; not `AccountController.java`) → push → **19/19**, then the Task 6 interview question in chat; Chapter 3 only after both. 🧩 Close **Contains Duplicate** with a strong-hint walkthrough in chat (~10 min, then push → 17/17; counts as solved with hints), then **Valid Anagram**, pseudocode first. 🐞 `DailyTemperatures` comments, then `Day05DecodeString` with hints. 🔁 Evening: `Day03NextGreaterIndexRedoNov17` + `AsteroidCollisionRedoNov17`, cold (CarFleet + LargestRect Fri 20 Nov). Nothing landed after the evening review; no new scores.
>
> Previous (18 Nov evening): **Wed 18 Nov, evening review:** nothing landed today (all tracks unscored). **Tonight:** Ch 2 Task 6 → 19/19, then Contains Duplicate (push even if red), then one cold redo (`Day03NextGreaterIndexRedoNov17`). **Thu 19 Nov ([day27.md evening](archive/tasks/day27.md#-tomorrows-focus-thu-19-nov-based-on-tonight)):** 🌱 Ch 2 Task 6 + interview first if still open, and Chapter 3 only after that; 🧩 close Contains Duplicate with hints in chat if red, then **Valid Anagram**; 🐞 `DailyTemperatures` comments, then close `Day05DecodeString` with hints; 🔁 whatever is left of Day03 + Asteroid first.
>
> Previous (18 Nov morning): **Wed 18 Nov ([day27.md](archive/tasks/day27.md)):** `git pull` both repos. 🌱 labs Chapter 2 **Task 6** first (one line: "Spring Boot already ___, so I only add ___"), push → **19/19**, run the README curls, then the Task 6 interview question in chat; spare Spring minutes → B2 Q3/Q6. 🧩 **Contains Duplicate** carried over (day 2 of 2): pseudocode + brute force first, hint level 1 questions, level 2 skeleton only after 15 min stuck → 17/17. 🐞 Wednesday slot (no new round): `DailyTemperatures` comments, then `Day05DecodeString` → 25/25. Evening: cold redos `Day03NextGreaterIndexRedoNov17` + `AsteroidCollisionRedoNov17`. **Thu 19 Nov:** labs Chapter 3 (12-part spec) only if Chapter 2 is 19/19 with the interview answered; **Valid Anagram** either way (Contains Duplicate, if still red, closes with hints in chat); redos `CarFleet` + `Day04LargestRectangle`.
>
> Previous (17 Nov morning): **Tue 17 Nov ([day26.md](archive/tasks/day26.md)):** `git pull` both repos. 🌱 labs Chapter 2 **Task 4** first (one line: "the path is ___, the param is ___ as ___"; path-only mapping + `@RequestParam`), push → 11/19; then **Task 5** (`/fee`, `amount` required, `express` optional default false; minimum 10 before doubling) → 15/19. 🧩 **Contains Duplicate** with pseudocode + brute force first → 17/17. 🐞 **`Day05DecodeString`** → 25/25, smallest fixes. Evening: `DailyTemperatures` comments (5 min), then cold redos `Day03NextGreaterIndexRedoNov17` + `AsteroidCollisionRedoNov17`. **Wed 18 Nov:** Chapter 2 Task 6 + its interview question (if 4-5 are ✅); DSA Valid Anagram only if Contains Duplicate is ✅ (else it carries over with a stronger hint); redos `CarFleet` + `Day04LargestRectangle`.
>
> Previous (16 Nov evening): **Tue 17 Nov (after the 16 Nov evening review, [day25.md evening](archive/tasks/day25.md#-evening-16-nov-review-scores-tonight-and-tomorrow)):** first anything still open from 16 Nov (scopes recall ✅ done 16 Nov night; `GenerateParentheses` 0/17 with pseudocode first; `DailyTemperatures` comments). 🌱 labs Chapter 2 **Task 4**: fix `@GetMapping("/accounts/above?balance=N")` → `@GetMapping("/accounts/above")` + `@RequestParam int balance` after one line "the path is ___, the param is ___"; Task 5 if time. 🔁 Evening redos, **cold on blank files**: `Day03NextGreaterIndex` + `AsteroidCollision`. Ask for a hint after 15 minutes on any step.

## 📊 Status counts
```mermaid
pie title Tracked items (1 Nov 2026)
  "COMPLETED" : 14
  "IN_PROGRESS" : 10
  "REVISION_REQUIRED" : 1
  "NOT_STARTED" : 19
  "BLOCKED" : 0
```

| Track | ✅ COMPLETED | 🟡 IN_PROGRESS | 🔴 REVISION_REQUIRED | ⬜ NOT_STARTED | ⛔ BLOCKED | Items |
|---|---|---|---|---|---|---|
| 🧩 DSA problems | 5 | 0 | 0 | 1 | 0 | 6 |
| 🐞 Buggy rounds | 3 | 0 | 0 | 2 | 0 | 5 |
| 🔁 Redo files | 3 | 3 | 0 | 0 | 0 | 6 |
| 🌱 Spring foundation (8 sections + 3 `course-practice` tasks) | 2 | 5 | 0 | 4 | 0 | 11 |
| 🏦 Banking (milestone 0 + 10 modules) | 1 | 0 | 0 | 10 | 0 | 11 |
| 🎤 Q&A sets | 0 | 2 | 1 | 2 | 0 | 5 |
| **Total** | **14** | **10** | **1** | **19** | **0** | **44** |

> [!NOTE]
> Counted from the tables on this page on 1 Nov 2026. The earlier tally (27 items, 31 Oct) did not list the ten banking modules or the redo files separately, so the totals are not comparable; the old statuses were mapped by the rule in the legend.

## 🔮 Plan projection (3 h a day)

> [!WARNING]
> **Estimate, not a promise.** Built only from this file, the [redo schedule](revision/redo-schedule.md) and the `tasks/` files, at 2 h morning + 1 h evening a day. **Refreshed every Sunday by the 10 PM check** (this one: Sun 22 Nov 2026, 10 PM, W5 D31, from data through 22 Nov; next: Sun 29 Nov). Weeks count from 23 Oct: W1 = 23-29 Oct, W2 = 30 Oct-5 Nov, W3 = 6-12 Nov, W4 = 13-19 Nov, W5 = 20-26 Nov, W6 = 27 Nov-3 Dec, W8 = 11-17 Dec, W11 = 1-7 Jan 2027, W12 = 8-14 Jan, W16 = 5-11 Feb 2027.

### 📊 Verified per week (measured, 23 Oct-22 Nov, 31 days)

| Week | Dates | 🧩 DSA | 🐞 Buggy | 🌱 Spring | 🏦 Banking | Total | 🔁 Cold redos (separate) |
|---|---|---|---|---|---|---|---|
| W1 | 23-29 Oct | 4 | 3 | 1 | 1 | 9 | 1 |
| W2 | 30 Oct-5 Nov | 2 (`AsteroidCollision`, `CarFleet`) | 1 (`Day04LargestRectangle`) | 3 (Part B1, Day 04 Q&A, Part B2) | 0 | 6 | 3 |
| W3 | 6-12 Nov | 1 (`DailyTemperatures`) | 1 (`Day00BuggyExample`) | 0 (labs Ch 1 tasks 19/19 on 12 Nov; chapter closed in W4) | 0 | 2 | 2 |
| W4 | 13-19 Nov | 3 (`GenerateParentheses`, `ContainsDuplicate`, `ValidAnagram`) | 1 (`Day05DecodeString`) | 1 (labs Chapter 1 closed 15 Nov) | 0 | 5 | 1 (`Day03NextGreaterIndexRedoNov17`; 2 more were copied, 🔶) |
| W5 (3 of 7 days) | 20-22 Nov | 0 | 0 | 1 (labs Chapter 2 closed 21 Nov: 19/19 + answer 7/10) | 0 | 1 | 0 |
| **Total** | 31 days | **10** | **6** | **6** | **1** | **23** | **7** |
| Pace per week (total × 7 / 31) | | 2.3 | 1.4 | 1.4 | 0.2 | 5.2 | 1.6 |

> [!NOTE]
> Measured pace is about flat (5.3 → **5.2** a week), but it is uneven: W4 had student commits most days (5 verified), while 20-22 Nov landed only the Ch 2 answer and `Day06` at 16/20. Labs Ch 3 code is 15/15 but the chapter is not counted until its interview answer reaches 7. `TwoSum` (0/19) and `Day06` (16/20) are open and not counted.

### 🧮 What remains

| Section | Done | Left | Detail |
|---|---|---|---|
| 🧩 NeetCode 150 | 10 (all 7 Stack + Contains Duplicate, Valid Anagram, Two Sum) | **140** | Arrays & Hashing 3 of 9 (`GroupAnagrams` open, 0/22, 24 Nov) |
| 🧩 Goal: 45-50 by mid-Jan 2027 | 10 | **35-40** | needs about **5 a week** for the 7.6 weeks to 14 Jan; measured 2.3 |
| 🐞 Buggy rounds | 6 | **2 a week planned** (Tue, Fri) | `Day06` open at 16/20; rounds follow the DSA pattern, so there is no fixed list |
| 🌱 `spring-boot-labs` | 2 of 41 chapters ✅ | **39 chapters** | Ch 3 code 15/15, interview re-answer owed; Ch 4 waits for it |
| 🏦 Banking | milestone 0 | **10 modules, parked** | not projected while the Spring slot is `spring-boot-labs` |
| 🔁 Redos | 7 clean cold passes | **69** until all 14 graduate | 14 in 23-29 Nov (cap-bound, about 5.8 h of the 7 h evening budget at ~25 min each); 16 in November; last graduation Sat 30 Jan 2027 if every pass is clean |

### 🎯 Estimated finish

| Section | Pace (best / slow, per week) | Finish week (range) | Dates |
|---|---|---|---|
| 🧩 NeetCode by mid-Jan (W12) | 2.9 / 1.15 | **about 18-31 of 150** by 14 Jan | the 45-50 goal needs the planned 5 a week; at the measured pace it lands about Mar 2027 |
| 🧩 Full NeetCode 150 (141 left) | 2.9 / 1.15 | **not inside the 12 weeks** | best case about Oct 2027 |
| 🌱 `spring-boot-labs`, 39 chapters (39 slots best, 78 slow) | 7 slots a week | **W11-W16** | about 1 Jan-9 Feb 2027 |
| ⭐ **Overall** (everything except the full NeetCode 150 and the parked banking modules) | set by `spring-boot-labs` | **W11-W16** | about 1 Jan-9 Feb 2027 · the 12-week target (W12, 14 Jan) is met only if a chapter averages **about 1.3 Spring slots or less** from Mon 23 Nov |

> [!IMPORTANT]
> **Assumptions**
> - Pace is the measured 31-day average (23 verified items), counted from Mon 23 Nov. Best = measured × 1.25; slow for DSA and buggy = half the measured pace; slow for Spring doubles the effort.
> - A labs chapter is still a guess of **1 Spring slot best, 2 slow**. Measured: Ch 1 took 6-15 Nov, Ch 2 15-21 Nov (about 1 chapter a week); at that rate the 39 chapters take most of 2027, so steady mornings matter more than speed.
> - Redos are separate and use the evening hour; every redo assumed clean, no missed days, 7 days a week. A conceptual miss resets to day 1 and adds load.
> - **Versus the 15 Nov projection (overall W10-W15):** both ends moved one week later (**W11-W16**) because 20-22 Nov closed only one Spring item and no DSA; the redo queue's last graduation moved from Fri 15 Jan to **Sat 30 Jan 2027** (two new problems joined, and 17-22 Nov slots were missed).

## 🗄️ Archive
> [!NOTE]
> **Progress history** (evening scores and log rows up to 21 Nov, weekly reviews 1–14 Nov): [archive/progress-2026-11.md](archive/progress-2026-11.md). **Old day plans** `day06`–`day28`: [archive/tasks/](archive/tasks). `tasks/` keeps the last 5 days.

> [!NOTE]
> **SQL was retired on 31 Oct 2026**: SQL files, the SQL mistake log, the SQL checker and the SQL interview questions (none were left in the active files) are kept in [archive/](archive/README.md). It is no longer assigned, tracked, graded or counted. Database topics come back only as Spring/JPA/Flyway questions. The four early `day02-05-morning` task files are archived there too (1 Nov 2026).

## 📝 Log
> [!NOTE]
> Older log rows (23 Oct – 21 Nov) are in [archive/progress-2026-11.md](archive/progress-2026-11.md#-log-23-oct--21-nov-2026). New rows go at the bottom of this table.

| Date | Week/Day | Done | Notes |
|------|----------|------|-------|
| 22 Nov 2026 | W5 D31 | 🌅 Day 31 morning session (Sunday catch-up) and 🌙 evening review (~8:00 PM IST): no student commits or chat answers today; Spring, DSA and Buggy **unscored** (last 7 / 6 / 5) | Plan in [day31.md](tasks/day31.md): Ch 3 re-answer + Q2/Q3, `Day06` and `TwoSum` guided, Asteroid + CarFleet cold. Topic classes unchanged (3 🔴 packs open, nothing blocked). Mon 23 Nov stays a catch-up day. Neither note reached the repo on the day (push approval expired); both go in with the 10 PM records. |
| 22 Nov 2026 | W5 D31 | 🌒 10 PM check: no student activity after the evening review; 📈 Sunday plan projection refreshed | No commits in either repo (this repo `c85379f`, labs `my-solutions` `e619f82`), no chat answers; suites stand (795 run / 88 red). Asteroid + CarFleet missed → Mon 23 Nov, queue moved one slot, last graduation Sat 30 Jan 2027. Projection: 23 verified in 31 days (5.2 a week); overall **W11-W16** (was W10-W15); NeetCode about 18-31 by mid-Jan against the 45-50 goal. First task Mon 23 Nov: Ch 3 re-answer in chat. Pending: 10 · [day31.md end of day](tasks/day31.md#-end-of-day) |
| 23 Nov 2026 | W5 D32 | 🌅 Day 32 morning session (catch-up Monday) | No student activity since `41abb48` (21 Nov 9:21 PM IST) in either repo; re-run 795 run / 88 red (the four open files). Plan in [day32.md](tasks/day32.md): Ch 3 re-answer + Q2/Q3, Two Sum carry-over (near-full skeleton), `Day06` last loop in the buggy slot, Asteroid cold (morning) + CarFleet cold (evening). Housekeeping: Sunday's unpushed day31.md and records pushed with this commit; PROGRESS revision-schedule mirror synced with redo-schedule.md. DSA verified 9 of 45-50. Pending: 10 |
| 24 Nov 2026 | W5 D33 | 🌅 Day 33 morning session: `TwoSum` ✅ **19/19** (`3a620f4`, 23 Nov 6:11 PM IST, near-full skeleton 🔶) reviewed; **Group Anagrams** assigned (A&H 4 of 9, stub + 22 verified tests) | No Day 32 evening review / 10 PM check on record; Mon 23 redos (Asteroid, CarFleet) not attempted → today, queue moved one day; `TwoSum` joins the ladder at +1. No new Tuesday buggy round (`Day06` 🔴 16/20). Ch 3 re-answer moved to writing in interview-answers.md. Housekeeping: `TwoSum` notes block re-indented (cosmetic). Plan in [day33.md](tasks/day33.md). DSA verified 10 of 45-50 |
