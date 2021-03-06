package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * <p>
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 * @author carl
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        return process(s, 0, s.length() - 1, 0);
    }

    private boolean process(String s, int l, int r, int skipCount) {
        if (skipCount > 1) {
            return false;
        }
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return process(s, l, r - 1, skipCount + 1)
                        || process(s, l + 1, r, skipCount + 1);
            }
        }
        return true;
    }
}
