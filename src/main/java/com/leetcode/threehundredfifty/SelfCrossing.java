package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/self-crossing/
 * <p>
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.
 * <p>
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * ┌───┐
 * │   │
 * └───┼──>
 * │
 * <p>
 * Input: [2,1,1,2]
 * Output: true
 * Example 2:
 * <p>
 * ┌──────┐
 * │      │
 * │
 * │
 * └────────────>
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * ┌───┐
 * │   │
 * └───┼>
 * <p>
 * Input: [1,1,1,1]
 * Output: true
 *
 * @auther carl
 */
public class SelfCrossing {

    public boolean isSelfCrossing(int[] x) {
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
        for (int g : x) {
            f = e;
            e = d;
            d = c;
            c = b;
            b = a;
            a = g;
            if (b > 0 && c > 0 && c <= a && d >= b) return true;
            if (a > 0 && b > 0 && c > 0 && d >= b && e <= c && e + a >= c && b + f >= d) return true;
        }
        return false;
    }
}
