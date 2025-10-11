package pers.cc.demo.leetcode.greedy;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;

// 1005. K 次取反后最大化的数组和
//简单
//相关标签
//premium lock icon
//相关企业
//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
//
//选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
//重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
//
//以这种方式修改数组后，返回数组 可能的最大和 。
//
//
//
//示例 1：
//
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
//示例 2：
//
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
//示例 3：
//
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
//
//
//提示：
//
//1 <= nums.length <= 104
//-100 <= nums[i] <= 100
//1 <= k <= 104
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums); // 1. 先排序

        // 2. 先把负数变成正数，尽可能消耗 k
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // 3. 计算当前数组和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 4. 处理剩余的 k，如果是奇数，需要反转当前最小值
        if (k % 2 == 1) {
            int minVal = Arrays.stream(nums).min().getAsInt(); // 找最小值
            sum -= 2 * minVal; // 相当于将最小值变负
        }

        return sum;
    }

    public static void main(String[] args) {
        LargestSumAfterKNegations largestSumAfterKNegations;
        largestSumAfterKNegations = new LargestSumAfterKNegations();
        int i;
//        i = largestSumAfterKNegations.largestSumAfterKNegations(new int[]{4, 2, 3}, 1);
//        Assert.assertEquals(5, i);

        largestSumAfterKNegations = new LargestSumAfterKNegations();
        i = largestSumAfterKNegations.largestSumAfterKNegations(new int[]{3,-1,0,2}, 1);
        Assert.assertEquals(6, i);
    }

}
