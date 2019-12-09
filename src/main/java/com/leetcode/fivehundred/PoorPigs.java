package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/poor-pigs/
 * <p>
 * There are 1000 buckets, one and only one of them is poisonous, while the rest are filled with water. They all look identical. If a pig drinks the poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket is poisonous within one hour?
 * <p>
 * Answer this question, and write an algorithm for the general case.
 * <p>
 * <p>
 * <p>
 * General case:
 * <p>
 * If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the poisonous bucket within p minutes? There is exactly one bucket with poison.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * A pig can be allowed to drink simultaneously on as many buckets as one would like, and the feeding takes no time.
 * After a pig has instantly finished drinking buckets, there has to be a cool down time of m minutes. During this time, only observation is allowed and no feedings at all.
 * Any given bucket can be sampled an infinite number of times (by an unlimited number of pigs).
 *
 * @author carl
 */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) return 0;
        int pigs = 1, round = minutesToTest / minutesToDie + 1;
        for (int r = 1; r * round < buckets; r *= round, pigs++) ;
        return pigs;
    }
}
