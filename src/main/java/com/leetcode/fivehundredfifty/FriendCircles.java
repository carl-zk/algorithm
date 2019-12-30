package com.leetcode.fivehundredfifty;

/**
 * @author carl
 */
public class FriendCircles {
    int ans;

    public int findCircleNum(int[][] M) {
        int n = M.length;
        ans = n;
        int[] par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(par, i, j);
                }
            }
        }
        return ans;
    }

    private void union(int[] par, int i, int j) {
        int pi = lookup(par, i), pj = lookup(par, j);
        if (pi == pj) return;
        ans--;
        if (pi < pj) {
            par[pj] = pi;
        } else {
            par[pi] = pj;
        }
    }

    private int lookup(int[] par, int i) {
        if (par[i] == i) {
            return i;
        } else {
            return par[i] = lookup(par, par[i]);
        }
    }

    public static void main(String[] args) {
        FriendCircles fc = new FriendCircles();
        System.out.println(fc.findCircleNum(new int[][]{{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}}));
    }
}
