package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/burst-balloons/
 * <p>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * <p>
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @auther carl
 */
public class BurstBalloons {
    int[] nums;
    int[][] mem;
    int n;

    public int maxCoins(int[] nums) {
        n = nums.length + 2;
        this.nums = new int[n];
        this.mem = new int[n][n];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i + 1] = nums[i];
        }
        this.nums[0] = this.nums[n - 1] = 1;
        return burst(0, n - 1);
    }

    private int burst(int left, int right) {
        if (left + 1 == right) return 0;
        if (mem[left][right] > 0) return mem[left][right];
        for (int i = left + 1; i < right; i++) {
            mem[left][right] = Math.max(mem[left][right],
                    nums[left] * nums[i] * nums[right] + burst(left, i) + burst(i, right));
        }
        return mem[left][right];
    }

    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();
        System.out.println(bb.maxCoins(new int[]{3, 1, 5, 8}));
        ;
    }
}
