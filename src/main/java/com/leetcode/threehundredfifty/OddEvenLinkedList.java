package com.leetcode.threehundredfifty;

import com.leetcode.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * <p>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 * <p>
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 * @author carl
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = head, pre = head.next, jump = head.next.next;
        while (jump != null) {
            ListNode next = jump.next == null ? null : jump.next.next;
            pre.next = jump.next;
            pre = jump.next;
            jump.next = last.next;
            last.next = jump;
            last = jump;
            jump = next;
        }
        return head;
    }
}
