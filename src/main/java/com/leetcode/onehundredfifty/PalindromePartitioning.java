package com.leetcode.onehundredfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @auther carl
 */
public class PalindromePartitioning {
    List<List<String>> ans;
    List<String>[] palins;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        palins = new ArrayList[s.length()];
        for (int i = 0; i < s.length(); i++) {
            palins[i] = new ArrayList<>();
            palins[i].add(String.valueOf(s.charAt(i)));
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                expand(s, i, i + 1);
            }
            if (i + 2 < s.length() && s.charAt(i) == s.charAt(i + 2)) {
                expand(s, i, i + 2);
            }
        }

        for (int i = 0; i < palins[0].size(); i++) {
            List<String> path = new ArrayList<>();
            path.add(palins[0].get(i));
            solve(path, palins[0].get(i).length());
        }
        return ans;
    }

    private void expand(String s, int h, int t) {
        int k = 0;
        while (h - k > -1 && t + k < s.length() && s.charAt(h - k) == s.charAt(t + k)) {
            palins[h - k].add(s.substring(h - k, t + k + 1));
            k++;
        }
    }

    private void solve(List<String> path, int index) {
        if (index == palins.length) {
            ans.add(path);
            return;
        }
        List<String> newp = new ArrayList<>(path);
        newp.add(palins[index].get(0));
        solve(newp, index + palins[index].get(0).length());
        for (int i = 1; i < palins[index].size(); i++) {
            newp = new ArrayList<>(path);
            newp.add(palins[index].get(i));
            solve(newp, palins[index].get(i).length() + index);
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        p.partition("cdd");
    }
}
