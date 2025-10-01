package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

//. 最长公共前缀
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//
//
//示例 1：
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//示例 2：
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//提示：
//
//1 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] 如果非空，则仅由小写英文字母组成
//
public class l_14 {

    public static String longestCommonPrefix(String[] strs) {
        int length = strs[0].length();
        if (length == 0) {
            return "";
        }
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        String longestCommonPrefix = longestCommonPrefix(strs);
        Assert.assertEquals("fl", longestCommonPrefix);
    }

}
