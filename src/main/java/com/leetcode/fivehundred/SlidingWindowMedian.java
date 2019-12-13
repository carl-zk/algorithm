package com.leetcode.fivehundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sliding-window-median/
 * <p>
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * <p>
 * Note:
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 *
 * @author carl
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            ans[i] = calMedian(Arrays.copyOfRange(nums, i, i + k));
        }
        return ans;
    }

    private double calMedian(int[] a) {
        int start = 0, end = a.length - 1, k = start + (end - start) / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            swap(a, mid, end);
            int j = start;
            for (int i = start; i < end; i++) {
                if (a[i] < a[end]) {
                    swap(a, j++, i);
                }
            }
            swap(a, j, end);
            if (j == k) break;
            else if (j < k) start = j + 1;
            else end = j - 1;
        }
        double first = a[k], sec = first;
        if (a.length % 2 == 0) {
            for (int i = k + 1; i < a.length; i++) {
                a[k + 1] = Math.min(a[k + 1], a[i]);
            }
            sec = a[k + 1];
        }
        return (first + sec) / 2;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        swm.medianSlidingWindow(new int[]{290145159, 681808623, 977764947, 750597385, 971307217}, 5);
    }
}
