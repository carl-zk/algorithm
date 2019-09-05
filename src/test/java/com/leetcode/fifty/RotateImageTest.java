package com.leetcode.fifty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class RotateImageTest {
    RotateImage rotateImage = new RotateImage();

    @Test
    public void test() {
        int[][] expect = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(input);
        assertTrue(() -> {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    if (expect[i][j] != input[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        });
    }
}
