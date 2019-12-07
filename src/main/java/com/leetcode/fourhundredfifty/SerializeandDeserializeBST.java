package com.leetcode.fourhundredfifty;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 * @author carl
 */
public class SerializeandDeserializeBST {

    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] ss = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(ss[0]));
        for (int i = 1; i < ss.length; i++) {
            insert(root, Integer.valueOf(ss[i]));
        }
        return root;
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(',');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    private void insert(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode p = root;
        while (p != null) {
            if (val < p.val) {
                if (p.left == null) {
                    p.left = node;
                    break;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = node;
                    break;
                }
                p = p.right;
            }
        }
    }
}
