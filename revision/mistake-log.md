# 🔁 Mistake log

![Spaced repetition](https://img.shields.io/badge/redo-day%203%20%2B%20day%207-purple)

> [!IMPORTANT]
> Add every problem you got wrong or got stuck on. Redo it after 3 days and again after 7 days.

> [!NOTE]
> **Legend:** 🐞 buggy round · 🧩 DSA · 🗄️ SQL · 🌱 Spring — mark a redo ✅ when done cleanly, ❌ if you got stuck again.

| Date | Problem | What went wrong | Redo on day 3 | Redo on day 7 |
|------|---------|-----------------|---------------|---------------|
| 23 Oct | Day01ArrayStack (buggy round) | Needed hints. Missed off-by-one in the grow check (`size > data.length` should be `>=`), an empty check that could never be true (`size < 0` instead of `isEmpty()`), and zero capacity never growing (`0 * 2 = 0`). Lesson: trace each check with tiny inputs (0, 1, full array). | ✅ 28 Oct (2 days late, cold, 17/17) | 30 Oct |
| 24 Oct | Day02RpnEvaluator (buggy round) | Fixed all 3 bugs (44/44 pass) but needed a hint for the negative-number bug: `isOperator` checked only `charAt(0)`, so `"-3"` looked like an operator. Other fixes: `a * b` -> `Math.multiplyExact` (overflow), end check `isEmpty()` -> `size() != 1`. Lesson: test tokens that *start* like an operator (`-3`, `-0`) and think about overflow on every arithmetic op. | 27 Oct | 31 Oct |
| 27 Oct | Day02RpnEvaluatorRedo (redo) | Couldn't recall the solution from memory; re-read the original to get 44/44. Weak spot: pop order (first pop is `b`, the right operand) and the `-3` token check. Lesson: redo cold, no peeking. | 31 Oct | 3 Nov |
| 29 Oct | Day03NextGreaterIndex (buggy round) | Found both bugs (37/37), but pushed a stray `main()` again (same as `Day02RpnEvaluator`, removed in bcb37f3), left an unused `java.beans` import, and committed `.postman/` and `postman/globals/` files by accident. Lesson: run `git status` and read the diff before every push; delete scratch `main()` methods and unused imports. | 1 Nov | 5 Nov |
| 29 Oct | RemoveKAdjacentDuplicates (DSA quiz) | Solution passes 26/26, but the "why is the count stack O(n)" quiz scored 3/5: naive approach and its O(n²) were right, missed the amortised argument (each character is pushed once and popped at most once, so total work is O(n)). | 1 Nov | 5 Nov |
| 30 Oct | AsteroidCollision (DSA) | 28/28 pass, solution is right (stack, `long` size for `Integer.MIN_VALUE`). Hygiene miss: a stray `+6` typed into the Javadoc (`Rules for this repo:+6`) went into the commit. Same habit as the stray `main()` and unused import: read the diff before pushing. Style: one-line `if (top == size) stack.pop();` without braces, keep braces. | 2 Nov | 6 Nov |
| 30 Oct | SQL learn lesson 02, ex 1 | Checker 5/5, but the task says "Sorted by customer_id" and the query has no `ORDER BY`; it only passed because rows came back in insert order. Without `ORDER BY` the order is not guaranteed. Also use `<>` rather than `!=` and keep keyword case consistent. Fixed in f2e5a58 (ex 1 now has `ORDER BY`, lesson 02 ✅). | 2 Nov | 6 Nov |
| 31 Oct | Day 04 Part B1 (Spring) | Tests 13/13 but the first B1 item was skipped: `@Size(min=2, max=50)` still has no `message`. The 409 for duplicate email was added on create and update, yet only the "own email stays 200" case is tested, not "another student's email → 409" on PUT. A stale `// map to 409 in @RestControllerAdvice` comment was left in the service. Also noted: no unique constraint on `email`, so check-then-save can race. Lesson: tick every line of the task list before pushing, and test each new status code on every endpoint that can return it. | 3 Nov | 7 Nov |
