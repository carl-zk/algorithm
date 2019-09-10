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
public class MinimumWindowSubstringTest {
    MinimumWindowSubstring mws = new MinimumWindowSubstring();

    @ParameterizedTest
    @MethodSource("source")
    public void test(String s, String t, String expect) {
        assertEquals(expect, mws.minWindow(s, t));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments("ADOBECODEBANC", "ABC", "BANC"),
                arguments("ADOBECODEBACN", "ABC", "BAC"),
                arguments("ADOBECODEBACN", "AD", "AD"),
                arguments("ADOBECODEBACN", "ACN", "ACN"),
                arguments("abc", "de", "")
        );
    }
}
