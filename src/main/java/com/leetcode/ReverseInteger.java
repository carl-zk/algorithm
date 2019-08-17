package com.leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 *
 * @author carl
 */
public class ReverseInteger {

    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        boolean positive = x >= 0;
        x = positive ? x : -x;
        int tail = x % 10;

        int r = 0, base = 0;
        while (x > 0) {
            r = r * 10 + (x % 10);
            x /= 10;
            base = base == 0 ? 1 : base * 10;
        }

        if (r / base != tail) {
            return 0;
        }

        return positive ? r : -r;
    }
}
