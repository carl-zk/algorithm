package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class ValidParenthesesTest {

    @Test
    public void test() {
        ValidParentheses vp = new ValidParentheses();

        assertTrue(vp.isValid(""));
        assertTrue(vp.isValid("[]"));
        assertTrue(vp.isValid("()[]{}"));
        assertTrue(vp.isValid("{[]}"));
        assertFalse(vp.isValid("[)"));
        assertFalse(vp.isValid("([)]"));
        assertFalse(vp.isValid("()]"));
    }
}
