package com.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * <p>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * Example:
 * <p>
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * <p>
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * <p>
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * <p>
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * <p>
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * <p>
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 *
 * @author carl
 */
public class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean notExists = !map.containsKey(val) || map.get(val).size() == 0;
        list.add(val);
        map.compute(val, (k, v) -> v == null ? new HashSet<>() : v).add(list.size() - 1);
        return notExists;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) return false;
        Set<Integer> indexes = map.get(val);
        int index = indexes.iterator().next();
        map.compute(val, (k, v) -> v).remove(index);
        int lastVal = list.get(list.size() - 1);
        list.set(index, lastVal);
        map.compute(lastVal, (k, v) -> {
            v.add(index);
            v.remove(list.size() - 1);
            return v;
        });
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(1);
        rc.remove(1);
        rc.remove(1);
    }
}
