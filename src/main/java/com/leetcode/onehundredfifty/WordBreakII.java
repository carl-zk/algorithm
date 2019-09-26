package com.leetcode.onehundredfifty;

import java.util.*;

/**
 * @auther carl
 */
public class WordBreakII {
    Set<String> dict;
    Map<Integer, List<String>> map;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        map = new HashMap<>();

        return map.get(s);
    }

    private List<String> solve(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        /*wordBreakII.wordBreak("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog"));*/

        wordBreakII.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
    }
}
