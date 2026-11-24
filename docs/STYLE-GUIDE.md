# 🎨 Markdown style guide (DSA + buggy repo)

Scope: this repo's DSA, buggy-round and record files. Spring specs are written in [spring-boot-labs](https://github.com/PrashantSury/spring-boot-labs); [`banking-app/`](../banking-app/README.md) is a standalone project with its own docs.

## 📄 Per file type

| File | Format |
|---|---|
| **Day files** `tasks/dayNN.md` | **Exactly [DAY-TEMPLATE.md](DAY-TEMPLATE.md)**: header line + Focus/Done-when line, `✅ Today` table, `🔎 Since yesterday`, one `## N. 🧩/🐞 <item>` per item with 3-6 bullets (goal, file, run `mvn test -Dtest=X`, done when, hint rule), `❓ Questions` (table + full text in `<details>`), `🔁 Redos` table, `📌 Pending` bullets, `🌙 Evening` and `🌒 End of day` tables, coach notes in the last `<details>`. No badges, no callout opener, **no paragraphs outside `<details>`**. Past days are not rewritten. |
| **Files Prashant reads** (`README.md`, `CONTRIBUTING.md`, `PROBLEMS.md`, the `🟢 Now` block of `PROGRESS.md`) | plain, short: tables and bullets, no essays, no badges |
| **Coach files** (`revision/`, `docs/`, the rest of `PROGRESS.md`) | opener: emoji title, optional badge row, `> [!IMPORTANT]` purpose (1-2 sentences), `> [!NOTE]` with a **Legend:** line; then the body |
| **Mistake log** `revision/mistakes/dsa.md` | one table `\| Date \| Problem \| What went wrong \| Redo on day 3 \| Redo on day 7 \|`; a row only for **conceptual** mistakes; cosmetic slips are fixed in place, never logged |

## 🧱 Body rules

- `##` headings with one leading emoji; blank line around every heading, table, callout and code block.
- Tracked or compared lists → **tables**; work items → `- [ ]` checklists; prose only inside `<details>` in day files.
- Status words with emoji: ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified only) · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Historical rows keep their old words.
- Code blocks always tag the language (`java`, `bash`, `diff`); `diff` for his line (`-`) vs the correction (`+`).
- Times in IST.

## 🧩 DSA spec (inside the item's `📖 Spec and teaching` block)

| # | Section | Where |
|---|---|---|
| 1 | Problem understanding: why it matters + worked example table | 📖 |
| 2 | Input / output and constraints | 📖 |
| 3 | Pattern and how to recognise it | 📖 |
| 4 | Brute force only + hints phrased as questions | 📖 |
| 5 | Dry run of the optimised algorithm | 🔒 |
| 6 | Java stub notes (signature, rules, TODOs, no solution) | 📖 |
| 7 | Complexity: brute force in 📖, optimised in 🔒 | both |
| 8 | Interview follow-ups + 2-4 multiple-choice checks (answers in 🔒) | 📖 |

Tone: reason first, small realistic example, comparison table, senior-level trade-offs, plain English with exact terms.

## 🐞 Buggy spec

- Expected behaviour as a rules table, then tests grouped **normal / edge / failure**.
- Never reveal or hint at the faulty lines, the number of bugs or which method holds them. Checks are about the pattern, not the bug.
- Code and tests are not edited when a spec is rewritten.
- New rounds are named `BuggyNN<Problem>` (see [CONTRIBUTING.md](../CONTRIBUTING.md)).

## 🔁 Redo card

One row in the day file's `🔁 Redos` table (redo, stub, `mvn test -Dtest=<Redo>Test`, when, done when, status) plus at most three bullets; rules from [redo-schedule.md](../revision/redo-schedule.md). Redo tests are `<Problem>Contract` subclasses, never copies.

## 🔗 Anchors

- GitHub drops emoji and keeps the hyphens: `## 2. 🐞 Day06 last loop` → `#2--day06-last-loop`. Prefer emoji without a variation selector in linked headings.
- Changing a heading means updating every `](#...)` link to it, in every file.
