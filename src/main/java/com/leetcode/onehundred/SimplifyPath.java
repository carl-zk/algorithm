package com.leetcode.onehundred;

import java.util.Stack;

/**
 * @auther carl
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path.length() == 0) return "/";
        char[] arr = new char[path.length()];
        arr[0] = '/';
        int lastSlash = 0;
        int len = 1;
        char[] chars = path.toCharArray();
        int s = 0;
        while (s < chars.length) {
            if (chars[s] == '/') {
                continue;
            }
            if (chars[s] == '.') {
                if (s + 1 < chars.length && chars[s + 1] == '.') {

                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (s < chars.length && (chars[s] != '/' && chars[s] != '.')) {
                    sb.append(chars[s]);
                    s++;
                }
                s--;

            }
            s++;
        }

        return new String(arr, 0, len);
    }
}
