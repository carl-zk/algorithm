package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * <p>
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * Example 1:
 * <p>
 * Input: [5,7]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [0,1]
 * Output: 0
 *
 * @auther carl
 */
public class BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) n &= (n - 1);
        return n;
    }

    public static void main(String[] args) {
        BitwiseANDOfNumbersRange b = new BitwiseANDOfNumbersRange();
        System.out.println(b.rangeBitwiseAnd(5, 7));
    }
}
