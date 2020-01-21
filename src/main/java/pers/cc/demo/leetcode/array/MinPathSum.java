package pers.cc.demo.leetcode.array;

import java.util.Arrays;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @description:
 * @author: haochencheng
 * @create: 2020-01-21 15:18
 **/
public class MinPathSum {

    public static void main(String[] args) {
        int[][] nums={{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum minPathSum =new MinPathSum();
        int minPath = minPathSum.minPathSum(nums);
        System.out.println(minPath);
    }


    public int minPathSum(int[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0){
                    grid[i][j]=grid[i][j]+((j-1>=0)?grid[i][j-1]:0);
                }else if (j==0){
                    grid[i][j]=grid[i][j]+ ((i-1>=0)?grid[i-1][j]:0);
                }else {
                    grid[i][j]=grid[i][j]+Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }

}
