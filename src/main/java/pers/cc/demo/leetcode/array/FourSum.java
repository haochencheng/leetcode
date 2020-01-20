package pers.cc.demo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2020-01-20 10:39
 **/
public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum.fourSum(nums, 0);
        System.out.println(Arrays.deepToString(lists.toArray()));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }
            int max = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = length - 1;
                int min1 = nums[i] + nums[j] + nums[k] + nums[k + 1];
                if (min1 > target) {
                    continue;
                }
                int max1 = nums[i] + nums[j] + nums[l] + nums[l - 1];
                if (max1 < target) {
                    continue;
                }
                while (k < l) {
                    int curr = nums[i] + nums[j] + nums[k] + nums[l];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (curr > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }


}
