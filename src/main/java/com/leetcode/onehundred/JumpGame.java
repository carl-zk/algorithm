package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/jump-game/
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 * @author carl
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;

        int cur = 0;
        int next = nums[0];

        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, nums[i] + i);
            if (i == cur) {
                cur = next;
            }
        }
        return cur >= nums.length - 1;
    }
}
