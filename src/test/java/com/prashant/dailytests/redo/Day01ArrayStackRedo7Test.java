package com.prashant.dailytests.redo;

import com.prashant.dailytests.Day01ArrayStackContract;

/** Runs the shared Day01ArrayStackContract cases against {@code Day01ArrayStackRedo7}. */
class Day01ArrayStackRedo7Test extends Day01ArrayStackContract {
    @Override
    protected ArrayStack newStack(int initialCapacity) {
        Day01ArrayStackRedo7 s = new Day01ArrayStackRedo7(initialCapacity);
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
