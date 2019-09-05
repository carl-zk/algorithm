package com.leetcode.fifty;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author carl
 */
public class WildcardMatchingTest {
    WildcardMatching match = new WildcardMatching();

    @ParameterizedTest
    @MethodSource("source")
    public void test(String s, String p, boolean expect) {
        assertEquals(expect, match.isMatch(s, p));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments("aa", "a", false),
                arguments("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
                        , "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb", false),
                arguments("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b", false),
                arguments("aa", "*", true),
                arguments("adceb", "*a*b", true),
                arguments("mississippi", "m??*ss*?i*pi", false),
                arguments("acdcb", "a*c?b", false)
        );
    }

    @Test
    public void tes() {
        //String str = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String str = "aa1aaa2aaaa3aa";
        String[] s = str.split("aa");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
