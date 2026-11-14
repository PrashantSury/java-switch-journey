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
