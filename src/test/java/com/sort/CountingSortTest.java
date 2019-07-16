package com.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class CountingSortTest {

    private CountingSort getSort() {
        return new CountingSort();
    }

    @Test
    public void testInput_empty() {
        int[] a = {};
        int[] b = {};
        getSort().sort(a, b, 0);
        assertEquals(b.length, 0L);
    }

    @Test
    public void testInput_singleElement() {
        int[] a = {1};
        int[] b = new int[1];
        int[] expect = {1};
        getSort().sort(a, b, 1);
        check(expect, b);
    }

    @Test
    public void testInput_twoElements() {
        int[] a = {2, 1};
        int[] b = new int[2];
        int[] expect = {1, 2};
        getSort().sort(a, b, 2);
        check(expect, b);
    }

    @Test
    public void testOrder_asc() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[5];
        int[] expect = {1, 2, 3, 4, 5};
        getSort().sort(a, b, 5);
        check(expect, b);
    }

    @Test
    public void testOrder_desc() {
        int[] a = {5, 4, 3, 2, 1};
        int[] b = new int[5];
        int[] expect = {1, 2, 3, 4, 5};
        getSort().sort(a, b, 5);
        check(expect, b);
    }

    private void check(int[] expect, int[] origin) {
        for (int i = 0; i < origin.length; i++) {
            assertEquals(expect[i], origin[i]);
        }
    }
}
