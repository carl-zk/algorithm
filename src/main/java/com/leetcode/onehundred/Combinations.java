package com.leetcode.onehundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @auther carl
 */
public class Combinations {
    List<List<Integer>> ans;
    int[] temp;
    int N, K;

    public List<List<Integer>> combine(int n, int k) {
        ans = new LinkedList<>();
        temp = new int[k];
        N = n;
        K = k;
        solve(1, 0);
        return ans;
    }

    private void solve(int start, int j) {
        if (j == K) {
            ArrayList<Integer> list = new ArrayList<>(K);
            for (int i = 0; i < K; i++) {
                list.add(temp[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = start; i <= N; i++) {
            temp[j] = i;
            solve(i + 1, j + 1);
        }
    }
}
