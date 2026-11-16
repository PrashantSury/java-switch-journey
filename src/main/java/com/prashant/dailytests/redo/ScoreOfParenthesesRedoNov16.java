package com.prashant.dailytests.redo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Cold redo of LeetCode 856, Score of Parentheses (gap +1, 21 days late; first redo ever).
 * Write it from memory, in 20-30 minutes, without opening dsa/stack/ScoreOfParentheses.
 * Run ScoreOfParenthesesRedoNov16Test until all tests pass.
 *
 * Before any code, write three comment lines here: the pattern, the time complexity
 * and the space complexity (one sentence each on where the cost comes from).
 *
 * Spec:
 *  - "()" scores 1; AB scores A + B; (A) scores 2 * A.
 *  - null -> IllegalArgumentException; "" -> 0.
 *  - Any character other than '(' or ')' -> IllegalArgumentException.
 *  - Unbalanced input (e.g. "(()", "())", ")(") -> IllegalArgumentException.
 *  - A score that does not fit in an int -> ArithmeticException.
 *  - Must handle 100_000 nesting levels without StackOverflowError (no recursion).
 *  - Examples: "()" -> 1, "(())" -> 2, "()()" -> 2, "(()(()))" -> 6.
 */
public class ScoreOfParenthesesRedoNov16 {

    //Pattern: stack where we update the score of parentheses
    // time: O(n)
    // space: O(n)
    public int scoreOfParentheses(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (s.isEmpty()) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // Base score for the current level

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                // Start a new nested group
                stack.push(0);

            } else if (ch == ')') {

                // No matching opening parenthesis
                if (stack.size() == 1) {
                    throw new IllegalArgumentException(
                            "Unbalanced parentheses"
                    );
                }

                int innerScore = stack.pop();

                // Empty pair () scores 1.
                // Otherwise, (A) scores 2 * score(A).
                int groupScore = (innerScore == 0)
                        ? 1
                        : Math.multiplyExact(innerScore, 2);

                // Add the completed group's score to its parent.
                int parentScore = stack.pop();
                stack.push(Math.addExact(parentScore, groupScore));

            } else {
                throw new IllegalArgumentException(
                        "Invalid character: " + ch
                );
            }
        }

        // Extra opening parentheses mean the input is unbalanced.
        if (stack.size() != 1) {
            throw new IllegalArgumentException(
                    "Unbalanced parentheses"
            );
        }

        return stack.pop();
    }
}
