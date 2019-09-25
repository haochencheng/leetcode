package pers.cc.demo.leetcode.array;

/**
 * 移除重复元素 （快慢指针）
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出线的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地删除重复的元素，使得每个元素只出线一次，返回移除后数组的新长度
 * 不要使用额外的空间
 * <p>
 * 示例1：
 * 给定数组 nums=[1,1,2]
 * 函数应该返回新长度2，并将原数组nums前两个修改为1,2
 * <p>
 * 示例2：
 * 给定数组 nums=[0,0,1,1,1,2,2,3,3,4]
 * 函数应该返回新长度2，并将原数组nums前五个修改为0,1,2,3,4
 * <p>
 * 不需要考虑数组中超出新长度后面的元素
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-25 16:22
 **/
public class RemoveDuplicates {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int res = removeDuplicates.removeDuplicates(nums);
        System.out.println(res);
    }

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


}
