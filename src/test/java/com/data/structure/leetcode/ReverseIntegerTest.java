package com.data.structure.leetcode;

import com.leetcode.ReverseInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class ReverseIntegerTest {

    @Test
    public void test() {
        ReverseInteger reverseInteger = new ReverseInteger();
        assertEquals(0, reverseInteger.reverse(0));
        assertEquals(0, reverseInteger.reverse(Integer.MIN_VALUE));
        assertEquals(1, reverseInteger.reverse(1));
        assertEquals(-31, reverseInteger.reverse(-13));
        assertEquals(0, reverseInteger.reverse(1534236469));
        assertEquals(2147483641, reverseInteger.reverse(1463847412));
    }

    @Test
    public void t() {
        System.out.println(-32 % 10);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
