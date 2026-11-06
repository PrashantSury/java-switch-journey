package com.prashant.dsa.stack;

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

    // Pattern:
    // Time:
    // Space:

    /**
     * For each day, how many days until a strictly warmer temperature (0 if none).
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // TODO: implement
        throw new UnsupportedOperationException("TODO");
    }
}
