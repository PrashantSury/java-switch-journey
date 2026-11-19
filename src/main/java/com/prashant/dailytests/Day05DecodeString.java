package com.prashant.dailytests;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 05 fix-the-buggy-code round: decode a run-length template (two stacks).
 * This class has bugs. Run Day05DecodeStringTest, read the failing tests,
 * then make the smallest fixes until every test passes. Don't rewrite it.
 * Full expected behaviour and test groups: tasks/day26.md, "Day05DecodeString".
 *
 * Spec:
 *  - decode(s) expands every k[body] into body repeated k times, from the inside out:
 *        "3[a]2[bc]"      -> "aaabcbc"
 *        "3[a2[c]]"       -> "accaccacc"
 *        "2[abc]3[cd]ef"  -> "abcabccdcdcdef"
 *  - k is a non-negative whole number written in decimal, and can have several digits
 *    ("10[a]" is ten a's, "0[x]" is the empty string). k is always followed by '['.
 *  - Letters (a-z, A-Z) are copied as they are, in order; text before, between and
 *    after the brackets keeps its position.
 *  - The empty string decodes to the empty string; "2[]" decodes to "".
 *  - null, a ']' with no open '[' before it, or a '[' that is never closed throws
 *    IllegalArgumentException.
 *  - The decoded text may be at most 1 000 000 characters (MAX_OUTPUT). A template that
 *    would expand past that throws IllegalArgumentException before the big string is
 *    built (a "template bomb" like "1000[1000[1000[a]]]" must not exhaust the heap).
 *  - Must run in time proportional to the input plus the output.
 */
public class Day05DecodeString {

    static final int MAX_OUTPUT = 1_000_000;

    public static String decode(String s) {
        if (s == null) {
            throw new IllegalArgumentException("input must not be null");
        }
        Deque<Integer> counts = new ArrayDeque<>();        // repeat count of each open '['
        Deque<StringBuilder> outers = new ArrayDeque<>();  // text built before each open '['
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                k = (int) Math.min(k * 10L + (c - '0'), MAX_OUTPUT + 1L);
            } else if (c == '[') {
                counts.push(k);
                k = 0;
                outers.push(current);
                current = new StringBuilder();
            } else if (c == ']') {
                if (counts.isEmpty()) {
                    throw new IllegalArgumentException("unmatched ']' at index " + i);
                }
                int times = counts.pop();
                StringBuilder outer = outers.pop();
                if ((long) current.length() * times + outer.length() > MAX_OUTPUT) {
                    throw new IllegalArgumentException("decoded text longer than " + MAX_OUTPUT);
                }
                outer.append(current.toString().repeat(times));
                current = outer;
            } else {
                current.append(c);
            }
        }
        if (!counts.isEmpty()) {
            throw new IllegalArgumentException("unclosed '[' in input");
        }
        return current.toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("a0[bc]d"));   // expected: ad
        System.out.println(decode("3[a2[c]]"));    // expected: accaccacc
    }
}
