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

## 🌙 Evening (13 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-15--30%20min-blue) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Evening review at ~8:00 PM IST on tip `f46e9f5` (the 6 AM session; JDK 21, Maven). No student commits today in either repo: this repo's last student code is `d6ca103` (12 Nov, 9:01 PM IST); [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) still has only `main` at `4384b9c` (12 Nov, 10:26 PM IST), no `my-solutions` branch. No Chapter 1 interview answer in chat yet. Re-run tonight: `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **0/19** (untouched stub). Root suite unchanged since the 12 Nov run (**514 run, 0 red**). **No new conceptual mistake** logged; no redo graded, so redo rows only move by date.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **unscored** (⬜ Pending) | No new work today: interview Q unanswered, Ch 2 Task 1 not started. Last score stays **8/10** (12 Nov late re-check, Chapter 1 tasks 19/19) |
| 🧩 DSA | **unscored** (⬜ resting) | Rested by plan. Last score **8/10** (12 Nov, `DailyTemperatures` 18/18) |
| 🐞 Buggy | **unscored** (⬜ resting) | Rested by plan; LargestRect empty-stack width sentence still open. Last score 7/10 (7 Nov) |

> [!TIP]
> Yesterday was a real comeback: three pushes, 19/19 + 18/18 + both redos clean. One quiet day after that isn't a slide. The rule only needs a second push day; the smallest one is the interview answer typed into chat (about 10 minutes, no IDE).

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

Either item counts as the second push day. If it's already late, item 1 alone is plenty.

### 🎯 Tomorrow's focus (Sat 14 Nov)

| Track | Focus | Why (from tonight's assessment) |
|---|---|---|
| 🌱 Spring | If item 1 or 2 lands tonight: normal plan, Chapter 2 onward (HTTP-semantics weak pack comes back with it). If not: one slot again, the **interview Q only** (closes Chapter 1) | Chapter 1 code is strong; only the explain-it part is open, and that's the interview-readiness gap |
| 🧩 DSA | Normal plan only: next Stack problem, starting with 3–5 lines of plain-English pseudocode before any Java | 12 Nov skipped pseudocode and brute-force comments; that's the habit to fix, not the stack logic |
| 🐞 Buggy | Normal plan only: LargestRect empty-stack width sentence + 3-line ASCII for `[2,1,2]` first, no new round until it lands | geometric why still soft since 7 Nov |
| 🔁 Redos | Normal plan only: `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` (both +1, late). On a one-slot day they move to the first normal day | no redos on one-slot days |

Saturday also has the 2 PM weekly review.
