package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/perfect-squares/
 * <p>
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * @auther carl
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; 2 * j <= i; j++) {
                if (j * j == i) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(12));
    }
}
