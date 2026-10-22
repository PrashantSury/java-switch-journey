package com.prashant.dailytests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day00BuggyExampleTest {
    private final Day00BuggyExample ex = new Day00BuggyExample();

    @Test
    void positives() {
        assertEquals(9, ex.max(new int[]{3, 9, 2}));
    }

    @Test
    void allNegative() {
        assertEquals(-2, ex.max(new int[]{-5, -2, -8}));
    }

    @Test
    void single() {
        assertEquals(7, ex.max(new int[]{7}));
    }
}
