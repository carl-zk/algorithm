package com.data.structure.leetcode;

import com.leetcode.RomanToInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class RomanToIntegerTest {

    @Test
    public void test() {
        RomanToInteger romanToInteger = new RomanToInteger();

        assertEquals(3, romanToInteger.romanToInt("III"));
        assertEquals(4, romanToInteger.romanToInt("IV"));
        assertEquals(9, romanToInteger.romanToInt("IX"));
        assertEquals(58, romanToInteger.romanToInt("LVIII"));
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"));
    }
}
