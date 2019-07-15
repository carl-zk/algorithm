package com.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class HeapSortTest {

    @Test
    public void testInput_oneElement() {
        int[] a = {0, 1};
        int[] expect = {0, 1};
        check(expect, a);
    }

    @Test
    public void testInput_twoElements() {
        int[] a = {0, 1, 2};
        int[] expect = {0, 1, 2};
        check(expect, a);
    }

    @Test
    public void testInput_threeElements() {
        int[] a = {0, 3, 1, 2};
        int[] expect = {0, 1, 2, 3};
        check(expect, a);
    }

    public void check(int[] expect, int[] actual) {
        new HeapSort(actual).sort();

        for (int i = 0; i < expect.length; i++) {
            assertEquals(expect[i], actual[i]);
        }
    }
}
