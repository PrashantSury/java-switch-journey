package com.prashant.dsa.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ScoreOfParenthesesTest {
    private ScoreOfParentheses sol;

    @BeforeEach
    void setUp() { sol = new ScoreOfParentheses(); }

    /** k nested pairs, e.g. nested(3) = "((()))", which scores 2^(k-1). */
    private static String nested(int k) {
        return "(".repeat(k) + ")".repeat(k);
    }

    private void check(int expected, String input) {
        assertEquals(expected, sol.scoreOfParentheses(input), () -> "input " + input);
    }

    private void invalid(String input) {
        assertThrows(IllegalArgumentException.class, () -> sol.scoreOfParentheses(input), () -> "input " + input);
    }

    // ---------- LeetCode examples ----------
    @Test @DisplayName("normal: \"()\" scores 1")
    void example1() { check(1, "()"); }

    @Test @DisplayName("normal: \"(())\" scores 2")
    void example2() { check(2, "(())"); }

    @Test @DisplayName("normal: \"()()\" scores 2")
    void example3() { check(2, "()()"); }

    @Test @DisplayName("normal: \"(()(()))\" scores 6")
    void example4() { check(6, "(()(()))"); }

    // ---------- more valid shapes ----------
    @Test @DisplayName("normal: three nested \"((()))\" scores 4")
    void threeNested() { check(4, "((()))"); }

    @Test @DisplayName("normal: \"()(())\" scores 3 (sum of 1 and 2)")
    void sumThenNested() { check(3, "()(())"); }

    @Test @DisplayName("normal: \"(()())\" scores 4 (double of 1 + 1)")
    void doubleOfSum() { check(4, "(()())"); }

    @Test @DisplayName("normal: \"((())())\" scores 6 (double of 2 + 1)")
    void doubleOfMixed() { check(6, "((())())"); }

    @Test @DisplayName("normal: four siblings \"()()()()\" score 4")
    void fourSiblings() { check(4, "()()()()"); }

    @Test @DisplayName("normal: \"(())(())\" scores 4, inner score resets between siblings")
    void siblingsReset() { check(4, "(())(())"); }

    // ---------- null / empty / single char ----------
    @Test @DisplayName("edge: null input throws IllegalArgumentException")
    void nullInput() { invalid(null); }

    @Test @DisplayName("edge: empty string scores 0")
    void empty() { check(0, ""); }

    @Test @DisplayName("edge: single \"(\" is unbalanced")
    void singleOpen() { invalid("("); }

    @Test @DisplayName("edge: single \")\" is unbalanced (pop on empty stack)")
    void singleClose() { invalid(")"); }

    // ---------- unbalanced ----------
    @Test @DisplayName("invalid: \")(\" has equal counts but wrong order")
    void reversedPair() { invalid(")("); }

    @Test @DisplayName("invalid: \"(()\" has a leftover open bracket")
    void leftoverOpen() { invalid("(()"); }

    @Test @DisplayName("invalid: \"())\" closes more than it opened")
    void extraClose() { invalid("())"); }

    @Test @DisplayName("invalid: \"())(()\" has equal counts but goes negative in the middle")
    void negativeMidway() { invalid("())(()"); }

    @Test @DisplayName("invalid: \"(((\" only opens")
    void onlyOpens() { invalid("((("); }

    // ---------- bad characters ----------
    @Test @DisplayName("invalid: letter inside \"(a)\"")
    void letterInside() { invalid("(a)"); }

    @Test @DisplayName("invalid: space inside \"( )\"")
    void spaceInside() { invalid("( )"); }

    @Test @DisplayName("invalid: other bracket types \"[]\"")
    void squareBrackets() { invalid("[]"); }

    @Test @DisplayName("invalid: mixed \"({})\"")
    void mixedBrackets() { invalid("({})"); }

    // ---------- overflow boundaries ----------
    @Test @DisplayName("boundary: 31 nested pairs score 2^30 = 1073741824 (still fits)")
    void maxNestingThatFits() { check(1 << 30, nested(31)); }

    @Test @DisplayName("overflow: 32 nested pairs would be 2^31, throws ArithmeticException")
    void nestingOverflow() {
        assertThrows(ArithmeticException.class, () -> sol.scoreOfParentheses(nested(32)));
    }

    @Test @DisplayName("boundary: sum of 2^30 + 2^29 + ... + 2^0 is exactly Integer.MAX_VALUE")
    void sumEqualsMaxValue() {
        StringBuilder sb = new StringBuilder();
        for (int k = 31; k >= 1; k--) sb.append(nested(k));
        check(Integer.MAX_VALUE, sb.toString());
    }

    @Test @DisplayName("overflow: Integer.MAX_VALUE + one more \"()\" throws ArithmeticException")
    void sumOverflowByOne() {
        StringBuilder sb = new StringBuilder();
        for (int k = 31; k >= 1; k--) sb.append(nested(k));
        sb.append("()");
        assertThrows(ArithmeticException.class, () -> sol.scoreOfParentheses(sb.toString()));
    }

    @Test @DisplayName("overflow: two siblings of 2^30 each sum to 2^31, throws ArithmeticException")
    void siblingSumOverflow() {
        assertThrows(ArithmeticException.class, () -> sol.scoreOfParentheses(nested(31) + nested(31)));
    }

    @Test @DisplayName("overflow: doubling a sum, (2^29 + 2^29) * 2 = 2^31 throws ArithmeticException")
    void doubleOfSumOverflow() {
        assertThrows(ArithmeticException.class,
                () -> sol.scoreOfParentheses("(" + nested(30) + nested(30) + ")"));
    }

    @Test @DisplayName("boundary: doubled (2^29 + 2^28) = 3 * 2^29 still fits")
    void doubleOfSumFits() { check(3 << 29, "(" + nested(30) + nested(29) + ")"); }

    // ---------- large inputs ----------
    @Test @DisplayName("large: 100_000 sibling pairs score 100_000")
    void manySiblings() {
        String s = "()".repeat(100_000);
        assertTimeout(Duration.ofSeconds(2), () -> check(100_000, s));
    }

    @Test @DisplayName("large: 100_000 copies of 10-deep nesting score 51_200_000")
    void manyMediumNests() {
        String s = nested(10).repeat(100_000);
        assertTimeout(Duration.ofSeconds(2), () -> check(51_200_000, s));
    }

    @Test @DisplayName("large: 100_000 levels deep overflows with ArithmeticException, not StackOverflowError")
    void veryDeepNesting() {
        String s = nested(100_000);
        assertTimeout(Duration.ofSeconds(2),
                () -> assertThrows(ArithmeticException.class, () -> sol.scoreOfParentheses(s)));
    }

    @Test @DisplayName("large: 100_000 valid pairs plus a trailing \"(\" is unbalanced")
    void largeTrailingOpen() {
        String s = "()".repeat(100_000) + "(";
        assertTimeout(Duration.ofSeconds(2), () -> invalid(s));
    }

    @Test @DisplayName("large: bad character at the very end is still caught")
    void largeBadCharAtEnd() {
        String s = "()".repeat(100_000) + "x";
        assertTimeout(Duration.ofSeconds(2), () -> invalid(s));
    }

    @Test @DisplayName("large: a leading \")\" before 100_000 pairs is unbalanced")
    void largeLeadingClose() {
        String s = ")" + "()".repeat(100_000);
        assertTimeout(Duration.ofSeconds(2), () -> invalid(s));
    }

    // ---------- repeat calls ----------
    @Test @DisplayName("state: same instance gives the same answer on repeated calls")
    void repeatedCalls() {
        assertEquals(6, sol.scoreOfParentheses("(()(()))"));
        assertEquals(6, sol.scoreOfParentheses("(()(()))"));
        assertEquals(1, sol.scoreOfParentheses("()"));
    }
}
