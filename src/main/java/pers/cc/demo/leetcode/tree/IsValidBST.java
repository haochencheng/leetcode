package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description:
 * @author: haochencheng
 * @create: 2019-08-28 08:44
 **/
public class IsValidBST {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(7, 5, 23, 87, 56, 93, 25, 1);
//        List<Integer> list = Arrays.asList(2, 1, 3);
//        List<Integer> list = Arrays.asList(0,-1);
        List<Integer> list = Arrays.asList(3,1,5,0,2,4,6);
        TreeNode treeNode = SearchTree.buildSearchTree(list);
//        treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(1);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(treeNode));
    }

    Integer last=Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return dfs(root,null,null);
    }

    private boolean dfs(TreeNode node, Integer lower, Integer upper) {
        if (node==null){
            return true;
        }
        int val=node.val;
        if (lower!=null && val <= lower){
            return false;
        }
        if (upper!=null && val >= upper){
            return false;
        }
        if (!dfs(node.left,lower,val)){
            return false;
        }
        if (!dfs(node.right,lower,upper)){
            return false;
        }
        return true;
    }


}
