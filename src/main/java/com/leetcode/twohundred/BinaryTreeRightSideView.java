package com.leetcode.twohundred;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 *
 * @auther carl
 */
public class BinaryTreeRightSideView {
    List<Integer> ans;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        ans = new LinkedList<>();
        solve(Arrays.asList(root));
        return ans;
    }

    private void solve(List<TreeNode> layer) {
        if (layer.isEmpty()) return;

        ans.add(layer.get(0).val);

        List<TreeNode> next = new ArrayList<>();
        for (TreeNode node : layer) {
            if (node.right != null) {
                next.add(node.right);
            }
            if (node.left != null) {
                next.add(node.left);
            }
        }
        solve(next);
    }
}
