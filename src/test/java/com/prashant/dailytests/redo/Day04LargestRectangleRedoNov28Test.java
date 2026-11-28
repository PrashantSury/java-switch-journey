package com.prashant.dailytests.redo;

import com.prashant.dailytests.Day04LargestRectangleContract;

/** Runs the shared Day04LargestRectangleContract cases against {@code Day04LargestRectangleRedoNov28}. */
class Day04LargestRectangleRedoNov28Test extends Day04LargestRectangleContract {
    @Override
    protected long largestRectangleArea(int[] heights) { return Day04LargestRectangleRedoNov28.largestRectangleArea(heights); }
}
