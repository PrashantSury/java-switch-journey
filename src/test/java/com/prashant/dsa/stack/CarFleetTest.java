package com.prashant.dsa.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarFleetTest {
    private CarFleet sol;

    @BeforeEach
    void setUp() { sol = new CarFleet(); }

    private void check(int expected, int target, int[] position, int[] speed) {
        assertEquals(expected, sol.carFleet(target, position, speed),
                () -> "target=" + target + " position=" + Arrays.toString(position) + " speed=" + Arrays.toString(speed));
    }

    private void invalid(int target, int[] position, int[] speed) {
        assertThrows(IllegalArgumentException.class, () -> sol.carFleet(target, position, speed));
    }

    // ---------- LeetCode examples ----------
    @Test @DisplayName("normal: LeetCode example 1 gives 3 fleets")
    void example1() { check(3, 12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}); }

    @Test @DisplayName("normal: LeetCode example 2, single car is 1 fleet")
    void example2() { check(1, 10, new int[]{3}, new int[]{3}); }

    @Test @DisplayName("normal: LeetCode example 3, everyone merges into 1 fleet")
    void example3() { check(1, 100, new int[]{0, 2, 4}, new int[]{4, 2, 1}); }

    // ---------- empty / single ----------
    @Test @DisplayName("empty: no cars returns 0")
    void noCars() { check(0, 10, new int[]{}, new int[]{}); }

    @Test @DisplayName("single: car at position 0 is 1 fleet")
    void singleAtZero() { check(1, 1, new int[]{0}, new int[]{1}); }

    @Test @DisplayName("single: car just before the target (target - 1) is 1 fleet")
    void singleJustBeforeTarget() { check(1, 10, new int[]{9}, new int[]{1}); }

    // ---------- two cars ----------
    @Test @DisplayName("two cars: car behind is slower, never catches up, 2 fleets")
    void behindSlower() { check(2, 10, new int[]{6, 2}, new int[]{2, 1}); }

    @Test @DisplayName("two cars: car behind catches up before target, 1 fleet")
    void behindCatchesUp() { check(1, 10, new int[]{8, 0}, new int[]{1, 10}); }

    @Test @DisplayName("boundary: cars meet exactly at the target, counts as 1 fleet")
    void meetExactlyAtTarget() { check(1, 10, new int[]{0, 5}, new int[]{2, 1}); }

    @Test @DisplayName("boundary: car behind would arrive a tiny bit later, 2 fleets")
    void justMissesAtTarget() { check(2, 10, new int[]{6, 8}, new int[]{3, 2}); }

    @Test @DisplayName("duplicates: same speed never catches up, 2 fleets")
    void sameSpeed() { check(2, 10, new int[]{1, 5}, new int[]{3, 3}); }

    @Test @DisplayName("duplicates: equal arrival times with different positions merge into 1 fleet")
    void equalTimesMerge() { check(1, 12, new int[]{0, 6, 9}, new int[]{4, 2, 1}); }

    // ---------- ordering ----------
    @Test @DisplayName("ordering: input not sorted by position still works")
    void unsortedInput() { check(3, 12, new int[]{3, 5, 0, 8, 10}, new int[]{3, 1, 1, 4, 2}); }

    @Test @DisplayName("ordering: a slow car in front blocks everyone behind, 1 fleet")
    void slowLeaderBlocksAll() { check(1, 100, new int[]{90, 10, 20, 30, 40}, new int[]{1, 50, 40, 30, 20}); }

    @Test @DisplayName("ordering: speeds increase towards the front, nobody catches anyone")
    void allSeparate() { check(4, 100, new int[]{0, 10, 20, 30}, new int[]{1, 2, 3, 4}); }

    @Test @DisplayName("ordering: two fleets form, then a fast car from the back joins the second one")
    void joinsSlowedFleet() {
        // car at 9 (speed 1) arrives t=1; car at 5 (speed 5) arrives t=1 -> same fleet;
        // car at 1 (speed 1) arrives t=9 -> new fleet; car at 0 (speed 3) would arrive t=3.33,
        // but it is behind the car at 1, so it gets stuck behind it -> joins that fleet. Total 2.
        check(2, 10, new int[]{9, 5, 0, 1}, new int[]{1, 5, 3, 1});
    }

    @Test @DisplayName("ordering: fleet time is the SLOWEST car's time, not the latest car added")
    void fleetKeepsSlowestTime() {
        // front car very slow (t=10), car behind fast (t=1) joins it, car further behind (t=5) also joins
        check(1, 20, new int[]{10, 5, 0}, new int[]{1, 15, 4});
    }

    @Test @DisplayName("input arrays are not modified")
    void inputNotModified() {
        int[] pos = {10, 8, 0, 5, 3};
        int[] spd = {2, 4, 1, 1, 3};
        sol.carFleet(12, pos, spd);
        assertArrayEquals(new int[]{10, 8, 0, 5, 3}, pos);
        assertArrayEquals(new int[]{2, 4, 1, 1, 3}, spd);
    }

    // ---------- overflow / precision ----------
    @Test @DisplayName("overflow: target = Integer.MAX_VALUE and huge speeds, cross-multiplying in int overflows")
    void overflowCrossMultiply() {
        int max = Integer.MAX_VALUE;
        // car at 0 speed MAX arrives t=1; car at 1 speed 1 is AHEAD and arrives t=MAX-1 -> car at 0 catches it
        check(1, max, new int[]{1, 0}, new int[]{1, max});
    }

    @Test @DisplayName("overflow: two cars with huge distances and speeds, 2 fleets")
    void overflowTwoFleets() {
        int max = Integer.MAX_VALUE;
        // front car at max-1 speed 1 -> t=1; back car at 0 speed max-1 -> t = max/(max-1) > 1
        check(2, max, new int[]{max - 1, 0}, new int[]{1, max - 1});
    }

    @Test @DisplayName("precision: arrival times differ by about 1e-19, doubles can't tell them apart, still 2 fleets")
    void doublePrecisionTrap() {
        int max = Integer.MAX_VALUE;
        // front car: distance max-2, speed max-1 ; back car: distance max-1, speed max
        // (max-2)/(max-1) < (max-1)/max exactly, so the back car arrives later -> 2 fleets
        check(2, max, new int[]{2, 1}, new int[]{max - 1, max});
    }

    @Test @DisplayName("precision: equal times written as different fractions merge exactly, 1 fleet")
    void exactEqualFractions() {
        int max = Integer.MAX_VALUE; // 2147483647 = 7 * 306783378 + 1
        // front: distance 6, speed 3 (t=2); back: distance 2147483646, speed 1073741823 (t=2)
        check(1, max, new int[]{max - 6, 1}, new int[]{3, 1073741823});
    }

    // ---------- invalid input ----------
    @Test @DisplayName("invalid: null position throws IllegalArgumentException")
    void nullPosition() { invalid(10, null, new int[]{1}); }

    @Test @DisplayName("invalid: null speed throws IllegalArgumentException")
    void nullSpeed() { invalid(10, new int[]{1}, null); }

    @Test @DisplayName("invalid: both arrays null throws IllegalArgumentException")
    void bothNull() { invalid(10, null, null); }

    @Test @DisplayName("invalid: different array lengths throw IllegalArgumentException")
    void lengthMismatch() { invalid(10, new int[]{1, 2}, new int[]{1}); }

    @Test @DisplayName("invalid: target 0 throws IllegalArgumentException")
    void zeroTarget() { invalid(0, new int[]{}, new int[]{}); }

    @Test @DisplayName("invalid: negative target throws IllegalArgumentException")
    void negativeTarget() { invalid(-5, new int[]{0}, new int[]{1}); }

    @Test @DisplayName("invalid: negative position throws IllegalArgumentException")
    void negativePosition() { invalid(10, new int[]{-1}, new int[]{1}); }

    @Test @DisplayName("invalid: position equal to target throws IllegalArgumentException")
    void positionAtTarget() { invalid(10, new int[]{10}, new int[]{1}); }

    @Test @DisplayName("invalid: position beyond target throws IllegalArgumentException")
    void positionBeyondTarget() { invalid(10, new int[]{3, 11}, new int[]{1, 1}); }

    @Test @DisplayName("invalid: zero speed throws IllegalArgumentException")
    void zeroSpeed() { invalid(10, new int[]{1, 2}, new int[]{1, 0}); }

    @Test @DisplayName("invalid: negative speed throws IllegalArgumentException")
    void negativeSpeed() { invalid(10, new int[]{1}, new int[]{-3}); }

    @Test @DisplayName("invalid: Integer.MIN_VALUE speed throws IllegalArgumentException")
    void minIntSpeed() { invalid(10, new int[]{1}, new int[]{Integer.MIN_VALUE}); }

    @Test @DisplayName("invalid: duplicate positions throw IllegalArgumentException")
    void duplicatePositions() { invalid(10, new int[]{4, 2, 4}, new int[]{1, 2, 3}); }

    // ---------- large input ----------
    @Test @DisplayName("large: 100_000 cars, speeds increase to the front, 100_000 fleets, under 2 s")
    void largeAllSeparate() {
        int n = 100_000;
        int[] pos = new int[n], spd = new int[n];
        for (int i = 0; i < n; i++) { pos[i] = i; spd[i] = i + 1; }
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> check(n, 1_000_000, pos, spd));
    }

    @Test @DisplayName("large: 100_000 cars, slow car in front, everyone merges into 1 fleet, under 2 s")
    void largeAllMerge() {
        int n = 100_000;
        int[] pos = new int[n], spd = new int[n];
        for (int i = 0; i < n; i++) { pos[i] = i; spd[i] = n - i; }
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> check(1, 1_000_000, pos, spd));
    }
}
