package pers.cc.demo.leetcode.topinterview150;

import javax.swing.*;
import java.util.Arrays;

// 数组向右移动N位

public class l_189 {

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length];
        for(int i = 0; i< length; i++){
            result[(i+k)%length]=nums[i];
        }
        System.arraycopy(result, 0, nums, 0, length);
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
        // 3,99,-1,-100
        rotate(new int[]{-1,-100,3,99},2);
    }

}
