package com.leetcode.onehundred;

import java.util.HashMap;
import java.util.Map;

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
    Map<Character, Integer> sings;
    int eIndex;

    public boolean isNumber(String s) {
        if (s.length() == 0) return false;
        sings = new HashMap<>();
        sings.put('+', 2);
        sings.put('-', 2);
        sings.put('e', 1);
        sings.put('.', 1);

        s = s.trim();
        char[] chars = s.toCharArray();
        if (!isValidCharacters(chars)) return false;

        if (sings.get('e') == 0) {
            return isValidDecimal(chars, 0, eIndex - 1, true)
                    && isValidDecimal(chars, eIndex + 1, chars.length - 1, false);
        }
        return isValidDecimal(chars, 0, chars.length - 1, true);
    }

    private boolean isValidCharacters(char[] chars) {
        if (chars.length == 0) return false;

        for (int i = 0; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                continue;
            }
            Integer cnt = sings.get(chars[i]);
            if (cnt == null || cnt == 0) {
                return false;
            }
            sings.put(chars[i], cnt - 1);
            if (chars[i] == 'e') eIndex = i;
        }
        return true;
    }

    private boolean isValidDecimal(char[] chars, int s, int e, boolean hasDot) {
        if (s > e) return false;

        int numCount = 0;
        int dotCount = 0;
        if ('0' <= chars[s] && chars[s] <= '9') {
            numCount = 1;
        } else if (chars[s] == '.') {
            if (!hasDot) return false;
            dotCount = 1;
        } else if (chars[s] != '+' && chars[s] != '-') {
            return false;
        }
        int i = s + 1;
        while (i <= e) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                numCount++;
            } else if (chars[i] == '.') {
                if (!hasDot || dotCount == 1) return false;
                dotCount = 1;
            } else return false;
            i++;
        }
        return numCount > 0;
    }
}
