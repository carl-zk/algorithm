package com.data.structure;

/**
 * 红黑树
 * 1. 每个节点或为红色，或为黑色;
 * 2. 根节点为黑色;
 * 3. 每个叶节点为黑色;
 * 4. 如果节点为红色，它两个孩子都为黑色;
 * 5. 对于每个节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点;
 *
 * @author carl
 */
public class RedBlackTree {
    /**
     * root的父节点指向 LEAF；
     * 所有指向null的指针均指向 LEAF;
     */
    public static final RbTreeNode LEAF = new RbTreeNode(0);

    private RedBlackTree() {
    }

    public static RbTreeNode insert(RbTreeNode root, int value) {
        RbTreeNode e = new RbTreeNode(value);
        RbTreeNode y = LEAF;
        RbTreeNode x = root;
        while (x != null && x != LEAF) {
            y = x;
            if (value < x.value) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
        e.parent = y;
        if (y == LEAF) {
            root = e;
        } else if (value < y.value) {
            y.leftChild = e;
        } else {
            y.rightChild = e;
        }
        e.leftChild = e.rightChild = LEAF;
        e.black = false;
        root = fixupInsert(root, e);
        return root;
    }

    private static RbTreeNode fixupInsert(RbTreeNode root, RbTreeNode z) {
        while (!z.parent.isBlack()) {
            if (z.parent == z.parent.parent.leftChild) {
                RbTreeNode y = z.parent.parent.rightChild;
                if (!y.isBlack()) {
                    z.parent.black = true;
                    y.black = true;
                    z.parent.parent.black = false;
                    z = z.parent.parent;
                } else if (z == z.parent.rightChild) {
                    z = z.parent;
                    root = leftRotate(root, z);
                    z.parent.black = true;
                    z.parent.parent.black = false;
                    root = rightRotate(root, z.parent.parent);
                } else {
                    z.parent.black = true;
                    z.parent.parent.black = false;
                    root = rightRotate(root, z.parent.parent);
                }
            } else {
                RbTreeNode y = z.parent.parent.leftChild;
                if (!y.isBlack()) {
                    z.parent.black = true;
                    y.black = true;
                    z.parent.parent.black = false;
                    z = z.parent.parent;
                } else if (z == z.parent.leftChild) {
                    z = z.parent;
                    root = rightRotate(root, z);
                    z.parent.black = true;
                    z.parent.parent.black = false;
                    root = leftRotate(root, z.parent.parent);
                } else {
                    z.parent.black = true;
                    z.parent.parent.black = false;
                    root = leftRotate(root, z.parent.parent);
                }
            }
        }
        root.black = true;
        return root;
    }

    private static RbTreeNode leftRotate(RbTreeNode root, RbTreeNode x) {
        RbTreeNode y = x.rightChild;
        if (y == LEAF) {
            return root;
        }
        x.rightChild = y.leftChild;
        if (y.leftChild != LEAF) {
            y.leftChild.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == LEAF) {
            root = y;
        } else if (x.parent.leftChild == x) {
            x.parent.leftChild = y;
        } else {
            x.parent.rightChild = y;
        }
        y.leftChild = x;
        x.parent = y;
        return root;
    }

    private static RbTreeNode rightRotate(RbTreeNode root, RbTreeNode y) {
        RbTreeNode x = y.leftChild;
        if (x == LEAF) {
            return root;
        }
        y.leftChild = x.rightChild;
        if (x.rightChild != LEAF) {
            x.rightChild.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == LEAF) {
            root = x;
        } else if (y.parent.rightChild == y) {
            y.parent.rightChild = x;
        } else {
            y.parent.leftChild = x;
        }
        x.rightChild = y;
        y.parent = x;
        return root;
    }

    public static RbTreeNode search(final RbTreeNode root, int value) {
        RbTreeNode x = root;
        while (x != RedBlackTree.LEAF && x.value != value) {
            x = value < x.value ? x.leftChild : x.rightChild;
        }
        return x == RedBlackTree.LEAF ? null : x;
    }

    public static RbTreeNode remove(RbTreeNode root, int value) {
        RbTreeNode z = search(root, value);
        if (z == null) {
            return root;
        }
        RbTreeNode y = z;
        boolean yIsBlack = y.black;
        if (z.leftChild == RedBlackTree.LEAF) {
            RbTreeNode x = z.rightChild;
            root = transplant(root, z, z.rightChild);
        } else if (z.rightChild == RedBlackTree.LEAF) {
            RbTreeNode x = z.leftChild;
            root = transplant(root, z, z.leftChild);
        } else {
            y = successor(root, z);
            // TODO
        }
        return root;
    }

    private static RbTreeNode transplant(RbTreeNode root, RbTreeNode u, RbTreeNode v) {
        if (u.parent == RedBlackTree.LEAF) {
            root = v;
        } else if (u.parent.leftChild == u) {
            u.parent.leftChild = v;
        } else {
            u.parent.rightChild = v;
        }
        v.parent = u.parent;
        return root;
    }

    private static RbTreeNode successor(final RbTreeNode root, RbTreeNode x) {
        if (x.rightChild != RedBlackTree.LEAF) {
            return minimum(x.rightChild);
        }
        RbTreeNode y = RedBlackTree.LEAF;
        while (x.parent != RedBlackTree.LEAF && x.parent.rightChild == x) {
            y = x.parent;
            x = x.parent;
        }
        return y != RedBlackTree.LEAF ? y : null;
    }

    public static RbTreeNode minimum(final RbTreeNode root) {
        if (root == null || root == RedBlackTree.LEAF) {
            return null;
        }
        RbTreeNode x = root;
        while (x.leftChild != RedBlackTree.LEAF) {
            x = x.leftChild;
        }
        return x;
    }
}
