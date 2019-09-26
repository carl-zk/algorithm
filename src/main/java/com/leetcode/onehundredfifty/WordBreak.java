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
    Map<String, Set<Integer>> visited = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, 0, wordDict);
    }

    private boolean solve(String s, int start, List<String> wordDict) {
        if (s.length() == start) return true;

        for (String word : wordDict) {
            if (s.substring(start).startsWith(word)) {
                if (visited.get(word) == null) {
                    visited.put(word, new HashSet<>());
                }
                if (visited.get(word).contains(start)) {
                    continue;
                }
                visited.get(word).add(start);
                if (solve(s, start + word.length(), wordDict)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
    }
}
