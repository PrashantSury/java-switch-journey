# 📅 Day 21 (Thu 12 Nov): one-slot day · one item · 45 minutes

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-21-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-45%20min-yellow) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> First **one-slot day** (decided at the [11 Nov evening review](day20.md#-evening-11-nov-review-scores-tonight-and-tomorrow)). Nothing was pushed on 8-11 Nov (last student code `3019054`, 7 Nov 14:11 IST), so today is **one 45-minute block with one item**: `spring-boot-labs` Chapter 1 **Task 1**, the project's coordinates, on a new `my-solutions` branch, **pushed even if red**. ✅ Done when `task1a`, `task1b`, `task1c` are green on the pushed branch. Nothing new is added on any track.

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first.
>
> State at 6 AM on tip `0979813` (11 Nov 10 PM check): no student commits on either repo since `3019054`. Only docs changed since the 11 Nov 6 AM re-run, so the suites stand as re-run then and at the 8 PM review: `mvn test` **514 run, 46 red** (exactly the three untouched stubs `DailyTemperatures` 0/18, `ValidParenthesesRedoNov08` 0/18, `MinStackRedoNov01` 0/10). Labs: only `main` `507aaa3`, no `my-solutions`; `Chapter01CheckTest` **1/19**.

## 🌅 Morning

### ⏱️ Time plan (45 min, one item)

| Minutes | Track | Item | Push it |
|---|---|---|---|
| 0-5 | 🌱 | `git pull` both repos, `git switch -c my-solutions` in `spring-boot-labs`, open `chapters/01-maven-and-the-pom/lab/pom.xml` and read the **Task 1** comment fully | — |
| 5-15 | 🌱 | **Task 1**: the three lines directly under `<project>` → `com.ledgerly` · `ledgerly-core` · `0.1.0-SNAPSHOT`; run the chapter checks | **yes, now, even if red** |
| 15-45 | 🌱 | Only if Task 1 is pushed: **Task 2** (the parent: `spring-boot-starter-parent`, three-number version from the root `pom.xml`, empty `relativePath`, placed **before** your `groupId`) | yes, after it |

```bash
cd spring-boot-labs && git pull && git switch -c my-solutions
# edit chapters/01-maven-and-the-pom/lab/pom.xml: the three lines under "Task 1" only
mvn -pl chapters/01-maven-and-the-pom test     # expect task1a/b/c green, the rest red
git add -A && git commit -m "Ch1 task 1" && git push -u origin my-solutions
```

> [!TIP]
> Why it matters for a lead: `groupId : artifactId : version` is the address the artifact repository, the dependency tree and the release pipeline use for this service. Keep the scaffold's `com.example : demo` and two services collide in Nexus; `-SNAPSHOT` decides whether consumers get a moving or a pinned build.

> [!WARNING]
> Task 1 is **only** the project's own three lines, not anything inside `<parent>` or a dependency. Stuck for **15 minutes**? Ask for a hint in chat rather than stopping. Full step table, traps and the interview question: [day16.md § Chapter 1](day16.md#2--spring-boot-labs-chapter-1-maven-and-the-pomxml-50-min) (Task 1 = coordinates, Task 2 = parent; day16-19 had them swapped).

- [ ] Task 1 pushed on `my-solutions` (`task1a-c` green)
- [ ] (only if time) Task 2 pushed (`task2a-e` green)

### 🧩 DSA · 🐞 Buggy · 🔁 Redos: resting today

| Track | Open item (unchanged) | Status | Returns when |
|---|---|---|---|
| 🧩 DSA | `DailyTemperatures` stub 0/18 (2-line brute force + 3-5 lines of pseudocode first) | 🟡 IN_PROGRESS (stub) | after one labs push lands |
| 🐞 Buggy | `Day04LargestRectangle` empty-stack width: one sentence + 3-line ASCII | 🟡 IN_PROGRESS | after DSA resumes |
| 🔁 Redos | `ValidParenthesesRedoNov08` 0/18, `MinStackRedoNov01` 0/10 | on hold | Sat 14 Nov at the earliest ([redo-schedule.md](../revision/redo-schedule.md)) |

### 📦 Carried backlog (not for today)

| Item | Track | Status |
|---|---|---|
| labs Ch 1 Tasks 3-6 + interview Q | 🌱 | ⬜ NOT_STARTED |
| `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) merge or close | 🧩 | 🟡 IN_PROGRESS |
| B2 Q3, Q6 and the catch-all sentence | 🌱 | ⬜ NOT_STARTED |
| Banking module 1 step 1, Drills 2 and 3 | 🏦🌱 | ⬜ NOT_STARTED (**parked**) |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| `Day00BuggyExample` symptom groups | 🐞 | 🟡 IN_PROGRESS |

> [!NOTE]
> 🧭 Pace: one 45-minute block, one item, until two days with a push; then the lighter plan returns. Reply in chat with a different shape (other time, shorter block, a pause for a few days) and the plan follows that instead.
