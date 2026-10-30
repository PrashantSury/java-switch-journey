package com.prashant.dailytests.redo;

/**
 * Day-7 redo of the Day 01 buggy round: write this from memory, without opening
 * Day01ArrayStack or Day01ArrayStackRedo. Run Day01ArrayStackRedo7Test until all tests pass.
 *
 * Spec (same as Day 01): a growable int stack backed by an int[] array.
 *  - new Day01ArrayStackRedo7(initialCapacity): initialCapacity >= 0 is allowed (0 too);
 *    a negative capacity throws IllegalArgumentException.
 *  - push(x): never fails; the backing array grows when it is full
 *    (including when the starting capacity is 0).
 *  - pop(): removes and returns the top; throws java.util.NoSuchElementException when empty,
 *    and the stack must still work normally afterwards.
 *  - peek(): returns the top without removing it; throws NoSuchElementException when empty.
 *  - size(), isEmpty().
 *  - toArray(): a copy of the elements from bottom to top, length == size().
 *
 * Don't use ArrayDeque, ArrayList or Stack: manage the array yourself.
 */
public class Day01ArrayStackRedo7 {

    public Day01ArrayStackRedo7(int initialCapacity) {
        // TODO(Day 08 redo): write it from memory
    }

    public void push(int x) {
        // TODO
    }

    public int pop() {
        // TODO
        return 0;
    }

    public int peek() {
        // TODO
        return 0;
    }

    public int size() {
        // TODO
        return 0;
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public int[] toArray() {
        // TODO
        return new int[0];
    }
}
