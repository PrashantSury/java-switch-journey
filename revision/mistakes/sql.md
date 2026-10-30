# 🗄️ SQL mistake log

![Spaced repetition](https://img.shields.io/badge/redo-day%203%20%2B%20day%207-purple) ![Section](https://img.shields.io/badge/section-SQL-blue)

> [!IMPORTANT]
> Conceptual mistakes from `sql/` exercises and the `sql/learn/` lessons. Redo each item after 3 days and again after 7 days. Only conceptual mistakes go here; cosmetic slips (typos, stale comments, missing braces, unused imports, stray `main()`) are fixed directly by Lumi and not logged.

> [!NOTE]
> **Legend:** 🗄️ SQL · 🎓 learn track · 🔁 redo · mark a redo ✅ when done cleanly, ❌ if you got stuck again. Other sections: [index](../mistake-log.md).

| Date | Problem | What went wrong | Redo on day 3 | Redo on day 7 |
|------|---------|-----------------|---------------|---------------|
| 30 Oct | SQL learn lesson 02, ex 1 | Checker 5/5, but the task says "Sorted by customer_id" and the query had no `ORDER BY`; it only passed because rows came back in insert order. Without `ORDER BY` the order is never guaranteed. Fixed in f2e5a58 (ex 1 now has `ORDER BY`, lesson 02 ✅). | 2 Nov | 6 Nov |
