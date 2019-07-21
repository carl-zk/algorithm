package com.data.structure;

/**
 * @author carl
 */
public class TreeNode {
    int value;
    public TreeNode parent;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int value) {
        this.value = value;
        parent = leftChild = rightChild = null;
    }
}
