package com.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author carl
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] sums = new int[(nums.length * (nums.length - 1)) >> 1];
        for (int i = 0, k = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sums[k++] = nums[i] + nums[j];
            }
        }
        return null;
    }
}
