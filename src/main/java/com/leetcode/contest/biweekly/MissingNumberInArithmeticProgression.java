package com.leetcode.contest.biweekly;

/**
 * 5088. Missing Number In Arithmetic Progression
 * <p>
 * In some array arr, the values were in arithmetic progression: the values arr[i+1] - arr[i] are all equal for every 0 <= i < arr.length - 1.
 * <p>
 * Then, a value from arr was removed that was not the first or last value in the array.
 * <p>
 * Return the removed value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [5,7,11,13]
 * Output: 9
 * Explanation: The previous array was [5,7,9,11,13].
 * Example 2:
 * <p>
 * Input: arr = [15,13,12]
 * Output: 14
 * Explanation: The previous array was [15,14,13,12].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= arr.length <= 1000
 * 0 <= arr[i] <= 10^5
 *
 * @author carl
 */
public class MissingNumberInArithmeticProgression {

    public int missingNumber(int[] arr) {
        int deta = arr[1] - arr[0];
        for (int i = 2, k; i < arr.length; i++) {
            k = arr[i] - arr[i - 1];
            if (k > deta) {
                return k > 0 ? arr[i] - deta : arr[0] + k;
            } else if (k < deta) {
                return k > 0 ? arr[0] + k : arr[i] - deta;
            }
        }
        return arr[0];
    }
}
