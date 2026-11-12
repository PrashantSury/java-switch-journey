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

## 🌙 Evening (12 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-15%20min%20max-blue) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Evening review at ~8:00 PM IST on tip `3df22ff` (JDK 21.0.13, Maven). No student commits after the 6 AM session; last student code is still `3019054` (7 Nov 14:11 IST). No answers in chat today to grade. Full `mvn test` re-run: **514 run, 46 red**, exactly the three untouched stubs (`DailyTemperaturesTest` 0/18, `ValidParenthesesRedoNov08Test` 0/18, `MinStackRedoNov01Test` 0/10); everything else green. [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs): still only `main` `507aaa3` (no commit since 6 Nov), no `my-solutions` branch, so today's single item (Task 1, the coordinates) did not land. **No new conceptual mistake** logged. No redo graded, so [redo-schedule.md](../revision/redo-schedule.md) rows are unchanged (queue still on hold).

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **unscored** (⬜ Pending) | No labs push, no Chapter 1 answer. Seventh assigned morning (6–12 Nov) with Chapter 1 at 1/19. Last scored Spring night: 5 Nov (7/10). No number without work |
| 🧩 DSA | **unscored** (⬜ resting) | Track rested by plan; `DailyTemperatures` still the 0/18 stub. Last scored DSA night: 7 Nov (6/10) |
| 🐞 Buggy | **unscored** (⬜ resting) | Track rested by plan; empty-stack width sentence still open. Last scored buggy night: 7 Nov (7/10) |

> [!WARNING]
> Fifth day in a row with no student work (8–12 Nov), including the first one-slot day. This isn't a knowledge problem: the last graded work (5–7 Nov) scored 6–7/10. It's a start-up problem, so tomorrow's block gets smaller again (15 minutes, three lines). If a pause of a few days, a different time, or an evening-only slot fits better right now, say so in chat and the plan follows that.

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 `spring-boot-labs` Chapter 1 (Maven / pom) | ⬜ Pending | seventh morning, no push, no graded Q |
| 🌱 B2 Q3 / Q6 / catch-all sentence | ⬜ Pending (carried) | unanswered |
| 🌱 HTTP semantics / `ResponseEntity` / `@PathVariable` set | 🔴 Weak (carried) | Day 02–03 scores; packs stay parked until labs Ch 1 lands |
| 🧩 `DailyTemperatures` | ⬜ Pending | stub 0/18; resting |
| 🧩 `CarFleet` single-pair / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🟡 Moderate | written merge pending |
| 🔁 `ValidParenthesesRedoNov08` / `MinStackRedoNov01` | ⬜ Pending (on hold) | 0/18 and 0/10; resume on first normal-plan day |
| 🐞 `Day04LargestRectangle` empty-stack width | 🟡 Moderate / ⬜ Pending sentence | geometric why still open |
| 🐞 `Day00BuggyExample` write-up | 🟡 Pending | code 10/10; no symptom groups |
| 🏦 Banking module 1 / Drills 2–3 | ⬜ Pending, **parked** | unchanged |
| ⛔ Blocked | none | nothing outside his control is stopping the work |

No topic is newly 🔴 Weak tonight, so no new weak-topic pack.

### ⏳ Tonight's evening-slot work (finishable; push after it)

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 15 | `spring-boot-labs` Chapter 1 **Task 1**: in `chapters/01-maven-and-the-pom/lab/pom.xml`, the three lines under `<project>` → `com.ledgerly` · `ledgerly-core` · `0.1.0-SNAPSHOT`, on a new `my-solutions` branch | 🌱 | branch pushed (even if red), `task1a-c` green |

Nothing else tonight. If it's already late, skip it and do it tomorrow morning.

### 🎯 Tomorrow's focus (Fri 13 Nov): one-slot day, smaller block

