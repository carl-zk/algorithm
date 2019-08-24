package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class ThreeSumClosestTest {

    @Test
    public void test() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();

        assertEquals(2, threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
