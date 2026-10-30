# 🌱 Spring mistake log

![Spaced repetition](https://img.shields.io/badge/redo-day%203%20%2B%20day%207-purple) ![Section](https://img.shields.io/badge/section-Spring-blue)

> [!IMPORTANT]
> Conceptual mistakes from `course-practice`, the Spring Q&A and the banking app. Redo each item after 3 days and again after 7 days. Only conceptual mistakes go here; cosmetic slips (typos, stale comments, missing braces, unused imports, stray `main()`) are fixed directly by Lumi and not logged.

> [!NOTE]
> **Legend:** 🌱 Spring · 🏦 banking · 🎤 Q&A · 🔁 redo · mark a redo ✅ when done cleanly, ❌ if you got stuck again. Other sections: [index](../mistake-log.md).

| Date | Problem | What went wrong | Redo on day 3 | Redo on day 7 |
|------|---------|-----------------|---------------|---------------|
| 31 Oct | Day 04 Part B1 (Spring) | Tests 13/13 but the first B1 item was skipped: `@Size(min=2, max=50)` still has no `message`. The 409 for duplicate email was added on create and update, yet only the "own email stays 200" case is tested, not "another student's email → 409" on PUT. Also noted: no unique constraint on `email`, so check-then-save can race. Lesson: tick every line of the task list before pushing, and test each new status code on every endpoint that can return it. | 3 Nov | 7 Nov |
