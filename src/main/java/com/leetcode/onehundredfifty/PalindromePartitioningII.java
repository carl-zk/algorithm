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

        cut = new int[s.length() + 1];
        for (int i = 0; i < cut.length; i++) {
            cut[i] = i - 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; i - k > -1 && i + k < s.length() && s.charAt(i - k) == s.charAt(i + k); k++) {
                cut[i + k + 1] = Math.min(cut[i + k + 1], cut[i - k] + 1);
            }
            for (int k = 1; i - k + 1 > -1 && i + k < s.length() && s.charAt(i - k + 1) == s.charAt(i + k); k++) {
                cut[i + k + 1] = Math.min(cut[i + k + 1], cut[i - k + 1] + 1);
            }
        }
        return cut[s.length()];
    }

    public static void main(String[] args) {
        PalindromePartitioningII p = new PalindromePartitioningII();
        System.out.println(p.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }
}
