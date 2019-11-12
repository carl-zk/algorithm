package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/count-of-range-sum/
 * <p>
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * <p>
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * <p>
 * Example:
 * <p>
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 *
 * @auther carl
 */
public class CountofRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long[] copy = new long[sum.length];
        return mergeSort(sum, copy, 0, n, lower, upper);
    }

    private int mergeSort(long[] sums, long[] copy, int start, int end, int lower, int upper) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int count = mergeSort(sums, copy, start, mid, lower, upper) +
                mergeSort(sums, copy, mid + 1, end, lower, upper);
        count += merge(sums, copy, start, mid, end, lower, upper);
        return count;
    }

    private int merge(long[] sums, long[] copy, int start, int mid, int end, int lower, int upper) {
        int l = mid + 1, r = mid + 1;
        int index = start, j = mid + 1;
        int count = 0;
        for (int i = start; i <= mid; i++) {
            while (l <= end && sums[l] - sums[i] < lower) l++;
            while (r <= end && sums[r] - sums[i] <= upper) r++;
            while (j <= end && sums[j] < sums[i]) copy[index++] = sums[j++];
            count += r - l;
            copy[index++] = sums[i];
        }
        System.arraycopy(sums, j, copy, index, end - j + 1);
        System.arraycopy(copy, start, sums, start, end - start + 1);
        return count;
    }
}
