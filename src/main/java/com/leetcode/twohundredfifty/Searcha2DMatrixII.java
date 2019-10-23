package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 *
 * @auther carl
 */
public class Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (search(nums, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] nums, int target) {
        int h = 0, t = nums.length - 1, m;
        while (h <= t) {
            m = (h + t) >> 1;
            if (nums[m] == target) {
                return true;
            } else if (nums[m] < target) {
                h = m + 1;
            } else {
                t = m - 1;
            }
        }
        return false;
    }
}
