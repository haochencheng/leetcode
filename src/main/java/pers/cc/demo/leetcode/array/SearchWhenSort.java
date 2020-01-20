package pers.cc.demo.leetcode.array;

import java.util.Arrays;

/**
 * @description:
 * @author: haochencheng
 * @create: 2020-01-20 14:04
 **/
public class SearchWhenSort {

    public static void main(String[] args) {
        int[] ints = {4,5,6,7,0,1,2};
//        int[] ints = {4,5,6,7,0,1,2};
//        int[] ints = {1};
//        int[] ints = {2,2};
        SearchWhenSort searchWhenSort = new SearchWhenSort();
        int result = searchWhenSort.search(ints, 0);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0){
            return -1;
        }
        int length = nums.length;
        int left=0;
        int right=length-1;
        while (left<=right){
            int mid=left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[left]<=nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid-1;
                }else{//只能从右边找
                    left = mid+1;
                }
            }else {
                if(target >= nums[mid] && target <= nums[right]){
                    left = mid +1;
                }else{//只能从左边找
                    right = mid-1;
                }

            }
        }
        return -1;
    }

}
