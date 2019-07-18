package com.data.structure;

import lombok.Data;

/**
 * 二叉树
 *
 * @author carl
 */
public class BinaryTree {

    @Data
    class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = this.rightChild = null;
        }
    }
}
