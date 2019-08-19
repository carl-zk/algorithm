package com.data.structure.leetcode;

import com.leetcode.ContainerWithMostWater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class ContainerWithMostWaterTest {

    @Test
    public void test() {
        ContainerWithMostWater cwt = new ContainerWithMostWater();

        assertEquals(0, cwt.maxArea(new int[]{0, 0}));
        assertEquals(0, cwt.maxArea(new int[]{0, 1}));
        assertEquals(0, cwt.maxArea(new int[]{1, 0}));
        assertEquals(49, cwt.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
