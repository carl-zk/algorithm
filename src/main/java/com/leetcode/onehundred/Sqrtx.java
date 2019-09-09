package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/sqrtx/
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 * @auther carl
 */
public class Sqrtx {

    public int mySqrt(int x) {
        int h = 0, t = 46340;
        int mid = 0;
        while (h < t) {
            mid = (h + t) >> 1;
            int sqrt = mid * mid;
            if (sqrt == x || h == mid) {
                if (t * t <= x) {
                    mid = t;
                }
                break;
            } else if (sqrt < x) h = mid;
            else t = mid;
        }
        return mid;
    }
}
