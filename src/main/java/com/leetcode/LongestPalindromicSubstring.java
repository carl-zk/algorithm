package com.leetcode;

/**
 * @author carl
 */
public class LongestPalindromicSubstring {
    static final int MAX = 1000;
    int[][] s = new int[MAX][MAX];
    int l, r;

    public String solve(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int max = -1;
        int l = 0, r = 0;
        for (int i = 0, t, k, c; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                t = i;
                k = j;
                c = 0;
                while (t <= k && s.charAt(t) == s.charAt(k)) {
                    t++;
                    k--;
                    c++;
                }
                if (t > k && j - i + 1 > max) {
                    max = j - i + 1;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
