package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * @auther carl
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] count = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
            ans = Math.max(ans, count[i]);
        }
        return ans;
    }
}
