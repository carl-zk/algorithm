package com.leetcode.fivehundredfifty;

/**
 * @author carl
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        return allUpper(word) || allLower(word) || firstCapitalOnly(word);
    }

    boolean allUpper(String word) {
        for (char c : word.toCharArray()) {
            if ('A' > c || 'Z' < c) return false;
        }
        return true;
    }

    boolean allLower(String word) {
        for (char c : word.toCharArray()) {
            if ('a' > c || 'z' < c) return false;
        }
        return true;
    }

    boolean firstCapitalOnly(String word) {
        return 'A' <= word.charAt(0) && word.charAt(0) <= 'Z' && allLower(word.substring(1));
    }
}
