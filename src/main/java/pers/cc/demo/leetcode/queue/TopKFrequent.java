package pers.cc.demo.leetcode.queue;

import java.util.*;

// 前 K 个高频元素
//中等
//相关标签
//premium lock icon
//相关企业
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//
//
//示例 1：
//
//输入：nums = [1,1,1,2,2,3], k = 2
//
//输出：[1,2]
//
//示例 2：
//
//输入：nums = [1], k = 1
//
//输出：[1]
//
//示例 3：
//
//输入：nums = [1,2,1,2,1,2,3,1,3,2], k = 2
//
//输出：[1,2]
//
//
//
//提示：
//
//1 <= nums.length <= 105
//k 的取值范围是 [1, 数组中不相同的元素的个数]
//题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//
//
//进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->pair2[1]-pair1[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){//大顶堆需要对所有元素进行排序
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){//依次从队头弹出k个,就是出现频率前k高的元素
            ans[i] = pq.poll()[0];
        }
        return ans;
    }




}
