package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

import java.util.HashSet;

// 存在重复元素 II
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
//
//
//
//示例 1：
//
//输入：nums = [1,2,3,1], k = 3
//输出：true
//示例 2：
//
//输入：nums = [1,0,1,1], k = 1
//输出：true
//示例 3：
//
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false
//
//
//
//
//提示：
//
//1 <= nums.length <= 105
//-109 <= nums[i] <= 109
//0 <= k <= 105
public class L_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(i!=0){
                set.remove(nums[i-1]);
            }
            while(j-i<=k && j<nums.length){
                if(!set.add(nums[j])){
                    return true;
                }
                j++;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Assert.assertFalse(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

}
