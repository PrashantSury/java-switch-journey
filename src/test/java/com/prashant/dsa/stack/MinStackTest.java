package com.prashant.dsa.stack;


/** Runs the shared MinStackContract cases against {@code MinStack}. */
class MinStackTest extends MinStackContract {
    @Override
    protected Stack newStack() {
        MinStack s = new MinStack();
        return new Stack() {
            public void push(int x) { s.push(x); }
            public void pop() { s.pop(); }
            public int top() { return s.top(); }
            public int getMin() { return s.getMin(); }
        };
    }
}
