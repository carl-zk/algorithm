package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * @auther carl
 */
public class PalindromePartitioningII {
    int[] cut;

    public int minCut(String s) {
        if (s.length() == 0) return 0;

        cut = new int[s.length()];
        for (int i = 0; i < cut.length; i++) {
            cut[i] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i - 1 > -1) cut[i] = Math.min(cut[i - 1] + 1, cut[i]);
            for (int j = i + 1, k = 0; i - k > -1 && j + k < s.length() && s.charAt(i - k) == s.charAt(j + k); k++) {
                cut[j + k] = Math.min(cut[j + k], i - k - 1 > -1 ? cut[i - k - 1] + 1 : 0);
            }
            for (int j = i + 2, k = 0; i - k > -1 && j + k < s.length() && s.charAt(i - k) == s.charAt(j + k); k++) {
                cut[j + k] = Math.min(cut[j + k], i - k - 1 > -1 ? cut[i - k - 1] + 1 : 0);
            }
        }
        return cut[s.length() - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioningII p = new PalindromePartitioningII();
        System.out.println(p.minCut("aab"));
    }
}
