package com.data.structure.leetcode;

import com.leetcode.ValidPalindrome2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class ValidPalindrome2Test {

    @Test
    public void test() {
        ValidPalindrome2 vp = new ValidPalindrome2();

        assertTrue(vp.validPalindrome("a"));
        assertTrue(vp.validPalindrome("aa"));
        assertTrue(vp.validPalindrome("aac"));
        assertTrue(vp.validPalindrome("abca"));
        assertTrue(vp.validPalindrome("acbba"));
        assertFalse(vp.validPalindrome("abcab"));
    }
}
