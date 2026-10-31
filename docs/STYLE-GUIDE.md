# 🎨 Markdown style guide

![Standard](https://img.shields.io/badge/standard-revision%2Fmistakes%2Fdsa.md-purple) ![Applies to](https://img.shields.io/badge/applies%20to-every%20.md%20file-blue)

> [!IMPORTANT]
> Every `.md` file in this repo opens exactly like [`revision/mistakes/dsa.md`](../revision/mistakes/dsa.md): emoji title, one badge row, an `[!IMPORTANT]` purpose (1-2 sentences), an `[!NOTE]` with a **Legend:** line, then the body. Routines and Lumi must produce this opener for every new or updated file, tasks included.

> [!NOTE]
> **Legend:** ✅ done / correct · ❌ wrong · ⚠️ gotcha · 📌 rule · 🔥 focus · ⬜🟡✅🔴⛔ statuses (see `PROGRESS.md` and [PROGRAM.md](PROGRAM.md)) · 🧩 DSA · 🐞 buggy round · 🗄️ SQL (archived) · 🌱 Spring.

## 🧬 The opener (non-negotiable)
```markdown
# 🔁 Emoji + title

![Label](https://img.shields.io/badge/label-value-blue)

> [!IMPORTANT]
> Purpose or rule of the file, 1-2 sentences (for a task file: what you do and the done criterion).

> [!NOTE]
> **Legend:** 🐞 buggy round · 🧩 DSA · ✅ done · ❌ stuck. Any short context sentence may follow after a `>` blank line.
```
- The first callout is always `[!IMPORTANT]`, the second always `[!NOTE]` with a `**Legend:**` line. Never open with `[!TIP]`, `[!WARNING]` or a plain intro line.
- One badge row (shields.io) with the file's own facts: `Day`, `Week`, `slot`, `time`, `Lesson`, `grade`, `Spring Boot`, `Java`.
- Put TIPs, WARNINGs and CAUTIONs **after** the opener, next to what they explain.

## 🧱 Body rules
- `##` sections with one leading emoji each; blank line before and after every heading, callout, table and code block.
- Anything list-like that is tracked or compared goes in a **table** (`| Date | Problem | ... |`): layouts, file lists, "revise first" topics, backlogs, status maps. Work items are `- [ ]` **checklists**. Prose bullets are for explanations only.
- No `---` rules; no table of contents on short files.
- Status words (since 1 Nov 2026), always with their emoji: ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified only) · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. The old 🟠 Attempted and 🔵 Ready for revision are retired (both are `IN_PROGRESS`); Needs correction is `REVISION_REQUIRED`. Historical log rows keep the words they were written with.

## 🧰 Toolbox
| Element | Use for | Example |
|---|---|---|
| `> [!IMPORTANT]` (purple) | purpose, key points, defaults, rules, done criteria | `required = true` |
| `> [!NOTE]` (blue) | legend, context, background | base package, plan info |
| `> [!TIP]` (green) | how-to, revision hints, model answers | "Run `mvn test`" |
| `> [!WARNING]` (orange) | gotchas, low grades, structure changes | "Valid on String does nothing" |
| `> [!CAUTION]` (red) | things that break code or lose work | "commit before git pull" |
| shields.io badges | Day/Week, grades, confidence | `https://img.shields.io/badge/Q1-5%2F10-orange` |
| `` ```diff `` | wrong (`-`) vs correct (`+`) | his answer vs correction |
| `` ```java `` / `` ```sql `` / `` ```bash `` | all code | always tag the language |
| `` ```mermaid `` | flows & layer diagrams | request flow |

## 🏅 Badge colours
- Grades: `red` < 5, `orange` 5-6, `yellowgreen` 7-8, `brightgreen` 9-10.
- Confidence 1-5: `red` 1, `orange` 2-3, `yellowgreen` 4, `brightgreen` 5.
- Day / Week / Lesson / meta: `blue`; slot / time: `yellow`; spaced repetition / standard: `purple`.

## 📄 Per file type
| File type | On top of the opener |
|---|---|
| **Mistake logs** (`revision/mistakes/<section>.md`: `dsa.md`, `spring.md`; [`revision/mistake-log.md`](../revision/mistake-log.md) is only the index) | One log per section, same table in each (`\| Date \| Problem \| What went wrong \| Redo on day 3 \| Redo on day 7 \|`). Routines append a row to the file of the section, only for **conceptual** mistakes. Cosmetic slips (typos, stale comments, missing braces, unused imports, stray `main()`) are fixed directly in his code and never logged. A new section gets a new file plus one line in the index. |
| **Daily tasks** (`tasks/dayNN.md`, one file per day) | Badges: Week, Day, slot, time (under the title; evening and end-of-day sections may add a slot badge). IMPORTANT = what the day is for and the done criterion; NOTE = the task legend plus context. Then `## 🌅 Morning` (Spring about 50 / DSA about 35 / Buggy about 15 minutes), `## 🌙 Evening` (review, score each track out of 10, finish pending work), `## 🌒 End of day`, and the specs of the day's tasks written with the [spec templates](#-spec-templates-and-tone); with revise-first topics in a table, work in `- [ ]` checklists, "Done when" in `[!IMPORTANT]`, hints in `[!TIP]`, gotchas in `[!WARNING]`, the carried backlog as a table. |
| **SQL learn lessons** (archived, `archive/sql/learn/lessonNN.md`) | Lesson / time / schema badges; the `⏱ N minutes · schema · status:` line stays inside the NOTE; `## 🎯 What you will learn`, `💡 Concept`, `🧰 Setup`, `🧪 Worked example`, `📝 Exercises` with `### 🔹 Exercise N`, `🔎 Check your work`, `🏁 Done when`. |
| **Interview answers** | Grade badges in the badge row; verbatim answer in a `diff` block with `-` lines; grade in `[!WARNING]` (<7) or `[!NOTE]`; model answer in `[!TIP]`. |
| **Revision sheets** (`prerequisites.md`, workbook) | Per topic: `### 📖 Explanation` / `### 📖 Concept notes`, key points in `[!IMPORTANT]`, `### 💡 Example`, `### 🎤 Interview questions` or `### ❓ Questions` (each followed by `> ✍️ My answer:` in the workbook), `### ✅ Section check`. Workbook headings carry a section number and an emoji (`## 🧯 5. Validation and error handling`) and end with `[⬆ Back to contents](#-contents)`. |
| **READMEs / architecture docs / journals** | Badges for stack facts, layouts and file lists as tables, mermaid for flows. Architecture facts come from the code; anything not built yet is marked 📐 planned. |
| **Program / process docs** ([PROGRAM.md](PROGRAM.md)) | Tables for tracks, statuses, rubric and classification; no calendar dates as rules. |

