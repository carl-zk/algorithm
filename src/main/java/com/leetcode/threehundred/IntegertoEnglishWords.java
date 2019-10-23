package com.leetcode.threehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    String[] str = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    Map<Integer, String> map = new HashMap<>();

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        init();
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
            sb.append(str[num / 100]).append(" Hundred");
            num %= 100;
        }
        if (num / 10 != 0 && num >= 20) {
            sb.append(sb.length() > 0 ? " " : "").append(map.get(num - (num % 10)));
            num %= 10;
        }
        if (num > 0) {
            sb.append(sb.length() > 0 ? " " : "").append(str[num]);
        }
        return sb.toString();
    }

    private void init() {
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }
}
