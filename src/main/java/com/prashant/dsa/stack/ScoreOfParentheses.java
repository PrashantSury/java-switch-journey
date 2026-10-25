package com.prashant.dsa.stack;

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

    public int scoreOfParentheses(String s) {
        // TODO: implement
        return 0;
    }
}
