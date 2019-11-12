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
        int ans = 0;
        for (int i = 1; i < sum.length; i++) {
            for (int j = i; j < sum.length; j++) {
                long total = sum[j] - sum[i - 1];
                ans += lower <= total && total <= upper ? 1 : 0;
            }
        }
        return ans;
    }
}
