# 🔁 Mistake log

![Spaced repetition](https://img.shields.io/badge/redo-day%203%20%2B%20day%207-purple)

> [!IMPORTANT]
> Add every problem you got wrong or got stuck on. Redo it after 3 days and again after 7 days.

> [!NOTE]
> **Legend:** 🐞 buggy round · 🧩 DSA · 🗄️ SQL · 🌱 Spring — mark a redo ✅ when done cleanly, ❌ if you got stuck again.

| Date | Problem | What went wrong | Redo on day 3 | Redo on day 7 |
|------|---------|-----------------|---------------|---------------|
| 23 Oct | Day01ArrayStack (buggy round) | Needed hints. Missed off-by-one in the grow check (`size > data.length` should be `>=`), an empty check that could never be true (`size < 0` instead of `isEmpty()`), and zero capacity never growing (`0 * 2 = 0`). Lesson: trace each check with tiny inputs (0, 1, full array). | 26 Oct | 30 Oct |
| 24 Oct | Day02RpnEvaluator (buggy round) | Fixed all 3 bugs (44/44 pass) but needed a hint for the negative-number bug: `isOperator` checked only `charAt(0)`, so `"-3"` looked like an operator. Other fixes: `a * b` -> `Math.multiplyExact` (overflow), end check `isEmpty()` -> `size() != 1`. Lesson: test tokens that *start* like an operator (`-3`, `-0`) and think about overflow on every arithmetic op. | 27 Oct | 31 Oct |
| 27 Oct | Day02RpnEvaluatorRedo (redo) | Couldn't recall the solution from memory; re-read the original to get 44/44. Weak spot: pop order (first pop is `b`, the right operand) and the `-3` token check. Lesson: redo cold, no peeking. | 31 Oct | 3 Nov |
