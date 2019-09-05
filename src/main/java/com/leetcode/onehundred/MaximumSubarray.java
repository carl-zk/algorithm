package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @author carl
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private int solve(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }
        int mid = (s + e) / 2;
        int left = solve(nums, s, mid);
        int right = solve(nums, mid + 1, e);
        int leftMax = 0, leftSum = 0;
        int rightMax = 0, rightSum = 0;
        for (int i = mid - 1; i >= s; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        for (int i = mid + 1; i <= e; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return Math.max(Math.max(left, right), leftMax + nums[mid] + rightMax);
    }
}
