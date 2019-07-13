package com.test;

import com.sort.MergeSort;
import junit.framework.TestCase;

/**
 * @author carl
 */
public class MergeSortTest extends TestCase {

    public void testInput_null() {
        try {
            MergeSort.sort(null);
            fail();
        } catch (NullPointerException ex) {
        }

    }

    public void testInput_empty() {
        int[] a = {};
        MergeSort.sort(a);
        assertEquals(a.length, 0L);
    }

    public void testInput_singleElement() {
        int[] origin = {1};
        int[] expect = {1};
        MergeSort.sort(origin);
        assertEquals(origin.length, expect.length);
        assertEquals(origin[0], expect[0]);
    }

    public void testInput_twoElements() {
        int[] origin = {2, 1};
        int[] expect = {1, 2};
        MergeSort.sort(origin);
        check(origin, expect);
    }

    public void testOrder_asc() {
        int[] origin = {1, 2, 3, 4, 5};
        int[] expect = {1, 2, 3, 4, 5};
        MergeSort.sort(origin);
        check(origin, expect);
    }

    public void testOrder_desc() {
        int[] origin = {5, 4, 3, 2, 1};
        int[] expect = {1, 2, 3, 4, 5};
        MergeSort.sort(origin);
        check(origin, expect);
    }

    private void check(int[] origin, int[] expect) {
        for (int i = 0; i < origin.length; i++) {
            assertEquals(origin[i], expect[i]);
        }
    }
}
