package com.leetcode.threehundred;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 * @auther carl
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void build(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#').append(',');
            return;
        }
        sb.append(root.val).append(',');
        build(root.left, sb);
        build(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return solve(data.split(","), new int[]{0});
    }

    private TreeNode solve(String[] strs, int[] index) {
        if ("#".equals(strs[index[0]])) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[index[0]++]));
        node.left = solve(strs, index);
        node.right = solve(strs, index);
        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String data = codec.serialize(root);
        System.out.println(data);
        root = codec.deserialize(data);
        System.out.println(1 + '0');
    }
}
