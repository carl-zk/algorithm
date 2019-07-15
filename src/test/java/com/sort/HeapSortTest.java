package com.sort;

/**
 * @author carl
 */
public class HeapSortTest extends SortTest {

    @Override
    Sort getSort() {
        return new HeapSort();
    }
}
