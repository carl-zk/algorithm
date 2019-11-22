package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/frog-jump/
 * <p>
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * <p>
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * <p>
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * <p>
 * Note:
 * <p>
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 * <p>
 * [0,1,3,5,6,8,12,17]
 * <p>
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * <p>
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * <p>
 * [0,1,2,3,4,8,9,11]
 * <p>
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 *
 * @author carl
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        if (stones[1] > 1) return false;

        for (int i = 2; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] + i + 2) return false;
        }

        return solve(stones, 0, 1);
    }

    private boolean solve(int[] stones, int index, int jump) {

        if (index == stones.length - 1) {
            return true;
        }

        int reach = stones[index] + jump;

        for (int i = index + 1; i < stones.length; i++) {
            if (stones[i] < reach) continue;

            if (stones[i] > reach) break;

            // swap jump+1 and jump-1 will get TLE.
            if (solve(stones, i, jump + 1) ||
                    solve(stones, i, jump) ||
                    solve(stones, i, jump - 1)) return true;
        }
        return false;
    }
}
