package com.prashant.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 03 DSA (Sunday revision, Stack): Score of Parentheses (LeetCode 856), with extra rules.
 *
 * Revises this week's stack work (Valid Parentheses, Min Stack, Asteroid Collision)
 * and two mistake-log lessons: trace tiny/empty inputs, and guard every arithmetic op
 * against overflow.
 *
 * Score a balanced parentheses string:
 *  - "()" has score 1
 *  - AB has score A + B, where A and B are balanced strings
 *  - (A) has score 2 * A, where A is a balanced string
 *
 * Rules for this repo:
 *  - If s is null, throw IllegalArgumentException.
 *  - If s is empty, return 0.
 *  - If s contains any character other than '(' or ')', throw IllegalArgumentException.
 *  - If s is not balanced (e.g. "(()", "())", ")("), throw IllegalArgumentException.
 *  - If the score does not fit in an int, throw ArithmeticException.
 *    (Hint: 31 nested pairs score 2^30, which fits; 32 nested pairs would be 2^31, which doesn't.)
 *  - Must work for very deep nesting (100_000 levels) without StackOverflowError.
 *
 * Constraints: 0 <= s.length() <= 200_000. Aim for O(n) time.
 *
 * Examples:
 *  "()"        -> 1
 *  "(())"      -> 2
 *  "()()"      -> 2
 *  "(()(()))"  -> 6
 *  "(()"       -> IllegalArgumentException
 */
public class ScoreOfParentheses {


    public static int scoreOfParentheses(String s) {

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
