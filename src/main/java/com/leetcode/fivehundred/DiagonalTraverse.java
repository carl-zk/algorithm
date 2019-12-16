package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/diagonal-traverse/
 * 498. Diagonal Traverse
 *
 * @author carl
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int M = matrix.length;
        int N = matrix[0].length;
        int[] ans = new int[M * N];
        int k = 0, i = 0, j = 0;
        while (k < ans.length) {
            while (0 <= i && i < M && 0 <= j && j < N) {
                ans[k++] = matrix[i--][j++];
            }
            if (j == N) {
                i = i + 2;
                j = N - 1;
            } else i += 1;
            while (0 <= i && i < M && 0 <= j && j < N) {
                ans[k++] = matrix[i++][j--];
            }
            if (i == M) {
                i = M - 1;
                j = j + 2;
            } else j += 1;
        }
        return ans;
    }
}
