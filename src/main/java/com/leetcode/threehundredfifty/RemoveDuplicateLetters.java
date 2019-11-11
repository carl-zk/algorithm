package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 * <p>
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example 1:
 * <p>
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: "cbacdcbc"
 * Output: "acdb"
 *
 * @auther carl
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] counter = new int[256];
        for (char c : s.toCharArray()) {
            counter[c]++;
        }
        char[] ans = new char[s.length()];
        int len = 0;
        boolean[] used = new boolean[256];

        for (char c : s.toCharArray()) {
            counter[c]--;
            if (!used[c]) {
                while (len > 0 && ans[len - 1] > c && counter[ans[len - 1]] > 0) {
                    used[ans[len - 1]] = false;
                    len--;
                }
                ans[len++] = c;
                used[c] = true;
            }
        }
        return String.valueOf(ans, 0, len);
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        System.out.println(rdl.removeDuplicateLetters("edebbed"));
    }
}
