package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/decode-string/
 * <p>
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * @author carl
 */
public class DecodeString {

    public String decodeString(String s) {
        return parseList(1, s.toCharArray(), -1, s.length());
    }

    /**
     * pattern 3[abc]
     *
     * @param n     3
     * @param chars [abc]
     * @param start [
     * @param end   ]
     * @return abcabcabc
     */
    private String parseList(int n, char[] chars, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start + 1; i < end; i++) {
            if ('0' < chars[i] && chars[i] <= '9') {
                int num = 0;
                while ('0' <= chars[i] && chars[i] <= '9') {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                int counter = 1;
                int j = i + 1;
                while (j < end && counter > 0) {
                    if (chars[j] == '[') counter++;
                    else if (chars[j] == ']') counter--;
                    j++;
                }
                sb.append(parseList(num, chars, i, j - 1));
                i = j - 1;
            } else {
                sb.append(chars[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(n * sb.length());
        for (int i = 0; i < n; i++) {
            stringBuilder.append(sb);
        }
        return stringBuilder.toString();
    }
}
