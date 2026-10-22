package com.prashant.dsa.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    private final ValidParentheses solver = new ValidParentheses();

    @Test
    void balanced() {
        assertTrue(solver.isValid("()[]{}"));
        assertTrue(solver.isValid("{[()]}"));
    }

    @Test
    void unbalanced() {
        assertFalse(solver.isValid("(]"));
        assertFalse(solver.isValid("(("));
    }
}
