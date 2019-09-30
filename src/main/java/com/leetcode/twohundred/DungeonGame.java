package com.leetcode.twohundred;

/**
 * @auther carl
 */
public class DungeonGame {
    int[][] least;
    int[][] remain;

    public int calculateMinimumHP(int[][] dungeon) {
        least = new int[dungeon.length][dungeon[0].length];
        remain = new int[dungeon.length][dungeon[0].length];
        least[0][0] = 1;
        remain[0][0] = 1;
        if (dungeon[0][0] < 0) {
            least[0][0] = 1 - dungeon[0][0];
        }
        for (int j = 1; j < dungeon[0].length; j++) {
            remain[0][j] = remain[0][j - 1] + dungeon[0][j];
            least[0][j] = least[0][j - 1];
            if (remain[0][j] <= 0) {
                least[0][j] = least[0][j - 1] - remain[0][j] + 1;
                remain[0][j] = 1;
            }
        }
        for (int i = 1; i < dungeon.length; i++) {
            remain[i][0] = remain[i - 1][0] + dungeon[i][0];
            least[i][0] = least[i - 1][0];
            if (remain[i][0] <= 0) {
                least[i][0] = least[i - 1][0] - remain[i][0] + 1;
                remain[i][0] = 1;
            }
        }
        for (int i = 1; i < dungeon.length; i++) {
            for (int j = 1; j < dungeon[0].length; j++) {
                int remain1 = remain[i - 1][j] + dungeon[i][j];
                int least1 = least[i - 1][j];
                if (remain1 <= 0) {
                    least1 = least[i - 1][j] - remain1 + 1;
                    remain1 = 1;
                }
                int remain2 = remain[i][j - 1] + dungeon[i][j];
                int least2 = least[i][j - 1];
                if (remain2 <= 0) {
                    least2 = least[i][j - 1] - remain2 + 1;
                    remain2 = 1;
                }
                if (least1 < least2) {
                    least[i][j] = least1;
                    remain[i][j] = remain1;
                } else {
                    least[i][j] = least2;
                    remain[i][j] = remain2;
                }
            }
        }
        return least[dungeon.length - 1][dungeon[0].length - 1];
    }

    public static void main(String[] args) {
        DungeonGame game = new DungeonGame();
        System.out.println(game.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }
}
