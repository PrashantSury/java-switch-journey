package com.prashant.dailytests;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Day 01 fix-the-buggy-code round: a growable int stack backed by an array.
 * This class has bugs. Run Day01ArrayStackTest, read the failing tests,
 * then make the smallest fixes until every test passes. Don't rewrite it.
 *
 * Spec:
 *  - new Day01ArrayStack(initialCapacity): initialCapacity >= 0 is allowed (0 too);
 *    a negative capacity throws IllegalArgumentException.
 *  - push(x): never fails; the backing array grows when it is full.
 *  - pop(): removes and returns the top; throws NoSuchElementException when empty,
 *    and the stack must still work normally afterwards.
 *  - peek(): returns the top without removing it; throws NoSuchElementException when empty.
 *  - size(), isEmpty().
 *  - toArray(): a copy of the elements from bottom to top, length == size().
 */
public class Day01ArrayStack {
    private int[] data;
    private int size;

    public Day01ArrayStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 0");
        }
        data = new int[initialCapacity];
    }

    public void push(int x) {
        if (size >= data.length) {
            grow();
        }
        data[size++] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return data[--size];
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return data[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    private void grow() {

        int newCapacity = data.length == 0 ? 1 : data.length * 2;
        data = Arrays.copyOf(data, newCapacity );
    }
}
