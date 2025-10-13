package pers.cc.demo.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 763. 划分字母区间
//中等
//相关标签
//premium lock icon
//相关企业
//提示
//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
//
//注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
//
//返回一个表示每个字符串片段的长度的列表。
//
//
//
//示例 1：
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
//示例 2：
//
//输入：s = "eccbbbbdec"
//输出：[10]
//
//
//提示：
//
//1 <= s.length <= 500
//s 仅由小写英文字母组成
public class PartitionLabels {

    // ababcbaca defegd ehijhklij
    // 因为没个字母只能出现在一段内，记录字母最后出现的下标位置，遍历到的时候切割
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)-'a']=i;
        }
        for (int i = 0; i < n; i++) {
            end = Math.max(end, count[s.charAt(i) - 'a']);
            if (i==end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        List<Integer> ababcbacadefegdehijhklij = p.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(Arrays.toString(ababcbacadefegdehijhklij.toArray()));
    }

}
