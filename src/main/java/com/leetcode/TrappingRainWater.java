package com.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * @author carl
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int ans = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();

        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int h = Math.min(height[current], height[stack.peek()]) - height[top];
                int distance = current - stack.peek() - 1;
                ans += h * distance;
            }
            stack.push(current++);
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] hts = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trw.trap(hts));
    }
}
