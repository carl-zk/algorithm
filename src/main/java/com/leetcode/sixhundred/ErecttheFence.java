package com.leetcode.sixhundred;

import java.util.HashSet;
import java.util.Set;

/**
 * @author carl
 */
public class ErecttheFence {

    public int[][] outerTrees(int[][] points) {
        if (points.length < 4) {
            return points;
        }
        int l = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] < points[l][0]) {
                l = i;
            }
        }
        Set<Integer> set = new HashSet<>();
        int p = l, q;
        do {
            set.add(p);
            q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++) {
                if (orientation(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }
            for (int i = 0; i < points.length; i++) {
                if (i != p && i != q && orientation(points[p], points[i], points[q]) == 0) {
                    set.add(i);
                }
            }
            p = q;
        } while (p != l);
        int[][] ans = new int[set.size()][2];
        int j = 0;
        for (int i : set) {
            ans[j++] = points[i];
        }
        return ans;
    }

    /**
     * orientation of p,q,r
     *
     * @param p
     * @param q
     * @param r
     * @return eq 0 : colinear; > 0 : clockwise; < 0 : counterclockwise;
     */
    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (r[1] - q[1]) * (q[0] - p[0]);
    }
}
