package com.prashant.dailytests.redo;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayDeque;
import java.util.Deque;

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

         Deque<Integer> stack = new ArrayDeque<>();

         for (String token : tokens)  {

             if (token == null) {
                 throw new IllegalArgumentException("null token");
             }
             if(isOperator(token)){
                 if (stack.size() < 2) {
                     throw new IllegalArgumentException("not enough operands for " + token);
                 }
                 int b =  stack.pop();
                 int a = stack.pop();
                 stack.push(apply(a,b,token));
             }
             stack.push(Integer.parseInt(token));
         }

         if (stack.pop() != 1) {
             throw new IllegalArgumentException("no result");
         }
        return  stack.pop();
    }

    private static boolean isOperator(String op) {
       return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") ;
    }
    public static int apply(int a, int b, String token) {
        switch (token) {
            case "+": return Math.addExact(a, b);
            case "-": return Math.subtractExact(a, b);
            case "*": return Math.multiplyExact(a, b);
            case "/":
                if(b == 0){
                    throw new ArithmeticException("Cannot divide by zero");
                }
                if (a == Integer.MIN_VALUE && b == -1) {
                    throw new ArithmeticException("overflow");
                }
                return a / b;
            default: throw new IllegalArgumentException("Operator is not listed");
        }
    }
}
