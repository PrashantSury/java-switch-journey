package com.prashant.dailytests.redo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Day01ArrayStackRedo7Test {

    @Test @DisplayName("new stack is empty with size 0")
    void newStackIsEmpty() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(4);
        assertTrue(st.isEmpty());
        assertEquals(0, st.size());
        assertArrayEquals(new int[0], st.toArray());
    }

    @Test @DisplayName("normal: push then pop returns elements in LIFO order")
    void lifoOrder() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(4);
        st.push(1); st.push(2); st.push(3);
        assertEquals(3, st.pop());
        assertEquals(2, st.pop());
        assertEquals(1, st.pop());
        assertTrue(st.isEmpty());
    }

    @Test @DisplayName("normal: peek returns top without removing it")
    void peekDoesNotRemove() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(4);
        st.push(7);
        assertEquals(7, st.peek());
        assertEquals(7, st.peek());
        assertEquals(1, st.size());
    }

    @Test @DisplayName("edge: pop on an empty stack throws NoSuchElementException")
    void popEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> new Day01ArrayStackRedo7(4).pop());
    }

    @Test @DisplayName("edge: peek on an empty stack throws NoSuchElementException")
    void peekEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> new Day01ArrayStackRedo7(4).peek());
    }

    @Test @DisplayName("edge: pop after the stack is emptied again throws NoSuchElementException")
    void popAfterEmptiedThrows() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(2);
        st.push(1);
        st.pop();
        assertThrows(NoSuchElementException.class, st::pop);
    }

    @Test @DisplayName("edge: a failed pop leaves size at 0 and the stack still usable")
    void failedPopKeepsStateValid() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(2);
        assertThrows(NoSuchElementException.class, st::pop);
        assertEquals(0, st.size());
        assertTrue(st.isEmpty());
        st.push(5);
        assertEquals(1, st.size());
        assertEquals(5, st.peek());
    }

    @Test @DisplayName("boundary: filling exactly to initial capacity works")
    void fillToCapacity() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(3);
        st.push(1); st.push(2); st.push(3);
        assertEquals(3, st.size());
        assertArrayEquals(new int[]{1, 2, 3}, st.toArray());
    }

    @Test @DisplayName("boundary: pushing one past initial capacity grows the array")
    void pushPastCapacity() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(3);
        for (int i = 1; i <= 4; i++) st.push(i);
        assertEquals(4, st.size());
        assertEquals(4, st.peek());
        assertArrayEquals(new int[]{1, 2, 3, 4}, st.toArray());
    }

    @Test @DisplayName("boundary: initial capacity 1 grows correctly over many pushes")
    void capacityOne() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(1);
        for (int i = 0; i < 10; i++) st.push(i);
        assertEquals(10, st.size());
        for (int i = 9; i >= 0; i--) assertEquals(i, st.pop());
    }

    @Test @DisplayName("edge: initial capacity 0 is allowed and push still works")
    void capacityZero() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(0);
        st.push(42);
        st.push(43);
        assertEquals(2, st.size());
        assertEquals(43, st.pop());
        assertEquals(42, st.pop());
    }

    @Test @DisplayName("invalid: negative capacity throws IllegalArgumentException")
    void negativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Day01ArrayStackRedo7(-1));
    }

    @Test @DisplayName("values: negatives, zero, Integer.MIN_VALUE and MAX_VALUE are stored exactly")
    void extremeValues() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(2);
        st.push(Integer.MIN_VALUE); st.push(-1); st.push(0); st.push(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, st.pop());
        assertEquals(0, st.pop());
        assertEquals(-1, st.pop());
        assertEquals(Integer.MIN_VALUE, st.pop());
    }

    @Test @DisplayName("values: duplicates are kept as separate elements")
    void duplicates() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(2);
        st.push(5); st.push(5); st.push(5);
        assertEquals(3, st.size());
        assertArrayEquals(new int[]{5, 5, 5}, st.toArray());
    }

    @Test @DisplayName("normal: interleaved pushes and pops keep the right order")
    void interleaved() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(2);
        st.push(1); st.push(2);
        assertEquals(2, st.pop());
        st.push(3); st.push(4);
        assertEquals(4, st.pop());
        assertEquals(3, st.pop());
        assertEquals(1, st.peek());
        assertEquals(1, st.size());
    }

    @Test @DisplayName("toArray returns a copy: changing it does not change the stack")
    void toArrayIsCopy() {
        Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(4);
        st.push(1); st.push(2);
        int[] arr = st.toArray();
        arr[1] = 99;
        assertEquals(2, st.peek());
    }

    @Test @DisplayName("large: 1,000,000 pushes and pops from capacity 1, within 2 seconds")
    void largeInput() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            Day01ArrayStackRedo7 st = new Day01ArrayStackRedo7(1);
            for (int i = 0; i < 1_000_000; i++) st.push(i);
            assertEquals(1_000_000, st.size());
            for (int i = 999_999; i >= 0; i--) assertEquals(i, st.pop());
            assertTrue(st.isEmpty());
        });
    }
}
