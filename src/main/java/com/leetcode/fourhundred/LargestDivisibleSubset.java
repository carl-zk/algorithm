package com.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 * <p>
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * <p>
 * Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 *
 * @author carl
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.stream(nums).sorted().forEach(x -> {
            List<Integer> prefix = new ArrayList<>(ans.stream().filter(l -> x % l.get(l.size() - 1) == 0)
                    .max(Comparator.comparing(List::size)).orElse(new ArrayList<>()));
            prefix.add(x);
            ans.add(prefix);
        });
        return ans.stream().max(Comparator.comparing(List::size)).orElse(Collections.emptyList());
    }
}
