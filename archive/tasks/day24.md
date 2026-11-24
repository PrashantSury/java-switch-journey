# 📅 Day 24 (Sun 15 Nov): one-slot day · 15 minutes

![Week](https://img.shields.io/badge/Week-4-blue) ![Day](https://img.shields.io/badge/Day-24-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-15%20min-yellow) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Still a **one-slot day**. Nothing landed on 14 Nov (no commits, no chat answer), so the **second push day** is still needed before the normal 2-hour plan and the redo queue come back. One must-do: the 🎤 **Chapter 1 interview question in chat** (unchanged from [day23.md](day23.md#-1-chapter-1-interview-question-must-do-in-chat)). It's about 10 minutes and needs no IDE. A chat answer closes Chapter 1 but does **not** count as a push; the normal plan returns the day after the second push day.

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first.
>
> State at 6 AM on tip `7325500` (the 14 Nov weekly review): no student commits after `d6ca103` (this repo, 12 Nov 9:01 PM IST) and `4384b9c` ([`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) `main`, 12 Nov 10:26 PM IST); still no `my-solutions` branch. No code changed, so the last verified results stand: labs `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **0/19** (stub), root `mvn test` **514 run, 0 red**.

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

Not sure where to start? Write one line per part first ("the version comes from ___ via ___", "a bump changes ___; I'd check ___", "runtime = ___ / provided = ___"), then expand. Stuck for 15 minutes? Ask for a hint.

### 🌱 2. Chapter 2 Task 1 (optional, 15 min)

Same as [day23.md](day23.md#-2-chapter-2-task-1-optional-15-min): `GET /status` → `200`, plain text `Ledgerly is open`; `POST /status` → `405`.

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

- [x] Chapter 1 interview question answered in chat
- [x] (optional) Chapter 2 Task 1 pushed on `my-solutions`

## 🎤 Chapter 1 interview grade (~8:07-8:15 AM IST)

![Score](https://img.shields.io/badge/interview-7%2F10-yellow) ![Chapter](https://img.shields.io/badge/Chapter%201-closed-brightgreen) ![Spring](https://img.shields.io/badge/Spring%20stays-8%2F10-blue)

> [!NOTE]
> Graded in chat on Sun 15 Nov, ~8:07-8:15 AM IST, on tip `7325500`. No new student commit. Labs tasks already **19/19** on `4384b9c`, so with this answer **Chapter 1 is ✅ closed**. Spring score stays **8/10** (the 12 Nov late re-check). A chat answer is **not** a push day; the second push day is still needed before the normal plan returns (redos `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` come back on the first normal day after it).

| Part | First answer | After hint / correction | Result |
|---|---|---|---|
| 1. Who picks the starter version when the pom writes none? | "Parent dependency" | After a hint, named the **BOM** (`spring-boot-dependencies`, inherited into `<dependencyManagement>`) | ✅ correct with a hint |
| 2. What a `spring-boot-starter-parent` bump changes, and the risk to check | Half: "all other dependencies will get downloaded with respect to the parent version as a jar" | After a hint: code that depends on a library can break when that library's version moves; run the unit tests before merging | ✅ correct with a hint. Coaching add: also read the release notes, or run `mvn dependency:tree`, to see which versions actually changed |
| 3. `runtime` vs `provided` classpaths, plus one Ledgerly example each | ❌ Reversed: said `provided` is on compile, test and the packaged jar, and `runtime` is only on the packaged jar | After a corrected grid: **H2** = `runtime` (no compile-time import; needed when the app runs), **Tomcat** = `provided` (the server already has it, so leave it out of a WAR) | ✅ correct after a correction |

Correct classpath picture used in the review:

```
             compile   test   packaged jar
provided       ✅        ✅        ❌   (the server already has it)
runtime        ❌        ✅        ✅   (needed only when the app runs)
```

> [!IMPORTANT]
> **Interview 7/10.** All three parts were reached, but part 3 needed a correction and parts 1 and 2 needed hints. Weak-topic note: **Maven dependency scopes (the classpath grid)** — revisit briefly, no pack (🟡 Moderate, not 🔴 Weak). Next push: Chapter 2 **Task 1** on `my-solutions` (`GET /status` → 200, `Ledgerly is open`; `POST /status` → 405 is already handled by Spring).

## 🌱 Chapter 2 Task 1 grade (`1ded3b3`, 8:35 AM IST)

![Score](https://img.shields.io/badge/Task%201-9%2F10-brightgreen) ![Ch2](https://img.shields.io/badge/Ch2-3%2F19-yellow) ![Push day](https://img.shields.io/badge/push%20day-2%20of%202-brightgreen)

> [!NOTE]
> Graded on tip `1075608`. Student push on [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) `my-solutions` `1ded3b3` (15 Nov, 8:35 AM IST, "completed chapter2- task 1"). Only file changed: `AccountController.java` — `@GetMapping("/status")` returns `"Ledgerly is open"`. Verified: `Chapter01CheckTest` **19/19**; `Chapter02CheckTest` **3/19** (`task1a`, `task1b`, `task1c` all green). `POST /status` → 405 from Spring's default, with **no** extra handler. Tasks 2-6 not started; first fail is `task2a_list` (`GET /accounts` → 404).

### 📝 Score (rubric in [PROGRAM.md](../../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot (Task 1) | **9/10** (concept 9 · implementation 10 · debugging n/a) | The mapped `GET` is exact (200, plain text `Ledgerly is open`), and `task1c` was left to Spring — the first unprompted "check Spring defaults first" win, after the Drill 1 catch-all habit. No debugging dimension: the three Task 1 checks were green on this push |

> [!TIP]
> This is the habit we wanted on 405: check what Spring already does before writing a handler. Hold onto that for Task 2 onward.

> [!IMPORTANT]
> This is the **second push day** (the first was 12 Nov). The normal 2-hour plan returns **Mon 16 Nov**, and the evening starts with redos `ScoreOfParentheses` + `RemoveKAdjacentDuplicates`. Next labs item: Chapter 2 **Task 2** (`GET /accounts`).

## 🌙 Evening (15 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-8%2F10-blue) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Evening review at ~8:00 PM IST on tip `fd7b9eb`. No student commits after the morning: this repo's last student code is still `d6ca103` (12 Nov); [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) `my-solutions` is `1ded3b3` (8:35 AM IST), `main` `4384b9c`. **Re-verified tonight** on `1ded3b3` (JDK 21, Maven): `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **3/19** (task1a/b/c green, 16 red = Tasks 2-6 not started). No new chat answers after the 8:15 AM interview. **No new conceptual mistake** (the scopes mix-up is already in the weak-topic table as 🟡 Moderate). No redo graded today (one-slot day), so [redo-schedule.md](../../revision/redo-schedule.md) is unchanged.

### 📝 Scores (rubric in [PROGRAM.md](../../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot (whole day) | **8/10** (concept 7 · implementation 10 · problem solving 8 · debugging n/a · interview readiness 7) | Code side was a 9: Task 1 exact on the first push, and the 405 left to Spring without being told. Explain-it side was a 7: BOM and upgrade risk only with hints, and the `runtime`/`provided` classpaths reversed before the corrected grid. A lead has to *say* where versions and jars come from, not just get the build green, so the day lands at 8 |
| 🧩 DSA | **unscored** (⬜ resting by plan) | No DSA work today. Last score **8/10** (12 Nov, `DailyTemperatures` 18/18) |
| 🐞 Buggy | **unscored** (⬜ resting by plan) | No buggy work today; LargestRect empty-stack width sentence still open. Last score 7/10 (7 Nov) |

> [!TIP]
> Good Sunday: both must-dos landed before 9 AM and the second push day is done. The 405 move is the habit we've been after since Drill 1. Now do the same thing in words: one line on where something comes from before you explain it.

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 labs Chapter 1 (Maven / pom) | ✅ Strong (tasks) · closed | 19/19 re-verified; interview 7/10 |
| 🌱 Maven dependency scopes (`runtime` vs `provided` grid) | 🟡 Moderate | reversed first, right after the grid; one-line recall at the start of tomorrow's Spring slot |
| 🌱 labs Chapter 2 Task 1 (`GET /status`, 405 from Spring) | ✅ Strong | 3/3 green, no extra handler |
| 🌱 labs Chapter 2 Tasks 2-6 | ⬜ Pending | not started (next: Task 2 `GET /accounts`) |
| 🌱 HTTP semantics / `ResponseEntity` / `@PathVariable` set | 🔴 Weak (carried) | pack returns with Chapter 2 Tasks 2-3 on the normal plan; no new pack tonight |
| 🌱 B2 Q3 / Q6 / catch-all sentence | ⬜ Pending (carried) | unanswered |
| 🧩 `DailyTemperatures` | ✅ Strong (code) · 🟡 process | pseudocode/brute-force comments still not written |
| 🧩 `CarFleet` single-pair / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🟡 Moderate | written merge pending |
| 🐞 `Day04LargestRectangle` empty-stack width | 🟡 Moderate / ⬜ Pending sentence | geometric why still open |
| ⛔ Blocked | none | nothing outside his control is stopping the work |

No topic is newly 🔴 Weak tonight, so no new weak-topic pack.

### ⏳ Tonight's evening-slot work

Both morning items are ✅ done, so nothing from this morning is pending. No new material tonight. Optional, if you have 10-15 minutes:

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 5 | Say the scopes grid back in chat from memory: `compile` / `provided` / `runtime` / `test` × compile classpath / test classpath / packaged jar | 🌱 | grid right first try → scopes move to ✅ Strong |
| 2 | 10 (optional) | 🐞 LargestRect: one sentence on why the width is `i` when the stack is empty, plus a 3-line ASCII for `[2,1,2]` | 🐞 | sentence names the "everything to the left is taller" reason |

### 🎯 Tomorrow's focus (Mon 16 Nov, normal 2-hour plan returns)

| Track | Focus | Why (from tonight's assessment) |
|---|---|---|
| 🌱 Spring | Chapter 2 **Task 2** (`GET /accounts`). Before coding, write one line: *what does Spring already give a `List` return (status, JSON)?* Start with a 1-minute scopes-grid recall if item 1 wasn't done tonight | code habit is now good; the gap is explaining defaults and sources out loud. Task 2-3 also bring back the HTTP-semantics weak pack |
| 🧩 DSA | Next Stack problem, with 3–5 lines of plain-English pseudocode and a brute-force comment **before** any Java | 12 Nov skipped both; that's the habit to fix, not the stack logic |
| 🐞 Buggy | LargestRect empty-stack width sentence + ASCII first (if not done tonight); no new round until it lands | geometric why soft since 7 Nov |
| 🔁 Redos (evening) | `ScoreOfParentheses` (+1, late) + `RemoveKAdjacentDuplicates` (+1, late), cold | most overdue in the queue (ScoreOfParentheses since 26 Oct) |

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Pushes](https://img.shields.io/badge/student%20pushes%20today-1-brightgreen)

> [!NOTE]
> 10 PM check on tip `fd7b9eb`. No student commits after the 8 PM evening review: this repo's last student code is still `d6ca103` (12 Nov) and `spring-boot-labs` `my-solutions` is still `1ded3b3` (8:35 AM IST). At the moment of this check there were no new student commits after the 8 PM review, and the suites still stand: labs `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **3/19**. Two chat answers then landed ~10:00-10:27 PM IST (scopes grid + LargestRect); they are recorded in the late-chat section below. Housekeeping: the near-term rows in [redo-schedule.md](../../revision/redo-schedule.md) were rebuilt so they match the resume date (Mon 16 Nov), and the Sunday plan projection in [PROGRESS.md](../../PROGRESS.md#-plan-projection-3-h-a-day) was refreshed.

| Item | Track | Outcome | Status |
|---|---|---|---|
| Chapter 1 interview question | 🌱 | answered in chat, **7/10** | ✅ COMPLETED (Chapter 1 closed) |
| Chapter 2 Task 1 (`GET /status`) | 🌱 | `1ded3b3`, 3/3 green, **9/10** | ✅ COMPLETED |
| Chapter 2 Tasks 2-6 | 🌱 | not started (`task2a_list` 404) | ⬜ NOT_STARTED |
| Scopes grid recall (optional tonight) | 🌱 | asked what was expected; the full grid was given, **not graded as recall** | 🟡 IN_PROGRESS (recall retry is Mon 16 Nov's 1-minute warm-up) |
| LargestRectangle empty-stack width sentence + ASCII | 🐞 | answered ~10:00-10:27 PM IST, sentence **8/10** after a correction | ✅ COMPLETED (item closed; buggy score stays 7) |
| `CarFleet` single-pair follow-up / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🧩 | resting; PR still open | 🟡 IN_PROGRESS |
| 🔁 `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` | 🔁 | not due on a one-slot day | ⬜ NOT_STARTED (Mon 16 Nov evening) |

> [!IMPORTANT]
> **First task tomorrow (Mon 16 Nov, normal 2-hour plan):** 1 minute, say the Maven scopes grid from memory (`compile` / `provided` / `runtime` / `test` × compile classpath / test classpath / packaged jar) — last night was a teach, not a recall grade. Then labs Chapter 2 **Task 2** (`GET /accounts`) on `my-solutions`: before any code, write one line on what Spring already gives a `List` return (status, JSON), then push. ✅ Done when `task2a` is green. The 15-min buggy slot is now the missing `DailyTemperatures` comments (LargestRect width closed tonight). Evening redos: `ScoreOfParentheses` + `RemoveKAdjacentDuplicates`, cold. Ask for a hint after 15 minutes on any step.

## 🌙 Late chat (~10:00-10:27 PM IST): scopes grid + LargestRect

![Slot](https://img.shields.io/badge/slot-10%3A00--10%3A27%20PM-yellow) ![Scopes](https://img.shields.io/badge/scopes-taught%2C%20not%20graded-lightgrey) ![LargestRect](https://img.shields.io/badge/LargestRect-8%2F10-yellow) ![Buggy](https://img.shields.io/badge/Buggy%20stays-7%2F10-blue)

> [!NOTE]
> Two optional chat answers after the 10 PM check, still on 15 Nov. No new student commit. Tip at the check was `fd7b9eb` / later records `c54a877`.

### 1. Scopes grid — taught, not graded as recall

He asked what was expected. The full grid was given:

```
           compile cp   test cp   packaged jar
compile        ✅          ✅          ✅
provided       ✅          ✅          ❌   (server already has it, e.g. Tomcat)
runtime        ❌          ✅          ✅   (needed only when the app runs, e.g. H2)
test           ❌          ✅          ❌   (JUnit, never shipped)
```

This was a teach, not a first-try recall, so scopes stay 🟡 Moderate. The **recall retry** is the 1-minute warm-up at the start of [day25.md](day25.md).

### 2. `Day04LargestRectangle` empty-stack width — closed

| Attempt | What he said | Result |
|---|---|---|
| First sentence | "stack is empty means no element is greater than the current element so the width is `i`" | ❌ wrong direction: empty means no bar to the left is **smaller** than the popped bar |
| `[2,1,2]` trace | Pop flow was right, but height came from the **current** bar, not the popped one: i=1 h=1 a=1 (should be h=2 a=2); i=3 first pop a=0 (should be w=1, h=2, a=2); final pop w=2 (should be w=`i`=3, h=1, a=3); best 2 (should be 3) | 🟡 steps right, two values off. Graded **5/10** on this pass |
| After the correction | "when stack is empty then width is the current `i` means no elements smaller than popped one" | ✅ correct |

> [!IMPORTANT]
> Sentence **8/10** after the correction. The write-up item is ✅ **closed**. Buggy score stays **7/10** (the first trace used the current bar's height). Lesson, logged in [mistakes/dsa.md](../../revision/mistakes/dsa.md): **height always comes from the popped bar**, not the current one. No new buggy round today; Monday's 15-min buggy slot is the missing `DailyTemperatures` comments instead.
