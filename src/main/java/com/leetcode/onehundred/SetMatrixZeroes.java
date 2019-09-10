package com.leetcode.onehundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * <p>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 * @auther carl
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstLine = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstLine = true;
                break;
            }
        }
        boolean hasZero;
        for (int i = 1; i < m; i++) {
            hasZero = false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    hasZero = true;
                    matrix[0][j] = 0;
                }
            }
            if (hasZero) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    if (matrix[j][i] != 0) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
        if (firstLine) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
