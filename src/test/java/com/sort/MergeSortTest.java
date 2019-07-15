package com.sort;

/**
 * @author carl
 */
public class MergeSortTest extends SortTest {

    @Override
    Sort getSort() {
        return new MergeSort();
    }
}
