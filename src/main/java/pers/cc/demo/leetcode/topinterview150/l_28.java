package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

public class l_28 {

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String needle;
        String haystack;
        haystack = "sadbutsad";
        needle = "sad";
        Assert.assertEquals(0, strStr(haystack, needle));
        haystack = "hello";
        needle = "ll";
        Assert.assertEquals(2, strStr(haystack, needle));
        haystack = "mississippi ";
        needle = "issip";
        Assert.assertEquals(4, strStr(haystack, needle));
    }

}
