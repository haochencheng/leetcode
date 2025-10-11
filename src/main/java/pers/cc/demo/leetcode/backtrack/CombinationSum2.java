package pers.cc.demo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> path,int index) {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(target < 0){
                return;
            }
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],path,i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

}
