package com.prashant.dsa.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class RemoveKAdjacentDuplicatesTest {
    private RemoveKAdjacentDuplicates sol;

    @BeforeEach
    void setUp() { sol = new RemoveKAdjacentDuplicates(); }

    @Test @DisplayName("normal: LeetCode example 1, nothing to remove")
    void example1() { assertEquals("abcd", sol.removeDuplicates("abcd", 2)); }

    @Test @DisplayName("normal: LeetCode example 2, k = 3 with cascades")
    void example2() { assertEquals("aa", sol.removeDuplicates("deeedbbcccbdaa", 3)); }

    @Test @DisplayName("normal: LeetCode example 3, k = 2 with many cascades")
    void example3() { assertEquals("ps", sol.removeDuplicates("pbbcggttciiippooaais", 2)); }

    @Test @DisplayName("edge: empty string returns empty string")
    void empty() { assertEquals("", sol.removeDuplicates("", 2)); }

    @Test @DisplayName("edge: single character is kept")
    void single() { assertEquals("a", sol.removeDuplicates("a", 2)); }

    @Test @DisplayName("edge: whole string is exactly one run of k, result is empty")
    void wholeStringRemoved() { assertEquals("", sol.removeDuplicates("bbbb", 4)); }

    @Test @DisplayName("edge: run of k-1 equal chars is NOT removed")
    void runOfKMinusOne() { assertEquals("aab", sol.removeDuplicates("aab", 3)); }

    @Test @DisplayName("edge: k larger than string length, nothing removed")
    void kLargerThanLength() { assertEquals("aa", sol.removeDuplicates("aa", 5)); }

    @Test @DisplayName("edge: run longer than k leaves the remainder (5 a's, k=2 -> 'a')")
    void runLongerThanK() { assertEquals("a", sol.removeDuplicates("aaaaa", 2)); }

    @Test @DisplayName("edge: run of 4 with k=3 leaves one char")
    void runOfFourKThree() { assertEquals("a", sol.removeDuplicates("aaaa", 3)); }

    @Test @DisplayName("cascade: removing a middle run joins neighbours into a new run")
    void cascadeJoin() { assertEquals("a", sol.removeDuplicates("abbbaaa", 3)); }

    @Test @DisplayName("cascade: fully nested string collapses to empty")
    void nestedCollapse() { assertEquals("", sol.removeDuplicates("abccba", 2)); }

    @Test @DisplayName("duplicates that are not adjacent are left alone")
    void nonAdjacentDuplicates() { assertEquals("abab", sol.removeDuplicates("abab", 2)); }

    @Test @DisplayName("case-sensitive: 'a' and 'A' are different characters")
    void caseSensitive() {
        assertEquals("aAa", sol.removeDuplicates("aAa", 2));
        assertEquals("a", sol.removeDuplicates("AAa", 2));
    }

    @Test @DisplayName("digits and special characters are handled like letters")
    void digitsAndSymbols() { assertEquals("2", sol.removeDuplicates("11##2", 2)); }

    @Test @DisplayName("cascade: counts on both sides of a removed run must combine ('abbbaa', k=3 -> '')")
    void countsCombineAfterRemoval() { assertEquals("", sol.removeDuplicates("abbbaa", 3)); }

    @Test @DisplayName("cascade: leftover after a combined run is kept ('aabbbaa', k=3 -> 'a')")
    void leftoverAfterCombine() { assertEquals("a", sol.removeDuplicates("aabbbaa", 3)); }

    @Test @DisplayName("invalid: null string throws IllegalArgumentException")
    void nullString() { assertThrows(IllegalArgumentException.class, () -> sol.removeDuplicates(null, 2)); }

    @Test @DisplayName("invalid: k = 1 throws IllegalArgumentException")
    void kOne() { assertThrows(IllegalArgumentException.class, () -> sol.removeDuplicates("abc", 1)); }

    @Test @DisplayName("invalid: k = 0 throws IllegalArgumentException")
    void kZero() { assertThrows(IllegalArgumentException.class, () -> sol.removeDuplicates("abc", 0)); }

    @Test @DisplayName("invalid: negative k throws IllegalArgumentException")
    void kNegative() { assertThrows(IllegalArgumentException.class, () -> sol.removeDuplicates("abc", -3)); }

    @Test @DisplayName("invalid: k = Integer.MIN_VALUE throws IllegalArgumentException")
    void kMinValue() { assertThrows(IllegalArgumentException.class, () -> sol.removeDuplicates("abc", Integer.MIN_VALUE)); }

    @Test @DisplayName("boundary: k = Integer.MAX_VALUE never removes anything")
    void kMaxValue() { assertEquals("aaaa", sol.removeDuplicates("aaaa", Integer.MAX_VALUE)); }

    @Test @DisplayName("large: 100,000 alternating chars stay unchanged, within 2 seconds")
    void largeNoRemovals() {
        String s = "ab".repeat(50_000);
        String result = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sol.removeDuplicates(s, 2));
        assertEquals(s, result);
    }

    @Test @DisplayName("large: 100,000 identical chars with k=2 collapse to empty, within 2 seconds")
    void largeAllSame() {
        String s = "z".repeat(100_000);
        String result = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sol.removeDuplicates(s, 2));
        assertEquals("", result);
    }

    @Test @DisplayName("large: 100,000-char mirrored string cascades to empty, needs O(n), within 2 seconds")
    void largeDeepCascade() {
        String half = "ab".repeat(25_000);
        String s = half + new StringBuilder(half).reverse();
        String result = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sol.removeDuplicates(s, 2));
        assertEquals("", result);
    }
}
