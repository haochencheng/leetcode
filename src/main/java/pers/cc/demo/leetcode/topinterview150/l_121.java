package pers.cc.demo.leetcode.topinterview150;

public class l_121 {

    public static int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i <prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }else if (prices[i]- lowest > maxProfit) {
                maxProfit=prices[i]- lowest;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int max= maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(max);
    }

}
