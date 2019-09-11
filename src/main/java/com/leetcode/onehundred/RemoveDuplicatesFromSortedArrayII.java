package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 * @auther carl
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1, j = 1;
        int count = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    j++;
                } else {
                    nums[i++] = nums[j];
                    j++;
                }
            } else {
                nums[i++] = nums[j];
                count = 1;
                j++;
            }
        }
        return i;
    }
}
