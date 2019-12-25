package com.leetcode.fivehundredfifty;

/**
 * @author carl
 */
public class BeautifulArrangement {
    boolean[] visit;
    int ans = 0;

    public int countArrangement(int N) {
        visit = new boolean[N + 1];
        solve(1, N);
        return ans;
    }

    private void solve(int pos, int N) {
        if (pos > N) {
            ans++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i] && (i % pos == 0 || pos % i == 0)) {
                visit[i] = true;
                solve(pos + 1, N);
                visit[i] = false;
            }
        }
    }
}
