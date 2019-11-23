package com.leetcode.fourhundredfifty;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * <p>
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given the following 3x6 height map:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * <p>
 * Return 4.
 * <p>
 * <p>
 * The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * After the rain, water is trapped between the blocks. The total volume of water trapped is 4.
 *
 * @author carl
 */
public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = heightMap.length;
        int n = m == 0 ? 0 : heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            que.add(new int[]{i, 0, heightMap[i][0]});
            que.add(new int[]{i, n - 1, heightMap[i][n - 1]});
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            que.add(new int[]{0, i, heightMap[0][i]});
            que.add(new int[]{m - 1, i, heightMap[m - 1][i]});
        }

        int res = 0;

        while (!que.isEmpty()) {
            int[] cell = que.poll();
            for (int[] dir : directions) {
                int r = cell[0] + dir[0], c = cell[1] + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) continue;
                res += Math.max(0, cell[2] - heightMap[r][c]);
                visited[r][c] = true;
                que.add(new int[]{r, c, Math.max(cell[2], heightMap[r][c])});
            }
        }

        return res;
    }
}
