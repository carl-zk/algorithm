package com.leetcode.twohundred;

import java.util.Arrays;

/**
 * @auther carl
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int gap = nums[1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(gap, nums[i] - nums[i - 1]);
        }
        return gap;
    }
}
