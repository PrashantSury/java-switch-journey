# 🌅 Day 05 morning: finish the Day 03 corrections + RPN redo

![Week](https://img.shields.io/badge/Week-1-blue) ![Day](https://img.shields.io/badge/Day-05-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-~60%20min-blue)

> [!IMPORTANT]
> Backlog day: fix the Day 03 Part A corrections in `spring-boot/course-practice` and redo `Day02RpnEvaluator` from memory (44/44).

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🔥 revise first · ⬜ not started · 🟡 in progress · 🟠 attempted · 🔴 needs correction · 🔵 ready for revision · ✅ done · ⚠️ gotcha. Tick the `- [ ]` boxes as you finish each item.
>
> Backlog day, no new material. The Day 03 Part A work you pushed in `11dfcc8` is 🔴 **Needs correction**, and §3/§4 must be verified before §5 (Day 04 Part B) or the banking-app V2 auth migration can start. Two buggy rounds (Day 03, Day 04) are still unattempted, so there's no new buggy round today.

## 📚 Revise first (~10 min) in `spring-boot/prerequisites.md`
| Topic | What to recall |
|---|---|
| 🔥 **3. Request mapping** | what belongs in the mapping path vs. what `@RequestParam` reads from the query string. |
| 🔥 **4. HTTP semantics** | which status a successful DELETE should return, and why it has no body. |

> [!TIP]
> Add one row per topic to the **Revision log** at the bottom of `prerequisites.md` with your confidence (1-5).

## 🅰️ Main task (~35 min): Day 03 Part A corrections in `spring-boot/course-practice`

| Package | Class | What you fix |
|---|---|---|
| `controller` | `StudentController` | `/search` mapping · DELETE status · no not-found logic in the controller |
| `service` / `service.impl` | `StudentService`, `StudentServiceImpl` | `delete(Long id)` throws `StudentNotFoundException` for an unknown id |
| test `controller` | `StudentControllerTest` | at least 6 new tests |

- [ ] `GET /api/students/search?name=...` returns 200 with matches (today it returns 400).
- [ ] `DELETE /api/students/{id}` returns the right success status with an empty body.
- [ ] The controller only calls the service; the "does this student exist?" decision lives in the service.
- [ ] DELETE of an unknown id gives 404 through `GlobalExceptionHandler`.
- [ ] 6+ new controller tests, one per behaviour: POST 201 + `Location` header, GET by id 200, GET unknown id 404, PUT 200, DELETE success status with empty body, DELETE unknown id 404, search 200.

> [!IMPORTANT]
> ✅ Done when `mvn test` passes inside `spring-boot/course-practice`, and the Postman collection's search and delete requests behave as above.

## 🔁 Small item (~15 min): Day02RpnEvaluator redo from memory
- [ ] Without opening `Day02RpnEvaluator.java`, write `evaluate` in `src/main/java/com/prashant/dailytests/redo/Day02RpnEvaluatorRedo.java` (the spec is in its Javadoc).
- [ ] Run `mvn test -Dtest=Day02RpnEvaluatorRedoTest` until 44/44 pass. It's 0/44 right now.

> [!TIP]
> The Day 02 lesson was about tokens that *start* like an operator, and about overflow on every arithmetic operation.

## 🎤 Still open (answer in chat when you can)
The three Day 03 questions in `tasks/day03-morning.md` are still ⬜ Pending (they're also in `interview-answers.md`). Day 04's wait until Part B.
