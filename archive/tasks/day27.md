# 📅 Day 27 (Wed 18 Nov): close Chapter 2, finish Contains Duplicate, clear the write-ups

![Week](https://img.shields.io/badge/Week-4-blue) ![Day](https://img.shields.io/badge/Day-27-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h-green) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> No new material today. Every slot finishes something already open: 🌱 labs Chapter 2 **Task 6 + its interview question** (closes the chapter), 🧩 **Contains Duplicate** (carried over, day 2 of 2, stronger hints), 🐞 Wednesday slot = **write-ups**: `DailyTemperatures` comments, then the open `Day05DecodeString` round, then the 🔁 evening redos `Day03NextGreaterIndex` + `AsteroidCollision` (cold). Done when each item is green on your pushed code.

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first. In `spring-boot-labs` stay on `my-solutions`.
>
> State at 6 AM (fresh clones, JDK 21): no student commits after last night's 10 PM check. Labs `my-solutions` tip `00bd2eb` (9:33 PM IST): `Chapter02CheckTest` **15/19**, only `task6a`-`task6d` red (the app does not start: "missing ServletWebServerFactory bean"). This repo, student code unchanged since `221069b`: `ContainsDuplicateTest` 0/17, `Day05DecodeStringTest` 12/25, `Day03NextGreaterIndexRedoNov17Test` 0/37, `AsteroidCollisionRedoNov17Test` 0/28. Last night's evening and 10 PM records did not reach the repo; they are now in [day26.md](day26.md#-evening-17-nov-review-scores-tonight-and-tomorrow) (Spring 6 → **7/10** after the `00bd2eb` fix, DSA **8/10**, buggy unscored).

## 🌅 Morning

### ⏱️ Time plan (120 min morning + evening redos)

| Minutes | Track | Item | Done when |
|---|---|---|---|
| 0-3 | 🌱 | `git pull` both repos; `git checkout my-solutions` in labs | clean pull |
| 3-25 | 🌱 | **Chapter 2 Task 6**: first answer "what does Spring Boot already do once this class is the right kind?", then the change, then start the app and run the README curls | `task6a`-`task6d` green on pushed `my-solutions` → **19/19** |
| 25-40 | 🌱 | **Task 6 interview question**, three sentences, typed in chat (graded there) | answered in chat |
| 40-50 | 🌱 | Only if both are done: pending B2 **Q3 + Q6** and the one sentence "why the catch-all hid Spring's own answers" (in chat) | answered in chat; otherwise buffer |
| 50-85 | 🧩 | **Contains Duplicate** (carried over, day 2 of 2): pseudocode + brute-force comment first, then hint level 1, level 2 only after 15 min stuck | `ContainsDuplicateTest` **17/17** pushed |
| 85-90 | 🐞 | `DailyTemperatures` brute-force + pseudocode **comments** (pending since 12 Nov) | comment-only push |
| 90-105 | 🐞 | `Day05DecodeString` (open Tuesday round): symptom groups first, then smallest fixes | `Day05DecodeStringTest` **25/25** pushed |
| 105-120 | — | Push, buffer, hint requests | nothing left unpushed |
| Evening ③ (cap 2) | 🔁 | `Day03NextGreaterIndex` then `AsteroidCollision`, cold, 20-30 min each | see the redo table below |

> [!TIP]
> Stuck 15 minutes on any step? Ask for a hint. Push after each item, even if red. 3-5 lines of plain-English pseudocode before any Java, every time.

### 🌱 1. Chapter 2, Task 6 (Interview): the application class (~25 min + 15 min interview)

Where: [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs), branch `my-solutions`, file `chapters/02-first-spring-boot-app/src/main/java/ledgerly/LedgerlyApplication.java` (the `// Task 6` comment is there). Tests: `mvn -pl chapters/02-first-spring-boot-app test`. Chapter README: "Your turn" item 6 and "Interview question (task 6)".

> [!IMPORTANT]
> ✅ Done when `task6a`-`task6d` are green on the pushed `my-solutions` branch (Chapter 2 **19/19**) **and** the interview question is answered in chat. Then Chapter 2 is closed and Chapter 3 opens tomorrow with the full 12-part spec.

#### 💡 Why it matters
Tasks 1-5 passed without ever starting Spring: the checks build `AccountController` by hand (`new AccountController()` inside `MockMvcBuilders.standaloneSetup`). Production does not work like that. Something has to create the context, find your controllers and stand up Tomcat. In an interview, "what does the main class actually switch on?" separates people who use Boot from people who can debug it when a bean is "not found" at 3 AM.

#### 🧠 The concept in two sentences
A Boot application class has three jobs: be a **configuration** (a source of bean definitions), turn on **auto-configuration** (beans picked from what is on the classpath, such as a servlet web server because Spring MVC is there), and turn on **component scanning** (find `@Component`s, `@RestController`s included, in its own package and below). `SpringApplication.run(LedgerlyApplication.class, args)` uses that class as the starting point for all three, so if the class carries none of them, the context has nothing to build.

#### 🧪 The real output this morning (your code at `00bd2eb`)

```text
task6a  FAIL  LedgerlyApplication is not a @SpringBootConfiguration. Which one annotation includes it?
task6b  FAIL  LedgerlyApplication does not enable auto-configuration
task6c  FAIL  LedgerlyApplication does not scan for components
task6d  FAIL  the app did not start: No qualifying bean of type
              'org.springframework.boot.web.server.servlet.ServletWebServerFactory' available
```

| Test | What it checks | Why it is red today |
|---|---|---|
| `task6a` | the class is a configuration | the class has no annotation at all |
| `task6b` | auto-configuration is on | same; nothing asks Boot to look at the classpath |
| `task6c` | component scanning is on | same; nothing asks Spring to look for `AccountController` |
| `task6d` | the app starts and `AccountController` is a bean | the context starts empty, so no web server factory exists: that bean comes from one of the three jobs above. Which one? |

#### 🧭 Guide (questions, not the answer)
1. **What does Spring already handle?** Once the class is the right kind, do you need to write a `@Bean` for Tomcat, list any package, or touch `application.properties`? (Write your one-line answer before the code.)
2. The `// Task 6` comment says **one** annotation gives all three jobs. Which annotation is on the main class of every Boot project you have shipped at HSBC?
3. For `task6d`: which of the three jobs creates `ServletWebServerFactory`, and which one makes `AccountController` a bean?
4. After the tests are green, start the app (`mvn -pl chapters/02-first-spring-boot-app spring-boot:run`) and run the README curls on port **8081**, including `curl "localhost:8081/double?n=three"`. Note what status that one returns and who produced it (you wrote no handler).

> [!WARNING]
> Gotchas: (1) Do not add `@EnableWebMvc`; in a Boot app it switches **off** Boot's MVC auto-configuration (message converters, static resources, error handling defaults). (2) Do not add `scanBasePackages` or an extra `@ComponentScan`; the default (this class's package and below) already covers `ledgerly`. (3) Leave `BranchController` alone; it is the demo you curl after Task 6.

#### 🎤 Interview question (answer in chat, three sentences, aloud first)
*What does the application-class annotation switch on?* Name the three annotations inside it and what each does. Then: *what happens if the controller class is in a package above the application class?* Senior add-on (one more sentence): how would you see **why** an auto-configuration did or did not apply (think `--debug`)?

**Knowledge checks:**

1. `task6d` said "No qualifying bean of type `ServletWebServerFactory`". The missing job was:
   - A. configuration
   - B. auto-configuration
   - C. component scanning
   - D. the `@RestController` on `AccountController`
2. You put `@EnableWebMvc` next to the application-class annotation "to be safe". What changes?
   - A. Nothing, it is already implied
   - B. Boot backs off its own MVC auto-configuration, so defaults you relied on (for example its message converter and error setup) may disappear
   - C. The app fails to start
   - D. Component scanning stops
3. In `SpringApplication.run(LedgerlyApplication.class, args)`, the class argument is:
   - A. only used for logging
   - B. the primary source: its annotations decide configuration, auto-configuration and the base package for scanning
   - C. instantiated as a controller
   - D. ignored when `application.properties` exists

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Answers.** (1) **B**: the web server factory is one of the beans auto-configuration adds because Spring MVC and Tomcat are on the classpath. (2) **B**. (3) **B**.

</details>

- [ ] One line first: "Spring Boot already ___, so I only add ___".
- [ ] `task6a`-`task6d` green → **19/19**. Push on `my-solutions`.
- [ ] Start the app, run the README curls, stop it.
- [ ] Interview question answered in chat.

### 🧩 2. DSA: Contains Duplicate, carried over (day 2 of 2, ~35 min)

![Type](https://img.shields.io/badge/type-DSA%20Arrays%20%26%20Hashing-blue) ![Tests](https://img.shields.io/badge/ContainsDuplicateTest-0%2F17-orange) ![Carry](https://img.shields.io/badge/carry--over-day%202%20of%202-yellow)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/arrayshashing/ContainsDuplicate.java` · tests `ContainsDuplicateTest` (17). Full 8-part spec (problem, constraints, pattern, brute force, follow-ups, locked dry run): [day26.md](day26.md#-2-dsa-contains-duplicate-35-min). ✅ Done when 17/17 pass on your pushed code, with the pseudocode and brute-force comments first and pattern / time / space lines that each say **where** the cost comes from. Not started yesterday, so today it comes with stronger hints; nothing stays open more than 2 days.

> [!NOTE]
> Why no new problem today: under the pace agreed on 16 Nov, an unfinished problem carries over with stronger hints instead of a new one piling on. **Valid Anagram** (Arrays & Hashing 2 of 9) is Thursday's problem either way. If Contains Duplicate is still red tonight, we close it together in chat on Thursday (it counts as solved with hints) and Valid Anagram starts on time.

**Step 0, before any Java (5 min).** Fill the comment lines already waiting in the stub: 3 pseudocode lines, the brute force in one line, and your answer to *"how many pair comparisons for n = 1 000 000, and why do the two `large` tests (1 000 000 values within 2 s) fail with that?"*

**Hint level 1: guiding questions (use first).**

| # | Question | Why it helps |
|---|---|---|
| 1 | What is the one fact you need to remember about the values already passed? | it tells you which data structure to keep |
| 2 | Which Java collection answers "have I seen x?" in O(1) on average? | that is the structure |
| 3 | What does `Set.add` **return** when the value is already there? | it lets you check and insert in one call |
| 4 | When can you stop early, and what do you return if the loop ends? | the two return points |
| 5 | Which three rules come before the loop or are guaranteed by it: `null`, empty/one element, "do not modify the caller's array"? | `null` and "do not modify" are the two most-missed tests |

<details>
<summary><b>🪜 Hint level 2: partial skeleton (open only after 15 minutes stuck on level 1)</b></summary>

```java
public boolean containsDuplicate(int[] nums) {
    // rule 1: what happens for null? (the tests expect an exception type, see the class Javadoc)
    // TODO

    // a structure that remembers the values already seen; can you size it up front?
    // TODO

    for (int x : nums) {
        // TODO: one line that both checks and remembers x, and returns early on a repeat
    }
    // TODO: what is left to return if the loop finished?
}
```

You still write every `TODO` line yourself. The sort-a-copy variant is a valid second answer: say in a comment why it must sort a **copy**, and what that costs in space.

</details>

- [ ] Pseudocode + brute-force comment (with the 10^6 answer) before any Java.
- [ ] Pattern / time / space lines, one reason sentence each.
- [ ] `mvn test -Dtest=ContainsDuplicateTest` → **17/17**. Push.
- [ ] Knowledge checks 1-3 in [day26.md](day26.md#-2-dsa-contains-duplicate-35-min): answer in chat before opening the locked block.

### 🐞 3. Wednesday slot: write-ups first, then the open round (~20 min)

> [!NOTE]
> Buggy rounds are Tuesday and Friday only, so there is **no new buggy file today**. The slot goes to open work, oldest first: the `DailyTemperatures` comments (open since 12 Nov), then `Day05DecodeString` (Tuesday's round, untouched at 12/25). Friday's new round (on the Arrays & Hashing pattern) is given only once `Day05DecodeString` is ✅; otherwise Friday's slot finishes it.

**3a. `DailyTemperatures` comments (5 min).** 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` (code already ✅ 18/18). Above the Java, add:

- [ ] one brute-force comment line (what the naive re-scan does and its cost, with the reason)
- [ ] 3-5 lines of plain-English pseudocode of **your** stack solution
- [ ] comment-only push

**3b. `Day05DecodeString` (15 min).** Full spec (rules, normal / edge / failure cases, pattern checks): [day26.md](day26.md#-3-tuesday-buggy-round-day05decodestring-stack-20-min). 📂 `src/main/java/com/prashant/dailytests/Day05DecodeString.java`.

- [ ] Run `mvn test -Dtest=Day05DecodeStringTest`; write the failures grouped by symptom (which inputs fail, which pass) as a comment **before** changing code.
- [ ] Smallest fixes, one comment line each naming the test that led you there.
- [ ] **25/25**. Push. If the 15 minutes run out, push the symptom groups anyway.

### 🔁 Evening redos (cap 2, most overdue first, cold)

| Redo | File (blank stub, from 17 Nov, still untouched) | Tests | Gap | Why now |
|---|---|---|---|---|
| 🐞 `Day03NextGreaterIndex` | `src/main/java/com/prashant/dailytests/redo/Day03NextGreaterIndexRedoNov17.java` | `mvn test -Dtest=Day03NextGreaterIndexRedoNov17Test` (0/37) | +1, due 30 Oct | most overdue; not attempted Tue 17 Nov, so the queue moved one day |
| 🧩 `AsteroidCollision` | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | `mvn test -Dtest=AsteroidCollisionRedoNov17Test` (0/28) | +1, due 1 Nov | next most overdue |

> [!CAUTION]
> **Cold means cold.** Blank file, 25-minute timer, no peeking at `dailytests/Day03NextGreaterIndex`, `dsa/stack/AsteroidCollision` or `DailyTemperatures`. A redo whose body matches the original counts as **not passed** (the 16 Nov pair scored 2/10 for exactly that). A red push from memory beats a green copy.

- [ ] Each starts with a **pattern line + time and space comments** (one sentence each saying where the cost comes from), then 3-5 lines of pseudocode, then code.
- [ ] Push at the end of each, even if red.

### 📦 Carried backlog (not for today unless a slot frees up)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) still open | 🧩 | 🟡 IN_PROGRESS |
| 2 | B2 interview Q3 and Q6 + "why the catch-all hid Spring's own answers" (40-50 min slot if free) | 🌱 | ⬜ NOT_STARTED |
| 3 | Banking module 1 step 1, Drills 2 and 3 (parked; Spring slot is `spring-boot-labs`) | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 4 | `ScoreOfParentheses` follow-up questions (with its Mon 23 Nov redo) | 🧩 | ⬜ NOT_STARTED |
| 5 | Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| 6 | `Day00BuggyExample` symptom groups (write-up) | 🐞 | ⬜ NOT_STARTED |
| 7 | 🔁 `RemoveKAdjacentDuplicates` + `ScoreOfParentheses` cold redos (now **Mon 23 Nov**, blank files) | 🔁 | 🟡 IN_PROGRESS |
| 8 | Maven scopes: one applied question (`provided` in a WAR) at the next check | 🌱 | 🟡 IN_PROGRESS |

### ✅ Morning checklist

- [ ] Chapter 2 Task 6 pushed on `my-solutions` → **19/19**
- [ ] Task 6 interview question answered in chat
- [ ] `ContainsDuplicate` pseudocode + code pushed → **17/17**
- [ ] `DailyTemperatures` comments pushed
- [ ] `Day05DecodeString` symptom groups + fixes pushed → **25/25**
- [ ] Evening: the two cold redos

### 🧹 Housekeeping (Lumi, this morning)

- Last night's 8 PM review and 10 PM check records had not reached the repo; added now: [day26.md](day26.md#-evening-17-nov-review-scores-tonight-and-tomorrow) Evening + End of day, two PROGRESS score rows and log rows, and the Task 5 `Math.min`-for-a-minimum mistake in [mistakes/spring.md](../../revision/mistakes/spring.md) (fixed in `00bd2eb`).
- [redo-schedule.md](../../revision/redo-schedule.md): the 17 Nov pair was not attempted, so every queued date moved one day; the whole calendar was re-simulated (60 redos left, last graduation Tue 19 Jan 2027). The 17 Nov blank stubs are reused today (no duplicates). The Sun 22 Nov pair is now Mon 23 Nov.
- PROGRESS: the "Today's plan" pointer (still pointing at day20) now points here; Chapter 2 rows, Pending and Next recommended refreshed.
- No cosmetic fixes needed: no new student code since last night.

## 🌙 Evening (18 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Checked at ~8 PM IST on fresh clones (JDK 21, Maven). **No student commits today** in either repo (this repo's tip is the 6 AM `0861fb2`; labs `my-solutions` is still `00bd2eb` from 17 Nov 9:33 PM IST) and **no answers in chat today**. Re-run results are unchanged from the morning, so no track can be scored tonight. Last scores stand: Spring **7**, DSA **8**, Buggy **7** (last scored 7 Nov). No new conceptual mistake was logged, and nothing cosmetic needed fixing.

| Track | Score | Evidence (re-run tonight) |
|---|---|---|
| 🌱 Spring | **can't be scored yet** | `Chapter02CheckTest` **15/19**; `task6a`-`task6d` still red (Task 6 untouched); Task 6 interview question not answered |
| 🧩 DSA | **can't be scored yet** | `ContainsDuplicateTest` **0/17** (stub untouched, day 2 of 2) |
| 🐞 Buggy | **can't be scored yet** | `Day05DecodeStringTest` **12/25** as shipped; `DailyTemperatures` comments not pushed |
| 🔁 Redos | not attempted yet (tonight's slot) | `Day03NextGreaterIndexRedoNov17` 0/37, `AsteroidCollisionRedoNov17` 0/28 |

### 🗂️ Topic classification tonight

| Topic | Class | Why |
|---|---|---|
| Ch 2 Task 6: the application class (`@SpringBootApplication` = configuration + auto-configuration + component scan) | ⏳ Pending | not started; the red tests point straight at the task, so it is not blocked |
| Contains Duplicate (HashSet, early exit) | ⏳ Pending | day 2 of 2 of the carry-over; closes with hints in chat on Thursday if still red tonight |
| `Day05DecodeString` (two stacks, saved text goes in front) | ⏳ Pending | open since Tue 17 Nov; the 17 Nov chat walkthrough ("save at `[`, glue in front at `]`") is the hint |
| `DailyTemperatures` pseudocode + brute-force comments | ⏳ Pending | open since 12 Nov |
| Day03 + Asteroid cold redos | ⏳ Pending | tonight's slot; if nothing lands by the 10 PM check, the queue moves one day again |
| HTTP semantics; `ResponseEntity` vs `@ResponseStatus` | 🔴 Weak (unchanged) | no new evidence; the short packs from 16 Nov still apply: [pack 2](day25.md#-weak-topic-pack-2-http-semantics-carried-short), [pack 3](day25.md#-weak-topic-pack-3-responseentity-vs-responsestatus-location-carried-short) |
| Everything else in PROGRESS "Weak topics" | unchanged | no new graded evidence today |
| ⛔ Blocked | none | nothing outside the tasks is in the way |

> [!TIP]
> The two 🔴 Weak packs were written on 16 Nov and haven't been attempted yet, so no new pack tonight. Each still has notes, one concept question, one implementation exercise, one debugging exercise and one interview scenario. Writing new ones before those are done would only add to the pile.

### 🌙 Tonight (the rest of the evening slot, in this order)

1. 🌱 **Ch 2 Task 6** (~20 min). First write one line: "Spring Boot already ___, so I only add ___". Then make the change and push to `my-solutions` → **19/19**.
2. 🧩 **Contains Duplicate** (~25 min). Write the pseudocode + brute-force comment, then code. Push it even if red. It's the last day of the carry-over.
3. 🔁 If time is left, **one** cold redo: `Day03NextGreaterIndexRedoNov17` (blank file, 25-minute timer, no peeking). Asteroid can wait for the 10 PM check.
4. `DailyTemperatures` comments and `Day05DecodeString` move to Thursday's buggy minutes (below).

### 🔮 Tomorrow's focus (Thu 19 Nov), based on tonight

| Track | Focus | Why (from tonight's assessment) |
|---|---|---|
| 🌱 Spring | **Finish Chapter 2 before anything new.** If Task 6 is still red, it comes first again with a stronger hint (the class is missing the one annotation that turns on auto-configuration and component scanning). Then the Task 6 interview question in chat. Chapter 3 starts only once Ch 2 is 19/19 and the interview question is answered. | Task 6 is the last red item and its interview question is ungraded. Starting Chapter 3 on top of it would repeat the pile-up from 8-11 Nov. |
| 🧩 DSA | If Contains Duplicate is still red, we close it together in chat first (~10 min; it counts as solved with hints). Then **Valid Anagram** (Arrays & Hashing 2 of 9) starts on time, pseudocode first. | The 2-day carry-over limit is reached. Valid Anagram uses the same idea (a frequency map / set), so closing Contains Duplicate first makes it easier. |
| 🐞 Buggy | `DailyTemperatures` comments (5 min), then close `Day05DecodeString` (day 3, so it comes with hints in chat). Friday's buggy round only after it's ✅. | Two buggy items are open, and there has been no buggy score since 7 Nov. |
| 🔁 Redos | Whatever doesn't land tonight from Day03 + Asteroid goes first (cap 2). | The redo ladder hasn't moved since 12 Nov. |

> [!IMPORTANT]
> Small wins beat a perfect plan: one push tonight (even a red Task 6 or a red Contains Duplicate) keeps Thursday light. Stuck 15 minutes on anything? Ask for a hint here.

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey) ![Ch2](https://img.shields.io/badge/Chapter%202-15%2F19-yellowgreen)

> [!NOTE]
> 10 PM check: **no student commits after the 8 PM review** (labs `my-solutions` still `00bd2eb`, 17 Nov 9:33 PM IST; this repo's student code still `221069b`; tip `0981cd6` is the evening-review commit), so the evening re-run stands: `Chapter02CheckTest` **15/19**, `ContainsDuplicateTest` 0/17, `Day05DecodeStringTest` 12/25, redos 0/37 + 0/28. All three tracks stay **unscored** (last Spring 7, DSA 8, Buggy 7). One chat exchange: at **8:20 PM IST** Prashant said he looked for Task 6 yesterday but could not find it. Answer given: Task 6 goes in `chapters/02-first-spring-boot-app/src/main/java/ledgerly/LedgerlyApplication.java` (not `AccountController.java`; the README says "You edit two files"), one annotation on the class, then the interview question. That is a **findability problem, not a concept gap**, so nothing goes to the mistakes file. Lumi also offered to reword the labs README Task 5 tip ("take the minimum of 10", which probably led to the 17 Nov `Math.min` slip). That edit waits for Prashant's OK, and the labs repo was not touched. Neither redo was attempted, so the queue moved one day.

| Item | Track | Outcome | Status |
|---|---|---|---|
| Chapter 2 Task 6 + interview question | 🌱 | not started (task6a-d red). He was stuck on **where** the code goes (17-18 Nov), not on the concept; the location was answered in chat at 8:20 PM IST, so it is unblocked. It was not logged as ⛔ BLOCKED because nothing outside the task needed fixing | ⬜ NOT_STARTED (unblocked; first task Thu 19 Nov) |
| `ContainsDuplicate` | 🧩 | untouched, 0/17. The 2-day carry-over limit is reached | 🟡 IN_PROGRESS (Thu 19 Nov: closed together in chat with a strong-hint walkthrough, ~10 min, then pushed → 17/17; counts as solved with hints) |
| `Day05DecodeString` | 🐞 | untouched, 12/25 | 🟡 IN_PROGRESS (Thu 19 Nov is day 3, so it closes with hints in chat; must be ✅ before Friday's round) |
| `DailyTemperatures` comments | 🧩 | not pushed | 🟡 IN_PROGRESS (Thu buggy minutes, 5 min) |
| B2 Q3 + Q6 + the catch-all sentence | 🌱 | not reached | ⬜ NOT_STARTED |
| 🔁 `Day03NextGreaterIndex`, `AsteroidCollision` | 🔁 | not attempted (second evening in a row). Missed is not failed, so no gap changed | 🟡 IN_PROGRESS (moved to Thu 19 Nov, same blank `...RedoNov17` stubs) |
| Labs README Task 5 tip wording | 🌱 | Lumi offered a clearer wording in chat | waiting for Prashant's OK; `spring-boot-labs` not edited |

> [!IMPORTANT]
> **First task Thu 19 Nov:** labs Chapter 2 **Task 6** in `chapters/02-first-spring-boot-app/src/main/java/ledgerly/LedgerlyApplication.java` (on `my-solutions`; first the one line "Spring Boot already ___, so I only add ___") → push → `Chapter02CheckTest` **19/19**, then the Task 6 interview question answered in chat. Next: close **`ContainsDuplicate`** with a strong-hint walkthrough in chat (~10 min, then push → 17/17) **before** Valid Anagram. Chapter 3 starts only after Ch 2 is 19/19 and the interview question is answered. Buggy minutes: `DailyTemperatures` comments, then `Day05DecodeString` with hints. Evening redos: `Day03NextGreaterIndexRedoNov17` + `AsteroidCollisionRedoNov17` (cold). CarFleet + LargestRect move to Fri 20 Nov ([redo-schedule.md](../../revision/redo-schedule.md)). **Pending items: 10** ([PROGRESS.md](../../PROGRESS.md#-pending)).
