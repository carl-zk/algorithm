package com.leetcode.twohundredfifty;

import java.util.ArrayList;

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
        if (numCourses == 0) return new int[]{};

        ArrayList<Integer> ans = new ArrayList<>();

        int[] count = new int[numCourses];
        for (int[] p : prerequisites) {
            count[p[0]]++;
        }
        boolean[] visit = new boolean[prerequisites.length];
        boolean[] taken = new boolean[numCourses];
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < prerequisites.length; i++) {
                int from = prerequisites[i][1];
                int to = prerequisites[i][0];
                if (!visit[i] && count[from] == 0) {
                    visit[i] = true;
                    count[to]--;
                    if (!taken[from]) {
                        taken[from] = true;
                        ans.add(from);
                    }
                    if (!taken[to] && count[to] == 0) {
                        taken[to] = true;
                        ans.add(to);
                    }
                    changed = true;
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (count[i] > 0) return new int[]{};
            if (!taken[i]) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
