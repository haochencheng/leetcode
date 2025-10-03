package pers.cc.demo.leetcode.tree;

import org.junit.Assert;
import pers.cc.demo.leetcode.common.TreeNode;

// 100. 相同的树
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
//
//
//示例 1：
//
//
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
//示例 2：
//
//
//输入：p = [1,2], q = [1,null,2]
//输出：false
//示例 3：
//
//
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
//
//
//提示：
//
//两棵树上的节点数目都在范围 [0, 100] 内
//-104 <= Node.val <= 104
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }else {
            if(p != null && q != null && p.val == q.val){
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, 3, 4});
        TreeNode treeNode1= TreeNode.buildTree(new Integer[]{1, 2, 3, 5});
        Assert.assertTrue(new IsSameTree().isSameTree(treeNode, treeNode));
        Assert.assertFalse(new IsSameTree().isSameTree(treeNode, treeNode1));
    }

}
