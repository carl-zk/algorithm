package com.leetcode;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * <p>
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 *
 * @author carl
 */
public class WildcardMatching {
    enum Result {
        TRUE,
        FALSE
    }

    Result[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Result[s.length()][p.length()];
        return solve(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean solve(char[] s, int i, char[] p, int j) {
        if (j == p.length) {
            return i == s.length;
        }
        if (i == s.length) {
            return p[j] == '*' && solve(s, i, p, j + 1);
        }
        if (dp[i][j] != null) {
            return dp[i][j] == Result.TRUE;
        }
        boolean firstMatch = p[j] == '?' || p[j] == s[i];

        dp[i][j] = p[j] == '*' && (solve(s, i, p, j + 1) || solve(s, i + 1, p, j))
                || firstMatch && solve(s, i + 1, p, j + 1) ? Result.TRUE : Result.FALSE;
        return dp[i][j] == Result.TRUE;
    }
}
