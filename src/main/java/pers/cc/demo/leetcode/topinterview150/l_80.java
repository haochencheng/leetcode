package pers.cc.demo.leetcode.topinterview150;

import java.util.Arrays;
import java.util.HashMap;

public class l_80 {

    public static int removeDuplicates(int[] nums) {
        int count=1;
        int cur = 1;
        int val=nums[0];
        for (int i =1 ; i < nums.length; i++) {
            if(val!=nums[i]){
                nums[cur++] = nums[i];
                val=nums[i];
                count=1;
            }else {
                if (count<2){
                    nums[cur++] = nums[i];
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

}
