package com.leetcode;

/**
 * https://leetcode.com/problems/divide-two-integers/
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * <p>
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 * @author carl
 */
public class DivideTwoIntegers {

    static int HALF_MIN_INT = -1073741824;

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        boolean f = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;
        int ans = handle(dividend, divisor, 1, 0);
        return f ? ans : -ans;
    }

    private int handle(int dd, int dr, int times, int res) {
        if (dd == 0 || (dd > dr && times == 1)) {
            return res;
        }
        if (dd <= dr) {
            if (dr >= HALF_MIN_INT) {
                return handle(dd - dr, dr + dr, times + times, res + times);
            } else {
                return handle(dd - dr, dr, times, res + times);
            }
        }
        return handle(dd, dr >> 1, times >> 1, res);
    }
}
