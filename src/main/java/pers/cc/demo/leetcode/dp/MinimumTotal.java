package pers.cc.demo.leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2020-01-21 12:59
 **/
public class MinimumTotal {

    public static void main(String[] args) {
        MinimumTotal minimumTotal=new MinimumTotal();
        List<Integer> list = Arrays.asList(2);
        List<Integer> list1 = Arrays.asList(3,4);
        List<Integer> list2 = Arrays.asList(5,6,7);
        List<Integer> list3 = Arrays.asList(4,1,8,3);
        List<List<Integer>> lists = Arrays.asList(list, list1, list2, list3);
        int i = minimumTotal.minimumTotal(lists);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()==0){
            return 0;
        }
        int n=triangle.size();
        int[][] f=new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i==n-1){
                    f[i][j]=list.get(j);
                }else {
                    f[i][j]=Math.min(f[i+1][j+1], f[i+1][j])+list.get(j);
                }

            }
        }
        System.out.println(f);
        return f[0][0];
    }

}
