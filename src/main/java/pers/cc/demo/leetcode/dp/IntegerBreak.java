package pers.cc.demo.leetcode.dp;

// 343. 整数拆分
//中等
//相关标签
//premium lock icon
//相关企业
//提示
//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
//
//返回 你可以获得的最大乘积 。
//
//
//
//示例 1:
//
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//示例 2:
//
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//
//
//提示:
//
//2 <= n <= 58
public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int curMax = 0;
            for (int j = 0; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
