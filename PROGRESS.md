# 📈 Progress

Last updated: Sat 28 Nov 2026 (Day 37, morning session)

## 🧩 DSA

**Verified: 11 of 45–50** by mid-Jan 2027 (re-checked 28 Nov morning, fresh clone at `477401a`: `mvn test` 807/807 green; `-Popen` 64 run / 64 red, the two redo stubs) · details per problem in [PROBLEMS.md](PROBLEMS.md)

| Problem | Pattern | Status | Tests | Solved | Notes |
|---|---|---|---|---|---|
| ValidParentheses | Stack | ✅ | 20/20 | | |
| MinStack | Stack | ✅ | 10/10 | | |
| ScoreOfParentheses | Stack | ✅ | 37/37 | 25 Oct | with help; follow-ups open |
| RemoveKAdjacentDuplicates | Stack | ✅ | 26/26 | 29 Oct | |
| AsteroidCollision | Stack | ✅ | 28/28 | 31 Oct | comments added 27 Nov; redo still 0/28 |
| CarFleet | Stack | ✅ | 37/37 | 3 Nov | hints 🔶 · redo 27 Nov 🔶 not cold |
| DailyTemperatures | Monotonic stack | ✅ | 18/18 | 12 Nov | pseudocode comments ✅ 27 Nov |
| GenerateParentheses | Backtracking | ✅ | 17/17 | 17 Nov | 9/10 |
| ContainsDuplicate | Arrays & Hashing | ✅ | 17/17 | 19 Nov | hints 🔶 |
| ValidAnagram | Arrays & Hashing | ✅ | 18/18 | 19 Nov | sums ❌ → fixed |
| TwoSum | Arrays & Hashing | ✅ | 19/19 | 23 Nov | skeleton 🔶 |
| GroupAnagrams | Arrays & Hashing | ✅ | 22/22 | 27 Nov | day 4, full skeleton 🔶; a-z IAE guard `a7ba6d5` |

**Open now:** no open DSA problem; next new one (A&H 5 of 9) Mon 30 Nov · today: cold-recall pack + Asteroid 0/28 and LargestRect 0/36 cold redos · [day37.md](tasks/day37.md)

