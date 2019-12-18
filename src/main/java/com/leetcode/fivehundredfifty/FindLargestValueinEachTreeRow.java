package com.leetcode.fivehundredfifty;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author carl
 */
public class FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int max = Integer.MIN_VALUE;
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : list) {
                max = Math.max(max, node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            ans.add(max);
            list = next;
        }
        return ans;
    }
}
