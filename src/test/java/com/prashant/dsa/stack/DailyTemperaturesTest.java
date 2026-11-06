package com.prashant.dsa.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {
    private DailyTemperatures sol;

    @BeforeEach
    void setUp() { sol = new DailyTemperatures(); }

    private void check(int[] expected, int[] temperatures) {
        int[] inputCopy = Arrays.copyOf(temperatures, temperatures.length);
        int[] actual = sol.dailyTemperatures(temperatures);
        assertArrayEquals(expected, actual,
                () -> "temperatures=" + Arrays.toString(temperatures));
        assertArrayEquals(inputCopy, temperatures, "input must not be mutated");
        assertNotSame(temperatures, actual, "must return a new array");
    }

    // ---------- LeetCode examples ----------
    @Test @DisplayName("normal: LeetCode example 1")
    void example1() {
        check(new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    @Test @DisplayName("normal: LeetCode example 2, strictly decreasing then warmer last")
    void example2() {
        check(new int[]{1, 1, 1, 0}, new int[]{30, 40, 50, 60});
    }

    @Test @DisplayName("normal: LeetCode example 3, strictly decreasing")
    void example3() {
        check(new int[]{1, 1, 0}, new int[]{30, 60, 90});
    }

    // ---------- empty / single ----------
    @Test @DisplayName("empty: empty input returns empty answer")
    void empty() { check(new int[]{}, new int[]{}); }

    @Test @DisplayName("single: one day never has a warmer future day")
    void single() { check(new int[]{0}, new int[]{42}); }

    @Test @DisplayName("two: second warmer → [1, 0]")
    void twoWarmer() { check(new int[]{1, 0}, new int[]{10, 20}); }

    @Test @DisplayName("two: second colder or equal → [0, 0]")
    void twoColder() {
        check(new int[]{0, 0}, new int[]{20, 10});
        check(new int[]{0, 0}, new int[]{7, 7});
    }

    // ---------- shapes ----------
    @Test @DisplayName("increasing: every day waits exactly 1 except the last")
    void increasing() {
        check(new int[]{1, 1, 1, 1, 0}, new int[]{1, 2, 3, 4, 5});
    }

    @Test @DisplayName("decreasing: every day waits 0")
    void decreasing() {
        check(new int[]{0, 0, 0, 0, 0}, new int[]{5, 4, 3, 2, 1});
    }

    @Test @DisplayName("all equal: every day waits 0")
    void allEqual() {
        check(new int[]{0, 0, 0, 0}, new int[]{55, 55, 55, 55});
    }

    @Test @DisplayName("valley then peak: early days jump over the valley")
    void valleyThenPeak() {
        // 70, 60, 50, 80 → day0 waits 3, day1 waits 2, day2 waits 1, day3 waits 0
        check(new int[]{3, 2, 1, 0}, new int[]{70, 60, 50, 80});
    }

    @Test @DisplayName("peak in the middle: sides wait for it or never")
    void middlePeak() {
        check(new int[]{1, 0, 0}, new int[]{40, 90, 50});
    }

    @Test @DisplayName("duplicates then warmer: equal does not count as warmer")
    void equalNotWarmer() {
        check(new int[]{2, 1, 0}, new int[]{50, 50, 60});
    }

    @Test @DisplayName("boundary: 30 and 100 (LeetCode range ends)")
    void rangeEnds() {
        check(new int[]{1, 0}, new int[]{30, 100});
        check(new int[]{0, 0}, new int[]{100, 30});
    }

    // ---------- failure ----------
    @Test @DisplayName("failure: null input throws IllegalArgumentException")
    void nullInput() {
        assertThrows(IllegalArgumentException.class, () -> sol.dailyTemperatures(null));
    }

    // ---------- large / performance ----------
    @Test @DisplayName("large: 100_000 strictly decreasing must finish in O(n)")
    void largeDecreasing() {
        int n = 100_000;
        int[] temps = new int[n];
        for (int i = 0; i < n; i++) temps[i] = n - i; // n, n-1, ..., 1
        int[] expected = new int[n]; // all zeros
        assertTimeoutPreemptively(Duration.ofMillis(800), () -> check(expected, temps));
    }

    @Test @DisplayName("large: 100_000 strictly increasing must finish in O(n)")
    void largeIncreasing() {
        int n = 100_000;
        int[] temps = new int[n];
        for (int i = 0; i < n; i++) temps[i] = i + 1;
        int[] expected = new int[n];
        Arrays.fill(expected, 1);
        expected[n - 1] = 0;
        assertTimeoutPreemptively(Duration.ofMillis(800), () -> check(expected, temps));
    }

    @Test @DisplayName("large: 100_000 equal temperatures must finish in O(n)")
    void largeEqual() {
        int n = 100_000;
        int[] temps = new int[n];
        Arrays.fill(temps, 50);
        int[] expected = new int[n];
        assertTimeoutPreemptively(Duration.ofMillis(800), () -> check(expected, temps));
    }
}
