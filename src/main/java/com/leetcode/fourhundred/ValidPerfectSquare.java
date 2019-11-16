package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 * <p>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * Example 2:
 * <p>
 * Input: 14
 * Output: false
 *
 * @author carl
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long ans = 0;
        int start = 0, end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            ans = mid;
            ans *= ans;
            if (ans == num) return true;
            else if (ans < num) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return false;
    }
}
