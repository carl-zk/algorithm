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
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, s.length() - i).equals(rev.substring(i))) {
                return rev.substring(0, i) + s;
            }
        }
        return "";
    }

    private String reverse(String s) {
        if (s.length() < 2) return s;
        char[] rev = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            rev[rev.length - 1 - i] = s.charAt(i);
        }
        return String.valueOf(rev);
    }

    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.println(sp.shortestPalindrome("abcd"));
        System.out.println("ab".substring(0, 0));
    }
}
