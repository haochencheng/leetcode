package pers.cc.demo.leetcode.sort;

import org.junit.Assert;

import java.util.Arrays;

// 归并排序，分冶思想，将排序二分，然后先排序子数组最后合并。和二叉树后序遍历类似，左子树，右子树，根。
public class MergeSort {

    public static int[]  mergeSort(int[] arr) {
        mergeSort(arr,0,arr.length-1);
        return arr;
    }

    private static void mergeSort(int[] arr,int left,int right) {
        if(left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }


    private static void merge(int[] arr,int left,int mid,int right) {
        int[] temp = new int[right - left + 1];
        int i = left; int j=mid+1;int k=0;

        // 归并两个有序数组
        while(i<=mid && j<=right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        // 把剩余元素加入
        while(i<=mid) {
            temp[k++] = arr[i++];
        }
        while(j<=right) {
            temp[k++] = arr[j++];
        }

        // 拷贝回原数组
        System.arraycopy(temp, 0, arr, left, temp.length);

    }

    public static void main(String[] args)  {
        int[] ints = mergeSort(new int[]{4, 2, 3, 5, 7, 0});
        System.out.println(Arrays.toString(ints));
        Assert.assertTrue(Arrays.equals(new int[]{0,2,3,4,5,7},ints));
    }


}
