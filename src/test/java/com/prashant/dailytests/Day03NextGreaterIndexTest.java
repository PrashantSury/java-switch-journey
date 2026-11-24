package com.prashant.dailytests;


/** Runs the shared Day03NextGreaterIndexContract cases against {@code Day03NextGreaterIndex}. */
class Day03NextGreaterIndexTest extends Day03NextGreaterIndexContract {
    @Override
    protected int[] nextGreaterIndex(int[] nums) { return Day03NextGreaterIndex.nextGreaterIndex(nums); }
}
