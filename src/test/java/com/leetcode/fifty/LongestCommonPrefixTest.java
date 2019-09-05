package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class LongestCommonPrefixTest {

    @Test
    public void test() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        assertEquals("fl", longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("a", longestCommonPrefix.longestCommonPrefix(new String[]{"a"}));
    }
}
