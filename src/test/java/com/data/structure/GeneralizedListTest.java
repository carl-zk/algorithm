package com.data.structure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author carl
 */
public class GeneralizedListTest {
    static List<String> list1 = Arrays.asList("100", "(", "50", "(", ",", "60", ")", ",", "500", "(", "300", ",",
            "800", "(", "600", ")", ")", ")");
    static List<String> list2 = Arrays.asList("40", "(", "30", "(", "20", ")", ",", "80", "(", "60", "(", "50",
            "(", "45", ",", "55", ")", ",", "70", "(", "65", ",", "75", "(", ",", "77", ")", ")", ")", ",", "90",
            ")", ")");

    @ParameterizedTest
    @MethodSource("testBuildTreeSource")
    public void testBuildTree(List<String> args) {
        TreeNode root = GeneralizedList.buildTree(args);
        PrintTree.inOrderTraversal(root);
    }

    static Stream<List<String>> testBuildTreeSource() {
        return Stream.of(list1, list2);
    }
}



