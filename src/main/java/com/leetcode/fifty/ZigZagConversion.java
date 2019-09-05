package com.leetcode.fifty;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author carl
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        List<StringBuilder> lists = new LinkedList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            StringBuilder sb = new StringBuilder(s.length());
            lists.add(sb);
        }
        boolean plus = false;
        for (int i = 0, t = 0; i < s.length(); i++) {
            lists.get(t % numRows).append(s.charAt(i));
            plus = (t == 0 || t == numRows - 1) != plus;
            t += plus ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            sb.append(lists.get(i));
        }
        return sb.toString();
    }
}
