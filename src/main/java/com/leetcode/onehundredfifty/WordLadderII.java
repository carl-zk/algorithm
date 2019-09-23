package com.leetcode.onehundredfifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author carl
 */
public class WordLadderII {
    List<List<String>> ans;
    int[] distb;
    ArrayList<Integer>[] distwl;
    Set<Integer> dest;
    boolean[] visited;
    String bw;
    List<String> wl;
    int minLen;

    ArrayList<ArrayList<String>>[] suffix;
    int[] minSz;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        distb = new int[wordList.size()];
        distwl = new ArrayList[wordList.size()];
        dest = new HashSet<>();
        visited = new boolean[wordList.size()];
        bw = beginWord;
        wl = wordList;
        minLen = Integer.MAX_VALUE;
        suffix = new ArrayList[wordList.size()];
        minSz = new int[wordList.size()];
        Arrays.fill(minSz, wordList.size() << 1);

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

        if (dest.isEmpty()) return Collections.emptyList();

        ans = new LinkedList<>();
        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < wordList.size(); i++) {
            String w = wordList.get(i);
            for (int j = 0; j < beginWord.length(); j++) {
                if (beginWord.charAt(j) != w.charAt(j)) {
                    distb[i]++;
                }
            }
            if (distb[i] == 1) {
                visited[i] = true;
                temp.add(wl.get(i));
                solve(i, temp);
                temp.remove(0);
                visited[i] = false;
            }
        }
        return ans;
    }

    private void solve(int start, ArrayList<String> temp) {
        if (start < 0) return;
        if (dest.contains(start)) {
            if (minLen < temp.size()) return;
            if (minLen > temp.size()) {
                ans.clear();
            }
            ArrayList<String> one = new ArrayList<>(temp);
            one.add(0, bw);
            ans.add(one);
            return;
        }
        if (distwl[start] == null) return;
        for (int i = 0; i < distwl[start].size(); i++) {
            int j = distwl[start].get(i);
            if (!visited[j]) {
                visited[j] = true;
                temp.add(0, wl.get(j));
                solve(j, temp);
                temp.remove(0);
                visited[j] = false;
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
