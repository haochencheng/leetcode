package pers.cc.demo.leetcode.array;

import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 207. 课程表
// 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
//在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//
//例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//示例 1：
//
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
//示例 2：
//
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
//
//
//提示：
//
//1 <= numCourses <= 2000
//0 <= prerequisites.length <= 5000
//prerequisites[i].length == 2
//0 <= ai, bi < numCourses
//prerequisites[i] 中的所有课程对 互不相同
//
public class CanFinish {

    private   Map<Integer, Integer> map = new HashMap<>();
    private Integer ans= Integer.MIN_VALUE;;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //3  [[0,1],[1,2],[3,4]]
        // 0 ->1 ->2
        // 34
        // 4 [ [0,1],[1,2],[2,3] ]
        if (numCourses == 0 && prerequisites.length == 0) {
            return true;
        }
        if (numCourses <=2 && prerequisites.length == 1) {
            return true;
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.put(prerequisites[i][0], prerequisites[i][1]);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            dfs(prerequisites[i][0],1);
            if (ans>=numCourses) {
                return true;
            }
        }
        return false;
    }

    public Integer dfs(Integer course,int cur) {
        cur++;
        ans= Math.max(ans,cur);
        if (map.containsKey(course)) {
            Integer value = map.get(course);
            dfs(value,cur);
        }
        return cur;
    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        Assert.assertTrue(canFinish.canFinish(2, new int[][]{{0,1}}));
        Assert.assertFalse(canFinish.canFinish(2, new int[][]{{0,1},{1,0}}));
        Assert.assertTrue(canFinish.canFinish(3, new int[][]{{0,1},{1,2},{2,3}}));
        Assert.assertFalse(canFinish.canFinish(4, new int[][]{{0,1},{1,2},{2,3},{4,3}}));
    }


}
