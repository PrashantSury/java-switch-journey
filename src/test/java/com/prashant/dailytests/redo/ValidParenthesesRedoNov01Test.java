package com.prashant.dailytests.redo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesRedoNov01Test {

    private static boolean valid(String s) {
        return ValidParenthesesRedoNov01.isValid(s);
    }

    // ---------- normal cases ----------

    @Test @DisplayName("normal: one pair of each type side by side is valid")
    void sideBySide() {
        assertTrue(valid("()[]{}"));
    }

    @Test @DisplayName("normal: fully nested mixed brackets are valid")
    void nested() {
        assertTrue(valid("{[()]}"));
    }

    @Test @DisplayName("normal: nested and sequential mix is valid")
    void nestedAndSequential() {
        assertTrue(valid("([]{})[({})]"));
    }

    @Test @DisplayName("normal: a single pair of round brackets is valid")
    void singlePair() {
        assertTrue(valid("()"));
    }

    @Test @DisplayName("normal: wrong closing type is invalid")
    void wrongType() {
        assertFalse(valid("(]"));
    }

    @Test @DisplayName("normal: interleaved pairs are invalid")
    void interleaved() {
        assertFalse(valid("([)]"));
    }

    // ---------- edge cases ----------

    @Test @DisplayName("edge: empty string is valid")
    void empty() {
        assertTrue(valid(""));
    }

    @Test @DisplayName("edge: a single opening bracket is invalid")
    void singleOpen() {
        assertFalse(valid("("));
    }

    @Test @DisplayName("edge: a single closing bracket is invalid (closing on an empty stack)")
    void singleClose() {
        assertFalse(valid("}"));
    }

    @Test @DisplayName("edge: unclosed openers left at the end are invalid")
    void leftovers() {
        assertFalse(valid("(("));
        assertFalse(valid("{[]"));
    }

    @Test @DisplayName("edge: a closing bracket before any opener, even if counts match, is invalid")
    void closeFirst() {
        assertFalse(valid(")("));
        assertFalse(valid("][]["));
    }

    @Test @DisplayName("edge: balanced counts but wrong order deep inside is invalid")
    void deepMismatch() {
        assertFalse(valid("{[(])}"));
    }

    @Test @DisplayName("edge: valid prefix followed by an extra closer is invalid")
    void extraCloser() {
        assertFalse(valid("()[]{}}"));
    }

    @Test @DisplayName("edge: 10 000 levels of nesting are valid (no recursion overflow)")
    void deepNesting() {
        String s = "(".repeat(10_000) + ")".repeat(10_000);
        assertTrue(valid(s));
    }

    // ---------- failure cases ----------

    @Test @DisplayName("failure: a non-bracket character makes the string invalid")
    void letters() {
        assertFalse(valid("(a)"));
        assertFalse(valid("x"));
    }

    @Test @DisplayName("failure: a space inside otherwise valid brackets is invalid")
    void space() {
        assertFalse(valid("( )"));
    }

    @Test @DisplayName("failure: null input throws IllegalArgumentException")
    void nullInput() {
        assertThrows(IllegalArgumentException.class, () -> valid(null));
    }

    @Test @DisplayName("performance: 100 000 characters finish in under 1 second")
    void performance() {
        String s = "([]{})".repeat(16_666) + "()";
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> assertTrue(valid(s)));
    }
}
