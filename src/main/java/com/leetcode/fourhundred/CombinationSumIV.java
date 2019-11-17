package com.leetcode.fourhundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 * <p>
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example:
 * <p>
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * Note that different sequences are counted as different combinations.
 * <p>
 * Therefore the output is 7.
 * <p>
 * <p>
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 * <p>
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 *
 * @author carl
 */
public class CombinationSumIV {
    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        solve(nums, target);
        return map.get(target);
    }

    private int solve(int[] nums, int target) {
        if (target == 0) return 1;
        if (map.containsKey(target)) return map.get(target);
        int count = 0;
        for (int i = 0; i < nums.length && target >= nums[i]; i++) {
            count += solve(nums, target - nums[i]);
        }
        map.put(target, count);
        return count;
    }
}
