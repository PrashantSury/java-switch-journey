package com.prashant.dailytests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class Day02RpnEvaluatorTest {

    private static int eval(String expr) {
        return Day02RpnEvaluator.evaluate(expr.split(" "));
    }

    // ---------- normal cases ----------

    @Test @DisplayName("normal: LeetCode example 1, (2 + 1) * 3 = 9")
    void leetcode1() {
        assertEquals(9, eval("2 1 + 3 *"));
    }

    @Test @DisplayName("normal: LeetCode example 2, 4 + 13 / 5 = 6")
    void leetcode2() {
        assertEquals(6, eval("4 13 5 / +"));
    }

    @Test @DisplayName("normal: LeetCode example 3 with a negative operand = 22")
    void leetcode3() {
        assertEquals(22, eval("10 6 9 3 + -11 * / * 17 + 5 +"));
    }

    @Test @DisplayName("normal: subtraction uses a - b (second popped minus first popped)")
    void subtractionOrder() {
        assertEquals(3, eval("5 2 -"));
    }

    @Test @DisplayName("normal: division uses a / b (second popped divided by first popped)")
    void divisionOrder() {
        assertEquals(4, eval("8 2 /"));
    }

    // ---------- single element ----------

    @Test @DisplayName("single: one positive number")
    void singlePositive() {
        assertEquals(5, eval("5"));
    }

    @Test @DisplayName("single: one negative number")
    void singleNegative() {
        assertEquals(-5, eval("-5"));
    }

    @Test @DisplayName("single: zero")
    void singleZero() {
        assertEquals(0, eval("0"));
    }

    @Test @DisplayName("single: Integer.MAX_VALUE")
    void singleMax() {
        assertEquals(Integer.MAX_VALUE, eval("2147483647"));
    }

    @Test @DisplayName("single: Integer.MIN_VALUE")
    void singleMin() {
        assertEquals(Integer.MIN_VALUE, eval("-2147483648"));
    }

    // ---------- negatives and zero ----------

    @Test @DisplayName("negatives: -3 * -4 = 12")
    void negativeTimesNegative() {
        assertEquals(12, eval("-3 -4 *"));
    }

    @Test @DisplayName("negatives: 3 - (-4) = 7")
    void minusNegative() {
        assertEquals(7, eval("3 -4 -"));
    }

    @Test @DisplayName("negatives: -1 + -1 = -2")
    void negativePlusNegative() {
        assertEquals(-2, eval("-1 -1 +"));
    }

    @Test @DisplayName("zero: 0 / 5 = 0")
    void zeroDividedBy() {
        assertEquals(0, eval("0 5 /"));
    }

    @Test @DisplayName("zero: x * 0 = 0")
    void timesZero() {
        assertEquals(0, eval("123456 0 *"));
    }

    // ---------- division truncation ----------

    @Test @DisplayName("division: 7 / 2 truncates to 3")
    void truncatePositive() {
        assertEquals(3, eval("7 2 /"));
    }

    @Test @DisplayName("division: 7 / -2 truncates toward zero to -3")
    void truncateNegativeDivisor() {
        assertEquals(-3, eval("7 -2 /"));
    }

    @Test @DisplayName("division: -7 / 2 truncates toward zero to -3")
    void truncateNegativeDividend() {
        assertEquals(-3, eval("-7 2 /"));
    }

    @Test @DisplayName("division: 1 / 2 truncates to 0")
    void smallDivision() {
        assertEquals(0, eval("1 2 /"));
    }

    @Test @DisplayName("division: divide by zero throws ArithmeticException")
    void divideByZero() {
        assertThrows(ArithmeticException.class, () -> eval("5 0 /"));
    }

    // ---------- overflow and int boundaries ----------

    @Test @DisplayName("overflow: MAX_VALUE + 1 throws ArithmeticException")
    void addOverflow() {
        assertThrows(ArithmeticException.class, () -> eval("2147483647 1 +"));
    }

    @Test @DisplayName("overflow: MIN_VALUE - 1 throws ArithmeticException")
    void subtractOverflow() {
        assertThrows(ArithmeticException.class, () -> eval("-2147483648 1 -"));
    }

    @Test @DisplayName("overflow: 65536 * 65536 throws ArithmeticException")
    void multiplyOverflow() {
        assertThrows(ArithmeticException.class, () -> eval("65536 65536 *"));
    }

    @Test @DisplayName("overflow: MIN_VALUE * -1 throws ArithmeticException")
    void multiplyMinByMinusOne() {
        assertThrows(ArithmeticException.class, () -> eval("-2147483648 -1 *"));
    }

    @Test @DisplayName("overflow: MIN_VALUE / -1 throws ArithmeticException")
    void divideMinByMinusOne() {
        assertThrows(ArithmeticException.class, () -> eval("-2147483648 -1 /"));
    }

    @Test @DisplayName("boundary: MAX_VALUE * -1 = -MAX_VALUE fits in an int")
    void multiplyMaxByMinusOne() {
        assertEquals(-Integer.MAX_VALUE, eval("2147483647 -1 *"));
    }

    @Test @DisplayName("boundary: MIN_VALUE + MAX_VALUE = -1")
    void minPlusMax() {
        assertEquals(-1, eval("-2147483648 2147483647 +"));
    }

    @Test @DisplayName("boundary: 46340 * 46340 fits just below MAX_VALUE")
    void largestSquareFits() {
        assertEquals(2147395600, eval("46340 46340 *"));
    }

    @Test @DisplayName("boundary: MIN_VALUE / 1 = MIN_VALUE")
    void minDividedByOne() {
        assertEquals(Integer.MIN_VALUE, eval("-2147483648 1 /"));
    }

    // ---------- invalid input ----------

    @Test @DisplayName("invalid: null array throws IllegalArgumentException")
    void nullArray() {
        assertThrows(IllegalArgumentException.class, () -> Day02RpnEvaluator.evaluate(null));
    }

    @Test @DisplayName("invalid: empty array throws IllegalArgumentException")
    void emptyArray() {
        assertThrows(IllegalArgumentException.class, () -> Day02RpnEvaluator.evaluate(new String[0]));
    }

    @Test @DisplayName("invalid: a null token throws IllegalArgumentException")
    void nullToken() {
        assertThrows(IllegalArgumentException.class,
                () -> Day02RpnEvaluator.evaluate(new String[]{"1", null, "+"}));
    }

    @Test @DisplayName("invalid: an empty-string token throws IllegalArgumentException")
    void emptyToken() {
        assertThrows(IllegalArgumentException.class,
                () -> Day02RpnEvaluator.evaluate(new String[]{"1", "", "+"}));
    }

    @Test @DisplayName("invalid: operator with no operands throws IllegalArgumentException")
    void operatorOnly() {
        assertThrows(IllegalArgumentException.class, () -> eval("+"));
    }

    @Test @DisplayName("invalid: operator with only one operand throws IllegalArgumentException")
    void oneOperand() {
        assertThrows(IllegalArgumentException.class, () -> eval("1 +"));
    }

    @Test @DisplayName("invalid: two values left at the end throws IllegalArgumentException")
    void leftoverOperands() {
        assertThrows(IllegalArgumentException.class, () -> eval("1 2"));
    }

    @Test @DisplayName("invalid: leftover value after a valid sub-expression throws IllegalArgumentException")
    void leftoverAfterOperation() {
        assertThrows(IllegalArgumentException.class, () -> eval("3 1 2 +"));
    }

    @Test @DisplayName("invalid: unknown operator throws IllegalArgumentException")
    void unknownOperator() {
        assertThrows(IllegalArgumentException.class, () -> eval("2 3 ^"));
    }

    @Test @DisplayName("invalid: non-numeric token throws IllegalArgumentException")
    void nonNumeric() {
        assertThrows(IllegalArgumentException.class, () -> eval("abc"));
    }

    @Test @DisplayName("invalid: operand larger than an int throws IllegalArgumentException")
    void operandTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> eval("2147483648"));
    }

    // ---------- duplicates, input safety, large input ----------

    @Test @DisplayName("duplicates: same number repeated, 2 2 2 * * = 8")
    void duplicates() {
        assertEquals(8, eval("2 2 2 * *"));
    }

    @Test @DisplayName("safety: the input array is not modified")
    void inputNotModified() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] copy = tokens.clone();
        Day02RpnEvaluator.evaluate(tokens);
        assertArrayEquals(copy, tokens);
    }

    @Test @DisplayName("large: 100,000 ones added together = 100000, fast")
    void largeInput() {
        int n = 100_000;
        String[] tokens = new String[2 * n - 1];
        for (int i = 0; i < n; i++) tokens[i] = "1";
        for (int i = n; i < tokens.length; i++) tokens[i] = "+";
        assertTimeoutPreemptively(Duration.ofSeconds(2),
                () -> assertEquals(n, Day02RpnEvaluator.evaluate(tokens)));
    }

    @Test @DisplayName("large: long alternating expression 1 1 + 1 + ... stays correct")
    void largeAlternating() {
        int n = 50_000;
        String[] tokens = new String[2 * n - 1];
        tokens[0] = "1";
        for (int i = 1, k = 1; i < n; i++) {
            tokens[k++] = "1";
            tokens[k++] = "+";
        }
        assertEquals(n, Day02RpnEvaluator.evaluate(tokens));
    }
}
