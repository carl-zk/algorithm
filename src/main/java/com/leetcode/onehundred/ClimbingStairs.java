package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
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
