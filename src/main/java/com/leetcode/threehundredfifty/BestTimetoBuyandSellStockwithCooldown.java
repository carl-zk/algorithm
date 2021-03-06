package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p>
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * @auther carl
 */
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        int sell = 0, preSell = 0, buy = Integer.MIN_VALUE, preBuy = 0;

        for (int i = 0; i < prices.length; i++) {
            preBuy = buy;
            buy = Math.max(preSell - prices[i], preBuy);
            preSell = sell;
            sell = Math.max(preBuy + prices[i], preSell);
        }
        return sell;
    }
}
