package com.prashant.dailytests.redo;

/**
 * Cold redo of LeetCode 1209, Remove All Adjacent Duplicates in String II (gap +1 after a
 * conceptual reset on 29 Oct; first redo ever).
 * Write it from memory, in 20-30 minutes, without opening dsa/stack/RemoveKAdjacentDuplicates.
 * Run RemoveKAdjacentDuplicatesRedoNov16Test until all tests pass.
 *
 * Before any code, write three comment lines here: the pattern, the time complexity
 * and the space complexity (one sentence each on where the cost comes from; the 29 Oct
 * quiz missed exactly this "why is it O(n)" sentence).
 *
 * Spec:
 *  - Repeatedly delete k adjacent equal characters, joining the parts, until none are left.
 *  - null s -> IllegalArgumentException; k < 2 -> IllegalArgumentException.
 *  - Case-sensitive. 0 <= s.length() <= 100_000.
 *  - Examples: ("abcd", 2) -> "abcd"; ("deeedbbcccbdaa", 3) -> "aa"; ("pbbcggttciiippooaais", 2) -> "ps".
 */
public class RemoveKAdjacentDuplicatesRedoNov16 {

    public String removeDuplicates(String s, int k) {
        throw new UnsupportedOperationException("TODO");
    }
}
