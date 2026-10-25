package com.prashant.dailytests;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Day 03 fix-the-buggy-code round: next greater element (monotonic stack).
 * This class has bugs. Run Day03NextGreaterIndexTest, read the failing tests,
 * then make the smallest fixes until every test passes. Don't rewrite it.
 *
 * Spec:
 *  - nextGreaterIndex(nums): returns a new int[] of the same length where
 *    result[i] is the INDEX of the first element to the right of i that is
 *    STRICTLY greater than nums[i], or -1 if there is no such element.
 *  - Equal values are not "greater": for [5, 5] the answer is [-1, -1].
 *  - Values can be any int, including negatives, Integer.MIN_VALUE and Integer.MAX_VALUE.
 *  - An empty array returns an empty array. null throws IllegalArgumentException.
 *  - Must run in O(n) time (each index is pushed and popped at most once).
 *  - The input array must not be modified.
 */
public class Day03NextGreaterIndex {

    public static int[] nextGreaterIndex(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1, n, -1);

        // indices whose next greater element hasn't been found yet (values non-increasing)
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] - nums[stack.peek()] >= 0) {
                result[stack.pop()] = i;
            }
            stack.push(i);
        }
        return result;
    }
}
