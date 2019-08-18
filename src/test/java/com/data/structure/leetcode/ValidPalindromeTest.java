package com.data.structure.leetcode;

import com.leetcode.ValidPalindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class ValidPalindromeTest {

    @Test
    public void test() {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        assertTrue(validPalindrome.isPalindrome(""));
        assertTrue(validPalindrome.isPalindrome("a."));
        assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(validPalindrome.isPalindrome("race a car"));
        assertFalse(validPalindrome.isPalindrome("0P"));
    }

    @Test
    public void t() {
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        System.out.println(a);
        System.out.println(z);
        System.out.println(A);
        System.out.println(Z);
    }
}
