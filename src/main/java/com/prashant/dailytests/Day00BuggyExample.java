package com.prashant.dailytests;

/**
 * Practice for the "fix the buggy code" round.
 * This method has a bug. Run Day00BuggyExampleTest, read the failing test,
 * then fix the code until every test passes.
 * Save each day's buggy-code round as DayXX... here with its test in src/test.
 */
public class Day00BuggyExample {
    /** Returns the largest value in the array. */
    public int max(int[] nums) {
        int max = 0; // bug: fails when all numbers are negative
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }
}
