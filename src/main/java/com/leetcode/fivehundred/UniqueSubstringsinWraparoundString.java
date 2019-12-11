package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 * <p>
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * <p>
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * <p>
 * Example 1:
 * Input: "a"
 * Output: 1
 * <p>
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * Example 3:
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 *
 * @author carl
 */
public class UniqueSubstringsinWraparoundString {

    /**
     * basic idea is calc max len of substrings which end up with specific one.
     *
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        int[] lens = new int[128];
        char[] chars = p.toCharArray();
        char c = chars[0];
        int l = 0, r;
        for (r = 0; r < chars.length; r++) {
            if (c != chars[r]) {
                l = 0;
                c = chars[r--];
            } else {
                lens[chars[r]] = Math.max(lens[chars[r]], ++l);
                c = c == 'z' ? 'a' : (char) (c + 1);
            }
        }
        int total = 0;
        for (int t : lens) total += t;
        return total;
    }

    public static void main(String[] args) {
        UniqueSubstringsinWraparoundString us = new UniqueSubstringsinWraparoundString();
        System.out.println(us.findSubstringInWraproundString("abaab"));
    }
}
