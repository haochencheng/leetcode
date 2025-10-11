package pers.cc.demo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums,int index,List<Integer> list){
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums,i+1,list);
            list.removeLast();
        }

    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1,2,3});
        System.out.println(Arrays.toString(subsets1.toArray()));
    }

}
