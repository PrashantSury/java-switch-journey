# 📅 Day 07 (29 Oct): Day 04 Part B, first half (409 for duplicate email)

## 🌅 Morning: Part B1 in `spring-boot/course-practice` + Day 04 Q3

![Week](https://img.shields.io/badge/Week-1-blue) ![Day](https://img.shields.io/badge/Day-07-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!NOTE]
> Backlog day, no new material. §5 Validation & error handling is the active section, and Day 04 Part B is its only open task. Part B is split in two so each slot stays around 60 minutes: **B1 today** (validation message, `exists...` queries, 409 for duplicate email), **B2 next** (every handler returns `ProblemDetail`, malformed JSON, the last 3 tests). No new buggy round: Day 03 and Day 04 buggy rounds are still unattempted. No banking-app increment until §5 is verified.

### 📚 Revise first (~10 min) in `spring-boot/prerequisites.md`
- 🔥 **5. Validation & error handling**: what `@Valid` triggers, where `MethodArgumentNotValidException` comes from, and how a `@RestControllerAdvice` handler picks the status code.
- 🔥 **4. HTTP semantics**: 400 vs 404 vs 409. When is a request well-formed but still in conflict with the server's state?

> [!TIP]
> Add one row per topic to the **Revision log** at the bottom of `prerequisites.md` with your confidence (1-5).

### 🧱 Where each change goes

| Package | Class | What you do |
|---|---|---|
| `dto` | `StudentRequest` | Task 1: give `@Size` a clear `message` |
| `repository` | `StudentRepository` | Task 2: two derived `exists...` queries |
| `service.impl` | `StudentServiceImpl` | Task 3: `create` and `update` throw `DuplicateEmailException` |
| `exception` | `GlobalExceptionHandler` | Task 3: a handler that maps `DuplicateEmailException` to 409 |
| test `controller` | `StudentControllerTest` | Task 4: 2 new tests |

### 🅰️ Main task (~40 min): Part B1

What's already in the repo: `@Size(min=2, max=50)` on `name` (no message yet) and an empty `DuplicateEmailException`. Nothing uses the exception yet.

- [ ] **1. DTO validation**: add a clear `message` to the `@Size` on `name` (keep `@NotBlank`).
- [ ] **2. Repository**: add one derived query that checks whether an email already exists (ignore case), and one that checks the same thing **excluding a given id**. You name and write them.
- [ ] **3. Duplicate email = 409**: `create` throws `DuplicateEmailException` when the email is taken; `update(id, request)` throws it only when **another** student has that email. Add a handler in `GlobalExceptionHandler` that returns 409. (Keep the existing handlers as they are for now; switching all of them to `ProblemDetail` is B2.)
- [ ] **4. Tests** in `StudentControllerTest`: POST with an email that's already taken gives 409; PUT a student with their **own** unchanged email gives 200.

> [!IMPORTANT]
> ✅ Done when `mvn test` passes inside `spring-boot/course-practice` with **13+ tests in `StudentControllerTest`** (11 today plus your 2), and the controller still never touches the repository.

> [!WARNING]
> ⚠️ Think about the order of checks in `update`: what should a PUT to an unknown id with a taken email return, 404 or 409?

### 🎤 Small item (~10 min): Day 04 Q3, in chat
Answer this one in chat after the code. It's copied in `interview-answers.md` under Day 04.

**Q3.** What is `ProblemDetail`? Why is 409 better than 400 for a duplicate email, and why isn't the "does it exist" check alone enough to keep emails unique?

> [!TIP]
> Answer format: **definition → difference → when to use → example from your Student API**.

### 📌 Carried backlog (still queued, not for this slot)

| Item | Path | Status |
|---|---|---|
| 🧩 RemoveKAdjacentDuplicates (LeetCode 1209) | `src/main/java/com/prashant/dsa/stack/RemoveKAdjacentDuplicates.java` | ⬜ Not started (0/26) · evening slot |
| 🗄️ SQL 03 Q1 (branch max with ties) | `sql/day03.sql` → `sql/day03-answers.md` | ⬜ Not started · evening slot |
| 🌱 Day 04 Part B2 (`ProblemDetail` everywhere, malformed JSON, +3 tests) | `spring-boot/course-practice` | ⬜ Not started · next morning |
| 🎤 Day 04 Q1, Q2 | `interview-answers.md` | ⬜ Pending |
| 🎤 Day 03 Q1, Q2 re-answers | `spring-boot/interview-answers/day03-answers.md` | 🔵 Ready for revision |
| 🔁 Day01ArrayStack day-7 redo | `src/main/java/com/prashant/dailytests/` | 🔵 Due 30 Oct |
| 🔁 Day02RpnEvaluator cold redo | `src/main/java/com/prashant/dailytests/redo/` | 🔵 Due 31 Oct |
| 🐞 Day03NextGreaterIndex, Day04LargestRectangle | `src/main/java/com/prashant/dailytests/` | ⬜ Not started (13/37, 15/36) |
| 🧩 AsteroidCollision, CarFleet | `src/main/java/com/prashant/dsa/stack/` | ⬜ Not started (8/28, 2/37) |
