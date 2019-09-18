package com.leetcode.onehundredfifty;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * @auther carl
 */
public class DistinctSubsequences {
    ArrayList<Integer>[] ids;
    int[] id;
    int[][] mem;

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
        mem = new int[t.length()][s.length()];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        return count(t.toCharArray(), 0, -1);
    }

    private int count(char[] tc, int i, int up) {
        if (i == tc.length) return 1;
        if (ids[tc[i]] == null) return 0;
        if (up != -1 && mem[i][up] != -1) return mem[i][up];

        int num = 0;
        for (int j = 0; j < ids[tc[i]].size(); j++) {
            if (ids[tc[i]].get(j) > up) {
                num += count(tc, i + 1, ids[tc[i]].get(j));
            }
        }
        if (up != -1) {
            mem[i][up] = num;
        }
        return num;
    }

    public static void main(String[] args) {
        DistinctSubsequences ds = new DistinctSubsequences();
        System.out.println(ds.numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc"
                , "bcddceeeebecbc"));
    }
}
