package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/add-binary/
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * @author carl
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        char[] cs1 = a.toCharArray();
        char[] cs2 = b.toCharArray();
        char[] cs = cs1.length > cs2.length ? cs1 : cs2;
        int up = 0;
        int i = cs1.length - 1, j = cs2.length - 1, k = cs.length - 1;

        while (i > -1 && j > -1 || k > -1) {
            int sum = i > -1 && j > -1 ? (cs1[i] - '0') + (cs2[j] - '0') + up
                    : (cs[k] - '0') + up;
            up = sum / 2;
            sum %= 2;
            cs[k] = (char) ('0' + sum);
            i--;
            j--;
            k--;
        }

        char[] ans = cs;
        if (up > 0) {
            ans = new char[cs.length + 1];
            ans[0] = '1';
            System.arraycopy(cs, 0, ans, 1, cs.length);
        }
        return new String(ans);
    }
}
