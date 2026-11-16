package com.prashant.dsa.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {
    private GenerateParentheses sol;

    @BeforeEach
    void setUp() { sol = new GenerateParentheses(); }

    private static List<String> sorted(List<String> in) {
        List<String> copy = new ArrayList<>(in);
        copy.sort(null);
        return copy;
    }

    private static boolean balanced(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0) return false;
        }
        return open == 0;
    }

    /** Checks length, balance, uniqueness and the Catalan count in one go. */
    private void checkAll(int n, int expectedCount) {
        List<String> result = sol.generateParenthesis(n);
        assertEquals(expectedCount, result.size(), () -> "count for n=" + n);
        assertEquals(expectedCount, new HashSet<>(result).size(), () -> "duplicates for n=" + n);
        for (String s : result) {
            assertEquals(2 * n, s.length(), () -> "length of " + s);
            assertTrue(balanced(s), () -> "not balanced: " + s);
        }
    }

    @Test @DisplayName("normal: n = 1 gives only \"()\"")
    void n1() { assertEquals(List.of("()"), sol.generateParenthesis(1)); }

    @Test @DisplayName("normal: n = 2 gives \"(())\" and \"()()\"")
    void n2() { assertEquals(List.of("(())", "()()"), sorted(sol.generateParenthesis(2))); }

    @Test @DisplayName("normal: LeetCode example n = 3, five strings")
    void n3() {
        assertEquals(List.of("((()))", "(()())", "(())()", "()(())", "()()()"),
                sorted(sol.generateParenthesis(3)));
    }

    @Test @DisplayName("normal: n = 4 gives the 14 balanced strings, no duplicates")
    void n4() { checkAll(4, 14); }

    @Test @DisplayName("normal: n = 5 gives 42 strings")
    void n5() { checkAll(5, 42); }

    @Test @DisplayName("normal: n = 6 gives 132 strings")
    void n6() { checkAll(6, 132); }

    @Test @DisplayName("normal: n = 8 (LeetCode maximum) gives 1430 strings")
    void n8() { checkAll(8, 1430); }

    @Test @DisplayName("normal: n = 4 contains the fully nested and the fully flat strings")
    void n4Extremes() {
        List<String> r = sol.generateParenthesis(4);
        assertTrue(r.contains("(((())))"));
        assertTrue(r.contains("()()()()"));
    }

    @Test @DisplayName("normal: n = 3 never contains a string that starts with \")\"")
    void neverStartsWithClose() {
        for (String s : sol.generateParenthesis(3)) {
            assertEquals('(', s.charAt(0), () -> s);
        }
    }

    @Test @DisplayName("edge: n = 2 must not contain the unbalanced \")(()\" or \"))((\"")
    void noUnbalanced() {
        List<String> r = sol.generateParenthesis(2);
        assertFalse(r.contains(")(()"));
        assertFalse(r.contains("))(("));
    }

    @Test @DisplayName("edge: a second call returns a fresh list with the same content")
    void freshEachCall() {
        List<String> first = sol.generateParenthesis(3);
        List<String> second = sol.generateParenthesis(3);
        assertNotSame(first, second);
        assertEquals(sorted(first), sorted(second));
        assertEquals(5, second.size());
    }

    @Test @DisplayName("edge: the same instance handles different n in turn")
    void reuseInstance() {
        assertEquals(5, sol.generateParenthesis(3).size());
        assertEquals(1, sol.generateParenthesis(1).size());
        assertEquals(14, sol.generateParenthesis(4).size());
    }

    @Test @DisplayName("failure: n = 0 throws IllegalArgumentException")
    void zero() { assertThrows(IllegalArgumentException.class, () -> sol.generateParenthesis(0)); }

    @Test @DisplayName("failure: negative n throws IllegalArgumentException")
    void negative() { assertThrows(IllegalArgumentException.class, () -> sol.generateParenthesis(-3)); }

    @Test @DisplayName("failure: Integer.MIN_VALUE throws IllegalArgumentException")
    void minValue() { assertThrows(IllegalArgumentException.class, () -> sol.generateParenthesis(Integer.MIN_VALUE)); }

    @Test @DisplayName("performance: n = 10 gives 16796 strings quickly")
    void n10() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> checkAll(10, 16_796));
    }

    @Test @DisplayName("performance: n = 12 gives 208012 strings, pruning required")
    void n12() {
        assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
            List<String> r = sol.generateParenthesis(12);
            assertEquals(208_012, r.size());
        });
    }
}
