package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * <p>
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * <p>
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 * @author carl
 */
public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;

        if (k >= prices.length / 2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    maxPro += prices[i] - prices[i - 1];
            }
            return maxPro;
        }

        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }
}
