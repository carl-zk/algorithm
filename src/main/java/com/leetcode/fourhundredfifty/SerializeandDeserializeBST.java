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

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(',');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] ss = data.split(",");
        int[] index = {0};
        return deserialize(ss, index, Long.MAX_VALUE);
    }

    private TreeNode deserialize(String[] ss, int[] index, long max) {
        if (index[0] >= ss.length || Integer.valueOf(ss[index[0]]) >= max) return null;
        TreeNode node = new TreeNode(Integer.valueOf(ss[index[0]++]));
        node.left = deserialize(ss, index, node.val);
        node.right = deserialize(ss, index, max);
        return node;
    }
}
