package com.leetcode;

/**
 * @auther carl
 */
public class Pow {

    public double myPow(double x, int n) {
        double ans = pow(x, n < 0 ? -n : n, 1, 0, 0);
        return n < 0 ? 1 / ans : ans;
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
