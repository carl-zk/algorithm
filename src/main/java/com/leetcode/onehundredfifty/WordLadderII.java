package com.leetcode.onehundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: []
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author carl
 */
public class WordLadderII {
    List<List<String>> ans;
    Map<String, List<String>> map;
    int minLen;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        minLen = wordList.size() << 1;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        if (!dict.contains(endWord)) return ans;

        start.add(beginWord);
        end.add(endWord);
        buildMap(start, end, dict);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        buildResult(path, beginWord, endWord);
        return ans;
    }

    private void buildMap(Set<String> start, Set<String> end, Set<String> dict) {
        dict.removeAll(start);
        Set<String> next = new HashSet<>();
        boolean finish = false;
        for (String word : start) {
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char oldLetter = charArray[i];
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    charArray[i] = letter;
                    String newWord = String.valueOf(charArray);
                    if (dict.contains(newWord)) {
                        if (end.contains(newWord)) {
                            finish = true;
                        } else {
                            next.add(newWord);
                        }
                        if (map.get(word) == null) {
                            map.put(word, new ArrayList<>());
                        }
                        map.get(word).add(newWord);
                    }
                }
                charArray[i] = oldLetter;
            }
        }
        if (finish || next.isEmpty()) return;
        buildMap(next, end, dict);
    }

    private void buildResult(List<String> path, String word, String endWord) {
        if (endWord.equals(word)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (map.get(word) == null) return;
        for (String next : map.get(word)) {
            path.add(next);
            buildResult(path, next, endWord);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        /*WordLadderII wl = new WordLadderII();
        String[] arr = new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        wl.findLadders("qa", "sq", Arrays.asList(arr));*/

        WordLadderII wl = new WordLadderII();
        String[] arr = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        wl.findLadders("hit", "cog", Arrays.asList(arr));

/*        WordLadderII wl = new WordLadderII();
        String[] arr = new String[]{"miss", "dusk", "kiss", "musk", "tusk", "diss", "disk", "sang", "ties", "muss"};
        wl.findLadders("kiss", "tusk", Arrays.asList(arr));*/
    }
}
