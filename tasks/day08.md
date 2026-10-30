# 📅 Day 08 (30 Oct): Part B1 again + Day01ArrayStack day-7 redo

![Week](https://img.shields.io/badge/Week-2-blue) ![Day](https://img.shields.io/badge/Day-08-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!IMPORTANT]
> Part B1 again and the `Day01ArrayStack` day-7 redo, with Revise-first on workbook §5. Day 04 Q3 moves to the next free slot.

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🔥 revise first · ⬜ not started · 🟡 in progress · 🟠 attempted · 🔴 needs correction · 🔵 ready for revision · ✅ done · ⚠️ gotcha. Tick the `- [ ]` boxes as you finish each item.

## 🌅 Morning: Part B1 in `spring-boot/course-practice` + cold redo

> [!NOTE]
> Backlog day, no new material. §5 Validation & error handling is still the active section and Part B1 is still 🟡 In progress (no Spring push on 29 Oct), so it stays the main task. The small item is the `Day01ArrayStack` **day-7 redo, due today** (redos come before pending Q&A). Day 04 Q3 moves to the next free slot. No new buggy round (`Day04LargestRectangle` is still unattempted and `Day01ArrayStackRedo7` is new today), no banking-app increment until §5 is verified.

> [!TIP]
> ✅ Nice late-night work: SQL learn **lesson 01 passes 5/5** on your own queries (`LESSON 01 COMPLETE`, checked on 30 Oct) and the queries read cleanly. It's now ✅ Completed and verified in `PROGRESS.md`.

### 📚 Revise first (~10 min) in `spring-boot/spring-boot-revision-sheet.md` §5
| Topic | What to recall |
|---|---|
| 🔥 | Read the **§5 Concept notes** box, then answer **5.5** (`@NotNull` vs `@NotEmpty` vs `@NotBlank`) and **5.8** (`@Validated` on a controller) from memory in the "My answer" slots. |
| 🔥 | Re-read **§4 HTTP semantics**: 400 vs 404 vs 409. |

> [!TIP]
> Add one row per topic to the **Revision log** at the bottom of `spring-boot/prerequisites.md` with your confidence (1-5).

### 🧱 Where each change goes

| Package | Class | What you do |
|---|---|---|
| `dto` | `StudentRequest` | Task 1: give `@Size` a clear `message` |
| `repository` | `StudentRepository` | Task 2: two derived `exists...` queries |
| `service.impl` | `StudentServiceImpl` | Task 3: `create` and `update` throw `DuplicateEmailException` |
| `exception` | `GlobalExceptionHandler` | Task 3: a handler that maps `DuplicateEmailException` to 409 |
| test `controller` | `StudentControllerTest` | Task 4: 2 new tests |

### 🅰️ Main task (~35 min): Part B1 (carried from Day 07)

The full brief is unchanged from the Morning section of [day07.md](day07.md). In short:

- [ ] **1. DTO validation**: add a clear `message` to the `@Size` on `name` (keep `@NotBlank`).
- [ ] **2. Repository**: one derived query that checks whether an email exists (ignore case), and one that checks the same thing **excluding a given id**. You name and write them.
- [ ] **3. Duplicate email = 409**: `create` throws `DuplicateEmailException` when the email is taken; `update(id, request)` throws it only when **another** student has that email. Add a 409 handler in `GlobalExceptionHandler` (the switch to `ProblemDetail` everywhere is B2).
- [ ] **4. Tests** in `StudentControllerTest`: POST with a taken email gives 409; PUT a student with their **own** unchanged email gives 200.

> [!WARNING]
> ⚠️ Order of checks in `update`: a PUT to an unknown id with a taken email should return what, 404 or 409? Decide before you write it.

> [!IMPORTANT]
> ✅ Done when `mvn test` passes inside `spring-boot/course-practice` with **13+ tests in `StudentControllerTest`** (11 today plus your 2), and the controller still never touches the repository.

### 🔁 Small item (~15 min): Day01ArrayStack day-7 redo, cold
- [ ] Without opening `Day01ArrayStack.java` or `Day01ArrayStackRedo.java`, write `src/main/java/com/prashant/dailytests/redo/Day01ArrayStackRedo7.java` (spec in its Javadoc).
- [ ] Run `mvn test -Dtest=Day01ArrayStackRedo7Test` until 17/17 pass. It's 0/17 right now (the tests were checked 17/17 against a correct version).

> [!TIP]
> The three Day 01 traps: when exactly is the array full, what does "empty" mean, and what does doubling a capacity of 0 give you?

> [!CAUTION]
> Run `git status` and read the diff before you push: no stray `main()`, no unused imports, no `.postman` files.

### 📌 Carried backlog (still queued, not for this slot)

| Item | Path | Status |
|---|---|---|
| 🎤 Day 04 Q3 (`ProblemDetail`, 409 vs 400) | `interview-answers.md` (also workbook 5.4 / 5.7) | ⬜ Pending · answer in chat after B1 |
| 🎤 Day 04 Q1, Q2 | `interview-answers.md` | ⬜ Pending |
| 🎤 Day 03 Q1, Q2 re-answers | `spring-boot/interview-answers/day03-answers.md` | 🔵 Ready for revision |
| 🌱 Day 04 Part B2 (`ProblemDetail` everywhere, malformed JSON, +3 tests) | `spring-boot/course-practice` | ⬜ Not started · after B1 is verified |
| 🧩 AsteroidCollision (LeetCode 735) | `src/main/java/com/prashant/dsa/stack/AsteroidCollision.java` | ⬜ Not started (8/28) · tonight |
| 🗄️ SQL 03 Q1 (branch max with ties) | `sql/day03.sql` → `sql/day03-answers.md` | ⬜ Not started · tonight |
| 🧹 Untrack `.postman/` and `postman/globals/` | repo root | ⬜ Not started · tonight |
| 🎓 SQL learn lessons 02-05 | `sql/learn/` | ⬜ Not started |
| 🔁 Day02RpnEvaluator cold redo | `src/main/java/com/prashant/dailytests/redo/` | 🔵 Due 31 Oct |
| 🔁 Day03NextGreaterIndex redo · count-stack O(n) re-quiz | `src/main/java/com/prashant/dailytests/` | 🔵 Due 1 Nov |
| 🐞 Day04LargestRectangle | `src/main/java/com/prashant/dailytests/` | ⬜ Not started (15/36) |
| 🧩 CarFleet | `src/main/java/com/prashant/dsa/stack/` | ⬜ Not started (2/37) |

> [!IMPORTANT]
> Reply in chat when you've pushed, and I'll grade it. Any later slot today is fine.

## 🌙 Evening (~60 min): backlog only

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!NOTE]
> No pushes since this morning's assignment (checked at 8 PM: `AsteroidCollisionTest` 8/28, `Day01ArrayStackRedo7Test` 0/17, `CarFleetTest` 2/37, no `sql/day03-answers.md`). With 2 DSA problems ⬜ Not started (`AsteroidCollision`, `CarFleet`) and 5 SQL files unanswered, tonight is backlog only: the oldest DSA stub and the oldest SQL question. No new stub, no new SQL file.

