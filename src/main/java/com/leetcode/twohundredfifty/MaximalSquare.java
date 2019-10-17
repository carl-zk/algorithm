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
        int[] dp = new int[m + 1];
        for (int i = 1, pre = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], pre)) + 1;
                    ans = Math.max(ans, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return ans * ans;
    }
}
