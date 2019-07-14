package com.test;

import com.sort.MergeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author carl
 */
public class MergeSortTest {

    @Test
    public void testInput_null() {
        assertThrows(NullPointerException.class, () -> MergeSort.sort(null));
    }

    @Test
    public void testInput_empty() {
        int[] a = {};
        MergeSort.sort(a);
        assertEquals(a.length, 0L);
    }

    @Test
    public void testInput_singleElement() {
        int[] origin = {1};
        int[] expect = {1};
        MergeSort.sort(origin);
        assertEquals(origin.length, expect.length);
        assertEquals(origin[0], expect[0]);
    }

    @Test
    public void testInput_twoElements() {
        int[] origin = {2, 1};
        int[] expect = {1, 2};
        MergeSort.sort(origin);
        check(origin, expect);
    }

    @Test
    public void testOrder_asc() {
        int[] origin = {1, 2, 3, 4, 5};
        int[] expect = {1, 2, 3, 4, 5};
        MergeSort.sort(origin);
        check(origin, expect);
    }

    @Test
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
