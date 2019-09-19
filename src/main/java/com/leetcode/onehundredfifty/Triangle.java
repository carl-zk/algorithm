package com.leetcode.onehundredfifty;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * @auther carl
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        for (int i = triangle.size() - 1; i > 0; i--) {
            List<Integer> up = triangle.get(i - 1);
            List<Integer> down = triangle.get(i);
            for (int j = 0; j < i; j++) {
                up.set(j, up.get(j) + Math.min(down.get(j), down.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
