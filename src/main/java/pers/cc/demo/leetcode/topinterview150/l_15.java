package pers.cc.demo.leetcode.topinterview150;

import java.util.*;

//5. 三数之和
//已解答
//中等
//相关标签
//premium lock icon
//相关企业
//提示
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//
//
//
//
//示例 1：
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
//示例 2：
//
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
//示例 3：
//
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
public class l_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;int j=1;int k=nums.length-1;
        Set<List<Integer>> res = new HashSet<>();
        while (i<j && j<k){
            if (nums[i] + nums[j] + nums[k] == 0 ){
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;

            }else {
                k--;
            }
            if (j==k){
                if (i==j-1){
                    return res.stream().toList();
                }
                i++;
                j=i+1;
                k=nums.length-1;
            }

        }
        return res.stream().toList();
    }


    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> lists;
//         nums= new int[]{-1,0,1,2,-1,-4};
//        lists = threeSum(nums);
//        // [[-1,-1,2],[-1,0,1]]
//        System.out.println(Arrays.toString(lists.toArray()));

         nums= new int[]{-100,-70,-60,110,120,130,160};
         lists = threeSum(nums);
        // [[-100,-60,160],[-70,-60,130]]
        System.out.println(Arrays.toString(lists.toArray()));

    }

}
