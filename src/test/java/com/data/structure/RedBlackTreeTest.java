package com.data.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author carl
 */
public class RedBlackTreeTest {
    int[] input = {11, 2, 1, 7, 5, 4, 8, 14, 15};
    int stack = 0;

    /**
     * (value=1, black=true)
     * (value=2, black=false)
     * (value=4, black=false)
     * (value=5, black=true)
     * (value=7, black=true)
     * (value=8, black=true)
     * (value=11, black=false)
     * (value=14, black=true)
     * (value=15, black=false)
     */
    @Test
    public void testInsert() {
        RbTreeNode root = null;
        for (int i = 0; i < input.length; i++) {
            root = RedBlackTree.insert(root, input[i]);
        }
        int[] expected = {1, 2, 4, 5, 7, 8, 11, 14, 15};
        int[] result = new int[input.length];
        inOrderPrint(root, result);
        for (int j = 0; j < result.length; j++) {
            assertEquals(expected[j], result[j]);
        }
    }

    @Test
    public void testDelete() {
        RbTreeNode root = null;
        for (int i = 0; i < input.length; i++) {
            root = RedBlackTree.insert(root, input[i]);
        }
        root = RedBlackTree.delete(root, 7);
        int[] res = new int[input.length - 1];
        inOrderPrint(root, res);
    }

    public void inOrderPrint(RbTreeNode root, int[] res) {
        if (root != RedBlackTree.LEAF) {
            inOrderPrint(root.leftChild, res);
            System.out.println(root);
            res[stack++] = root.value;
            inOrderPrint(root.rightChild, res);
        }
    }
}
