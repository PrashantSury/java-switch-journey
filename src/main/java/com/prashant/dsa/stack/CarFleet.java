package com.prashant.dsa.stack;

/**
 * Car Fleet (LeetCode 853, NeetCode 150, Stack), with extra rules.
 * Full spec, hints and the knowledge check: tasks/day09.md, "Car Fleet".
 *
 * <h2>Why this problem matters</h2>
 * <p>Interviewers use it to see whether you can turn a story about moving things into a clean
 * ordering problem, and whether you can compare two quantities exactly when a plain division
 * would lose information. At lead level the second part is the real test: "why not just
 * use double?" is a follow-up you should expect.</p>
 *
 * <h2>The story</h2>
 * <p>n cars drive along a one-lane road towards {@code target}. Car i starts at
 * {@code position[i]} (miles) and drives at {@code speed[i]} (miles per hour). A car can never
 * pass the car ahead of it. When a faster car catches a slower one, it slows down and they drive
 * on together as one <b>fleet</b>, at the speed of the slowest car in it. A single car is also a
 * fleet. A car that catches a fleet exactly at the target still counts as part of that fleet.
 * Return the number of fleets that arrive at the target.</p>
 *
 * <h2>Worked example</h2>
 * <p>{@code target = 12}, cars in input order (the input is not sorted by position):</p>
 * <pre>
 * | car | position | speed | miles to go |
 * |-----|----------|-------|-------------|
 * | A   | 10       | 2     | 2           |
 * | B   | 8        | 4     | 4           |
 * | C   | 0        | 1     | 12          |
 * | D   | 5        | 1     | 7           |
 * | E   | 3        | 3     | 9           |
 * </pre>
 * <p>Result: <b>3</b> fleets. B is faster than A, but A is ahead of it, so B cannot pass: B and A
 * reach the target together and count as one fleet (meeting exactly at the target counts). E is
 * stuck behind D and joins it (second fleet). C is the slowest car, at the back, and arrives
 * alone (third fleet). The result is a count of arrivals, not of cars.</p>
 *
 * <h2>Rules for this repo</h2>
 * <pre>
 * | situation                                          | required behaviour             |
 * |----------------------------------------------------|--------------------------------|
 * | position or speed is null                          | IllegalArgumentException       |
 * | position.length != speed.length                    | IllegalArgumentException       |
 * | no cars (both arrays empty)                        | return 0                       |
 * | target &lt;= 0                                        | IllegalArgumentException       |
 * | a position outside 0 &lt;= position[i] &lt; target       | IllegalArgumentException       |
 * | a speed &lt;= 0                                       | IllegalArgumentException       |
 * | two cars with the same starting position           | IllegalArgumentException       |
 * | the input arrays                                   | must NOT be modified           |
 * | comparing arrival times                            | EXACT (no rounding error)      |
 * </pre>
 *
 * <h2>Examples</h2>
 * <pre>
 * | target | position        | speed          | result | what it means                          |
 * |--------|-----------------|----------------|--------|----------------------------------------|
 * | 12     | [10, 8, 0, 5, 3]| [2, 4, 1, 1, 3]| 3      | the worked example above               |
 * | 10     | [3]             | [3]            | 1      | a single car is a fleet                |
 * | 100    | [0, 2, 4]       | [4, 2, 1]      | 1      | the slowest car in front holds all     |
 * | 10     | [6, 8]          | [3, 2]         | 2      | the rear car just misses the front one |
 * | 10     | [0, 5]          | [2, 1]         | 1      | they meet exactly at the target        |
 * </pre>
 *
 * <h2>Constraints</h2>
 * <p>{@code 0 <= n <= 100_000}, {@code 1 <= target <= Integer.MAX_VALUE},
 * {@code 1 <= speed[i] <= Integer.MAX_VALUE}. Aim for O(n log n) time.</p>
 *
 * <h2>Knowledge check (answers are in tasks/day09.md, under "Open only after your attempt")</h2>
 * <ol>
 *   <li>Two cars arrive at exactly the same time. How many fleets are they?
 *       (a) 1 &nbsp; (b) 2 &nbsp; (c) it depends on their speeds &nbsp; (d) it depends on their positions</li>
 *   <li>Car X is behind car Y, and X would arrive earlier than Y if the road were empty. What
 *       happens? (a) X passes Y &nbsp; (b) X catches Y and they arrive as one fleet at Y's pace
 *       &nbsp; (c) X stops and waits at the target &nbsp; (d) they count as two fleets</li>
 *   <li>Why is {@code (double) (target - position[i]) / speed[i]} risky for this problem?
 *       (a) it is slow &nbsp; (b) two different exact times can look equal after rounding
 *       &nbsp; (c) it throws on large values &nbsp; (d) it is not allowed in Java</li>
 * </ol>
 */
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        // TODO: implement
        return 0;
    }
}
