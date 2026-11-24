# Day 30 · Sat 21 Nov · 120 min

**Focus:** weekend catch-up — two interview answers, Two Sum and Day06 with stronger hints, two cold redos · Past day: kept for history; the original day file is in the block below, unchanged.

## ✅ Today (as planned)

| # | Min | Track | Item | Done when |
|---|---|---|---|---|
| 1 | 0-10 | 🌱 | **Chapter 2 Task 6 interview answer** in chat + Ch 3 knowledge checks 1-3 (letters only) | answered in chat → closes Chapter 2 (owed since 19 Nov) |
| 2 | 10-30 | 🌱 | **Ch 3 re-answer** (Q1 parts 2-3) + senior **Q2** and **Q3** | written in labs `chapters/03-.../interview-answer.md` on `my-solutions` and pushed, or in chat |
| 3 | 30-35 | 🌱 | Mistake-log redo: **floor vs cap** (below) | one line in chat |
| 4 | 35-65 | 🧩 | **Two Sum** carry-over, day 2 of 2, guiding questions → partial skeleton | `TwoSumTest` **19/19** pushed |
| 5 | 65-80 | 🐞 | **`Day06FirstUniqueCode`** carry-over, symptom groups given | `Day06FirstUniqueCodeTest` **20/20** pushed, one comment per fix |
| 6 | 80-105 | 🔁 | **`AsteroidCollisionRedoNov17`** cold (25-min timer) | 28/28 pushed (push even if red) |
| 7 | 105-120 | 🔁 | **`CarFleetRedoNov20`** cold — start it; finish in the evening slot if needed | 37/37 pushed |
| 8 | ~2 PM | 📆 | Weekly performance review (automatic) | — |

<details><summary>📜 Full day file (original layout: morning specs, evening review, end of day)</summary>

# 📅 Day 30 (Sat 21 Nov): weekend catch-up — two interview answers, Two Sum and Day06 with stronger hints, two cold redos

