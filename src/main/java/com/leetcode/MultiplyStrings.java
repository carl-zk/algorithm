package com.leetcode;

/**
 * https://leetcode.com/problems/multiply-strings/
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @author carl
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int tail = 0, up = 0;
        int[] ans = new int[12101];

        for (int i = num1.length() - 1; i > -1; i--) {
            tail = num1.length() - i - 1;
            up = 0;
            for (int j = num2.length() - 1; j > -1; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                ans[tail] += mul + up;
                up = ans[tail] / 10;
                ans[tail++] %= 10;
            }
            ans[tail] += up;
        }

        StringBuilder sb = new StringBuilder(tail + 1);
        while (ans[tail] == 0) tail--;
        while (tail > -1) {
            sb.append(ans[tail--]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();

        System.out.println(ms.multiply("789", "456"));
        System.out.println(ms.multiply("123", "456"));
    }
}
