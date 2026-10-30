# 🎨 Markdown style guide

![Standard](https://img.shields.io/badge/standard-revision%2Fmistake--log.md-purple) ![Applies to](https://img.shields.io/badge/applies%20to-all%20.md%20files-blue)

> [!IMPORTANT]
> The repo standard is the look of [`revision/mistake-log.md`](../revision/mistake-log.md): a compact page with an emoji title, one badge row, a purpose callout, a legend callout and then the content. Colour guides the eye, it never changes content. Routines and Lumi must produce every `.md` file in this style.

> [!NOTE]
> **Legend:** ✅ done / correct · ❌ wrong · ⚠️ gotcha · 📌 rule · 🔥 focus · ⬜🟡🟠🔴🔵 statuses (see `PROGRESS.md`).

## 🧬 The mistake-log pattern (every file)
1. **Title:** `# <emoji> Title`, one line.
2. **Badge row** directly under the title (shields.io): the file's own facts only, e.g. `Day`, `Week`, `slot`, `Lesson`, `grade`.
3. **`> [!IMPORTANT]`** purpose or rule of the file, 1-2 sentences (for tasks: the "Done when").
4. **`> [!NOTE]`** legend or context, 1-2 sentences, with the status emoji used in the file.
5. **Body:** `##` sections with one leading emoji each, short bullets, tables for anything list-like, `- [ ]` checklists for work.
6. No `---` rules, no tables of contents on short files, no walls of text. Blank line before and after every heading, callout, table and code block.

## 🧰 Toolbox
| Element | Use for | Example |
|---|---|---|
| `> [!NOTE]` (blue) | context, legends, background | base package, plan info |
| `> [!TIP]` (green) | how-to, revision hints, model answers | "Run `mvn test`" |
| `> [!IMPORTANT]` (purple) | purpose, key points, defaults, rules, done criteria | `required = true` |
| `> [!WARNING]` (orange) | gotchas, low grades, structure changes | "Valid on String does nothing" |
| `> [!CAUTION]` (red) | things that break code or lose work | "commit before git pull" |
| Emoji in headings | quick scanning | 🧠 🔀 🌐 🧯 💾 🧪 🔧 🎤 🔥 📌 |
| Status emoji | ✅ done/correct · ❌ wrong · ⚠️ gotcha · 📌 rule · 🔥 focus | |
| shields.io badges | Day/Week, grades, confidence | `https://img.shields.io/badge/Q1-5%2F10-orange` |
| `` ```diff `` | wrong (`-`) vs correct (`+`) | his answer vs correction |
| `` ```java `` / `` ```sql `` / `` ```bash `` | all code | always tag the language |
| `` ```mermaid `` | flows & layer diagrams | request flow |

## 🏅 Badge colours
- Grades: `red` < 5, `orange` 5-6, `yellowgreen` 7-8, `brightgreen` 9-10.
- Confidence 1-5: `red` 1, `orange` 2-3, `yellowgreen` 4, `brightgreen` 5.
- Day / Week / Lesson / meta: `blue`; slot / time: `yellow`; spaced repetition / standard: `purple`.

## 📄 Per file type
| File type | Layout on top of the pattern |
|---|---|
| **Mistake log** (`revision/mistake-log.md`) | The reference. Keep the table exactly as is (`\| Date \| Problem \| What went wrong \| Redo on day 3 \| Redo on day 7 \|`): routines append rows. Styling only above the table. |
| **Daily tasks** (`tasks/dayNN.md`) | Day / Week / slot / time badges, `- [ ]` checklists for acceptance criteria, "Done when" in `[!IMPORTANT]`, hints in `[!TIP]`, gotchas in `[!WARNING]`, carried backlog as a table with status emoji. |
| **SQL learn lessons** (`sql/learn/lessonNN.md`) | Lesson / time / schema badges, the `⏱ N minutes · schema · status:` line inside a `[!NOTE]`, emoji `##` headings (🎯 learn, 💡 concept, 🧰 setup, 🧪 worked example, 📝 exercises with `### 🔹 Exercise N`, 🔎 check, 🏁 done when), "Done when" in `[!IMPORTANT]`. |
| **Interview answers** | Grade badges at top, verbatim answer in a `diff` block with `-` lines, grade in `[!WARNING]` (<7) or `[!NOTE]`, model answer in `[!TIP]`. |
| **Revision sheets** (`prerequisites.md`, `spring-boot-revision-sheet.md`) | Key points in `[!IMPORTANT]`, examples in `` ```java ``, a `[!NOTE]` legend for status icons. The workbook uses emoji `##` headings with the section number (`## 🧯 5. Validation and error handling`), then `### 📖 Concept notes`, `### 💡 Concept example`, `### ❓ Questions` (each followed by `> ✍️ My answer:`), `### ✅ Section check`, and `[⬆ Back to contents](#-contents)`. |
| **READMEs / structure docs / journals** | Emoji title, badges for stack facts, `[!NOTE]` for what the folder is, tables for file lists. |

## 🔗 Anchors
- GitHub drops the emoji and keeps the leading hyphen: `## 🧯 5. Validation` is `#-5-validation`. Prefer emoji without a variation selector (e.g. 🧯, not 🛡️) in headings that are linked to.
- If you change a heading, update every `](#...)` link to it, in the same file and in other files.

## 🧪 Mermaid rules
- Use `flowchart LR/TB` or `sequenceDiagram`; keep node labels plain (avoid `@`, `()`, `{}` unquoted; wrap in `"..."` if needed).
- Keep a `` ```text `` fallback in `<details>` for complex flows.
