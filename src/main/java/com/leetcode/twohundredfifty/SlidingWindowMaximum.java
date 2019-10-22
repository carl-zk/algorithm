package com.leetcode.twohundredfifty;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 *
 * @author carl
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.value - a.value);
        LinkedList<Node> list = new LinkedList<>();
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        Node head, tail;
        for (int i = 0; i < k; i++) {
            Node node = new Node(nums[i]);
            queue.add(node);
            list.add(node);
        }
        int i = 0;
        ans[i++] = queue.peek().value;
        for (int j = k; j < len; j++) {
            queue.remove(list.removeFirst());
            Node node = new Node(nums[j]);
            queue.add(node);
            list.add(node);
            ans[i++] = queue.peek().value;
        }
        return ans;
    }

    class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
