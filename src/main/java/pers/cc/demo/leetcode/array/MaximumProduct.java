package pers.cc.demo.leetcode.array;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * <p>
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-11-06 16:02
 **/
public class MaximumProduct {

    public static void main(String[] args) {
//        int[] nums=new int[]{1,2,3};
        int[] nums = new int[]{1, 2, 3, 4};
        MaximumProduct maximumProduct = new MaximumProduct();
        int res = maximumProduct.maximumProduct(nums);
        System.out.println(res);
    }

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 3) {
            int res = 1;
            for (int i = 0; i < nums.length; i++) {
                res *= nums[i];
            }
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[length-1]*nums[length-2]*nums[length-3],nums[0]*nums[1]*nums[length-1]);
    }

}
