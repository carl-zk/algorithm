package com.leetcode.threehundredfifty;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * <p>
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * @auther carl
 */
public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> {
            if (b[0] == a[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        List<Integer> ans = new ArrayList<>(nums.length);
        List<Integer> remains = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ans.add(0);
            que.add(new int[]{nums[i], i});
            remains.add(i);
        }

        while (!que.isEmpty()) {
            int[] peek = que.poll();
            ans.set(peek[1], binaryCount(remains, 0, remains.size() - 1, peek[1]));
        }
        return ans;
    }

    private int binaryCount(List<Integer> remains, int start, int end, int key) {
        int index = remains.size() - 1;
        while (start <= end) {
            index = (start + end) >> 1;
            if (remains.get(index) == key) {
                break;
            } else if (remains.get(index) < key) {
                start = index + 1;
            } else end = index - 1;
        }
        remains.remove(index);
        return remains.size() - index;
    }
}
