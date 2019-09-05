package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class DivideTwoIntegersTest {

    @Test
    public void test() {
        DivideTwoIntegers dt = new DivideTwoIntegers();

        assertEquals(3, dt.divide(10, 3));
        assertEquals(-2, dt.divide(7, -3));
        assertEquals(2147483647, dt.divide(-2147483648, -1));
        assertEquals(-2147483648, dt.divide(-2147483648, 1));
        assertEquals(-1, dt.divide(1100540749, -1090366779));
    }

    @Test
    public void t() {
        System.out.println(Integer.MIN_VALUE / (-1));
        System.out.println(Integer.MIN_VALUE / 2);
        System.out.println(0 - Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
