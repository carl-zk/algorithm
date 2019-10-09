package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * <p>
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 * <p>
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 * @auther carl
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
