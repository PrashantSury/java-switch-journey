# 📅 Day 23 (Sat 14 Nov): one-slot day · 15 minutes

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-23-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-15%20min-yellow) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Still a **one-slot day**. Nothing landed on 13 Nov (no commits, no chat answer), so the **second push day** is still needed before the normal 2-hour plan and the redo queue come back. One must-do: the 🎤 **Chapter 1 interview question in chat** (unchanged from [day22.md](day22.md#-1-chapter-1-interview-question-must-do-in-chat)). It's about 10 minutes and needs no IDE. Answer it today and the normal plan returns **Sun 15 Nov**.

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first.
>
> State at 6 AM on tip `001655c` (the 13 Nov 10 PM check): no student commits after `d6ca103` (this repo, 12 Nov 9:01 PM IST) and `4384b9c` ([`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) `main`, 12 Nov 10:26 PM IST); still no `my-solutions` branch. No code changed, so the last verified results stand: labs `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **0/19** (stub), root `mvn test` **514 run, 0 red**.

## 🌅 Morning

### ⏱️ Time plan (15 min)

| Minutes | Track | Item | Done when |
|---|---|---|---|
| 0-2 | — | `git pull` both repos | — |
| 2-15 | 🌱🎤 | **Chapter 1 interview question, in chat** (below) | answered and graded in chat → Chapter 1 ✅ |
| +15 (optional) | 🌱 | `git switch -c my-solutions` in `spring-boot-labs`, Chapter 2 **Task 1**, push | `task1a`, `task1b`, `task1c` green on the pushed branch |

### 🎤 1. Chapter 1 interview question (must-do, in chat)

> [!TIP]
> Why it matters for a lead: you're the one who bumps Spring Boot across many services. Knowing *where* a version comes from tells you what an upgrade actually changes, and why a "no code change" bump can still break a build.

Answer in your own words, 2-3 sentences per part, without opening the pom.

1. Your `pom.xml` lists `spring-boot-starter-webmvc` with **no `<version>`**. Who decides its version, and through which mechanism?
2. You bump `spring-boot-starter-parent` from one 4.1.x to the next. What happens to **all** your starters and their transitive jars, and what's the one risk you'd check before merging?
3. `runtime` vs `provided` scope: on which classpath (compile, test, packaged jar) is each jar present? Give one Ledgerly example of each.

Not sure where to start? Write one line per part first ("version comes from ___", "a bump changes ___", "runtime = ___ / provided = ___"), then expand. Stuck for 15 minutes? Ask for a hint.

### 🌱 2. Chapter 2 Task 1 (optional, 15 min)

Same as [day22.md](day22.md#-2-chapter-2-task-1-optional-15-min): `GET /status` → `200`, plain text `Ledgerly is open`; `POST /status` → `405`.

> [!WARNING]
> Ask first: *what does Spring already do for an unmapped method?* `task1c` needs **no** code of its own.

### 🧩 DSA · 🐞 Buggy · 🔁 Redos: resting today

| Track | Open item (unchanged) | Status | Returns when |
|---|---|---|---|
| 🧩 DSA | `DailyTemperatures` ✅ 18/18; next Stack problem not assigned yet (pseudocode-first habit is the focus when it comes) | ✅ / ⬜ next | the day after the second push day |
| 🐞 Buggy | `Day04LargestRectangle` empty-stack width: one sentence + 3-line ASCII for `[2,1,2]` | 🟡 IN_PROGRESS | with the normal plan |
| 🔁 Redos | none assigned today (on hold on one-slot days). Most overdue next: `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` | ⬜ | first normal day |

### 📦 Carried backlog (not for today)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) still open | 🧩 | 🟡 IN_PROGRESS |
| 2 | B2 interview Q3 and Q6, plus "why the catch-all hid Spring's own answers" | 🌱 | ⬜ NOT_STARTED |
| 3 | Banking module 1 step 1, Drills 2 and 3 (parked; Spring slot is `spring-boot-labs`) | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 4 | `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED |
| 5 | Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| 6 | HTTP semantics / `ResponseEntity` / `@PathVariable` weak pack (🔴) | 🌱 | parked until Chapter 2 with the normal plan |

Saturday also has the **2 PM weekly review**.

- [ ] Chapter 1 interview question answered in chat
- [ ] (optional) Chapter 2 Task 1 pushed on `my-solutions`

## 🌙 Evening (14 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-15%20min-blue) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Evening review at ~8:00 PM IST on tip `7325500` (the 2:11 PM IST weekly review). No student commits today in either repo: this repo's last student code is `d6ca103` (12 Nov, 9:01 PM IST); [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) still has only `main` at `4384b9c` (12 Nov, 10:26 PM IST), no `my-solutions` branch. No Chapter 1 interview answer in chat yet. No code change, so the suites stand: `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **0/19** (stub), root `mvn test` **514 run, 0 red**. **No new conceptual mistake** logged; no redo graded, so redo rows only move by date. The [weekly review 8–14 Nov](../PROGRESS.md#-weekly-review--814-nov-2026) already landed at 2:10 PM IST.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **unscored** (⬜ Pending) | No new work today: interview Q unanswered, Ch 2 Task 1 not started. Last score stays **8/10** (12 Nov late re-check, Chapter 1 tasks 19/19) |
| 🧩 DSA | **unscored** (⬜ resting) | Rested by plan. Last score **8/10** (12 Nov, `DailyTemperatures` 18/18) |
| 🐞 Buggy | **unscored** (⬜ resting) | Rested by plan; LargestRect empty-stack width sentence still open. Last score 7/10 (7 Nov) |

> [!TIP]
> One quiet Saturday after Thursday's comeback. The must-do is still the interview question in chat (about 10 minutes, no IDE). It closes Chapter 1 but is not a push day; a push (for example Chapter 2 Task 1) is still what brings the normal plan back.

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 labs Chapter 1 tasks (Maven / pom) | ✅ Strong (tasks) | 19/19 verified on `4384b9c` |
| 🌱 labs Chapter 1 interview Q (BOM / parent versions, upgrade risk, `runtime` vs `provided`) | ⬜ Pending | not answered; Chapter 1 stays 🟡 until graded |
| 🌱 labs Chapter 2 Task 1 (`GET /status`, 405 for free) | ⬜ Pending (optional) | not started; 0/19 |
| 🌱 B2 Q3 / Q6 / catch-all sentence | ⬜ Pending (carried) | unanswered |
| 🌱 HTTP semantics / `ResponseEntity` / `@PathVariable` set | 🔴 Weak (carried) | pack stays parked until Chapter 2 with the normal plan; no new pack tonight |
| 🧩 `DailyTemperatures` | ✅ Strong (code) · 🟡 process | 18/18; pseudocode/brute-force comments still not written |
| 🧩 `CarFleet` single-pair / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🟡 Moderate | written merge pending |
| 🐞 `Day04LargestRectangle` empty-stack width | 🟡 Moderate / ⬜ Pending sentence | geometric why still open |
| ⛔ Blocked | none | nothing outside his control is stopping the work |

No topic is newly 🔴 Weak tonight, so no new weak-topic pack.

### ⏳ Tonight's evening-slot work (pending from this morning)

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 10-15 | 🎤 **Chapter 1 interview question in chat** (the three parts in the Morning section above) | 🌱 | answered here and graded → Chapter 1 ✅ |
| 2 | 15 (optional) | `git switch -c my-solutions` in `spring-boot-labs`, Chapter 2 **Task 1**, push. Remember: `task1c` (405) needs no code | 🌱 | `task1a-c` green on the pushed branch |

Item 1 closes Chapter 1 but does not count as the second push day. Item 2 would.

### 🎯 Tomorrow's focus (Sun 15 Nov)

| Track | Focus | Why (from tonight's assessment) |
|---|---|---|
| 🌱 Spring | If item 2 lands tonight: that is the second push day, and the normal plan starts Mon 16 Nov (HTTP-semantics weak pack comes back with it). If not: one slot again, the **interview Q only** (closes Chapter 1) | Chapter 1 code is strong; only the explain-it part is open |
| 🧩 DSA | Normal plan only: next Stack problem, starting with 3–5 lines of plain-English pseudocode before any Java | 12 Nov skipped pseudocode and brute-force comments; that's the habit to fix, not the stack logic |
| 🐞 Buggy | Normal plan only: LargestRect empty-stack width sentence + 3-line ASCII for `[2,1,2]` first, no new round until it lands | geometric why still soft since 7 Nov |
| 🔁 Redos | Normal plan only: `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` (both +1, late). On a one-slot day they move to the first normal day | no redos on one-slot days |

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Pushes](https://img.shields.io/badge/student%20pushes%20today-0-lightgrey)

> [!NOTE]
> 10 PM check on tip `7325500` (the 2:11 PM IST weekly review). No student commits after it: this repo's last student commit is still `d6ca103` (12 Nov, 9:01 PM IST) and `spring-boot-labs` `main` is still `4384b9c` (12 Nov, 10:26 PM IST), with no `my-solutions` branch. No Chapter 1 interview answer in chat. Nothing to re-test, so the suites stand: `mvn test` **514 run, 0 red**; labs `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **0/19** (stub). No new conceptual mistake, no cosmetic fix needed, and [redo-schedule.md](../revision/redo-schedule.md) is unchanged.

| Item | Track | Outcome | Status |
|---|---|---|---|
| `spring-boot-labs` Chapter 1 (Tasks 1-6) | 🌱 | 19/19 on `main` `4384b9c` (verified 12 Nov) | 🟡 IN_PROGRESS (interview Q open) |
| Chapter 1 interview question | 🌱 | not answered | ⬜ NOT_STARTED |
| Chapter 2 Task 1 (optional) | 🌱 | not started; 0/19 | ⬜ NOT_STARTED |
| LargestRectangle empty-stack width sentence + ASCII | 🐞 | resting (one-slot day) | 🟡 IN_PROGRESS |
| `CarFleet` single-pair follow-up / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🧩 | resting (one-slot day); PR still open | 🟡 IN_PROGRESS |
| 🔁 `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` | 🔁 | not due on a one-slot day; wait for the first normal day | ⬜ NOT_STARTED |

> [!IMPORTANT]
> **First task tomorrow (Sun 15 Nov, one slot, 15 min):** answer the 🎤 **Chapter 1 interview question in chat** (the three parts in the Morning section above: where the starter's version comes from, what a `spring-boot-starter-parent` bump changes and the one risk to check, `runtime` vs `provided` with a Ledgerly example each). ✅ Done when it's graded in chat, which closes Chapter 1. Optional: Chapter 2 **Task 1** on `my-solutions`, pushed. Today had no push, so the second push day is still needed before the normal plan and redo queue return. A chat answer closes Chapter 1 but does not count as a push.
