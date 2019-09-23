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
    ArrayList<Integer>[] distwl;
    Set<Integer> dest;
    Queue<ArrayList<Integer>> que;
    int[] soFar;
    int minLen;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        init(wordList);
        calEachDistance(endWord, wordList);

        if (dest.isEmpty()) return Collections.emptyList();

        for (int i = 0; i < wordList.size(); i++) {
            String w = wordList.get(i);
            int d = 0;
            for (int j = 0; j < beginWord.length(); j++) {
                if (beginWord.charAt(j) != w.charAt(j)) {
                    d++;
                }
            }
            if (d == 1) {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(i);
                que.add(a);
            }
        }

        bfs(beginWord, wordList);
        return ans;
    }

    private void init(List<String> wordList) {
        ans = new LinkedList<>();
        distwl = new ArrayList[wordList.size()];
        dest = new HashSet<>();
        minLen = wordList.size() << 1;
        que = new LinkedList<>();
        soFar = new int[wordList.size()];
        Arrays.fill(soFar, wordList.size() << 1);
    }

    private void calEachDistance(String endWord, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String w1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                int d = 0;
                String w2 = wordList.get(j);
                for (int k = 0; k < w1.length(); k++) {
                    if (w1.charAt(k) != w2.charAt(k)) {
                        d++;
                    }
                }
                if (d == 1) {
                    if (distwl[i] == null) {
                        distwl[i] = new ArrayList<>();
                    }
                    if (distwl[j] == null) {
                        distwl[j] = new ArrayList<>();
                    }
                    distwl[i].add(j);
                    distwl[j].add(i);
                }
            }
            if (endWord.equals(w1)) {
                dest.add(i);
            }
        }
    }

    private void bfs(String beginWord, List<String> wordList) {
        while (!que.isEmpty()) {
            ArrayList<Integer> a = que.poll();
            if (a.size() > minLen) return;
            if (dest.contains(a.get(a.size() - 1))) {
                minLen = a.size();
                List<String> list = new LinkedList<>();
                list.add(beginWord);
                for (int i = 0; i < a.size(); i++) {
                    list.add(wordList.get(a.get(i)));
                }
                ans.add(list);
                continue;
            }
            Set<Integer> used = new HashSet<>();
            for (int i = 0; i < a.size(); i++) {
                used.add(a.get(i));
            }
            int j = a.get(a.size() - 1);
            for (int i = 0; i < distwl[j].size(); i++) {
                if (!used.contains(distwl[j].get(i)) && soFar[distwl[j].get(i)] >= a.size()) {
                    soFar[distwl[j].get(i)] = a.size();
                    ArrayList<Integer> next = new ArrayList<>(a);
                    next.add(distwl[j].get(i));
                    que.add(next);
                }
            }
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
