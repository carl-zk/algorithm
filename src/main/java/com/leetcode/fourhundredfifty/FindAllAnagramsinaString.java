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
        int[] counter = new int[256];

        for (char c : p.toCharArray()) {
            counter[c]++;
        }

        char[] ss = s.toCharArray();
        int left = 0, right = 0;

        while (right < ss.length) {
            if (counter[ss[right]] > 0) {
                counter[ss[right++]]--;
            } else {
                counter[ss[left++]]++;
            }
            if (right - left == p.length()) {
                ans.add(left);
            }
        }
        return ans;
    }
}
