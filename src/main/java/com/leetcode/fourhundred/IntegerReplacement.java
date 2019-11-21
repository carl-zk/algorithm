package com.leetcode.fourhundred;

import java.util.HashMap;
import java.util.Map;

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
    Map<Long, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        return solve(n, 0);
    }

    private int solve(long n, int times) {
        if (map.containsKey(n)) return map.get(n) + times;
        while (n % 2 == 0) {
            n >>= 1;
            times++;
        }

        if (n == 1) {
            map.put(n, times);
            return times;
        }
        int min = Math.min(solve(n - 1, times + 1), solve(n + 1, times + 1));
        map.put(n, min);
        return min;
    }
}

