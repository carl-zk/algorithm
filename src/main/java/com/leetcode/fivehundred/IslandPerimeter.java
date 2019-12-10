package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/island-perimeter/
 * <p>
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Output: 16
 *
 * @author carl
 */
public class IslandPerimeter {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int M, N;
    int perimeter = 0;

    public int islandPerimeter(int[][] grid) {
        if ((M = grid.length) == 0 || (N = grid[0].length) == 0) return 0;
        int x = -1, y = 0;
        for (int i = 0; i < M && x == -1; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if (x == -1) return 0;
        dfs(grid, x, y);
        return perimeter;
    }

    private void dfs(int[][] grid, int x, int y) {
        perimeter += calPerimeter(grid, x, y);
        grid[x][y] = -1;
        for (int[] d : dirs) {
            int i = x + d[0], j = y + d[1];
            if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 0 || grid[i][j] == -1) {
                continue;
            }
            dfs(grid, i, j);
        }
    }

    private int calPerimeter(int[][] grid, int x, int y) {
        int res = 0;
        for (int[] d : dirs) {
            int i = x + d[0], j = y + d[1];
            if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 0) {
                res += 1;
            }
        }
        return res;
    }
}
