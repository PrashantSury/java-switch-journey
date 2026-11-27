package com.prashant.dsa.arrayshashing;

import java.util.*;

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

/*
  Pseudocode:
 1. For each string in the array, build a key from its letter-frequency signature
    (26 counts, each prefixed with '#', e.g. "eat" -> "#1#0#0#0#1#0...#1#0...").
 2. Use computeIfAbsent to fetch (or create) the list stored under that key
    in a HashMap<String, List<String>>, and add the string to it.
 3. Return new ArrayList<>(map.values()); each value is one anagram group.

 Brute force: compare every pair of strings with isAnagram().
   Number of pair checks for n = 20,000:
     n(n-1)/2 = 20,000 * 19,999 / 2 = 199,990,000  (~2 * 10^8 pair checks)
   Each check costs O(k), so total time is O(n^2 * k).
   Pair checking alone also doesn't build groups; you'd still need extra
   logic (e.g. visited[] / union-find) to merge results into groups.

 Key I chose, and why two different words can never get the same key:
   The key is the count of each letter a-z, written as "#c0#c1...#c25".
   Two strings are anagrams if and only if they have identical letter counts,
   so anagrams always produce the same key, and non-anagrams differ in at least
   one count, so they produce different keys. The '#' separator makes the
   encoding unambiguous: without it, counts (1, 11) and (11, 1) would both
   become "111" and collide. Since the counts can be recovered uniquely from
   the key, the key-to-multiset mapping is one-to-one.

 Complexity: Time O(n * k), Space O(n * k)
   (n = number of strings, k = max string length; the key length is a
   constant 26 counts, so building it is O(k + 26)).
 */

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            throw new IllegalArgumentException("input array can not be null");
        }

        Map<String, List<String>> map = new LinkedHashMap<>();

        for (String s : strs) {
            String key = buildKey(s);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Key = character frequency signature, e.g. "eat" -> "#1#0#0#0#1#0...#1..."
    private String buildKey(String s) {
        if (s == null) {
            throw new IllegalArgumentException("string can not be null");
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c < 'a' || c > 'z') {
                throw new IllegalArgumentException(
                        "only lowercase letters a-z are allowed, found '" + c + "' in \"" + s + "\"");
            }
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int count : freq) {
            sb.append('#').append(count);   // '#' avoids ambiguity like 1,11 vs 11,1
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // expected (any order): [[eat, tea, ate], [tan, nat], [bat]]
        System.out.println(ga.groupAnagrams(new String[]{""}));   // expected: [[]]
    }
}
