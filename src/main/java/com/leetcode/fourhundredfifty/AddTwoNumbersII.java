package com.leetcode.fourhundredfifty;

import com.leetcode.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 * @author carl
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverse(l1), h2 = reverse(l2);
        ListNode pre = null, cur = h1;
        int carry = 0;
        while (h1 != null && h2 != null) {
            h1.val = h1.val + h2.val + carry;
            carry = h1.val / 10;
            h1.val %= 10;
            h1 = h1.next;
            h2 = h2.next;
            cur.next = pre;
            pre = cur;
            cur = h1;
        }
        pre = h1 == null ? processRemain(pre, h2, carry) : processRemain(pre, h1, carry);
        return pre;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode processRemain(ListNode pre, ListNode h, int carry) {
        ListNode cur = h;
        while (h != null) {
            h.val += carry;
            carry = h.val / 10;
            h.val %= 10;
            h = h.next;
            cur.next = pre;
            pre = cur;
            cur = h;
        }
        if (carry > 0) {
            ListNode node = new ListNode(1);
            node.next = pre;
            pre = node;
        }
        return pre;
    }
}
