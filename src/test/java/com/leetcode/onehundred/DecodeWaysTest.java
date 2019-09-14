package com.leetcode.onehundred;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author carl
 */
public class DecodeWaysTest {
    DecodeWays decodeWays = new DecodeWays();

    @ParameterizedTest
    @MethodSource("source")
    public void test(String s, int expect) {
        assertEquals(expect, decodeWays.numDecodings(s));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments("17", 2),
                arguments("0", 0),
                arguments("01", 0),
                arguments("10", 1),
                arguments("1010", 1),
                arguments("226", 3),
                arguments("230", 0),
                arguments("1212", 5)
        );
    }
}
