package com.prashant.dailytests.redo;

import com.prashant.dailytests.Day01ArrayStackContract;

/** Runs the shared Day01ArrayStackContract cases against {@code Day01ArrayStackRedo}. */
class Day01ArrayStackRedoTest extends Day01ArrayStackContract {
    @Override
    protected ArrayStack newStack(int initialCapacity) {
        Day01ArrayStackRedo s = new Day01ArrayStackRedo(initialCapacity);
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
