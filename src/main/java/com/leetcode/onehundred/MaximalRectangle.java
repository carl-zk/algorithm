package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * @auther carl
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int ans = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int min = Integer.MAX_VALUE;
                    for (int k = i, h = 1; k > -1 && dp[k][j] > 0; k--, h++) {
                        min = Math.min(min, dp[k][j]);
                        int area = min * h;
                        if (area > ans) {
                            ans = area;
                        }
                    }

                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();
        char[][] m = new char[][]{
                {'0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1'},
                {'1', '0', '1', '1', '0', '1', '0', '0', '1', '1', '1', '0', '0', '0', '1'},
                {'0', '1', '0', '1', '1', '1', '0', '1', '0', '1', '1', '0', '0', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'0', '1', '1', '1', '0', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '0', '1', '0', '1', '1', '1', '0', '0', '1', '1'},
                {'0', '1', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '0', '0', '0', '1', '1', '1', '0', '1', '0', '0', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '1'}
        };
        System.out.println(mr.maximalRectangle(m));
    }
}
