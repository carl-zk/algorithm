package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/unique-paths/
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 *
 * @author carl
 */
public class UniquePaths {
    Integer[][] dp;
    int[] x = {0, 1};
    int[] y = {1, 0};
    int M, N;

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;

        dp = new Integer[m][n];
        M = m;
        N = n;
        solve(0, 0);
        return dp[0][0];
    }

    private int solve(int m, int n) {
        if (m == M || n == N) return 0;

        if (dp[m][n] != null) {
            return dp[m][n];
        }
        if (m == M - 1 && n == N - 1) {
            dp[m][n] = 1;
            return dp[m][n];
        }

        dp[m][n] = 0;
        for (int i = 0; i < x.length; i++) {
            int j = m + x[i], k = n + y[i];
            if (j < M && k < N) {
                dp[j][k] = solve(j, k);
                dp[m][n] += dp[j][k];
            }
        }
        return dp[m][n];
    }
}
