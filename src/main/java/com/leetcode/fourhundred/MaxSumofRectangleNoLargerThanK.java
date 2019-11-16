package com.leetcode.fourhundred;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * <p>
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 * <p>
 * Example:
 * <p>
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 * and 2 is the max number no larger than k (k = 2).
 * Note:
 * <p>
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 *
 * @author carl
 */
public class MaxSumofRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int[] sums = new int[col];
            for (int j = i; j < row; j++) {
                for (int c = 0; c < col; c++) {
                    sums[c] += matrix[j][c];
                }
                ans = Math.max(ans, findMax(sums, k));
            }
        }
        return ans;
    }

    private int findMax(int[] nums, int k) {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(0);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer leastGreater = tree.ceiling(sum - k);
            max = leastGreater == null ? max : Math.max(max, sum - leastGreater);
            tree.add(sum);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumofRectangleNoLargerThanK ms = new MaxSumofRectangleNoLargerThanK();
        System.out.println(ms.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0));
    }
}
