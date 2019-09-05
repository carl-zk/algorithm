package com.leetcode.fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @auther carl
 */
public class PermutationsII {
    private List<List<Integer>> ans;
    private boolean[] used;
    private List<Integer> tmp;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        used = new boolean[nums.length];
        tmp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int level) {
        if (level == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        Integer pre = null;
        for (int k = 0; k < nums.length; k++) {
            if (!used[k] && (pre == null || nums[k] != pre.intValue())) {
                used[k] = true;
                tmp.add(nums[k]);
                dfs(nums, level + 1);
                tmp.remove(tmp.size() - 1);
                used[k] = false;
                pre = nums[k];
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII perm = new PermutationsII();
        //3
        System.out.println(perm.permuteUnique(new int[]{1, 1, 2}).size());
        //630
        System.out.println(perm.permuteUnique(new int[]{-1, 2, 0, -1, 1, 0, 1}).size());
        //6
        System.out.println(perm.permuteUnique(new int[]{1, 1, 2, 2}).size());
        //20
        System.out.println(perm.permuteUnique(new int[]{0, 0, 0, 1, 9}).size());
    }
}
