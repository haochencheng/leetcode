package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description:
 * @author: haochencheng
 * @create: 2019-09-01 15:08
 **/
public class Flatten {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 3,4,null,6);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        Flatten flatten = new Flatten();
        flatten.flatten(treeNode);
        System.out.println(treeNode);
    }

    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        dfs(root);
        TreeNode node=null;
        TreeNode tmp=null;
        for (Integer integer : list) {
            if (node==null){
                node=new TreeNode(integer);
                tmp=node;
            }else {
                node.right=new TreeNode(integer);
                node=node.right;
            }
        }
        root.right=tmp.right;
        root.left=tmp.left;
    }

    private List<Integer> list=new LinkedList();

    public void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }



}
