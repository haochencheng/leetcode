package pers.cc.demo.leetcode.sort;

import org.junit.Assert;

import java.util.Arrays;

// 选择排序
// 每次将一个未排序的数字和其他的比较，找一个最小值。
public class SelectSort {

    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j =i+1; j < arr.length  ; j++) {
                if (arr[j] < arr[i]) {
                    minIndex=j;
                }
            }
            int temp= arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args)  {
        int[] ints = selectSort(new int[]{4, 2, 3, 5, 7, 0});
        System.out.println(Arrays.toString(ints));
        Assert.assertTrue(Arrays.equals(new int[]{0,2,3,4,5,7},ints));
    }

}
