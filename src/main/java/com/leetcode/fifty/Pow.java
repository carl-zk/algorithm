package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/powx-n/
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 * @auther carl
 */
public class Pow {

    public double myPow(double x, int n) {
        long m = n;
        if (m < 0) {
            m = -m;
            x = 1 / x;
        }
        double ans = 1;
        double cur = x;
        for (long i = m; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * cur;
            }
            cur *= cur;
        }
        return ans;
    }
}
