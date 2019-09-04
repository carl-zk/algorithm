package com.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @auther carl
 */
public class PowTest {
    Pow pow = new Pow();

    @ParameterizedTest
    @MethodSource("source")
    public void test(double x, int n, double expect) {
        assertTrue(() -> Math.abs(expect - pow.myPow(x, n)) < 0.000001);
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(2.00000, 10, 1024.00000),
                arguments(2.10000, 3, 9.26100),
                arguments(2.00000, -2, 0.25000)
        );
    }
}
