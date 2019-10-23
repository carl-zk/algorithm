package com.leetcode.threehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther carl
 */
public class IntegertoEnglishWords {
    String[] gape = {"Thousand", "Million", "Billion"};
    String[] str = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Teen", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    Map<Integer, String> map = new HashMap<>();

    public String numberToWords(int num) {
        init();
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 1000);
            num /= 1000;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(' ').append(parse(list.get(i)));
            if (i > 0) {
                sb.append(' ').append(gape[i]);
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
            sb.append(" ").append(map.get(num - (num % 10)));
            num %= 10;
        }
        if (num > 0) {
            sb.append(" ").append(str[num]);
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
