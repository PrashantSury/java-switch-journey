# Day file template (`tasks/dayNN.md`)

Every day file uses exactly this layout. This repo is **DSA + buggy rounds only** (🧩 DSA · 🐞 Buggy · 🔁 Redos); Spring work is planned in spring-boot-labs, not here. Rules:
- Outside `<details>`: only the header, tables, short bullets and numbered questions. **No paragraphs.**
- Each item: 3-6 bullets (goal, file, run, done when, hint rule). Spec, teaching, examples, hints and stubs go in a `📖` `<details>` block; solutions in a separate `🔒` block.
- Keep the section order and headings below so routines and links can find them. Leave a section in with "none" rather than deleting it.
- Routines fill 🌙 Evening and 🌒 End of day as tables (they don't add new sections). Coach-only notes go in the last `<details>`.

````markdown
# Day NN · Ddd DD Mmm · ~MMM min (+15 buffer)

**Focus:** <one line> · **Done when:** <one line> · Run `git pull` first · Stuck 15 min → ask Lumi.

## ✅ Today

| # | Track | Item | File | Tests | Time | Status |
|---|---|---|---|---|---|---|
| 1 | 🧩 | <new problem> | `<path>` | 0/22 | 40 | ⬜ |
| 2 | 🐞 | <buggy round or carry-over> | `<path>` | 16/20 | 15 | 🔴 |
| 3 | 🔁 | <redo> | `<path>` | 0/28 | 25 | ⬜ |

> Short on time: <the 15-minute minimum, one line>

## 🔎 Since yesterday

| Item | Result | Status |
|---|---|---|
| <push / answer> | <tests, verdict> | ✅ / 🔴 |

<details><summary>📖 Review details</summary>

(check table, cosmetic fixes, longer feedback)

</details>

## 1. 🧩 <Problem> (~40 min)

- **Goal:** <one line>
- **File:** `<path>`
- **Run:** `mvn test -Dtest=<Class>Test`
- **Done when:** <tests / grade>
- **Hint rule:** stuck 15 min → ask Lumi.
- **Answer:** questions Q1-Qn below.

<details><summary>📖 Spec and teaching</summary>

(why it matters, examples, warm-ups, constraints, pattern, brute force, hint questions, stub notes, follow-ups)

</details>

<details><summary>🔒 Open only after your attempt</summary>

(optimised algorithm, dry run, complexity, answers to the checks)

</details>

## 2. 🐞 <Buggy round> (~15 min)

(same 3-6 bullets + details blocks)

## ❓ Questions to answer in chat

| # | For | Question (short; letters only for MCQs) |
|---|---|---|
| Q1 | 🧩 | ... |

<details><summary>📖 Full question text and options</summary>

(numbered, matching Q1-Qn)

</details>

## 🔁 Redos (cold, cap 2)

| # | Redo | Stub | Run | When | Done when | Status |
|---|---|---|---|---|---|---|
| 1 | <Problem> (+gap) | `<path>` | `mvn test -Dtest=<Redo>Test` | morning | 28/28, cold | ⬜ |

## 📌 Pending (after today's items)

- <item> · <track> · <status>

## 🌙 Evening (filled by the evening review)

| Track | Score /10 | Evidence |
|---|---|---|
| 🧩 DSA | | |
| 🐞 Buggy | | |

| Tonight (in order) | Tomorrow |
|---|---|
| 1. ... | ... |

## 🌒 End of day (filled by the 10 PM check)

| Time (IST) | What changed | Result |
|---|---|---|
| | | |

<details><summary>🧹 Coach notes (state, housekeeping)</summary>

(fresh-clone state, suite counts, cosmetic fixes made, queue shifts)

</details>
````
