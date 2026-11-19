package com.prashant.dsa.arrayshashing;

import java.util.Arrays;

/**
 * Valid Anagram (LeetCode 242, NeetCode 150, Arrays & Hashing, problem 2 of 9).
 * Full spec, hints and knowledge checks: tasks/day28.md, "Valid Anagram".
 * Unlocks only after ContainsDuplicate is 17/17 on your pushed code.
 *
 * <h2>Why this problem matters</h2>
 * <p>It is Contains Duplicate's next step: instead of "have I seen x?" you ask
 * "how many times have I seen x?". The senior angle is choosing the counter:
 * a fixed {@code int[26]} versus a {@code HashMap<Character, Integer>} versus sorting,
 * and what breaks when the input stops being plain lowercase English.</p>
 *
 * <h2>The story</h2>
 * <p>A fraud rule in beneficiary onboarding flags a new beneficiary nickname that is a
 * rearranged copy of an existing one ("listen" vs "silent"), a known trick to slip a
 * mule account past a reviewer. Answer one question: does {@code t} use exactly the same
 * letters as {@code s}, each the same number of times?</p>
 *
 * <h2>Worked example</h2>
 * <pre>
 * s = "anagram", t = "nagaram"  ->  true
 * s = "rat",     t = "car"      ->  false  (t has 'c', s has 't')
 * s = "aacc",    t = "ccac"     ->  false  (same letters, different counts)
 * </pre>
 *
 * <h2>Rules the suite enforces</h2>
 * <ul>
 *   <li>{@code null} for either argument throws {@link IllegalArgumentException}.</li>
 *   <li>{@code s} and {@code t} contain only lowercase letters 'a'-'z' (LeetCode's rule).</li>
 *   <li>Two empty strings are anagrams; different lengths never are.</li>
 *   <li>Strings of 1 000 000 characters must finish within 2 seconds.</li>
 * </ul>
 *
 * <p>Before any Java: 3-5 lines of plain-English pseudocode and a brute-force comment,
 * then three comment lines for pattern, time and space, each with one sentence saying
 * where the cost comes from.</p>
 */
public class ValidAnagram {

/*     Pseudocode:
     1. Add freq of each character of a string 1 in the freq array
     2. if the freq of character from a string 2 matched then remove it to previous state
     3. if the freq array contains only 0 in it then it is anagram

     Brute force: compare each character in string 1 with each character in another string2 for containment

     Pattern: convert string to character array
     Time: O(n)
     Space: O(1)
 */

    public boolean isAnagram(String s, String t) {

        if(s == null || t == null ) {
            throw new IllegalArgumentException("either of the strings can not be null");
        }
        if(s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for( int i = 0; i < s.length(); i++ ) {
           freq[s.charAt(i) - 'a']++;
        }
        for( int i = 0; i < t.length(); i++ ) {
            freq[t.charAt(i) - 'a']--;
        }

        for(int i:freq){
            if(i!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("anagram", "nagaram"));   // expected: true
        System.out.println(va.isAnagram("rat", "car"));           // expected: false
    }
}
