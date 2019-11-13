package com.leetcode.threehundredfifty;

import java.util.*;

/**
 * @auther carl
 */
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (List<String> pair : tickets) {
            PriorityQueue<String> que = map.getOrDefault(pair.get(0), new PriorityQueue<>());
            que.add(pair.get(1));
            map.put(pair.get(0), que);
        }
        int n = tickets.size() + 1;
        solve(ans, map, "JFK", n);
        return ans;
    }

    private void solve(List<String> ans, Map<String, PriorityQueue<String>> map, String start, int n) {
        ans.add(start);
        if (ans.size() == n) return;
        PriorityQueue<String> que = map.get(start);
        if (que == null || que.isEmpty()) {
            ans.remove(ans.size() - 1);
            return;
        }
        PriorityQueue<String> copy = new PriorityQueue<>(que);

        for (String next : copy) {
            que.remove(next);
            solve(ans, map, next, n);
            if (ans.size() == n) return;
            que.add(next);
        }
        ans.remove(ans.size() - 1);
    }
}
