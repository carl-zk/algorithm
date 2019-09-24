package com.leetcode.onehundredfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther carl
 */
public class PalindromePartitioning {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            path.add(String.valueOf(s.charAt(i)));
        }
        ans.add(new ArrayList<>(path));
        for (int i = 0; i < path.size() - 1; i++) {
            if (path.get(i).equals(path.get(i + 1))) {
                int k = 0;
                while (i - k > -1 && i + k + 1 < path.size() && path.get(i - k).equals(path.get(i + k + 1))) {
                    solve(new ArrayList<>(path), i - k, i + k + 1);
                    k++;
                }
            }
            if (i + 2 < path.size() && path.get(i).equals(path.get(i + 2))) {
                int k = 0;
                while (i - k > -1 && i + k + 2 < path.size() && path.get(i).equals(path.get(i + k + 2))) {
                    solve(new ArrayList<>(path), i - k, i + k + 2);
                    k++;
                }
            }
        }
        return ans;
    }

    private void solve(List<String> path, int h, int t) {
        StringBuilder sb = new StringBuilder();
        for (int i = h; i <= t; i++) {
            sb.append(path.get(h));
            path.remove(h);
        }
        path.add(h, sb.toString());
        ans.add(path);

        for (int i = h + 1; i < path.size() - 1; i++) {
            if (path.get(i).equals(path.get(i + 1))) {
                int k = 0;
                while (i - k > -1 && i + k + 1 < path.size()&& path.get(i - k).equals(path.get(i + k + 1))) {
                    solve(new ArrayList<>(path), i - k, i + k + 1);
                    k++;
                }
            }
            if (i + 2 < path.size() && path.get(i).equals(path.get(i + 2))) {
                int k = 0;
                while (i - k > -1 && i + k + 2 < path.size()&& path.get(i - k).equals(path.get(i + k + 2))) {
                    solve(new ArrayList<>(path), i - k, i + k + 2);
                    k++;
                }
            }
        }
    }
}
