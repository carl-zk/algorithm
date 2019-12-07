package com.leetcode.fivehundred;

import java.util.PriorityQueue;
// @formatter:off
/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * @author carl
 */
// @formatter:on

public class SortCharactersByFrequency {
    char[] ans;
    int index = 0;

    public String frequencySort(String s) {
        ans = new char[s.length()];
        int[] counter = new int[128];
        for (char c : s.toCharArray()) counter[c]++;
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < counter.length; i++) {
            que.add(new int[]{counter[i], i});
        }
        while (!que.isEmpty()) {
            int[] e = que.poll();
            for (int i = 0; i < e[0]; i++) {
                ans[index++] = (char) e[1];
            }
        }
        return new String(ans);
    }
}