## 🧬 Spec templates and tone
> [!IMPORTANT]
> Every task spec (Spring, DSA, buggy) is written like a good reference page: **why it matters first**, then the variants, then each variant step by step with a small realistic example and a data table, the expected result and what it means, a comparison table, and multiple-choice knowledge checks at the end. Plain, simple English with the exact technical terms. The reader is a senior engineer, so it explains internals and trade-offs, not basics.

### 🧱 Tone rules
| Rule | Do | Don't |
|---|---|---|
| Start with the reason | "Why optimistic locking matters: two transfers can read the same balance..." | Start with the steps |
| Name the variants | A list: `@Version`, `SELECT ... FOR UPDATE`, serializable isolation | Describe only the one approach |
| Show a small realistic example | A 3-row accounts table, then the result table, then "this means..." | An abstract description |
| Compare in a table | Behaviour per variant: when it fits, cost, failure mode | A paragraph of "it depends" |
| End with checks | 2-4 multiple-choice questions, options as a list | Open-ended homework |
| Senior level | Internals, trade-offs, production failure, what you would say in the interview | Fresher-level definitions |

### 🌱 Spring spec (12 sections, in this order)
| # | Section | What goes in it |
|---|---|---|
| 1 | What are we building | One paragraph and the done criterion |
| 2 | Why it matters | The production problem and the interview angle |
| 3 | Concepts | The terms needed, each with one precise line |
| 4 | Approaches / variants | A comparison table: when each fits, cost, failure mode |
| 5 | How it works internally | Request or transaction flow (mermaid), who calls whom |
| 6 | Banking use case | The concrete scenario with a small data table |
| 7 | Implementation requirements | A `- [ ]` checklist |
| 8 | Sample API request/response | JSON for success and each error |
| 9 | DB changes | Migration name, tables/columns, constraints (or "none") |
| 10 | Edge and failure cases | A table: case, expected status/behaviour |
| 11 | Testing requirements | Test names and what each proves |
| 12 | Interview questions | Senior-level, plus 2-4 multiple-choice knowledge checks |

After section 12 come the **empty stubs**: packages, classes, method signatures, DTOs, `TODO(write by hand)` markers and acceptance criteria. The stubs contain no solution.

### 🧩 DSA spec
| # | Section | Visible before the attempt? |
|---|---|---|
| 1 | Problem understanding, with a worked example | yes |
| 2 | Input / output and constraints | yes |
| 3 | Pattern identification and how to recognise it | yes |
| 4 | Approach: **brute force only**, plus hints phrased as questions | yes |
| 5 | Dry run table of the optimised algorithm | **no, inside `<details>`** |
| 6 | Java stub with TODOs (signature, rules, empty body) | yes |
| 7 | Complexity (brute force visible; optimised inside `<details>`) | partly |
| 8 | Interview follow-ups | yes |

The optimised algorithm, its dry run and the answers to the knowledge checks sit in one collapsed block:

```markdown
<details>
<summary><b>🔒 Open only after your attempt</b></summary>

(optimised algorithm, dry-run table, complexity, answers)

</details>
```

### 🐞 Buggy-problem spec
- Expected behaviour as a rules table, then test cases grouped **normal / edge / failure** (input, expected result, what it checks).
- Never reveal or hint at the faulty lines, the number of bugs, or which method holds them. Knowledge checks are about the pattern, not about the bug.
- The code and the tests are not edited when a spec is rewritten; only the explanation around them.

### 🔁 Redo card
A redo card is a three-line spec: the problem, the test class to run (`mvn test -Dtest=<Problem>Test`) and the checklist from [redo-schedule.md](../revision/redo-schedule.md).

## 🔗 Anchors
- GitHub drops the emoji and keeps the leading hyphen: `## 🧯 5. Validation` is `#-5-validation`. Prefer emoji without a variation selector (🧯, not 🛡️) in headings that are linked to.
- If you change a heading, update every `](#...)` link to it, in the same file and in other files.

## 🧪 Mermaid rules
- Use `flowchart LR/TB` or `sequenceDiagram`; keep node labels plain (avoid `@`, `()`, `{}` unquoted; wrap in `"..."` if needed).
- Keep a `` ```text `` fallback in `<details>` for complex flows.
