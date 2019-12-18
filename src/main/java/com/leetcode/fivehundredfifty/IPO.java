package com.leetcode.fivehundredfifty;

import java.util.PriorityQueue;

/**
 * @author carl
 */
public class IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[]{Capital[i], Profits[i]});
        }
        while (k-- > 0) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) pqPro.add(pqCap.poll());
            if (pqPro.isEmpty()) break;
            W += pqPro.poll()[1];
        }
        return W;
    }
}
