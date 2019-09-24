package pers.cc.demo.leetcode.tree;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-08-24 17:08
 **/
public class NumTrees97 {

    public static void main(String[] args) {
        NumTrees97 numTrees97 = new NumTrees97();
        int nums = numTrees97.numTrees(3);
        System.out.println(nums);
    }

    /**
     * 1.数学 递推公式
     * 1...n 的所有BST
     * <p>
     * 1为根节点 所有BST + 2为根节点 所有BST + ... n为根节点所有BST
     * 假设 i 为 根节点
     * <p>
     * i [f(i)]
     * /                \
     * i-1 [dp[n-i]]       n-i [dp[n-i]]
     * <p>
     * n=1 -> 1
     * n=2 -> 2
     * n=3 -> 5
     * n=4 -> 14
     * <p>
     * dp(n) = f(1) + f(2) + f(3) ... + f(n)
     * <p>
     * n = 6 , i = 3
     * 左子树1，2 右子树 4，5,6
     * 所有BST = 左子树 * 右子树
     * f(i) = dp(i-1)*dp(n-i)
     * <p>
     * dp(n) = dp(0)*dp(n-1) + dp(1)*dp(n-2) + ... + dp(n)*dp(0)
     * <p>
     * 条件：初始化dp(1)=1,dp(0)=1 (case: dp(n)*dp(0)=dp(n) 而不能是 0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //dp[i] = sum(f[1] ... f[n])
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += f(dp, j, i);
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    private int f(int[] dp, int i, int n) {
        return dp[i - 1] * dp[n - i];
    }

}
