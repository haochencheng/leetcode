package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

public class l_11 {

    public static int maxArea(int[] height) {
        int max=0;
        int i= 0;int j= height.length-1;
        while(i<j){
            int result = Math.min(height[i] , height[j])*(j-i);
            if (height[i]<height[j]){
                ++i;
            }else {
                --j;
            }
            if (result > max) {
                max = result;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Assert.assertEquals(49,maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(1,maxArea(new int[]{1,1}));
    }


}
