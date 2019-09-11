package com.leetcode.onehundred;

import java.util.LinkedList;
import java.util.PriorityQueue;

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
        int[] counter = new int[256];
        LinkedList<Integer>[] slider = new LinkedList[256];
        PriorityQueue<Integer> que = new PriorityQueue<>();
        Integer first = null, last = null;

        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int count = counter[s.charAt(i)];
            if (count > 0) {
                LinkedList<Integer> ids = slider[s.charAt(i)];
                if (ids == null) {
                    ids = new LinkedList<>();
                }
                if (ids.size() == count) {
                    que.remove(ids.getFirst());
                    que.add(i);
                    ids.removeFirst();
                    ids.addLast(i);
                    slider[s.charAt(i)] = ids;
                } else {
                    que.add(i);
                    ids.addLast(i);
                    slider[s.charAt(i)] = ids;
                    if (que.size() == t.length()) {
                        if (first == null || last - first > i - que.peek()) {
                            first = que.peek();
                            last = i;
                        }
                        LinkedList<Integer> list = slider[s.charAt(que.peek())];
                        list.removeFirst();
                        slider[s.charAt(que.peek())] = list;
                        que.poll();
                    }
                }
            }
        }
        return first == null ? "" : new String(s.toCharArray(), first, last - first + 1);
    }
}
