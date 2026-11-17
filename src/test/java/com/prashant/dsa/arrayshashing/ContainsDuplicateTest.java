package com.prashant.dsa.arrayshashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {
    private ContainsDuplicate sol;

    @BeforeEach
    void setUp() { sol = new ContainsDuplicate(); }

    // ---------- normal ----------

    @Test @DisplayName("normal: LeetCode example 1, [1, 2, 3, 1] has a duplicate")
    void example1() { assertTrue(sol.containsDuplicate(new int[]{1, 2, 3, 1})); }

    @Test @DisplayName("normal: LeetCode example 2, [1, 2, 3, 4] has none")
    void example2() { assertFalse(sol.containsDuplicate(new int[]{1, 2, 3, 4})); }

    @Test @DisplayName("normal: LeetCode example 3, many repeats")
    void example3() { assertTrue(sol.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); }

    @Test @DisplayName("normal: duplicate pair is adjacent")
    void adjacent() { assertTrue(sol.containsDuplicate(new int[]{7, 9, 9, 4})); }

    @Test @DisplayName("normal: duplicate pair is at the two far ends")
    void farEnds() { assertTrue(sol.containsDuplicate(new int[]{42, 1, 2, 3, 4, 5, 42})); }

    @Test @DisplayName("normal: negative values, duplicate -3")
    void negatives() { assertTrue(sol.containsDuplicate(new int[]{-1, -3, 5, -3})); }

    @Test @DisplayName("normal: -5 and 5 are different values, no duplicate")
    void signMatters() { assertFalse(sol.containsDuplicate(new int[]{-5, 5, 0})); }

    // ---------- edge ----------

    @Test @DisplayName("edge: empty array has no duplicate")
    void empty() { assertFalse(sol.containsDuplicate(new int[0])); }

    @Test @DisplayName("edge: a single element has no duplicate")
    void single() { assertFalse(sol.containsDuplicate(new int[]{10})); }

    @Test @DisplayName("edge: two equal elements")
    void twoEqual() { assertTrue(sol.containsDuplicate(new int[]{0, 0})); }

    @Test @DisplayName("edge: Integer.MIN_VALUE and Integer.MAX_VALUE once each, no duplicate")
    void extremesOnce() {
        assertFalse(sol.containsDuplicate(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}));
    }

    @Test @DisplayName("edge: Integer.MIN_VALUE twice is a duplicate")
    void minTwice() {
        assertTrue(sol.containsDuplicate(new int[]{Integer.MIN_VALUE, 3, Integer.MIN_VALUE}));
    }

    @Test @DisplayName("edge: values far apart that collide in a small table (0, 16, 32, 48) are still distinct")
    void sameBucketDistinct() {
        assertFalse(sol.containsDuplicate(new int[]{0, 16, 32, 48, 64, 1 << 20, 1 << 30}));
    }

    @Test @DisplayName("edge: the caller's array is not modified")
    void inputNotModified() {
        int[] in = {5, 3, 9, 1, 3};
        int[] copy = in.clone();
        assertTrue(sol.containsDuplicate(in));
        assertArrayEquals(copy, in, "the input array must not be changed (for example sorted in place)");
    }

    // ---------- failure ----------

    @Test @DisplayName("failure: null throws IllegalArgumentException")
    void nullInput() {
        assertThrows(IllegalArgumentException.class, () -> sol.containsDuplicate(null));
    }

    // ---------- large ----------

    @Test @DisplayName("large: 1 000 000 distinct values, no duplicate, within 2 s")
    void largeDistinct() {
        int n = 1_000_000;
        int[] in = new int[n];
        for (int i = 0; i < n; i++) in[i] = (i % 2 == 0) ? i : -i - 7;   // all distinct
        assertFalse(assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sol.containsDuplicate(in)));
    }

    @Test @DisplayName("large: 1 000 000 values with one duplicate at the end, within 2 s")
    void largeOneDuplicateAtEnd() {
        int n = 1_000_000;
        int[] in = new int[n];
        for (int i = 0; i < n - 1; i++) in[i] = i * 3;
        in[n - 1] = 0;   // repeats in[0]
        assertTrue(assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sol.containsDuplicate(in)));
    }
}
