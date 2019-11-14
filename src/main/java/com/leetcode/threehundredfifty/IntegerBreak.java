package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/integer-break/
 * <p>
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * <p>
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * @author carl
 */
public class IntegerBreak {
    int[] dp = new int[60];

    public int integerBreak(int n) {
        if (n == 1) return 1;
        if (dp[n] != 0) return dp[n];
        int mid = n >> 1;
        for (int i = 1; i <= mid; i++) {
            dp[n] = Math.max(dp[n], Math.max(i, integerBreak(i)) * Math.max(n - i, integerBreak(n - i)));
        }
        return dp[n];
    }
}
