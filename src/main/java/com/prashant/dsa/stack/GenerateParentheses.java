package com.prashant.dsa.stack;

import java.util.List;
import java.util.ArrayList;

/**
 * Generate Parentheses (LeetCode 22, NeetCode 150, Stack).
 * Full spec, approach table and knowledge check: tasks/day25.md, "Generate Parentheses".
 *
 * <h2>Why this problem matters</h2>
 * <p>Interviewers use it to see whether you can turn a rule ("every ')' needs an earlier
 * '(' to match") into two counters that prune bad branches <b>before</b> they are built,
 * instead of generating everything and filtering. The recursion stack <i>is</i> the
 * stack here: each call is one open choice, and the follow-up is always "how many strings
 * come out, and why is the cost not 2^(2n)?"</p>
 *
 * <h2>The story</h2>
 * <p>A payments gateway logs nested "scopes" as bracket strings. For a given {@code n}
 * (the number of pairs), list every well-formed string of exactly {@code n} pairs.</p>
 *
 * <h2>Worked example</h2>
 * <pre>
 * n = 1  ->  ["()"]
 * n = 2  ->  ["(())", "()()"]
 * n = 3  ->  ["((()))", "(()())", "(())()", "()(())", "()()()"]   (any order)
 * </pre>
 *
 * <h2>Rules the suite enforces</h2>
 * <ul>
 *   <li>{@code n < 1} throws {@link IllegalArgumentException}.</li>
 *   <li>Every string has length {@code 2n}, is balanced, and appears exactly once.</li>
 *   <li>The result holds all of them (the count for n = 1..8 is 1, 2, 5, 14, 42, 132, 429, 1430).</li>
 *   <li>Order does not matter. The suite sorts before comparing.</li>
 *   <li>n = 12 (208 012 strings) must finish within a few seconds: no "build all 2^(2n) strings then filter".</li>
 * </ul>
 *
 * <p>Before any Java: 3-5 lines of plain-English pseudocode and a brute-force comment,
 * then three comment lines for pattern, time and space, each with one sentence saying
 * where the cost comes from.</p>
 */
public class GenerateParentheses {

    // Pseudocode:
    // 1. Start with an empty string and two counters: open = 0, close = 0.
    // 2. If open < n, we may add '(' and continue.
    // 3. If close < open, we may add ')' and continue.
    // 4. When the string has length 2n, save it.
    // Brute force: build all 2^(2n) strings of '(' and ')', then keep only the balanced ones.
    //
    // Pattern: backtracking with two counters; the recursion call stack is the stack.
    // Time:    O(C(n) * n), because only valid prefixes are expanded, and each of the
    //          C(n) results costs O(n) to copy into the list.
    // Space:   O(n), because recursion depth and the builder never exceed 2n (output not counted).

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be >= 1");
        }
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, int open, int close,
                           StringBuilder current, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        if (open < n) {                          // still have '(' left to place
            current.append('(');
            backtrack(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);   // undo
        }
        if (close < open) {                      // a ')' has an unmatched '(' to close
            current.append(')');
            backtrack(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);   // undo
        }
    }
}