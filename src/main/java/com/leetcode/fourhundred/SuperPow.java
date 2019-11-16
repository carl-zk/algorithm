package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/super-pow/
 * <p>
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * <p>
 * Example 1:
 * <p>
 * Input: a = 2, b = [3]
 * Output: 8
 * Example 2:
 * <p>
 * Input: a = 2, b = [1,0]
 * Output: 1024
 *
 * @author carl
 */
public class SuperPow {
    int mod = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;

        for (int i = 0; i < b.length; i++) {
            ans = modPow(ans, 10) * modPow(a, b[i]);
            ans %= mod;
        }
        return ans;
    }

    private int modPow(int base, int e) {
        long res = 1;
        long y = base;

        while (e > 0) {
            if (e % 2 == 1) {
                res = res * y % mod;
            }
            y = y * y % mod;
            e >>= 1;
        }
        return (int) (res % mod);
    }

    public static void main(String[] args) {
        SuperPow superPow = new SuperPow();
        System.out.println(superPow.superPow(2147483647, new int[]{2, 0, 0}));
    }
}
