package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class LongestPalindromicSubstringTest {

    @Test
    public void test() {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        assertEquals("bb", lps.longestPalindrome("cbbd"));
        assertEquals("ababa", lps.longestPalindrome("ababa"));
    }
}
