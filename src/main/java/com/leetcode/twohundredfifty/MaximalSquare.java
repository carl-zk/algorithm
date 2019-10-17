package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/maximal-square/
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 *
 * @auther carl
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            ans = Math.max(ans, dp[i][0]);
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i] - '0';
            ans = Math.max(ans, dp[0][i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }
}
