package com.prashant.dailytests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day03NextGreaterIndexTest {

    private static int[] ngi(int... nums) {
        return Day03NextGreaterIndex.nextGreaterIndex(nums);
    }

    /** Brute-force O(n^2) reference, used to cross-check. */
    private static int[] bruteForce(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) { res[i] = j; break; }
            }
        }
        return res;
    }

    // ---------- normal cases ----------

    @Test @DisplayName("normal: mixed values [2, 1, 3, 4]")
    void mixed() {
        assertArrayEquals(new int[]{2, 2, 3, -1}, ngi(2, 1, 3, 4));
    }

    @Test @DisplayName("normal: classic example [4, 5, 2, 25]")
    void classic() {
        assertArrayEquals(new int[]{1, 3, 3, -1}, ngi(4, 5, 2, 25));
    }

    @Test @DisplayName("normal: [13, 7, 6, 12] - one bigger element answers several smaller ones")
    void onePopsMany() {
        assertArrayEquals(new int[]{-1, 3, 3, -1}, ngi(13, 7, 6, 12));
    }

    @Test @DisplayName("normal: strictly increasing - each points to the next index")
    void increasing() {
        assertArrayEquals(new int[]{1, 2, 3, -1}, ngi(1, 2, 3, 4));
    }

    @Test @DisplayName("normal: strictly decreasing - nothing has a greater element")
    void decreasing() {
        assertArrayEquals(new int[]{-1, -1, -1, -1}, ngi(4, 3, 2, 1));
    }

    @Test @DisplayName("normal: valley shape [3, 1, 2, 5]")
    void valley() {
        assertArrayEquals(new int[]{3, 2, 3, -1}, ngi(3, 1, 2, 5));
    }

    @Test @DisplayName("normal: next greater is not the maximum, it's the FIRST greater [1, 3, 2, 4]")
    void firstGreaterNotMax() {
        assertArrayEquals(new int[]{1, 3, 3, -1}, ngi(1, 3, 2, 4));
    }

    // ---------- empty / null / single ----------

    @Test @DisplayName("edge: empty array returns an empty array")
    void empty() {
        assertArrayEquals(new int[0], ngi());
    }

    @Test @DisplayName("edge: null throws IllegalArgumentException")
    void nullInput() {
        assertThrows(IllegalArgumentException.class, () -> Day03NextGreaterIndex.nextGreaterIndex(null));
    }

    @Test @DisplayName("edge: single element has no next greater (-1)")
    void single() {
        assertArrayEquals(new int[]{-1}, ngi(42));
    }

    @Test @DisplayName("edge: single zero has no next greater (-1)")
    void singleZero() {
        assertArrayEquals(new int[]{-1}, ngi(0));
    }

    @Test @DisplayName("edge: two elements ascending [1, 2]")
    void twoAscending() {
        assertArrayEquals(new int[]{1, -1}, ngi(1, 2));
    }

    @Test @DisplayName("edge: two elements descending [2, 1]")
    void twoDescending() {
        assertArrayEquals(new int[]{-1, -1}, ngi(2, 1));
    }

    @Test @DisplayName("edge: first element is the maximum [9, 1, 2]")
    void firstIsMax() {
        assertArrayEquals(new int[]{-1, 2, -1}, ngi(9, 1, 2));
    }

    @Test @DisplayName("edge: the result array is a new array of the same length")
    void sameLength() {
        int[] in = {5, 1, 7};
        int[] out = Day03NextGreaterIndex.nextGreaterIndex(in);
        assertEquals(in.length, out.length);
        assertNotSame(in, out);
    }

    // ---------- duplicates ----------

    @Test @DisplayName("duplicates: equal values are not greater [5, 5]")
    void twoEqual() {
        assertArrayEquals(new int[]{-1, -1}, ngi(5, 5));
    }

    @Test @DisplayName("duplicates: all equal [7, 7, 7, 7] gives all -1")
    void allEqual() {
        assertArrayEquals(new int[]{-1, -1, -1, -1}, ngi(7, 7, 7, 7));
    }

    @Test @DisplayName("duplicates: equal neighbours skip to the strictly greater one [2, 2, 3]")
    void equalThenGreater() {
        assertArrayEquals(new int[]{2, 2, -1}, ngi(2, 2, 3));
    }

    @Test @DisplayName("duplicates: [1, 3, 3, 1, 4]")
    void duplicatesMixed() {
        assertArrayEquals(new int[]{1, 4, 4, 4, -1}, ngi(1, 3, 3, 1, 4));
    }

    @Test @DisplayName("duplicates: all zeros [0, 0, 0]")
    void allZeros() {
        assertArrayEquals(new int[]{-1, -1, -1}, ngi(0, 0, 0));
    }

    // ---------- negatives / zero ----------

    @Test @DisplayName("negatives: [-3, -1, -2, 0]")
    void negatives() {
        assertArrayEquals(new int[]{1, 3, 3, -1}, ngi(-3, -1, -2, 0));
    }

    @Test @DisplayName("negatives: all negative decreasing [-1, -2, -3]")
    void negativeDecreasing() {
        assertArrayEquals(new int[]{-1, -1, -1}, ngi(-1, -2, -3));
    }

    @Test @DisplayName("zero: zero is greater than negatives [-5, 0, -5]")
    void zeroVsNegative() {
        assertArrayEquals(new int[]{1, -1, -1}, ngi(-5, 0, -5));
    }

    // ---------- min / max int and overflow ----------

    @Test @DisplayName("overflow: MIN_VALUE then MAX_VALUE - MAX is greater")
    void minThenMax() {
        assertArrayEquals(new int[]{1, -1}, ngi(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test @DisplayName("overflow: MAX_VALUE then MIN_VALUE - MIN is NOT greater")
    void maxThenMin() {
        assertArrayEquals(new int[]{-1, -1}, ngi(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    @Test @DisplayName("overflow: -1 then MAX_VALUE")
    void minusOneThenMax() {
        assertArrayEquals(new int[]{1, -1}, ngi(-1, Integer.MAX_VALUE));
    }

    @Test @DisplayName("overflow: 1 then MIN_VALUE - MIN is NOT greater")
    void oneThenMin() {
        assertArrayEquals(new int[]{-1, -1}, ngi(1, Integer.MIN_VALUE));
    }

    @Test @DisplayName("max: MAX_VALUE twice is not greater")
    void maxTwice() {
        assertArrayEquals(new int[]{-1, -1}, ngi(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test @DisplayName("min: MIN_VALUE, 0, MAX_VALUE in order")
    void minZeroMax() {
        assertArrayEquals(new int[]{1, 2, -1}, ngi(Integer.MIN_VALUE, 0, Integer.MAX_VALUE));
    }

    // ---------- input not modified ----------

    @Test @DisplayName("contract: the input array is not modified")
    void inputUnchanged() {
        int[] in = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] copy = in.clone();
        Day03NextGreaterIndex.nextGreaterIndex(in);
        assertArrayEquals(copy, in);
    }

    // ---------- cross-check against brute force ----------

    @Test @DisplayName("cross-check: matches brute force on a fixed tricky array")
    void crossCheckFixed() {
        int[] in = {6, 0, 8, 1, 3, -2, 3, 8, 8, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 5};
        assertArrayEquals(bruteForce(in), ngi(in));
    }

    @Test @DisplayName("cross-check: matches brute force on 200 random arrays (small values, many duplicates)")
    void crossCheckRandom() {
        java.util.Random r = new java.util.Random(3);
        for (int t = 0; t < 200; t++) {
            int[] in = new int[r.nextInt(30) + 1];
            for (int i = 0; i < in.length; i++) in[i] = r.nextInt(11) - 5;
            assertArrayEquals(bruteForce(in), ngi(in), () -> "input " + Arrays.toString(in));
        }
    }

    @Test @DisplayName("cross-check: matches brute force on 200 random arrays (full int range)")
    void crossCheckRandomFullRange() {
        java.util.Random r = new java.util.Random(33);
        for (int t = 0; t < 200; t++) {
            int[] in = new int[r.nextInt(30) + 1];
            for (int i = 0; i < in.length; i++) in[i] = r.nextInt();
            assertArrayEquals(bruteForce(in), ngi(in), () -> "input " + Arrays.toString(in));
        }
    }

    // ---------- large input / performance ----------

    @Test @DisplayName("large: 200,000 increasing values, each points to i + 1 (fast)")
    void largeIncreasing() {
        int n = 200_000;
        int[] in = new int[n];
        for (int i = 0; i < n; i++) in[i] = i;
        int[] out = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> Day03NextGreaterIndex.nextGreaterIndex(in));
        for (int i = 0; i < n - 1; i++) assertEquals(i + 1, out[i]);
        assertEquals(-1, out[n - 1]);
    }

    @Test @DisplayName("large: 200,000 decreasing values, all -1 (fast)")
    void largeDecreasing() {
        int n = 200_000;
        int[] in = new int[n];
        for (int i = 0; i < n; i++) in[i] = n - i;
        int[] out = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> Day03NextGreaterIndex.nextGreaterIndex(in));
        for (int v : out) assertEquals(-1, v);
    }

    @Test @DisplayName("large: 200,000 equal values, all -1 (fast)")
    void largeEqual() {
        int n = 200_000;
        int[] in = new int[n];
        Arrays.fill(in, 7);
        int[] out = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> Day03NextGreaterIndex.nextGreaterIndex(in));
        for (int v : out) assertEquals(-1, v);
    }

    @Test @DisplayName("large: decreasing then one big value at the end answers everyone (fast)")
    void largeOneAnswersAll() {
        int n = 200_000;
        int[] in = new int[n];
        for (int i = 0; i < n - 1; i++) in[i] = n - i;
        in[n - 1] = Integer.MAX_VALUE;
        int[] out = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> Day03NextGreaterIndex.nextGreaterIndex(in));
        for (int i = 0; i < n - 1; i++) assertEquals(n - 1, out[i]);
        assertEquals(-1, out[n - 1]);
    }
}
