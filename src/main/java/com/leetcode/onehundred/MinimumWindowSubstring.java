package com.leetcode.onehundred;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @auther carl
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> counts = new HashMap<>();
        Map<Character, LinkedList<Integer>> indexes = new HashMap<>();
        LinkedList<Integer> que = new LinkedList<>();
        Integer first = null, last = null;

        for (int i = 0; i < t.length(); i++) {
            counts.put(t.charAt(i), 1 + counts.getOrDefault(t.charAt(i), 0));
        }

        for (int i = 0; i < s.length(); i++) {
            Integer count = counts.get(s.charAt(i));
            if (count != null) {
                LinkedList<Integer> ids = indexes.getOrDefault(s.charAt(i), new LinkedList<>());
                if (ids.size() == count) {
                    que.remove(ids.getFirst());
                    que.addLast(i);
                    ids.removeFirst();
                    ids.addLast(i);
                    indexes.put(s.charAt(i), ids);
                } else {
                    que.addLast(i);
                    ids.addLast(i);
                    indexes.put(s.charAt(i), ids);
                    if (que.size() == t.length()) {
                        if (first == null || last - first > que.getLast() - que.getFirst()) {
                            first = que.getFirst();
                            last = que.getLast();
                        }
                        LinkedList<Integer> list = indexes.get(s.charAt(que.getFirst()));
                        list.removeFirst();
                        indexes.put(s.charAt(que.getFirst()), list);
                        que.removeFirst();
                    }
                }
            }
        }
        return first == null ? "" : new String(s.toCharArray(), first, last - first + 1);
    }
}