### 🧩 DSA (~35 min): Asteroid Collision (LeetCode 735), second evening
- 📂 `src/main/java/com/prashant/dsa/stack/AsteroidCollision.java` (tests in `AsteroidCollisionTest`, 8/28 right now, and those 8 pass by accident on the empty stub)
- 📌 Each value is an asteroid: size is the absolute value, sign is direction (positive right, negative left), all at the same speed. When two meet, the smaller explodes; equal sizes both explode. Return what's left, in original order.
- 📌 Repo rules: `null` or any `0` throws `IllegalArgumentException`; don't modify the input; values cover the whole `int` range, including `Integer.MIN_VALUE`; aim for O(n) on up to 100,000 asteroids.

- [ ] Implement `asteroidCollision(int[] asteroids)`.
- [ ] `mvn test -Dtest=AsteroidCollisionTest` shows 28/28.

> [!TIP]
> Only one direction pairing can ever collide. And before comparing sizes, ask yourself what `Math.abs(Integer.MIN_VALUE)` returns.

### 🗄️ SQL (~20 min): `sql/day03.sql` Q1 (fourth evening, still the oldest)
- 📂 Questions and seed data in `sql/day03.sql`; your answer goes in a new file `sql/day03-answers.md`.
- 📌 For every branch, show the ACTIVE account(s) with the highest known balance, keeping ties. Ignore CLOSED accounts and NULL balances. A branch with no qualifying account still appears once with NULLs. Columns: `branch_id, branch_name, account_id, name, balance`, sorted by `branch_id`, then `account_id`.

- [ ] Run the seed in pgAdmin, write the query, paste it into `sql/day03-answers.md` with the row count.

> [!TIP]
> Think about where the "ACTIVE and not NULL" filter has to live so that an empty branch still shows up once.

### 🧹 Repo clean-up (~5 min), carried from Day 07
`.gitignore` lists `.postman`, but `.postman/resources.yaml` and `postman/globals/workspace.globals.yaml` are still tracked.

- [ ] Stop tracking them without deleting your local copies, and add `postman/globals/` to `.gitignore`.

> [!CAUTION]
> Run `git status` and read the diff before you push: no stray `main()`, no unused imports, no `.postman` files.

### 📌 Still open from this morning

| Item | Path | Status |
|---|---|---|
| 🌱 Day 04 Part B1 | `spring-boot/course-practice` | 🟡 In progress · no push today |
| 🔁 `Day01ArrayStackRedo7` (day-7 redo) | `src/main/java/com/prashant/dailytests/redo/` | ⬜ Not started (0/17) |
| 🎤 Day 04 Q3 | in chat | ⬜ Pending |

> [!IMPORTANT]
> ✅ Done when `AsteroidCollisionTest` is 28/28 on your pushed code, `sql/day03-answers.md` has Q1, and `git ls-files` no longer lists the Postman files. Reply in chat when you're ready for grading.
