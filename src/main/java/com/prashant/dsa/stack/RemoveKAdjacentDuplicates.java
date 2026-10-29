package com.prashant.dsa.stack;

import java.beans.PropertyEditorManager;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 01 DSA (Stack): Remove All Adjacent Duplicates in String II (LeetCode 1209).
 *
 * You are given a string s and an integer k. A "k duplicate removal" picks k adjacent,
 * equal characters and deletes them, joining the left and right parts together.
 * Keep doing removals until no more are possible, and return the final string.
 * The answer is unique.
 *
 * Rules for this repo:
 *  - If s is null, throw IllegalArgumentException.
 *  - If k < 2, throw IllegalArgumentException.
 *  - Characters are case-sensitive ('a' and 'A' are different).
 *
 * Constraints: 0 <= s.length() <= 100_000, any characters. Aim for O(n) time.
 *
 * Examples:
 *  ("abcd", 2)                 -> "abcd"
 *  ("deeedbbcccbdaa", 3)       -> "aa"
 *  ("pbbcggttciiippooaais", 2) -> "ps"
 */
public class RemoveKAdjacentDuplicates {

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
