package pers.cc.demo.leetcode.array;

import java.util.Arrays;

public class LeetCode_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] result=new int[m+n];
        int cur=0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[cur++] = nums1[i++];
            }else {
                result[cur++] = nums2[j++];
            }
        }
        if (i < m) {
            while (i < m){
                result[cur++] = nums1[i++];
            }
        }
        if (j < n) {
            while (j < n){
                result[cur++] = nums2[j++];
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(result).toArray()));
    }

    public static void main(String[] args) {
        merge(new int[]{1,3,4,7,9,11},6,new int[]{2,5,6,8},4);
    }

}
