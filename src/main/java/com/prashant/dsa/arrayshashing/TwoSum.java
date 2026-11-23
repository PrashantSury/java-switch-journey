package com.prashant.dsa.arrayshashing;

import java.util.HashMap;
import java.util.Map;
/**
 * Two Sum (LeetCode 1, NeetCode 150, Arrays &amp; Hashing, problem 3 of 9).
 * Full spec, hints and knowledge checks: tasks/day29.md, "Two Sum".
 *
 * <h2>Why this problem matters</h2>
 * <p>Contains Duplicate remembered <i>whether</i> you had seen a value. Valid Anagram
 * remembered <i>how many times</i>. Two Sum remembers <i>where</i>: a map from value to
 * index. "Store what you've seen so the partner can be found in O(1)" is the move behind
 * half of the hashing questions you will be asked, and the senior follow-ups are about
 * memory, duplicates and overflow, not about the loop.</p>
 *
 * <h2>The story</h2>
 * <p>A customer disputes one card charge. Reconciliation has the list of pending
 * authorisation amounts (in paise) and the disputed total. Find the two authorisations
 * that add up to exactly that total, and return their positions so the analyst can pull
 * both records.</p>
 *
 * <h2>Worked example</h2>
 * <pre>
 * nums = [2, 7, 11, 15], target = 9   ->  [0, 1]   (2 + 7)
 * nums = [3, 2, 4],      target = 6   ->  [1, 2]   (2 + 4, NOT [0, 0]: one element can't be used twice)
 * nums = [3, 3],         target = 6   ->  [0, 1]
 * </pre>
 *
 * <h2>Rules the suite enforces</h2>
 * <ul>
 *   <li>{@code null} throws {@link IllegalArgumentException}.</li>
 *   <li>Return the two indices in ascending order: {@code [i, j]} with {@code i < j}.</li>
 *   <li>Each test with an answer has exactly one valid pair. If no pair exists (including
 *       an empty or one-element array), throw {@link IllegalArgumentException}.</li>
 *   <li>Values and target cover the whole {@code int} range: the sum must be exact
 *       (a sum that only "matches" after int overflow wraps around is not a pair).</li>
 *   <li>The caller's array must <b>not</b> be modified.</li>
 *   <li>1 000 000 values must finish within 2 seconds: no O(n^2) pair check.</li>
 * </ul>
 *
 * <p>Before any Java: 3-5 lines of plain-English pseudocode and a brute-force comment,
 * then three comment lines for pattern, time and space, each with a "because" saying
 * where the cost comes from.</p>
 */
public class TwoSum {

/**
 1. Create an empty map of value -> index.
 2. For each index i, compute complement = target - nums[i] (as long, to avoid overflow).
 3. If the complement is in the map, return [map.get(complement), i].
 4. Otherwise, store nums[i] -> i in the map and continue.
 5. If the loop ends with no pair found, throw IllegalArgumentException.

 Brute force: check every pair (i, j), about n^2/2 = 5 * 10^11 checks for
 n = 1 000 000, because every element is compared with every later element.

 Pattern: Hash map (remember what you've seen so the partner is found in O(1)).
 Time:  O(n) because each element is visited once and map get/put are O(1) on average.
 Space: O(n) because in the worst case every element ends up in the map.
 */

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }

        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long complement = (long) target - nums[i];
            if (complement >= Integer.MIN_VALUE && complement <= Integer.MAX_VALUE) {
                Integer j = seen.get((int) complement);
                if (j != null) {
                    return new int[]{j, i};     // j < i, so ascending order
                }
            }
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two elements add up to " + target);
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        System.out.println(java.util.Arrays.toString(ts.twoSum(new int[]{2, 7, 11, 15}, 9)));   // expected: [0, 1]
        System.out.println(java.util.Arrays.toString(ts.twoSum(new int[]{3, 2, 4}, 6)));        // expected: [1, 2]
    }
}
