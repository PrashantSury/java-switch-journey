package com.prashant.dailytests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class Day05DecodeStringTest {

    private static String d(String s) { return Day05DecodeString.decode(s); }

    // ---------- normal ----------

    @Test @DisplayName("normal: LeetCode example 1, \"3[a]2[bc]\" -> \"aaabcbc\"")
    void example1() { assertEquals("aaabcbc", d("3[a]2[bc]")); }

    @Test @DisplayName("normal: LeetCode example 2, nested \"3[a2[c]]\" -> \"accaccacc\"")
    void example2() { assertEquals("accaccacc", d("3[a2[c]]")); }

    @Test @DisplayName("normal: LeetCode example 3, trailing text \"2[abc]3[cd]ef\"")
    void example3() { assertEquals("abcabccdcdcdef", d("2[abc]3[cd]ef")); }

    @Test @DisplayName("normal: plain text with no brackets is unchanged")
    void plain() { assertEquals("abc", d("abc")); }

    @Test @DisplayName("normal: text before and after one group keeps its position, \"a2[b]c\" -> \"abbc\"")
    void prefixAndSuffix() { assertEquals("abbc", d("a2[b]c")); }

    @Test @DisplayName("normal: inner group after a prefix, \"2[x3[y]]\" -> \"xyyyxyyy\"")
    void innerAfterPrefix() { assertEquals("xyyyxyyy", d("2[x3[y]]")); }

    @Test @DisplayName("normal: two groups side by side with single-digit counts, \"2[a]3[b]\"")
    void twoGroups() { assertEquals("aabbb", d("2[a]3[b]")); }

    @Test @DisplayName("normal: uppercase letters are copied as they are, \"2[AB]c\"")
    void uppercase() { assertEquals("ABABc", d("2[AB]c")); }

    @Test @DisplayName("normal: deep LeetCode-style mix \"3[z]2[2[y]pq4[2[jk]e1[f]]]ef\"")
    void deepMix() {
        assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef",
                d("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    // ---------- edge ----------

    @Test @DisplayName("edge: the empty string decodes to the empty string")
    void empty() { assertEquals("", d("")); }

    @Test @DisplayName("edge: a count of 1 leaves the body as it is")
    void countOne() { assertEquals("a", d("1[a]")); }

    @Test @DisplayName("edge: an empty body decodes to nothing, \"2[]x\" -> \"x\"")
    void emptyBody() { assertEquals("x", d("2[]x")); }

    @Test @DisplayName("edge: a count of 0 removes the group, \"a0[bc]d\" -> \"ad\"")
    void countZero() { assertEquals("ad", d("a0[bc]d")); }

    @Test @DisplayName("edge: two-digit count, \"10[a]\" is ten a's")
    void twoDigits() { assertEquals("a".repeat(10), d("10[a]")); }

    @Test @DisplayName("edge: three-digit count, \"100[xy]\" is 200 characters")
    void threeDigits() { assertEquals("xy".repeat(100), d("100[xy]")); }

    @Test @DisplayName("edge: two-digit counts nested and side by side, \"12[a]2[b10[c]]\"")
    void multiDigitMix() {
        String inner = "b" + "c".repeat(10);
        assertEquals("a".repeat(12) + inner + inner, d("12[a]2[b10[c]]"));
    }

    @Test @DisplayName("edge: three levels of nesting, \"2[2[2[a]]]\" is eight a's")
    void threeLevels() { assertEquals("aaaaaaaa", d("2[2[2[a]]]")); }

    @Test @DisplayName("edge: 1 000 levels of \"1[\" nesting do not overflow the call stack")
    void deepNesting() {
        String s = "1[".repeat(1000) + "q" + "]".repeat(1000);
        assertEquals("q", d(s));
    }

    // ---------- failure ----------

    @Test @DisplayName("failure: null throws IllegalArgumentException")
    void nullInput() { assertThrows(IllegalArgumentException.class, () -> d(null)); }

    @Test @DisplayName("failure: a ']' with no open '[' throws IllegalArgumentException")
    void strayClose() { assertThrows(IllegalArgumentException.class, () -> d("a]b")); }

    @Test @DisplayName("failure: one ']' too many after a valid group throws IllegalArgumentException")
    void extraClose() { assertThrows(IllegalArgumentException.class, () -> d("2[a]]")); }

    @Test @DisplayName("failure: a '[' that is never closed throws IllegalArgumentException")
    void unclosed() { assertThrows(IllegalArgumentException.class, () -> d("2[ab")); }

    @Test @DisplayName("failure: a template that expands past 1 000 000 characters throws IllegalArgumentException")
    void templateBomb() {
        assertThrows(IllegalArgumentException.class,
                () -> assertTimeoutPreemptively(Duration.ofSeconds(2), () -> d("1000[1000[1000[a]]]")));
    }

    @Test @DisplayName("edge: exactly 1 000 000 characters is still allowed")
    void atTheLimit() { assertEquals(1_000_000, d("1000[1000[a]]").length()); }

    // ---------- large ----------

    @Test @DisplayName("large: \"300[300[a]]\" (90 000 characters) within 2 s")
    void large() {
        String out = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> d("300[300[a]]"));
        assertEquals(90_000, out.length());
        assertTrue(out.chars().allMatch(ch -> ch == 'a'));
    }
}
