package com.prashant.dailytests;

/**
 * Warm-up for the "fix the buggy code" round: the largest value in an array.
 * Full spec and the knowledge check: tasks/day09.md, "Day00BuggyExample".
 *
 * <p>This class has bugs. Run {@code Day00BuggyExampleTest}, read the failing tests, then fix the code
 * until every test passes. The bugs are not described here on purpose.</p>
 *
 * <h2>Why this warm-up matters</h2>
 * <p>The real buggy rounds are short and unforgiving: you get a small class, a failing test suite and
 * about fifteen minutes. The skill being tested is not cleverness but method: read the failing test,
 * work out which input class it represents, change as little as possible, and re-run. This
 * ten-line class lets you practise that loop on something you already understand.</p>
 *
 * <h2>Expected behaviour of {@code max(int[] nums)}</h2>
 * <pre>
 * | situation                 | required behaviour                 |
 * |---------------------------|------------------------------------|
 * | normal array              | returns the largest element        |
 * | null array                | IllegalArgumentException           |
 * | empty array               | IllegalArgumentException           |
 * | any int values            | including Integer.MIN_VALUE and MAX_VALUE |
 * </pre>
 *
 * <h2>Test cases the suite runs</h2>
 * <pre>
 * | kind    | nums                              | result                    |
 * |---------|-----------------------------------|---------------------------|
 * | normal  | [3, 9, 2]                         | 9                         |
 * | edge    | [10, 1, 2]                        | 10 (max is first)         |
 * | edge    | [1, 2, 8]                         | 8 (max is last)           |
 * | edge    | [-5, -2, -8]                      | -2 (all negative)         |
 * | edge    | [7]                               | 7 (single element)        |
 * | edge    | [4, 4, 4]                         | 4 (duplicates)            |
 * | edge    | [-3, 0, -1]                       | 0 (zero among negatives)  |
 * | edge    | [MIN] and [MIN, MAX]              | MIN and MAX               |
 * | failure | []                                | IllegalArgumentException  |
 * | failure | null                              | IllegalArgumentException  |
 * </pre>
 *
 * <h2>Knowledge check (answers are in tasks/day09.md)</h2>
 * <ol>
 *   <li>A test fails. What is the best first step?
 *       (a) rewrite the method &nbsp; (b) read the test name and its input, and decide which kind of input it
 *       represents &nbsp; (c) delete the test &nbsp; (d) add a {@code try/catch}</li>
 *   <li>A test is named "edge: ...". What does that tell you?
 *       (a) the test is optional &nbsp; (b) the input sits at a boundary of what is valid or usual
 *       &nbsp; (c) the test is expected to fail &nbsp; (d) the test is slow</li>
 *   <li>Which fix is best in a buggy round?
 *       (a) the smallest change that fixes the failing tests without breaking the passing ones
 *       &nbsp; (b) a full rewrite &nbsp; (c) catching and ignoring the exception &nbsp; (d) commenting out
 *       the failing tests</li>
 * </ol>
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
