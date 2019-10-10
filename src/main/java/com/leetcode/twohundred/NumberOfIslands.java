package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/number-of-islands/
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 *
 * @auther carl
 */
public class NumberOfIslands {
    static final char MARK = 'x';
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    mark(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void mark(char[][] grid, int ii, int jj) {
        grid[ii][jj] = MARK;
        for (int i = 0; i < dx.length; i++) {
            int x = ii + dx[i];
            int y = jj + dy[i];
            if (x >= 0 && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == '1') {
                mark(grid, x, y);
            }
        }
    }
}
