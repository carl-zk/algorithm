package com.leetcode.twohundred;

/**
 * @author carl
 */
public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        MinHeap minHeap = new MinHeap(k);
        int lastBuy = -1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                if (lastBuy == -1) {
                    lastBuy = prices[i - 1];
                }
            } else if (prices[i - 1] > prices[i]) {
                if (lastBuy != -1 && prices[i - 1] > lastBuy) {
                    minHeap.add(prices[i - 1] - lastBuy);
                    lastBuy = -1;
                }
            }
        }
        if (lastBuy != -1 && prices[prices.length - 1] > lastBuy) {
            minHeap.add(prices[prices.length - 1] - lastBuy);
        }
        int ans = 0;
        for (int i = 0; i < minHeap.size; i++) {
            ans += minHeap.values[i];
        }
        return ans;
    }

    static class MinHeap {
        int[] values;
        int size;
        int capacity;

        public MinHeap(int capacity) {
            this.values = new int[capacity];
            this.capacity = capacity;
            this.size = 0;
        }

        public void add(int value) {
            if (size == capacity) {
                swap(0, size - 1);
                size--;
            }
            values[size++] = value;
            shiftUp(p(size - 1));
        }

        private void shiftUp(int i) {
            boolean changed = false;
            if (lc(i) < size && values[lc(i)] < values[i]) {
                swap(lc(i), i);
                changed = true;
            }
            if (rc(i) < size && values[rc(i)] < values[i]) {
                swap(rc(i), i);
                changed = true;
            }
            if (changed) {
                shiftUp(p(i));
            }
        }

        private int lc(int i) {
            return i * 2 + 1;
        }

        private int rc(int i) {
            return i * 2 + 2;
        }

        private int p(int i) {
            return (i - 1) / 2;
        }

        private void swap(int i, int j) {
            int t = values[i];
            values[i] = values[j];
            values[j] = t;
        }
    }
}
