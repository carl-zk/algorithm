package com.leetcode.onehundredfifty;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @author carl
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> ans = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null && node.right == null || node.right != null &&
                    node.left != null && visited.contains(node.right) && visited.contains(node.left) ||
                    node.right == null && visited.contains(node.left) || node.left == null && visited.contains(node.right)) {
                ans.add(node.val);
                visited.add(node);
                stack.pop();
            }
            if (node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
            }
            if (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
            }
        }
        return ans;
    }
}
