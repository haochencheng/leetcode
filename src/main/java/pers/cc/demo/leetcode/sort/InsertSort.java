package pers.cc.demo.leetcode.sort;


import org.junit.Assert;

import java.util.Arrays;

// 插入排序
// 和整理扑克牌一样，选择一张牌，和左边已经排序的比较，插入到合适为止
public class InsertSort {

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args)  {
        int[] ints = insertSort(new int[]{4, 2, 3, 5, 7, 0});
        System.out.println(Arrays.toString(ints));
        Assert.assertTrue(Arrays.equals(new int[]{0,2,3,4,5,7},ints));
    }

}
