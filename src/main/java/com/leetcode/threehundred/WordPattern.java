package com.leetcode.threehundred;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * <p>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 * @auther carl
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> map = new HashMap<>();
        String[] list = str.split(" ");
        int i = 0;
        char[] pat = pattern.toCharArray();

        for (String s : list) {
            if (!s.isEmpty()) {
                if (i == pat.length) return false;
                if (map.getOrDefault(s, pat[i]) != pat[i]) return false;
                if (!map.containsKey(s) && map.containsValue(pat[i])) return false;
                if (map.containsKey(s) && !map.containsValue(pat[i])) return false;
                map.put(s, pat[i++]);
            }
        }
        return i == pat.length;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
    }
}
