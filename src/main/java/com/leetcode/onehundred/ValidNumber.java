package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/valid-number/
 * <p>
 * Validate if a given string can be interpreted as a decimal number.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
 * <p>
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 *
 * @author carl
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        if (s.length() == 0) return false;

        s = s.trim();
        char[] chars = s.toCharArray();

        int numCount = 0;
        int dotCount = 0;
        int eCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                numCount++;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i != 0 && chars[i - 1] != 'e') return false;
            } else if (chars[i] == '.') {
                if (dotCount == 1) return false;
                dotCount = 1;
            } else if (chars[i] == 'e') {
                if (numCount == 0 || eCount == 1) return false;
                eCount = 1;
                numCount = 0;
                dotCount = 1;
            } else return false;
        }

        return numCount > 0;
    }
}
