package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/integer-replacement/
 * <p>
 * Given a positive integer n and you can do operations as follow:
 * <p>
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 8
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * Example 2:
 * <p>
 * Input:
 * 7
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 *
 * @author carl
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        int count = 0;
        long num = n;
        while (num > 1) {
            if (num % 2 == 0) {
                num >>= 1;
            } else if (num != 3 && (num + 1) % 4 == 0) {
                num++;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }
}

