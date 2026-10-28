# 📈 Progress Log

![Plan](https://img.shields.io/badge/plan-12%20weeks-blue) ![Started](https://img.shields.io/badge/started-23%20Oct%202026-informational) ![Current](https://img.shields.io/badge/phase-Spring%20prereqs%20%2B%20SQL%20%2B%20Stack-yellow) ![Reconciled](https://img.shields.io/badge/reconciled-26%20Oct%202026-blue)

> [!NOTE]
> 12-week plan to switch back to a Java backend role (started 23 Oct 2026).

## 🗂️ Layout (Maven project, Java 17, JUnit 5)
- 🧩 `src/main/java/com/prashant/dsa/<topic>/` : DSA solutions, tests in `src/test/java/...`
- 🐞 `src/main/java/com/prashant/dailytests/` : fix-the-buggy-code rounds, tests in `src/test/java/...`
- 🗄️ `sql/` : SQL queries, one file per day
- 📋 `tasks/` : all daily task files (one file per day, `dayNN.md`, with Morning and Evening sections; earlier days are `dayNN-morning.md`)
- 🌱 `spring-boot/` : Spring Boot and microservices notes
- 🔁 `revision/` : mistake log and weekly revision notes

> [!TIP]
> Run all tests with `mvn test`.

```bash
mvn test
```

## 🧭 Operating agreement (short)
> [!IMPORTANT]
> - 📌 Nothing is complete unless **my own work is in the repo and verified** (tests pass / answers graded).
> - 📌 Statuses: ⬜ Not started · 🟡 In progress · 🟠 Attempted · 🔴 Needs correction · 🔵 Ready for revision · ✅ Completed and verified
> - 📌 Spring Boot and SQL are paired. One Spring prerequisite section at a time. Pending work never disappears.

## 🎯 Current phase
- **Phase:** Week 1 foundations — Spring Boot prerequisites (`course-practice` Students API) + SQL (banking-flavoured) + DSA Stack. Banking app setup is done (health UP); hand-written V2 migrations have not started.
- 🔥 **Active Spring section:** §5 Validation & error handling (Day 04 Part B). §3 and §4 are code-verified (Part A ✅, 28 Oct), pending revision because the Day 03 Q1/Q2 answers scored 5/10. You've already started Part B (`@Size`, `DuplicateEmailException`).
- ✅ **Sections completed:** none yet. The Revision log in `spring-boot/prerequisites.md` is still empty.

| Section | Status |
|---|---|
| §1 Core: IoC, DI, beans | 🔵 Ready for revision (Day 02 answers graded 5/7/5) |
| §2 Request flow | 🟡 In progress (Day 04 Q1 pending) |
| §3 Request mapping | 🔵 Ready for revision (code verified 28 Oct, `course-practice` 12/12; Q3 7/10) |
| §4 HTTP semantics | 🔵 Ready for revision (code verified 28 Oct; Day 03 Q1/Q2 scored 5/10) |
| §5 Validation & error handling | 🟡 In progress (Day 04 Part B started: `@Size`, `DuplicateEmailException`) |
| §6 JPA · §7 Testing · §8 Config | ⬜ Not started |

## 🧩 DSA & 🐞 buggy rounds
> [!NOTE]
> Verified by running each test class against my current code on 26 Oct 2026. Authorship from git log (`Day NN: ...` commits are the routine's stubs).

| Item | Type | Tests | My commit | Status |
|---|---|---|---|---|
| ValidParentheses | DSA | 2/2 | starter | ✅ Completed and verified |
| MinStack | DSA | 10/10 | 156a339 | ✅ Completed and verified |
| ScoreOfParentheses | DSA | 37/37 | c909bb8 | ✅ Completed and verified · follow-up Qs ⬜ pending |
| RemoveKAdjacentDuplicates | DSA (Day 01) | 0/26 | — (stub only) | ⬜ Not started · assigned Day 05 evening, still 0/26 at 10 PM on 28 Oct · 🔥 assigned Day 06 evening, carried to Day 07 ([day06.md](tasks/day06.md)) |
| AsteroidCollision | DSA (Day 02) | 8/28 | — (stub only) | ⬜ Not started |
| CarFleet | DSA (Day 04) | 2/37 | — (stub only) | ⬜ Not started |
| Day01ArrayStack | 🐞 Buggy round | 17/17 | 71ae03f | ✅ Fixed (with hints) · 🔵 redo due 26 Oct + 30 Oct |
| Day02RpnEvaluator | 🐞 Buggy round | 44/44 | 1f1be84 | ✅ Fixed (hint on `-3`) · 🔵 redo due 27 Oct + 31 Oct |
| Day02RpnEvaluatorRedo | 🔁 Redo (day 3) | 44/44 | bddf14c | 🟠 Attempted · passes, but done by re-reading the original, not from memory · 🔵 cold redo due 31 Oct |
| Day01ArrayStackRedo | 🔁 Redo (overdue from 26 Oct) | 17/17 | af4f8e7 | ✅ Completed and verified (cold redo, 28 Oct) · next revision 30 Oct stays |
| Day03NextGreaterIndex | 🐞 Buggy round | 13/37 | — | ⬜ Not started |
| Day04LargestRectangle | 🐞 Buggy round | 15/36 | — | ⬜ Not started |

> [!TIP]
> Stub tests that pass by accident (e.g. empty-input cases) don't count as progress.

## 🧭 NeetCode 150 tracker
> [!NOTE]
> Pattern order from [neetcode.io/practice](https://neetcode.io/practice). The next pattern starts only when every problem here is ✅. Buggy rounds use the current pattern.

| Pattern | Status |
|---|---|
| Arrays & Hashing | ⬜ Not started (skipped for now; started at Stack) |
| Two Pointers · Sliding Window | ⬜ Not started |
| 🔥 **Stack** (current) | 🟡 In progress: Valid Parentheses ✅ · Min Stack ✅ · Car Fleet ⬜ · Evaluate RPN, Generate Parentheses, Daily Temperatures, Largest Rectangle ⬜ not yet assigned as problems |

## 🐞 Daily-test bug backlog
| Day | Problem | Topic | Original mistake | Correct approach | Status | Next revision |
|---|---|---|---|---|---|---|
| 01 | Day01ArrayStack | Array stack | Grow check `>` vs `>=`, `size < 0` empty check, zero capacity never grows | Trace checks with 0, 1, full array | 🔵 Ready for revision | 26 Oct, 30 Oct |
| 02 | Day02RpnEvaluator | Stack / RPN | `-3` treated as operator; overflow; end check | Check whole token; `multiplyExact`; `size() != 1` | 🔵 Ready for revision | 27 Oct, 31 Oct |
| 03 | Day03NextGreaterIndex | Monotonic stack | not attempted | — | ⬜ Not started | — |
| 04 | Day04LargestRectangle | Monotonic stack | not attempted | — | ⬜ Not started | — |

## 🗄️ SQL
| Exercise | File | Answers in file? | Status |
|---|---|---|---|
| Day 01 practice | `sql/day01.sql` | no (examples only) | ⬜ Not started |
| SQL 01 test | `sql/day01-test.sql` | no | ⬜ Not started |
| SQL 02 | `sql/day02.sql` | no | ⬜ Not started |
| SQL 03 (branch max + net flow) | `sql/day03.sql` | no | ⬜ Not started · Q1 assigned Day 05 evening, no `sql/day03-answers.md` at 10 PM on 28 Oct · 🔥 assigned Day 06 evening, carried to Day 07 ([day06.md](tasks/day06.md)) |
| SQL 04 (loans + anti-join) | `sql/day04.sql` | no | ⬜ Not started |

## 🌱 Spring tasks (`spring-boot/course-practice`)
| Task | Status | Notes |
|---|---|---|
| Day 02 endpoints | ✅ Rolled into Day 03 Part A | Verified together with Part A |
| Day 03 / Day 04 Part A (endpoint fixes) | ✅ Completed and verified (28 Oct) | 11dfcc8 → 27b70d6 → bddf14c → af4f8e7 → 6e3d6be → c047571. `course-practice` 12/12 (`StudentControllerTest` 11 + context test 1). `/search` mapping, DELETE 204, not-found in service, PUT unknown id → 404, search without `name` → 400, `@Valid`/dead branch removed from `search`, stray `main()` removed from `Day02RpnEvaluator`. See [day06.md](tasks/day06.md) |
| Day 04 Part B (`@Size`, 409, ProblemDetail, +5 tests) | 🟡 In progress · 🔥 active | `@Size` and `DuplicateEmailException` already in the repo. Still to verify: 409 handler with `ProblemDetail`, +5 tests |

## 🏦 Banking-app milestones (`banking-app/`)
| # | Milestone | Status |
|---|---|---|
| 0 | Setup: Docker Postgres 5433, Flyway, health UP | ✅ Completed and verified |
| 1 | Auth tables (V2: users, roles, permissions) + login returning a JWT | ⬜ Not started · §3/§4 code-verified · waits for §5 (Day 04 Part B) |
| 2 | Customers and accounts | ⬜ Not started |
| 3 | Transactions with locking and idempotency | ⬜ Not started |
| 4 | Admin and audit | ⬜ Not started |

> [!NOTE]
> 🔗 SQL pairing: §3/§4 pair with `sql/day03.sql` (branch max + net flow, banking tables). Milestone 1 will pair with SQL on the auth tables.

## 🎤 Interview Q&A → see [interview-answers.md](interview-answers.md)
| Set | Status |
|---|---|
| Day 01 | ⬜ Not started (no graded file found) |
| Day 02 | ✅ Graded (5 / 7 / 5) · 🔵 Q1, Q3 ready for revision |
| Day 03 | ✅ Graded 17/30 (5 / 5 / 7) · 🔵 Q1, Q2 ready for revision · [day03-answers.md](spring-boot/interview-answers/day03-answers.md) |
| Day 04 | ⬜ Pending |
| Score of Parentheses follow-up | ⬜ Pending |

## 📊 Status counts
```mermaid
pie title Tracked items (28 Oct 2026)
  "Completed and verified" : 6
  "Ready for revision" : 6
  "Needs correction" : 0
  "In progress" : 2
  "Attempted" : 1
  "Not started" : 15
```

> [!NOTE]
> Counts are adjusted from the 28 Oct morning tally: Part A and Day01ArrayStackRedo moved to Completed, §3, §4 and the Day 03 Q&A set to Ready for revision, §5 to In progress.

## ▶️ Next session starts with
> [!IMPORTANT]
> **Next task (29 Oct, 6 AM):** **Day 04 Part B** in `spring-boot/course-practice`: finish the 409 handler with `ProblemDetail`, add `@Size` coverage and the email-exists queries, and add the +5 tests. Full list in [day04-morning.md](tasks/day04-morning.md). You've already started it (`@Size`, `DuplicateEmailException`).
>
> **Still carried from Day 06 evening (third time, no pressure, it simply stays in the queue):**
> 1. 🧩 DSA: `RemoveKAdjacentDuplicates` (LeetCode 1209), 0/26 → 26/26.
> 2. 🗄️ SQL: `sql/day03.sql` **Q1** only (answer in `sql/day03-answers.md`).
>
> 🔁 Revision due: `Day01ArrayStack` redo on 30 Oct, cold `Day02RpnEvaluator` redo on 31 Oct, and Day 03 Q1/Q2 re-answers.
>
> No new DSA stub while 3 DSA problems are not started; no new SQL file while 5 are unanswered.

## 📝 Log
| Date | Week/Day | Done | Notes |
|------|----------|------|-------|
| 23 Oct 2026 | W1 D1 | Valid Parentheses (understood); Min Stack done, 10/10 tests passing | Two-stack approach, O(1) ops. Next: space-optimized version (push to mins only when x <= min) |
| 25 Oct 2026 | W1 D3 | ScoreOfParentheses 37/37 (c909bb8) | Got help writing; dry-ran line by line. Follow-up Qs pending |
| 26 Oct 2026 | W1 D4 | Day 03 Spring Part A pushed (11dfcc8) | Needs correction: /search, DELETE 204, tests |
| 26 Oct 2026 | — | Backlog reconciliation | This file + interview-answers.md |
| 27 Oct 2026 | W1 D5 | Morning round assigned (backlog only) | Day 03 Part A corrections + Day02 RPN redo stub. No new buggy round (Day 03/04 unattempted), no new Spring task (§3/§4 open) |
| 27 Oct 2026 | W1 D5 | Spring Part A mostly fixed (27b70d6, bddf14c); RPN redo 44/44 but not from memory | Evening: backlog only — RemoveKAdjacentDuplicates + SQL 03 Q1. Verified with `mvn test` (328 tests; my finished classes all green) |
| 27 Oct 2026 | W1 D5 | 10 PM check: no new pushes after the evening assignment | `RemoveKAdjacentDuplicates` still 0/26, no `sql/day03-answers.md`; both carried to Day 06 evening. Re-verified: Day02RpnEvaluator 44/44, Redo 44/44 (🟠 Attempted), StudentControllerTest 9/9 |
| 28 Oct 2026 | W1 D6 | Morning round assigned (backlog only) | Finish Part A (2 tests + 2 clean-ups) + `Day01ArrayStackRedo` stub (0/17, verified 17/17 against a correct version). No new buggy round (Day 03/04 unattempted), no new Spring task (§3/§4 open) |
| 28 Oct 2026 | W1 D6 | Day 03/04 Part A ✅ verified (af4f8e7, 6e3d6be, c047571); `Day01ArrayStackRedo` 17/17 ✅; Day 03 Q&A graded 17/30 | Verified with `mvn test`: `course-practice` 12/12, `Day01ArrayStackRedoTest` 17/17, `Day02RpnEvaluatorTest` 44/44, `Day02RpnEvaluatorRedoTest` 44/44 (still 🟠 Attempted, cold redo 31 Oct). `tasks/` moved to the repo root. §3/§4 Ready for revision (Q1/Q2 5/10); active section is now §5 |
| 28 Oct 2026 | W1 D6 | Evening session assigned (backlog only) | Re-checked at 8 PM: `RemoveKAdjacentDuplicatesTest` 0/26, no `sql/day03-answers.md`. Both assigned again in `tasks/day06.md` (renamed from `day06-morning.md`, now Morning + Evening). No new stub or SQL file (3 DSA not started, 5 SQL unanswered) |
| 28 Oct 2026 | W1 D6 | 10 PM check: no new pushes after the evening assignment | Re-verified with `mvn test`: `course-practice` 12/12, `Day01ArrayStackRedoTest` 17/17, `Day02RpnEvaluatorTest` 44/44, `Day02RpnEvaluatorRedoTest` 44/44. `RemoveKAdjacentDuplicatesTest` still 0/26, no `sql/day03-answers.md`; both carried to Day 07 evening. No new mistakes. Next: Day 04 Part B |