**Weak spots**
- 🔴 Cold recall: redos copied (ScoreOf, RemoveK 16 Nov; CarFleet 27 Nov) or skipped (Asteroid, due since 1 Nov) · pack in [day37.md item 1](tasks/day37.md#1--cold-recall-pack-weekend-review-15-min)
- Solving without the skeleton: TwoSum and GroupAnagrams both closed on day 4 with the full skeleton (frequency counting 🟡: Q1, Q11, count key right)
- Spec guards: GroupAnagrams a-z IAE added only after review (`a7ba6d5`); read every "throws" line of the spec first

## 🐞 Buggy

| Round | Problem | Status | Score | Notes |
|---|---|---|---|---|
| Day00 | max with edge cases | ✅ 10/10 | 7 | 6 Nov |
| Day01 | array-backed stack | ✅ 17/17 | | hints 🔶 |
| Day02 | Evaluate RPN | ✅ 44/44 | | hint on `-3` |
| Day03 | next greater index | ✅ 37/37 | | 29 Oct |
| Day04 | largest rectangle | ✅ 36/36 | 7 | 5 Nov |
| Day05 | decode string | ✅ 25/25 | 7 | 19 Nov |
| Day06 | first unique code | ✅ 20/20 | 8 | 27 Nov; last loop bound was `26`; Q10 🔶 |

**Open now:** none (Sat: write-ups Q6-Q7 in [day37.md](tasks/day37.md)). `Buggy07` unblocked, planned Tue 1 Dec.

**Weak spots**
- Loop index vs string position (Day06 code fixed 27 Nov; Q10 still 🔶 at 9:34 PM: said AIOOBE, it is `StringIndexOutOfBoundsException`; missed the silent wrong answer on 30 chars) · logged in [mistakes/dsa.md](revision/mistakes/dsa.md)
- No symptom-group or per-fix comments (Day05, Day06)

## 🏦 Banking app

Tracked daily · code [`banking-app/`](banking-app/) · tasks [TASKS.md](banking-app/TASKS.md)
Run `mvn -f banking-app/pom.xml verify` (Docker running)

| Module | Goal | Status | Tests | Notes |
|---|---|---|---|---|
| 0 Setup | Docker Postgres 5433, Flyway V1, 2 DB roles | ✅ | 1/1 | `BankingApplicationIT` |
| 1 AuthN / AuthZ | login → JWT; 401 / 403 / 200 | 🟡 | 0/2 | 8 tasks; 1.1 day 5 (4-step build order): Q4–Q7 ✅ 27 Nov, no V2 / `AuthSchemaIT` code yet |
| 2 Customer | JPA entities, validation, KYC maker-checker | ⬜ | | |
| 3 Account | `NUMERIC` money, owner checks, `@Version`, paging | ⬜ | | |
| 4 Beneficiary | uniqueness, soft delete, `Clock` | ⬜ | | |
| 5 Transactions | `@Transactional`, locking | ⬜ | | |
| 6 Fund Transfers | lock order, idempotency | ⬜ | | |
| 7 Transaction History | projections, keyset paging, N+1 | ⬜ | | |
| 8 Notifications | domain events, async | ⬜ | | |
| 9 Statements / Reports | scheduled jobs, batch reads | ⬜ | | |
| 10 Audit / Compliance | append-only audit, trigger, `REVOKE` | ⬜ | | |

**Open now:** Task 1.1 V2 auth tables + `AuthSchemaIT` (0/2), day 5 Sat 28: push after step 2 (`users` + test 2) · [day37.md](tasks/day37.md)

**Weak spots** (from Spring history)
- HTTP semantics: status codes, idempotency, PUT vs PATCH
- `ResponseEntity` vs `@ResponseStatus`, `Location` header
- Singleton beans and shared mutable state

spring-boot-labs chapters: paused at Ch 3 (re-answer open) ·
[TASKS.md](https://github.com/PrashantSury/spring-boot-labs/blob/my-solutions/TASKS.md)

## 🔁 Redos

Next due (cold, max 2 a day) · full calendar: [redo-schedule.md](revision/redo-schedule.md)

| Date | Redo 1 | Redo 2 |
|---|---|---|
| Sat 28 Nov | AsteroidCollision (+1, ⏰ due 1 Nov) 0/28, cold in `AsteroidCollisionRedoNov17` | Day04LargestRectangle (+1) 0/36, cold in `Day04LargestRectangleRedoNov28` |
| Sun 29 Nov | Day01ArrayStack (+7) | Day00BuggyExample (+1) |
| Mon 30 Nov | Day02RpnEvaluator (+3) | DailyTemperatures (+1) |
| Tue 1 Dec | ValidParentheses (+3) | MinStack (+3) |
| Sun 6 Dec | CarFleet (+1 repeat, new blank stub) | GroupAnagrams (+1, new) |

Missed today → Sun 29 = Asteroid + Day04, every later row moves one day.

## 📈 Scores (last 7 days)

| Date | DSA | Buggy | Banking |
|---|---|---|---|
| Sat 21 Nov | — | 5 | — |
| Sun 22 Nov | — | — | — |
| Mon 23 Nov | 6 | — | — |
| Tue 24 Nov | — | — | — |
| Wed 25 Nov | — | — | — |
| Thu 26 Nov | — | — | — |
| Fri 27 Nov | 8 | 8 | — |

## 📦 History

- [progress-2026-11.md](archive/progress-2026-11.md): scores, logs, weekly reviews, old detailed PROGRESS
- Old day plans: [archive/tasks/](archive/tasks/) · mistakes: [mistake-log.md](revision/mistake-log.md)
