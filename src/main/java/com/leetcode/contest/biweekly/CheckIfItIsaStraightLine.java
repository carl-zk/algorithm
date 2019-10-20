package com.leetcode.contest.biweekly;

/**
 * 5230. Check If It Is a Straight Line
 *
 * @author carl
 */
public class CheckIfItIsaStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][1] - coordinates[i - 1][1]) * dx != (coordinates[i][0] - coordinates[i - 1][0]) * dy)
                return false;
        }
        return true;
    }
}
