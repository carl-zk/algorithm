package com.leetcode.fourhundred;

import java.util.Comparator;
import java.util.PriorityQueue;

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
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            que.add(new int[]{matrix[i][0], i, 0});
        }

        int[] ans = null;

        while (k-- > 0) {
            ans = que.poll();
            if (ans[2] + 1 == n) continue;
            que.add(new int[]{matrix[ans[1]][ans[2] + 1], ans[1], ans[2] + 1});
        }
        return ans[0];
    }
}
