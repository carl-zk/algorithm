package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * <p>
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * <p>
 * Example:
 * <p>
 * n = 10, I pick 8.
 * <p>
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * <p>
 * Game over. 8 is the number I picked.
 * <p>
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 *
 * @author carl
 */
public class GuessNumberHigherorLowerII {
    int[][] dp;

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return solve(1, n);
    }

    private int solve(int s, int e) {
        if (s >= e) return 0;
        if (dp[s][e] != 0) return dp[s][e];
        dp[s][e] = Integer.MAX_VALUE;

        for (int i = s; i <= e; i++) {
            int max = Math.max(solve(s, i - 1), solve(i + 1, e)) + i;
            dp[s][e] = Math.min(dp[s][e], max);
        }
        return dp[s][e];
    }
}
