package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 * <p>
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * @author carl
 */
public class MaxPointsOnALine {
    int ans;

    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x = points[i + 1][0] - points[i][0];
            int y = points[i + 1][1] - points[i][1];
            if (x != 0 || y != 0) {
                solve(points, x, y, i);
            }
        }
        return ans == 0 ? points.length : ans;
    }

    private int solve(int[][] points, long x, long y, int base) {
        int counter = 2;
        for (int i = 0; i < points.length; i++) {
            if (i != base && i != base + 1) {
                if ((points[i][1] - points[base][1]) * x == (points[i][0] - points[base][0]) * y) {
                    counter++;
                }
            }
        }
        ans = Math.max(ans, counter);
        return counter;
    }

    public static void main(String[] args) {
        MaxPointsOnALine mp = new MaxPointsOnALine();
        System.out.println(mp.maxPoints(new int[][]{{0, 0}, {0, 1}}));
    }
}
