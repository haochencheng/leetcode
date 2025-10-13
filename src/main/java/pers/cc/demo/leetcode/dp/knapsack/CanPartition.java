package pers.cc.demo.leetcode.dp.knapsack;

import org.junit.Assert;

import java.util.Arrays;

// 416. 分割等和子集
//中等
//相关标签
//premium lock icon
//相关企业
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
//示例 1：
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//示例 2：
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//提示：
//
//1 <= nums.length <= 200
//1 <= nums[i] <= 100
public class CanPartition {

    // [ 2,2,1,1]
    //  [ 0 0 0 0 ]
    //  [ 2 0 0 0 ]
    //  [ 0 2 3 4 ]
    //  [ 2 4 5 6 ]
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        int[][] dp = new int[n][target + 1];
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];  // 只有一个数时，能取到的最大值就是 nums[0]
        }

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                int unSelect = dp[i - 1][j];
                int select = j < num ? 0 : dp[i - 1][j - num]+num;
                dp[i][j] = Math.max(select, unSelect);
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][target]==target;
    }

    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        // 一维 DP 数组，只记录「最大可达和」
        // 初始: [0,0,0,0,0,0,0,0,0,0,0,0]
        //处理 1: [0,1,1,1,1,1,1,1,1,1,1,1]
        //处理 5: [0,1,1,1,1,5,6,6,6,6,6,6]
        //处理11: [0,1,1,1,1,5,6,6,6,6,11,11]
        //处理 5: 最终 dp[11] = 11
        int[] dp = new int[target + 1];
        for (int num : nums) {
            // 注意：必须从大到小遍历，否则会重复使用同一个数字（变成完全背包）
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        boolean b;
        b= canPartition.canPartition(new int[]{1,5,11,5});
        Assert.assertTrue(b);
//         b = canPartition.canPartition(new int[]{1,2,5});
//        Assert.assertFalse(b);
    }

}
