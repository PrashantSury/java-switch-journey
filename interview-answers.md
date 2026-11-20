# 🎤 Interview answers — index

![Answered](https://img.shields.io/badge/graded-Day%2002%20%C2%B7%20Day%2003%20%C2%B7%20Day%2004-brightgreen) ![Pending](https://img.shields.io/badge/pending-SoP%20%C2%B7%20labs%20Ch2%20%C2%B7%20B2%20Q3%2FQ6-orange)

> [!IMPORTANT]
> A set is only ✅ when my own answers are written and graded. Graded day files live in `spring-boot/interview-answers/` and are linked here, not copied.

> [!NOTE]
> **Legend:** ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (graded 7+ or re-answered cleanly) · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Grades are out of 10. From 1 Nov 2026 the questions are senior-level (internals, trade-offs, production scenarios); see [docs/PROGRAM.md](docs/PROGRAM.md).

| Day | Topic | Status | File |
|---|---|---|---|
| 01 | — | ⬜ NOT_STARTED (no graded record found) | — |
| 02 | Core / DI / mapping | 🟡 IN_PROGRESS: Q1 5/10 · Q2 7/10 ✅ · Q3 5/10; re-answer Q1, Q3 | [day02-answers.md](spring-boot/interview-answers/day02-answers.md) |
| 03 | HTTP semantics, mapping | 🟡 IN_PROGRESS: Q1 5/10 · Q2 5/10 · Q3 7/10 ✅ (17/30); re-answer Q1, Q2 | [day03-answers.md](spring-boot/interview-answers/day03-answers.md) |
| 04 | Request flow, DTOs, errors | ✅ COMPLETED via re-answers (1 Nov: 8/10 · 9/10 · 9/10, 26/30); first answers Q1 5/10 · Q2 4/10 · Q3 6/10 (15/30) | [day04-answers.md](spring-boot/interview-answers/day04-answers.md) |
| SoP | Score of Parentheses follow-up | ⬜ NOT_STARTED (answers pending) | below |
| labs Ch1 | Maven / parent / scopes (`spring-boot-labs`) | ✅ COMPLETED (15 Nov, chat interview **7/10**; scopes grid recall 10/10 on 16 Nov) | below · [day24.md](tasks/day24.md#-chapter-1-interview-grade-807-815-am-ist) |
| labs Ch2 | Query params, request binding, `@SpringBootApplication` (`spring-boot-labs`) | ⬜ NOT_STARTED (assigned Day 26) | below |

## 📅 Day 03 — 🟡 IN_PROGRESS (17/30)
Source: the old `day03-morning.md`, now [archived](archive/tasks/day02-05-morning.md) · Full answers and grades: [day03-answers.md](spring-boot/interview-answers/day03-answers.md)

> [!NOTE]
> Q1 5/10 · Q2 5/10 · Q3 7/10. Q1 and Q2 are 🟡 `IN_PROGRESS` (re-answer them); Q3 is ✅ `COMPLETED`.

## 📅 Day 04 — 🔴 REVISION_REQUIRED (15/30)
Source: the old `day04-morning.md`, now [archived](archive/tasks/day02-05-morning.md) · Full answers and grades: [day04-answers.md](spring-boot/interview-answers/day04-answers.md)

> [!WARNING]
> Q1 5/10 · Q2 4/10 · Q3 6/10. All three are partial, so all three are 🔴 `REVISION_REQUIRED`: re-answer them in chat by Tue 3 Nov. Q1 missed `MethodArgumentNotValidException`, Q2 was vague, Q3 missed the race condition (unique constraint + `DataIntegrityViolationException` → 409).

## 🧩 Score of Parentheses follow-up — ⬜ NOT_STARTED
Source: `src/main/java/com/prashant/dsa/stack/ScoreOfParentheses.java` (c909bb8)

**Q1.** Why push a `0` before the loop starts? What would break without it?
> _Answer:_

**Q2.** Dry-run `"(()(()))"` and tell me what's on the stack right after index 5.
> _Answer:_

**Q3.** There's an O(1)-space solution that counts depth and adds `1 << depth` at each `()`. How does it work, and what's its overflow risk here?
> _Answer:_

## 🌱 spring-boot-labs Chapter 1 — ✅ COMPLETED (7/10, graded in chat 15 Nov)
Source: [chapters/01-maven-and-the-pom/README.md](https://github.com/PrashantSury/spring-boot-labs/blob/main/chapters/01-maven-and-the-pom/README.md) · assigned [tasks/day15.md](tasks/day15.md)

**Q1.** Who picks the version of `spring-boot-starter-webmvc` when you don't write one, and what happens to all your starters when you upgrade Spring Boot?
> _Answer:_

**Q2.** What is the difference between Maven scopes `runtime` and `provided`?
> _Answer:_

## 🌱 spring-boot-labs Chapter 2 — 🟡 IN_PROGRESS (code 19/19 at `b4a3717`; Q4 owed in chat)
Source: [chapters/02-first-spring-boot-app/README.md](https://github.com/PrashantSury/spring-boot-labs/blob/main/chapters/02-first-spring-boot-app/README.md) · assigned [tasks/day26.md](tasks/day26.md#-1-chapter-2-task-4-carried-over-and-task-5-50-min)

**Q1.** A client calls `GET /accounts/above?balance=10000` and gets 404, but `/accounts` works. Walk through how `RequestMappingHandlerMapping` matches the request and why `@GetMapping("/accounts/above?balance=N")` never matches.
> _Answer:_

**Q2.** `@RequestParam(required = false) int page` and the client leaves `page` out: what does Spring do, which status does the client see, and why does the same line with `boolean` not fail? Give two correct fixes and their trade-offs.
> _Answer:_

**Q3.** A filter endpoint like `/accounts/above` grows to 6 optional filters. When would you bind them into one object (a record) instead of six `@RequestParam`s, and how does validation change?
> _Answer:_

**Q4 (Task 6, from the chapter).** What does `@SpringBootApplication` switch on? Name the three annotations inside it and what each does. What happens if the controller class is in a package above the application class?
> _Answer:_

## 🌱 spring-boot-labs Chapter 3 — ⬜ NOT_STARTED
Source: [chapters/03-beans-and-the-application-context/README.md](https://github.com/PrashantSury/spring-boot-labs/blob/main/chapters/03-beans-and-the-application-context/README.md) · assigned [tasks/day29.md](tasks/day29.md#-1-spring-close-chapter-2-then-chapter-3-tasks-1-2-60-min)

**Q1 (Task 6, from the chapter).** Spring beans are singletons by default. What does that mean, is it the same as the singleton pattern, does it make a bean thread-safe, and what is the difference between `@Component` and `@Bean`? (Written answer goes in the chapter's `interview-answer.md`; graded in chat.)
> _Answer:_

**Q2 (senior).** A singleton `TransferService` keeps a `private BigDecimal runningTotal` field that each request updates. Under load, totals drift. Explain why, and give two fixes with their trade-offs.
> _Answer:_

**Q3 (senior).** A singleton bean gets a prototype `Receipt` injected through its constructor. Does every transfer get a new receipt? If not, name two ways to get a fresh one per call.
> _Answer:_
