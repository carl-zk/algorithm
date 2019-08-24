package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class LetterCombinationsOfaPhoneNumberTest {

    @Test
    public void test() {
        LetterCombinationsOfaPhoneNumber ins = new LetterCombinationsOfaPhoneNumber();

        List<String> result = ins.letterCombinations("23");
        result.forEach(x -> System.out.println(x));
        assertEquals(1, 1);
    }
}
