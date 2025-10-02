package pers.cc.demo.leetcode.topinterview150;

// 56. 合并区间
//已解答
//中等
//相关标签
//premium lock icon
//相关企业
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
//示例 1：
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2：
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//示例 3：
//
//输入：intervals = [[4,7],[1,4]]
//输出：[[1,7]]
//解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
//
//
//提示：
//
//1 <= intervals.length <= 104
//intervals[i].length == 2
//0 <= starti <= endi <= 104

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L_56 {

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int l=interval[0],r=interval[1];
            if (list.isEmpty()) {
                list.add(interval);
            }else {
                int[] pre = list.getLast();
                if (pre[1] >= l) {
                    pre[1] = Math.max(pre[1], r);
                }else {
                    list.add(interval);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        intervals = new int[][]{{4,7},{1,4}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        intervals = new int[][]{{1,4},{2,3}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

}
