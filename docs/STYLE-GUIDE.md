# 🎨 Markdown style guide

![Applies to](https://img.shields.io/badge/applies%20to-all%20.md%20files-blue)

> [!IMPORTANT]
> Readable first. Add colour to guide the eye, never change content. Don't overdo it — at most a few alerts per section.

## 🧰 Toolbox
| Element | Use for | Example |
|---|---|---|
| `> [!NOTE]` (blue) | context, legends, background | base package, plan info |
| `> [!TIP]` (green) | how-to, revision hints, model answers | "Run `mvn test`" |
| `> [!IMPORTANT]` (purple) | key points, defaults, rules, done criteria | `required = true` |
| `> [!WARNING]` (orange) | gotchas, low grades, structure changes | "Valid on String does nothing" |
| `> [!CAUTION]` (red) | things that break code or lose work | "commit before git pull" |
| Emoji in headings | quick scanning | 🧠 🔀 🗺️ 🌐 🛡️ 🗄️ 🧪 ⚙️ 🎤 🔥 📌 |
| Status emoji | ✅ done/correct · ❌ wrong · ⚠️ gotcha · 📌 rule · 🔥 focus | |
| shields.io badges | Day/Week, grades, confidence | `https://img.shields.io/badge/Q1-5%2F10-orange` |
| `` ```diff `` | wrong (`-`) vs correct (`+`) | his answer vs correction |
| `` ```java `` / `` ```sql `` / `` ```bash `` | all code | always tag the language |
| `` ```mermaid `` | flows & layer diagrams | request flow |

## 🏅 Badge colours
- Grades: `red` < 5, `orange` 5–6, `yellowgreen` 7–8, `brightgreen` 9–10.
- Confidence 1–5: `red` 1, `orange` 2–3, `yellowgreen` 4, `brightgreen` 5.
- Day / Week / meta: `blue`; slot: `yellow`.

## 📄 Per file type
- **Daily tasks** (`tasks/`, `sql/`): emoji headings, Day/Week/slot badges, acceptance criteria as `- [ ]` checklists, "Done when" in `[!IMPORTANT]`, hints in `[!TIP]`.
- **Interview answers**: grade badges at top, verbatim answer in a `diff` block with `-` lines, grade in `[!WARNING]` (<7) or `[!NOTE]`, model answer in `[!TIP]`.
- **Mistake log**: keep the table exactly as is (`| Date | Problem | What went wrong | Redo on day 3 | Redo on day 7 |`) — routines append rows. Styling only above the table.
- **Revision sheets / workbook** (`spring-boot/spring-boot-revision-sheet.md`): keep the lighter, notes-first layout.
  - One badge row under the title (Spring Boot, Java, mode, sections). **No per-section badges** and **no emoji in the numbered `##` headings** (`## 5. Validation and error handling`), so the anchors stay plain (`#5-validation-and-error-handling`, `#contents`).
  - Under each `##` section, a status line `> 🔗 **P§n** · <status>`, then these `###` blocks in order: `### 📖 Concept notes` (key points in `[!IMPORTANT]`), `### 💡 Concept example` (`` ```java `` or `` ```mermaid ``), `### ❓ Questions` (`**5.1** ...` each followed by `> ✍️ My answer:`), `### ✅ Section check` (`- [ ] Revised (answered from memory)` + `Score: _/5`), then `[⬆ Back to contents](#contents)`.
  - Emoji live in the `###` labels and in the Contents / Map tables only as ⬜🟡🟠🔴🔵✅ status icons; don't add emoji to section titles.
  - Other sheets (`prerequisites.md`): key points in `[!IMPORTANT]`, examples in `` ```java ``.

## 🧪 Mermaid rules
- Use `flowchart LR/TB` or `sequenceDiagram`; keep node labels plain (avoid `@`, `()`, `{}` unquoted; wrap in `"..."` if needed).
- Keep a `` ```text `` fallback in `<details>` for complex flows.
