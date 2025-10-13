package pers.cc.demo.leetcode.dp.knapsack;

import org.junit.Assert;

// 300. 最长递增子序列
//中等
//相关标签
//premium lock icon
//相关企业
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//
//
//示例 1：
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//示例 2：
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
//示例 3：
//
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
//
//
//提示：
//
//1 <= nums.length <= 2500
//-104 <= nums[i] <= 104
public class LengthOfLIS {

    // 0,3,1,6,2,2,7
    // 3627
    // 10,9,2,5,3,7,101,18
    // 2,3,7,101
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int left = lengthOfLISRange(nums, 0, length - 1);
        int right = lengthOfLISRange(nums, 1, length );
        return Math.max(left, right);
    }

    public int lengthOfLISRange(int[] nums, int start, int end) {
        int[] dp = new int[end + 1];
        dp[0] = nums[start];
        dp[1] = nums[start + 1];
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[end - 1];
    }

    public static void main(String[] args) {
        LengthOfLIS lis = new LengthOfLIS();
        int res = lis.lengthOfLIS(new int[]{2, 3, 2});
        Assert.assertEquals(3, res);
    }

}
