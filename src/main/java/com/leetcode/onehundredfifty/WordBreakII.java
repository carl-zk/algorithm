package com.leetcode.onehundredfifty;

import java.util.*;

/**
 * @auther carl
 */
public class WordBreakII {
    List<String> ans;
    Set<String> dict;
    int minLen = Integer.MAX_VALUE;
    int maxLen = Integer.MIN_VALUE;

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new LinkedList<>();
        dict = new HashSet<>(wordDict);
        for (String word : wordDict) {
            minLen = Math.min(word.length(), minLen);
            maxLen = Math.max(word.length(), maxLen);
        }
        solve(s, new StringBuilder());
        return ans;
    }

    private void solve(String s, StringBuilder sb) {
        if (s.length() == 0) {
            ans.add(sb.substring(1));
            return;
        }
        for (int i = minLen; i <= maxLen && i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (dict.contains(word)) {
                sb.append(' ').append(word);
                solve(s.substring(word.length()), sb);
                sb.delete(sb.length() - 1 - word.length(), sb.length());
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        wordBreakII.wordBreak("aaaaaaaa",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa"));
    }
}
