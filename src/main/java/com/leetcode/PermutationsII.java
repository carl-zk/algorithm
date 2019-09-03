package com.leetcode;

import java.util.*;

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
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new LinkedList<>();
        visited = new boolean[nums.length];
        int[] tmp = new int[nums.length];
        Arrays.sort(nums);
        perm(nums, 0, tmp, 0);
        return ans;
    }

    private void perm(int[] nums, int i, int[] arr, int j) {
        if (j == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (int k = 0; k < j; k++) {
                list.add(arr[k]);
            }
            ans.add(list);
            return;
        }
        for (int k = i, pre = nums[i]; k < nums.length; k++) {
            if (!visited[k] && (k == i || nums[k] != pre)) {
                visited[k] = true;
                arr[j] = nums[k];
                perm(nums, i + 1, arr, j + 1);
                visited[k] = false;
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
