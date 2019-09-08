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
public class ValidNumberTest {
    ValidNumber validNumber = new ValidNumber();

    @ParameterizedTest
    @MethodSource("source")
    public void test(String s, boolean expect) {
        assertEquals(expect, validNumber.isNumber(s));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(" -1.", true),
                arguments("+42e+76125", true),
                arguments("6e6.5", false),
                arguments("1e.66", false)
        );
    }
}
