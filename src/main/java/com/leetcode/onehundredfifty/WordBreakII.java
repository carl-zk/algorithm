package com.leetcode.onehundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 *
 * @auther carl
 */
public class WordBreakII {
    Map<String, List<String>> map;

    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return solve(s, wordDict);
    }

    private List<String> solve(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> suffix = solve(s.substring(word.length()), wordDict);
                for (String suf : suffix) {
                    ans.add(word + (suf.length() == 0 ? "" : " ") + suf);
                }
            }
        }
        map.put(s, ans);
        return ans;
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        /*wordBreakII.wordBreak("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog"));*/

        wordBreakII.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
    }
}
