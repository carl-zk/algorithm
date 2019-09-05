package com.leetcode.onehundred;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @auther carl
 */
public class NQueensIITest {
    NQueensII nQueensII = new NQueensII();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int n, int expect) {
        assertEquals(expect, nQueensII.totalNQueens(n));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(4, 2),
                arguments(5, 10),
                arguments(10, 724),
                arguments(12, 14200)
        );
    }
}
