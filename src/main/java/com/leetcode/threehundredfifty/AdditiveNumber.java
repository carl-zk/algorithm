package com.leetcode.threehundredfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/additive-number/
 * <p>
 * Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 * <p>
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * <p>
 * <p>
 * Constraints:
 * <p>
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * Follow up:
 * How would you handle overflow for very large input integers?
 *
 * @auther carl
 */
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        return solve(num.toCharArray(), 0, new ArrayList<>());
    }

    private boolean solve(char[] digits, int start, List<String> list) {
        if (start >= digits.length) return list.size() > 2;

        for (int count = 1; start + count <= digits.length; count++) {
            String num = String.valueOf(digits, start, count);
            if (list.size() >= 2) {
                if (!num.equals(largeNumAdd(list.get(list.size() - 1), list.get(list.size() - 2)))) {
                    continue;
                }
            }
            if (num.charAt(0) == '0' && num.length() > 1) return false;
            list.add(num);
            if (solve(digits, start + count, list)) return true;
            list.remove(num);
        }
        return false;
    }

    private String largeNumAdd(String a, String b) {
        char[] num1 = a.toCharArray(), num2 = b.toCharArray();
        int len = Math.max(num1.length, num2.length) + 1;
        char[] sum = new char[len];
        int i = num1.length - 1, j = num2.length - 1, k = sum.length - 1;
        int flag = 0;

        while (i >= 0 && j >= 0) {
            int s = (num1[i--] - '0') + (num2[j--] - '0') + flag;
            flag = s / 10;
            s %= 10;
            sum[k--] = (char) ('0' + s);
        }

        while (i >= 0) {
            int s = (num1[i--] - '0') + flag;
            flag = s / 10;
            s %= 10;
            sum[k--] = (char) ('0' + s);
        }

        while (j >= 0) {
            int s = (num2[j--] - '0') + flag;
            flag = s / 10;
            s %= 10;
            sum[k--] = (char) ('0' + s);
        }
        if (flag > 0) {
            sum[k--] = '1';
        }
        return String.valueOf(sum, k + 1, len - k - 1);
    }

    public static void main(String[] args) {
        AdditiveNumber additiveNumber = new AdditiveNumber();
        System.out.println(additiveNumber.isAdditiveNumber("199100199"));
    }
}
