package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/number-complement/
 * <p>
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * <p>
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 * @author carl
 */
public class NumberComplement {

    public int findComplement(int num) {
        int ans = 0;
        int i = 0;
        while (num > 1) {
            int t = num & 1;
            if (t == 0) {
                ans |= 1 << i;
            }
            i++;
            num >>= 1;
        }
        return ans;
    }
}
