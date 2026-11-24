package com.prashant.dsa.arrayshashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {
    private GroupAnagrams sol;

    @BeforeEach
    void setUp() { sol = new GroupAnagrams(); }

    /** Order-independent form: sort words inside each group, then sort the groups. */
    private static List<List<String>> normalise(List<List<String>> groups) {
        assertNotNull(groups, "result must not be null");
        List<List<String>> out = new ArrayList<>();
        for (List<String> g : groups) {
            assertNotNull(g, "a group must not be null");
            assertFalse(g.isEmpty(), "a group must not be empty");
            List<String> copy = new ArrayList<>(g);
            copy.sort(Comparator.naturalOrder());
            out.add(copy);
        }
        out.sort(Comparator.comparing((List<String> g) -> String.join(",", g)).thenComparingInt(List::size));
        return out;
    }

    private void check(String[] input, String[][] expected) {
        List<List<String>> exp = new ArrayList<>();
        for (String[] g : expected) exp.add(new ArrayList<>(Arrays.asList(g)));
        assertEquals(normalise(exp), normalise(sol.groupAnagrams(input)));
    }

    // ---------- normal ----------

    @Test @DisplayName("normal: LeetCode example 1, eat/tea/tan/ate/nat/bat -> three groups")
    void example1() {
        check(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
              new String[][]{{"eat", "tea", "ate"}, {"tan", "nat"}, {"bat"}});
    }

    @Test @DisplayName("normal: listen/silent/enlist/google/gooegl -> two groups")
    void listenSilent() {
        check(new String[]{"listen", "silent", "enlist", "google", "gooegl"},
              new String[][]{{"listen", "silent", "enlist"}, {"google", "gooegl"}});
    }

    @Test @DisplayName("normal: no two words are anagrams -> every word is its own group")
    void allSeparate() {
        check(new String[]{"abc", "abd", "xyz"}, new String[][]{{"abc"}, {"abd"}, {"xyz"}});
    }

    @Test @DisplayName("normal: every word is an anagram of the others -> one group")
    void allOneGroup() {
        check(new String[]{"abc", "bca", "cab", "acb"}, new String[][]{{"abc", "bca", "cab", "acb"}});
    }

    @Test @DisplayName("normal: same letters, different counts are NOT anagrams (aab vs abb)")
    void sameLettersDifferentCounts() {
        check(new String[]{"aab", "abb", "aba"}, new String[][]{{"aab", "aba"}, {"abb"}});
    }

    @Test @DisplayName("normal: equal character sums but different letters stay apart (ac vs bb, abd vs bbc)")
    void equalSumsDifferentLetters() {
        check(new String[]{"ac", "bb", "ca", "abd", "bbc"},
              new String[][]{{"ac", "ca"}, {"bb"}, {"abd"}, {"bbc"}});
    }

    @Test @DisplayName("normal: different lengths never group together (ab vs aab)")
    void differentLengths() {
        check(new String[]{"ab", "aab", "ba"}, new String[][]{{"ab", "ba"}, {"aab"}});
    }

    // ---------- edge ----------

    @Test @DisplayName("edge: empty array -> empty list, not null")
    void emptyArray() {
        List<List<String>> r = sol.groupAnagrams(new String[0]);
        assertNotNull(r);
        assertTrue(r.isEmpty());
    }

    @Test @DisplayName("edge: one empty string -> [[\"\"]]")
    void singleEmptyString() { check(new String[]{""}, new String[][]{{""}}); }

    @Test @DisplayName("edge: several empty strings are anagrams of each other")
    void manyEmptyStrings() {
        check(new String[]{"", "a", "", ""}, new String[][]{{"", "", ""}, {"a"}});
    }

    @Test @DisplayName("edge: single word -> one group of one")
    void singleWord() { check(new String[]{"a"}, new String[][]{{"a"}}); }

    @Test @DisplayName("edge: exact duplicates are all kept, in the same group")
    void duplicatesKept() {
        check(new String[]{"ab", "ba", "ab", "ab"}, new String[][]{{"ab", "ba", "ab", "ab"}});
    }

    @Test @DisplayName("edge: count key without separators collides (a+b*11 vs a*11+b) and must not")
    void countKeyDelimiterCollision() {
        String w1 = "a" + "b".repeat(11);          // counts a=1, b=11  -> "1" + "11"
        String w2 = "a".repeat(11) + "b";          // counts a=11, b=1  -> "11" + "1"
        check(new String[]{w1, w2}, new String[][]{{w1}, {w2}});
    }

    @Test @DisplayName("edge: all 26 letters forwards and backwards group together; missing z does not")
    void fullAlphabet() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String rev = new StringBuilder(abc).reverse().toString();
        String noZ = "abcdefghijklmnopqrstuvwxyy";
        check(new String[]{abc, rev, noZ}, new String[][]{{abc, rev}, {noZ}});
    }

    @Test @DisplayName("edge: total word count is preserved (no word lost or duplicated)")
    void countPreserved() {
        String[] in = {"eat", "tea", "tan", "ate", "nat", "bat", "", "", "tab"};
        int total = 0;
        for (List<String> g : sol.groupAnagrams(in)) total += g.size();
        assertEquals(in.length, total);
    }

    @Test @DisplayName("edge: the caller's array is not modified")
    void inputNotModified() {
        String[] in = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] copy = in.clone();
        sol.groupAnagrams(in);
        assertArrayEquals(copy, in);
    }

    // ---------- failure ----------

    @Test @DisplayName("failure: null array throws IllegalArgumentException")
    void nullArray() {
        assertThrows(IllegalArgumentException.class, () -> sol.groupAnagrams(null));
    }

    @Test @DisplayName("failure: a null element throws IllegalArgumentException")
    void nullElement() {
        assertThrows(IllegalArgumentException.class, () -> sol.groupAnagrams(new String[]{"ab", null, "ba"}));
    }

    @Test @DisplayName("failure: uppercase letter throws IllegalArgumentException")
    void uppercase() {
        assertThrows(IllegalArgumentException.class, () -> sol.groupAnagrams(new String[]{"ab", "Ba"}));
    }

    @Test @DisplayName("failure: digit, space or non-ASCII letter throws IllegalArgumentException")
    void otherCharacters() {
        assertThrows(IllegalArgumentException.class, () -> sol.groupAnagrams(new String[]{"a1"}));
        assertThrows(IllegalArgumentException.class, () -> sol.groupAnagrams(new String[]{"a b"}));
        assertThrows(IllegalArgumentException.class, () -> sol.groupAnagrams(new String[]{"caf\u00e9"}));
    }

    // ---------- large ----------

    @Test @DisplayName("large: 20 000 random words of length 100 (all distinct groups) within 2 s")
    void largeAllDistinct() {
        int n = 20_000;
        Random rnd = new Random(42);
        String[] in = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(100);
            for (int c = 0; c < 100; c++) sb.append((char) ('a' + rnd.nextInt(26)));
            in[i] = sb.toString();
        }
        List<List<String>> r = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sol.groupAnagrams(in));
        int total = 0;
        for (List<String> g : r) total += g.size();
        assertEquals(n, total);
        assertEquals(n, r.size());   // random 100-letter words: no two share letter counts (seed 42)
    }

    @Test @DisplayName("large: 20 000 shuffles of the same 100 letters -> one group, within 2 s")
    void largeOneGroup() {
        int n = 20_000;
        Random rnd = new Random(7);
        char[] base = new char[100];
        for (int c = 0; c < 100; c++) base[c] = (char) ('a' + rnd.nextInt(26));
        String[] in = new String[n];
        for (int i = 0; i < n; i++) {
            char[] w = base.clone();
            for (int j = w.length - 1; j > 0; j--) {
                int k = rnd.nextInt(j + 1);
                char t = w[j]; w[j] = w[k]; w[k] = t;
            }
            in[i] = new String(w);
        }
        List<List<String>> r = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sol.groupAnagrams(in));
        assertEquals(1, r.size());
        assertEquals(n, r.get(0).size());
    }
}
