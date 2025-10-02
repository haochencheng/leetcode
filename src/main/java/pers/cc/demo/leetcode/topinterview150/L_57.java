package pers.cc.demo.leetcode.topinterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//7. 插入区间
//中等
//相关标签
//premium lock icon
//相关企业
//提示
//给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
//
//在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
//
//返回插入之后的 intervals。
//
//注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
//
//
//
//示例 1：
//
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
//示例 2：
//
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
public class L_57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        int n = intervals.length, i = 0;
        // 区间情况分三种，小于需要插入的区间，有重合的区间，大于的区间
        // 处理小于的区间
        while(i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        // 处理重合的区间
        while(i < n && intervals[i][0] <= newInterval[1]){
            // 合并
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);
        // 处理大于的区间
        while(i < n && intervals[i][0] > newInterval[1]){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
            int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
            System.out.println(Arrays.deepToString(insert(intervals,new int[]{2,5})));
    }

}
