package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * <p>
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * <p>
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding 11,22,33,44,55,66,77,88,99
 *
 * @auther carl
 */
public class CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 10, base = 9;
        for (int i = 2; i <= 10 & i <= n; i++) {
            base *= (9 - i + 2);
            ans += base;
        }
        return ans;
    }
}
