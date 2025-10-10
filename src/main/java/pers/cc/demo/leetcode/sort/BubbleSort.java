package pers.cc.demo.leetcode.sort;

import org.junit.Assert;

import java.util.Arrays;

// 冒泡排序
// 两层循环，像泡泡一样每次找一个最大值。
public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args)  {
        int[] ints = bubbleSort(new int[]{4, 2, 3, 5, 7, 0});
        System.out.println(Arrays.toString(ints));
        Assert.assertTrue(Arrays.equals(new int[]{0,2,3,4,5,7},ints));
    }


}
