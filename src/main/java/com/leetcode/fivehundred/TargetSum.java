package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/target-sum/
 *
 * @author carl
 */
public class TargetSum {
    int ans = 0;
    int target;

    public int findTargetSumWays(int[] nums, int S) {
        target = S;
        solve(nums, 0, 0);
        return ans;
    }

    private void solve(int[] nums, int i, int sum) {
        if (i == nums.length) {
            ans += sum == target ? 1 : 0;
            return;
        }
        solve(nums, i + 1, sum + nums[i]);
        solve(nums, i + 1, sum - nums[i]);
    }
}
