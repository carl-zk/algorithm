package com.leetcode.onehundred;

/**
 * @auther carl
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 3) return n;
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            int t = f2;
            f2 += f1;
            f1 = t;
        }
        return f2;
    }
}
