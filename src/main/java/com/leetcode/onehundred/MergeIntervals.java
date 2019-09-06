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

        Seg[] segs = new Seg[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            segs[i] = new Seg(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(segs, Comparator.comparingInt(a -> a.t));
        ArrayList<Seg> list = new ArrayList<>();
        Seg cur = segs[0];
        for (int i = 1; i < segs.length; i++) {
            if (cur.t < segs[i].h) {
                list.add(cur);
                cur = segs[i];
            } else if (cur.h < segs[i].h) {
                cur.t = segs[i].t;
            } else {
                cur = segs[i];
            }
        }
        list.add(cur);
        list.sort(Comparator.comparingInt(a -> a.h));
        List<Seg> res = new LinkedList<>();
        cur = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (cur.t < list.get(i).h) {
                res.add(cur);
                cur = list.get(i);
            } else if (cur.t < list.get(i).t) {
                cur.t = list.get(i).t;
            }
        }
        res.add(cur);

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new int[]{res.get(i).h, res.get(i).t};
        }
        return ans;
    }

    static class Seg {
        public int h;
        public int t;

        public Seg(int h, int t) {
            this.h = h;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        System.out.println(mi.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}}));
        System.out.println(mi.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }
}
