package com.leetcode.onehundred;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * @auther carl
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;

        List<int[]> ans = new ArrayList<>();
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int j = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (ends[i] < starts[i + 1]) {
                ans.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        ans.add(new int[]{starts[j], ends[intervals.length - 1]});
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        System.out.println(mi.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}}));
        System.out.println(mi.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }
}
