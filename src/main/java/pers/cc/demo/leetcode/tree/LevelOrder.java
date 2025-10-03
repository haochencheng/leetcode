package pers.cc.demo.leetcode.tree;


import org.junit.Assert;
import pers.cc.demo.leetcode.common.ListUtils;
import pers.cc.demo.leetcode.common.TreeNode;

import java.util.*;

//102. 二叉树的层序遍历
//已解答
//中等
//相关标签
//premium lock icon
//相关企业
//提示
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
//示例 1：
//
//
//输入：root = {3,9,20,null,null,15,7}
//输出：{{3},{9,20},{15,7}}
//示例 2：
//
//输入：root = {1}
//输出：{{1}}
//示例 3：
//
//输入：root = {}
//输出：{}
//
//
//提示：
//
//树中节点数目在范围 {0, 2000} 内
//-1000 <= Node.val <= 1000
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> list = ListUtils.toList(new int[][]{{3}, {9, 20}, {15, 7}});
        Assert.assertTrue(list.equals(levelOrder(treeNode)));
    }

}
