package com.leetcode.fivehundredfifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * haha, this problem is a trap
 *
 * @author carl
 */
public class LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        if (!a.equals(b)) return a.length() < b.length() ? b.length() : a.length();
        Set<String> sa = new HashSet<>(), sb = new HashSet<>();
        List<String> la = solve(a.toCharArray(), 0, a.length() - 1, sa);
        List<String> lb = solve(b.toCharArray(), 0, b.length() - 1, sb);
        Collections.sort(la, (s1, s2) -> s2.length() - s1.length());
        Collections.sort(lb, (s1, s2) -> s2.length() - s1.length());
        int lena = 0;
        for (String s : la) {
            if (!sb.contains(s)) {
                lena = s.length();
                break;
            }
        }
        for (String s : lb) {
            if (!sa.contains(s)) {
                return s.length() >= lena ? s.length() : lena;
            }
        }
        return -1;
    }

    private List<String> solve(char[] cs, int start, int end, Set<String> set) {
        if (start > end) {
            set.add("");
            return Arrays.asList("");
        }
        List<String> list = new ArrayList<>();
        if (start == end) {
            set.add("" + cs[start]);
            list.add("" + cs[start]);
            return list;
        }
        int mid = (start + end) >> 1;
        List<String> left = solve(cs, start, mid, set), right = solve(cs, mid + 1, end, set);
        for (String l : left) {
            for (String r : right) {
                String str = l + r;
                set.add(str);
                list.add(str);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LongestUncommonSubsequenceI lu = new LongestUncommonSubsequenceI();
        System.out.println(lu.findLUSlength("aba", "cde"));
    }
}
