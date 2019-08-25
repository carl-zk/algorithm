package com.leetcode;

/**
 * https://leetcode.com/problems/implement-strstr/
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * @author carl
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        for (int i = 0, l, r; i < hay.length; i++) {
            if (hay[i] == nee[0]) {
                if (i + nee.length <= hay.length) {
                    boolean f = true;
                    l = i + 1;
                    r = i + nee.length - 1;
                    while (l <= r) {
                        if (hay[l] == nee[l - i] && hay[r] == nee[r - i]) {
                            l++;
                            r--;
                        } else {
                            f = false;
                            break;
                        }
                    }
                    if (f) {
                        return i;
                    }
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr imp = new ImplementStrStr();
        int i = imp.strStr("mississippi", "issip");
        System.out.println(i);
    }
}
