package pers.cc.demo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum3 {

    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0) {
            return res;
        }
        getCombine(n, k, 1, new ArrayList<>());
        return res;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        if(n < 0)return;
        if (k == 0) {
            if (n==0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9 - k; i++) {
            list.add(i);
            getCombine(n-i, k-1, i+1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        CombinationSum3 combinationSum3 = new CombinationSum3();
        List<List<Integer>> res = combinationSum3.combinationSum3(k, n);
        System.out.println(Arrays.deepToString(res.toArray()));
    }

}
