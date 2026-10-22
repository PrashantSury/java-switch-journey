package com.prashant.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Starter example: LeetCode 20 - Valid Parentheses.
 * Put each new DSA problem in its topic package, e.g. dsa/binarysearch, dsa/linkedlist.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
