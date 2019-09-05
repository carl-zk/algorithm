package com.leetcode.fifty;

import static com.leetcode.fifty.MergeTwoSortedLists.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author carl
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        ListNode pre = h;
        ListNode cur = head, jump;

        while (cur != null && cur.next != null) {
            jump = cur.next.next;
            pre.next = cur.next;
            pre.next.next = cur;
            pre = cur;
            cur = jump;
        }
        pre.next = cur;
        return h.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

        ListNode h = swapNodesInPairs.swapPairs(ListNode.buildList(new int[]{1, 2, 3, 4, 5}));
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
