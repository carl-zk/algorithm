package com.leetcode.twohundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 * <p>
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * @auther carl
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> pre = new HashMap<>();
        for (int[] p : prerequisites) {
            if (pre.get(p[0]) == null) {
                pre.put(p[0], new HashSet<>());
            }
            pre.get(p[0]).add(p[1]);
            Set<Integer> after = new HashSet<>();
            after.add(p[0]);
            if (!fill(pre.get(p[0]), p[1], pre, after)) return false;
        }
        for (int[] p : prerequisites) {
            if (pre.getOrDefault(p[1], new HashSet<>()).contains(p[0])) return false;
        }
        return true;
    }

    private boolean fill(Set<Integer> set, int i, Map<Integer, Set<Integer>> pre, Set<Integer> after) {
        after.add(i);
        if (pre.containsKey(i)) {
            for (Integer j : pre.get(i)) {
                if (!set.contains(j)) {
                    if (after.contains(j)) return false;
                    after.add(j);
                    set.add(j);
                    fill(set, j, pre, after);
                }
            }
        }
        return true;
    }
}
