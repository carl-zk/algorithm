package com.data.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class BinarySearchTreeTest {
    final int[] input = {40, 30, 20, 80, 60, 50, 45, 55, 70, 65, 75, 77, 90};

    @Test
    public void testBuildTree() {
        TreeNode root = BinarySearchTree.buildTree(input);
        PrintTree.preOrderTraversal(root);
        PrintTree.inOrderTraversal(root);
    }

    @Test
    public void testAdd() {
        TreeNode root = BinarySearchTree.buildTree(input);
        assertFalse(BinarySearchTree.contains(root, 100));
        root = BinarySearchTree.add(root, 100);
        assertTrue(BinarySearchTree.contains(root, 100));
        PrintTree.inOrderTraversal(root);
    }

    @Test
    public void testRemove() {
        TreeNode root = BinarySearchTree.buildTree(input);
        assertTrue(BinarySearchTree.contains(root, 60));
        root = BinarySearchTree.remove(root, 60);
        assertFalse(BinarySearchTree.contains(root, 60));
        PrintTree.inOrderTraversal(root);
    }
}
