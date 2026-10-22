package com.prashant.dailytests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day00BuggyExampleTest {
    private final Day00BuggyExample ex = new Day00BuggyExample();

    @Test @DisplayName("normal: mixed positives")
    void positives() { assertEquals(9, ex.max(new int[]{3, 9, 2})); }

    @Test @DisplayName("edge: max is the first element")
    void maxAtStart() { assertEquals(10, ex.max(new int[]{10, 1, 2})); }

    @Test @DisplayName("edge: max is the last element")
    void maxAtEnd() { assertEquals(8, ex.max(new int[]{1, 2, 8})); }

    @Test @DisplayName("edge: all negative")
    void allNegative() { assertEquals(-2, ex.max(new int[]{-5, -2, -8})); }

    @Test @DisplayName("edge: single element")
    void single() { assertEquals(7, ex.max(new int[]{7})); }

    @Test @DisplayName("edge: duplicates")
    void duplicates() { assertEquals(4, ex.max(new int[]{4, 4, 4})); }

    @Test @DisplayName("edge: zero and negatives")
    void zero() { assertEquals(0, ex.max(new int[]{-3, 0, -1})); }

    @Test @DisplayName("edge: Integer.MIN_VALUE and MAX_VALUE")
    void extremes() {
        assertEquals(Integer.MIN_VALUE, ex.max(new int[]{Integer.MIN_VALUE}));
        assertEquals(Integer.MAX_VALUE, ex.max(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}));
    }

    @Test @DisplayName("edge: empty array throws")
    void empty() { assertThrows(IllegalArgumentException.class, () -> ex.max(new int[]{})); }

    @Test @DisplayName("edge: null throws")
    void nullInput() { assertThrows(IllegalArgumentException.class, () -> ex.max(null)); }
}
