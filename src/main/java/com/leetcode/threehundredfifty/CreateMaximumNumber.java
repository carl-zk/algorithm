package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/create-maximum-number/
 * <p>
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 * <p>
 * Note: You should try to optimize your time and space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * Example 2:
 * <p>
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * Example 3:
 * <p>
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 *
 * @auther carl
 */
public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= nums1.length && i <= k; i++) {
            int[] num = merge(maxOfLengthK(nums1, i), maxOfLengthK(nums2, k - i));
            if (greater(num, 0, ans, 0)) {
                ans = num;
            }
        }
        return ans;
    }

    private int[] maxOfLengthK(int[] nums, int k) {
        int[] ans = new int[k];
        if (k > nums.length) return ans;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (j > 0 && ans[j - 1] < nums[i] && nums.length + j - 1 - i >= k) {
                j--;
            }
            if (j < k) {
                ans[j++] = nums[i];
            }
        }
        return ans;
    }

    private int[] merge(int[] sorted1, int[] sorted2) {
        int[] ans = new int[sorted1.length + sorted2.length];
        int i = 0, j = 0, k = 0;
        while (i < sorted1.length && j < sorted2.length) {
            ans[k++] = greater(sorted1, i, sorted2, j) ? sorted1[i++] : sorted2[j++];
        }
        while (i < sorted1.length) {
            ans[k++] = sorted1[i++];
        }
        while (j < sorted2.length) {
            ans[k++] = sorted2[j++];
        }
        return ans;
    }

    private boolean greater(int[] num1, int index1, int[] num2, int index2) {
        while (index1 < num1.length && index2 < num2.length) {
            if (num1[index1] != num2[index2]) return num1[index1] > num2[index2];
            index1++;
            index2++;
        }
        return index1 < num1.length;
    }

    public static void main(String[] args) {
        CreateMaximumNumber cmn = new CreateMaximumNumber();
        //cmn.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5);
        cmn.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
    }
}
