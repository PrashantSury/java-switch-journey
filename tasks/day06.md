# 📅 Day 06 (28 Oct): Part A close-out + evening backlog

![Week](https://img.shields.io/badge/Week-1-blue) ![Day](https://img.shields.io/badge/Day-06-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!IMPORTANT]
> Close Part A in `spring-boot/course-practice` (2 tests, 2 clean-ups), redo `Day01ArrayStack` cold, then clear the evening backlog (DSA + SQL).

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🔥 revise first · ⬜ not started · 🟡 in progress · 🟠 attempted · 🔴 needs correction · 🔵 ready for revision · ✅ done · ⚠️ gotcha. Tick the `- [ ]` boxes as you finish each item.

## 🌅 Morning: close Day 03/04 Part A + Day01ArrayStack redo

> [!NOTE]
> Backlog day, no new material. Part A is 🔴 **Needs correction (almost there)**: two tests and two clean-ups are left. §3/§4 must be verified before §5 (Day 04 Part B) and the banking-app V2 auth migration can start. Day 03 and Day 04 buggy rounds are still unattempted, so there's no new buggy round today.

### 📚 Revise first (~10 min) in `spring-boot/prerequisites.md`
| Topic | What to recall |
|---|---|
| 🔥 **3. Request mapping** | what happens when a required `@RequestParam` is missing, and which status the client gets. |
| 🔥 **4. HTTP semantics** | what a PUT to an id that doesn't exist should return, and why. |

> [!TIP]
> Add one row per topic to the **Revision log** at the bottom of `prerequisites.md` with your confidence (1-5).

### 🅰️ Main task (~35 min): finish Part A in `spring-boot/course-practice`

| Package | Class | What you do |
|---|---|---|
| test `controller` | `StudentControllerTest` | add 2 tests (below) |
| `controller` | `StudentController` | clean up the `search` method |
| `com.prashant.dailytests` (root project) | `Day02RpnEvaluator` | remove the stray `main()` |

- [ ] New test: `PUT /api/students/{id}` for an unknown id returns 404 (through `GlobalExceptionHandler`).
- [ ] New test: `GET /api/students/search` with no `name` parameter returns 400.
- [ ] `search`: drop the `@Valid` on the `String` parameter and the null branch that can never run.
- [ ] `Day02RpnEvaluator`: delete the leftover `main()` and keep 44/44 green.

> [!IMPORTANT]
> ✅ Done when `mvn test` passes inside `spring-boot/course-practice` with 11+ tests in `StudentControllerTest`, and `mvn test -Dtest=Day02RpnEvaluatorTest` still shows 44/44 in the root project. That closes §3/§4 corrections.

### 🔁 Small item (~15 min): Day01ArrayStack redo, cold
- [ ] Without opening `Day01ArrayStack.java`, write `src/main/java/com/prashant/dailytests/redo/Day01ArrayStackRedo.java` (the spec is in its Javadoc).
- [ ] Run `mvn test -Dtest=Day01ArrayStackRedoTest` until 17/17 pass. It's 0/17 right now.

> [!WARNING]
> No peeking this time. If you get stuck, write down where, push what you have, and we'll log it honestly as 🟠 Attempted.

### 🎤 Still open (answer in chat when you can)
The three Day 03 questions are still ⬜ Pending in `interview-answers.md`. Day 04's wait until Part B.

> [!NOTE]
> ✅ Morning result: Part A verified (`course-practice` 12/12) and `Day01ArrayStackRedo` 17/17, both on 28 Oct.

## 🌙 Evening (~60 min): backlog only

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!WARNING]
> Second evening in a row for these two. No new DSA stub while 3 DSA problems are ⬜ Not started (`RemoveKAdjacentDuplicates`, `AsteroidCollision`, `CarFleet`), and no new SQL file while 5 SQL files are unanswered.

### 🧩 DSA (~35 min): Remove All Adjacent Duplicates in String II (LeetCode 1209)
- 📂 `src/main/java/com/prashant/dsa/stack/RemoveKAdjacentDuplicates.java` (tests in `RemoveKAdjacentDuplicatesTest`, 0/26 right now)
- 📌 Given `s` and `k`, keep deleting runs of `k` equal adjacent characters (joining the two sides) until none are left, and return what remains.
- 📌 Repo rules: `null` string or `k < 2` throws `IllegalArgumentException`; case-sensitive; up to 100,000 characters, so aim for O(n).

- [ ] Implement `removeDuplicates(String s, int k)`.
- [ ] `mvn test -Dtest=RemoveKAdjacentDuplicatesTest` shows 26/26.

> [!TIP]
> Think about what you'd need to remember about the character *before* the current one, and how many of it are in a row, so a removal can expose an older run.

### 🗄️ SQL (~25 min): `sql/day03.sql` Q1
- 📂 Questions and seed data in `sql/day03.sql`; your answer goes in a new file `sql/day03-answers.md`.
- 📌 For every branch, show the ACTIVE account(s) with the highest known balance, keeping ties. Ignore CLOSED accounts and NULL balances. A branch with no qualifying account still appears once with NULLs. Columns: `branch_id, branch_name, account_id, name, balance`, sorted by `branch_id`, then `account_id`.

- [ ] Run the seed in pgAdmin, write the query, paste it into `sql/day03-answers.md` with the row count.

> [!IMPORTANT]
> ✅ Done when `RemoveKAdjacentDuplicatesTest` is 26/26 on your pushed code and `sql/day03-answers.md` has Q1. Reply in chat when you're ready for grading.

## 🌒 End of day (10 PM check, 28 Oct)

| Item | Outcome |
|---|---|
| Part A: PUT unknown id → 404 test | ✅ Completed and verified (`course-practice` 12/12) |
| Part A: search without `name` → 400 test | ✅ Completed and verified |
| Part A: `search` clean-up (`@Valid` + dead branch) | ✅ Completed and verified |
| Part A: stray `main()` in `Day02RpnEvaluator` | ✅ Completed and verified (44/44) |
| `Day01ArrayStackRedo` (cold) | ✅ Completed and verified (17/17) |
| Day 03 interview Q&A | ✅ Graded 17/30 · 🔵 Q1, Q2 ready for revision |
| 🧩 `RemoveKAdjacentDuplicates` | ⬜ Not started (0/26) · carried to Day 07 |
| 🗄️ `sql/day03.sql` Q1 | ⬜ Not started (no `sql/day03-answers.md`) · carried to Day 07 |

> [!IMPORTANT]
> ▶️ **Next task (29 Oct, 6 AM):** Day 04 Part B in `spring-boot/course-practice` (409 handler with `ProblemDetail`, `@Size` coverage, +5 tests). See [day04-morning.md](day04-morning.md).
