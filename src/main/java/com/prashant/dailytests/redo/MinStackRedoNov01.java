package com.prashant.dailytests.redo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Cold redo of LeetCode 155, Min Stack (gap +1, first redo since 23 Oct).
 * Write it from memory, in 20-30 minutes, without opening dsa/stack/MinStack.
 * Run MinStackRedoNov01Test until all tests pass.
 *
 * Before any code, write three comment lines here: the pattern, the time complexity
 * and the space complexity (one sentence each on where the cost comes from).
 *
 * Spec:
 *  - Design a stack that supports push, pop, top and getMin in O(1) worst case.
 *  - getMin returns the smallest value currently on the stack.
 *  - pop / top / getMin on an empty stack throw IllegalStateException.
 *  - Values may be Integer.MIN_VALUE, Integer.MAX_VALUE, 0, negatives, duplicates.
 *  - Expected: push(-2), push(0), push(-3) → getMin()=-3; pop(); top()=0; getMin()=-2.
 */
public class MinStackRedoNov01 {

// Pattern: Auxiliary (parallel) stack that stores the running minimum at each depth, so getMin never has to scan.
// Time: O(1) per operation, because push, pop, top and getMin each do a constant number of deque calls (push/pop/peek) and one Math.min.
// Space: O(n) total, because there are two stacks and each holds at most one entry per pushed element, so 2n entries, which is still O(n).

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
