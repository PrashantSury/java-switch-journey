# 🧩 DSA mistake log

![Spaced repetition](https://img.shields.io/badge/redo-day%203%20%2B%20day%207-purple) ![Section](https://img.shields.io/badge/section-DSA-blue)

> [!IMPORTANT]
> Conceptual mistakes from DSA problems, buggy rounds and DSA quizzes. Redo each item after 3 days and again after 7 days. Only conceptual mistakes go here; cosmetic slips (typos, stale comments, missing braces, unused imports, stray `main()`) are fixed directly by Lumi and not logged.

> [!NOTE]
> **Legend:** 🐞 buggy round · 🧩 DSA · 🔁 redo · mark a redo ✅ when done cleanly, ❌ if you got stuck again. Other sections: [index](../mistake-log.md).

| Date | Problem | What went wrong | Redo on day 3 | Redo on day 7 |
|------|---------|-----------------|---------------|---------------|
| 23 Oct | Day01ArrayStack (buggy round) | Needed hints. Missed off-by-one in the grow check (`size > data.length` should be `>=`), an empty check that could never be true (`size < 0` instead of `isEmpty()`), and zero capacity never growing (`0 * 2 = 0`). Lesson: trace each check with tiny inputs (0, 1, full array). | ✅ 28 Oct (2 days late, cold, 17/17) | 30 Oct |
| 24 Oct | Day02RpnEvaluator (buggy round) | Fixed all 3 bugs (44/44 pass) but needed a hint for the negative-number bug: `isOperator` checked only `charAt(0)`, so `"-3"` looked like an operator. Other fixes: `a * b` -> `Math.multiplyExact` (overflow), end check `isEmpty()` -> `size() != 1`. Lesson: test tokens that *start* like an operator (`-3`, `-0`) and think about overflow on every arithmetic op. | 27 Oct | 31 Oct |
| 27 Oct | Day02RpnEvaluatorRedo (redo) | Couldn't recall the solution from memory; re-read the original to get 44/44. Weak spot: pop order (first pop is `b`, the right operand) and the `-3` token check. Lesson: redo cold, no peeking. | 31 Oct | 3 Nov |
| 29 Oct | RemoveKAdjacentDuplicates (DSA quiz) | Solution passes 26/26, but the "why is the count stack O(n)" quiz scored 3/5: naive approach and its O(n²) were right, missed the amortised argument (each character is pushed once and popped at most once, so total work is O(n)). | 1 Nov | 5 Nov |
| 31 Oct | Day02RpnEvaluatorRedo7 (day-7 cold redo) | 15/44. Control-flow slip: after the operator branch the loop kept going and ran `Integer.parseInt(token)` on `"+"`, so every expression with an operator crashed (needs `continue` or `else`). End check was `stack.pop() != 1` (pops a value and compares it with 1) instead of `stack.size() != 1`, which also breaks a single operand. `null`/empty `tokens` was never rejected with `IllegalArgumentException`. Lesson: after writing a branch, trace a 3-token input (`2 3 +`) line by line, and write the empty/single-token cases first. | 3 Nov | 7 Nov |
