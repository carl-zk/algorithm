package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/ones-and-zeroes/
 * <p>
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * <p>
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 * <p>
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * <p>
 * Note:
 * <p>
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * <p>
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * <p>
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 *
 * @author carl
 */
public class OnesandZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int ones = calcOnes(str), zeros = str.length() - ones;
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - zeros][k - ones]);
                }
            }
        }
        return dp[m][n];
    }

    private int calcOnes(String str) {
        int ones = 0;
        for (char c : str.toCharArray()) ones += c - '0';
        return ones;
    }

    public static void main(String[] args) {
        OnesandZeroes oz = new OnesandZeroes();
        System.out.println(oz.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
