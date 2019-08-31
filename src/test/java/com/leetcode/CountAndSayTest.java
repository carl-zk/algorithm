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
public class CountAndSayTest {
    CountAndSay cas = new CountAndSay();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int n, String expect) {
        assertEquals(expect, cas.countAndSay(n));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(1, "1"),
                arguments(2, "11"),
                arguments(3, "21"),
                arguments(4, "1211"),
                arguments(5, "111221"),
                arguments(6, "312211"),
                arguments(7, "13112221"),
                arguments(8, "1113213211")
        );
    }
}
