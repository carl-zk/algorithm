package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/house-robber/
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * @auther carl
 */
public class HouseRobber {
    int ans;
    int[] mem;

    public int rob(int[] nums) {
        ans = 0;
        mem = new int[nums.length];
        int cur = 0;
        while (cur < nums.length && nums[cur] == 0) cur++;
        solve(nums, cur, 0);
        return ans;
    }

    private void solve(int[] nums, int cur, int sum) {
        if (cur >= nums.length) {
            ans = Math.max(ans, sum);
            return;
        }
        if (sum < mem[cur]) return;
        mem[cur] = sum;
        solve(nums, cur + 2, sum + nums[cur]);
        solve(nums, cur + 1, sum);
    }
}
