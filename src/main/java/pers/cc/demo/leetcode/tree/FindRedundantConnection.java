package pers.cc.demo.leetcode.tree;

import java.util.*;

/**
 * 684. 冗余连接
 * 在本问题中, 树指的是一个连通且无环的无向图。
 * <p>
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * <p>
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 * 1
 * / \
 * 2 - 3
 * 示例 2：
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * 5 - 1 - 2
 * |   |
 * 4 - 3
 * 注意:
 * <p>
 * 输入的二维数组大小在 3 到 1000。
 * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
 * 更新(2017-09-26):
 * 我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-12 19:16
 **/
public class FindRedundantConnection {

    public static void main(String[] args) {
//        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
//        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
//        int[][] edges = new int[][]{{1, 4}, {3, 4}, {1, 3}};
//        3,5
//        int[][] edges = new int[][]{{1, 3}, {3, 4}, {1, 5}, {3, 5}, {2, 3}};
//        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        // test 合并时候 尽量缩小 合并后的树的高度
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        int[] redundantConnection = findRedundantConnection.findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection));
    }

    private int[] ints;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        ints = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            ints[i] = i;
            rank[i] = 0;
        }
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[1];
    }

    public boolean union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (pRoot == qRoot) {
            return false;
        }
        /**
         * 尽量缩小 合并后的树的高度
         * 低树 指向  高树  树高 为原高树的高度
         * 如果两个树高度相同 则选一个 高度 + 1
         */
        if (rank[pRoot] > rank[qRoot]) {
            ints[qRoot] = qRoot;
        } else if (rank[pRoot] < rank[qRoot]) {
            ints[pRoot] = qRoot;
        } else {
            ints[pRoot] = qRoot;
            rank[pRoot] = rank[pRoot] + 1;
        }
        return true;
    }

    public int getRoot(int i) {
        while (i != ints[i]) {
            i = ints[i];
        }
        return i;
    }

    public boolean find(int p, int q) {
        return getRoot(p) == getRoot(q);
    }


}
