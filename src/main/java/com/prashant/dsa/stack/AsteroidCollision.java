package com.prashant.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 02 DSA (Stack): Asteroid Collision (LeetCode 735).
 *
 * You are given an array of integers representing asteroids in a row.
 * The absolute value is the asteroid's size, and the sign is its direction
 * (positive = moving right, negative = moving left). All asteroids move at the same speed.
 *
 * When two asteroids meet, the smaller one explodes. If both are the same size,
 * both explode. Two asteroids moving in the same direction never meet, and a
 * left-moving asteroid on the left never meets a right-moving one on its right.
 * Return the state of the asteroids after all collisions, in their original order.
 *
 * Rules for this repo:
 *  - If asteroids is null, throw IllegalArgumentException.
 *  - If any value is 0, throw IllegalArgumentException.
 *  - Do not modify the input array.
 *  - Values can be anywhere in the int range, including Integer.MIN_VALUE and
 *    Integer.MAX_VALUE. Careful: Math.abs(Integer.MIN_VALUE) is still negative,
 *    and -Integer.MIN_VALUE overflows. Size of MIN_VALUE is 2147483648, which is
 *    bigger than MAX_VALUE (2147483647).
 *
 * Constraints: 0 <= asteroids.length <= 100_000. Aim for O(n) time.
 *
 * Examples:
 *  [5, 10, -5]      -> [5, 10]
 *  [8, -8]          -> []
 *  [10, 2, -5]      -> [10]
 *  [-2, -1, 1, 2]   -> [-2, -1, 1, 2]
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            throw new IllegalArgumentException("asteroids must not be null");
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            if (a == 0) {
                throw new IllegalArgumentException("asteroid value must not be 0");
            }

            boolean alive = true;
            if (a < 0) {
                long size = -(long) a;                       // safe for Integer.MIN_VALUE
                while (alive && !stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.peek();
                    if (top < size) {
                        stack.pop();                         // top explodes, keep fighting
                    } else {
                        if (top == size) {
                            stack.pop();                     // both explode
                        }
                        alive = false;                       // a explodes
                    }
                }
            }
            if (alive) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        int i = result.length - 1;
        for (int x : stack) {                                // iterates top -> bottom
            result[i--] = x;
        }
        return result;
    }
}
