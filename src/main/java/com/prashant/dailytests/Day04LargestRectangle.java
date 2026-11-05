package com.prashant.dailytests;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Buggy round, Stack pattern: largest rectangle in a histogram (LeetCode 84, NeetCode 150).
 * Full spec and the knowledge check: tasks/day09.md, "Day04LargestRectangle".
 *
 * <p>This class has bugs. Run {@code Day04LargestRectangleTest}, read the failing tests, then make the
 * smallest fixes until every test passes. Don't rewrite it. The bugs are not described here on purpose.</p>
 *
 * <h2>Why this round matters</h2>
 * <p>"Largest rectangle in a histogram" is the classic test of whether you can reason about
 * boundaries: for every bar, how far can a rectangle of that bar's height stretch to the left and to
 * the right? Interviewers like it because a correct-looking solution fails on a handful of
 * precise inputs (ties, zeros, the ends of the array, very large numbers), and because the fix
 * has to be small and exact. It is also the hardest problem in the Stack pattern, so a clean
 * pass here is a strong signal.</p>
 *
 * <h2>Expected behaviour</h2>
 * <pre>
 * | topic            | required behaviour                                                            |
 * |------------------|-------------------------------------------------------------------------------|
 * | input            | each bar has width 1 and height heights[i]                                    |
 * | result           | the exact area (a long) of the largest rectangle that fits fully inside       |
 * | zero height      | allowed; a bar of height 0 splits the histogram                               |
 * | negative height  | IllegalArgumentException                                                      |
 * | null array       | IllegalArgumentException                                                      |
 * | empty array      | returns 0                                                                     |
 * | single bar       | returns that bar's own height                                                 |
 * | equal neighbours | are combined: [3, 3, 3] returns 9                                             |
 * | time             | O(n): each index is pushed and popped at most once                            |
 * | the input array  | must not be modified                                                          |
 * </pre>
 *
 * <h2>Test cases the suite runs (input, expected result)</h2>
 * <p><b>Normal</b></p>
 * <pre>
 * | heights                    | result | what it checks                          |
 * |----------------------------|--------|-----------------------------------------|
 * | [2, 1, 5, 6, 2, 3]         | 10     | the classic example                     |
 * | [2, 4]                     | 4      | two bars                                |
 * | [6, 2, 5, 4, 5, 1, 6]      | 12     | a valley                                |
 * | [1, 2, 3, 4, 5]            | 9      | strictly increasing                     |
 * | [5, 4, 3, 2, 1]            | 9      | strictly decreasing                     |
 * | [1, 1, 10, 1]              | 10     | one tall bar wins alone                 |
 * | [2, 1, 2]                  | 3      | a low, wide rectangle wins              |
 * </pre>
 * <p><b>Edge</b></p>
 * <pre>
 * | heights                    | result | what it checks                          |
 * |----------------------------|--------|-----------------------------------------|
 * | []                         | 0      | empty                                   |
 * | [5] / [1] / [0]            | 5 / 1 / 0 | single bar                           |
 * | [3, 3, 3] / [2, 2]         | 9 / 4  | all equal                               |
 * | [1, 4, 4, 4, 1]            | 12     | a plateau                               |
 * | [3, 1, 3]                  | 3      | equal bars split by a dip               |
 * | [2, 0, 2]                  | 2      | a zero splits the histogram             |
 * | [0, 0, 0]                  | 0      | all zeros                               |
 * | [0, 3, 3, 0]               | 6      | zeros at both ends                      |
 * | [4, 0, 1, 1, 1]            | 4      | a tie between the two sides             |
 * | [5, 5, 1] / [1, 5, 5]      | 10     | best rectangle touches an end           |
 * | [4, 5, 4, 6]               | 16     | the whole histogram is the answer       |
 * | [MAX]                      | MAX    | one bar of Integer.MAX_VALUE            |
 * | [MAX, MAX]                 | 2 * MAX| the exact area as a long                |
 * | [MAX, 1, MAX]              | MAX    | a dip between two huge bars             |
 * | [1e9, 1e9, 1e9]            | 3e9    | three bars of 1,000,000,000             |
 * | 100,000 bars of MAX        | MAX * 100,000 | many huge bars                   |
 * </pre>
 * <p><b>Failure</b></p>
 * <pre>
 * | heights                    | result                     | what it checks            |
 * |----------------------------|----------------------------|---------------------------|
 * | null                       | IllegalArgumentException   | null input                |
 * | [-1]                       | IllegalArgumentException   | a single negative bar     |
 * | [2, -3, 4]                 | IllegalArgumentException   | a negative bar in the middle |
 * | [1, Integer.MIN_VALUE]     | IllegalArgumentException   | the most negative int     |
 * </pre>
 * <p><b>Other:</b> the array is unchanged after the call; 200,000 equal, increasing or decreasing bars
 * finish within 2 seconds; 500 random small arrays (with zeros and repeats) match a brute-force
 * answer.</p>
 *
 * <h2>Knowledge check (answers are in tasks/day09.md, under "Open only after your attempt")</h2>
 * <ol>
 *   <li>For a chosen bar of height h, the widest rectangle of height h is limited on each side by:
 *       (a) the nearest bar that is shorter than h &nbsp; (b) the nearest bar that is taller than h
 *       &nbsp; (c) the first and last bar of the array &nbsp; (d) the two tallest bars</li>
 *   <li>Which structure holds the bars that are still waiting for their right boundary?
 *       (a) a queue &nbsp; (b) a stack whose bars are in increasing height &nbsp; (c) a max-heap
 *       &nbsp; (d) a hash map from height to index</li>
 *   <li>Why is the stack approach O(n) even though there is a loop inside a loop?
 *       (a) the inner loop runs at most 2 times &nbsp; (b) every index is pushed once and popped at
 *       most once &nbsp; (c) the array is sorted first &nbsp; (d) it is actually O(n log n)</li>
 * </ol>
 */
public class Day04LargestRectangle {

    public static long largestRectangleArea(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("heights must not be null");
        }
        for (int h : heights) {
            if (h < 0) {
                throw new IllegalArgumentException("invalid height: " + h);
            }
        }

        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // indices, heights increasing
        long best = 0;

        // i == n acts as a sentinel bar of height 0 that flushes the stack.
        for (int i = 0; i <= n; i++) {
            int current = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= current) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                long area = (long) height * width;
                best = Math.max(best, area);
            }
            stack.push(i);
        }
        return best;
    }
}
