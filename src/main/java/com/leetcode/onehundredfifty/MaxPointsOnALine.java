package com.leetcode.onehundredfifty;

import java.util.HashMap;
import java.util.Map;

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

    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        Map<Long, Map<Long, Integer>> counter = new HashMap<>();
        int ans = 0;
        int max, overlap, column;
        for (int i = 0; i < points.length; i++) {
            counter.clear();
            max = 1;
            overlap = 0;
            column = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    overlap++;
                } else if (points[i][0] == points[j][0]) {
                    column++;
                } else {
                    long dy = points[j][1] - points[i][1];
                    long dx = points[j][0] - points[i][0];
                    long gc = gcd(dy, dx);
                    dy /= gc;
                    dx /= gc;
                    long a = (dy << 32) + dx;
                    dy = points[i][1] * dx - points[i][0] * dy;
                    gc = gcd(dy, dx);
                    dy /= gc;
                    dx /= gc;
                    long b = (dy << 32) + dx;
                    if (counter.get(a) == null) {
                        Map<Long, Integer> map = new HashMap<>();
                        map.put(b, 2);
                        counter.put(a, map);
                        max = Math.max(max, 2);
                    } else {
                        int cnt = 1 + counter.get(a).get(b);
                        counter.get(a).put(b, cnt);
                        max = Math.max(max, cnt);
                    }
                }
                max = Math.max(max, column);
            }
            ans = Math.max(ans, max + overlap);
        }
        return ans;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaxPointsOnALine mp = new MaxPointsOnALine();
        System.out.println(mp.maxPoints(new int[][]{{0, 0}, {0, 1}}));
    }
}
