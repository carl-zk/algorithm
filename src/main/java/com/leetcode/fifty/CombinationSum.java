package com.leetcode.fifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @author carl
 */
public class CombinationSum {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] holder = new int[1000];
        Arrays.sort(candidates);
        process(candidates, 0, target, holder, 0);
        return ans;
    }

    private void process(int[] cans, int i, int target, int[] stack, int j) {
        if (target == 0) {
            List<Integer> list = new LinkedList<>();
            for (int k = 0; k < j; k++) {
                list.add(stack[k]);
            }
            ans.add(list);
        }
        if (i == cans.length || cans[i] > target) return;
        stack[j] = cans[i];
        process(cans, i, target - cans[i], stack, j + 1);
        process(cans, i + 1, target, stack, j);
    }
}
