package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 *Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @auther carl
 */
public class ConvertSortedListToBinarySearchTree {
    ListNode first;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        int len = 0;
        for (ListNode h = head; h != null; h = h.next) {
            len++;
        }
        first = head;
        return solve(1, len);
    }

    private TreeNode solve(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) >> 1;
        TreeNode left = solve(start, mid - 1);
        TreeNode root = new TreeNode(first.val);
        first = first.next;
        root.left = left;
        TreeNode right = solve(mid + 1, end);
        root.right = right;
        return root;
    }
}
