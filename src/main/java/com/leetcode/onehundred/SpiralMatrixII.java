package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * <p>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @auther carl
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int N = 1;

        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                ans[up][i] = N++;
            }
            for (int i = up + 1; i <= down; i++) {
                ans[i][right] = N++;
            }
            if (up < down && left < right) {
                for (int i = right - 1; i > left; i--) {
                    ans[down][i] = N++;
                }
                for (int i = down; i > up; i--) {
                    ans[i][left] = N++;
                }
            }
            up++;
            down--;
            left++;
            right--;
        }
        return ans;
    }
}
