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
        return solve(heights, 0, heights.length - 1);
    }

    private int solve(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        boolean asc = true;
        boolean desc = true;
        int indexMin = start;
        for (int i = start; i <= end; i++) {
            if (i != start && heights[i] > heights[i - 1]) {
                desc = false;
            }
            if (i != start && heights[i] < heights[i - 1]) {
                asc = false;
            }
            if (heights[i] < heights[indexMin]) {
                indexMin = i;
            }
        }
        if (asc) {
            int ans = 0;
            for (int i = start, area; i <= end; i++) {
                area = (end - i + 1) * heights[i];
                if (area > ans) {
                    ans = area;
                }
            }
            return ans;
        }
        if (desc) {
            int ans = 0;
            for (int i = start, area; i <= end; i++) {
                area = (i - start + 1) * heights[i];
                if (area > ans) {
                    ans = area;
                }
            }
            return ans;
        }
        int leftMax = solve(heights, start, indexMin - 1);
        int rightMax = solve(heights, indexMin + 1, end);
        int l = indexMin;
        while (l - 1 > -1 && heights[l - 1] >= heights[indexMin]) l--;
        int r = indexMin;
        while (r + 1 < heights.length && heights[r + 1] >= heights[indexMin]) r++;
        int area = (r - l + 1) * heights[indexMin];
        return Math.max(area, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram large = new LargestRectangleInHistogram();
        System.out.println(large.largestRectangleArea(new int[]{2, 1, 4, 5, 1, 3, 3}));
    }
}
