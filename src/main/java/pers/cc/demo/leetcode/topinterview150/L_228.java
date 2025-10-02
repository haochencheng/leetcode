package pers.cc.demo.leetcode.topinterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 228. 汇总区间
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//给定一个  无重复元素 的 有序 整数数组 nums 。
//
//区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。
//
//返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。
//
//列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//"a->b" ，如果 a != b
//"a" ，如果 a == b
//
//
//示例 1：
//
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
//示例 2：
//
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
public class L_228 {

    public static List<String> summaryRanges(int[] nums) {
        int i = 0;
        int length = nums.length;
        List<String> ret = new ArrayList<>();
        while (i < length) {
            int low=i;
            do {
                i++;
            } while (i < length && nums[i] == nums[i - 1]+1);
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            ret.add(temp.toString());

        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> strings = summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(Arrays.toString(strings.toArray()));
    }

}
