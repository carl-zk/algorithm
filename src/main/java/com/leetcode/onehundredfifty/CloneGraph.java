package com.leetcode.onehundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/
 * <p>
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * <p>
 * <p>
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * <p>
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.
 *
 * @auther carl
 */
public class CloneGraph {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.get(node) != null) {
            return map.get(node);
        }
        Node copy = new Node();
        copy.val = node.val;
        map.put(node, copy);
        if (node.neighbors != null) {
            copy.neighbors = new ArrayList<>();
            for (Node o : node.neighbors) {
                copy.neighbors.add(cloneGraph(o));
            }
        }
        return copy;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}