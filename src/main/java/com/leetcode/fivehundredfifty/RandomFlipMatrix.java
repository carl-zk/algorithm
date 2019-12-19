package com.leetcode.fivehundredfifty;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author carl
 */
public class RandomFlipMatrix {
    int total;
    int row, col;
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public RandomFlipMatrix(int n_rows, int n_cols) {
        this.row = n_rows;
        this.col = n_cols;
        this.total = this.row * this.col;
    }

    public int[] flip() {
        if (this.total == 0) return null;
        int r = random.nextInt(this.total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / this.col, x % this.col};
    }

    public void reset() {
        this.total = this.row * this.col;
        map.clear();
    }
}
