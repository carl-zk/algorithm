package com.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author carl
 */
public class FirstMissingPositiveTest {
    FirstMissingPositive fmp = new FirstMissingPositive();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int expect) {
        assertEquals(expect, fmp.firstMissingPositive(nums));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{1, 1}, 2),
                arguments(new int[]{1, 2, 0}, 3),
                arguments(new int[]{3, 4, -1, 1}, 2),
                arguments(new int[]{7, 8, 9, 11, 12}, 1)
        );
    }
}
