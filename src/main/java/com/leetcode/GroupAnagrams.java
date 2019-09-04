package com.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * @auther carl
 */
public class GroupAnagrams {
    List<List<String>> ans;

    public List<List<String>> groupAnagrams(String[] strs) {
        ans = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            List<String> list = map.get(sortedStr);
            if (list == null) {
                list = new LinkedList<>();
                list.add(strs[i]);
                map.put(sortedStr, list);
            } else {
                list.add(strs[i]);
            }
        }
        map.entrySet().forEach(entry -> ans.add(entry.getValue()));
        return ans;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
