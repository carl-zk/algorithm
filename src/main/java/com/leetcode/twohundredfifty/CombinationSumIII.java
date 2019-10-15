package com.leetcode.twohundredfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * <p>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author carl
 */
public class CombinationSumIII {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        solve(1, 9, k, n, new ArrayList<>());
        return ans;
    }

    private void solve(int start, int end, int num, int target, List<Integer> temp) {
        if (num == 0 && target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < start || num == 0) return;
        for (int i = start; i <= end && i <= target; i++) {
            temp.add(i);
            solve(i + 1, end, num - 1, target - i, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
