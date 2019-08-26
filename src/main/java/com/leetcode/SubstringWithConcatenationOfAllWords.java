package com.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author carl
 */
public class SubstringWithConcatenationOfAllWords {
    int wl;
    int cl;
    Map<String, Integer> wds;
    Map<String, Integer> used;
    List<Integer> ans;

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return Collections.emptyList();
        }
        wl = words[0].length();
        cl = wl * words.length;
        wds = new HashMap<>(words.length);
        ans = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int cnt = wds.getOrDefault(words[i], 0);
            wds.put(words[i], cnt + 1);
        }

        for (int i = 0; i < wl; i++) {
            handle(s, i);
        }
        return ans;
    }

    private void handle(String s, int start) {
        used = new HashMap<>(wds.size());
        // 滑动窗口左端
        int i = start;
        // 滑动窗口右端
        int j = start;

        while (j <= s.length() - wl) {
            if (i > s.length() - cl) {
                return;
            }
            String wd = s.substring(j, j + wl);
            if (wds.containsKey(wd)) {
                int total = wds.get(wd);
                int cnt = used.getOrDefault(wd, 0);
                if (cnt < total) {
                    // word 没达到上限
                    used.put(wd, cnt + 1);
                    j += wl;
                    if (j - i == cl) {
                        // 窗口内满足条件，i 右移一字，重置 j、used
                        ans.add(i);
                        i += wl;
                        j = i;
                        used.clear();
                    }
                } else {
                    // 窗口内 word 重复，i 右移，重置 j、used
                    int offset = s.substring(i, j).indexOf(wd);
                    i += wl + offset;
                    j = i;
                    used.clear();
                }
            } else {
                // 出现未知 word，j 右移一字，重置 i、used
                j += wl;
                i = j;
                used.clear();
            }
        }
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords sub = new SubstringWithConcatenationOfAllWords();

        //List<Integer> result = sub.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}); // 0, 9
        //List<Integer> result = sub.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
        //List<Integer> result = sub.findSubstring("goodgoodbestword", new String[]{"word", "good", "best", "word"});
        List<Integer> result = sub.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}); // 6, 9, 12
        result.forEach(x -> System.out.println(x));
    }
}
