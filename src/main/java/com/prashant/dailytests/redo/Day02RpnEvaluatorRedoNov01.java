package com.prashant.dailytests.redo;

/**
 * Cold redo of the Day 02 buggy round (gap +1 after the 31 Oct reset). Write it from
 * memory, in 20-30 minutes, without opening Day02RpnEvaluator, Day02RpnEvaluatorRedo
 * or Day02RpnEvaluatorRedo7. Run Day02RpnEvaluatorRedoNov01Test until all tests pass.
 *
 * Before any code, write three comment lines here: the pattern, the time complexity
 * and the space complexity.
 *
 * Spec (same as Day 02):
 *  - evaluate(tokens): each token is either an operator ("+", "-", "*", "/")
 *    or a whole int operand such as "42", "0" or "-7" (negative numbers are operands).
 *  - For an operator, pop b (top) then a, and push (a op b).
 *  - Division truncates toward zero, like Java int division.
 *  - Any result that does not fit in an int (including Integer.MIN_VALUE / -1)
 *    throws ArithmeticException. Division by zero throws ArithmeticException.
 *  - null or empty tokens, a null token, an operand that is not a valid int,
 *    too few operands for an operator, or more than one value left at the end
 *    throws IllegalArgumentException.
 *  - The input array must not be modified.
 */
public class Day02RpnEvaluatorRedoNov01 {

    // Pattern:
    // Time:
    // Space:

    public static int evaluate(String[] tokens) {
        // TODO: write from memory
        throw new UnsupportedOperationException("TODO");
    }
}
