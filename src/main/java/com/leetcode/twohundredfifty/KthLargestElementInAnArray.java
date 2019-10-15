package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * <p>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @author carl
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int i = partition(nums, s, e);
            if (i < k) {
                s = i + 1;
            } else if (i > k) {
                e = i - 1;
            } else {
                return nums[k];
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int s, int e) {
        int mid = (s + e) >> 1;
        swap(nums, s, mid);
        int x = nums[s];
        int i = e + 1;
        for (int j = e; j >= s; j--) {
            if (nums[j] > x) {
                i--;
                swap(nums, j, i);
            }
        }
        swap(nums, s, --i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
