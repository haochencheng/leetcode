package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description:
 * @author: haochencheng
 * @create: 2019-09-03 15:46
 **/
public class MaxPathSumHard {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
//        List<Integer> list = Arrays.asList(0);
//        List<Integer> list = Arrays.asList(-10,9,20,null,null,15,7);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        MaxPathSumHard maxPathSumHard = new MaxPathSumHard();
        System.out.println(maxPathSumHard.maxPathSum(treeNode));
    }

    private Integer max=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left=Math.max(0, maxPath(root.left));
        int right=Math.max(0, maxPath(root.right));
        max = Math.max(max, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

}
