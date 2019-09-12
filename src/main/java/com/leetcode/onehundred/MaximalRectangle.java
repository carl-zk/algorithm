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
        int[] heights = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int len = 0, sum = 0;
                    for (int k = i; k > -1 && dp[k][j] > 0; k--) {
                        heights[len++] = dp[k][j];
                        sum += dp[k][j];
                    }
                    if ((i == matrix.length - 1 || matrix[i + 1][j] == '0') && sum > ans) {
                        int rec = solve(heights, 0, len - 1);
                        if (rec > ans) {
                            ans = rec;
                        }
                    }
                }
            }
        }

        return ans;
    }

    private int solve(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        boolean asc = true;
        boolean desc = true;
        int indexMin = start;
        for (int i = start; i <= end; i++) {
            if (i != start && heights[i] > heights[i - 1]) {
                desc = false;
            }
            if (i != start && heights[i] < heights[i - 1]) {
                asc = false;
            }
            if (heights[i] < heights[indexMin]) {
                indexMin = i;
            }
        }
        if (asc) {
            int ans = 0;
            for (int i = start, area; i <= end; i++) {
                area = (end - i + 1) * heights[i];
                if (area > ans) {
                    ans = area;
                }
            }
            return ans;
        }
        if (desc) {
            int ans = 0;
            for (int i = start, area; i <= end; i++) {
                area = (i - start + 1) * heights[i];
                if (area > ans) {
                    ans = area;
                }
            }
            return ans;
        }
        int leftMax = solve(heights, start, indexMin - 1);
        int rightMax = solve(heights, indexMin + 1, end);
        int area = (end - start + 1) * heights[indexMin];
        return Math.max(area, Math.max(leftMax, rightMax));
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
