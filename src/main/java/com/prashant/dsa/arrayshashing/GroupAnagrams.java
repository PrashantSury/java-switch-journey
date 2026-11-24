package com.prashant.dsa.arrayshashing;

import java.util.List;

/**
 * Group Anagrams (LeetCode 49, NeetCode 150, Arrays &amp; Hashing, problem 4 of 9).
 * Full spec, hints and knowledge checks: tasks/day33.md, "Group Anagrams".
 *
 * <h2>Why this problem matters</h2>
 * <p>Valid Anagram compared <i>two</i> strings. Group Anagrams compares <i>n</i> strings
 * with each other, and you can't afford to compare every pair. The move is to turn each
 * string into a <b>key</b> (a fingerprint) so that anagrams share a key and non-anagrams
 * never do, then let a {@code HashMap<key, list>} do the grouping. The senior part is the
 * key: what it costs to build, and whether it ever lets two different strings collide.</p>
 *
 * <h2>The story</h2>
 * <p>Beneficiary onboarding again. The fraud team wants every batch of new beneficiary
 * nicknames bucketed so that rearranged copies ("listen", "silent", "enlist") land in the
 * same bucket for one reviewer. Return the buckets.</p>
 *
 * <h2>Worked example</h2>
 * <pre>
 * ["eat","tea","tan","ate","nat","bat"]  ->  [["eat","tea","ate"], ["tan","nat"], ["bat"]]
 * [""]                                   ->  [[""]]
 * ["a"]                                  ->  [["a"]]
 * </pre>
 *
 * <h2>Rules the suite enforces</h2>
 * <ul>
 *   <li>{@code null} array, or a {@code null} element, throws {@link IllegalArgumentException}.</li>
 *   <li>Strings contain only lowercase letters 'a'-'z'; any other character throws
 *       {@link IllegalArgumentException}. The empty string is valid.</li>
 *   <li>Groups may come back in <b>any order</b>, and words inside a group in any order.</li>
 *   <li>Every input string appears in exactly one group, duplicates included
 *       ({@code ["ab","ba","ab"]} is one group of three).</li>
 *   <li>Empty array returns an empty list (never {@code null}).</li>
 *   <li>The caller's array must <b>not</b> be modified.</li>
 *   <li>20 000 strings of length 100 must finish within 2 seconds: no pair-by-pair compare.</li>
 * </ul>
 *
 * <p>Before any Java: 3-5 lines of plain-English pseudocode and a brute-force comment,
 * then three comment lines for pattern, time and space, each with a "because" saying
 * where the cost comes from (time depends on <b>two</b> sizes here: n strings, k letters).</p>
 */
public class GroupAnagrams {

    // Pseudocode:
    //
    // Brute force (and how many pair checks for n = 20 000, because ...):
    //
    // Key I chose, and why two different words can never get the same key:
    //
    // Pattern:
    // Time:  O(?) because
    // Space: O(?) because

    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO: write by hand
        throw new UnsupportedOperationException("TODO: Group Anagrams");
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // expected (any order): [[eat, tea, ate], [tan, nat], [bat]]
        System.out.println(ga.groupAnagrams(new String[]{""}));   // expected: [[]]
    }
}
