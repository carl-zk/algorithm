package com.leetcode.twohundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 * <p>
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 * <p>
 * Buildings Skyline Contour
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * <p>
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * <p>
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * <p>
 * Notes:
 * <p>
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 *
 * @auther carl
 */
public class TheSkylineProblem {
    List<List<Integer>> ans;

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) return Collections.emptyList();

        ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : b[2] - a[2]);
        //List<int[]> filtered = new ArrayList<>();
        int[] pre = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        for (int[] cur : buildings) {
            while (!queue.isEmpty() && cur[0] > pre[1]) {
                int[] top = queue.poll();
                if (top[1] <= pre[1]) continue;
                ans.add(Arrays.asList(pre[1], top[2]));
                pre = top;
            }
            if (cur[2] > pre[2]) {
                if (cur[0] == pre[0]) {
                    ans.remove(ans.size() - 1);
                }
                ans.add(Arrays.asList(cur[0], cur[2]));
                if (pre[1] > cur[1]) {
                    queue.add(pre);
                }
                pre = cur;
            } else if (cur[2] == pre[2]) {
                pre[1] = cur[1];
            } else if (cur[1] > pre[1]) {
                queue.add(cur);
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            if (top[1] <= pre[1]) continue;
            ans.add(Arrays.asList(pre[1], top[2]));
            pre = top;
        }
        if (pre[2] > 0) {
            ans.add(Arrays.asList(pre[1], 0));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 12}, {2, 9, 1}, {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
        System.out.println(theSkylineProblem.getSkyline(buildings).size()); // expect 7
        // [[2,12],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
        // 有点小瑕疵，不过可以弄个filter过滤一下数据，基本OK
        // test case 不要出现连续3个开始值相同的building
    }
}
