package com.prashant.dailytests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Day04LargestRectangleTest {

    private static long area(int... heights) {
        return Day04LargestRectangle.largestRectangleArea(heights);
    }

    /** Brute-force O(n^2) reference, used to cross-check. */
    private static long bruteForce(int[] h) {
        long best = 0;
        for (int i = 0; i < h.length; i++) {
            long min = Long.MAX_VALUE;
            for (int j = i; j < h.length; j++) {
                min = Math.min(min, h[j]);
                best = Math.max(best, min * (j - i + 1));
            }
        }
        return best;
    }

    // ---------- normal cases ----------

    @Test @DisplayName("normal: classic example [2, 1, 5, 6, 2, 3] gives 10")
    void classic() {
        assertEquals(10L, area(2, 1, 5, 6, 2, 3));
    }

    @Test @DisplayName("normal: two bars [2, 4] gives 4")
    void twoBars() {
        assertEquals(4L, area(2, 4));
    }

    @Test @DisplayName("normal: valley [6, 2, 5, 4, 5, 1, 6] gives 12")
    void valley() {
        assertEquals(12L, area(6, 2, 5, 4, 5, 1, 6));
    }

    @Test @DisplayName("normal: strictly increasing [1, 2, 3, 4, 5] gives 9")
    void increasing() {
        assertEquals(9L, area(1, 2, 3, 4, 5));
    }

    @Test @DisplayName("normal: strictly decreasing [5, 4, 3, 2, 1] gives 9")
    void decreasing() {
        assertEquals(9L, area(5, 4, 3, 2, 1));
    }

    @Test @DisplayName("normal: tallest bar alone wins [1, 1, 10, 1] gives 10")
    void tallSpike() {
        assertEquals(10L, area(1, 1, 10, 1));
    }

    @Test @DisplayName("normal: low wide bar wins [2, 1, 2] gives 3")
    void lowWide() {
        assertEquals(3L, area(2, 1, 2));
    }

    // ---------- empty / null / single ----------

    @Test @DisplayName("empty: [] gives 0")
    void empty() {
        assertEquals(0L, area());
    }

    @Test @DisplayName("null: throws IllegalArgumentException")
    void nullInput() {
        assertThrows(IllegalArgumentException.class,
                () -> Day04LargestRectangle.largestRectangleArea(null));
    }

    @Test @DisplayName("single: [5] gives 5")
    void single() {
        assertEquals(5L, area(5));
    }

    @Test @DisplayName("single: [1] gives 1")
    void singleOne() {
        assertEquals(1L, area(1));
    }

    @Test @DisplayName("single: [0] gives 0")
    void singleZero() {
        assertEquals(0L, area(0));
    }

    // ---------- duplicates ----------

    @Test @DisplayName("duplicates: [3, 3, 3] gives 9")
    void allEqual() {
        assertEquals(9L, area(3, 3, 3));
    }

    @Test @DisplayName("duplicates: [2, 2] gives 4")
    void twoEqual() {
        assertEquals(4L, area(2, 2));
    }

    @Test @DisplayName("duplicates: plateau [1, 4, 4, 4, 1] gives 12")
    void plateau() {
        assertEquals(12L, area(1, 4, 4, 4, 1));
    }

    @Test @DisplayName("duplicates: equal bars split by a dip [3, 1, 3] gives 3")
    void equalSplitByDip() {
        assertEquals(3L, area(3, 1, 3));
    }

    // ---------- zero ----------

    @Test @DisplayName("zero: allowed and splits the histogram [2, 0, 2] gives 2")
    void zeroSplits() {
        assertEquals(2L, area(2, 0, 2));
    }

    @Test @DisplayName("zero: all zeros [0, 0, 0] gives 0")
    void allZeros() {
        assertEquals(0L, area(0, 0, 0));
    }

    @Test @DisplayName("zero: leading and trailing zeros [0, 3, 3, 0] gives 6")
    void zeroEdges() {
        assertEquals(6L, area(0, 3, 3, 0));
    }

    @Test @DisplayName("zero: [4, 0, 1, 1, 1] gives 4 (tie between sides)")
    void zeroTie() {
        assertEquals(4L, area(4, 0, 1, 1, 1));
    }

    // ---------- negatives ----------

    @Test @DisplayName("negative: [-1] throws IllegalArgumentException")
    void negativeSingle() {
        assertThrows(IllegalArgumentException.class, () -> area(-1));
    }

    @Test @DisplayName("negative: negative in the middle [2, -3, 4] throws")
    void negativeMiddle() {
        assertThrows(IllegalArgumentException.class, () -> area(2, -3, 4));
    }

    @Test @DisplayName("negative: Integer.MIN_VALUE throws")
    void negativeMin() {
        assertThrows(IllegalArgumentException.class, () -> area(1, Integer.MIN_VALUE));
    }

    // ---------- min / max int and overflow ----------

    @Test @DisplayName("max: single Integer.MAX_VALUE bar")
    void singleMax() {
        assertEquals((long) Integer.MAX_VALUE, area(Integer.MAX_VALUE));
    }

    @Test @DisplayName("overflow: two Integer.MAX_VALUE bars give 2 * MAX as a long")
    void twoMax() {
        assertEquals(2L * Integer.MAX_VALUE, area(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test @DisplayName("overflow: [MAX, 1, MAX] keeps the long answer MAX")
    void maxSplit() {
        assertEquals((long) Integer.MAX_VALUE, area(Integer.MAX_VALUE, 1, Integer.MAX_VALUE));
    }

    @Test @DisplayName("overflow: 1_000_000_000 x 3 bars gives 3_000_000_000")
    void billionTimesThree() {
        assertEquals(3_000_000_000L, area(1_000_000_000, 1_000_000_000, 1_000_000_000));
    }

    @Test @DisplayName("overflow: 100_000 bars of MAX gives MAX * 100_000")
    void manyMax() {
        int[] h = new int[100_000];
        Arrays.fill(h, Integer.MAX_VALUE);
        assertEquals((long) Integer.MAX_VALUE * 100_000, Day04LargestRectangle.largestRectangleArea(h));
    }

    // ---------- boundaries ----------

    @Test @DisplayName("boundary: best rectangle touches the left edge [5, 5, 1]")
    void leftEdge() {
        assertEquals(10L, area(5, 5, 1));
    }

    @Test @DisplayName("boundary: best rectangle touches the right edge [1, 5, 5]")
    void rightEdge() {
        assertEquals(10L, area(1, 5, 5));
    }

    @Test @DisplayName("boundary: whole histogram is the answer [4, 5, 4, 6]")
    void wholeRange() {
        assertEquals(16L, area(4, 5, 4, 6));
    }

    // ---------- input not modified ----------

    @Test @DisplayName("input: array is not modified")
    void inputUnchanged() {
        int[] h = {2, 1, 5, 6, 2, 3};
        int[] copy = h.clone();
        Day04LargestRectangle.largestRectangleArea(h);
        assertArrayEquals(copy, h);
    }

    // ---------- large input / performance ----------

    @Test @DisplayName("large: 200_000 equal bars of 1 gives 200_000 quickly")
    void largeFlat() {
        int[] h = new int[200_000];
        Arrays.fill(h, 1);
        long result = assertTimeoutPreemptively(Duration.ofSeconds(2),
                () -> Day04LargestRectangle.largestRectangleArea(h));
        assertEquals(200_000L, result);
    }

    @Test @DisplayName("large: 200_000 increasing bars runs in O(n)")
    void largeIncreasing() {
        int n = 200_000;
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = i + 1;
        long result = assertTimeoutPreemptively(Duration.ofSeconds(2),
                () -> Day04LargestRectangle.largestRectangleArea(h));
        // best is height k with width n - k + 1, maximised at k = n/2 (and n/2 + 1)
        long expected = 0;
        for (int k = 1; k <= n; k++) expected = Math.max(expected, (long) k * (n - k + 1));
        assertEquals(expected, result);
    }

    @Test @DisplayName("large: 200_000 decreasing bars runs in O(n)")
    void largeDecreasing() {
        int n = 200_000;
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = n - i;
        long result = assertTimeoutPreemptively(Duration.ofSeconds(2),
                () -> Day04LargestRectangle.largestRectangleArea(h));
        long expected = 0;
        for (int k = 1; k <= n; k++) expected = Math.max(expected, (long) k * (n - k + 1));
        assertEquals(expected, result);
    }

    // ---------- randomized cross-check ----------

    @Test @DisplayName("random: 500 small arrays (with zeros and repeats) match brute force")
    void randomCrossCheck() {
        Random rnd = new Random(42);
        for (int t = 0; t < 500; t++) {
            int[] h = new int[rnd.nextInt(12)];
            for (int i = 0; i < h.length; i++) h[i] = rnd.nextInt(6);
            assertEquals(bruteForce(h), Day04LargestRectangle.largestRectangleArea(h),
                    () -> "heights=" + Arrays.toString(h));
        }
    }
}
