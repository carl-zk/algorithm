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
        Stack<TreeNode> stack = new Stack<>();
        String flag = LEFT;
        boolean lastIsParenthesis = false;
        for (String s : list) {
            switch (s) {
                case "(":
                    flag = LEFT;
                    lastIsParenthesis = true;
                    break;
                case ")":
                    stack.pop();
                    lastIsParenthesis = false;
                    break;
                case ",":
                    flag = RIGHT;
                    if (!lastIsParenthesis) {
                        stack.pop();
                    }
                    lastIsParenthesis = false;
                    break;
                default:
                    TreeNode e = new TreeNode(Integer.parseInt(s));
                    if (stack.isEmpty()) {
                        root = e;
                    } else {
                        append(flag, stack.top(), e);
                    }
                    stack.push(e);
                    lastIsParenthesis = false;
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
