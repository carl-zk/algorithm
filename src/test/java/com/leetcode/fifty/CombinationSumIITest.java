package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class CombinationSumIITest {
    CombinationSumII csii = new CombinationSumII();

    @Test
    public void test() {
        List<List<Integer>> expect = new LinkedList<>();
        expect.add(Arrays.asList(1, 1, 6));
        expect.add(Arrays.asList(1, 2, 5));
        expect.add(Arrays.asList(1, 7));
        expect.add(Arrays.asList(2, 6));
        int[] input = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = csii.combinationSum2(input, 8);
        assertEquals(expect.size(), result.size());
        assertTrue(() -> {
            for (int i = 0; i < expect.size(); i++) {
                for (int j = 0; j < expect.get(i).size(); j++) {
                    if (expect.get(i).get(j) != result.get(i).get(j)) {
                        return false;
                    }
                }
            }
            return true;
        });
    }
}
