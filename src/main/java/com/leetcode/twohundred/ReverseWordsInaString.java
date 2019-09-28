package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * For C programmers, try to solve it in-place in O(1) extra space.
 *
 * @author carl
 */
public class ReverseWordsInaString {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        solve(s.toCharArray(), 0, sb);
        return sb.toString();
    }

    private void solve(char[] chars, int start, StringBuilder sb) {
        while (start < chars.length && chars[start] == ' ') start++;
        if (start == chars.length) return;
        int end = start;
        while (end < chars.length && chars[end] != ' ') end++;
        solve(chars, end, sb);
        if (sb.length() > 0) {
            sb.append(' ');
        }
        for (int i = start; i < end; i++) {
            sb.append(chars[i]);
        }
    }
}
