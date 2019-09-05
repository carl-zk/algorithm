package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 *
 * @author carl
 */
public class ValidPalindrome {
    private static final char[] charMap = new char[256];

    static {
        for (int i = 0; i < 10; i++) {
            charMap['0' + i] = (char) (1 + i);
        }
        for (int i = 0; i < 26; i++) {
            charMap['a' + i] = charMap['A' + i] = (char) (11 + i);
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        int a, b;

        while (l < r) {
            a = charMap[s.charAt(l)];
            b = charMap[s.charAt(r)];
            if (a != 0 && b != 0) {
                if (a != b) {
                    return false;
                }
                l++;
                r--;
            } else if (a == 0) {
                l++;
            } else {
                r--;
            }
        }

        return true;
    }
}
