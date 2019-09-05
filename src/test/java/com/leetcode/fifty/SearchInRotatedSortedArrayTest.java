package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class SearchInRotatedSortedArrayTest {

    @Test
    public void test() {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int expect = 4;
        int result = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        assertEquals(expect, result);

        expect = -1;
        result = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        assertEquals(expect, result);
    }
}
