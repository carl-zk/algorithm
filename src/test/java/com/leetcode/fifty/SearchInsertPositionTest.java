package com.leetcode.fifty;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author carl
 */
public class SearchInsertPositionTest {
    SearchInsertPosition search = new SearchInsertPosition();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int target, int expect) {
        int result = search.searchInsert(nums, target);
        assertEquals(expect, result);
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{1}, 1, 0),
                arguments(new int[]{1, 3, 5, 6}, 5, 2),
                arguments(new int[]{1, 3, 5, 6}, 2, 1),
                arguments(new int[]{1, 3, 5, 6}, 7, 4),
                arguments(new int[]{1, 3, 5, 6}, 0, 0)
        );
    }
}
