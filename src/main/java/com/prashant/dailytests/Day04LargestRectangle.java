package com.prashant.dailytests;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 04 fix-the-buggy-code round: largest rectangle in a histogram (monotonic stack).
 * This class has bugs. Run Day04LargestRectangleTest, read the failing tests,
 * then make the smallest fixes until every test passes. Don't rewrite it.
 *
 * Spec:
 *  - largestRectangleArea(heights): each bar has width 1 and height heights[i].
 *    Return the area of the largest rectangle that fits fully inside the histogram.
 *  - The answer is a long: heights can be as large as Integer.MAX_VALUE and
 *    there can be many bars, so the area may not fit in an int.
 *  - A height of 0 is allowed (it splits the histogram). A negative height
 *    throws IllegalArgumentException. null throws IllegalArgumentException.
 *  - An empty array returns 0. A single bar returns its own height.
 *  - Equal neighbouring heights must be combined: [3, 3, 3] returns 9.
 *  - Must run in O(n) time (each index is pushed and popped at most once).
 *  - The input array must not be modified.
 */
public class Day04LargestRectangle {

    public static long largestRectangleArea(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("heights must not be null");
        }
        for (int h : heights) {
            if (h <= 0) {
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
                int width = stack.isEmpty() ? i - 1 : i - stack.peek() - 1;
                int area = height * width;
                best = Math.max(best, area);
            }
            stack.push(i);
        }
        return best;
    }
}
