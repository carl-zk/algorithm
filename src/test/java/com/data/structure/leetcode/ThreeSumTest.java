package com.data.structure.leetcode;

import com.leetcode.ThreeSum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author carl
 */
public class ThreeSumTest {

    @Test
    public void test() {
        ThreeSum threeSum = new ThreeSum();

        List<List<Integer>> ans = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        ans.forEach(list -> {
            list.forEach(
                    e -> System.out.print(e + ", ")
            );
            System.out.println();
        });
    }

    @Test
    public void test2() {
        ThreeSum threeSum = new ThreeSum();

        List<List<Integer>> ans = threeSum.threeSum(new int[]{0, 0, 0, 0});
        ans.forEach(list -> {
            list.forEach(
                    e -> System.out.print(e + ", ")
            );
            System.out.println();
        });
    }

    @Test
    public void t() {
        int[] nums = new int[]{1, 2, 3};
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
