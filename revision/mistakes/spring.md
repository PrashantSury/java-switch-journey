# 🌱 Spring mistake log

![Spaced repetition](https://img.shields.io/badge/redo-day%203%20%2B%20day%207-purple) ![Section](https://img.shields.io/badge/section-Spring-blue)

> [!IMPORTANT]
> Conceptual mistakes from `course-practice`, the Spring Q&A and the banking app. Redo each item after 3 days and again after 7 days. Only conceptual mistakes go here; cosmetic slips (typos, stale comments, missing braces, unused imports, stray `main()`) are fixed directly by Lumi and not logged.

> [!NOTE]
> **Legend:** 🌱 Spring · 🏦 banking · 🎤 Q&A · 🔁 redo · mark a redo ✅ when done cleanly, ❌ if you got stuck again. Other sections: [index](../mistake-log.md).

| Date | Problem | What went wrong | Redo on day 3 | Redo on day 7 |
|------|---------|-----------------|---------------|---------------|
| 31 Oct | Day 04 Part B1 (Spring) | Tests 13/13 but the first B1 item was skipped: `@Size(min=2, max=50)` still has no `message`. The 409 for duplicate email was added on create and update, yet only the "own email stays 200" case is tested, not "another student's email → 409" on PUT. Also noted: no unique constraint on `email`, so check-then-save can race. Both gaps fixed in c344203 (✅ B1, 31 Oct). Lesson: tick every line of the task list before pushing, and test each new status code on every endpoint that can return it. | 3 Nov | 7 Nov |
| 31 Oct | Day 04 Q1 (Q&A: JSON → validated DTO) | Named `HttpMessageNotReadableException` as the exception when validation fails. That one is for malformed or unreadable JSON; a failed `@Valid` throws `MethodArgumentNotValidException` (field errors in its `BindingResult`). Both give 400 but at different steps (conversion, then validation) and need two handlers in the advice. Lesson: say the steps in order (converter → validation) and name one exception per step. | 3 Nov | 7 Nov |
| 31 Oct | Day 04 Q3 (Q&A: `ProblemDetail`, 409 vs 400) | `ProblemDetail` and 400 vs 409 were right, but the third part was left unanswered: why the "does it exist" check isn't enough. Check-then-save isn't atomic, so two concurrent requests can both pass the check and both save. The guarantee is a DB unique constraint on `email` (case-insensitive: unique index on `lower(email)`), with `DataIntegrityViolationException` mapped to 409. Lesson: when a question asks "why isn't X enough", think concurrency. Revisit in §6 JPA. | 3 Nov | 7 Nov |
