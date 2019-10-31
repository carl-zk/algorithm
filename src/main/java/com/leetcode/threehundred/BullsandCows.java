package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 * <p>
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * <p>
 * Example 1:
 * <p>
 * Input: secret = "1807", guess = "7810"
 * <p>
 * Output: "1A3B"
 * <p>
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 * <p>
 * Input: secret = "1123", guess = "0111"
 * <p>
 * Output: "1A1B"
 * <p>
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 * @auther carl
 */
public class BullsandCows {

    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] count = new int[256];
        char[] sec = secret.toCharArray();
        char[] gue = guess.toCharArray();
        for (int i = 0; i < sec.length; i++) {
            if (gue[i] == sec[i]) {
                bulls++;
            } else {
                count[sec[i]]++;
            }
        }
        for (int i = 0; i < gue.length; i++) {
            if (gue[i] != sec[i] && count[gue[i]] > 0) {
                cows++;
                count[gue[i]]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
