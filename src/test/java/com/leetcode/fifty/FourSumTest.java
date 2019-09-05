package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author carl
 */
public class FourSumTest {

    @Test
    public void test() {
        int[] a = new int[]{1, 0, -1, 0, -2, 2};
        int[] b = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] c = new int[]{2, 1, 0, -1};
        int[] d = new int[]{-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};

        FourSum fourSum = new FourSum();
        List<List<Integer>> result = fourSum.fourSum(c, 2);
        result.forEach(x -> {
            x.forEach(i -> System.out.print(i + ", "));
            System.out.println();
        });
        System.out.println(result.size());
    }
}
