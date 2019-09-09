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
public class SqrtxTest {
    Sqrtx sqrtx = new Sqrtx();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int x, int expect) {
        assertEquals(expect, sqrtx.mySqrt(x));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(0, 0),
                arguments(1, 1),
                arguments(2147395599, 46339),
                arguments(2147395600, 46340)
        );
    }
}
