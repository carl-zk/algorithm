package com.leetcode.threehundredfifty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author carl
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>(k);
        Map<Integer, Node> map = new HashMap<>(nums.length);
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(a -> a.count));

        for (int i = 0; i < nums.length; i++) {
            Node node = map.get(nums[i]);
            if (node == null) {
                node = new Node(nums[i]);
            }
            node.count++;
            map.put(nums[i], node);
        }

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            que.add(entry.getValue());
            if (que.size() > k) que.poll();
        }
        while (!que.isEmpty()) {
            ans.add(que.poll().num);
        }
        return ans;
    }

    class Node {
        int num;
        int count;

        public Node(int num) {
            this.num = num;
            this.count = 0;
        }
    }
}
