package pers.cc.demo.leetcode.tree;


import pers.cc.demo.leetcode.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtll;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 94. 二叉树的中序遍历
 * @description:
 * @author: haochencheng
 * @create: 2019-08-24 16:08
 **/
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtll.fillTreeNodeWidth(Arrays.asList(1, null, 2, 3));
        System.out.println(treeNode);
        List<Integer> list = inorderTraversal(treeNode);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static List<Integer> list=new LinkedList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)){
            return list;
        }
        if (Objects.nonNull(root.left)){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (Objects.nonNull(root.right)){
            inorderTraversal(root.right);
        }
        return list;
    }

}
