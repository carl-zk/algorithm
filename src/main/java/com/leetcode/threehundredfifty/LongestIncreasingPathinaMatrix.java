package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * <p>
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * Input: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 * <p>
 * Input: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 * @auther carl
 */
public class LongestIncreasingPathinaMatrix {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int ans = 1;
    int[][] dist;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        dist = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, solve(matrix, i, j));
            }
        }
        return ans;
    }

    private int solve(int[][] matrix, int x, int y) {
        if (dist[x][y] != 0) return dist[x][y];
        dist[x][y] = 1;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (0 <= nx && nx < matrix.length && 0 <= ny && ny < matrix[0].length && matrix[nx][ny] > matrix[x][y]) {
                dist[x][y] = Math.max(dist[x][y], 1 + solve(matrix, nx, ny));
            }
        }
        return dist[x][y];
    }
}
