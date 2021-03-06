package pers.cc.demo.leetcode.dynamic;

import java.util.Arrays;
import java.util.List;

/**
 * 63. 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * @description:
 * @author: haochencheng
 * @create: 2020-01-21 13:59
 **/
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int[][] nums={{0,0,0},{0,1,0},{0,0,0}};
//        int[][] nums = {{1, 0}};
//        int[][] nums = {{0, 1}, {1, 0}};
        int steps = uniquePathsWithObstacles.uniquePathsWithObstacles(nums);
        System.out.println(steps);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0){
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }else {
                    obstacleGrid[i][j] = ((i-1>=0)?obstacleGrid[i-1][j]:0) + ((j-1>=0)?obstacleGrid[i][j-1]:0);
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

}
