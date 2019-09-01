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
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i > -1; i--) {
            for (int j = num2.length() - 1; j > -1; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                ans[i + j + 1] += mul;
                ans[i + j] += ans[i + j + 1] / 10;
                ans[i + j + 1] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder(ans.length);
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0 || sb.length() != 0) {
                sb.append(ans[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();

        System.out.println(ms.multiply("0", "456"));
        System.out.println(ms.multiply("789", "456"));
        System.out.println(ms.multiply("123", "456"));
    }
}
