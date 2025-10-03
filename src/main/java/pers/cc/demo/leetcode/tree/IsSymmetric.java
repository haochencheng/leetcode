package pers.cc.demo.leetcode.tree;

import org.junit.Assert;
import pers.cc.demo.leetcode.common.TreeNode;

// 101. 对称二叉树
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
//示例 1：
//
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//示例 2：
//
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//提示：
//
//树中节点数目在范围 [1, 1000] 内
//-100 <= Node.val <= 100
public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }

    private static boolean check(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null  ){
            return false;
        }
        return root1.val == root2.val &&  check(root1.left, root2.right) && check(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        Assert.assertTrue(isSymmetric(treeNode));
    }
}
