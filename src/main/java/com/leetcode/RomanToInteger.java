package com.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * @author carl
 */
public class RomanToInteger {
    static HashMap<String, Integer> ref;

    static {
        ref = new HashMap<>(16);
        ref.put("M", 1000);
        ref.put("CM", 900);
        ref.put("D", 500);
        ref.put("CD", 400);
        ref.put("C", 100);
        ref.put("XC", 90);
        ref.put("L", 50);
        ref.put("XL", 40);
        ref.put("X", 10);
        ref.put("IX", 9);
        ref.put("V", 5);
        ref.put("IV", 4);
        ref.put("I", 1);
    }

    public int romanToInt(String s) {
        int res = 0;

        int i = 0, a, b;
        while (i < s.length() - 1) {
            a = ref.get(s.substring(i, i + 1));
            b = ref.get(s.substring(i + 1, i + 2));
            if (a >= b) {
                res += a;
                i++;
            } else {
                res += ref.get(s.substring(i, i + 2));
                i += 2;
            }
        }

        if (i == s.length() - 1) {
            res += ref.get(s.substring(s.length() - 1));
        }

        return res;
    }
}
