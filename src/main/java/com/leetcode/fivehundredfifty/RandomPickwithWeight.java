package com.leetcode.fivehundredfifty;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author carl
 */
public class RandomPickwithWeight {
    TreeMap<Integer, Integer> treeMap;
    Random random;
    int totalWeight;

    public RandomPickwithWeight(int[] w) {
        random = new Random();
        treeMap = new TreeMap<>();
        totalWeight = 0;
        for (int i = 0, pos = 0; i < w.length; i++) {
            totalWeight += w[i];
            treeMap.put(pos, i);
            pos = totalWeight;
        }
    }

    public int pickIndex() {
        return treeMap.floorEntry(random.nextInt(totalWeight)).getValue();
    }
}
