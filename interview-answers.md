# 🎤 Interview answers — index

![Answered](https://img.shields.io/badge/graded-Day%2002%20%C2%B7%20Day%2003%20%C2%B7%20Day%2004-brightgreen) ![Pending](https://img.shields.io/badge/pending-SoP-orange)

> [!IMPORTANT]
> A set is only ✅ when my own answers are written and graded. Graded day files live in `spring-boot/interview-answers/` and are linked here, not copied.

> [!NOTE]
> **Legend:** ✅ graded · 🔴 needs correction · ⏳ pending · ⬜ no record · 🔵 ready for revision. Grades are out of 10.

| Day | Topic | Status | File |
|---|---|---|---|
| 01 | — | ⬜ No graded record found | — |
| 02 | Core / DI / mapping | ✅ Graded: Q1 5/10 · Q2 7/10 · Q3 5/10 | [day02-answers.md](spring-boot/interview-answers/day02-answers.md) |
| 03 | HTTP semantics, mapping | ✅ Graded: Q1 5/10 · Q2 5/10 · Q3 7/10 (17/30) · 🔵 Q1, Q2 ready for revision | [day03-answers.md](spring-boot/interview-answers/day03-answers.md) |
| 04 | Request flow, DTOs, errors | 🔴 Needs correction: Q1 5/10 · Q2 4/10 · Q3 6/10 (15/30) | [day04-answers.md](spring-boot/interview-answers/day04-answers.md) |
| SoP | Score of Parentheses follow-up | ⏳ Pending | below |

## 📅 Day 03 — ✅ Graded (17/30)
Source: [day03-morning.md](tasks/day03-morning.md) · Full answers and grades: [day03-answers.md](spring-boot/interview-answers/day03-answers.md)

> [!NOTE]
> Q1 5/10 · Q2 5/10 · Q3 7/10. Q1 and Q2 are 🔵 Ready for revision.

## 📅 Day 04 — 🔴 Needs correction (15/30)
Source: [day04-morning.md](tasks/day04-morning.md) · Full answers and grades: [day04-answers.md](spring-boot/interview-answers/day04-answers.md)

> [!WARNING]
> Q1 5/10 · Q2 4/10 · Q3 6/10. All three are partial, so all three are 🔴 Needs correction: re-answer them in chat by Tue 3 Nov. Q1 missed `MethodArgumentNotValidException`, Q2 was vague, Q3 missed the race condition (unique constraint + `DataIntegrityViolationException` → 409).

## 🧩 Score of Parentheses follow-up — ⏳ Pending
Source: `src/main/java/com/prashant/dsa/stack/ScoreOfParentheses.java` (c909bb8)

**Q1.** Why push a `0` before the loop starts? What would break without it?
> _Answer:_

**Q2.** Dry-run `"(()(()))"` and tell me what's on the stack right after index 5.
> _Answer:_

**Q3.** There's an O(1)-space solution that counts depth and adds `1 << depth` at each `()`. How does it work, and what's its overflow risk here?
> _Answer:_
