package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * <p>
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 * <p>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * <p>
 * <p>
 * Note:
 * <p>
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 *
 * @auther carl
 */
public class DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        ListNode cur = node, next = cur.next;
        while (next != null) {
            cur.val = next.val;
            if (next.next == null) {
                cur.next = null;
            }
            cur = next;
            next = next.next;
        }
    }
}