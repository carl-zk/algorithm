package com.leetcode;

/**
 * @author carl
 */
public class JumpGameII {
    boolean[] visited;
    int[] dist;
    int ans;

    public int jump(int[] nums) {
        visited = new boolean[nums.length];
        dist = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        ans = Integer.MAX_VALUE;
        solve(nums, 0, 0);
        return ans;
    }

    private void solve(int[] nums, int i, int step) {
        /*if (step >= dist[i] || step >= ans) {
            return;
        }*/
        dist[i] = Math.min(dist[i], step);
        if (nums[i] + i + 1 >= nums.length) {
            ans = Math.min(ans, i == nums.length - 1 ? dist[i] : dist[i] + 1);
            return;
        }

        for (int j = i + 1, k = 0; k < nums[i] && j + k < nums.length; k++) {
            if (step + 1 < dist[j + k] && step + 1 < ans) {
                solve(nums, j + k, step + 1);
            }
        }
    }

    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        System.out.println(jg.jump(new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5}));
        System.out.println(jg.jump(new int[]{2, 1, 4}));
        System.out.println(jg.jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));
    }
}
