package pers.cc.demo.leetcode.greedy;

import org.junit.Assert;

// 455. 分发饼干
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
//
//对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
//
//
//示例 1:
//
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释:
//你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。
//所以你应该输出 1。
//示例 2:
//
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释:
//你有两个孩子和三块小饼干，2 个孩子的胃口值分别是 1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出 2。
public class FindContentChildren {


    public int findContentChildren(int[] g, int[] s) {
        int i =0;
        int k=0;
        while(i<g.length && k<s.length){
            if (s[k] >=g[i]) {
                i++;
            }
            k++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] g =new  int[]{1,2,3}; int[] s = new int[]{1,1};
        FindContentChildren fc = new FindContentChildren();
        int contentChildren = fc.findContentChildren(g, s);
        Assert.assertEquals(1, contentChildren);
    }


}
