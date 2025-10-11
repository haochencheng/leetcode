package pers.cc.demo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 回溯+枝剪
public class Combine {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) {
            return res;
        }
        getCombine(n,k,1,new ArrayList<>());
        return res;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n-k+1 ; i++) {
            list.add(i);
            getCombine(n, k - 1, i + 1, list);
            list.removeLast();
        }
    }



    public static void main(String[] args) {
        int n=3;
        int k=2;
        Combine combine = new Combine();
        List<List<Integer>> res = combine.combine(n,k);
        System.out.println(Arrays.deepToString(res.toArray()));
    }

}
