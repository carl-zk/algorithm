package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/power-of-two/
 * <p>
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 * <p>
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * <p>
 * Input: 218
 * Output: false
 *
 * @auther carl
 */
public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        long i = 1;
        while (i < n) {
            i <<= 1;
        }
        return i == n;
    }

    public static void main(String[] args) {
        PowerofTwo p = new PowerofTwo();
        System.out.println(p.isPowerOfTwo(1073741825));
    }
}
