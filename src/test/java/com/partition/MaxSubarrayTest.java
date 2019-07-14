package com.partition;

import junit.framework.TestCase;

/**
 * @author carl
 */
public class MaxSubarrayTest extends TestCase {

    public void testInput_oneElement() {
        int[] a = {1};
        MaxSubarray.Sub expect = new MaxSubarray.Sub(0, 0, 1);

        MaxSubarray maxSubarray = new MaxSubarray(a);
        MaxSubarray.Sub result = maxSubarray.getResult();
        assertEquals(result, expect);
    }

    public void testInput_twoElements() {
        int[] a = {-1, 2};
        MaxSubarray.Sub expect = new MaxSubarray.Sub(1, 1, 2);

        MaxSubarray maxSubarray = new MaxSubarray(a);
        MaxSubarray.Sub result = maxSubarray.getResult();
        assertEquals(result, expect);
    }

    public void testInput_threeElements() {
        int[] a = {9, -1, 2};
        MaxSubarray.Sub expect = new MaxSubarray.Sub(0, 2, 10);

        MaxSubarray maxSubarray = new MaxSubarray(a);
        MaxSubarray.Sub result = maxSubarray.getResult();
        assertEquals(result, expect);
    }

    public void testResultIn_left() {
        int[] a = {1, 9, -10, 2, 4};
        MaxSubarray.Sub expect = new MaxSubarray.Sub(0, 1, 10);

        MaxSubarray maxSubarray = new MaxSubarray(a);
        MaxSubarray.Sub result = maxSubarray.getResult();
        assertEquals(result, expect);
    }

    public void testResultIn_right() {
        int[] a = {1, -9, -10, 2, 4};
        MaxSubarray.Sub expect = new MaxSubarray.Sub(3, 4, 6);

        MaxSubarray maxSubarray = new MaxSubarray(a);
        MaxSubarray.Sub result = maxSubarray.getResult();
        assertEquals(result, expect);
    }

    public void testResultIn_cross() {
        int[] a = {-10, 9, -1, 2, -5};
        MaxSubarray.Sub expect = new MaxSubarray.Sub(1, 3, 10);

        MaxSubarray maxSubarray = new MaxSubarray(a);
        MaxSubarray.Sub result = maxSubarray.getResult();
        assertEquals(result, expect);
    }
}
