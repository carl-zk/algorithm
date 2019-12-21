package com.leetcode.fivehundredfifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author carl
 */
public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        boolean allSame = true;
        for (String s : strs) {
            map.compute(s, (k, v) -> v == null ? 1 : v + 1);
            if (allSame) allSame = s == strs[0];
        }
        if (allSame) return -1;
        Set<String> set = new HashSet<>();
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        for (String s : strs) {
            if (map.get(s) == 1 && !set.contains(s)) return s.length();
            else if (!set.contains(s)) subStrs(s.toCharArray(), 0, s.length() - 1, set);
        }
        return -1;
    }

    private List<String> subStrs(char[] cs, int start, int end, Set<String> set) {
        List<String> list = new ArrayList<>();
        set.add("");
        list.add("");
        if (start > end) {
            return list;
        }
        if (start == end) {
            set.add("" + cs[start]);
            list.add("" + cs[start]);
            return list;
        }
        int mid = (start + end) >> 1;
        List<String> left = subStrs(cs, start, mid, set), right = subStrs(cs, mid + 1, end, set);
        for (String l : left) {
            for (String r : right) {
                String str = l + r;
                set.add(str);
                list.add(str);
            }
        }
        return list;
    }
}
