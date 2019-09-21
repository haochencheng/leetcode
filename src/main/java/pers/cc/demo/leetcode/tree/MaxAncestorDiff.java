package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 1026. 节点与其祖先之间的最大差值
 * <p>
 * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 * 示例：
 * <p>
 * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *  
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * 每个节点的值介于 0 到 100000 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-21 14:47
 **/
public class MaxAncestorDiff {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13);
//        List<Integer> list = Arrays.asList(1,null,2,null,0,3);
        List<Integer> list = Arrays.asList(2, 5, 0, null, null, 4, null, null, 6, 1, null, 3);
//        List<Integer> list = Arrays.asList(0, null, 1);
//        List<Integer> list = Arrays.asList(-10,9,20,null,null,15,7);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        MaxAncestorDiff maxAncestorDiff = new MaxAncestorDiff();
        System.out.println(maxAncestorDiff.maxAncestorDiff(treeNode));
    }


    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root.left, root.val, root.val);
        dfs(root.right, root.val, root.val);
        return result;
    }

    private int result = Integer.MIN_VALUE;

    public int dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        if (root.val > max) {
            max = root.val;
        }
        if (root.val < min) {
            min = root.val;
        }
        dfs(root.left, max, min);
        dfs(root.right, max, min);
        if (max - min > result) {
            result = max - min;
        }
        return result;
    }

}
