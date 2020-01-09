package com.leetcode.sixhundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author carl
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i > -1; i--) {
            int eq = map.getOrDefault(nums[i], 0);
            int less = map.getOrDefault(nums[i] - 1, 0);
            int more = map.getOrDefault(nums[i] + 1, 0);
            int diff = Math.max(less, more);
            if (diff > 0) {
                ans = Math.max(ans, diff + eq + 1);
            }
            map.put(nums[i], eq + 1);
        }
        return ans;
    }
}
