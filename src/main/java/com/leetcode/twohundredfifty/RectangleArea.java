package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/rectangle-area/
 * <p>
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * Rectangle Area
 * <p>
 * Example:
 * <p>
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * Note:
 * <p>
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * @auther carl
 */
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        int down = Math.max(B, F);
        int up = Math.max(Math.min(D, H), down);
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (up - down);
    }
}
