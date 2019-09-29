package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * Example 1:
 * <p>
 * Input: 1
 * Output: "A"
 * Example 2:
 * <p>
 * Input: 28
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: 701
 * Output: "ZY"
 *
 * @auther carl
 */
public class ExcelSheetColumnTitle {
    StringBuilder sb;

    public String convertToTitle(int n) {
        sb = new StringBuilder();
        solve(n);
        return sb.reverse().toString();
    }

    private void solve(int n) {
        if (n == 0) return;
        int m = n % 26;
        sb.append(m == 0 ? 'Z' : (char) (64 + m));
        solve(n <= 26 ? 0 : m == 0 ? n / 26 - 1 : n / 26);
    }

    public static void main(String[] args) {
        int i = 'A';
        System.out.println(i);
        ExcelSheetColumnTitle ex = new ExcelSheetColumnTitle();
        System.out.println(ex.convertToTitle(27)); //AA
        System.out.println(ex.convertToTitle(52)); //AZ
    }
}
