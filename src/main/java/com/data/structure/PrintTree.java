package com.data.structure;

/**
 * @author carl
 */
public class PrintTree {

    /**
     * 先序遍历
     *
     * @param root
     */
    public static void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            preOrderTraversal(root.leftChild);
            preOrderTraversal(root.rightChild);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.leftChild);
            System.out.println(root.value);
            inOrderTraversal(root.rightChild);
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.leftChild);
            postOrderTraversal(root.rightChild);
            System.out.println(root.value);
        }
    }
}
