package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @auther carl
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int ans = nums[0];
        for (int i = 1, min = nums[0], max = nums[0]; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = min;
                min = max;
                max = t;
            }
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
