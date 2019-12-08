package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/circular-array-loop/
 * <p>
 * You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.
 * <p>
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 * Example 2:
 * <p>
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
 * Example 3:
 * <p>
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 * <p>
 * <p>
 * Note:
 * <p>
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 1 ≤ nums.length ≤ 5000
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Could you solve it in O(n) time complexity and O(1) extra space complexity?
 *
 * @author carl
 */
public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        if (nums.length < 2) return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i;
            int fast = next(nums, slow);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == next(nums, slow)) break;
                    return true;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int val = nums[i];
            slow = i;
            while (val * nums[slow] > 0) {
                int next = next(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;
        return (nums[i] > 0 ? i + nums[i] : n + (nums[i] % n) + i) % n;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }
}
