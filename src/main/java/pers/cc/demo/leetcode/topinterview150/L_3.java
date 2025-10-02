package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;

// 字符的最长子串
//尝试过
//中等
//相关标签
//premium lock icon
//相关企业
//提示
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
//
//
//示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
public class L_3 {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();

        if(length == 0) return 0;
        int ans = Integer.MIN_VALUE ;
        HashSet<Character> map = new HashSet<>();
        int rk = -1;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                map.remove(s.charAt(i - 1));
            }
            while( rk+1<length && !map.contains(s.charAt(rk+1))){
                map.add(s.charAt(rk+1));
                rk++;
            }
            ans = Math.max(ans, map.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        Assert.assertEquals(3, new L_3().lengthOfLongestSubstring("abcabcbb"));
    }


}
