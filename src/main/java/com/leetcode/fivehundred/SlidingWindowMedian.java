package com.leetcode.fivehundred;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

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
        Comparator<Integer> comparator = (i, j) -> nums[i] == nums[j] ? j - i : Integer.compare(nums[j], nums[i]);
        TreeSet<Integer> left = new TreeSet<>(comparator);
        TreeSet<Integer> right = new TreeSet<>(comparator.reversed());
        Runnable balance = () -> {
            while (left.size() > right.size()) {
                right.add(left.pollFirst());
            }
        };
        Supplier<Double> median = () -> k % 2 == 0 ? ((double) nums[left.first()] + nums[right.first()]) / 2 : (double) nums[right.first()];
        for (int i = 0; i < k; i++) {
            left.add(i);
        }
        balance.run();
        int i = 0;
        ans[i++] = median.get();
        for (int j = k; j < nums.length; j++) {
            if (!left.remove(j - k)) right.remove(j - k);
            right.add(j);
            left.add(right.pollFirst());
            balance.run();
            ans[i++] = median.get();
        }
        return ans;
    }


    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        swm.medianSlidingWindow(new int[]{290145159, 681808623, 977764947, 750597385, 971307217}, 5);
    }
}
