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
    int[][] distwl;
    Set<Integer> dest;
    boolean[] visited;
    String bw;
    List<String> wl;
    int minLen;
    int[] sofar;
    int[] suffix;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        distb = new int[wordList.size()];
        distwl = new int[wordList.size()][wordList.size()];
        dest = new HashSet<>();
        visited = new boolean[wordList.size()];
        bw = beginWord;
        wl = wordList;
        minLen = Integer.MAX_VALUE;
        sofar = new int[wordList.size()];
        Arrays.fill(sofar, Integer.MAX_VALUE);
        suffix = new int[wordList.size()];

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
                distwl[i][j] = distwl[j][i] = d;
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            String w = wordList.get(i);
            for (int j = 0; j < beginWord.length(); j++) {
                if (beginWord.charAt(j) != w.charAt(j)) {
                    distb[i]++;
                }
            }
            if (endWord.equals(w)) {
                dest.add(i);
            }
        }

        if (dest.isEmpty()) return Collections.emptyList();

        ans = new LinkedList<>();

        dest.forEach(index -> {
            visited[index] = true;
            suffix[index] = 0;
            suf(index, 0);
            visited[index] = false;
        });

        int[] temp = new int[wordList.size()];

        for (int i = 0; i < distb.length; i++) {
            if (distb[i] == 1) {
                visited[i] = true;
                temp[0] = i;
                sofar[i] = 1;
                solve(i, temp, 1);
                visited[i] = false;
            }
        }
        return ans;
    }

    private void suf(int start, int count) {
        for (int i = 0; i < wl.size(); i++) {
            if (distwl[start][i] == 1 && !visited[i] && (suffix[i] == 0 || suffix[i] > count + 1)) {
                suffix[i] = count + 1;
                visited[i] = true;
                suf(i, count + 1);
                visited[i] = false;
            }
        }
    }

    private void solve(int start, int[] temp, int len) {

        if (dest.contains(start)) {
            List<String> list = new ArrayList<>();
            list.add(bw);
            for (int i = 0; i < len; i++) {
                list.add(wl.get(temp[i]));
            }
            if (minLen > list.size()) {
                ans.clear();
            }
            minLen = list.size();
            ans.add(list);
            return;
        }

        if (suffix[start] == 0) return;

        if (suffix[start] + len + 1 > minLen) {
            return;
        }

        for (int i = 0; i < distwl.length; i++) {
            if (distwl[start][i] == 1 && !visited[i] && sofar[i] >= len + 1 && len + 1 <= minLen) {
                visited[i] = true;
                temp[len] = i;
                sofar[i] = len + 1;
                solve(i, temp, len + 1);
                visited[i] = false;
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