| Track | Focus | Why (from tonight's assessment) |
|---|---|---|
| 🌱 Spring | **15 minutes**: labs Ch 1 **Task 1** only (the three coordinate lines), pushed on `my-solutions` even if red. Task 2 (parent) only if he wants to keep going | 45 minutes didn't start today; the goal is one push, not a chapter |
| 🧩 DSA | resting · `DailyTemperatures` returns after pushes restart, starting with 3–5 lines of plain-English pseudocode | one item per day until two days with a push |
| 🐞 Buggy | resting · LargestRect empty-stack width sentence returns with DSA | same |
| 🔁 Redos | on hold · resume with `ValidParenthesesRedoNov08` then `MinStackRedoNov01` on the first normal-plan day (two push days first, so **Sun 15 Nov at the earliest**) | no redo on one-slot days |

## 🌌 Late push review (12 Nov, 8:04 PM IST): first `spring-boot-labs` push

![Slot](https://img.shields.io/badge/slot-late%20push-yellow) ![Spring](https://img.shields.io/badge/Spring-7%2F10-yellow) ![DSA](https://img.shields.io/badge/DSA-not%20scored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-not%20scored-lightgrey) ![Labs](https://img.shields.io/badge/Ch%201-18%2F19-yellowgreen)

> [!NOTE]
> Reviewed [`5c366dc`](https://github.com/PrashantSury/spring-boot-labs/commit/5c366dcec685e1be1dd869579033ee1bedf390b6) ("completed chapter1", Prashant Suryawanshi, **8:04 PM IST**), pushed to `main` just after the 8 PM review above (`7d3265c`, 7:55 PM IST). Previous labs tip `507aaa3`. Fresh clone, JDK 21.0.13, Maven 3.9.6. **One file changed:** `chapters/01-maven-and-the-pom/lab/pom.xml` (+32 / −3). No checks, harness or README touched. Nothing changed in this repo, so `mvn test` here stands at 514 run / 46 red (the three resting stubs).

### 🧪 Test results (`mvn -pl chapters/01-maven-and-the-pom test`)

**19 run, 1 failure, 0 errors, 0 skipped → 18/19** (was 1/19 on `507aaa3`).

| Task | Checks | Result | What the pom has now |
|---|---|---|---|
| 1 Coordinates | `task1a_groupId`, `task1b_artifactId`, `task1c_version` | 🟡 **2/3** | `com.ledgerly` ✅ · `ledgerly-core` ✅ · version still the scaffold's `0.0.1-SNAPSHOT` ❌ (check: *expected 0.1.0-SNAPSHOT*) |
| 2 Parent | `task2a`-`task2e` | ✅ 5/5 | `spring-boot-starter-parent` `4.1.2` (matches the root pom), empty `<relativePath/>`, placed before the project's own `groupId` |
| 3 Java 21 | `task3_javaVersion` | ✅ 1/1 | the existing `java.version` edited to `21`, no second `<properties>` |
| 4 Web starter | `task4a`-`task4d` | ✅ 4/4 | `spring-boot-starter-webmvc`, no version, no scope |
| 5 Scopes | `task5a`, `task5b` | ✅ 2/2 | `spring-boot-starter-webmvc-test` `test`; `h2` `runtime`; no versions |
| 6 Profile | `task6a`-`task6d` | ✅ 4/4 | `<profiles>` last in `<project>`, `uat` sets `spring-boot.run.profiles` inside the profile |

Real Maven agrees: `help:evaluate maven.compiler.release` prints **21** (inherited from the parent), and `dependency:tree` is `BUILD SUCCESS` with webmvc `4.1.2:compile`, webmvc-test `4.1.2:test`, h2 `2.4.240:runtime`. The root line reads `com.ledgerly:ledgerly-core:jar:0.0.1-SNAPSHOT`, the one difference from the README's finished tree.

### 🔍 What's right and what's left

✅ **Right, and these are the ideas the chapter is about:** parent first, three-number version taken from the root pom, empty `relativePath`, **no versions on any dependency** (the parent picks them), the right scope on each jar, and the profile in the right place. Those are the conceptual parts of Chapter 1, and every one is green.

🟡 **Left (cosmetic, not conceptual):**
1. **`task1c`**: the third coordinate line still has the scaffold's version. You changed two of the three lines and the third one got missed. The red message names the expected value.
2. `<groupId> com.h2database</groupId>` has a leading space. Maven trims it, so it resolves and the check passes, but tidy it while you're in there. The new blocks also use 4-space indents while the file uses 2. That's cosmetic.

Guiding question (for `task1c`): *a teammate depends on `ledgerly-core` at `0.1.0-SNAPSHOT`; which of your three lines decides whether Maven can find this build?*

🎤 **Interview item (task 4): not answered yet.** No written or chat answer. The question is in the README: who picks the starter's version when you don't write one, what happens to all your starters when Spring Boot is upgraded, and the difference between `runtime` and `provided`.

🧭 Process note: the plan said a `my-solutions` branch, and this went to `main`. It isn't scored, and the work counts the same. From the next push on, `git switch -c my-solutions` keeps `main` as the clean stub, so the chapters can be reset or diffed later.

### 📝 Score (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **7/10** (concept 8 · implementation 8 · debugging 6) | 18/19 on his own push, and every conceptual task (parent, no versions, scopes, profile) is green. The one red check is a leftover default whose failure message names the fix, so it was pushed without a final check run. Interview not attempted, so that dimension is skipped (not zero). Last scored Spring night: 5 Nov (7/10) |
| 🧩 DSA | **unscored** (⬜ resting) | No work; `DailyTemperatures` still the 0/18 stub |
| 🐞 Buggy | **unscored** (⬜ resting) | LargestRect empty-stack width sentence still unanswered |

🧪 **Classification:** labs Chapter 1 → 🟡 **Moderate** (weakest: debugging, i.e. reading the red check before pushing). **No new weak topic**, because the miss isn't conceptual. The HTTP semantics / `ResponseEntity` / `@PathVariable` pack (🔴, carried) **stays parked**. Chapter 1 has effectively landed, but packs return with the normal plan, not on one-slot days.

### 🎯 Tomorrow (Fri 13 Nov): still one slot, 15-30 minutes

Today is the **first day with a push**. The rule is two push days before the normal plan returns, so tomorrow is still one slot:

| # | Minutes | Item | Done when |
|---|---|---|---|
| 1 | 5 | Fix `task1c` (and the h2 space), run the chapter checks, push. Ideally on a new `my-solutions` branch | `Chapter01CheckTest` **19/19** pushed |
| 2 | 10-20 | Chapter 1 interview question in chat: 2-3 sentences on who picks the version and what an upgrade changes, plus `runtime` vs `provided` | answer graded in chat |

If Fri 13 also has a push, that's two push days (12 and 13 Nov). The lighter plan and the redo queue (`ValidParenthesesRedoNov08`, then `MinStackRedoNov01`) can then return **Sat 14 Nov**, earlier than the "Sun 15 Nov at the earliest" noted above, which assumed no push today. [redo-schedule.md](../revision/redo-schedule.md) is unchanged, because no redo was graded.

## 🌃 Late push review (12 Nov, 9:01 PM IST): DailyTemperatures + both redos

![Slot](https://img.shields.io/badge/slot-late%20push-yellow) ![DSA](https://img.shields.io/badge/DSA-8%2F10-brightgreen) ![Buggy](https://img.shields.io/badge/Buggy-not%20scored-lightgrey) ![Redos](https://img.shields.io/badge/redos-2%20clean%20%E2%9C%85-brightgreen) ![Suite](https://img.shields.io/badge/mvn%20test-514%2F514-brightgreen)

> [!NOTE]
> Reviewed [`d6ca103`](https://github.com/PrashantSury/java-switch-journey/commit/d6ca1035bc388807de2787b4c5018897b986536f) ("DailyTemperatures, MinStackRedoNov01, ValidParenthesesRedoNov08 completed", Prashant Suryawanshi, **9:01 PM IST**), pushed to `main` of **this repo** (not labs) after the labs review `1fa4e69`. Fresh clone, JDK 21.0.13, Maven 3.9.6. **Three files changed** (+69 / −20), all student solution files: `dsa/stack/DailyTemperatures.java`, `dailytests/redo/MinStackRedoNov01.java`, `dailytests/redo/ValidParenthesesRedoNov08.java`. No tests, specs or records touched. Labs not touched, so labs stays at 18/19 (`5c366dc`). Student files were read and tested only, not edited.

### 🧪 Test results

| Test class | Before (`1fa4e69`) | Now (`d6ca103`) |
|---|---|---|
| `DailyTemperaturesTest` | 0/18 | ✅ **18/18** |
| `ValidParenthesesRedoNov08Test` | 0/18 | ✅ **18/18** |
| `MinStackRedoNov01Test` | 0/10 | ✅ **10/10** |
| Full `mvn test` | 514 run, 46 red | **514 run, 0 failures, 0 errors, 0 skipped**, BUILD SUCCESS |

The 46 red tests were exactly these three stubs, and all of them are green now. Everything else stays green (for example `MinStackTest` 10/10, `ValidParenthesesTest` 2/2, `CarFleetTest` 37/37).

### 🔍 What's right and what's left

**🧩 `DailyTemperatures` (18/18).**
✅ Decreasing stack of **indices**. Each new day pops every colder day still waiting and writes `i - j` as the answer. Days that stay on the stack keep the default 0. There's a null → `IllegalArgumentException` guard, a new array is returned and the input isn't changed. The 100 000-element O(n) test passes.
✅ The pattern line names "next greater element". The **time line gives the amortised reason** ("each index is pushed once and popped at most once, so the inner while loop does O(n) total work"), and the space line names the worst case (strictly decreasing input). That's exactly the "why" that was missing before (count-stack quiz, 29 Oct).
🟡 **Missing process step (not conceptual):** the plan asked for the brute force, the re-scan question and **3-5 lines of plain-English pseudocode** as comments before the Java. None of these is in the file. The code went straight in.
Guiding question: *in the brute force, day `i` scans forward for a warmer day. What does the stack remember, so that no day is ever scanned twice?*

**🔁 `ValidParenthesesRedoNov08` (18/18, cold).** ✅ Blank file, closer-push design (push the expected closer, pop and compare), early `false` on a stray closer or an empty stack, `stack.isEmpty()` at the end, and **the null → `IllegalArgumentException` guard is there on the first try**: the 7 Nov miss didn't come back. Non-bracket characters fall into the closer branch and return `false`, as the spec requires.
🟡 Cosmetic: the three comment lines say `Stack / O(n) / O(n)` without the one-sentence "where the cost comes from" that the file header asks for.
Guiding question: *which input makes the stack hold the most characters, and how many is that?*

**🔁 `MinStackRedoNov01` (10/10, cold, first redo since 23 Oct).** ✅ Parallel min stack (each level stores `min(x, previous min)`), so duplicate minimums and `Integer.MIN_VALUE` survive pops. All four operations are O(1), and `pop`, `top` and `getMin` throw `IllegalStateException` on an empty stack. The pattern, time and space lines each have a clear reason (2n entries is still O(n)). Nothing to fix.

### 📝 Score (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🧩 DSA | **8/10** (concept 8 · implementation 10 · problem solving 6 · complexity 9) | `DailyTemperatures` 18/18 on his own first push: clean monotonic stack of indices, null guard, amortised time reason written down. Problem solving is 6 because the brute force, re-scan question and pseudocode were skipped. Interview not attempted, so that dimension is skipped. Last DSA score: 6/10 (7 Nov) |
| 🐞 Buggy | **unscored** (⬜ resting) | LargestRect empty-stack width sentence + `[2,1,2]` sketch still unanswered |
| 🌱 Spring | unchanged (7/10 from the 8:04 PM labs push above) | not re-graded; this commit didn't touch labs |

🧪 **Classification:** Daily Temperatures → 🟢 **Strong** (8). **No new weak topic.** The pseudocode gap is a habit, not a concept. "Amortised O(n) reasoning" got fresh evidence for Strong-level work (written reason correct, unprompted), but stays 🟡 until a quiz confirms it. The HTTP / `ResponseEntity` / `@PathVariable` pack (🔴) **stays parked**.

### 🔁 Redo outcomes (rules in [redo-schedule.md](../revision/redo-schedule.md#-rules))

| Problem | Result | Ladder | Next due |
|---|---|---|---|
| `ValidParentheses` | ✅ **clean cold pass** (blank `Nov08` file, 18/18 on the first push, no hint and no post-push fix tonight) | **+1 → +3** (rule 2) | due **Sun 15 Nov**, queued **Thu 19 Nov** behind more overdue items (cap 2 a day) |
| `MinStack` | ✅ **clean cold pass** (blank stub, 10/10 on the first push) | **+1 → +3** | due **Sun 15 Nov**, queued **Thu 19 Nov** |
| `DailyTemperatures` (new) | first verified solve, 18/18 | joins at **+1** (rule 9) | due Fri 13 Nov, queued **Wed 18 Nov** |

The redo queue stays on hold on one-slot days. It now starts with `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` on **Sat 14 Nov** (if Fri 13 also has a push). See the rebuilt calendar in [redo-schedule.md](../revision/redo-schedule.md).

### 🎯 Still open, and tomorrow (Fri 13 Nov): still one slot

Today, 12 Nov, is the **first push day**, with two pushes (labs and this). The normal plan returns after a second push day, so Fri 13 Nov stays **one slot, 15-30 minutes**:

| # | Minutes | Item | Done when |
|---|---|---|---|
| 1 | 5-10 | Labs `task1c`: the version line (and the h2 space), re-run the chapter checks, push (ideally on `my-solutions`) | `Chapter01CheckTest` **19/19** |
| 2 | optional | The Chapter 1 interview question or the LargestRect empty-stack width sentence, in chat | graded in chat |

Optional, no push needed: add the 3-5 pseudocode lines to `DailyTemperatures` as comments. If Fri 13 has a push, the normal plan and the redo queue return **Sat 14 Nov**.
