package pers.cc.demo.leetcode.array;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2020-01-20 14:52
 **/
public class CombinationSum {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 6, 7};
        int[] nums = {2, 3, 5};
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(nums, 8);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    /**
     * 求所有可能和  递归枝减
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combinationSum(candidates, target , new ArrayList<>(),result,0);
        return result;
    }

    public void combinationSum(int[] candidates,int target,List<Integer> list,List<List<Integer>> result,int start){
        if (target<0){
            return;
        }
        if (target==0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[start]){
                break;
            }
            list.add(candidates[i]);
//            System.out.println(list);
            combinationSum(candidates, target-candidates[i],list,result,i);
            list.remove(list.size()-1);
        }
    }


}