![Week](https://img.shields.io/badge/week-4-blue) ![Day](https://img.shields.io/badge/day-30-blue) ![Type](https://img.shields.io/badge/type-weekend%20(no%20new%20problems)-lightgrey) ![Spring](https://img.shields.io/badge/Spring-interview%20answers-green) ![DSA](https://img.shields.io/badge/TwoSum-0%2F19%20day%202%20of%202-orange) ![Buggy](https://img.shields.io/badge/Day06-6%2F20%20day%202-orange) ![Redos](https://img.shields.io/badge/redos-Asteroid%20%2B%20CarFleet-purple)

> [!IMPORTANT]
> Saturday catch-up (weekend: no new problem, no new buggy round, no Chapter 4): close the two owed Spring interview answers, finish the Two Sum and `Day06FirstUniqueCode` carry-overs with stronger hints, and do the two overdue cold redos. **Done when** Chapter 2's interview is graded, `TwoSumTest` 19/19 and `Day06FirstUniqueCodeTest` 20/20 are pushed, and both redos are pushed cold.

> [!NOTE]
> **Legend:** 🌱 Spring (`spring-boot-labs`) · 🧩 DSA · 🐞 buggy round · 🔁 redo · ✅ done · ❌ missed · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Week 4, Day 30. Sections: 🌅 Morning, 🌙 Evening, 🌒 End of day.

## 🌅 Morning

> [!NOTE]
> Saturday rules: **no new DSA problem, no new buggy round, no Chapter 4.** Today is carry-overs, redos and review. Nothing new on a track until its open items close.

> [!NOTE]
> State at ~6:10 AM IST (fresh clone in `/workspace/morning-day30`, JDK 21, Maven): **no student commits since the 20 Nov 8 PM review** in either repo (labs `my-solutions` tip `e619f82`, 20 Nov 1:04 PM IST; this repo's tip was `a9ec0d4`, the Day 29 morning). No answers in chat after the review. Re-run: **795 run / 98 red**, exactly the open stubs (`TwoSum` 0/19, `Day06FirstUniqueCode` 6/20, `AsteroidCollisionRedoNov17` 0/28, `CarFleetRedoNov20` 0/37). Housekeeping: last night's evening review and 10 PM notes ([day29.md](day29.md#-evening-20-nov-review-scores-tonight-and-tomorrow)) never reached the repo (both the 8 PM and 10 PM push approvals expired), so they go in with this morning's commits. No cosmetic fixes needed (none of your code changed).

### ⏱️ Time plan (120 min)

| Min | Track | Item | Done when |
|---|---|---|---|
| 0-10 | 🌱 | **Chapter 2 Task 6 interview answer** in chat + Ch 3 knowledge checks 1-3 (letters only) | answered in chat → closes Chapter 2 (owed since 19 Nov) |
| 10-30 | 🌱 | **Ch 3 re-answer** (Q1 parts 2-3) + senior **Q2** and **Q3** | written in labs `chapters/03-.../interview-answer.md` on `my-solutions` and pushed, or in chat |
| 30-35 | 🌱 | Mistake-log redo: **floor vs cap** (below) | one line in chat |
| 35-65 | 🧩 | **Two Sum** carry-over, day 2 of 2, guiding questions → partial skeleton | `TwoSumTest` **19/19** pushed |
| 65-80 | 🐞 | **`Day06FirstUniqueCode`** carry-over, symptom groups given | `Day06FirstUniqueCodeTest` **20/20** pushed, one comment per fix |
| 80-105 | 🔁 | **`AsteroidCollisionRedoNov17`** cold (25-min timer) | 28/28 pushed (push even if red) |
| 105-120 | 🔁 | **`CarFleetRedoNov20`** cold — start it; finish in the evening slot if needed | 37/37 pushed |
| ~2 PM | 📆 | Weekly performance review (automatic) | — |

> [!WARNING]
> 🔁 **Redos are cold only.** Open the blank stub, close every other tab, don't look at `dsa/stack/AsteroidCollision.java` or `CarFleet.java`. Write the pattern line and time/space (each with a **because**) first. A redo that matches the original solution counts as **not passed** and repeats the same gap.

### 🌱 1. Spring: close Chapter 2's interview, re-answer Chapter 3 (~35 min, no new chapter)

**Why it matters.** Your code is strong (Ch 2 19/19, Ch 3 15/15 on the first push). The gap is explaining it, and that's what a senior interview scores. Chapter 4 (`@Qualifier`, injection styles) builds on both answers, so it waits until they're done.

**1a. Chapter 2 Task 6 (in chat, ~10 min).** In 4-8 sentences:
1. Which three annotations does `@SpringBootApplication` combine, and what does each one do at startup?
2. `LedgerlyApplication` is in `ledgerly`, and a new controller is put in a package **above** it. What happens when you call its URL, and why?
3. An auto-configuration you expected didn't apply. How do you find out why? (one command-line flag, plus what you look for in its output)

Then Ch 3 knowledge checks 1-3 from the chapter README, letters only.

**1b. Chapter 3 re-answer (~20 min).** Rewrite only what was wrong (graded 5/10 on 20 Nov):
- **Part 2:** "Is a singleton bean thread-safe?" Say *why* it isn't by default (where fields live and where locals live), then give **two real fixes**. Deep copies aren't a fix. Read the 20 Nov weak pack first ([day29.md](day29.md#-weak-topic-pack-singleton-beans-and-shared-mutable-state)).
- **Part 3:** `@Component` vs `@Bean`: add the **why** (what finds each one, and the "needs code to build it" case).
- **Q2 (senior):** singleton `TransferService` with `private BigDecimal runningTotal`; totals drift under load. Why, and two fixes with trade-offs (one of them must survive 3 instances and a restart).
- **Q3 (senior):** a prototype `Receipt` injected into a singleton's constructor. Does each transfer get a new receipt? If not, two ways to get a fresh one per call.

| Fix for shared state | Works across threads in 1 JVM? | Works across 3 instances / restart? | Cost |
|---|---|---|---|
| keep it in a local variable | ✅ | n/a (nothing shared) | none |
| `AtomicLong` / `ConcurrentHashMap` | ✅ | ❌ | contention on hot keys |
| `synchronized` | ✅ | ❌ | serialises callers |
| DB row: `UPDATE ... SET total = total + ?` | ✅ | ✅ | a DB round trip, row lock |

**1c. Mistake-log redo: floor vs cap (5 min, due since 20 Nov).** No code. In one line each, in chat: (a) "The fee is 1% but **at least** ₹10" → `Math.___(amount / 100, 10)`; (b) "cashback is 2% but **at most** ₹500" → `Math.___(amount * 2 / 100, 500)`; (c) one sentence: how do you decide which one before typing?

**Knowledge checks (Spring):**
1. A singleton bean's method has `int fee = amount / 100;`. Two threads call it at once. Is `fee` shared?
   - A. yes, singletons share everything · B. no, locals live on each thread's stack · C. only if `fee` is `static` · D. only under `@Transactional`
2. Marking `private int count;` as `volatile` makes `count++` safe:
   - A. yes · B. no, `volatile` gives visibility, not an atomic read-modify-write · C. only on one CPU · D. only in Java 21
3. A singleton injects a prototype bean through its constructor. How many prototype instances does it use?
   - A. one per call · B. one, created when the singleton is built · C. none · D. one per thread

### 🧩 2. DSA: Two Sum, carry-over day 2 of 2 (~30 min)

![Tests](https://img.shields.io/badge/TwoSumTest-0%2F19-orange) ![Hint](https://img.shields.io/badge/hint-stronger%20(day%202)-yellow)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/arrayshashing/TwoSum.java` · tests `TwoSumTest` (19). Full spec: [day29.md Two Sum](day29.md#-2b-dsa-two-sum-new-arrays--hashing-3-of-9-30-min). This is day 2, so it closes today with stronger hints (rule: nothing stays open more than 2 days). Monday's new problem comes only after this is 19/19. Pseudocode (3-5 lines) and the brute-force comment come **before** any Java.

**Step 1: guiding questions (5 min, answer them in the comment block).**
1. At index `j` with value `x`, which exact value completes the pair? Write it as an expression.
2. "Have I seen that value, and **at which index**?" Which `java.util` type answers both in O(1)? What's the key and what's the value?
3. Trace `[3, 2, 4]`, target 6, twice: once storing `x` **before** looking up its partner, once **after**. Which order returns `[0, 0]`?
4. With `target = Integer.MIN_VALUE`, `x = Integer.MAX_VALUE`, what does `target - x` give in `int`? Which type stops the wrap?

**Step 2: partial skeleton (open after 15 minutes stuck, or straight away if Step 1 is done).** Fill the `___` blanks; the structure is given, the decisions are yours.

```java
if (nums == null) throw new IllegalArgumentException("nums must not be null");
Map<Integer, Integer> seen = new HashMap<>();          // value -> ___
for (int j = 0; j < nums.length; j++) {
    long need = ___;                                   // computed so it can't wrap
    if (need >= Integer.MIN_VALUE && need <= Integer.MAX_VALUE
            && seen.containsKey((int) need)) {
        return new int[] { ___, j };
    }
    seen.___(nums[j], j);                              // keep the FIRST index
}
throw new IllegalArgumentException("no pair adds up to " + target);
```

Then the three comment lines: pattern, time **because**, space **because** (one sentence each on where the cost comes from).

- [ ] guiding answers + pseudocode + brute-force comment (n = 1 000 000 → how many pairs?)
- [ ] `mvn test -Dtest=TwoSumTest` → **19/19**, push
- [ ] knowledge checks 1-3 from day29.md in chat, then open the locked block there

### 🐞 3. Buggy: `Day06FirstUniqueCode`, carry-over day 2 (~15 min)

![Tests](https://img.shields.io/badge/Day06FirstUniqueCodeTest-6%2F20-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java` · tests `Day06FirstUniqueCodeTest` (20). Spec: [day29.md 3b](day29.md#3b-friday-buggy-round-day06firstuniquecode-arrays--hashing-13-min-may-continue-saturday). **Fix only, don't rewrite.** Smallest change per bug. Expected: the index of the **leftmost** code that appears exactly once in `codes` (lowercase `a`-`z` only), `-1` if none, `IllegalArgumentException` for `null` or any other character.

**Stronger hint: the failing tests, already grouped by what you see** (you find the cause; trace each group by hand on its smallest input first):

| Group | Failing tests | What the test sees |
|---|---|---|
| A | `uppercase`, `digit`, `aboveZ`, `space` (4) | an invalid code is **not rejected**: no `IllegalArgumentException` |
| B | `single` (`a`), `twoEqual` (`aa`), `allRepeat` (`aabb`) (3) | wrong on the tiniest inputs: `a` gives `-1`, `aa` gives `0` |
| C | `leetcode`, `loveleetcode`, `ledgerly`-style, `leftmostNotAlphabetical`, `settlementFile`, `firstRepeatsAtEnd`, `uniqueLast`, `alphabetOnce` (7) | returns an index, but **not the one the test wants** |

Guiding questions, one per group: **A.** Hand-trace the input `"A"`: which statement is meant to notice it's invalid, and is its condition ever `true` for *any* character? **B.** For `"a"`, write the `count` array after the counting loop. Is every character counted? **C.** For `"zxa"`, the answer is `0`. In what order does the method *look for* a count of 1, and is that the order the problem asks for?

Fix order tip: groups overlap (C still fails after B is fixed), so re-run after each single fix and watch the count climb.

- [ ] symptom-group comment at the top of the class (you can copy the three group names above, in your own words) **before** the first fix
- [ ] one comment line per fix naming the test that led you there
- [ ] `mvn test -Dtest=Day06FirstUniqueCodeTest` → **20/20**, push
- [ ] `DailyTemperatures` comments (brute-force line + 3-5 lines of your pseudocode), comment-only push — 5 min if you have it, otherwise evening

### 🔁 4. Due redos (cap 2, most overdue first, cold)

| # | Redo | Stub (blank, tests verified) | Due | Timer | Done when |
|---|---|---|---|---|---|
| 1 | 🧩 `AsteroidCollision` (+1) | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` (0/28) | 1 Nov | 25 min | 28/28 pushed |
| 2 | 🧩 `CarFleet` (+1) | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` (0/37) | 4 Nov | 25 min | 37/37 pushed |

Each redo starts with: one pattern line, time and space **each with a because**, 3-5 lines of pseudocode, then Java. Push even if red. Results set the ladder ([redo-schedule.md](../revision/redo-schedule.md)): clean cold pass → +3; needed a hint or a fix → same +1; conceptual miss → reset. Missed today means they stay first tomorrow, not failed.

### 📌 Carried backlog (not today unless time is left, in this order)

| Item | Track | Status |
|---|---|---|
| Singleton weak pack: `DailyCounter` 3-ways exercise, debugging snippet, scenario ([day29.md](day29.md#-weak-topic-pack-singleton-beans-and-shared-mutable-state)) | 🌱 | ⬜ NOT_STARTED (evening) |
| Frequency-counting weak pack debugging exercise + Valid Anagram checks ([day28.md](../archive/tasks/day28.md#-weak-topic-pack-frequency-counting-counts-not-sums)) | 🧩 | ⬜ NOT_STARTED (evening, 10 min) |
| `DailyTemperatures` comments | 🧩🐞 | 🟡 IN_PROGRESS (open since 12 Nov) |
| HTTP semantics / `ResponseEntity` packs (16 Nov) | 🌱 | 🔴 weak, unattempted |
| B2 Q3/Q6; `ScoreOfParentheses` follow-ups; Day 02/03 re-answers | 🎤 | 🟡 / ⬜ |
| `Day00BuggyExample` symptom groups; `Day05DecodeString` write-up | 🐞 | 🟡 |
| CarFleet comment PR #1 | 🧩 | open |

### ✅ Morning checklist
- [ ] `git pull` in both repos
- [ ] Ch 2 Task 6 answer + Ch 3 checks in chat
- [ ] Ch 3 re-answer + Q2 + Q3, floor-vs-cap line
- [ ] `TwoSumTest` 19/19 pushed
- [ ] `Day06FirstUniqueCodeTest` 20/20 pushed with symptom groups + fix comments
- [ ] Asteroid redo pushed (cold), CarFleet redo started (cold)
- [ ] Hint after 15 minutes stuck on anything — just ask

## 🌙 Evening (21 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey) ![Redos](https://img.shields.io/badge/redos-none%20graded-lightgrey)

> [!NOTE]
> Checked at ~8:05 PM IST. **No student commits today in either repo**: labs `my-solutions` tip is still `e619f82` (20 Nov 1:04 PM IST), and this repo's `main` is still `a9ec0d4` (the Day 29 morning session). No answers in chat today. Nothing was touched, so the morning re-run stands: **795 run / 98 red**, which is exactly the four open stubs (`TwoSum` 0/19, `Day06FirstUniqueCode` 6/20, `AsteroidCollisionRedoNov17` 0/28, `CarFleetRedoNov20` 0/37). No cosmetic fixes, and no new mistakes to log. The weekly review (15–21 Nov) is in [PROGRESS.md](../PROGRESS.md#-weekly-review--1521-nov-2026).

Nothing landed today, so I can't score any track honestly. I won't invent a number. The work from Friday is still open, and Sunday is a catch-up day, so it all still fits.

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring | **can't be scored yet** (no work today; last 7, 20 Nov) | Ch 2 Task 6 interview answer (owed since 19 Nov), Ch 3 re-answer + Q2/Q3, floor-vs-cap line: none in chat or pushed. |
| 🧩 DSA | **can't be scored yet** (no work today; last 6, 19 Nov) | `TwoSumTest` 0/19, untouched; frequency-counting exercise and Valid Anagram checks not answered. |
| 🐞 Buggy | **can't be scored yet** (no work today; last 7, 19 Nov) | `Day06FirstUniqueCodeTest` 6/20 as shipped; `DailyTemperatures` comments (open since 12 Nov) not pushed. |
| 🔁 Redos | none graded | Asteroid 0/28 and CarFleet 0/37 still blank. Tonight's slot is still open; if missed, the 10 PM check moves the queue (missed is not failed, so no gap changes). |

### 🗂️ Topic classification tonight

| Topic | Class | Why |
|---|---|---|
| Registering beans (`@Component`, `@Bean`, `@Primary`, prototype) in code | 🟢 Strong (unchanged) | Ch 3 15/15 on the first push, 20 Nov |
| `@Component` vs `@Bean` (explaining the choice) | 🟡 Moderate (unchanged) | right rule, missing the "needs code to build it" reason |
| Singleton beans and shared mutable state | 🔴 Weak (unchanged) | 20 Nov conceptual miss; pack not attempted → [day29.md pack](day29.md#-weak-topic-pack-singleton-beans-and-shared-mutable-state) |
| Frequency counting: counts, not sums | 🔴 Weak (unchanged) | 19 Nov miss; pack not attempted → [day28.md pack](../archive/tasks/day28.md#-weak-topic-pack-frequency-counting-counts-not-sums) |
| HTTP semantics; `ResponseEntity` vs `@ResponseStatus` | 🔴 Weak (unchanged) | 16 Nov packs still not attempted → [day25.md evening](../archive/tasks/day25.md#-weak-topic-pack-2-http-semantics-carried-short) |
| `@SpringBootApplication` explanation (Ch 2 Task 6 answer) | ⏳ Pending | code 19/19 since 19 Nov; the answer is owed for a 3rd day |
| `TwoSum`, `Day06FirstUniqueCode`, `DailyTemperatures` comments, Asteroid + CarFleet redos | ⏳ Pending | not started |
| ⛔ Blocked | none | nothing is in the way; the gap is time on task, not a tool or a spec |

> [!NOTE]
> No new weak topic tonight, so there's no new pack. The three 🔴 packs above already have notes, one conceptual question, one implementation exercise, one debugging exercise and one interview scenario each. Do one of them before adding anything new.

### 🌙 Tonight (rest of the evening slot, in this order)

1. 🌱 **Chapter 2 Task 6 interview answer in chat** (~10 min, questions in [the morning section](#-1-spring-close-chapter-2s-interview-re-answer-chapter-3-35-min-no-new-chapter)). It closes Chapter 2.
2. 🧩 **Two Sum: the four guiding questions + pseudocode + the brute-force comment** (~20 min), then the skeleton if time. **Push even if red.**
3. 🐞 **`Day06FirstUniqueCode` group A only** (~10 min): hand-trace `"A"`, write the symptom-group comment, one fix, push.
4. 🔁 **`AsteroidCollisionRedoNov17` cold** only if time is left (25-minute timer). Otherwise the 10 PM check re-queues it.

### 🔮 Tomorrow's focus (Sun 22 Nov), based on tonight

| Track | Focus | Why (from tonight's assessment) |
|---|---|---|
| 🌱 Spring | **Still no Chapter 4.** First 10 minutes: the Ch 2 Task 6 answer in chat (if not done tonight). Then the Ch 3 re-answer (part 2: why a singleton field races and two real fixes; part 3: the "why" for `@Component` vs `@Bean`) + senior Q2/Q3, and the floor-vs-cap line. | The code is ahead of the explanations. Two interview answers are open, and Chapter 4 builds on both. |
| 🧩 DSA | Weekend, no new problem. **Two Sum closes Sunday with a guided walkthrough** if it's still red tonight: we fill the skeleton's blanks together in chat, then you retype it from a blank method and push 19/19. Then the frequency-counting debugging exercise (10 min). Every complexity line gets a "because". | Two Sum has passed its 2-day limit without a start, so it closes with the strongest hint instead of carrying over again. Monday's new problem waits for it. |
| 🐞 Buggy | **`Day06FirstUniqueCode` closes Sunday** the same way: symptom groups A/B/C are given, and you write one fix + one comment per group → 20/20. `DailyTemperatures` comments (5 min). | The Friday round never started; the written symptom groups are the debugging habit to build. |
| 🔁 Redos | Most overdue first, cold: **Asteroid** (due 1 Nov) + **CarFleet** (due 4 Nov) if they miss tonight. The 10 PM check sets the final pair per [redo-schedule.md](../revision/redo-schedule.md). | Missed is not failed, but Asteroid has now been skipped 5 evenings in a row. |
| 🔁 Weekly plan | Act on the weekly review's three changes from Monday: a one-line rule check before every push, each chapter's interview answer the same day, and one cold redo in the morning. | Weekly review, 15–21 Nov |

> [!TIP]
> One quiet day is fine. The fastest way back is the smallest one: three sentences about `@SpringBootApplication` in chat tonight close a whole chapter.

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-7%2F10-yellowgreen) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-5%2F10-red) ![Ch2](https://img.shields.io/badge/Chapter%202-completed-brightgreen) ![Day06](https://img.shields.io/badge/Day06-16%2F20-orange) ![Pending](https://img.shields.io/badge/pending-10-blue)

> [!NOTE]
> 10 PM check (~10 PM IST). One student commit after the 8 PM review: **`41abb48`** (9:21 PM IST, "Day06FirstUniqueCode is completed"), touching only `Day06FirstUniqueCode.java`. Re-run on the updated tree: **`Day06FirstUniqueCodeTest` 16/20** (was 6/20); full suite **795 run / 88 red**, exactly the four open files (`TwoSum` 0/19, `Day06` 16/20, Asteroid redo 0/28, CarFleet redo 0/37). In chat, 9:38-9:40 PM IST, the **Chapter 2 Task 6 interview answer**: graded **7/10** after two corrections, so **Chapter 2 is ✅ COMPLETED** ([interview-answers.md](../interview-answers.md)). Nothing else landed: `TwoSum` 0/19, Asteroid redo 0/28, CarFleet redo 0/37, so the redo queue moved one slot ([redo-schedule.md](../revision/redo-schedule.md)). The 8 PM evening review, the morning session and the weekly review had not reached `main` (their push approvals expired), so they go in with tonight's commits. No cosmetic fix needed in your code.

| Track | Item | Result | Status |
|---|---|---|---|
| 🌱 | Chapter 2 Task 6 interview (`@SpringBootApplication`) | **7/10** in chat: part 1 ✅; part 2 "it gets scanned" ❌ → corrected to "not scanned → 404"; part 3 first explained why auto-config applies, then `--debug =true` (accepted: `--debug` on the CLI, `debug=true` in `application.properties`) | ✅ COMPLETED → **Chapter 2 ✅ COMPLETED** (code 19/19 + answer) |
| 🌱 | Ch 3 re-answer (part 2 thread-safety, part 3 the why) + senior Q2/Q3 | not started | 🔴 REVISION_REQUIRED (**Sun 22 Nov, first task**) |
| 🌱 | Floor-vs-cap mistake redo (one line) | not answered | ⬜ NOT_STARTED (Sun 22 Nov, after the Ch 3 re-answer) |
| 🐞 | `Day06FirstUniqueCode` (`41abb48`) | **16/20**: validation `&&` → `\|\|` ✅, counting loop from `i = 0` ✅; third change ❌ conceptual: the last loop runs `letter` 0..25, checks `count[codes.charAt(letter) - 'a']` and returns `letter`, mixing the alphabet index with the string position. Red: `allRepeat`, `empty`, `twoEqual` (`StringIndexOutOfBoundsException` on strings shorter than 26), `large` (expected 999998, got -1: only the first 26 positions are scanned). No symptom-group comment, no per-fix comments. Logged in [mistakes/dsa.md](../revision/mistakes/dsa.md) | 🔴 REVISION_REQUIRED (not ✅ despite the commit message); past its 2-day limit → **Sun 22 Nov guided walkthrough** → 20/20 |
| 🧩 | `TwoSum` (Arrays & Hashing 3 of 9) | not started, 0/19 | ⬜ NOT_STARTED (past its 2-day limit → Sun 22 Nov guided walkthrough → 19/19) |
| 🧩 | Frequency-counting weak pack + Valid Anagram checks | not started | ⬜ NOT_STARTED (Sun 22 Nov; the `Day06` miss is the same topic, so this pack is now doubly due) |
| 🧩🐞 | `DailyTemperatures` comments | not pushed | 🟡 IN_PROGRESS (open since 12 Nov) |
| 🔁 | `AsteroidCollisionRedoNov17` cold | not attempted (17-21 Nov). Missed is not failed, no gap changed | 🟡 IN_PROGRESS (**Sun 22 Nov, slot 1**) |
| 🔁 | `CarFleetRedoNov20` cold | not attempted (20-21 Nov) | 🟡 IN_PROGRESS (**Sun 22 Nov, slot 2**) |

> [!WARNING]
> **Why `Day06` isn't ✅:** frequency counting is two passes with two different indexes. Pass 1 walks the string and fills `count[c - 'a']`. Pass 2 must walk the **string positions** `i = 0..n-1` again and return the first `i` whose letter has a count of 1. Looping over the 26 alphabet slots answers a different question ("which letter is unique", in alphabet order), and using that slot number as a string index breaks on short and long strings alike. This is the second frequency-counting miss in three days (Valid Anagram, 19 Nov), so the topic stays 🔴 Weak.

> [!IMPORTANT]
> **First task Sun 22 Nov:** `git pull` both repos (this repo has tonight's commits on top of `41abb48`). Then the **Spring Ch 3 interview re-answer** in chat (~15 min): part 2, why a singleton bean's field races (the bean's fields live on the **heap**, shared by every request thread, while locals live on **each thread's own stack**) plus **two real fixes** (keep the bean stateless with state in locals / the request / the DB, or a thread-safe type or lock for the read-modify-write, e.g. `AtomicLong`, or a DB `UPDATE ... SET total = total + ?` when it must survive several instances); part 3, the *why* for `@Component` vs `@Bean`; then senior Q2/Q3 and the floor-vs-cap line. Still no Chapter 4. Then 🐞 **`Day06FirstUniqueCode` guided walkthrough** (we trace `"aab"` together and rewrite only the last loop to walk string positions → 20/20, plus the symptom-group comment and one comment per fix) and 🧩 **Two Sum guided walkthrough** (skeleton blanks filled together, then retyped from a blank method → 19/19). Evening: 🔁 `AsteroidCollisionRedoNov17` + `CarFleetRedoNov20`, cold. **Pending items: 10** ([PROGRESS.md](../PROGRESS.md#-pending)).

</details>
