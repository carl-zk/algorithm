package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/plus-one/
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * @author carl
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int up = 0;
        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i > -1; i--) {
            digits[i] += up;
            if (digits[i] > 9) {
                digits[i] = 0;
                up = 1;
            } else {
                up = 0;
                break;
            }
        }
        int[] ans = digits;
        if (up > 0) {
            ans = new int[digits.length + 1];
            System.arraycopy(digits, 0, ans, 1, digits.length);
            ans[0] = 1;
        }
        return ans;
    }
}
