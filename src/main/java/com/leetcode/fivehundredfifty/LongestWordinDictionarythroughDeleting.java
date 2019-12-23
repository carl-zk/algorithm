package com.leetcode.fivehundredfifty;

import java.util.Collections;
import java.util.List;

/**
 * @author carl
 */
public class LongestWordinDictionarythroughDeleting {
    String ans = "";

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) return a.charAt(i) < b.charAt(i) ? -1 : 1;
            }
            return -1;
        });
        char[] cs = s.toCharArray();
        for (String wd : d) {
            int i = 0, j = 0;
            for (; i < cs.length && j < wd.length(); i++) {
                if (cs[i] == wd.charAt(j)) j++;
            }
            if (j == wd.length()) {
                return wd;
            }
        }
        //solve(s.toCharArray(), 0, d, "");
        return "";
    }

    private void solve(char[] cs, int index, List<String> d, String str) {
        if (str.length() > ans.length()) {
            ans = str;
        } else if (str.length() == ans.length()) {
            ans = minStr(ans, str);
        }
        for (String wd : d) {
            int i = index, j = 0;
            for (; i < cs.length && j < wd.length(); i++) {
                if (cs[i] == wd.charAt(j)) j++;
            }
            if (j == wd.length()) {
                solve(cs, i, d, str + wd);
            }
        }
    }

    private String minStr(String a, String b) {
        char[] ca = a.toCharArray(), cb = b.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != cb[i]) {
                return ca[i] < cb[i] ? a : b;
            }
        }
        return a;
    }
}
