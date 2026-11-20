package com.prashant.dsa.arrayshashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    private TwoSum sol;

    @BeforeEach
    void setUp() { sol = new TwoSum(); }

    private void check(int[] expected, int[] nums, int target) {
        assertArrayEquals(expected, sol.twoSum(nums, target),
                () -> "nums=" + Arrays.toString(nums) + " target=" + target);
    }

    // ---------- normal ----------

    @Test @DisplayName("normal: LeetCode example 1, [2,7,11,15] target 9 gives [0,1]")
    void example1() { check(new int[]{0, 1}, new int[]{2, 7, 11, 15}, 9); }

    @Test @DisplayName("normal: LeetCode example 2, [3,2,4] target 6 gives [1,2], never [0,0]")
    void example2() { check(new int[]{1, 2}, new int[]{3, 2, 4}, 6); }

    @Test @DisplayName("normal: LeetCode example 3, duplicates [3,3] target 6 gives [0,1]")
    void example3() { check(new int[]{0, 1}, new int[]{3, 3}, 6); }

    @Test @DisplayName("normal: the pair is far apart (first and last index)")
    void farApart() { check(new int[]{0, 5}, new int[]{1, 20, 30, 40, 50, 8}, 9); }

    @Test @DisplayName("normal: negative values (-3 + 4 = 1)")
    void negatives() { check(new int[]{0, 2}, new int[]{-3, 10, 4, 90}, 1); }

    @Test @DisplayName("normal: target 0 with a value and its negation")
    void zeroTarget() { check(new int[]{1, 3}, new int[]{5, -7, 2, 7}, 0); }

    @Test @DisplayName("normal: zeros, [0,4,3,0] target 0 gives [0,3]")
    void twoZeros() { check(new int[]{0, 3}, new int[]{0, 4, 3, 0}, 0); }

    @Test @DisplayName("normal: half of the target appears once, so it must not pair with itself")
    void halfTargetOnce() { check(new int[]{2, 3}, new int[]{5, 1, 4, 6}, 10); }

    @Test @DisplayName("normal: indices come back in ascending order")
    void ascendingOrder() {
        int[] r = sol.twoSum(new int[]{11, 15, 7, 2}, 9);
        assertEquals(2, r.length);
        assertTrue(r[0] < r[1], () -> "got " + Arrays.toString(r));
        assertArrayEquals(new int[]{2, 3}, r);
    }

    // ---------- edge ----------

    @Test @DisplayName("edge: exactly two elements that form the pair")
    void twoElements() { check(new int[]{0, 1}, new int[]{-1, -2}, -3); }

    @Test @DisplayName("edge: Integer.MAX_VALUE + Integer.MIN_VALUE = -1 is a real pair")
    void extremesRealPair() { check(new int[]{1, 2}, new int[]{5, Integer.MAX_VALUE, Integer.MIN_VALUE}, -1); }

    @Test @DisplayName("edge: a sum that only matches after int overflow wraps is NOT a pair")
    void overflowIsNotAPair() {
        // Integer.MAX_VALUE + 1 wraps to Integer.MIN_VALUE in int arithmetic, but the exact sum is 2147483648.
        assertThrows(IllegalArgumentException.class,
                () -> sol.twoSum(new int[]{Integer.MAX_VALUE, 7, 1}, Integer.MIN_VALUE));
    }

    @Test @DisplayName("edge: the caller's array is not modified")
    void inputUnchanged() {
        int[] nums = {9, 4, 1, 7, 3};
        int[] copy = nums.clone();
        check(new int[]{1, 4}, nums, 7);
        assertArrayEquals(copy, nums);
    }

    // ---------- failure ----------

    @Test @DisplayName("failure: null array throws IllegalArgumentException")
    void nullInput() { assertThrows(IllegalArgumentException.class, () -> sol.twoSum(null, 1)); }

    @Test @DisplayName("failure: empty array throws IllegalArgumentException (no pair)")
    void emptyInput() { assertThrows(IllegalArgumentException.class, () -> sol.twoSum(new int[]{}, 0)); }

    @Test @DisplayName("failure: one element can't pair with itself, throws IllegalArgumentException")
    void singleElement() { assertThrows(IllegalArgumentException.class, () -> sol.twoSum(new int[]{5}, 10)); }

    @Test @DisplayName("failure: no two values add up to the target, throws IllegalArgumentException")
    void noPair() { assertThrows(IllegalArgumentException.class, () -> sol.twoSum(new int[]{1, 2, 3, 4}, 100)); }

    // ---------- large ----------

    @Test @DisplayName("large: 1 000 000 values, pair at the very end, within 2 s")
    void largeEnd() {
        int n = 1_000_000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = 1_000_000 + i * 2;   // all even and >= 1 000 000
        nums[n - 2] = -1;                                           // the only pair that sums to 3
        nums[n - 1] = 4;
        int[] r = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sol.twoSum(nums, 3));
        assertArrayEquals(new int[]{n - 2, n - 1}, r);
    }

    @Test @DisplayName("large: 1 000 000 distinct values with no pair, throws within 2 s")
    void largeNoPair() {
        int n = 1_000_000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i * 2;          // all even, target is odd
        assertTimeoutPreemptively(Duration.ofSeconds(2),
                () -> assertThrows(IllegalArgumentException.class, () -> sol.twoSum(nums, 1)));
    }
}
