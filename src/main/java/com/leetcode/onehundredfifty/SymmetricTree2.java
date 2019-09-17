package com.leetcode.onehundredfifty;

import java.util.LinkedList;
import java.util.List;

/**
 * @auther carl
 */
public class SymmetricTree2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        List<TreeNode> left = new LinkedList<>();
        left.add(root);
        List<TreeNode> right = new LinkedList<>();
        right.add(root);

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.remove(0);
            TreeNode r = right.remove(0);
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
            left.add(l.left);
            left.add(l.right);
            right.add(r.right);
            right.add(r.left);
        }
        return left.isEmpty() && right.isEmpty();
    }
}
