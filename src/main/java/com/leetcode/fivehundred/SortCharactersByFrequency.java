package com.leetcode.fivehundred;

import java.util.Arrays;
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

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        StringBuilder[] builders = new StringBuilder[256];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }
        for (char c : s.toCharArray()) {
            builders[c].append(c);
        }
        Arrays.sort(builders, (a, b) -> b.length() - a.length());
        for (int i = 0; i < builders.length && builders[i].length() > 0; i++) {
            sb.append(builders[i]);
        }
        return sb.toString();
    }
}
