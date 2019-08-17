package com.leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * @author carl
 */
public class PalindromeNumber {
    int[] a = new int[15];
    int l, r;

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        l = r = 0;
        while (x > 0) {
            a[r] = x % 10;
            x /= 10;
            r++;
        }

        r--;
        while (l < r && a[l] == a[r]) {
            l++;
            r--;
        }

        return l >= r;
    }
}
