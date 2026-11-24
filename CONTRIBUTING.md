# 🧾 Conventions (for Prashant and for Lumi's routines)

These rules apply **from 24 Nov 2026 onwards**. Old files keep their names so the links in the records never break.

## 📛 Naming
| What | Name | Where | Example |
|---|---|---|---|
| New DSA problem | `<Problem>` (NeetCode name, PascalCase) | `src/main/java/com/prashant/dsa/<pattern>/` + `src/test/java/.../dsa/<pattern>/<Problem>Test.java` | `dsa/arrayshashing/GroupAnagrams.java` |
| New buggy round | `BuggyNN<Problem>` (NN continues the old `DayNN` numbering, so the next one is `Buggy07`) | `src/main/java/com/prashant/dailytests/` | `Buggy07TopKFrequent.java` |
| Cold redo | `<Problem>RedoMmmDD`, the date the blank stub is handed out (`Mmm` = Jan, Feb, ... Dec) | `src/main/java/com/prashant/dailytests/redo/` | `CarFleetRedoNov20.java` |
| Shared test cases | `<Problem>Contract` (abstract, never run on its own) | next to the original's test | `dsa/stack/CarFleetContract.java` |

Old names stay as they are: `Day00`-`Day06` buggy rounds, `...Redo` / `...Redo7` redo files.

## ➕ Handing out a new stub (problem, buggy round or redo)
1. Add the stub in `src/main` and its test class in `src/test`.
2. Add the test class to [`open-stubs.txt`](open-stubs.txt), one line, e.g. `**/dsa/arrayshashing/GroupAnagramsTest.java`.
3. `mvn test` must stay green (the new class is skipped); `mvn test -Popen` shows it red.

## ✅ When the stub passes
1. Grade it with `mvn test -Dtest=<Class>Test` (all green).
2. Remove its line from `open-stubs.txt`. From now on the default suite guards it.
3. Update its row in [PROBLEMS.md](PROBLEMS.md) and the schedule in [revision/redo-schedule.md](revision/redo-schedule.md).

## 🔁 Registering a cold redo's tests (no copying!)
Each problem's cases live **once** in `<Problem>Contract`. A redo test is a tiny subclass that plugs in the new class:

```java
package com.prashant.dailytests.redo;

import com.prashant.dsa.stack.CarFleetContract;

/** Runs the shared CarFleetContract cases against {@code CarFleetRedoDec01}. */
class CarFleetRedoDec01Test extends CarFleetContract {
    @Override
    protected Solver newSolver() { return new CarFleetRedoDec01()::carFleet; }
}
```

- **Instance method** (`sol.method(...)` style): override `newSolver()` and return `new <Redo>()::<method>` (or `<Redo>::<method>` if the method is static).
- **Static method** (RPN, NextGreaterIndex, ValidParentheses): override the hook, e.g. `protected int evaluate(String[] tokens) { return Day02RpnEvaluatorRedoDec01.evaluate(tokens); }`.
- **Stateful design** (MinStack, Day01ArrayStack): override `newStack(...)` and return an adapter; copy the adapter from `MinStackTest` / `Day01ArrayStackTest`.
- **Problem without a contract yet** (first redo of e.g. TwoSum): turn `<Problem>Test` into `<Problem>Contract` (make it `public abstract`, replace direct calls with one `protected abstract` hook), then make `<Problem>Test` and the redo test subclasses. Check that the test count stays the same before and after.
- Then add the redo test to `open-stubs.txt` like any other stub.

## 🧪 Commands
| Goal | Command |
|---|---|
| Done suite (must be green) | `mvn test` |
| Only open stubs | `mvn test -Popen` |
| Grade one class | `mvn test -Dtest=CarFleetRedoNov20Test` |
| Everything, open stubs included | `mvn test -Dsurefire.openStubs.excludes=` |

## 🚫 Never
- Rename or move old solution files (links in the records point at them).
- Copy a test file for a redo (use the contract).
- Force-push, or commit with `--no-verify`.
