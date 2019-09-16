package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/interleaving-string/
 * <p>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 * @auther carl
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        return isTrue(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    private boolean isTrue(char[] s1, int i1, char[] s2, int i2, char[] s3, int i3) {
        if (i1 == s1.length && i2 == s2.length && i3 == s3.length) return true;

        if (i3 < s3.length && i1 < s1.length && i2 < s2.length
                && s3[i3] != s1[i1] && s3[i3] != s2[i2]) {
            return false;
        }
        if (i3 < s3.length && i1 < s1.length && i2 < s2.length
                && s3[i3] == s1[i1] && s3[i3] == s2[i2]) {
            return isTrue(s1, i1 + 1, s2, i2, s3, i3 + 1) || isTrue(s1, i1, s2, i2 + 1, s3, i3 + 1);
        }
        if (i3 < s3.length && i1 < s1.length && s3[i3] == s1[i1]) {
            return isTrue(s1, i1 + 1, s2, i2, s3, i3 + 1);
        }
        if (i3 < s3.length && i2 < s2.length && s3[i3] == s2[i2]) {
            return isTrue(s1, i1, s2, i2 + 1, s3, i3 + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave("bcca", "bccca", "bbcccacca"));
    }
}
