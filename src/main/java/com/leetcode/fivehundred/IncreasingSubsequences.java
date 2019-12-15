package com.leetcode.fivehundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/increasing-subsequences/
 * <p>
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 *
 * @author carl
 */
public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<String> set = new HashSet<>();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(Integer.toString(nums[i]))) {
                List<Integer> array = new ArrayList<>();
                array.add(nums[i]);
                Node node = new Node(i + 1, array, Integer.toString(nums[i]));
                list.add(node);
                set.add(node.key);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!list.isEmpty()) {
            List<Node> next = new ArrayList<>();
            for (Node node : list) {
                for (int i = node.index; i < nums.length; i++) {
                    if (nums[i] >= node.array.get(node.array.size() - 1)) {
                        String key = node.key + "." + Integer.toString(nums[i]);
                        if (!set.contains(key)) {
                            List<Integer> ls = new ArrayList<>(node.array);
                            ls.add(nums[i]);
                            Node nd = new Node(i + 1, ls, key);
                            next.add(nd);
                            ans.add(ls);
                            set.add(key);
                        }
                    }
                }
            }
            list = next;
        }
        return ans;
    }

    class Node {
        int index;
        List<Integer> array;
        String key;

        public Node(int index, List<Integer> array, String key) {
            this.index = index;
            this.array = array;
            this.key = key;
        }
    }
}
