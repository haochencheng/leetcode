package pers.cc.demo.leetcode.topinterview150;

public class l_26 {

    public static int removeDuplicates(int[] nums) {
        int cur = 1;
        int val=nums[0];
        for (int i =1 ; i < nums.length; i++) {
            if(val!=nums[i]){
                nums[cur++] = nums[i];
                val=nums[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{3,2,2,3}));
    }


}
