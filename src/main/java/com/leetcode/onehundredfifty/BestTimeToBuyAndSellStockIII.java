package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @auther carl
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, sale1 = 0, buy2 = Integer.MIN_VALUE, sale2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sale1 = Math.max(sale1, prices[i] - buy1);
            buy2 = Math.max(buy2, sale1 - prices[i]);
            sale2 = Math.max(sale2, prices[i] + buy2);
        }
        return sale2;
    }
}
