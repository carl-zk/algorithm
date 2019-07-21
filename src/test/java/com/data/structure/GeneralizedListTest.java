package com.data.structure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author carl
 */
public class GeneralizedListTest {
    List<String> list1 = Arrays.asList("100", "(", "50", "(", ",", "60", ")", ",", "500", "(", "300", ",", "800", "(",
            "600", ")", ")", ")");
    List<String> list2 = Arrays.asList("40", "(", "30", "(", "20", ")", ",", "80", "(", "60", "(", "50", "(", "45",
            ",", "55", ")", ",", "70", "(", "65", ",", "75", "(", "77", ")", ")", ")", ",", "90", ")", ")");

    @Test
    public void test() {
        TreeNode root = GeneralizedList.buildTree(list1);
        PrintTree.inOrderTraversal(root);
    }
}



