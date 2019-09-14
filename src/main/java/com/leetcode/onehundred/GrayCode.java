package com.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 * <p>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 * <p>
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 *
 * @author carl
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(0);
            return ans;
        }
        ArrayList<Integer> pre = (ArrayList<Integer>) grayCode(n - 1);
        ans.addAll(pre);
        for (int i = pre.size() - 1, t = (int) Math.pow(2, n - 1); i > -1; i--) {
            ans.add(pre.get(i) + t);
        }
        return ans;
    }
}
