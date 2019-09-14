package com.leetcode.onehundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-ways/
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * @author carl
 */
public class DecodeWays {
    int[] dp;

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;

        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(s.toCharArray(), 0);
    }

    private int solve(char[] cs, int cur) {
        if (cur == cs.length) {
            return 1;
        }
        if (cs[cur] == '0') {
            return 0;
        }
        if (dp[cur] != -1) return dp[cur];
        int count = solve(cs, cur + 1);

        if (cur + 1 < cs.length && cs[cur] == '1') {
            count += solve(cs, cur + 2);
        }
        if (cur + 1 < cs.length && cs[cur] == '2' && cs[cur + 1] >= '0' && cs[cur + 1] <= '6') {
            count += solve(cs, cur + 2);
        }
        return dp[cur] = count;
    }
}
