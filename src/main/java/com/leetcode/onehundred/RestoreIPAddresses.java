package com.leetcode.onehundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 * @author carl
 */
public class RestoreIPAddresses {
    List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() == 0) return Collections.emptyList();

        ans = new LinkedList<>();
        solve(s.toCharArray(), 0, new ArrayList<>());
        return ans;
    }

    private void solve(char[] nums, int cur, ArrayList<String> temp) {
        if (temp.size() == 4 && cur != nums.length || cur == nums.length && temp.size() != 4) {
            return;
        }
        if (cur == nums.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i)).append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            return;
        }

        temp.add(String.valueOf(nums[cur]));
        solve(nums, cur + 1, temp);
        temp.remove(temp.size() - 1);

        if (cur + 1 < nums.length && (nums[cur] != '0')) {
            temp.add(String.valueOf(new char[]{nums[cur], nums[cur + 1]}));
            solve(nums, cur + 2, temp);
            temp.remove(temp.size() - 1);

        }
        if (cur + 2 < nums.length && (nums[cur] == '1' || nums[cur] == '2'
                && (nums[cur + 1] < '5' || nums[cur + 1] == '5' && nums[cur + 2] < '6'))) {
            temp.add(String.valueOf(new char[]{nums[cur], nums[cur + 1], nums[cur + 2]}));
            solve(nums, cur + 3, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses ria = new RestoreIPAddresses();
        ria.restoreIpAddresses("25525511135");
    }
}
