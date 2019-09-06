package com.leetcode.onehundred;

/**
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
