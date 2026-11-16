package com.prashant.dailytests.redo;

import java.util.ArrayDeque;
import java.util.Deque;

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

    // pattern: stack used here to count the frequencies of the characters
    // time: O(n)
    // space: O(n)
    public String removeDuplicates(String s, int k) {
        if (s == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (k < 2) {
            throw new IllegalArgumentException("k must be at least 2");
        }

        Deque<Pair> pairs = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!pairs.isEmpty() && pairs.peekLast().character == ch) {
                Pair top = pairs.peekLast();
                top.count++;
                if (top.count == k) {
                    pairs.removeLast();
                }
            } else {
                pairs.addLast(new Pair(ch));
            }
        }

        StringBuilder result = new StringBuilder(s.length());
        for (Pair pair : pairs) {
            for (int i = 0; i < pair.count; i++) {
                result.append(pair.character);
            }
        }
        return result.toString();
    }

    /** One adjacent pair still on the stack: the character and how many times it repeats. */
    private static final class Pair {
        private final char character;
        private int count;

        private Pair(char character) {
            this.character = character;
            this.count = 1;
        }
    }
}
