package com.leetcode;

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
        int flag = n < 0 ? -1 : 1;
        double ans = 1.0;
        double y = 1;
        int times = 0;

        while (n != 0) {
            if (times == 0) {
                y = n < 0 ? 1 / x : x;
                ans *= y;
                times = 1;
                n = n < 0 ? n + 1 : n - 1;
            } else if (flag * n >= 2 * times) {
                y *= y;
                ans *= y;
                times *= 2;
                n = n < 0 ? n + times : n - times;
            } else if (flag * n >= times) {
                ans *= y;
                n = n < 0 ? n + times : n - times;
            } else {
                times /= 2;
                y = 1;
                for (int i = 0; i < times; i++) {
                    y *= (n < 0 ? 1 / x : x);
                }
            }
        }
        return ans;
    }

    private double pow(double base, int n, double y, int times, double ans) {
        if (n == 0) return ans;
        if (times == 0) {
            return pow(base, n - 1, base, 1, base);
        }
        if (n >= 2 * times) {
            return pow(base, n - 2 * times, y * y, 2 * times, ans * (y * y));
        }
        return pow(base, n - 1, base, 1, ans * base);
    }
}
