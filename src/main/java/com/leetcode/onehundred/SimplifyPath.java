package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/simplify-path/
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 * <p>
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 * <p>
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 * <p>
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 * <p>
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 * <p>
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 *
 * @auther carl
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path.length() == 0) return "/";
        char[] arr = new char[path.length()];
        arr[0] = '/';
        int len = 1;
        char[] chars = path.toCharArray();
        int s = 0;
        while (s < chars.length) {
            if (chars[s] == '.') {
                if (s + 1 < chars.length && chars[s + 1] == '.') {
                    if (s + 1 == chars.length - 1 || chars[s + 2] == '/') {
                        while (len > 0 && arr[len - 1] != '/') len--;
                        if (len > 1 && arr[len - 1] == '/') len--;
                    } else {
                        if (arr[len - 1] != '/') {
                            arr[len++] = '/';
                        }
                        arr[len++] = '.';
                        arr[len++] = '.';
                        s += 2;
                        while (s < chars.length && chars[s] != '/') {
                            arr[len++] = chars[s++];
                        }
                    }
                } else if (s + 1 < chars.length && chars[s + 1] != '/') {
                    if (arr[len - 1] != '/') {
                        arr[len++] = '/';
                    }
                    arr[len++] = '.';
                    s++;
                    while (s < chars.length && chars[s] != '/') {
                        arr[len++] = chars[s++];
                    }
                }
            } else if (chars[s] != '/') {
                if (arr[len - 1] != '/') {
                    arr[len++] = '/';
                }
                while (s < chars.length && chars[s] != '/') {
                    arr[len++] = chars[s++];
                }
            }
            s++;
        }
        return new String(arr, 0, len);
    }
}
