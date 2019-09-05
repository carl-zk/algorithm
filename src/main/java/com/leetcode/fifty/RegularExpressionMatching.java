package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * <p>
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
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
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * @author carl
 */
public class RegularExpressionMatching {
    enum Result {
        TRUE,
        FALSE
    }

    Result[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Result[s.length() + 1][p.length()];
        return process(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean process(char[] s, char[] p, int i, int j) {
        if (j == p.length) {
            return i == s.length;
        }

        if (dp[i][j] != null) {
            return dp[i][j] == Result.TRUE;
        }

        boolean firstMatch = i < s.length && (s[i] == p[j] || p[j] == '.');

        if (j + 1 < p.length && p[j + 1] == '*') {
            dp[i][j] = process(s, p, i, j + 2)
                    || firstMatch && process(s, p, i + 1, j) ? Result.TRUE : Result.FALSE;
        } else {
            dp[i][j] = firstMatch && process(s, p, i + 1, j + 1) ? Result.TRUE : Result.FALSE;
        }

        return dp[i][j] == Result.TRUE;
    }
}
