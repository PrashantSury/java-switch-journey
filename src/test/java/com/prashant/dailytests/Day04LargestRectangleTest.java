package com.prashant.dailytests;


/** Runs the shared Day04LargestRectangleContract cases against {@code Day04LargestRectangle}. */
class Day04LargestRectangleTest extends Day04LargestRectangleContract {
    @Override
    protected long largestRectangleArea(int[] heights) { return Day04LargestRectangle.largestRectangleArea(heights); }
}
