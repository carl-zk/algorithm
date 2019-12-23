package com.leetcode.fivehundredfifty;

import java.util.HashMap;
import java.util.Map;

/**
 * I thought out by my own.
 *
 * @author carl
 */
public class ContiguousArray {
    Map<Integer, Integer> memo = new HashMap<>();
    int max = 0;

    public int findMaxLength(int[] nums) {
        int t = 0;
        memo.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            t += nums[i] == 1 ? 1 : -1;
            Integer v = memo.get(t);
            if (v != null) {
                max = Math.max(max, i - v);
            } else memo.put(t, i);
        }
        return max;
    }
}
