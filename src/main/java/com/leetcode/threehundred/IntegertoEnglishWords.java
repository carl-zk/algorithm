package com.leetcode.threehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 * <p>
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * @auther carl
 */
public class IntegertoEnglishWords {
    String[] gape = {"Thousand", "Million", "Billion"};
    String[] dict1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] dict2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 1000);
            num /= 1000;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = parse(list.get(i));
            if (s.length() > 0) {
                sb.append(' ').append(s);
            }
            if (s.length() > 0 && i > 0) {
                sb.append(' ').append(gape[i - 1]);
            }
        }
        return sb.substring(1);
    }

    private String parse(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(dict1[num / 100]).append(" Hundred");
            num %= 100;
        }
        if (num >= 20) {
            sb.append(sb.length() > 0 ? " " : "").append(dict2[num / 10]);
            num %= 10;
        }
        if (num > 0) {
            sb.append(sb.length() > 0 ? " " : "").append(dict1[num]);
        }
        return sb.toString();
    }
}
