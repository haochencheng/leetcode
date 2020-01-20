package pers.cc.demo.leetcode.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * 31. 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2020-01-20 11:31
 **/
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums={1,2,3};
//        int[] nums={3,2,1};
//        int[] nums={1,1,5};
//        int[] nums={1,3,2};
        NextPermutation nextPermutation=new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length == 0){
            return;
        }
        for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i]>nums[i-1]){
                for (int j = nums.length-1; j >= i; j--) {
                    if (nums[j]>nums[i-1]){
                        swap(i-1, j, nums);
                        break;
                    }
                }
                Arrays.sort(nums,i,nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int i, int j, int[] nums) {
        int num = nums[i];
        nums[i]=nums[j];
        nums[j]=num;
    }

}
