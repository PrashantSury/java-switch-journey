package com.prashant.dailytests.redo;

/**
 * Redo of the Day 01 buggy round: write this from memory, without opening
 * Day01ArrayStack. Run Day01ArrayStackRedoTest until all tests pass.
 *
 * Spec (same as Day 01): a growable int stack backed by an int[] array.
 *  - new Day01ArrayStackRedo(initialCapacity): initialCapacity >= 0 is allowed (0 too);
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
public class Day01ArrayStackRedo {

    public Day01ArrayStackRedo(int initialCapacity) {
        // TODO(Day 06 redo): write it from memory
    }

    public void push(int x) {
        throw new UnsupportedOperationException("not written yet");
    }

    public int pop() {
        throw new UnsupportedOperationException("not written yet");
    }

    public int peek() {
        throw new UnsupportedOperationException("not written yet");
    }

    public int size() {
        throw new UnsupportedOperationException("not written yet");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("not written yet");
    }

    public int[] toArray() {
        throw new UnsupportedOperationException("not written yet");
    }
}
