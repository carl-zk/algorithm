package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 * @auther carl
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}
