package com.leetcode.fourhundredfifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * <p>
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 *
 * @author carl
 */
public class PacificAtlanticWaterFlow {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();


        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;

        List<List<Integer>> ans = new LinkedList<>();

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific);
            dfs(matrix, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, pacific);
            dfs(matrix, m - 1, j, atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        for (int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length ||
                    visited[x][y] || matrix[x][y] < matrix[i][j]) {
                continue;
            }
            dfs(matrix, x, y, visited);
        }
    }
}
