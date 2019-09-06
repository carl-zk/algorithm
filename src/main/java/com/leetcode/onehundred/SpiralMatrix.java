package com.leetcode.onehundred;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author carl
 */
public class SpiralMatrix {
    List<Integer> ans;

    public List<Integer> spiralOrder(int[][] matrix) {
        ans = new LinkedList<>();
        if (matrix.length == 0) return ans;

        int upX = 0, bottomX = matrix.length - 1, leftY = 0, rightY = matrix[0].length - 1;

        while (upX <= bottomX && leftY <= rightY) {
            for (int i = leftY; i <= rightY; i++) {
                ans.add(matrix[upX][i]);
            }
            for (int i = upX + 1; i <= bottomX; i++) {
                ans.add(matrix[i][rightY]);
            }
            if (upX < bottomX && leftY < rightY) {
                for (int i = rightY - 1; i > leftY; i--) {
                    ans.add(matrix[bottomX][i]);
                }
                for (int i = bottomX; i > upX; i--) {
                    ans.add(matrix[i][leftY]);
                }
            }
            upX++;
            bottomX--;
            leftY++;
            rightY--;
        }
        return ans;
    }
}
