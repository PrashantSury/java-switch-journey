# 📈 Progress Log

![Plan](https://img.shields.io/badge/plan-12%20weeks-blue) ![Started](https://img.shields.io/badge/started-23%20Oct%202026-informational) ![Current](https://img.shields.io/badge/current-W1-yellow)

> [!NOTE]
> 12-week plan to switch back to a Java backend role (started 23 Oct 2026).

## 🗂️ Layout (Maven project, Java 17, JUnit 5)
- 🧩 `src/main/java/com/prashant/dsa/<topic>/` : DSA solutions, tests in `src/test/java/...`
- 🐞 `src/main/java/com/prashant/dailytests/` : fix-the-buggy-code rounds, tests in `src/test/java/...`
- 🗄️ `sql/` : SQL queries, one file per day
- 🌱 `spring-boot/` : Spring Boot and microservices notes
- 🔁 `revision/` : mistake log and weekly revision notes

> [!TIP]
> Run all tests with `mvn test`.

```bash
mvn test
```

## 📝 Log
| Date | Week/Day | Done | Notes |
|------|----------|------|-------|
| 23 Oct 2026 | W1 D1 | Valid Parentheses (understood); Min Stack done, 10/10 tests passing | Two-stack approach, O(1) ops. Next: space-optimized version (push to mins only when x <= min) |
