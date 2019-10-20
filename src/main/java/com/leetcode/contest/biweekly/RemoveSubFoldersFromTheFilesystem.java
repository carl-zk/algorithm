package com.leetcode.contest.biweekly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 5231. Remove Sub-Folders from the Filesystem
 * <p>
 * Given a list of folders, remove all sub-folders in those folders and return in any order the folders after removing.
 * <p>
 * If a folder[i] is located within another folder[j], it is called a sub-folder of it.
 * <p>
 * The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 * Example 2:
 * <p>
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are subfolders of "/a".
 * Example 3:
 * <p>
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] contains only lowercase letters and '/'
 * folder[i] always starts with character '/'
 * Each folder name is unique.
 *
 * @author carl
 */
public class RemoveSubFoldersFromTheFilesystem {

    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new LinkedList<>();
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        for (String f : folder) {
            boolean sub = false;
            for (String p : ans) {
                if (f.startsWith(p) && (p.length() == f.length() || f.charAt(p.length()) == '/')) {
                    sub = true;
                    break;
                }
            }
            if (!sub) {
                ans.add(f);
            }
        }
        return ans;
    }
}
