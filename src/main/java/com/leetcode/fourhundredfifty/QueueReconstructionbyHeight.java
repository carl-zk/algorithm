package com.leetcode.fourhundredfifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * <p>
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @author carl
 */
public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        List<int[]> list = new LinkedList<>();

        for (int[] p : people) {
            int i = 0;
            for (int k = 0; i < list.size(); i++) {
                if (k < p[1] && list.get(i)[0] >= p[0]) k++;
                else if (k == p[1] && list.get(i)[0] >= p[0]) break;
            }
            list.add(i, p);
        }

        int[][] ans = new int[people.length][2];
        int i = 0;
        for (int[] p : list) {
            ans[i][0] = p[0];
            ans[i][1] = p[1];
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        QueueReconstructionbyHeight qr = new QueueReconstructionbyHeight();
        qr.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }
}
