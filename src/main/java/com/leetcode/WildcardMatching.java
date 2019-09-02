package com.leetcode;

/**
 * @author carl
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if ("".equals(s) && "".equals(p)) return true;
        if ("".equals(p)) return false;

        boolean firstMath = p.charAt(0) == '*'
                || (s.length() != 0 && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)));
        if (p.charAt(0) == '*') {
            int i = 0;
            while (i < p.length() && p.charAt(i) == '*') i++;
            return s.length() == 0 ? isMatch(s, p.substring(i))
                    : isMatch(s.substring(1), p.substring(i - 1)) || isMatch(s, p.substring(i));
        }
        return firstMath && (s.length() == 0 ? isMatch(s, p.substring(1)) : isMatch(s.substring(1), p.substring(1)));
    }
}
