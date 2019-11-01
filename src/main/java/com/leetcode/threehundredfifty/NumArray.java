package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 * @auther carl
 */
public class NumArray {
    int[] nums;
    long[] sum;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sum = new long[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return (int) (sum[j + 1] - sum[i]);
    }
}
