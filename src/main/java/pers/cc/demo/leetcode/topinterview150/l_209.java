package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

// 度最小的子数组
//中等
//相关标签
//premium lock icon
//相关企业
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//
//示例 1：
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//示例 2：
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//示例 3：
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//提示：
//
//1 <= target <= 109
//1 <= nums.length <= 105
//1 <= nums[i] <= 104
public class l_209 {


    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        if (nums.length==0) return 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int target = 7;
        int nums = minSubArrayLen(target,new int[]{2,3,1,2,4,3});
        Assert.assertEquals(2,nums);
         target = 4;
         nums = minSubArrayLen(target,new int[]{1,4,4});
        Assert.assertEquals(1,nums);


    }

}
