package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/count-primes/
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * @auther carl
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n < 2) return 0;

        boolean[] prime = new boolean[n];
        int ans = 0;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                prime[i] = true;
                ans++;
                for (int j = 2; j * i < prime.length; j++) {
                    prime[j * i] = true;
                }
            }
        }
        return ans;
    }
}
