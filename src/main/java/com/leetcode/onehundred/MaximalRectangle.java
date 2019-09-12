package com.leetcode.onehundred;

/**
 * @auther carl
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] dpR = new int[matrix.length][matrix[0].length];
        int[][] dpC = new int[matrix.length][matrix[0].length];
        int[][] dpAngle = new int[matrix.length][matrix[0].length];
        int ans = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                if (i == 0) {
                    dpR[0][i] = 1;
                } else {
                    dpR[0][i] = 1 + dpR[0][i - 1];
                }
                if (dpR[0][i] > ans) {
                    ans = dpR[0][i];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                if (i == 0) {
                    dpC[i][0] = 1;
                } else {
                    dpC[i][0] = 1 + dpC[i - 1][0];
                }
                if (dpC[i][0] > ans) {
                    ans = dpC[i][0];
                }
            }
        }

        if (matrix[0][0] == '1') {
            dpAngle[0][0] = 1;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dpR[i][j] = dpR[i][j - 1] + 1;
                    dpC[i][j] = dpC[i - 1][j] + 1;
                    if (matrix[i][j - 1] == '1' && matrix[i - 1][j] == '1') {
                        dpAngle[i][j] = dpAngle[i - 1][j - 1] + 1;
                    } else {
                        dpAngle[i][j] = 1;
                    }

                }
            }
        }
        return 0;
    }
}
