package com.data.structure;

/**
 * 二叉搜索树
 * 左孩子 < parent
 * 右孩子 >= parent
 *
 * @author carl
 */
public class BinarySearchTree {

    private BinarySearchTree() {
    }

    public static TreeNode buildTree(int[] a) {
        TreeNode root = null;
        for (int i = 0; i < a.length; i++) {
            root = add(root, a[i]);
        }
        return root;
    }

    public static TreeNode add(TreeNode root, int e) {
        TreeNode node = new TreeNode(e);
        TreeNode y = null;
        TreeNode x = root;
        while (x != null) {
            y = x;
            if (node.value < x.value) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
        if (y == null) {
            return node;
        }
        if (node.value < y.value) {
            y.leftChild = node;
        } else {
            y.rightChild = node;
        }
        node.parent = y;
        return root;
    }

    public static TreeNode remove(TreeNode root, int e) {
        TreeNode x = search(root, e);
        if (x == null) {
            return root;
        }
        if (x.leftChild == null) {
            return transplant(root, x, x.rightChild);
        }
        if (x.rightChild == null) {
            return transplant(root, x, x.leftChild);
        }
        TreeNode successor = getSuccessor(x);
        if (successor.parent != x) {
            root = transplant(root, successor, successor.rightChild);
            if (successor.rightChild != null) {
                successor.rightChild.parent = successor.parent;
            }
            successor.rightChild = x.rightChild;
        }
        root = transplant(root, x, successor);
        successor.leftChild = x.leftChild;
        successor.leftChild.parent = successor;
        return root;
    }

    public static boolean contains(final TreeNode root, int e) {
        return search(root, e) != null;
    }

    private static TreeNode search(final TreeNode root, int e) {
        TreeNode p = root;
        while (p != null) {
            if (p.value == e) {
                return p;
            }
            p = e < p.value ? p.leftChild : p.rightChild;
        }
        return null;
    }

    private static TreeNode transplant(TreeNode root, final TreeNode u, final TreeNode v) {
        if (u == null || u.parent == null) {
            return v;
        }
        TreeNode parent = u.parent;
        if (parent.leftChild == u) {
            parent.leftChild = v;
        } else {
            parent.rightChild = v;
        }
        if (v != null) {
            v.parent = parent;
        }
        return root;
    }

    private static TreeNode getSuccessor(final TreeNode x) {
        if (x.rightChild != null) {
            return getMinimum(x.rightChild);
        }
        TreeNode y = x.parent;
        TreeNode z = x;
        while (y != null && y.rightChild == z) {
            z = y;
            y = y.parent;
        }
        return y;
    }

    private static TreeNode getMinimum(final TreeNode tree) {
        TreeNode x = tree;
        if (x.leftChild != null) {
            x = x.leftChild;
        }
        return x;
    }

    private static TreeNode getMaximum(final TreeNode tree) {
        TreeNode x = tree;
        if (x.rightChild != null) {
            x = x.rightChild;
        }
        return x;
    }
}
