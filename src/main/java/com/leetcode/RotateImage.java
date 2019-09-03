package com.leetcode;

/**
 * @author carl
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix.length < 2) return;
        if (matrix.length == 2) {
            move(matrix, 0, 0);
            return;
        }
        int n = matrix.length - 1;
        for (int i = 0; i < n; i++) {
            move(matrix, 0, i);
        }
        move(matrix, 1, 1);
    }

    private void move(int[][] matrix, int start_i, int start_j) {
        int t = matrix[start_i][start_j];
        int i = start_i, j = start_j;
        while (true) {
            int next_i = matrix.length - 1 - j, next_j = i;
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
