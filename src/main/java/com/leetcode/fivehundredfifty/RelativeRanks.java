package com.leetcode.fivehundredfifty;

import java.util.PriorityQueue;

/**
 * @author carl
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }
        String[] title = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] ans = new String[nums.length];
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            ans[pq.poll()[1]] = title[i];
        }
        for (int i = 4; i <= nums.length; i++) {
            ans[pq.poll()[1]] = "" + i;
        }
        return ans;
    }
}
