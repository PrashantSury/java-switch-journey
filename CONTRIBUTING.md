# 🧾 Rules (short)

**Naming (new files only; old files keep their names)**
- DSA problem: `dsa/<pattern>/<Problem>.java` + `<Problem>Test.java`
- Buggy round: `dailytests/BuggyNN<Problem>.java` (next is `Buggy07`)
- Cold redo: `dailytests/redo/<Problem>RedoMmmDD.java` (date the stub is handed out, e.g. `CarFleetRedoNov20`)
- Shared cases: `<Problem>Contract.java` (abstract, next to the original's test)

**Stubs**
- Hand out a stub → add its test class to `open-stubs.txt` (e.g. `**/dsa/arrayshashing/GroupAnagramsTest.java`).
- It passes → remove the line; it now guards the green suite.
- `mvn test` must stay green; `mvn test -Popen` shows the open work.

**Redo tests (never copy a test file)**
- Write a tiny subclass of `<Problem>Contract`, e.g.
  `class CarFleetRedoDec01Test extends CarFleetContract { protected Solver newSolver() { return new CarFleetRedoDec01()::carFleet; } }`
- Static-method problems (RPN, NextGreaterIndex, ValidParentheses): override the hook, e.g. `evaluate(tokens)`.
- Stateful problems (MinStack, Day01ArrayStack): copy the adapter from `MinStackTest` / `Day01ArrayStackTest`.
- First redo of a problem without a contract: turn `<Problem>Test` into `<Problem>Contract` (public abstract, one `protected abstract` hook), then subclass it twice. The test count must not change.

**PROGRESS.md (one page)**
- Edit the problem/round row in the DSA or Buggy table; keep Open now ≤ 3 and Weak spots ≤ 3.
- Daily score → one row in `📈 Scores (last 7 days)` (DSA · Buggy · Banking), `—` if unscored; drop the oldest row.
- Detailed score rows, log rows and weekly reviews → `archive/progress-YYYY-MM.md`; one History link line in PROGRESS.
- Rules: [PROGRAM.md](docs/PROGRAM.md#-how-progressmd-is-updated).

**Banking app**
- Tasks: [banking-app/TASKS.md](banking-app/TASKS.md); code and tests by Prashant, coach adds only empty stubs/TODOs.
- Tests are `*IT.java` (Testcontainers): `mvn -f banking-app/pom.xml verify`; root `mvn test` doesn't touch them.
- Endpoints: fill the method × outcomes grid first; check what Spring already handles.

**Day files** follow [docs/DAY-TEMPLATE.md](docs/DAY-TEMPLATE.md).

**Never:** rename old solution files, copy test files, force-push, or use `--no-verify`.

**Commands:** done suite `mvn test` · open `mvn test -Popen` · one class `mvn test -Dtest=X` · everything `mvn test -Dsurefire.openStubs.excludes=`
