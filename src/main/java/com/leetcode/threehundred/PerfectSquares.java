package com.leetcode.threehundred;

/**
 * @auther carl
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int count = 0;
        while (n > 0) {
            int x = (int) Math.sqrt(n);
            n -= x * x;
            count++;
        }
        return count;
    }
}
