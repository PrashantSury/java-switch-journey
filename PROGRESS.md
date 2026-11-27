# 📈 Progress

Last updated: Fri 27 Nov 2026 (Day 36, afternoon push review ~5:25 PM IST)

## 🧩 DSA

**Verified: 10 of 45–50** by mid-Jan 2027 (re-checked 27 Nov afternoon: `mvn test` 785/785 green after open-stubs update) · details per problem in [PROBLEMS.md](PROBLEMS.md)

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
| GroupAnagrams | Arrays & Hashing | 🟡 | 20/22 | | assigned 24 Nov; day 4: count-key + `#` separator; missing IAE for non-a-z |

**Open now:** GroupAnagrams 20/22, missing `'a'-'z'` guard (`uppercase`, `otherCharacters` throw AIOOBE, tests expect IAE) · [day36.md](tasks/day36.md)

**Weak spots**
- Frequency counting: counts, not sums (ValidAnagram); Q11 today was solid
- Solving without the skeleton: TwoSum and GroupAnagrams both closed (or nearly) on day 4
- Invalid-char guard: GroupAnagrams 20/22, `char - 'a'` on `'B'` is -31

## 🐞 Buggy

| Round | Problem | Status | Score | Notes |
|---|---|---|---|---|
| Day00 | max with edge cases | ✅ 10/10 | 7 | 6 Nov |
| Day01 | array-backed stack | ✅ 17/17 | | hints 🔶 |
| Day02 | Evaluate RPN | ✅ 44/44 | | hint on `-3` |
| Day03 | next greater index | ✅ 37/37 | | 29 Oct |
| Day04 | largest rectangle | ✅ 36/36 | 7 | 5 Nov |
| Day05 | decode string | ✅ 25/25 | 7 | 19 Nov |
| Day06 | first unique code | ✅ 20/20 | 8 | 27 Nov; last loop bound was `26` |

**Open now:** none. `Buggy07` unblocked, planned Tue 1 Dec.

**Weak spots**
- Loop index: alphabet index mixed with string position (Day06, fixed 27 Nov) — watch it
- No symptom-group or per-fix comments (Day05, Day06)

## 🏦 Banking app

Tracked daily · code [`banking-app/`](banking-app/) · tasks [TASKS.md](banking-app/TASKS.md)
Run `mvn -f banking-app/pom.xml verify` (Docker running)

| Module | Goal | Status | Tests | Notes |
|---|---|---|---|---|
| 0 Setup | Docker Postgres 5433, Flyway V1, 2 DB roles | ✅ | 1/1 | `BankingApplicationIT` |
| 1 AuthN / AuthZ | login → JWT; 401 / 403 / 200 | 🟡 | 0/2 | 8 tasks; 1.1 day 4: Q4–Q7 ✅ in chat 27 Nov, no V2 / `AuthSchemaIT` code |
| 2 Customer | JPA entities, validation, KYC maker-checker | ⬜ | | |
| 3 Account | `NUMERIC` money, owner checks, `@Version`, paging | ⬜ | | |
| 4 Beneficiary | uniqueness, soft delete, `Clock` | ⬜ | | |
| 5 Transactions | `@Transactional`, locking | ⬜ | | |
| 6 Fund Transfers | lock order, idempotency | ⬜ | | |
| 7 Transaction History | projections, keyset paging, N+1 | ⬜ | | |
| 8 Notifications | domain events, async | ⬜ | | |
| 9 Statements / Reports | scheduled jobs, batch reads | ⬜ | | |
| 10 Audit / Compliance | append-only audit, trigger, `REVOKE` | ⬜ | | |

**Open now:** Task 1.1 V2 auth tables + `AuthSchemaIT` (0/2); concepts answered, code not pushed · [day36.md](tasks/day36.md)

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
| Fri 27 Nov | AsteroidCollision (+1) still 0/28 (comments went into the original) | CarFleetRedoNov20 🔶 37/37 not cold (copy) |
| Sat 28 Nov | Day04LargestRectangle (+1) | Day01ArrayStack (+7) |
| Sun 29 Nov | Day00BuggyExample (+1) | Day02RpnEvaluator (+3) |
| Mon 30 Nov | DailyTemperatures (+1) | ValidParentheses (+3) |

Evening review places Asteroid (still overdue) and Day06's first +1 slot (joins the ladder today). New blank `CarFleet` stub needed for the +1 repeat.

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
