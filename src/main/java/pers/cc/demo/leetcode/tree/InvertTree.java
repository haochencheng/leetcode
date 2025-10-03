package pers.cc.demo.leetcode.tree;

import org.junit.Assert;
import pers.cc.demo.leetcode.common.TreeNode;

// 226. 翻转二叉树
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
//示例 1：
//
//
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//示例 2：
//
//
//
//输入：root = [2,1,3]
//输出：[2,3,1]
//示例 3：
//
//输入：root = []
//输出：[]
//
//
//提示：
//
//树中节点数目范围在 [0, 100] 内
//-100 <= Node.val <= 100
public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{4, 7, 2, 9, 6, 3, 1});
        Assert.assertTrue(TreeNode.isSameTree(invertTree(treeNode), treeNode1));
    }

}
