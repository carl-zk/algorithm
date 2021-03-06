package com.leetcode.threehundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 * <p>
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1 :
 * <p>
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * Example 2 :
 * <p>
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 * Note:
 * <p>
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 * @auther carl
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new HashSet<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> next = new ArrayList<>();
            for (int i : leaves) {
                int j = g.get(i).iterator().next();
                g.get(j).remove(i);
                if (g.get(j).size() == 1) next.add(j);
            }
            leaves = next;
        }
        return leaves;
    }
}
