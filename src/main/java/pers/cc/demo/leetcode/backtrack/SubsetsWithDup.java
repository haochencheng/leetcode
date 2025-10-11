package pers.cc.demo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, i+1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(Arrays.deepToString(subsetsWithDup.subsetsWithDup(nums).toArray()));
    }

}
