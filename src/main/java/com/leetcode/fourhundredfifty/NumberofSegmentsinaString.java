package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 * <p>
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 *
 * @author carl
 */
public class NumberofSegmentsinaString {

    public int countSegments(String s) {
        if (s.length() == 0) return 0;

        char[] chars = s.toCharArray();
        int count = chars[0] != ' ' ? 1 : 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != ' ' && chars[i - 1] == ' ') count++;
        }
        return count;
    }
}
