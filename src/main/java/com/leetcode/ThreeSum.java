package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author carl
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        Set<E> pairs = new HashSet<>(nums.length * nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int idx = Arrays.binarySearch(nums, -(nums[i] + nums[j]));
                if (idx < nums.length && idx > -1 && idx != i && idx != j) {
                    pairs.add(new E(nums[i], nums[j]));
                }
            }
        }

        Iterator<E> iter = pairs.iterator();
        while (iter.hasNext()) {
            ans.add(iter.next().toList());
        }
        return ans;
    }

    static class E {
        public int a;
        public int b;
        public int c;

        public E(int a, int b) {
            this.a = a;
            this.b = b;
            this.c = -(a + b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof E)) return false;
            E e = (E) o;
            int min = Math.min(Math.min(a, b), c);
            int max = Math.max(Math.max(a, b), c);
            int oMin = Math.min(Math.min(e.a, e.b), e.c);
            int oMax = Math.max(Math.max(e.a, e.b), e.c);

            return min == oMin && max == oMax;
        }

        @Override
        public int hashCode() {
            int min = Math.min(Math.min(a, b), c);
            int max = Math.max(Math.max(a, b), c);
            return Objects.hash(min, max);
        }

        public List<Integer> toList() {
            return Arrays.asList(a, b, c);
        }
    }
}
