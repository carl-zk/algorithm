package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class CombinationSumTest {
    CombinationSum cs = new CombinationSum();

    @Test
    public void test() {
        List<List<Integer>> expect = new LinkedList<>();
        expect.add(Arrays.asList(2, 2, 3));
        expect.add(Arrays.asList(7));
        int[] input = {2, 3, 6, 7};
        List<List<Integer>> result = cs.combinationSum(input, 7);
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
