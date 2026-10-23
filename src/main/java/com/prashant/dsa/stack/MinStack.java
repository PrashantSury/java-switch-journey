package com.prashant.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private final Deque<Integer> main = new ArrayDeque<>();
    private final Deque<Integer> mins = new ArrayDeque<>();

    public void push(int x) {
        main.push(x);

        if (mins.isEmpty()) {
            mins.push(x);
        } else {
            mins.push(Math.min(x, mins.peek()));
        }
    }

    public void pop() {
        if (main.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        main.pop();
        mins.pop();
    }

    public int top() {
        if (main.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return main.peek();
    }

    public int getMin() {
        if (mins.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return mins.peek();
    }
}

