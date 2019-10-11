package com.leetcode.twohundredfifty;

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
        int[] count = new int[numCourses + 1];
        for (int[] p : prerequisites) {
            count[p[0]]++;
        }
        boolean[] visited = new boolean[prerequisites.length];
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i] && count[prerequisites[i][1]] == 0) {
                    visited[i] = true;
                    changed = true;
                    count[prerequisites[i][0]]--;
                }
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) return false;
        }
        return true;
    }
}
