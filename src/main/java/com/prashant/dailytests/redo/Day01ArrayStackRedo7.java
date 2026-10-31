package com.prashant.dailytests.redo;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    private int[] array;
    private int size;

    public Day01ArrayStackRedo7(int initialCapacity) {

        if(initialCapacity<0){
            throw new IllegalArgumentException("Illegal Capacity"+initialCapacity);
        }
        array = new int[initialCapacity];
    }

    public void push(int x) {
       if(size >= array.length){
           grow();
       }
       array[size++] = x;
    }

    private void grow() {
       int newCapacity= array.length == 0 ? 1 : array.length * 2;
        array = Arrays.copyOf(array,newCapacity);
    }

    public int pop() {

        if(isEmpty()){
            throw new NoSuchElementException("Stack is Empty");
        }

        return array[--size];
    }

    public int peek() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack is Empty");
        }
        return array[size-1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int[] toArray() {
        return Arrays.copyOf(array,size);
    }
}
