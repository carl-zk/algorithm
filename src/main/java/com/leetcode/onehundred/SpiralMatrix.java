package com.leetcode.onehundred;

import java.util.LinkedList;
import java.util.List;

/**
 * @author carl
 */
public class SpiralMatrix {
    List<Integer> ans;

    public List<Integer> spiralOrder(int[][] matrix) {
        ans = new LinkedList<>();
        if (matrix.length == 0) return ans;

        int cnt = matrix.length * matrix[0].length;
        int upX = 0, bottomX = matrix.length - 1, leftY = 0, rightY = matrix[0].length - 1;

        while (cnt > 0) {
            for (int i = leftY; i <= rightY; i++) {
                ans.add(matrix[upX][i]);
                cnt--;
                if (cnt == 0) return ans;
            }
            upX++;
            for (int i = upX; i <= bottomX; i++) {
                ans.add(matrix[i][rightY]);
                cnt--;
                if (cnt == 0) return ans;
            }
            rightY--;
            for (int i = rightY; i >= leftY; i--) {
                ans.add(matrix[bottomX][i]);
                cnt--;
                if (cnt == 0) return ans;
            }
            bottomX--;
            for (int i = bottomX; i >= upX; i--) {
                ans.add(matrix[i][leftY]);
                cnt--;
                if (cnt == 0) return ans;
            }
            leftY++;
        }
        return ans;
    }
}
