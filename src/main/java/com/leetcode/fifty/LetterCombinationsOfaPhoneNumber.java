package com.leetcode.fifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author carl
 */
public class LetterCombinationsOfaPhoneNumber {

    static char[][] n2c = new char[10][];

    static {
        n2c[2] = new char[]{'a', 'b', 'c'};
        n2c[3] = new char[]{'d', 'e', 'f'};
        n2c[4] = new char[]{'g', 'h', 'i'};
        n2c[5] = new char[]{'j', 'k', 'l'};
        n2c[6] = new char[]{'m', 'n', 'o'};
        n2c[7] = new char[]{'p', 'q', 'r', 's'};
        n2c[8] = new char[]{'t', 'u', 'v'};
        n2c[9] = new char[]{'w', 'x', 'y', 'z'};
    }

    List<String> ans;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Arrays.asList();
        }
        char[] numbers = digits.toCharArray();
        ans = new LinkedList<>();
        char[] chars = new char[numbers.length];
        process(numbers, 0, chars, 0);
        return ans;
    }

    private void process(char[] numbers, int i, char[] chars, int j) {
        if (j == numbers.length) {
            ans.add(new String(chars));
            return;
        }
        for (int k = 0; k < n2c[numbers[i] - '0'].length; k++) {
            chars[j] = n2c[numbers[i] - '0'][k];
            process(numbers, i + 1, chars, j + 1);
        }
    }


    public static void main(String[] args) {
        int[] a = {2, 3};
        int[] b = new int[a.length];

        permutation(a, 0, b, 0);
    }

    public static void permutation(int[] a, int h, int[] ans, int ansLen) {
        if (ansLen == a.length) {
            for (int i = 0; i < ansLen; i++) {
                System.out.print(ans[i] + ", ");
            }
            System.out.println();
            char[] chars = new char[ansLen];
            print(ans, 0, chars, 0);
            System.out.println("\n==============");
            return;
        }
        for (int i = h; i < a.length; i++) {
            swap(a, h, i);
            ans[ansLen] = a[h];
            permutation(a, h + 1, ans, ansLen + 1);
            swap(a, i, h);
        }
    }

    private static void print(int[] ans, int i, char[] chars, int j) {
        if (j == ans.length) {
            for (int k = 0; k < chars.length; k++) {
                System.out.print(chars[k] + ", ");
            }
            System.out.println();
            return;
        }
        for (int k = 0; k < n2c[ans[i]].length; k++) {
            chars[j] = n2c[ans[i]][k];
            print(ans, i + 1, chars, j + 1);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
