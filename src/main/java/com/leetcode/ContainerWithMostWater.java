package com.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @author carl
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0, w;

        while (l < r) {
            if (height[l] > height[r]) {
                w = height[r] * (r - l);
                if (w > max) {
                    max = w;
                }
                r--;
            } else {
                w = height[l] * (r - l);
                if (w > max) {
                    max = w;
                }
                l++;
            }
        }

        return max;
    }
}
