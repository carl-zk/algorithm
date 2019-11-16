package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * <p>
 * Input: a = -2, b = 3
 * Output: 1
 *
 * @author carl
 */
public class SumofTwoIntegers {

    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
