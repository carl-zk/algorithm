package com.leetcode.onehundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * @auther carl
 */
public class WordBreak {
    boolean[] reach;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        reach = new boolean[s.length() + 1];
        solve(s, 0, wordDict);
        return reach[s.length()];
    }

    private void solve(String s, int start, List<String> wordDict) {
        for (String word : wordDict) {
            if (s.substring(start).startsWith(word) && !reach[start + word.length()]) {
                reach[start + word.length()] = true;
                solve(s, start + word.length(), wordDict);
            }
        }
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
    }
}
