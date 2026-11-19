package com.prashant.dsa.arrayshashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {
    private ValidAnagram sol;

    @BeforeEach
    void setUp() { sol = new ValidAnagram(); }

    // ---------- normal ----------

    @Test @DisplayName("normal: LeetCode example 1, anagram / nagaram is an anagram")
    void example1() { assertTrue(sol.isAnagram("anagram", "nagaram")); }

    @Test @DisplayName("normal: LeetCode example 2, rat / car is not")
    void example2() { assertFalse(sol.isAnagram("rat", "car")); }

    @Test @DisplayName("normal: listen / silent is an anagram")
    void listenSilent() { assertTrue(sol.isAnagram("listen", "silent")); }

    @Test @DisplayName("normal: same letters but different counts (aacc / ccac) is not")
    void sameLettersDifferentCounts() { assertFalse(sol.isAnagram("aacc", "ccac")); }

    @Test @DisplayName("normal: identical strings are anagrams of each other")
    void identical() { assertTrue(sol.isAnagram("ledgerly", "ledgerly")); }

    @Test @DisplayName("normal: order of the arguments does not matter")
    void symmetric() {
        assertTrue(sol.isAnagram("nagaram", "anagram"));
        assertFalse(sol.isAnagram("car", "rat"));
    }

    @Test @DisplayName("normal: equal character sums but different letters (ac / bb, abd / bbc) is not")
    void equalSumsDifferentLetters() {
        assertFalse(sol.isAnagram("ac", "bb"));
        assertFalse(sol.isAnagram("abd", "bbc"));
    }

    // ---------- edge ----------

    @Test @DisplayName("edge: two empty strings are anagrams")
    void bothEmpty() { assertTrue(sol.isAnagram("", "")); }

    @Test @DisplayName("edge: empty versus one letter is not")
    void emptyVersusOne() {
        assertFalse(sol.isAnagram("", "a"));
        assertFalse(sol.isAnagram("a", ""));
    }

    @Test @DisplayName("edge: single equal letters")
    void singleEqual() { assertTrue(sol.isAnagram("z", "z")); }

    @Test @DisplayName("edge: single different letters")
    void singleDifferent() { assertFalse(sol.isAnagram("a", "b")); }

    @Test @DisplayName("edge: t is s plus one extra letter (different lengths)")
    void extraLetter() { assertFalse(sol.isAnagram("abc", "abcc")); }

    @Test @DisplayName("edge: same length, one letter swapped for another (aab / abb)")
    void oneSwapped() { assertFalse(sol.isAnagram("aab", "abb")); }

    @Test @DisplayName("edge: all 26 letters, reversed")
    void fullAlphabetReversed() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        assertTrue(sol.isAnagram(abc, new StringBuilder(abc).reverse().toString()));
    }

    // ---------- failure ----------

    @Test @DisplayName("failure: null s throws IllegalArgumentException")
    void nullS() { assertThrows(IllegalArgumentException.class, () -> sol.isAnagram(null, "a")); }

    @Test @DisplayName("failure: null t throws IllegalArgumentException")
    void nullT() { assertThrows(IllegalArgumentException.class, () -> sol.isAnagram("a", null)); }

    // ---------- large ----------

    @Test @DisplayName("large: 1 000 000 characters, an anagram, within 2 seconds")
    void largeTrue() {
        String s = big(1_000_000, 0);
        String t = new StringBuilder(s).reverse().toString();
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> assertTrue(sol.isAnagram(s, t)));
    }

    @Test @DisplayName("large: 1 000 000 characters, last letter differs, within 2 seconds")
    void largeFalse() {
        String s = big(1_000_000, 0);
        char[] chars = new StringBuilder(s).reverse().toString().toCharArray();
        chars[chars.length - 1] = chars[chars.length - 1] == 'a' ? 'b' : 'a';
        String t = new String(chars);
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> assertFalse(sol.isAnagram(s, t)));
    }

    private static String big(int n, int seed) {
        StringBuilder sb = new StringBuilder(n);
        long x = 12345 + seed;
        for (int i = 0; i < n; i++) {
            x = (x * 1103515245L + 12345L) & 0x7fffffffL;
            sb.append((char) ('a' + (x % 26)));
        }
        return sb.toString();
    }
}
