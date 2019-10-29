package com.leetcode.threehundred;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    static final TreeNode NIL = new TreeNode(0);
    static final String NIL_STR = "nil";

    public String serialize(TreeNode root) {
        if (root == null) return "";

        List<TreeNode> all = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : cur) {
                all.add(node);
                if (node != NIL) {
                    next.add(node.left == null ? NIL : node.left);
                    next.add(node.right == null ? NIL : node.right);
                }
            }
            cur = next;
        }
        while (!all.isEmpty() && all.get(all.size() - 1) == NIL) {
            all.remove(all.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        all.forEach(x -> sb.append(',').append(x == NIL ? NIL_STR : x.val));
        return sb.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;

        String[] values = data.split(",");
        TreeNode[] nodes = new TreeNode[values.length];
        int p = 0, q = 1;
        nodes[0] = new TreeNode(Integer.parseInt(values[p]));
        while (q < values.length) {
            while (nodes[p] == null) {
                p++;
            }
            nodes[q] = NIL_STR.equals(values[q]) ? null : new TreeNode(Integer.parseInt(values[q]));
            nodes[p].left = nodes[q];
            q++;
            if (q == values.length) return nodes[0];
            nodes[q] = NIL_STR.equals(values[q]) ? null : new TreeNode(Integer.parseInt(values[q]));
            nodes[p].right = nodes[q];
            q++;
            p++;
        }
        return nodes[0];
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
        codec.deserialize(data);
    }
}
