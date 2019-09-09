package com.leetcode.onehundred;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author carl
 */
public class SimplifyPathTest {
    SimplifyPath simplifyPath = new SimplifyPath();

    @ParameterizedTest
    @MethodSource("source")
    public void test(String path, String expect) {
        assertEquals(expect, simplifyPath.simplifyPath(path));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments("/home/", "/home"),
                arguments("/../", "/"),
                arguments("/...", "/..."),
                arguments("/.hidden", "/.hidden"),
                arguments("/home/foo/.bashrc", "/home/foo/.bashrc"),
                arguments("/home//foo/", "/home/foo"),
                arguments("/a/./b/../../c/", "/c"),
                arguments("/a/../../b/../c//.//", "/c"),
                arguments("/a//b////c/d//././/..", "/a/b/c")

        );
    }
}
