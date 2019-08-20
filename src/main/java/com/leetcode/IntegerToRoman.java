package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/integer-to-roman/
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
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: "III"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "IV"
 * Example 3:
 * <p>
 * Input: 9
 * Output: "IX"
 * Example 4:
 * <p>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * <p>
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * @author carl
 */
public class IntegerToRoman {
    static final Map<Integer, String> ref = new HashMap<>(64);

    static {
        ref.put(0, "");
        ref.put(1, "I");
        ref.put(10, "X");
        ref.put(100, "C");
        ref.put(1000, "M");
        ref.put(2, "II");
        ref.put(20, "XX");
        ref.put(200, "CC");
        ref.put(2000, "MM");
        ref.put(3, "III");
        ref.put(30, "XXX");
        ref.put(300, "CCC");
        ref.put(3000, "MMM");
        ref.put(4, "IV");
        ref.put(40, "XL");
        ref.put(400, "CD");
        ref.put(5, "V");
        ref.put(50, "L");
        ref.put(500, "D");
        ref.put(6, "VI");
        ref.put(60, "LX");
        ref.put(600, "DC");
        ref.put(7, "VII");
        ref.put(70, "LXX");
        ref.put(700, "DCC");
        ref.put(8, "VIII");
        ref.put(80, "LXXX");
        ref.put(800, "DCCC");
        ref.put(9, "IX");
        ref.put(90, "XC");
        ref.put(900, "CM");
    }

    public String intToRoman(int num) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(16);
        int i = 0, j;
        while (num > 0) {
            j = (int) ((num % 10) * Math.pow(10, i++));
            stack.push(ref.get(j));
            num /= 10;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
