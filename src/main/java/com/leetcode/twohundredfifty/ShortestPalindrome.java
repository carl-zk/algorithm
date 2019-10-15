package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 * <p>
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * Example 1:
 * <p>
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 * <p>
 * Input: "abcd"
 * Output: "dcbabcd"
 *
 * @auther carl
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        String rev = reverse(s);
        if (s.equals(rev)) return s;

        int n = rev.length();
        int[] lps = computelps(s);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && s.charAt(q) != rev.charAt(i)) {
                q = lps[q - 1];
            }
            if (s.charAt(q) == rev.charAt(i)) {
                q++;
            }
        }
        return rev + s.substring(q);
    }

    private String reverse(String s) {
        if (s.length() < 2) return s;
        char[] rev = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            rev[rev.length - 1 - i] = s.charAt(i);
        }
        return String.valueOf(rev);
    }

    private int[] computelps(String s) {
        int m = s.length();
        int[] lps = new int[m];
        lps[0] = 0;
        int k = 0;
        for (int i = 1; i < m; i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = lps[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            lps[i] = k;
        }
        return lps;
    }

    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.println(sp.shortestPalindrome("aacecaaa"));
        //System.out.println("ab".substring(0, 0));
    }
}
