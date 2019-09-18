package com.leetcode.onehundredfifty;

import java.util.ArrayList;

/**
 * @auther carl
 */
public class DistinctSubsequences {
    ArrayList<Integer>[] ids;
    int[] id;

    public int numDistinct(String s, String t) {
        ids = new ArrayList[256];
        id = new int[256];
        for (int i = 0; i < t.length(); i++) {
            id[t.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ids[s.charAt(i)] == null) {
                ids[s.charAt(i)] = new ArrayList<>();
            }
            ids[s.charAt(i)].add(i);
        }
        return count(t.toCharArray(), 0, -1);
    }

    private int count(char[] tc, int i, int up) {
        if (i == tc.length) return 1;
        if (ids[tc[i]] == null) return 0;

        int num = 0;
        for (int j = 0; j < ids[tc[i]].size(); j++) {
            if (ids[tc[i]].get(j) > up) {
                num += count(tc, i + 1, ids[tc[i]].get(j));
            }
        }
        return num;
    }
}
