package com.prashant.dailytests.redo;

/**
 * Cold redo of LeetCode 853, Car Fleet (gap +1, first redo; first solve 3 Nov, 37/37,
 * built with hints). Write it from memory on this blank file, in 20-30 minutes, without
 * opening dsa/stack/CarFleet, PR #1 or tasks/day09.md.
 * Run CarFleetRedoNov20Test until all tests pass.
 *
 * Before any code, write three comment lines here: the pattern, the time complexity
 * and the space complexity (one sentence each on where the cost comes from).
 *
 * Spec:
 *  - n cars drive on a one-lane road towards target. Car i starts at position[i] and
 *    drives at speed[i]. A car never passes the one ahead; a faster car that catches up
 *    joins it and drives at the slower speed (one fleet). Catching up exactly at the
 *    target still counts as the same fleet. Return the number of fleets that arrive.
 *  - position or speed null, different lengths, target <= 0, a position outside
 *    0 <= position[i] < target, a speed <= 0, or two cars on the same position:
 *    IllegalArgumentException. No cars: return 0.
 *  - Do not modify the input arrays.
 *  - Arrival times must be compared EXACTLY (target and speed go up to Integer.MAX_VALUE).
 *  - 0 <= n <= 100 000; aim for O(n log n).
 *  - Examples: target 12, position [10, 8, 0, 5, 3], speed [2, 4, 1, 1, 3] -> 3 ·
 *    target 10, [3], [3] -> 1 · target 100, [0, 2, 4], [4, 2, 1] -> 1 ·
 *    target 10, [6, 8], [3, 2] -> 2 · target 10, [0, 5], [2, 1] -> 1.
 */
public class CarFleetRedoNov20 {

    // Pattern:
    // Time:
    // Space:

    public int carFleet(int target, int[] position, int[] speed) {
        // TODO: write from memory
        throw new UnsupportedOperationException("TODO");
    }
}
