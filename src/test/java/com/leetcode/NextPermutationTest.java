package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class NextPermutationTest {

    @Test
    public void test() {
        NextPermutation np = new NextPermutation();

        assertAll(
                () -> assertTrue(() -> {
                    int[] exp = new int[]{1, 3, 2};
                    int[] nums = new int[]{1, 2, 3};
                    np.nextPermutation(nums);
                    for (int i = 0; i < exp.length; i++) {
                        if (exp[i] != nums[i]) {
                            return false;
                        }
                    }
                    return true;
                }), () -> assertTrue(() -> {
                    int[] exp = new int[]{1, 2, 3};
                    int[] nums = new int[]{3, 2, 1};
                    np.nextPermutation(nums);
                    for (int i = 0; i < exp.length; i++) {
                        if (exp[i] != nums[i]) {
                            return false;
                        }
                    }
                    return true;
                }), () -> assertTrue(() -> {
                    int[] exp = new int[]{1, 5, 1};
                    int[] nums = new int[]{1, 1, 5};
                    np.nextPermutation(nums);
                    for (int i = 0; i < exp.length; i++) {
                        if (exp[i] != nums[i]) {
                            return false;
                        }
                    }
                    return true;
                }), () -> assertTrue(() -> {
                    int[] exp = new int[]{1, 4, 3, 6, 7};
                    int[] nums = new int[]{1, 3, 7, 6, 4};
                    np.nextPermutation(nums);
                    for (int i = 0; i < exp.length; i++) {
                        if (exp[i] != nums[i]) {
                            return false;
                        }
                    }
                    return true;
                }));

    }
}
