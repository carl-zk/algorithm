package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 * <p>
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 *
 * @auther carl
 */
public class FindMinimumInRotatedSortedArrayII {

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
