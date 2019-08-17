package com.data.structure.leetcode;

import com.leetcode.StringToInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class StringToIntegerTest {

    @Test
    public void test() {
        StringToInteger stringToInteger = new StringToInteger();
        assertEquals(0, stringToInteger.myAtoi(""));
        assertEquals(0, stringToInteger.myAtoi("+-2"));
        assertEquals(-1, stringToInteger.myAtoi("-000000001"));
        assertEquals(0, stringToInteger.myAtoi("  -0000000000"));
        assertEquals(1, stringToInteger.myAtoi("+1"));
        assertEquals(123, stringToInteger.myAtoi("123"));
        assertEquals(-123, stringToInteger.myAtoi("   -123"));
        assertEquals(4193, stringToInteger.myAtoi("4193 with words"));
        assertEquals(0, stringToInteger.myAtoi("words and 987"));
        assertEquals(Integer.MIN_VALUE, stringToInteger.myAtoi("-91283472332"));
        assertEquals(Integer.MAX_VALUE, stringToInteger.myAtoi("91283472332"));
        assertEquals(Integer.MAX_VALUE, stringToInteger.myAtoi("2147483647"));
        assertEquals(Integer.MIN_VALUE, stringToInteger.myAtoi("-2147483648"));
    }

    @Test
    public void t() {
        char c = '1';
        int i = c;
        System.out.println(i);
        System.out.println('1' - '0');
    }
}
