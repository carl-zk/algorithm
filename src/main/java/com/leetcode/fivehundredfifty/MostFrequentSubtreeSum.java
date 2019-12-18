package com.leetcode.fivehundredfifty;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author carl
 */
public class MostFrequentSubtreeSum {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        travel(root);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                ans.add(e.getKey());
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int travel(TreeNode r) {
        if (r == null) return 0;
        int sum = r.val + travel(r.left) + travel(r.right);
        map.compute(sum, (k, v) -> {
            v = v == null ? 1 : v + 1;
            max = Math.max(max, v);
            return v;
        });
        return sum;
    }
}
