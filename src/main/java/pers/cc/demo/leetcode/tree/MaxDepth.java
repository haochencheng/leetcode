package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.LeetCodePart1;
import pers.cc.demo.leetcode.common.TreeNode;

// 104. 二叉树的最大深度
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//给定一个二叉树 root ，返回其最大深度。
//
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        int res = new MaxDepth().maxDepth(treeNode);
        System.out.println(res);
    }

}
