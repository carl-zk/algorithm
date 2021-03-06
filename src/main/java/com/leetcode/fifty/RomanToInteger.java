package com.leetcode.fifty;

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

    public int romanToInt(String s) {
        int sum = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    sum += sum > 4 ? -1 : 1;
                    break;
                case 'V':
                    sum += sum > 8 ? -5 : 5;
                    break;
                case 'X':
                    sum += sum > 49 ? -10 : 10;
                    break;
                case 'L':
                    sum += sum > 89 ? -50 : 50;
                    break;
                case 'C':
                    sum += sum > 499 ? -100 : 100;
                    break;
                case 'D':
                    sum += sum > 899 ? -500 : 500;
                    break;
                default:
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }
}
