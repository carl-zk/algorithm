package com.leetcode;

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
    int h, t;

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        h = 0;
        t = s.length() - 1;

        while (h <= t) {
            char head = next(s, true);
            char tail = next(s, false);
            if (head == '-' && tail == '-') {
                return true;
            } else if (head == '-' || tail == '-') {
                return false;
            } else if (head != tail) {
                return false;
            }
            h++;
            t--;
        }

        return true;
    }

    private char next(String s, boolean isHead) {
        if (isHead) {
            while (h <= t) {
                char c = transform(s.charAt(h));
                if ('-' != c) {
                    return c;
                }
                h++;
            }
        } else {
            while (h <= t) {
                char c = transform(s.charAt(t));
                if ('-' != c) {
                    return c;
                }
                t--;
            }
        }
        return '-';
    }

    private char transform(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        } else if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        } else if (c >= '0' && c <= '9') {
            return c;
        }
        return '-';
    }
}
