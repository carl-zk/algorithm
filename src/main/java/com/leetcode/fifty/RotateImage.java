package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/rotate-image/
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author carl
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix.length < 2) return;
        for (int i = 0; i <= (matrix.length - 1) / 2; i++) {
            for (int j = i; j <= matrix.length - 2 - i; j++) {
                move(matrix, i, j);
            }
        }
    }

    private void move(int[][] matrix, int start_i, int start_j) {
        int t = matrix[start_i][start_j];
        int i = start_i;
        int j = start_j;
        while (true) {
            int next_i = matrix.length - 1 - j;
            int next_j = i;
            if (next_i == start_i && next_j == start_j) {
                matrix[i][j] = t;
                break;
            }
            matrix[i][j] = matrix[next_i][next_j];
            i = next_i;
            j = next_j;
        }
    }
}
