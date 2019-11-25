package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/construct-quad-tree/
 *
 * @author carl
 */
public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        Node root = new Node();
        if (grid.length == 0) return root;
        int n = grid.length;
        root = solve(grid, 0, n - 1, 0, n - 1);
        return root;
    }

    private Node solve(int[][] grid, int xs, int xe, int ys, int ye) {
        if (xe == xs) {
            return new Node(grid[xs][ys] == 1, true, null, null, null, null);
        }

        int xm = (xs + xe) / 2, ym = (ys + ye) / 2;
        Node topLeft = solve(grid, xs, xm, ys, ym);
        Node topRight = solve(grid, xs, xm, ym + 1, ye);
        Node bottomLeft = solve(grid, xm + 1, xe, ys, ym);
        Node bottomRight = solve(grid, xm + 1, xe, ym + 1, ye);

        boolean same = canCombine(topLeft, topRight, bottomLeft, bottomRight);
        boolean leaf = isLeaf(topLeft, topRight, bottomLeft, bottomRight);

        return same && leaf ? new Node(topLeft.val, true, null, null, null, null)
                : new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean canCombine(Node tl, Node tr, Node bl, Node br) {
        return (tl.val && tr.val && bl.val && br.val) == (tl.val || tr.val || bl.val || br.val);
    }

    private boolean isLeaf(Node tl, Node tr, Node bl, Node br) {
        return tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf;
    }

    public static void main(String[] args) {
        ConstructQuadTree cq = new ConstructQuadTree();
        cq.construct(new int[][]{{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}});
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}


