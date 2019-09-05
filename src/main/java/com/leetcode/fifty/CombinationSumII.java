package com.leetcode.fifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author carl
 */
public class CombinationSumII {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] stack = new int[candidates.length];
        solve(candidates, 0, target, stack, 0);
        return ans;
    }

    private void solve(int[] cans, int i, int target, int[] stack, int j) {
        if (target == 0) {
            List<Integer> list = new LinkedList<>();
            for (int k = 0; k < j; k++) {
                list.add(stack[k]);
            }
            ans.add(list);
            return;
        }
        if (i == cans.length || cans[i] > target) return;
        stack[j] = cans[i];
        solve(cans, i + 1, target - cans[i], stack, j + 1);
        while (i + 1 < cans.length && cans[i + 1] == cans[i]) i++;
        solve(cans, i + 1, target, stack, j);
    }
}
