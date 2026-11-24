package com.prashant.dsa.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Runs the shared ValidParenthesesContract cases (18) against {@code ValidParentheses},
 * plus the two original starter tests, kept so no test is lost (their inputs are also in the 18).
 */
class ValidParenthesesTest extends ValidParenthesesContract {
    private final ValidParentheses solver = new ValidParentheses();

    @Override
    protected boolean isValid(String s) { return solver.isValid(s); }

    @Test @DisplayName("starter: balanced inputs")
    void balanced() {
        assertTrue(solver.isValid("()[]{}"));
        assertTrue(solver.isValid("{[()]}"));
    }

    @Test @DisplayName("starter: unbalanced inputs")
    void unbalanced() {
        assertFalse(solver.isValid("(]"));
        assertFalse(solver.isValid("(("));
    }
}
