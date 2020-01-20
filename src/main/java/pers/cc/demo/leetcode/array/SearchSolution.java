package pers.cc.demo.leetcode.array;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2020-01-08 20:09
 **/
public class SearchSolution {

    public static void main(String[] args) {
        int[] ints = {5, 7, 7, 8, 8, 10};
//        int[] ints = {5,7,7,8,8,10};
//        int[] ints = {1};
//        int[] ints = {2,2};
        SearchSolution searchSolution = new SearchSolution();
        int[] result = searchSolution.searchRange(ints, 8);
        System.out.println(Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length==0){
            return result;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return result;
        }
        if (nums.length==1){
            if (nums[0]==target){
                return new int[]{0,0};
            }else {
                return result;
            }
        }
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {

            } else if ((nums[mid] < target)) {

            } else {

            }
        }
        return result;
    }


}
