package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 *
 * @author carl
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int e = m + n - 1;
        int e1 = m - 1, e2 = n - 1;
        while (e2 > -1 && e1 > -1) {
            if (nums1[e1] > nums2[e2]) {
                nums1[e--] = nums1[e1--];
            } else {
                nums1[e--] = nums2[e2--];
            }
        }
        while (e2 > -1) {
            nums1[e--] = nums2[e2--];
        }
    }
}
