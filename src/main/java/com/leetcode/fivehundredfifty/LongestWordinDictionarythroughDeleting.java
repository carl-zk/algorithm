package com.leetcode.fivehundredfifty;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author carl
 */
public class LongestWordinDictionarythroughDeleting {
    Map<Character, TreeSet<Integer>> map = new HashMap<>();

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            else return a.compareTo(b);
        });
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            map.computeIfAbsent(cs[i], k -> new TreeSet<>()).add(i);
        }

        for (String wd : d) {
            if (contains(wd.toCharArray())) return wd;
        }
        return "";
    }

    private boolean contains(char[] wd) {
        int i = 0;
        Integer cur = -1;
        while (i < wd.length) {
            Integer next = map.getOrDefault(wd[i], new TreeSet<>()).ceiling(cur);
            if (next == null) return false;
            cur = next + 1;
            i++;
        }
        return true;
    }
}
