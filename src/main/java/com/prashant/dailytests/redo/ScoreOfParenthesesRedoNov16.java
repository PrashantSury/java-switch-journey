package com.prashant.dailytests.redo;

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

    public int scoreOfParentheses(String s) {
        throw new UnsupportedOperationException("TODO");
    }
}
