package com.leetcode.onehundred;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @auther carl
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] counter = new int[256];
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i)]++;
        }
        int start = -1, end = s.length(), i = 0, j = 0, target = t.length();
        char[] sc = s.toCharArray();

        while (j < sc.length) {
            if (counter[sc[j++]]-- > 0) {
                target--;
            }
            if (target == 0 && j - i < end - start) {
                start = i;
                end = j;
            }
            while (i < j && (target == 0 || counter[sc[i]] < 0)) {
                if (counter[sc[i++]]++ == 0) {
                    target++;
                }
            }
        }
        return start == -1 ? "" : s.substring(start, end);
    }
}
