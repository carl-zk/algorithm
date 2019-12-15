package com.leetcode.fivehundred;

/**
 * @author carl
 */
public class PredicttheWinner {

    public boolean PredictTheWinner(int[] nums) {
        if ((nums.length & 1) == 0) return true;
        int[] dp = new int[nums.length];
        for (int i = nums.length - 1; i > -1; i--) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[j] = nums[j];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[nums.length - 1] >= 0;
    }

    public static void main(String[] args) {
        PredicttheWinner pw = new PredicttheWinner();
        System.out.println(pw.PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
}
