package com.leetcode.onehundredfifty;

import sun.jvm.hotspot.oops.InstanceKlass;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 * <p>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * @auther carl
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int[] sum = new int[triangle.size()];
        List<Integer> last = triangle.get(triangle.size() - 1);
        for (int i = 0; i < sum.length; i++) {
            sum[i] = last.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                sum[j] = cur.get(j) + Math.min(sum[j], sum[j + 1]);
            }
        }
        return sum[0];
    }
}
