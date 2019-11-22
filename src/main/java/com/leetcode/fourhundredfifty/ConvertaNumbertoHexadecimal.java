package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 * <p>
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * <p>
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * Example 2:
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 *
 * @author carl
 */
public class ConvertaNumbertoHexadecimal {
    char[] SIGNS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        int mask = 0x0000000f;
        char[] digits = new char[8];
        for (int i = 7; i >= 0; i--) {
            digits[i] = SIGNS[num & mask];
            num >>>= 4;
        }
        int start = 0;
        while (start < digits.length && digits[start] == '0') start++;
        return start == digits.length ? "0" : String.valueOf(digits, start, 8 - start);
    }

    public static void main(String[] args) {
        ConvertaNumbertoHexadecimal cn = new ConvertaNumbertoHexadecimal();
        System.out.println(cn.toHex(26));
    }
}
