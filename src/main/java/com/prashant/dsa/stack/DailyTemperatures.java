package com.prashant.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Daily Temperatures (LeetCode 739, NeetCode 150, Stack / monotonic stack).
 * Full spec, hints and the knowledge check: tasks/day15.md, "Daily Temperatures".
 *
 * <h2>Why this problem matters</h2>
 * <p>Interviewers use it to see whether you recognise a "next greater" question when
 * it is dressed as a weather story, and whether you can keep a monotonic stack of
 * <b>indices</b> (not values) so the answer can be written as a distance. At lead
 * level the follow-up is always the same: "what is the amortised cost of each push
 * and pop, and why is the whole pass still O(n)?"</p>
 *
 * <h2>The story</h2>
 * <p>You are given an array {@code temperatures} where {@code temperatures[i]} is
 * the temperature on day {@code i}. For each day, return how many days you have to
 * wait until a warmer temperature. If there is no future day that is warmer, the
 * answer for that day is {@code 0}.</p>
 *
 * <h2>Worked example</h2>
 * <pre>
 * temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
 * answer       = [ 1,  1,  4,  2,  1,  1,  0,  0]
 * </pre>
 * <p>Day 0 (73) warms on day 1 (74) → wait 1. Day 2 (75) does not warm until day 6
 * (76) → wait 4. Days 6 and 7 never see a warmer future day → 0.</p>
 *
 * <h2>Rules the suite enforces</h2>
 * <ul>
 *   <li>Return a new {@code int[]} of the same length; do not mutate the input.</li>
 *   <li>{@code null} input throws {@link IllegalArgumentException}.</li>
 *   <li>An empty input returns a new empty array.</li>
 *   <li>A single day always answers {@code [0]}.</li>
 *   <li>Must finish in O(n) for n = 100 000 (no nested scan of the whole array).</li>
 * </ul>
 *
 * <p>Before any Java: 3-5 lines of plain-English pseudocode, then three comment
 * lines for pattern, time and space, each with one sentence saying where the cost
 * comes from.</p>
 */
public class DailyTemperatures {

// Pattern: Monotonic (decreasing) stack of indices, the "next greater element" pattern.
// Time: O(n), because each index is pushed once and popped at most once, so the inner while loop does O(n) total work across the whole pass.
// Space: O(n), because the stack can hold up to n indices (strictly decreasing input) plus the O(n) answer array.

    /**
     * For each day, how many days until a strictly warmer temperature (0 if none).
     */
    public int[] dailyTemperatures(int[] temperatures) {

        if (temperatures == null) {
            throw new IllegalArgumentException("temperatures must not be null");
        }

        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        return answer;
    }
}
