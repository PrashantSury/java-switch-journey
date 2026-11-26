# 📈 Progress

Last updated: Thu 26 Nov 2026 (Day 35, evening review)

## 🧩 DSA

**Verified: 10 of 45–50** by mid-Jan 2027 (re-checked 26 Nov evening: `mvn test` 728/728 green) · details per problem in [PROBLEMS.md](PROBLEMS.md)

| Problem | Pattern | Status | Tests | Solved | Notes |
|---|---|---|---|---|---|
| ValidParentheses | Stack | ✅ | 20/20 | | |
| MinStack | Stack | ✅ | 10/10 | | |
| ScoreOfParentheses | Stack | ✅ | 37/37 | 25 Oct | with help; follow-ups open |
| RemoveKAdjacentDuplicates | Stack | ✅ | 26/26 | 29 Oct | |
| AsteroidCollision | Stack | ✅ | 28/28 | 31 Oct | |
| CarFleet | Stack | ✅ | 37/37 | 3 Nov | hints 🔶 |
| DailyTemperatures | Monotonic stack | ✅ | 18/18 | 12 Nov | comments open |
| GenerateParentheses | Backtracking | ✅ | 17/17 | 17 Nov | 9/10 |
| ContainsDuplicate | Arrays & Hashing | ✅ | 17/17 | 19 Nov | hints 🔶 |
| ValidAnagram | Arrays & Hashing | ✅ | 18/18 | 19 Nov | sums ❌ → fixed |
| TwoSum | Arrays & Hashing | ✅ | 19/19 | 23 Nov | skeleton 🔶 |
| GroupAnagrams | Arrays & Hashing | ⬜ | 0/22 | | assigned 24 Nov; day 3 (26 Nov) not pushed; full skeleton, 3 blanks |

**Open now:** GroupAnagrams (Arrays & Hashing 4 of 9), 0/22, day 3: full skeleton, no new problem until ✅ · [day35.md](tasks/day35.md)

**Weak spots**
- Frequency counting: counts, not sums (ValidAnagram)
- Solving without the skeleton: TwoSum closed on day 4, problem solving 4/10
- Interview explanation: 5/10 (23 Nov)

## 🐞 Buggy

| Round | Problem | Status | Score | Notes |
|---|---|---|---|---|
| Day00 | max with edge cases | ✅ 10/10 | 7 | 6 Nov |
| Day01 | array-backed stack | ✅ 17/17 | | hints 🔶 |
| Day02 | Evaluate RPN | ✅ 44/44 | | hint on `-3` |
| Day03 | next greater index | ✅ 37/37 | | 29 Oct |
| Day04 | largest rectangle | ✅ 36/36 | 7 | 5 Nov |
| Day05 | decode string | ✅ 25/25 | 7 | 19 Nov |
| Day06 | first unique code | 🔴 16/20 | 5 | last loop open |

**Open now:** Day06 last loop → 20/20 (open since 21 Nov, loop header given, [day35.md](tasks/day35.md)); Fri 27 Nov `Buggy07` stays parked until it is ✅

**Weak spots**
- Loop index: alphabet index mixed with string position (Day06)
- No symptom-group or per-fix comments (Day05, Day06)

## 🏦 Banking app

Tracked daily · code [`banking-app/`](banking-app/) · tasks [TASKS.md](banking-app/TASKS.md)
Run `mvn -f banking-app/pom.xml verify` (Docker running)

| Module | Goal | Status | Tests | Notes |
|---|---|---|---|---|
| 0 Setup | Docker Postgres 5433, Flyway V1, 2 DB roles | ✅ | 1/1 | `BankingApplicationIT` |
| 1 AuthN / AuthZ | login → JWT; 401 / 403 / 200 | 🟡 | 0/2 | 8 tasks; 1.1 assigned 24 Nov, not pushed 24-26 Nov |
| 2 Customer | JPA entities, validation, KYC maker-checker | ⬜ | | |
| 3 Account | `NUMERIC` money, owner checks, `@Version`, paging | ⬜ | | |
| 4 Beneficiary | uniqueness, soft delete, `Clock` | ⬜ | | |
| 5 Transactions | `@Transactional`, locking | ⬜ | | |
| 6 Fund Transfers | lock order, idempotency | ⬜ | | |
| 7 Transaction History | projections, keyset paging, N+1 | ⬜ | | |
| 8 Notifications | domain events, async | ⬜ | | |
| 9 Statements / Reports | scheduled jobs, batch reads | ⬜ | | |
| 10 Audit / Compliance | append-only audit, trigger, `REVOKE` | ⬜ | | |

**Open now:** Task 1.1 V2 auth tables + `AuthSchemaIT` (0/2), day 3 Thu 26 Nov (decision table) · [day35.md](tasks/day35.md)

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
| Fri 27 Nov | AsteroidCollision (+1) | CarFleet (+1) |
| Sat 28 Nov | Day04LargestRectangle (+1) | Day01ArrayStack (+7) |
| Sun 29 Nov | Day00BuggyExample (+1) | Day02RpnEvaluator (+3) |
| Mon 30 Nov | DailyTemperatures (+1) | ValidParentheses (+3) |

## 📈 Scores (last 7 days)

| Date | DSA | Buggy | Banking |
|---|---|---|---|
| Fri 20 Nov | — | — | — |
| Sat 21 Nov | — | 5 | — |
| Sun 22 Nov | — | — | — |
| Mon 23 Nov | 6 | — | — |
| Tue 24 Nov | — | — | — |
| Wed 25 Nov | — | — | — |
| Thu 26 Nov | — | — | — |

## 📦 History

- [progress-2026-11.md](archive/progress-2026-11.md): scores, logs, weekly reviews, old detailed PROGRESS
- Old day plans: [archive/tasks/](archive/tasks/) · mistakes: [mistake-log.md](revision/mistake-log.md)
