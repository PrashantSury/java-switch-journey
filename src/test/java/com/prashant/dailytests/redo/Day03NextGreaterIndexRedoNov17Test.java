package com.prashant.dailytests.redo;

import com.prashant.dailytests.Day03NextGreaterIndexContract;

/** Runs the shared Day03NextGreaterIndexContract cases against {@code Day03NextGreaterIndexRedoNov17}. */
class Day03NextGreaterIndexRedoNov17Test extends Day03NextGreaterIndexContract {
    @Override
    protected int[] nextGreaterIndex(int[] nums) { return Day03NextGreaterIndexRedoNov17.nextGreaterIndex(nums); }
}
