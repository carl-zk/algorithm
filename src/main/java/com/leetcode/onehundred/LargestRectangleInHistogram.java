package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * <p>
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * <p>
 * <p>
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * @author carl
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int l = i;
            while (l - 1 > -1 && heights[l - 1] >= heights[i]) l--;
            int r = i;
            while (r + 1 < heights.length && heights[r + 1] >= heights[i]) r++;
            int area = (r - l + 1) * heights[i];
            if (area > ans) {
                ans = area;
            }
        }
        return ans;
    }
}
