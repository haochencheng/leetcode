package pers.cc.demo.leetcode.sort;

import org.junit.Assert;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// 快速排序，分冶思想
// 快速排序的核心操作是“哨兵划分”，其目标是：选择数组中的某个元素作为“基准数”，将所有小于基准数的元素移到其左侧，而大于基准数的元素移到其右侧。具体来说，哨兵划分的流程如图 11-8 所示。
//
//选取数组最左端元素作为基准数，初始化两个指针 i 和 j 分别指向数组的两端。
//设置一个循环，在每轮中使用 i（j）分别寻找第一个比基准数大（小）的元素，然后交换这两个元素。
//循环执行步骤 2. ，直到 i 和 j 相遇时停止，最后将基准数交换至两个子数组的分界线。
public class QuickSort {

    public static int[] quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right){
        if (left >= right)
            return;
        // 随机化 pivot，避免最坏情况
//        int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
//        swap(nums, pivotIndex, right);
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /* 哨兵划分 */
    private static int partition(int[] nums, int left, int right) {
        // 以 nums[right] 为基准数
       int pivot = nums[right];
       int i = left ;
       for (int j = left ; j < right ; j++) {
           if (nums[j] < pivot) {
               swap(nums, i, j);
               i++;
           }
       }
       swap(nums, i, right);
       return i;
    }

    public static void main(String[] args)  {
        int[] nums = quickSort(new int[]{4, 2, 3, 5, 7, 0});
        System.out.println(Arrays.toString(nums));
        Assert.assertTrue(Arrays.equals(new int[]{0,2,3,4,5,7},nums));
    }

    static void  swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
