package com.leetcode.fourhundredfifty;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-right-interval/
 * <p>
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 * <p>
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.
 * <p>
 * Note:
 * <p>
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [ [1,2] ]
 * <p>
 * Output: [-1]
 * <p>
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [ [3,4], [2,3], [1,2] ]
 * <p>
 * Output: [-1, 0, 1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: [ [1,4], [2,3], [3,4] ]
 * <p>
 * Output: [-1, 2, -1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * @author carl
 */
public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i][0], i);
        }

        int[] ans = new int[intervals.length];
        Map.Entry<Integer, Integer> e;

        for (int i = 0; i < intervals.length; i++) {
            e = treeMap.ceilingEntry(intervals[i][1]);
            ans[i] = e == null ? -1 : e.getValue();
        }
        return ans;
    }
}
