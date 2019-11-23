package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/add-strings/
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @author carl
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        char[] numa = num1.toCharArray(), numb = num2.toCharArray();
        int len = Math.max(numa.length, numb.length) + 1;
        char[] sum = new char[len];
        int i = numa.length - 1, j = numb.length - 1, k = sum.length - 1;
        int flag = 0;

        while (i >= 0 && j >= 0) {
            int s = (numa[i--] - '0') + (numb[j--] - '0') + flag;
            flag = s / 10;
            s %= 10;
            sum[k--] = (char) ('0' + s);
        }

        while (i >= 0) {
            int s = (numa[i--] - '0') + flag;
            flag = s / 10;
            s %= 10;
            sum[k--] = (char) ('0' + s);
        }

        while (j >= 0) {
            int s = (numb[j--] - '0') + flag;
            flag = s / 10;
            s %= 10;
            sum[k--] = (char) ('0' + s);
        }
        if (flag > 0) {
            sum[k--] = '1';
        }
        return String.valueOf(sum, k + 1, len - k - 1);
    }
}
