package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/nth-digit/
 * <p>
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * <p>
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 3
 * <p>
 * Output:
 * 3
 * Example 2:
 * <p>
 * Input:
 * 11
 * <p>
 * Output:
 * 0
 * <p>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *
 * @author carl
 */
public class NthDigit {

    public int findNthDigit(int n) {
        n -= 1;
        int digits = 1, first = 1;
        while (n / 9 / digits / first >= 1) {
            n -= 9 * digits * first;
            digits++;
            first *= 10;
        }
        return String.valueOf(first + n / digits).charAt(n % digits) - '0';
    }
}
