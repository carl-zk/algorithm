package com.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author carl
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0, j, k, sum; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return target;
                }
                if (Math.abs(target - ans) > Math.abs(target - sum)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
