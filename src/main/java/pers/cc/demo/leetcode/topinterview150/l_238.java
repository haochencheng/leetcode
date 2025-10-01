package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

import java.util.Arrays;

public class l_238 {

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

}
