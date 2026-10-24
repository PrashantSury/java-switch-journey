package com.prashant.dsa.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidCollisionTest {
    private AsteroidCollision sol;

    @BeforeEach
    void setUp() { sol = new AsteroidCollision(); }

    private void check(int[] expected, int[] input) {
        assertArrayEquals(expected, sol.asteroidCollision(input), () -> "input " + Arrays.toString(input));
    }

    @Test @DisplayName("normal: LeetCode example 1, small left-mover explodes")
    void example1() { check(new int[]{5, 10}, new int[]{5, 10, -5}); }

    @Test @DisplayName("normal: LeetCode example 2, equal sizes destroy each other")
    void example2() { check(new int[]{}, new int[]{8, -8}); }

    @Test @DisplayName("normal: LeetCode example 3, left-mover destroys one then dies")
    void example3() { check(new int[]{10}, new int[]{10, 2, -5}); }

    @Test @DisplayName("normal: LeetCode example 4, moving apart never collide")
    void example4() { check(new int[]{-2, -1, 1, 2}, new int[]{-2, -1, 1, 2}); }

    @Test @DisplayName("edge: null input throws IllegalArgumentException")
    void nullInput() { assertThrows(IllegalArgumentException.class, () -> sol.asteroidCollision(null)); }

    @Test @DisplayName("edge: zero-sized asteroid throws IllegalArgumentException")
    void zeroValue() { assertThrows(IllegalArgumentException.class, () -> sol.asteroidCollision(new int[]{3, 0, -2})); }

    @Test @DisplayName("edge: empty array returns empty array (not null)")
    void empty() { check(new int[]{}, new int[]{}); }

    @Test @DisplayName("edge: single right-moving asteroid survives")
    void singlePositive() { check(new int[]{7}, new int[]{7}); }

    @Test @DisplayName("edge: single left-moving asteroid survives")
    void singleNegative() { check(new int[]{-7}, new int[]{-7}); }

    @Test @DisplayName("edge: all moving right, nothing collides")
    void allRight() { check(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}); }

    @Test @DisplayName("edge: all moving left, nothing collides")
    void allLeft() { check(new int[]{-4, -3, -2, -1}, new int[]{-4, -3, -2, -1}); }

    @Test @DisplayName("edge: left-mover before right-mover never meet")
    void leftThenRight() { check(new int[]{-5, 5}, new int[]{-5, 5}); }

    @Test @DisplayName("chain: big left-mover destroys every right-mover in the stack")
    void bigLeftDestroysAll() { check(new int[]{-10}, new int[]{1, 2, 3, 4, -10}); }

    @Test @DisplayName("chain: left-mover destroys some, then ties and both explode")
    void destroySomeThenTie() { check(new int[]{1}, new int[]{1, 5, 2, 3, -5}); }

    @Test @DisplayName("chain: left-mover destroys some, then is destroyed by a bigger one")
    void destroySomeThenDies() { check(new int[]{9}, new int[]{9, 2, 3, -5}); }

    @Test @DisplayName("tie: equal pair explodes, next left-mover hits the earlier one")
    void tieThenNextHits() { check(new int[]{-3}, new int[]{2, 4, -4, -3}); }

    @Test @DisplayName("survivor: after destroying everything, the left-mover stays in place before later ones")
    void survivorOrder() { check(new int[]{-6, -1, 2}, new int[]{3, -6, -1, 2}); }

    @Test @DisplayName("duplicates: repeated equal pairs all cancel")
    void repeatedPairs() { check(new int[]{}, new int[]{5, -5, 5, -5, 5, -5}); }

    @Test @DisplayName("duplicates: several same-size right-movers, one left-mover only kills one")
    void sameSizeRightMovers() { check(new int[]{4, 4}, new int[]{4, 4, 4, -4}); }

    @Test @DisplayName("nested: alternating collisions collapse inside-out")
    void nested() { check(new int[]{}, new int[]{1, 2, 3, -3, -2, -1}); }

    @Test @DisplayName("overflow: MAX_VALUE vs -MAX_VALUE is a tie")
    void maxTie() { check(new int[]{}, new int[]{Integer.MAX_VALUE, -Integer.MAX_VALUE}); }

    @Test @DisplayName("overflow: MIN_VALUE (size 2^31) beats MAX_VALUE")
    void minBeatsMax() { check(new int[]{Integer.MIN_VALUE}, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}); }

    @Test @DisplayName("overflow: MIN_VALUE wipes out a stack of big right-movers")
    void minWipesStack() {
        check(new int[]{Integer.MIN_VALUE, 1},
              new int[]{Integer.MAX_VALUE, 1_000_000_000, Integer.MAX_VALUE - 1, Integer.MIN_VALUE, 1});
    }

    @Test @DisplayName("overflow: MAX_VALUE survives a small left-mover")
    void maxSurvives() { check(new int[]{Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE, -1}); }

    @Test @DisplayName("boundary: size 1 asteroids collide like any other")
    void sizeOne() { check(new int[]{}, new int[]{1, -1}); }

    @Test @DisplayName("input array is not modified")
    void inputUnchanged() {
        int[] in = {5, 10, -5};
        sol.asteroidCollision(in);
        assertArrayEquals(new int[]{5, 10, -5}, in);
    }

    @Test @DisplayName("large: 100_000 right-movers then one huge left-mover, O(n) within 1s")
    void largeWipeout() {
        int n = 100_000;
        int[] in = new int[n + 1];
        Arrays.fill(in, 0, n, 1);
        in[n] = -2;
        int[] out = assertTimeoutPreemptively(Duration.ofSeconds(1), () -> sol.asteroidCollision(in));
        assertArrayEquals(new int[]{-2}, out);
    }

    @Test @DisplayName("large: 50_000 equal pairs alternating all cancel within 1s")
    void largeAlternating() {
        int n = 100_000;
        int[] in = new int[n];
        for (int i = 0; i < n; i++) in[i] = (i % 2 == 0) ? 7 : -7;
        int[] out = assertTimeoutPreemptively(Duration.ofSeconds(1), () -> sol.asteroidCollision(in));
        assertEquals(0, out.length);
    }
}
