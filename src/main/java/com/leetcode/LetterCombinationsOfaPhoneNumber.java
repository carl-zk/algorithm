package com.leetcode;

import java.util.List;

/**
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

    public List<String> letterCombinations(String digits) {
        return null;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = new int[3];

        permutation(a, 0, b, 0);
    }

    public static void permutation(int[] a, int h, int[] ans, int ansLen) {
        if (ansLen == a.length) {
            for (int i = 0; i < ansLen; i++) {
                System.out.print(ans[i] + ", ");
            }
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

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
