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

        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(45));

        int t = Integer.MAX_VALUE;
        System.out.println(t);

        System.out.println(Math.pow(3.0, 19.0));
    }
}
