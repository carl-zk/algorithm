package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @author carl
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode jump = head;
        ListNode current = head;
        ListNode prev = null;
        while (jump != null && jump.next != null) {
            jump = jump.next.next;

            ListNode t = current.next;
            current.next = prev;
            prev = current;
            current = t;
        }

        if (jump != null) {
            current = current.next;
        }

        while (prev != null) {
            if (prev.val != current.val) {
                return false;
            }
            current = current.next;
            prev = prev.next;
        }

        return true;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
