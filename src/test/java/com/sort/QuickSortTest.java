package com.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class QuickSortTest extends SortTest {

    @Override
    Sort getSort() {
        return new QuickSort();
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int next = QuickSort.internalNextInt(random, 2, 6);
            assertTrue(2 <= next && next < 6);
        }
    }
}
