package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/power-of-three/
 * <p>
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:
 * <p>
 * Input: 27
 * Output: true
 * Example 2:
 * <p>
 * Input: 0
 * Output: false
 * Example 3:
 * <p>
 * Input: 9
 * Output: true
 * Example 4:
 * <p>
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * @auther carl
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        long m = 1;
        while (m < n) {
            m *= 3;
        }
        return m == n;
    }

    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(45));
    }
}
