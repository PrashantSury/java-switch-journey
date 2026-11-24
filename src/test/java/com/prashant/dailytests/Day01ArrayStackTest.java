package com.prashant.dailytests;


/** Runs the shared Day01ArrayStackContract cases against {@code Day01ArrayStack}. */
class Day01ArrayStackTest extends Day01ArrayStackContract {
    @Override
    protected ArrayStack newStack(int initialCapacity) {
        Day01ArrayStack s = new Day01ArrayStack(initialCapacity);
        return new ArrayStack() {
            public void push(int x) { s.push(x); }
            public int pop() { return s.pop(); }
            public int peek() { return s.peek(); }
            public int size() { return s.size(); }
            public boolean isEmpty() { return s.isEmpty(); }
            public int[] toArray() { return s.toArray(); }
        };
    }
}
