package com.leetcode.twohundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * <p>
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 * Example 2:
 * <p>
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * @auther carl
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        int sz = 0;
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        Queue<Integer> que = new LinkedList<>();

        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            ArrayList<Integer> list = adjList.getOrDefault(p[1], new ArrayList<>());
            list.add(p[0]);
            adjList.put(p[1], list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int from = que.poll();
            topologicalOrder[sz++] = from;
            for (int to : adjList.getOrDefault(from, new ArrayList<>())) {
                indegree[to]--;
                if (indegree[to] == 0) {
                    que.add(to);
                }
            }
        }

        if (sz == numCourses) return topologicalOrder;

        return new int[0];
    }
}
