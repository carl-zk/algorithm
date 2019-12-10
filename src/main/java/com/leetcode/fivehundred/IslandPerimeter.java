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
    public int islandPerimeter(int[][] grid) {
        int M, N;
        if ((M = grid.length) == 0 || (N = grid[0].length) == 0) return 0;
        int ones = 0, adjoins = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    ones++;
                    if (i + 1 < M && grid[i + 1][j] == 1) adjoins++;
                    if (j + 1 < N && grid[i][j + 1] == 1) adjoins++;
                }
            }
        }
        return ones * 4 - adjoins * 2;
    }
}
