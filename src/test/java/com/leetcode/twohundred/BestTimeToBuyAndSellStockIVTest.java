package com.leetcode.twohundred;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author carl
 */
public class BestTimeToBuyAndSellStockIVTest {
    BestTimeToBuyAndSellStockIV btb = new BestTimeToBuyAndSellStockIV();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int k, int[] prices, int expect) {
        assertEquals(expect, btb.maxProfit(k, prices));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(2, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}, 13),
                arguments(2, new int[]{2, 4, 1}, 2),
                arguments(2, new int[]{3, 2, 6, 5, 0, 3}, 7)
        );
    }
}
