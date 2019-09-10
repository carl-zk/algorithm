package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 * @auther carl
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int s = 0, e = matrix.length - 1;
        while (s < e) {
            int mid = (s + e) >> 1;
            if (matrix[mid][matrix[mid].length - 1] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        int i = e;
        s = 0;
        e = matrix[i].length - 1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (matrix[i][mid] == target) {
                return true;
            }
            if (matrix[i][mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;
    }
}
