package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

public class l_122 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] -prices[i-1] > 0) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int max= maxProfit(new int[]{7,1,5,3,6,4});
        Assert.assertEquals(7, max);
         max= maxProfit(new int[]{1,2,3,4,5});
        Assert.assertEquals(4, max);
        max= maxProfit(new int[]{7,6,4,3,1});
        Assert.assertEquals(0, max);
    }

}
