package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 * <p>
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * <p>
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * <p>
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * <p>
 * Output: "45"
 *
 * @author carl
 */
public class ReconstructOriginalDigitsfromEnglish {

    public String originalDigits(String s) {
        int[] bucket = new int[10];
        int[] counter = new int[123];
        char[] arr = {'g', 'h', 't', 'u', 'z', 'f', 'v', 'x', 'o', 'n'};
        int[] index = {8, 3, 2, 4, 0, 5, 7, 6, 1, 9};
        String[] str = {"eight", "three", "two", "four", "zero", "five", "seven", "six", "one", "nine"};

        for (char c : s.toCharArray()) {
            counter[c]++;
        }

        for (int i = 0; i < arr.length; i++) {
            while (counter[arr[i]] > 0) {
                bucket[index[i]]++;
                for (char c : str[i].toCharArray()) {
                    counter[c]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a = 'z';

        System.out.println(a);
    }
}
