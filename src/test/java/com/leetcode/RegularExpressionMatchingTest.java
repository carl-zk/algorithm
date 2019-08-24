package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class RegularExpressionMatchingTest {

    @Test
    public void test() {
        RegularExpressionMatching matcher = new RegularExpressionMatching();

        assertTrue(matcher.isMatch("", ""));
        assertTrue(matcher.isMatch("a", "."));
        assertTrue(matcher.isMatch("ab", ".*"));
        assertTrue(matcher.isMatch("aa", "a*"));
        assertTrue(matcher.isMatch("aaa", "a*a"));
        assertTrue(matcher.isMatch("aaa", "a*aaa"));
        assertTrue(matcher.isMatch("aab", "c*a*b"));
        assertFalse(matcher.isMatch("aa", "a"));
        assertFalse(matcher.isMatch("mississippi", "mis*is*p*."));
        assertFalse(matcher.isMatch("ab", ".*c"));
    }
}
