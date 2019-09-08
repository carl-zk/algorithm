package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * <p>
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * @author carl
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int i = 0;
        while (i < dp.length && obstacleGrid[i][0] == 0) {
            dp[i][0] = 1;
            i++;
        }
        while (i < dp.length) {
            dp[i][0] = 0;
            i++;
        }
        int j = 0;
        while (j < obstacleGrid[0].length && obstacleGrid[0][j] == 0) {
            dp[0][j] = 1;
            j++;
        }
        while (j < obstacleGrid[0].length) {
            dp[0][j] = 0;
            j++;
        }
        for (int k = 1; k < obstacleGrid.length; k++) {
            for (int l = 1; l < obstacleGrid[0].length; l++) {
                dp[k][l] = dp[k - 1][l] + dp[k][l - 1];
                if (obstacleGrid[k][l] == 1) {
                    dp[k][l] = 0;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
