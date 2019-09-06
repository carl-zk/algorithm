package com.leetcode.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * @auther carl
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 && newInterval.length == 0) return intervals;

        List<int[]> ans = new ArrayList<>();
        int[] starts = new int[intervals.length + 1];
        int[] ends = new int[intervals.length + 1];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        starts[starts.length - 1] = newInterval[0];
        ends[ends.length - 1] = newInterval[1];

        Arrays.sort(starts);
        Arrays.sort(ends);

        int j = 0;
        for (int i = 0; i < starts.length - 1; i++) {
            if (ends[i] < starts[i + 1]) {
                ans.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        ans.add(new int[]{starts[j], ends[ends.length - 1]});
        return ans.toArray(new int[ans.size()][]);
    }
}
