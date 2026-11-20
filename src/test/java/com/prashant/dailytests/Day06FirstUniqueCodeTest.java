package com.prashant.dailytests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class Day06FirstUniqueCodeTest {
    private Day06FirstUniqueCode sol;

    @BeforeEach
    void setUp() { sol = new Day06FirstUniqueCode(); }

    private void check(int expected, String codes) {
        assertEquals(expected, sol.firstUniqueIndex(codes), () -> "codes=\"" + codes + "\"");
    }

    // ---------- normal ----------

    @Test @DisplayName("normal: leetcode -> 0, the first code is already unique")
    void leetcode() { check(0, "leetcode"); }

    @Test @DisplayName("normal: loveleetcode -> 2 ('v')")
    void loveleetcode() { check(2, "loveleetcode"); }

    @Test @DisplayName("normal: aabb -> -1, every code repeats")
    void allRepeat() { check(-1, "aabb"); }

    @Test @DisplayName("normal: ledgerly -> 2 ('d')")
    void ledgerly() { check(2, "ledgerly"); }

    @Test @DisplayName("normal: leftmost wins over alphabetical: zxa -> 0 ('z'), not 2 ('a')")
    void leftmostNotAlphabetical() { check(0, "zxa"); }

    @Test @DisplayName("normal: dcbabcdz -> 3 ('a' at index 3), even though 'z' also appears once")
    void uniqueInTheMiddle() { check(3, "dcbabcdz"); }

    @Test @DisplayName("normal: settlement file ppqqrstt -> 4 ('r'), not 's'")
    void settlementFile() { check(4, "ppqqrstt"); }

    // ---------- edge ----------

    @Test @DisplayName("edge: empty string -> -1")
    void empty() { check(-1, ""); }

    @Test @DisplayName("edge: one code -> 0")
    void single() { check(0, "m"); }

    @Test @DisplayName("edge: two equal codes -> -1")
    void twoEqual() { check(-1, "kk"); }

    @Test @DisplayName("edge: the first code repeats only at the very end (abca -> 1)")
    void firstRepeatsAtEnd() { check(1, "abca"); }

    @Test @DisplayName("edge: the only unique code is the last one (aabbc -> 4)")
    void uniqueLast() { check(4, "aabbc"); }

    @Test @DisplayName("edge: a code that appears three times is not unique (aaab -> 3)")
    void threeTimes() { check(3, "aaab"); }

    @Test @DisplayName("edge: all 26 letters once -> 0")
    void alphabetOnce() { check(0, "qwertyuiopasdfghjklzxcvbnm"); }

    // ---------- failure ----------

    @Test @DisplayName("failure: null throws IllegalArgumentException")
    void nullInput() { assertThrows(IllegalArgumentException.class, () -> sol.firstUniqueIndex(null)); }

    @Test @DisplayName("failure: an uppercase code throws IllegalArgumentException")
    void uppercase() { assertThrows(IllegalArgumentException.class, () -> sol.firstUniqueIndex("abCd")); }

    @Test @DisplayName("failure: a digit throws IllegalArgumentException")
    void digit() { assertThrows(IllegalArgumentException.class, () -> sol.firstUniqueIndex("ab1")); }

    @Test @DisplayName("failure: a character just above 'z' ('{') throws IllegalArgumentException")
    void aboveZ() { assertThrows(IllegalArgumentException.class, () -> sol.firstUniqueIndex("ab{")); }

    @Test @DisplayName("failure: a space throws IllegalArgumentException")
    void space() { assertThrows(IllegalArgumentException.class, () -> sol.firstUniqueIndex("a b")); }

    // ---------- large ----------

    @Test @DisplayName("large: 1 000 000 codes, the unique one near the end, within 1 s")
    void large() {
        StringBuilder sb = new StringBuilder(1_000_000);
        for (int i = 0; i < 999_998; i++) sb.append((char) ('a' + (i % 25)));   // 'a'..'y' many times
        sb.append('z');                                                           // index 999 998, once
        sb.append('a');
        String codes = sb.toString();
        int r = assertTimeoutPreemptively(Duration.ofSeconds(1), () -> sol.firstUniqueIndex(codes));
        assertEquals(999_998, r);
    }
}
