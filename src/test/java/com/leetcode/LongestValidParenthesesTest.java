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
public class LongestValidParenthesesTest {
    LongestValidParentheses lvp = new LongestValidParentheses();

    @ParameterizedTest
    @MethodSource("source")
    public void test(String s, int c) {
        assertEquals(c, lvp.longestValidParentheses(s));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments("(()", 2),
                arguments("", 0),
                arguments("()(())", 6),
                arguments("()(()", 2),
                arguments("()(()()", 4),
                arguments(")()())", 4)
        );
    }
}
