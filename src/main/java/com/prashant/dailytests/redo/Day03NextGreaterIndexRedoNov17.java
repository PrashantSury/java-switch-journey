package com.prashant.dailytests.redo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Cold redo of the Day 03 buggy round, next greater INDEX (gap +1, first redo; the
 * round was fixed 29 Oct, 37/37). This time there is no buggy code to fix: write the
 * whole method from memory on this blank file, in 20-30 minutes, without opening
 * dailytests/Day03NextGreaterIndex or dsa/stack/DailyTemperatures.
 * Run Day03NextGreaterIndexRedoNov17Test until all tests pass.
 *
 * Before any code, write three comment lines here: the pattern, the time complexity
 * and the space complexity (one sentence each on where the cost comes from).
 *
 * Spec:
 *  - nextGreaterIndex(nums) returns a new int[] of the same length where result[i] is
 *    the INDEX of the first element to the right of i that is STRICTLY greater than
 *    nums[i], or -1 if there is no such element.
 *  - Equal values are not "greater": [5, 5] -> [-1, -1].
 *  - Values can be any int, including negatives, Integer.MIN_VALUE and Integer.MAX_VALUE.
 *  - An empty array returns an empty array. null throws IllegalArgumentException.
 *  - The input array must not be modified.
 *  - Must run in O(n) for a 200 000-element input.
 *  - Example: [2, 1, 3, 4] -> [2, 2, 3, -1].
 */
public class Day03NextGreaterIndexRedoNov17 {

    // Pattern: stack
    // Time: O(n)
    // Space: O(n)

    public static int[] nextGreaterIndex(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("array is null");
        }

        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = i;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        nextGreaterIndex(new int[]{2, 1, 3, 4});
    }
}
