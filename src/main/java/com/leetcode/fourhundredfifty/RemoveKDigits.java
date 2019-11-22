package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/remove-k-digits/
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 * @author carl
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        char[] chars = num.toCharArray();
        char[] res = new char[chars.length - k];
        int index = -1;

        for (int i = 0; i < chars.length; i++) {
            while (index >= 0 && res[index] > chars[i] && index + chars.length - i >= res.length) {
                index--;
            }
            if (index + 1 < res.length) {
                res[++index] = chars[i];
            }
        }
        int start = 0;
        while (start < res.length && res[start] == '0') start++;
        return start == res.length ? "0" : String.valueOf(res, start, res.length - start);
    }

    public static void main(String[] args) {
        RemoveKDigits rkd = new RemoveKDigits();
        System.out.println(rkd.removeKdigits("10200", 1));
    }
}
