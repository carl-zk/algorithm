package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/scramble-string/
 * <p>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 *
 * @author carl
 */
public class ScrambleString {
    char[] cs1;
    char[] cs2;

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        cs1 = s1.toCharArray();
        cs2 = s2.toCharArray();
        return solve(0, 0, cs1.length);
    }

    private boolean solve(int i, int j, int k) {
        if (k == 1) {
            return cs1[i] == cs2[j];
        }

        int[] counter = new int[256];
        for (int l = 0; l < k; l++) {
            counter[cs1[i + l]]++;
        }
        for (int l = 0; l < k; l++) {
            if (counter[cs2[j + l]] == 0) {
                return false;
            }
            counter[cs2[j + l]]--;
        }

        for (int p = 1; p < k; p++) {
            if (solve(i, j, p) && solve(i + p, j + p, k - p))
                return true;
            if (solve(i, j + k - p, p) && solve(i + p, j, k - p)) {
                return true;
            }
        }
        return false;
    }
}
