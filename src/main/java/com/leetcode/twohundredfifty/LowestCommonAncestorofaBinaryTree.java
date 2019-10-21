package com.leetcode.twohundredfifty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 * @author carl
 */
public class LowestCommonAncestorofaBinaryTree {
    Set<TreeNode> first = new HashSet<>();
    int find = 0;
    List<TreeNode> path = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p.val, q.val);
        for (int i = path.size() - 1; i >= 0; i--) {
            if (first.contains(path.get(i))) return path.get(i);
        }
        return root;
    }

    private void search(TreeNode root, int p, int q) {
        if (root == null || find == 2) return;
        path.add(root);
        if (root.val == p || root.val == q) {
            find++;
            if (find == 1) {
                first = new HashSet<>(path);
            } else {
                return;
            }
        }
        search(root.left, p, q);
        if (find == 2) return;
        if (root.left != null) {
            path.remove(path.size() - 1);
        }
        search(root.right, p, q);
        if (find == 2) return;
        if (root.right != null) {
            path.remove(path.size() - 1);
        }
    }
}
