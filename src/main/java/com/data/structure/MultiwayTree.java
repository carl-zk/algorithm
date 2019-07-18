package com.data.structure;

import lombok.Data;

/**
 * 分枝无限制的有根树
 *
 * @author carl
 */
public class MultiwayTree {


    @Data
    class Node {
        int value;
        Node leftChild;
        Node rightSibling;

        public Node(int value) {
            this.value = value;
            this.leftChild = this.rightSibling = null;
        }
    }
}
