package com.leetcode.fourhundredfifty;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * @author carl
 */
public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        int[] dict = new int[256];
        int[] counter = new int[256];
        int len = p.length();

        for (char c : p.toCharArray()) {
            dict[c]++;
        }

        char[] chars = s.toCharArray();
        int i = 0, sz = 0;

        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];

            if (dict[c] > 0) {
                counter[c]++;
                sz++;
                for (; counter[c] > dict[c]; ) {
                    counter[chars[i++]]--;
                    sz--;
                }
                if (sz == len) {
                    ans.add(i);
                    counter[chars[i++]]--;
                    sz--;
                }
            } else {
                for (; i <= j; ) {
                    counter[chars[i++]]--;
                }
                sz = 0;
            }
        }
        return ans;
    }
}
