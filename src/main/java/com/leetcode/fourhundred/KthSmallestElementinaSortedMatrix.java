package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * <p>
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * @author carl
 */
public class KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], heigh = matrix[matrix.length - 1][matrix.length - 1];
        while (low <= heigh) {
            int mid = low + (heigh - low) / 2;
            int count = search(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                heigh = mid - 1;
            }
        }
        return low;
    }

    private int search(int[][] matrix, int value) {
        int count = 0;
        int i = matrix.length - 1, j = 0;

        while (i > -1 && j < matrix[0].length) {
            if (matrix[i][j] <= value) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
