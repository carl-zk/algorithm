package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/happy-number/
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @auther carl
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n, fast = sum(sum(n));
        while (slow != fast) {
            slow = sum(slow);
            fast = sum(sum(fast));
        }
        return slow == 1;
    }

    private int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += (n % 10) * (n % 10);
            n /= 10;
        }
        return s;
    }
}
