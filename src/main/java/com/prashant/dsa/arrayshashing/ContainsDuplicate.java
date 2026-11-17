package com.prashant.dsa.arrayshashing;

/**
 * Contains Duplicate (LeetCode 217, NeetCode 150, Arrays & Hashing, problem 1 of 9).
 * Full spec, approach table and knowledge check: tasks/day26.md, "Contains Duplicate".
 *
 * <h2>Why this problem matters</h2>
 * <p>It is the "hello world" of hashing, but the senior interview is about the trade-off:
 * O(n) time with O(n) extra memory (hash set) versus O(n log n) time with O(1) extra
 * memory (sort), what each costs when the input is 10 million transaction ids, and
 * whether you are allowed to change the caller's array.</p>
 *
 * <h2>The story</h2>
 * <p>A nightly settlement file carries one {@code int} reference per payment. A
 * reference that appears twice means a payment may be settled twice, so the batch is
 * held. Answer one question: does any reference appear more than once?</p>
 *
 * <h2>Worked example</h2>
 * <pre>
 * [1, 2, 3, 1]                    ->  true   (1 appears at index 0 and 3)
 * [1, 2, 3, 4]                    ->  false
 * [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]  ->  true
 * </pre>
 *
 * <h2>Rules the suite enforces</h2>
 * <ul>
 *   <li>{@code null} throws {@link IllegalArgumentException}.</li>
 *   <li>An empty or one-element array has no duplicate ({@code false}).</li>
 *   <li>Values cover the whole {@code int} range, including negatives,
 *       {@code Integer.MIN_VALUE} and {@code Integer.MAX_VALUE}.</li>
 *   <li>The caller's array must <b>not</b> be modified (the batch is still being read
 *       by another step).</li>
 *   <li>1 000 000 distinct values must finish within 2 seconds: no O(n^2) pair check.</li>
 * </ul>
 *
 * <p>Before any Java: 3-5 lines of plain-English pseudocode and a brute-force comment,
 * then three comment lines for pattern, time and space, each with one sentence saying
 * where the cost comes from.</p>
 */
public class ContainsDuplicate {

    // Pseudocode:
    // 1.
    // 2.
    // 3.
    // Brute force:
    //
    // Pattern:
    // Time:
    // Space:

    public boolean containsDuplicate(int[] nums) {
        // TODO(write by hand)
        throw new UnsupportedOperationException("TODO: Contains Duplicate");
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(new int[]{1, 2, 3, 1}));   // expected: true
        System.out.println(cd.containsDuplicate(new int[]{1, 2, 3, 4}));   // expected: false
    }
}
