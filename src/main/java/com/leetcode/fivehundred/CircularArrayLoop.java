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
            nums[i] %= n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == n) continue;
            int slow = i, fast = next(nums, slow, n);
            if (nums[fast] != n && (nums[fast] ^ nums[i]) >= 0) {
                fast = next(nums, fast, n);
            }
            while (slow != fast) {
                if (nums[slow] == n || (nums[slow] ^ nums[i]) < 0) break;
                if (nums[fast] == n || (nums[fast] ^ nums[i]) < 0) break;
                slow = next(nums, slow, n);
                fast = next(nums, fast, n);
                if (nums[fast] == n || (nums[fast] ^ nums[i]) < 0) break;
                fast = next(nums, fast, n);
            }
            if (slow == fast && slow != next(nums, slow, n)) return true;
            int sign = nums[i], next = i;
            while (nums[next] != n && (nums[next] ^ sign) >= 0) {
                int j = next(nums, next, n);
                nums[next] = n;
                next = j;
            }
        }
        return false;
    }

    private int next(int[] nums, int i, int n) {
        return (nums[i] > 0 ? i + nums[i] : n + (nums[i] % n) + i) % n;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }
}
