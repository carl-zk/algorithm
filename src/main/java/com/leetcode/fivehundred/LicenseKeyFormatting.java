package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/license-key-formatting/
 * <p>
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
 * <p>
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 * <p>
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 * <p>
 * Example 1:
 * Input: S = "5F3Z-2e-9-w", K = 4
 * <p>
 * Output: "5F3Z-2E9W"
 * <p>
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * Example 2:
 * Input: S = "2-5g-3-J", K = 2
 * <p>
 * Output: "2-5G-3J"
 * <p>
 * Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 * Note:
 * The length of string S will not exceed 12,000, and K is a positive integer.
 * String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
 * String S is non-empty.
 *
 * @author carl
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1, j = 0; i > -1; i--) {
            if (chars[i] != '-') {
                char c = 'a' <= chars[i] && chars[i] <= 'z' ? (char) (chars[i] - 32) : chars[i];
                sb.append(c);
                j++;
                if (j == K) {
                    sb.append('-');
                    j = 0;
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}
