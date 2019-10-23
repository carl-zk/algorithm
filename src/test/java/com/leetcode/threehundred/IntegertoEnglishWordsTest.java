package com.leetcode.threehundred;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author carl
 */
public class IntegertoEnglishWordsTest {

    IntegertoEnglishWords inst = new IntegertoEnglishWords();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int num, String expect) {
        assertEquals(expect, inst.numberToWords(num));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(1000, "One Thousand"),
                arguments(1000000, "One Million"),
                arguments(123, "One Hundred Twenty Three"),
                arguments(12345, "Twelve Thousand Three Hundred Forty Five"),
                arguments(1234567, "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"),
                arguments(1234567891, "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One")
        );
    }
}
