package com.data.structure;

import lombok.Getter;
import lombok.Setter;

/**
 * @author carl
 */
@Getter
@Setter
public class RbTreeNode {
    int value;
    public RbTreeNode parent;
    public RbTreeNode leftChild;
    public RbTreeNode rightChild;
    public boolean black;

    public RbTreeNode(int value) {
        this.value = value;
        parent = leftChild = rightChild = null;
        black = true;
    }
}
