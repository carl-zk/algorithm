package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/power-of-four/
 * <p>
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * Example 2:
 * <p>
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 *
 * @author carl
 */
public class PowerofFour {

    public boolean isPowerOfFour(int num) {
        int n = 1;
        for (int i = 0; i < 32 && n <= num; i += 2) {
            if (n == num) return true;
            n <<= 2;
        }
        return false;
    }
}
