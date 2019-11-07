package com.leetcode.threehundredfifty;

/**
 * @auther carl
 */
public class BestTimetoBuyandSellStockwithCooldown {
    int maxProfit = Integer.MIN_VALUE;
    int[][] mem;

    public int maxProfit(int[] prices) {
        mem = new int[prices.length][prices.length];
        solve(prices, 0, -1, 0);
        return maxProfit;
    }

    private void solve(int[] prices, int index, int lastBuyAt, int profit) {
        if (index >= prices.length) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }
        if (lastBuyAt != -1 && profit < mem[index][lastBuyAt]) return;
        if (lastBuyAt != -1) {
            mem[index][lastBuyAt] = profit;
        }
        if (lastBuyAt != -1) {
            if (prices[index] > prices[lastBuyAt]) {
                solve(prices, index + 2, -1, profit + prices[index] - prices[lastBuyAt]);
            }
            solve(prices, index + 1, lastBuyAt, profit);
        } else {
            solve(prices, index + 1, index, profit);
            solve(prices, index + 1, lastBuyAt, profit);
        }
    }
}
