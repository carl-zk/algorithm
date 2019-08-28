package com.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author carl
 */
public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    FindFirstAndLastPositionOfElementInSortedArray find = new FindFirstAndLastPositionOfElementInSortedArray();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int target, int[] expect) {
        int[] result = find.searchRange(nums, target);
        assertEquals(expect.length, result.length);
        assertTrue(() -> {
            for (int i = 0; i < result.length; i++) {
                if (expect[i] != result[i]) {
                    return false;
                }
            }
            return true;
        });
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                arguments(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1})
        );
    }
}
