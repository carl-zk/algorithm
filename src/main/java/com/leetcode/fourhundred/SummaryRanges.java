package com.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 * <p>
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 *
 * @auther carl
 */
public class SummaryRanges {
    List<int[]> list;

    public SummaryRanges() {
        list = new ArrayList<>();
    }

    public void addNum(int val) {
        int[] p = new int[]{val, val};
        List<int[]> temp = new ArrayList<>();

        for (int[] q : list) {
            if (p[1] + 1 < q[0]) {
                temp.add(p);
                p = q;
            } else if (q[1] + 1 < p[0]) {
                temp.add(q);
            } else {
                p[0] = Math.min(p[0], q[0]);
                p[1] = Math.max(p[1], q[1]);
            }
        }
        temp.add(p);
        list = temp;
    }

    public int[][] getIntervals() {
        return list.toArray(new int[list.size()][]);
    }
}
