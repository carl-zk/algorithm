package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/ransom-note/
 * <p>
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @author carl
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[256];

        for (char c : magazine.toCharArray()) {
            counter[c]++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--counter[c] < 0) return false;
        }

        return true;
    }
}
