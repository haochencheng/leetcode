package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

public class l__45 {

    public static int jump(int[] nums) {
        int length = nums.length;
        int count = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < length-1; i++) {
            max = Math.max(max, nums[i] + i);
            if (end == i) {
                end = max;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Assert.assertEquals(2, jump(new int[]{1,2,3}));
        Assert.assertEquals(2, jump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(2, jump(new int[]{2,3,0,1,4}));
        Assert.assertEquals(3, jump(new int[]{1, 1, 1, 1}));
    }

}
