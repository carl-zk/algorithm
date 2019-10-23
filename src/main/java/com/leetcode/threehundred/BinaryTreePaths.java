package com.leetcode.threehundred;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * @auther carl
 */
public class BinaryTreePaths {
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();
        traversal(root, new ArrayList<>());
        return ans;
    }

    private void traversal(TreeNode root, List<TreeNode> path) {
        if (root == null) return;
        path.add(root);
        traversal(root.left, path);
        traversal(root.right, path);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0).val);
            for (int i = 1; i < path.size(); i++) {
                sb.append("->").append(path.get(i).val);
            }
            ans.add(sb.toString());
        }
        path.remove(path.size() - 1);
    }
}
