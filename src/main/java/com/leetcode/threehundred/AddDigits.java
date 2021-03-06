package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/add-digits/
 * <p>
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * Example:
 * <p>
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * @auther carl
 */
public class AddDigits {

    public int addDigits(int num) {
        int ans = num % 9;
        return num == 0 ? 0 : ans == 0 ? 9 : ans;
    }
}
