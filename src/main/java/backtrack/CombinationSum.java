package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        dfs(candidates,target,new ArrayList<>(),0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> path,int index) {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(target < 0){
                return;
            }
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],path,i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7));
    }

}
