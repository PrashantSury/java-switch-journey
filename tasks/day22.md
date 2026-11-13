# 📅 Day 22 (Fri 13 Nov): one-slot day · 15-30 minutes

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-22-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-15--30%20min-yellow) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Still a **one-slot day**. 12 Nov was the first push day (labs `5c366dc` + fix `4384b9c`, this repo `d6ca103`), and the rule is **two push days** before the normal 2-hour plan comes back. One must-do today: the 🎤 **Chapter 1 interview question in chat**, which closes Chapter 1. Optional: Chapter 2 **Task 1** on `my-solutions`, pushed. A push today makes the second push day, and the normal plan plus the redo queue return **Sat 14 Nov**.

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first.
>
> State at 6 AM on tip `43d0e69` (the 12 Nov 10:26 PM labs re-check): no student commits after `4384b9c` (labs, 10:26 PM IST) and `d6ca103` (this repo, 9:01 PM IST). Re-run this morning on JDK 21: labs `Chapter01CheckTest` **19/19** on `4384b9c`; `Chapter02CheckTest` **0/19** (untouched stub, as expected). Root `mvn test` stands at **514 run, 0 red** (no code change since the 9:01 PM review).

## 🌅 Morning

### ⏱️ Time plan (15-30 min)

| Minutes | Track | Item | Done when |
|---|---|---|---|
| 0-2 | — | `git pull` both repos | — |
| 2-15 | 🌱🎤 | **Chapter 1 interview question, in chat** (below) | answered and graded in chat → Chapter 1 ✅ |
| 15-30 | 🌱 | *Optional:* `git switch -c my-solutions` in `spring-boot-labs`, then [Chapter 2](https://github.com/PrashantSury/spring-boot-labs/tree/main/chapters/02-first-spring-boot-app) **Task 1**, checks, push | `task1a`, `task1b`, `task1c` green on the pushed branch |

### 🎤 1. Chapter 1 interview question (must-do, in chat)

> [!TIP]
> Why a lead gets asked this: on a platform team you're the one who bumps Spring Boot across 20 services. Knowing *where* versions come from tells you what an upgrade really changes and why a "no code change" bump can still break a build.

Answer in your own words, 2-3 sentences per part. No looking at the pom while you write.

1. Your `pom.xml` lists `spring-boot-starter-webmvc` with **no `<version>`**. Who decides its version, and through which mechanism?
2. You bump `spring-boot-starter-parent` from one 4.1.x to the next. What happens to **all** your starters and their transitive jars, and what's the one risk you'd check before merging?
3. `runtime` vs `provided` scope: on which classpath (compile, test, packaged jar) is each jar present? Give one Ledgerly example of each.

Done when: graded in chat. Stuck for 15 minutes? Ask for a hint.

### 🌱 2. Chapter 2 Task 1 (optional, 15 min)

```bash
cd spring-boot-labs && git pull && git switch -c my-solutions
# read chapters/02-first-spring-boot-app/README.md, the "Task 1" part only
mvn -pl chapters/02-first-spring-boot-app test     # expect task1a/b/c green, the rest red
git add -A && git commit -m "Ch2 task 1" && git push -u origin my-solutions
```

| Check | Expected |
|---|---|
| `task1a` | `GET /status` → `200`, body `Ledgerly is open` |
| `task1b` | plain text, not JSON |
| `task1c` | `POST /status` → `405` (only `GET` is mapped) |

> [!WARNING]
> Before you add anything, ask: *what does Spring already do for an unmapped method?* `task1c` needs **no** code of its own. If you're writing a handler for `405`, stop: that's the Drill 1 trap again.

### 🧩 DSA · 🐞 Buggy · 🔁 Redos: resting today

| Track | Open item (unchanged) | Status | Returns when |
|---|---|---|---|
| 🧩 DSA | `DailyTemperatures` ✅ 18/18; next Stack problem not assigned yet. Optional: brute-force + 3-5 pseudocode lines as comments | ✅ / ⬜ next | Sat 14 Nov if today has a push |
| 🐞 Buggy | `Day04LargestRectangle` empty-stack width: one sentence + 3-line ASCII for `[2,1,2]` (optional, in chat) | 🟡 IN_PROGRESS | with the normal plan |
| 🔁 Redos | none due today (on hold on one-slot days). Next: `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` | ⬜ | Sat 14 Nov if today has a push |

### 📦 Carried backlog (not for today)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) still open | 🧩 | 🟡 IN_PROGRESS |
| 2 | B2 interview Q3 and Q6, plus "why the catch-all hid Spring's own answers" | 🌱 | ⬜ NOT_STARTED |
| 3 | Banking module 1 step 1, Drills 2 and 3 (parked; Spring slot is `spring-boot-labs`) | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 4 | `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED |
| 5 | Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| 6 | HTTP semantics / `ResponseEntity` / `@PathVariable` weak pack (🔴) | 🌱 | parked until Chapter 2 with the normal plan |

- [ ] Chapter 1 interview question answered in chat
- [ ] (optional) Chapter 2 Task 1 pushed on `my-solutions`
