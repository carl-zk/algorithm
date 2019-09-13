package com.leetcode.onehundred;

/**
 * @author carl
 */
public class LargestRectangleInHistogram2 {

    public int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length + 1];
        int len = 0;
        int ans = 0;

        for (int i = 0; i <= heights.length; i++) {
            while (len != 0 && (i == heights.length || heights[stack[len - 1]] > heights[i])) {
                int area = len == 1 ? heights[stack[len - 1]] * i : (i - stack[len - 2] - 1) * heights[stack[len - 1]];
                if (area > ans) {
                    ans = area;
                }
                len--;
            }
            stack[len++] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram2 large = new LargestRectangleInHistogram2();
        System.out.println(large.largestRectangleArea(new int[]{2, 1, 3, 4, 2, 3, 1}));
    }
}
