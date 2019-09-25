package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/candy/
 * <p>
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 * <p>
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 * @author carl
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int ans = 1;
        int up = 1, down = 0, peak = up;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                ans += up;
            } else if (ratings[i] < ratings[i - 1]) {
                down++;
                ans += down < peak ? down : down + 1;
                up = 1;
            } else {
                ans++;
                up = 1;
                down = 0;
                peak = up;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.candy(new int[]{1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2}));
    }
}
