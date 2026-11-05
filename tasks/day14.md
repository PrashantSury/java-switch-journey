# 📅 Day 14 (Thu 5 Nov): carried work only, one push per item

![Week](https://img.shields.io/badge/Week-2-blue) ![Day](https://img.shields.io/badge/Day-14-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Progress decides the work, not the calendar. There was no push after `80d98f1` (3 Nov, 23:15 IST), so every item of [day13.md](day13.md) is still open and **nothing new is added today**: no new stub, no new Stack problem, no new buggy round. This file only re-orders the open items into smaller steps. **Each step ends in a push, even if red.** The order below is the order to work in.

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🏦 banking · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Run `git pull` first. Nothing changed in the repo since your last code push, so the figures from 4 Nov still stand: `course-practice` 19/19 (`SpringDefaultsDrillTest` red, 3 stubs), `CarFleetTest` 37/37, `Day04LargestRectangleTest` 15/36, `Day02RpnEvaluatorRedoNov01Test` 0/44, `ValidParenthesesRedoNov01Test` 0/18, `AuthSchemaIT` 2 red stubs.

## 🌅 Morning

> [!WARNING]
> **Why the plan is smaller this time.** Yesterday's morning list had seven items and none was pushed. Today the list is the same seven items in five short steps, with the quick, certain wins first (comment lines, then the one small Spring drill that closes Part B2). The long steps (RPN redo, module 1) come after, so a short morning still ends with pushes. Ask for a hint after **15 minutes** on any step; a red push counts.

### ⏱️ Time plan (120 min)
| Minutes | Track | Item | Push it |
|---|---|---|---|
| 0-5 | 🧩 DSA | `CarFleet`: pattern, time, space as 3 comment lines | yes, first; `CarFleetTest` stays 37/37 |
| 5-25 | 🌱 Spring | **Drill 1** (closes Part B2): `/abc` → 400, unknown path → 404, 405 keeps `Allow` | yes; `course-practice` **22 tests, 0 failures** |
| 25-30 | 🧩 DSA | Count-stack O(n) re-ask, answered in chat | graded tonight |
| 30-55 | 🔁🧩 DSA | Cold redo `Day02RpnEvaluatorRedoNov01` (0/44), timed 25 min | yes, even if red |
| 55-70 | 🐞 Buggy | `Day04LargestRectangle`: symptom table and blank hand trace, no code change | yes |
| 70-110 | 🏦 Banking | **Module 1, step 1**: five design decisions, then `V2__create_auth_tables.sql` by hand and `AuthSchemaIT` | yes, once V2 is complete |
| 110-120 | Buffer | `mvn test`, push whatever is left | |

> [!TIP]
> Spring gets 60 of the 120 minutes (Drill 1 plus module 1 step 1). If Drill 1 takes longer than 25 minutes, stop it, push what you have and move on; the unfinished part goes to tonight's list.

---

## 1️⃣ 🧩 `CarFleet`: three comment lines (5 min, **push first**)
Spec and hints: [day13.md](day13.md#1️⃣-carfleet-three-comment-lines-5-10-min-push-first).

- [ ] At the top of `src/main/java/com/prashant/dsa/stack/CarFleet.java`: one comment line each for the pattern, the time and the space, with the reason in one sentence next to each cost.
- [ ] `mvn test -Dtest=CarFleetTest` is still **37/37**. Push.

> [!TIP]
> One question each. Time: which step costs the most, the sort or the single pass over the stack? Space: in the worst case how many fleets can the stack hold, and what else did you allocate (the sorted copy)?

## 2️⃣ 🌱 Drill 1: Spring defaults vs the catch-all (about 20 min)
Full 12-part spec: [day13.md, Drill 1](day13.md#-drill-1-spring-defaults-vs-the-catch-all-about-15-min). Stub: `spring-boot/course-practice/src/test/java/com/prashant/coursepractice/controller/SpringDefaultsDrillTest.java` (3 red tests).

> [!IMPORTANT]
> ✅ Done when `mvn test` in `spring-boot/course-practice` shows **22 tests, 0 failures** and you can say in one sentence why the catch-all hid Spring's own answers. This closes Part B2.

Do it in this order, so nothing is added before you know what is missing:
| Step | What you do | Minutes |
|---|---|---|
| 1 | Run the app (or write test 1 first) and read what `GET /api/students/abc` and `GET /api/nothing` answer today. Write the two answers next to what Spring answers by itself (400 and 404). | 5 |
| 2 | Ask: which exception is each one, and which resolver would have handled it if the catch-all had not matched first? Write the two exception class names. | 3 |
| 3 | Add **only** the handlers that are missing for those two exceptions (or change the catch-all so they pass through). 3-5 lines of plain-English pseudocode first. | 7 |
| 4 | Fill in the 3 tests (400, 404, 405 with `Allow`). Push. | 5 |

## 3️⃣ 🧩 Count-stack O(n) re-ask (5 min, in chat)
Answer in 3-4 lines: `RemoveKAdjacentDuplicates` keeps a stack of (character, count). A run can be popped many times. Why is the total still O(n)?

> [!TIP]
> (1) How many times can one character be **pushed** in total? (2) How many times can one entry be **popped**? (3) So what is the most work the whole loop can do, and where does that cost come from, in one sentence?

## 4️⃣ 🔁 Cold redo `Day02RpnEvaluatorRedoNov01` (25 min)
| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🐞 `Day02RpnEvaluator` | `src/main/java/com/prashant/dailytests/redo/Day02RpnEvaluatorRedoNov01.java` | `Day02RpnEvaluatorRedoNov01Test` 0/44 | +1 (reset 31 Oct, 4 days late) | 25 min, cold |

- [ ] Before any Java: 3 comment lines (pattern, time, space) and 3-5 lines of plain-English pseudocode: a number token, an operator token, the end check.
- [ ] Cold means cold: do not open `Day02RpnEvaluator*` or older redos. Set a 25-minute timer. Push at the end, even if red.

> [!WARNING]
> Ladder rule: 44/44 with no peeking moves it up; a pass that needed a hint repeats the gap; a conceptual slip (operand order, the `-3` token, the end check, the null guard) resets it to day 1. If it fails, the [RPN weak-topic pack](day13.md#️-weak-topic-pack-rpn-evaluation-new-tonight) is the next step.

## 5️⃣ 🐞 `Day04LargestRectangle`: symptom table (15 min)
Both tables and the method are in [day13.md](day13.md#-buggy-day04largestrectangle-symptom-table-15-min); spec in [day09.md](day09.md#-day04largestrectangle-buggy-round).

- [ ] A comment block at the top of `Day04LargestRectangle.java` with table 1 (failing tests by group, what the wrong answers share) and table 2 (a blank hand trace on `[2, 1, 2]`, expected 3). **No code change today.** Push.

## 6️⃣ 🏦 Banking module 1, step 1 (about 40 min)
Step 1 only: [day13.md, module 1 step 1](day13.md#-banking-module-1-step-1-the-v2-auth-migration-and-its-test-about-40-min). Full 12-part module spec: [day09.md](day09.md#-banking-module-1-authn--authz-foundation).

| Part | Minutes | What |
|---|---|---|
| a | 10 | Decide the five points (tables and join tables, key type, case-insensitive username, password column, `BaseEntity` columns) in writing on paper or in chat |
| b | 25 | Write `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` by hand, the five decisions as comment lines at the top |
| c | 5 | Fill in the two `AuthSchemaIT` tests |

> [!CAUTION]
> Flyway checksums a migration the first time it runs. Do **not** start the app or run `AuthSchemaIT` against a database until V2 is complete, and never edit V2 afterwards (add V3 or reset the dev database). No password, hash or seed user in the file.

- [ ] V2 pushed. `v2CreatesFiveAuthTables` and `usernameIsUniqueIgnoringCase` pass with Docker Desktop running, or the push is red and tonight's review reads the file.

---

## 🌙 Evening plan (60 min)
| Order | Item | Track |
|---|---|---|
| 1 | Review and score each track out of 10 | all |
| 2 | Finish whatever is pending from the morning, in the order above | all |
| 3 | In chat: Q3 and Q6 of the B2 interview questions (graded) and the `CarFleet` single-pair follow-up | 🌱🧩 |
| 4 | 🔁 cold redo `ValidParenthesesRedoNov01` (0/18), 20 min, pattern note and complexity first | 🧩 |

## 📦 Carried backlog (not for this morning)
| Item | Track | Status | When |
|---|---|---|---|
| Part B2 | 🌱 | 🟡 IN_PROGRESS (19/19; closes with Drill 1, then ✅ after review) | today, step 2 |
| Drill 2 (`@Valid` and 400) and Drill 3 (a MockMvc happy-path plus error test) | 🌱 | ⬜ NOT_STARTED | after Drill 1, 15 min each |
| Count-stack O(n) re-ask (3/5) | 🧩 | 🔴 REVISION_REQUIRED | today, step 3 |
| `CarFleet` single-pair follow-up | 🧩 | ⬜ NOT_STARTED | tonight, in chat |
| `Day00BuggyExample` warm-up (4/10) | 🐞 | ⬜ NOT_STARTED | after `Day04LargestRectangle` is ✅ |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after the re-ask |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | evenings with spare time |
| Next new Stack problem | 🧩 | ⬜ not assigned | only when the `CarFleet` comments and the re-ask are done |
| Redos queued: `MinStack`, `ScoreOfParentheses` (6 Nov), `RemoveKAdjacentDuplicates`, `Day03NextGreaterIndex` (7 Nov) | 🔁 | 🟡 IN_PROGRESS | [redo-schedule.md](../revision/redo-schedule.md), cap 2 a day |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.
