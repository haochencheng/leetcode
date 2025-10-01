package pers.cc.demo.leetcode.topinterview150;

public class l_27 {

    public static int removeElement(int[] nums, int val) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3},3));
    }

}
