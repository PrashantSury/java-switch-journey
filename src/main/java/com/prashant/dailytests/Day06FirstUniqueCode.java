package com.prashant.dailytests;

/**
 * Day 06 buggy round (Friday, Arrays &amp; Hashing: frequency counting).
 * Full spec, rules table and test groups: tasks/day29.md, "Friday buggy round".
 *
 * <h2>The story</h2>
 * <p>Every settlement batch in a nightly file is tagged with one lowercase letter, its
 * clearing-house code. A code that appears exactly once means that batch has no matching
 * counter-batch, so an analyst must look at it first. Return the <b>position</b> (index in
 * the string) of the first batch, reading left to right, whose code appears exactly once
 * in the whole file. If every code repeats, return -1.</p>
 *
 * <h2>Examples</h2>
 * <pre>
 * "leetcode"      ->  0    ('l' appears once and it is the leftmost such code)
 * "loveleetcode"  ->  2    ('v' is the leftmost code that appears once)
 * "aabb"          -> -1    (every code repeats)
 * ""              -> -1    (no batches)
 * </pre>
 *
 * <h2>Rules</h2>
 * <ul>
 *   <li>{@code null} throws {@link IllegalArgumentException}.</li>
 *   <li>Only lowercase 'a'-'z' are valid codes; any other character throws
 *       {@link IllegalArgumentException}.</li>
 *   <li>"First" means the smallest index in the string, not the first letter of the
 *       alphabet.</li>
 *   <li>1 000 000 codes must finish within 1 second.</li>
 * </ul>
 *
 * <p>The code compiles. Some tests fail. Fix it with the smallest changes; don't rewrite.</p>
 */
public class Day06FirstUniqueCode {

    public int firstUniqueIndex(String codes) {
        if (codes == null) {
            throw new IllegalArgumentException("codes must not be null");
        }

        int[] count = new int[26];
        for (int i = 0; i < codes.length(); i++) {
            char c = codes.charAt(i);
            if (c < 'a' || c > 'z') {
                throw new IllegalArgumentException("invalid code '" + c + "' at index " + i);
            }
        }

        for (int i = 0; i < codes.length(); i++) {
            count[codes.charAt(i) - 'a']++;
        }

        for (int letter = 0; letter < codes.length(); letter++) {
            if (count[codes.charAt(letter) - 'a'] == 1) {
                return letter;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Day06FirstUniqueCode d = new Day06FirstUniqueCode();
        System.out.println(d.firstUniqueIndex("loveleetcode"));   // expected: 2
        System.out.println(d.firstUniqueIndex("aabb"));           // expected: -1
    }
}
