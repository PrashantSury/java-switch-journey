# 🎤 Interview answers — index

![Answered](https://img.shields.io/badge/graded-Day%2002%20%C2%B7%20Day%2003%20%C2%B7%20Day%2004-brightgreen) ![Labs Ch2](https://img.shields.io/badge/labs%20Ch2%20Q4-7%2F10-yellowgreen) ![Labs Ch3](https://img.shields.io/badge/labs%20Ch3%20Q1-5%2F10-orange) ![Pending](https://img.shields.io/badge/pending-SoP%20%C2%B7%20labs%20Ch3%20%C2%B7%20B2%20Q3%2FQ6-orange)

> [!IMPORTANT]
> A set is only ✅ when my own answers are written and graded. Graded day files live in `spring-boot/interview-answers/` and are linked here, not copied.

> [!NOTE]
> **Legend:** ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (graded 7+ or re-answered cleanly) · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Grades are out of 10. From 1 Nov 2026 the questions are senior-level (internals, trade-offs, production scenarios); see [docs/PROGRAM.md](docs/PROGRAM.md).

| Day | Topic | Status | File |
|---|---|---|---|
| 01 | — | ⬜ NOT_STARTED (no graded record found) | — |
| 02 | Core / DI / mapping | 🟡 IN_PROGRESS: Q1 5/10 · Q2 7/10 ✅ · Q3 5/10; re-answer Q1, Q3 | [day02-answers.md](archive/spring-boot/interview-answers/day02-answers.md) |
| 03 | HTTP semantics, mapping | 🟡 IN_PROGRESS: Q1 5/10 · Q2 5/10 · Q3 7/10 ✅ (17/30); re-answer Q1, Q2 | [day03-answers.md](archive/spring-boot/interview-answers/day03-answers.md) |
| 04 | Request flow, DTOs, errors | ✅ COMPLETED via re-answers (1 Nov: 8/10 · 9/10 · 9/10, 26/30); first answers Q1 5/10 · Q2 4/10 · Q3 6/10 (15/30) | [day04-answers.md](archive/spring-boot/interview-answers/day04-answers.md) |
| SoP | Score of Parentheses follow-up | ⬜ NOT_STARTED (answers pending) | below |
| labs Ch1 | Maven / parent / scopes (`spring-boot-labs`) | ✅ COMPLETED (15 Nov, chat interview **7/10**; scopes grid recall 10/10 on 16 Nov) | below · [day24.md](archive/tasks/day24.md#-chapter-1-interview-grade-807-815-am-ist) |
| labs Ch2 | Query params, request binding, `@SpringBootApplication` (`spring-boot-labs`) | ✅ COMPLETED (21 Nov): Task 6 interview (Q4) **7/10** in chat after two corrections; code 19/19. Q1-Q3 are extra practice, not graded | below · [day30.md end of day](tasks/day30.md#-end-of-day) |
| labs Ch3 | Singleton beans, `@Component` vs `@Bean` (`spring-boot-labs`) | 🔴 REVISION_REQUIRED: Q1 written **5/10** (20 Nov); re-answer + Q2/Q3 first on Sun 22 Nov | below |

## 📅 Day 03 — 🟡 IN_PROGRESS (17/30)
Source: the old `day03-morning.md`, now [archived](archive/tasks/day02-05-morning.md) · Full answers and grades: [day03-answers.md](archive/spring-boot/interview-answers/day03-answers.md)

> [!NOTE]
> Q1 5/10 · Q2 5/10 · Q3 7/10. Q1 and Q2 are 🟡 `IN_PROGRESS` (re-answer them); Q3 is ✅ `COMPLETED`.

## 📅 Day 04 — ✅ COMPLETED via re-answers (26/30; first attempt 15/30)
Source: the old `day04-morning.md`, now [archived](archive/tasks/day02-05-morning.md) · Full answers and grades: [day04-answers.md](archive/spring-boot/interview-answers/day04-answers.md)

> [!WARNING]
> Q1 5/10 · Q2 4/10 · Q3 6/10. All three are partial, so all three are 🔴 `REVISION_REQUIRED`: re-answer them in chat by Tue 3 Nov. Q1 missed `MethodArgumentNotValidException`, Q2 was vague, Q3 missed the race condition (unique constraint + `DataIntegrityViolationException` → 409). Re-answered 1 Nov: **8/10 · 9/10 · 9/10 (26/30)** ✅, so the set is closed.

## 🧩 Score of Parentheses follow-up — ⬜ NOT_STARTED
Source: `src/main/java/com/prashant/dsa/stack/ScoreOfParentheses.java` (c909bb8)

**Q1.** Why push a `0` before the loop starts? What would break without it?
> _Answer:_

**Q2.** Dry-run `"(()(()))"` and tell me what's on the stack right after index 5.
> _Answer:_

**Q3.** There's an O(1)-space solution that counts depth and adds `1 << depth` at each `()`. How does it work, and what's its overflow risk here?
> _Answer:_

## 🌱 spring-boot-labs Chapter 1 — ✅ COMPLETED (7/10, graded in chat 15 Nov)
Source: [chapters/01-maven-and-the-pom/README.md](https://github.com/PrashantSury/spring-boot-labs/blob/main/chapters/01-maven-and-the-pom/README.md) · assigned [tasks/day15.md](archive/tasks/day15.md)

**Q1.** Who picks the version of `spring-boot-starter-webmvc` when you don't write one, and what happens to all your starters when you upgrade Spring Boot?
> _Answer:_

**Q2.** What is the difference between Maven scopes `runtime` and `provided`?
> _Answer:_

## 🌱 spring-boot-labs Chapter 2 — ✅ COMPLETED (code 19/19 at `b4a3717`; Q4 **7/10** in chat, 21 Nov)
Source: [chapters/02-first-spring-boot-app/README.md](https://github.com/PrashantSury/spring-boot-labs/blob/main/chapters/02-first-spring-boot-app/README.md) · assigned [tasks/day26.md](archive/tasks/day26.md#-1-chapter-2-task-4-carried-over-and-task-5-50-min)

**Q1.** A client calls `GET /accounts/above?balance=10000` and gets 404, but `/accounts` works. Walk through how `RequestMappingHandlerMapping` matches the request and why `@GetMapping("/accounts/above?balance=N")` never matches.
> _Answer:_

**Q2.** `@RequestParam(required = false) int page` and the client leaves `page` out: what does Spring do, which status does the client see, and why does the same line with `boolean` not fail? Give two correct fixes and their trade-offs.
> _Answer:_

**Q3.** A filter endpoint like `/accounts/above` grows to 6 optional filters. When would you bind them into one object (a record) instead of six `@RequestParam`s, and how does validation change?
> _Answer:_

**Q4 (Task 6, from the chapter).** What does `@SpringBootApplication` switch on? Name the three annotations inside it and what each does. What happens if the controller class is in a package above the application class?
> _Answer (chat, 21 Nov 9:38-9:40 PM IST, summarised):_ part 1, the three annotations and their jobs, right first time; part 2 first said the controller above the application class **gets scanned**, then corrected to **not scanned → 404**; part 3 first explained *why* an auto-configuration applies, then gave `--debug =true` for how to see it.

```diff
- a controller in a package above the application class gets scanned
+ it is not scanned (component scan starts at the application class's package and goes down), so no handler is mapped → 404
- (part 3) why the auto-configuration applies
+ start with --debug on the command line, or debug=true in application.properties, and read the conditions evaluation report
```

> [!NOTE]
> **Grade 7/10** (after two corrections). Part 1 ✅. Part 2 ❌ then ✅ after the correction. Part 3 answered the wrong question first, then `--debug =true` was accepted as the flag (`--debug` on the CLI, `debug=true` in `application.properties`). With the code at 19/19 (19 Nov), **Chapter 2 is ✅ COMPLETED**.

> [!TIP]
> Model answer: `@SpringBootApplication` = `@SpringBootConfiguration` (the class is a `@Configuration` source of beans) + `@EnableAutoConfiguration` (loads the auto-configuration classes listed by Spring Boot and keeps only those whose `@Conditional...` checks pass) + `@ComponentScan` (scans the application class's package and its sub-packages). A controller in a package above it is never found, so no handler mapping exists and the URL returns 404. To see why an auto-configuration did or didn't apply, start with `--debug` (or `debug=true`) and read the **conditions evaluation report**: positive matches, negative matches, and the condition that failed.

## 🌱 spring-boot-labs Chapter 3 — 🔴 REVISION_REQUIRED (code 15/15 at `e619f82`; Q1 written 5/10, Q2-Q3 owed)
Source: [chapters/03-beans-and-the-application-context/README.md](https://github.com/PrashantSury/spring-boot-labs/blob/main/chapters/03-beans-and-the-application-context/README.md) · assigned [tasks/day29.md](archive/tasks/day29.md#-1-spring-close-chapter-2-then-chapter-3-tasks-1-2-60-min)

**Q1 (Task 6, from the chapter).** Spring beans are singletons by default. What does that mean, is it the same as the singleton pattern, does it make a bean thread-safe, and what is the difference between `@Component` and `@Bean`? (Written answer goes in the chapter's `interview-answer.md`; graded in chat.)
> _Answer (labs `my-solutions` `e619f82`, 20 Nov 1:04 PM IST, 3 sentences):_ one copy per application context, not the Gang-of-Four pattern; not thread-safe, "we can make deep copies of the mutable fields"; `@Component` on your own class, `@Bean` method in a `@Configuration` class for JDK classes.
>
> **Grade 5/10 (20 Nov evening).** Part 1 ✅ exact. Part 2 half: "not thread-safe" ✅, but deep copies don't fix a race on a shared field ❌ (logged in [mistakes/spring.md](revision/mistakes/spring.md)); expected: stateless beans, immutable fields, thread-safe types / locks for read-modify-write, or a narrower scope. Part 3 half: right rule, but it misses *why* (`@Component` is found by scanning; `@Bean` is for classes you don't own **or** that need code to build, e.g. `Clock.system(...)`). Below the 4-8 sentences asked. Re-answer due Sat 21 Nov in chat.

**Q2 (senior).** A singleton `TransferService` keeps a `private BigDecimal runningTotal` field that each request updates. Under load, totals drift. Explain why, and give two fixes with their trade-offs.
> _Answer:_

**Q3 (senior).** A singleton bean gets a prototype `Receipt` injected through its constructor. Does every transfer get a new receipt? If not, name two ways to get a fresh one per call.
> _Answer:_
