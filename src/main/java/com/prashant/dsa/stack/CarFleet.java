package com.prashant.dsa.stack;

/**
 * Day 04 DSA (Week 1, Stack): Car Fleet (LeetCode 853), with extra rules.
 *
 * n cars drive along a one-lane road towards {@code target}. Car i starts at
 * {@code position[i]} (miles) and drives at {@code speed[i]} (miles per hour).
 * A car can never pass the car ahead of it. When a faster car catches a slower
 * one, it slows down and they drive on together as one fleet (the fleet's speed
 * is the speed of the slowest car in it). A single car is also a fleet.
 * If a car catches up with a fleet exactly at the target, it still counts as
 * part of that fleet.
 *
 * Return the number of fleets that arrive at the target.
 *
 * Rules for this repo:
 *  - If position or speed is null, throw IllegalArgumentException.
 *  - If position.length != speed.length, throw IllegalArgumentException.
 *  - If there are no cars, return 0.
 *  - If target <= 0, throw IllegalArgumentException.
 *  - Every position must satisfy 0 <= position[i] < target, else IllegalArgumentException.
 *  - Every speed must be > 0, else IllegalArgumentException.
 *  - Positions must be unique (two cars can't start at the same spot), else IllegalArgumentException.
 *  - The input arrays must NOT be modified.
 *  - Compare arrival times EXACTLY. target and speeds can go up to Integer.MAX_VALUE,
 *    so think about int overflow and about double precision before you divide.
 *
 * Constraints: 0 <= n <= 100_000, 1 <= target <= Integer.MAX_VALUE,
 * 1 <= speed[i] <= Integer.MAX_VALUE. Aim for O(n log n) time.
 *
 * Examples:
 *  target = 12, position = [10, 8, 0, 5, 3], speed = [2, 4, 1, 1, 3]  -> 3
 *  target = 10, position = [3], speed = [3]                            -> 1
 *  target = 100, position = [0, 2, 4], speed = [4, 2, 1]               -> 1
 *  target = 10, position = [6, 8], speed = [3, 2]                      -> 2
 *  target = 10, position = [0, 5], speed = [2, 1]                      -> 1 (they meet exactly at the target)
 */
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        // TODO: implement
        return 0;
    }
}
