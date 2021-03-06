package com.leetcode.fourhundred;

import com.leetcode.ListNode;

import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 * <p>
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * <p>
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * <p>
 * Example:
 * <p>
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 *
 * @author carl
 */
public class Solution1 {
    ListNode head;
    Random random;

    public Solution1(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /**
     * Reservoir Sample
     */
    public int getRandom() {
        return selectKItems(head);
    }

    private int selectKItems(ListNode cur) {
        int i, k = 1;
        int[] reservoir = new int[k];
        for (i = 0; i < k; i++, cur = cur.next) {
            reservoir[i] = cur.val;
        }

        for (; cur != null; i++, cur = cur.next) {
            int j = random.nextInt(i + 1);

            if (j < k) {
                reservoir[j] = cur.val;
            }
        }

        return reservoir[0];
    }
}
