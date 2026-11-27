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
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CarFleetRedoNov20 {

    // Pattern: Sorting + Monotonic Stack (greedy)
    //
    // Pseudocode:
    //   1. Validate inputs.
    //   2. Pair each car as (position, speed).
    //   3. Sort cars by position in DESCENDING order (car closest to target first).
    //   4. For each car, in that order, compare its arrival time to the fleet
    //      directly ahead of it (top of stack):
    //        - time = (target - position) / speed
    //        - if time > time of fleet on top -> it never catches up,
    //          so it forms a NEW fleet -> push.
    //        - else (time <= top) -> it catches up and merges into that fleet
    //          (it must slow down to the fleet's speed) -> do nothing.
    //   5. Answer = number of fleets on the stack.
    //
    // Time:  O(n log n)  -> dominated by sorting; the stack pass is O(n)
    // Space: O(n)        -> the cars array plus the stack

    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || speed == null) {
            throw new IllegalArgumentException("position and speed must not be null");
        }
        if (position.length != speed.length) {
            throw new IllegalArgumentException("position and speed must have the same length");
        }
        if (target <= 0) {
            throw new IllegalArgumentException("target must be positive");
        }

        int n = position.length;
        if (n == 0) {
            return 0;
        }

        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (position[i] < 0 || position[i] >= target) {
                throw new IllegalArgumentException("position must satisfy 0 <= position < target");
            }
            if (speed[i] <= 0) {
                throw new IllegalArgumentException("speed must be positive");
            }
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // closest to target first
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 1; i < n; i++) {
            if (cars[i][0] == cars[i - 1][0]) {
                throw new IllegalArgumentException("two cars share the same starting position");
            }
        }

        // each entry: {distance to target, speed} of a fleet's leader
        Deque<long[]> stack = new ArrayDeque<>();
        for (int[] car : cars) {
            long dist = (long) target - car[0];
            long spd = car[1];

            // dist/spd > topDist/topSpd  <=>  dist * topSpd > topDist * spd
            // (cross-multiplication avoids floating point error)
            if (stack.isEmpty()
                    || dist * stack.peek()[1] > stack.peek()[0] * spd) {
                stack.push(new long[]{dist, spd});
            }
            // else: merges into the fleet ahead
        }
        return stack.size();
    }
}
