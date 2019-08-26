package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author carl
 */
public class SubstringWithConcatenationOfAllWords {
    boolean[] flags;

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) return Arrays.asList();
        char[] sour = s.toCharArray();
        flags = new boolean[s.length()];
        perm(sour, words, 0, 0);
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void perm(char[] sour, String[] words, int idx, int n) {
        if (n == words.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                sb.append(words[i]);
            }
            char[] tar = sb.toString().toCharArray();

            for (int i = 0; i < sour.length; i++) {
                if (sour[i] == tar[0]) {
                    int j = indexOf(sour, i, tar);
                    if (j != -1) {
                        flags[j] = true;
                    }
                }
            }
            return;
        }
        for (int i = idx; i < words.length; i++) {
            swap(words, idx, i);
            perm(sour, words, idx + 1, n + 1);
            swap(words, idx, i);
        }
    }

    public int indexOf(char[] sour, int i, char[] tar) {
        if (i + tar.length <= sour.length) {
            boolean f = true;
            int l = i + 1;
            int r = i + tar.length - 1;
            while (l <= r) {
                if (sour[l] == tar[l - i] && sour[r] == tar[r - i]) {
                    l++;
                    r--;
                } else {
                    f = false;
                    break;
                }
            }
            if (f) {
                return i;
            }
        } else {
            return -1;
        }
        return -1;
    }

    private void swap(String[] words, int i, int j) {
        String s = words[i];
        words[i] = words[j];
        words[j] = s;
    }
}
