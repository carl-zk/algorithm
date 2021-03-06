package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * <p>
 * Example:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * <p>
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 * @auther carl
 */
public class NumArray {
/*    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n << 1];
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        for (int i = n, j = 0; j < n; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = n - 1; i > -1; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int i, int val) {
        i += n;
        tree[i] = val;
        int p = i >> 1;

        while (p > 0) {
            tree[p] = tree[2 * p] + tree[2 * p + 1];
            p >>= 1;
        }
    }

    public int sumRange(int i, int j) {
        int l = i + n;
        int r = j + n;
        int sum = 0;

        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }*/

    int[] nums;
    int[] BITree;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        BITree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    private void init(int i, int diff) {
        i++;
        while (i <= n) {
            BITree[i] += diff;
            i += (i & -i);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    private int getSum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += BITree[i];
            i -= (i & -i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = 2;
        System.out.println(i - (i & (-i)));
    }
}
