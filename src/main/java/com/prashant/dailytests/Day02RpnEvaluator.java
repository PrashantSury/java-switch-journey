package com.prashant.dailytests;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 02 fix-the-buggy-code round: evaluate an expression in Reverse Polish Notation.
 * This class has bugs. Run Day02RpnEvaluatorTest, read the failing tests,
 * then make the smallest fixes until every test passes. Don't rewrite it.
 *
 * Spec:
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
public class Day02RpnEvaluator {

    public static int evaluate(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("tokens must not be null or empty");
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token == null) {
                throw new IllegalArgumentException("null token");
            }
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("not enough operands for " + token);
                }
                int b = stack.pop();
                int a = stack.pop();
                stack.push(apply(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("no result");
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {

       if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
           return true;
       }
        return false;
    }

    private static int apply(int a, int b, String op) {
        switch (op) {
            case "+":
                return Math.addExact(a, b);
            case "-":
                return Math.subtractExact(a, b);
            case "*":
                return Math.multiplyExact(a,  b);
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("division by zero");
                }
                if (a == Integer.MIN_VALUE && b == -1) {
                    throw new ArithmeticException("overflow");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("unknown operator: " + op);
        }
    }
}