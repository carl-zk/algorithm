package com.leetcode.twohundred;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * <p>
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * <p>
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * <p>
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 *
 * @auther carl
 */
public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        if (numerator < 0 ^ denominator < 0) sb.append('-');

        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);

        sb.append(num / den);
        if (num % den == 0) return sb.toString();

        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();

        num = 10 * (num % den);
        while (num != 0) {
            if (map.get(num) != null) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                return sb.toString();
            }
            map.put(num, sb.length());
            sb.append(num / den);
            num = 10 * (num % den);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal fra = new FractionToRecurringDecimal();
        System.out.println(fra.fractionToDecimal(-1, -2147483648));
    }
}
