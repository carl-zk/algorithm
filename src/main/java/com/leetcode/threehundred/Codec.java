package com.leetcode.threehundred;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
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
        StringBuilder sb = new StringBuilder();
        all.forEach(x -> sb.append(',').append(x == NIL ? NIL_STR : x.val));
        return sb.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] nodes = data.split(",");
        return buildTree(null, nodes, 0);
    }

    private TreeNode buildTree(TreeNode root, String[] nodes, int p) {
        if (root == NIL || p >= nodes.length || NIL_STR.equals(nodes[p])) return null;
        if (root == null) {
            root = new TreeNode(Integer.parseInt(nodes[p]));
        }
        root.left = buildTree(root.left, nodes, 2 * p + 1);
        root.right = buildTree(root.right, nodes, 2 * p + 2);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(codec.serialize(root));
    }
}
