package com.prashant.dailytests.redo;

import com.prashant.dsa.stack.MinStackContract;

/** Runs the shared MinStackContract cases against {@code MinStackRedoNov01}. */
class MinStackRedoNov01Test extends MinStackContract {
    @Override
    protected Stack newStack() {
        MinStackRedoNov01 s = new MinStackRedoNov01();
        return new Stack() {
            public void push(int x) { s.push(x); }
            public void pop() { s.pop(); }
            public int top() { return s.top(); }
            public int getMin() { return s.getMin(); }
        };
    }
}
