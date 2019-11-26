package com.leetcode.fourhundredfifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author carl
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        List<Node> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            List<Integer> values = new LinkedList<>();
            List<Node> next = new LinkedList<>();

            for (Node node : que) {
                values.add(node.val);
                next.addAll(node.children);
            }

            ans.add(values);
            que = next;
        }
        return ans;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
