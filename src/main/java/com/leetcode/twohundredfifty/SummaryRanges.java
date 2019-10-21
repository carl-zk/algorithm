package com.leetcode.twohundredfifty;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * <p>
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 * <p>
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 *
 * @auther carl
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j - 1] + 1 != nums[j]) {
                ans.add(i == j - 1 ? "" + nums[i] : nums[i] + "->" + nums[j - 1]);
                i = j;
            }
        }
        if (i < nums.length) {
            ans.add(i == nums.length - 1 ? "" + nums[i] : nums[i] + "->" + nums[nums.length - 1]);
        }
        return ans;
    }
}
