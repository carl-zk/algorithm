package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/construct-the-rectangle/
 *
 * @author carl
 */
public class ConstructtheRectangle {

    public int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area);
        while (area % l != 0) l--;
        return new int[]{area / l, l};
    }
}
