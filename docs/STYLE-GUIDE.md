# 🎨 Markdown style guide

![Standard](https://img.shields.io/badge/standard-revision%2Fmistakes%2Fdsa.md-purple) ![Applies to](https://img.shields.io/badge/applies%20to-every%20.md%20file-blue)

> [!IMPORTANT]
> Every `.md` file in this repo opens exactly like [`revision/mistakes/dsa.md`](../revision/mistakes/dsa.md): emoji title, one badge row, an `[!IMPORTANT]` purpose (1-2 sentences), an `[!NOTE]` with a **Legend:** line, then the body. Routines and Lumi must produce this opener for every new or updated file, tasks included.

> [!NOTE]
> **Legend:** ✅ done / correct · ❌ wrong · ⚠️ gotcha · 📌 rule · 🔥 focus · ⬜🟡🟠🔴🔵 statuses (see `PROGRESS.md`) · 🧩 DSA · 🐞 buggy round · 🗄️ SQL · 🌱 Spring.

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
- Status emoji: ⬜ Not started · 🟡 In progress · 🟠 Attempted · 🔴 Needs correction · 🔵 Ready for revision · ✅ Completed and verified.

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
| **Mistake logs** (`revision/mistakes/<section>.md`: `dsa.md`, `sql.md`, `spring.md`; [`revision/mistake-log.md`](../revision/mistake-log.md) is only the index) | One log per section, same table in each (`\| Date \| Problem \| What went wrong \| Redo on day 3 \| Redo on day 7 \|`). Routines append a row to the file of the section, only for **conceptual** mistakes. Cosmetic slips (typos, stale comments, missing braces, unused imports, stray `main()`) are fixed directly in his code and never logged. A new section gets a new file plus one line in the index. |
| **Daily tasks** (`tasks/dayNN.md`) | Badges: Week, Day, slot, time (under the title; evening and end-of-day sections may add a slot badge). IMPORTANT = what the day is for and the done criterion; NOTE = the task legend plus the "backlog day" context. Then `## 🌅 Morning`, `## 🌙 Evening`, `## 🌒 End of day`, with revise-first topics in a table, work in `- [ ]` checklists, "Done when" in `[!IMPORTANT]`, hints in `[!TIP]`, gotchas in `[!WARNING]`, the carried backlog as a table. |
| **SQL learn lessons** (`sql/learn/lessonNN.md`) | Lesson / time / schema badges; the `⏱ N minutes · schema · status:` line stays inside the NOTE; `## 🎯 What you will learn`, `💡 Concept`, `🧰 Setup`, `🧪 Worked example`, `📝 Exercises` with `### 🔹 Exercise N`, `🔎 Check your work`, `🏁 Done when`. |
| **Interview answers** | Grade badges in the badge row; verbatim answer in a `diff` block with `-` lines; grade in `[!WARNING]` (<7) or `[!NOTE]`; model answer in `[!TIP]`. |
| **Revision sheets** (`prerequisites.md`, workbook) | Per topic: `### 📖 Explanation` / `### 📖 Concept notes`, key points in `[!IMPORTANT]`, `### 💡 Example`, `### 🎤 Interview questions` or `### ❓ Questions` (each followed by `> ✍️ My answer:` in the workbook), `### ✅ Section check`. Workbook headings carry a section number and an emoji (`## 🧯 5. Validation and error handling`) and end with `[⬆ Back to contents](#-contents)`. |
| **READMEs / structure docs / journals** | Badges for stack facts, layouts and file lists as tables, mermaid for flows. |

## 🔗 Anchors
- GitHub drops the emoji and keeps the leading hyphen: `## 🧯 5. Validation` is `#-5-validation`. Prefer emoji without a variation selector (🧯, not 🛡️) in headings that are linked to.
- If you change a heading, update every `](#...)` link to it, in the same file and in other files.

## 🧪 Mermaid rules
- Use `flowchart LR/TB` or `sequenceDiagram`; keep node labels plain (avoid `@`, `()`, `{}` unquoted; wrap in `"..."` if needed).
- Keep a `` ```text `` fallback in `<details>` for complex flows.
