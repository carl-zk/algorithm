package com.data.structure.leetcode;

import com.leetcode.IntegerToRoman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class IntegerToRomanTest {

    @Test
    public void test() {
        IntegerToRoman itr = new IntegerToRoman();

        assertEquals("III", itr.intToRoman(3));
        assertEquals("IV", itr.intToRoman(4));
        assertEquals("IX", itr.intToRoman(9));
        assertEquals("LVIII", itr.intToRoman(58));
        assertEquals("MCMXCIV", itr.intToRoman(1994));
    }
}
