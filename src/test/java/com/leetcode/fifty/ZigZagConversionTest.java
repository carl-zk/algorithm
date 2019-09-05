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
public class ZigZagConversionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    public void test(String expect, String input, int numRows) {
        ZigZagConversion p = new ZigZagConversion();
        String res = p.convert(input, numRows);
        assertEquals(expect, res);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                arguments("ab", "ab", 1),
                arguments("0481357926", "0123456789", 3),
                arguments("PAHNAPLSIIGYIR", "PAYPALISHIRING", 3)
        );
    }

}
