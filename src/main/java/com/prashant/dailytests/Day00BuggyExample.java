package com.prashant.dailytests;

/**
 * Practice for the "fix the buggy code" round.
 * This class has bugs. Run Day00BuggyExampleTest, read the failing tests,
 * then fix the code until every test passes.
 */
public class Day00BuggyExample {
    /**
     * Returns the largest value in the array.
     * Throws IllegalArgumentException if nums is null or empty.
     */
    public int max(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }
}
