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
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (map.containsKey(e.getKey() + 1)) {
                ans = Math.max(ans, map.get(e.getKey() + 1) + e.getValue());
            }
        }
        return ans;
    }
}
