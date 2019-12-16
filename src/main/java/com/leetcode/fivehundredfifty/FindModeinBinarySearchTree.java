package com.leetcode.fivehundredfifty;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * @author carl
 */
public class FindModeinBinarySearchTree {
    List<Integer> ans = new ArrayList<>();
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        traversal(root, new int[]{root.val == 1 ? 0 : 1}, new int[]{0});
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traversal(TreeNode root, int[] pre, int[] count) {
        if (root == null) return;
        traversal(root.left, pre, count);
        if (root.val == pre[0]) count[0]++;
        else count[0] = 1;
        if (count[0] > max) {
            ans = new ArrayList<>();
            ans.add(root.val);
            max = count[0];
        } else if (count[0] == max) {
            ans.add(root.val);
        }
        pre[0] = root.val;
        traversal(root.right, pre, count);
    }
}
