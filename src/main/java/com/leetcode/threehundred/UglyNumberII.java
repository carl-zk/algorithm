package com.leetcode.threehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 *
 * @auther carl
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        List<Integer> uglies = new ArrayList<>();
        uglies.add(0);
        uglies.add(1);
        int i2 = 1, i3 = 1, i5 = 1;
        while (uglies.size() <= n) {
            int next = Math.min(2 * uglies.get(i2), Math.min(3 * uglies.get(i3), 5 * uglies.get(i5)));
            uglies.add(next);
            if (2 * uglies.get(i2) == next) {
                i2++;
            }
            if (3 * uglies.get(i3) == next) {
                i3++;
            }
            if (5 * uglies.get(i5) == next) {
                i5++;
            }
        }
        return uglies.get(n);
    }
}
