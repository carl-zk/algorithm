package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 * @auther carl
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private int solve(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int mid = (start + end) >> 1;
        if (nums[mid] > nums[mid + 1]) return solve(nums, mid + 1, end);
        return Math.min(solve(nums, start, mid), solve(nums, mid + 1, end));
    }
}
