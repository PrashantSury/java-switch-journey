# 🧭 Program: DSA + buggy rounds

This repo is **DSA (NeetCode by pattern) and buggy rounds only**, with cold redos. Spring practice lives in [spring-boot-labs](https://github.com/PrashantSury/spring-boot-labs); [`banking-app/`](../banking-app/README.md) is a standalone project kept here and is not part of the daily plan. If another file disagrees with this one about the process, this file wins; [`PROGRESS.md`](../PROGRESS.md) is the tracker.

## 🛤️ Tracks

| | Track | What | Where |
|---|---|---|---|
| 🧩 | DSA | one new NeetCode problem each weekday, one pattern at a time in NeetCode order | `src/main/java/com/prashant/dsa/<pattern>/` |
| 🐞 | Buggy | fix-the-code rounds on the current pattern, **Tue and Fri**; an open round blocks the next one | `src/main/java/com/prashant/dailytests/` |
| 🔁 | Redos | cold, 1 → 3 → 7 → 14 → 30 days by result, **max 2 a day** | `src/main/java/com/prashant/dailytests/redo/` |

## ⏱️ The day

| Slot | What |
|---|---|
| 🌅 Morning | 🧩 DSA ~35-40 min · 🐞 buggy slot ~15 min · redo 20-30 min (blank stub, timer) |
| 🌙 Evening | ① review and score 🧩 DSA and 🐞 Buggy out of 10 ② finish morning leftovers ③ then a redo from the schedule |
| Weekend | review and cold redos only, no new problems |

- **Progress decides tasks, never the calendar.** A task is replaced only when ✅ COMPLETED. An unfinished problem carries over with stronger hints, never open more than 2 days.
- Pseudocode (3-5 lines) before Java; stuck 15 min → ask for a hint; every complexity line has a "because".
- Goal: 45-50 verified problems by mid-January 2027.

## 🚦 Statuses

| Status | Meaning |
|---|---|
| ⬜ `NOT_STARTED` | no work in the repo yet |
| 🟡 `IN_PROGRESS` | work exists, or passing but still in its redo cycle |
| ✅ `COMPLETED` | **verified**: tests pass on the pushed code and the reviewer checked it (never "passes by accident") |
| 🔴 `REVISION_REQUIRED` | reviewed, conceptual gap found; redo it |
| ⛔ `BLOCKED` | waiting on something outside the task (listed in PROGRESS Blockers) |

A problem keeps ✅ for its first verified solve; its redo state lives in [redo-schedule.md](../revision/redo-schedule.md). Conceptual mistakes (never cosmetic slips) go to [revision/mistakes/dsa.md](../revision/mistakes/dsa.md).

## 📝 Evening scoring rubric

Each track that had work gets one score out of 10 = rounded average of the dimensions that applied (skip, don't zero, the ones that didn't). No work → "unscored", never an invented number.

| Dimension | Check |
|---|---|
| 🧠 Concept | explains why it works, with exact terms |
| 🛠️ Implementation | passes on his own pushed code; clean and idiomatic |
| 🧩 Problem solving | pattern and approach chosen before coding |
| 🐞 Debugging | read the failing test, localised the cause, smallest fix |
| ⏱️ Complexity | time and space stated and defended |
| 🎤 Interview | could say it out loud in 60-90 s with a trade-off |

| Class | Rule | Then |
|---|---|---|
| 🟢 Strong | 8-10, nothing 🔴 | normal redo ladder |
| 🟡 Moderate | 6-7 | weakest dimension noted in PROGRESS |
| 🔴 Weak | 0-5, or the same dimension missed twice | weak-topic pack first next morning |

**Weak-topic pack** (one slot): short note (1 page) · 1 conceptual question (5 min) · 1 implementation task (15 min) · 1 debugging snippet, bug never hinted (10 min) · 1 interview scenario (5 min).

## 📏 Specs and files

- Day files follow [DAY-TEMPLATE.md](DAY-TEMPLATE.md); spec details in [STYLE-GUIDE.md](STYLE-GUIDE.md).
- DSA specs keep the optimised algorithm and dry run in a `🔒 Open only after your attempt` block. Buggy specs give behaviour and tests, never the faulty lines.
- Today: `tasks/dayNN.md` (last 5 days; older in `archive/tasks/`) · redo calendar: [redo-schedule.md](../revision/redo-schedule.md) · problems: [PROBLEMS.md](../PROBLEMS.md).
- History kept as is: older Spring rows in PROGRESS and `archive/`, [interview-answers.md](../interview-answers.md), [revision/mistakes/spring.md](../revision/mistakes/spring.md), `archive/spring-boot/`.
