# 🌅 Day 02 morning: Spring Boot practice (Week 1 · REST controllers, @RequestBody, @PathVariable)

![Week](https://img.shields.io/badge/Week-1-blue) ![Day](https://img.shields.io/badge/Day-02-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow)

Work in the `spring-boot/course-practice` module, package `com.prashant.coursepractice.student`.

## 🛠️ Task: finish the Student REST API
- [ ] **1.** `PUT /api/students/{id}`: takes a `@Valid @RequestBody Student`, updates name and email of the existing student and returns it with 200. Unknown id gives 404 (reuse `StudentNotFoundException`); invalid body gives 400 with the field errors.
- [ ] **2.** `DELETE /api/students/{id}`: returns 204 No Content. Unknown id gives 404.
- [ ] **3.** `GET /api/students/search?name=...`: uses `@RequestParam` and a derived query `findByNameContainingIgnoreCase(String name)` in `StudentRepository`. A missing `name` param should give 400.
- [ ] **4.** Add tests to `StudentControllerTest` for each endpoint: the happy path, 404, and 400 cases (at least 7 tests).

> [!IMPORTANT]
> ✅ Done when `mvn test` passes inside `spring-boot/course-practice`.

## 🎤 Interview questions (answer in chat or in a notes file)
1. What's the difference between `@PathVariable`, `@RequestParam` and `@RequestBody`? When would you use each?
2. `@RestController` vs `@Controller`: what does `@RestController` add?
3. Should PUT be idempotent? How is it different from PATCH, and what status codes would you return for create vs update vs delete?

> [!WARNING]
> **Note (structure update):** the module now uses a layered layout (see `course-practice/STRUCTURE.md`). Your PUT/DELETE/search fixes now go in `controller/StudentController.java` (endpoint mappings) and `service/impl/StudentServiceImpl.java` (lookup/delete logic). Request body is now `dto/StudentRequest`; tests are in `src/test/java/com/prashant/coursepractice/controller/StudentControllerTest.java`.
