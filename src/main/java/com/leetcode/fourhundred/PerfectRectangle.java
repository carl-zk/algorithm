package com.leetcode.fourhundred;

/**
 * @author carl
 */
public class PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {
        Point leftBottom = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point rightTop = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Point rightBottom = new Point(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Point leftTop = new Point(Integer.MAX_VALUE, Integer.MIN_VALUE);
        int bottom = Integer.MAX_VALUE, left = Integer.MAX_VALUE, top = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        int area = 0;

        for (int[] p : rectangles) {
            if (p[0] <= leftBottom.x && p[1] <= leftBottom.y) {
                leftBottom.x = p[0];
                leftBottom.y = p[1];
            }
            if (p[2] >= rightTop.x && p[3] >= rightTop.y) {
                rightTop.x = p[2];
                rightTop.y = p[3];
            }
            if (p[3] >= rightBottom.x && p[1] <= rightBottom.y) {
                rightBottom.x = p[3];
                rightBottom.y = p[1];
            }
            if (p[0] <= leftTop.x && p[3] >= leftTop.y) {
                leftTop.x = p[0];
                leftTop.y = p[3];
            }
            left = Math.min(left, p[0]);
            bottom = Math.min(bottom, p[1]);
            right = Math.max(right, p[2]);
            top = Math.max(top, p[3]);
            area += calcArea(p[0], p[1], p[2], p[3]);
        }
        if (left < leftBottom.x || bottom < leftBottom.y || right > rightTop.x || top > rightTop.y) return false;
        return area == calcArea(left, bottom, right, top) && area == Math.abs((rightBottom.x - leftTop.x) * (rightBottom.y - leftTop.y));
    }

    private int calcArea(int x1, int y1, int x2, int y2) {
        return (y2 - y1) * (x2 - x1);
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
