package com.prashant.dailytests.redo;

/**
 * Day-7 cold redo of the Day 02 buggy round: write this from memory, without
 * opening Day02RpnEvaluator or Day02RpnEvaluatorRedo. Run Day02RpnEvaluatorRedo7Test until all tests pass.
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
public class Day02RpnEvaluatorRedo7 {

    public static int evaluate(String[] tokens) {
        // TODO(Day 09 redo): write it from memory, no peeking
        throw new UnsupportedOperationException("not written yet");
    }
}
