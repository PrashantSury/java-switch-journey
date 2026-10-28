# 🌅 Day 06 morning: close Day 03/04 Part A + Day01ArrayStack redo

![Week](https://img.shields.io/badge/Week-1-blue) ![Day](https://img.shields.io/badge/Day-06-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!NOTE]
> Backlog day, no new material. Part A is 🔴 **Needs correction (almost there)**: two tests and two clean-ups are left. §3/§4 must be verified before §5 (Day 04 Part B) and the banking-app V2 auth migration can start. Day 03 and Day 04 buggy rounds are still unattempted, so there's no new buggy round today.

## 📚 Revise first (~10 min) in `spring-boot/prerequisites.md`
- 🔥 **3. Request mapping**: what happens when a required `@RequestParam` is missing, and which status the client gets.
- 🔥 **4. HTTP semantics**: what a PUT to an id that doesn't exist should return, and why.

> [!TIP]
> Add one row per topic to the **Revision log** at the bottom of `prerequisites.md` with your confidence (1-5).

## 🅰️ Main task (~35 min): finish Part A in `spring-boot/course-practice`

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

## 🔁 Small item (~15 min): Day01ArrayStack redo, cold
- [ ] Without opening `Day01ArrayStack.java`, write `src/main/java/com/prashant/dailytests/redo/Day01ArrayStackRedo.java` (the spec is in its Javadoc).
- [ ] Run `mvn test -Dtest=Day01ArrayStackRedoTest` until 17/17 pass. It's 0/17 right now.

> [!WARNING]
> No peeking this time. If you get stuck, write down where, push what you have, and we'll log it honestly as 🟠 Attempted.

## 🎤 Still open (answer in chat when you can)
The three Day 03 questions are still ⬜ Pending in `interview-answers.md`. Day 04's wait until Part B.
