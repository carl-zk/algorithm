package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/house-robber-ii/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 * @auther carl
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(solve(nums, 0, nums.length - 2), solve(nums, 1, nums.length - 1));
    }

    private int solve(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int pre2, pre1;
        pre2 = nums[start];
        pre1 = Math.max(pre2, nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args) {
        HouseRobberII hr = new HouseRobberII();
        System.out.println(hr.rob(new int[]{2, 2, 4, 3, 2, 5}));
    }
}
