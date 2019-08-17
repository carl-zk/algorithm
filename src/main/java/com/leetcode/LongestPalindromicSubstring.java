package com.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author carl
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }

        int[][] p = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                p[i][j] = -1;
            }
        }
        p[0][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            p[i][i] = 1;
            p[i - 1][i] = s.charAt(i) == s.charAt(i - 1) ? 1 : 0;
        }

        int l = 0, r = 0, len = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (solve(p, i, j, s) == 1 && j - i > len) {
                    l = i;
                    r = j;
                    len = r - l;
                }
            }
        }

        return s.substring(l, r + 1);
    }

    private int solve(int[][] p, int i, int j, String s) {
        if (p[i][j] != -1) {
            return p[i][j];
        }
        p[i][j] = (solve(p, i + 1, j - 1, s) == 1
                && s.charAt(i) == s.charAt(j)) ? 1 : 0;
        return p[i][j];
    }
}
