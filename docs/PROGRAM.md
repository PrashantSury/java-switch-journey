# 🧭 Program: Senior Java Backend Interview Mentor

![Tracks](https://img.shields.io/badge/tracks-3-blue) ![Time](https://img.shields.io/badge/time-2h%20morning%20%2B%201h%20evening-yellow) ![Level](https://img.shields.io/badge/level-senior%20(5.2%20yrs)-purple) ![Since](https://img.shields.io/badge/since-1%20Nov%202026-informational)

> [!IMPORTANT]
> The operating model of this repo in one page: three tracks, a 2 h + 1 h day, five statuses, and progress (never the calendar) deciding what comes next. If another file disagrees with this one about the process, this file wins; [`PROGRESS.md`](../PROGRESS.md) stays the single tracker.

> [!NOTE]
> **Legend:** 🏦 Spring Boot project · 🧩 DSA · 🐞 buggy problem · 🔁 redo · ⬜ NOT_STARTED · 🟡 IN_PROGRESS · ✅ COMPLETED · 🔴 REVISION_REQUIRED · ⛔ BLOCKED. Visual style: [STYLE-GUIDE.md](STYLE-GUIDE.md).

## 🎯 Why this program exists
Prashant is a 5.2-year Java Tech Lead (HSBC) preparing for senior Java backend interviews. At that level the questions are not "what is `@Autowired`". They are internals, trade-offs and production scenarios: what happens at 3 AM when two transfers hit the same account, why you chose optimistic over pessimistic locking, how you would roll a bad migration back. So every task here is written for a senior engineer: exact terms, internals, trade-offs and failure cases, with no fresher-level teaching.

## 🛤️ The three tracks
| | Track | What | Where the work lives |
|---|---|---|---|
| 🏦 | **Spring Boot retail banking** | One project, built module by module. Concepts are introduced progressively, each when a module needs it. Modules: Customer, Account, Beneficiary, Fund Transfers, Transactions, Transaction History, AuthN/AuthZ, Notifications, Statements/Reports, Audit/Compliance | `banking-app/` (design: [project-architecture.md](../banking-app/project-architecture.md)); `spring-boot/course-practice` is only finished, not extended |
| 🧩 | **DSA, NeetCode 150 by pattern** | One pattern at a time, in NeetCode order. Currently **Stack** | `src/main/java/com/prashant/dsa/<pattern>/` |
| 🐞 | **Buggy problems** | Fix-the-buggy-code rounds on the **current DSA pattern**, the interview format where code must pass given tests | `src/main/java/com/prashant/dailytests/` |

> [!NOTE]
> SQL is retired and archived ([archive/README.md](../archive/README.md)). Database questions are asked only as Spring/JPA/Flyway questions: N+1, transactions and isolation as Spring sees them, locking, migrations.

## ⏱️ The day: 2 h morning + 1 h evening
| Slot | Minutes | What |
|---|---|---|
| 🌅 Morning (all new work) | 120 | 🏦 Spring about 50 · 🧩 DSA about 35 · 🐞 Buggy about 15 · the rest is revise-first and buffer |
| 🌙 Evening | 60 | ① review and score each track out of 10 ② finish whatever is pending from the morning ③ only then a redo from the schedule |

> [!IMPORTANT]
> **Progress decides tasks, never the calendar.** A task is replaced only when it is ✅ COMPLETED. A day without a push does not move the plan; it just leaves the same task open. Pending morning work is finished in the evening, and anything still open the next morning comes first.

## 🚦 Statuses
| Status | Meaning | Old name it replaces |
|---|---|---|
| ⬜ `NOT_STARTED` | No work of mine in the repo yet | Not started |
| 🟡 `IN_PROGRESS` | Work exists, or it is passing but still in its revision cycle | In progress · Attempted · Ready for revision |
| ✅ `COMPLETED` | **Verified**: tests pass on my pushed code (or the answer is graded), and the reviewer has checked it | Completed and verified |
| 🔴 `REVISION_REQUIRED` | Reviewed and a conceptual gap was found; it must be redone or re-answered | Needs correction |
| ⛔ `BLOCKED` | Cannot continue until something outside the task is fixed (named in the Blockers table of `PROGRESS.md`) | new |

> [!WARNING]
> `COMPLETED` is never given on the strength of "it compiles" or "it passes by accident". Stub tests that pass on an empty method (for example an empty-input case) do not count. A problem keeps `COMPLETED` for its first verified solve; its spaced-repetition state lives in [redo-schedule.md](../revision/redo-schedule.md), where it stays `IN_PROGRESS` until it graduates (clean pass at the 30-day gap).

## 🔁 Spaced repetition
Every DSA problem and buggy round is redone cold on the ladder **1 → 3 → 7 → 14 → 30 days**, set by the **result** of each redo (clean pass moves up, hint or fix repeats the gap, conceptual miss resets to day 1), **at most 2 a day**. Calendar and rules: [revision/redo-schedule.md](../revision/redo-schedule.md). Conceptual mistakes (never cosmetic slips) go to the log of their track: [revision/mistakes/dsa.md](../revision/mistakes/dsa.md) or [spring.md](../revision/mistakes/spring.md). There is deliberately **no single `mistakes.md`**.

## 📝 Evening scoring rubric
Each evening every track that had work gets one score out of 10. Score each dimension that applied that day from 0 to 10; the track score is the rounded average of those dimensions. Skip a dimension that did not apply (for example, complexity on a Spring task) rather than scoring it zero.

| Dimension | What the reviewer checks |
|---|---|
| 🧠 Concept understanding | Can I explain why it works, in order, with the exact terms (not just what it does)? |
| 🛠️ Implementation | Does it pass the tests on my own pushed code, and is it clean and idiomatic for a lead engineer? |
| 🧩 Problem solving | Did I identify the pattern and pick an approach and its trade-offs before coding? |
| 🐞 Debugging | When something failed, did I read the failing test, localise the cause and fix it with the smallest change? |
| ⏱️ Complexity | Can I state time and space, and defend them (amortised arguments, worst case)? |
| 🎤 Interview readiness | Could I say this out loud in 60-90 seconds, with a production angle and a trade-off? |

## 🧪 Classification
| Class | Rule | What happens |
|---|---|---|
| 🟢 **Strong** | Track score 8-10 and no `REVISION_REQUIRED` item | Moves on; only the normal redo ladder |
| 🟡 **Moderate** | 6-7 | Moves on; the weakest dimension is noted in `PROGRESS.md` |
| 🔴 **Weak** | 0-5, or the same dimension missed twice | A **weak-topic pack** is generated (below) and goes to the front of the next morning |
| ⬜ **Pending** | Not scored yet | Listed in Pending |
| ⛔ **Blocked** | Cannot be scored until a blocker is cleared | Listed in Blockers |

## 🎒 Weak-topic pack
Generated for every 🔴 Weak topic. Exactly five parts, so it fits in one slot:

| # | Part | Size |
|---|---|---|
| 1 | **Notes**: a short concept note in the teaching style (why it matters, the variants, how it works, a comparison table) | 1 page |
| 2 | **1 conceptual question** | 5 min |
| 3 | **1 implementation task** | 15 min |
| 4 | **1 debugging task** (a small broken snippet; the bug is never hinted) | 10 min |
| 5 | **1 interview scenario** (a production situation to talk through) | 5 min |

## 📏 How every spec is written
Specs for Spring, DSA and buggy tasks follow the templates and the tone in [STYLE-GUIDE.md](STYLE-GUIDE.md#-spec-templates-and-tone): *why it matters → the variants → each one step by step with a small realistic example and data tables → the expected result and what it means → comparison tables → multiple-choice knowledge checks*, in plain English with exact technical terms.

> [!TIP]
> DSA specs keep the optimised algorithm and the dry run inside a collapsed `<details>` block titled **Open only after your attempt**. Buggy-problem specs state the expected behaviour and the test cases (normal, edge, failure) and never reveal or hint at the faulty lines.

## 📂 Where things are
| Need | File |
|---|---|
| What is done, pending, weak, blocked, next | [PROGRESS.md](../PROGRESS.md) |
| Today's work and the specs of pending tasks | `tasks/dayNN.md` (one file per day) |
| Graded interview answers | [interview-answers.md](../interview-answers.md) |
| What to redo today | [revision/redo-schedule.md](../revision/redo-schedule.md) |
| Conceptual mistakes | [revision/mistakes/](../revision/mistake-log.md) |
| Banking design | [banking-app/project-architecture.md](../banking-app/project-architecture.md) |
