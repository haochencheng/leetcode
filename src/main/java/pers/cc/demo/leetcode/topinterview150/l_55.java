package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

public class l_55 {

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Assert.assertEquals(true, canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(false, canJump(new int[]{3, 2, 1, 0, 4}));

    }

}
