package com.prashant.dsa.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {
    private MinStack st;

    @BeforeEach
    void setUp() { st = new MinStack(); }

    @Test @DisplayName("normal: LeetCode example")
    void leetcodeExample() {
        st.push(-2); st.push(0); st.push(-3);
        assertEquals(-3, st.getMin());
        st.pop();
        assertEquals(0, st.top());
        assertEquals(-2, st.getMin());
    }

    @Test @DisplayName("edge: single element is both top and min")
    void single() {
        st.push(5);
        assertEquals(5, st.top());
        assertEquals(5, st.getMin());
    }

    @Test @DisplayName("edge: duplicate minimums survive one pop")
    void duplicateMins() {
        st.push(2); st.push(1); st.push(1);
        st.pop();
        assertEquals(1, st.getMin());
        st.pop();
        assertEquals(2, st.getMin());
    }

    @Test @DisplayName("edge: increasing pushes keep first as min")
    void increasing() {
        for (int i = 1; i <= 5; i++) st.push(i);
        assertEquals(1, st.getMin());
        assertEquals(5, st.top());
    }

    @Test @DisplayName("edge: decreasing pushes, min restored on each pop")
    void decreasing() {
        for (int i = 5; i >= 1; i--) st.push(i);
        for (int expected = 1; expected <= 5; expected++) {
            assertEquals(expected, st.getMin());
            st.pop();
        }
    }

    @Test @DisplayName("edge: Integer.MIN_VALUE and MAX_VALUE")
    void extremes() {
        st.push(Integer.MAX_VALUE);
        st.push(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, st.getMin());
        st.pop();
        assertEquals(Integer.MAX_VALUE, st.getMin());
    }

    @Test @DisplayName("edge: zero and negatives")
    void zeroAndNegatives() {
        st.push(0); st.push(-1); st.push(0);
        assertEquals(-1, st.getMin());
        assertEquals(0, st.top());
    }

    @Test @DisplayName("edge: reuse after emptying")
    void reuseAfterEmpty() {
        st.push(3); st.pop();
        st.push(7);
        assertEquals(7, st.getMin());
        assertEquals(7, st.top());
    }

    @Test @DisplayName("edge: empty stack throws on pop/top/getMin")
    void emptyThrows() {
        assertThrows(IllegalStateException.class, () -> st.pop());
        assertThrows(IllegalStateException.class, () -> st.top());
        assertThrows(IllegalStateException.class, () -> st.getMin());
    }

    @Test @DisplayName("large input: 100,000 pushes and pops")
    void large() {
        for (int i = 100_000; i > 0; i--) st.push(i);
        assertEquals(1, st.getMin());
        for (int i = 0; i < 99_999; i++) st.pop();
        assertEquals(100_000, st.getMin());
    }
}
