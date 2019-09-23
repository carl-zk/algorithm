package com.leetcode.onehundredfifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author carl
 */
public class WordLadder {
    Map<String, List<String>> map;
    int minLen;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        map = new HashMap<>();
        minLen = 0;

        if (!dict.contains(endWord)) return 0;

        start.add(beginWord);
        end.add(endWord);
        solve(start, end, dict, false);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        counter(path, beginWord, endWord);
        return minLen;
    }

    private void solve(Set<String> start, Set<String> end, Set<String> dict, boolean reverse) {
        if (start.size() > end.size()) {
            solve(end, start, dict, !reverse);
            return;
        }
        dict.removeAll(start);
        Set<String> next = new HashSet<>();
        boolean finish = false;
        for (String word : start) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char oldLetter = chars[i];
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    chars[i] = letter;
                    String newWord = String.valueOf(chars);
                    if (dict.contains(newWord)) {
                        if (end.contains(newWord)) {
                            finish = true;
                        } else {
                            next.add(newWord);
                        }
                        String key = reverse ? newWord : word;
                        String value = reverse ? word : newWord;
                        if (map.get(key) == null) {
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(value);
                    }
                }
                chars[i] = oldLetter;
            }
        }
        if (finish || next.isEmpty()) return;
        solve(next, end, dict, reverse);
    }

    private void counter(List<String> path, String word, String endWord) {
        if (minLen != 0) return;

        if (endWord.equals(word)) {
            minLen = path.size();
            return;
        }
        if (map.get(word) == null) return;
        for (String next : map.get(word)) {
            path.add(next);
            counter(path, next, endWord);
            path.remove(path.size() - 1);
        }
    }
}
