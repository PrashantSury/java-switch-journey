package com.prashant.dailytests.redo;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    private int[] data ;
    private int size ;

    public Day01ArrayStackRedo(int initialCapacity) {
        // TODO(Day 06 redo): write it from memory
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Capacity can not be less than zero " + initialCapacity);
        }
         data = new int[initialCapacity];
    }

    public void push(int x) {
        if(size >= data.length ){
            grow();
        }
       data[size++]=x;
    }

    private void grow() {
        int newCapacity = data.length == 0 ? 1 : data.length* 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    public int pop() {

        if (isEmpty()){
            throw new NoSuchElementException("empty stack");
        }
        return data[--size];
    }

    public int peek() {

        if (isEmpty()){
            throw new NoSuchElementException("empty stack");
        }
        return data[size-1];
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
}
