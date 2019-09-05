package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void test() {
        RemoveDuplicatesFromSortedArray rem = new RemoveDuplicatesFromSortedArray();

        int[] expected = new int[]{1, 2};
        int[] a = new int[]{1, 1, 2};
        int len = rem.removeDuplicates(a);

        assertEquals(expected.length, len);
        assertTrue(() -> {
            for (int i = 0; i < expected.length; i++) {
                if (expected[i] != a[i]) {
                    return false;
                }
            }
            return true;
        });
    }
}
