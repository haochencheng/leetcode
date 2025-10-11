package pers.cc.demo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubsequences {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, Integer.MIN_VALUE, list);
        return res;
    }

    private void dfs(int[] nums, int index, int last, List<Integer> list) {
        if (index == nums.length) {
            if (list.size() >= 2) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (nums[index] >= last) {
            list.add(nums[index]);
            dfs(nums, index + 1, nums[index], list);
            list.removeLast();
        }
        if (nums[index] != last) {
            dfs(nums, index + 1, last, list);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        FindSubsequences findSubsequences = new FindSubsequences();
        List<List<Integer>> res = findSubsequences.findSubsequences(nums);
        System.out.println(Arrays.deepToString(res.toArray()));
    }

}
