package com.data.structure;

import java.util.List;

/**
 * 广义表
 * 主要用于构建和表示二叉树
 *
 * @author carl
 */
public class GeneralizedList {
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public static TreeNode buildTree(List<String> list) {
        TreeNode root = null;
        TreeNode p = null;
        Stack<TreeNode> stack = new Stack<>();
        String flag = LEFT;
        for (String s : list) {
            switch (s) {
                case "(":
                    flag = LEFT;
                    stack.push(p);
                    break;
                case ")":
                    stack.pop();
                    break;
                case ",":
                    flag = RIGHT;
                    break;
                default:
                    p = new TreeNode(Integer.parseInt(s));
                    if (stack.isEmpty()) {
                        root = p;
                    } else {
                        append(flag, stack.top(), p);
                    }
            }
        }
        return root;
    }

    private static void append(String flag, TreeNode p, TreeNode q) {
        if (LEFT.equals(flag)) {
            p.leftChild = q;
        } else {
            p.rightChild = q;
        }
        q.parent = p;
    }

    public static String printTree(TreeNode root) {
        return null;
    }
}
