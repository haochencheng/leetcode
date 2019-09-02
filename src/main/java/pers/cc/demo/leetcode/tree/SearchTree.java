package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 二叉搜索树
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-08-24 17:19
 **/
public class SearchTree {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 2, 56, 23, 9, 67, 32, 83, 6, 45);
        TreeNode treeNode = buildSearchTree(list);
        System.out.println(exist(treeNode, 67));
        System.out.println(exist(treeNode, 68));
        TreeNode delete = delete(treeNode, 6);
        System.out.println(delete);
    }

    /**
     * 构建二叉搜索树
     *
     * @param list
     * @return
     */
    public static TreeNode buildSearchTree(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return TreeNode.EMPTY_TREENODE;
        }
        TreeNode treeNode = new TreeNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            insert(treeNode, list.get(i));
        }
        return treeNode;
    }

    /**
     * 插入节点
     *
     * @param treeNode
     * @param val
     */
    public static void insert(TreeNode treeNode, int val) {
        if (treeNode.val == val) {
            throw new RuntimeException("insert node val already existed");
        }
        if (treeNode.val > val) {
            if (treeNode.left == null) {
                treeNode.left = new TreeNode(val);
            } else {
                insert(treeNode.left, val);
            }
        } else {
            if (treeNode.right == null) {
                treeNode.right = new TreeNode(val);
            } else {
                insert(treeNode.right, val);
            }
        }
    }

    /**
     * 二叉树查找算法
     *
     * @param val
     */
    public static boolean exist(TreeNode treeNode, int val) {
        if (Objects.isNull(treeNode)) {
            return false;
        }
        if (treeNode.val == val) {
            return true;
        }
        if (treeNode.val > val) {
            return exist(treeNode.left, val);
        }
        return exist(treeNode.right, val);
    }

    public static TreeNode delete(TreeNode treeNode, int val) {
        Objects.requireNonNull(treeNode);
        return delete(treeNode, null, val);
    }

    private static TreeNode delete(TreeNode treeNode, TreeNode parentNode, int val) {
        if (treeNode.val > val) {
            delete(treeNode.left, treeNode, val);
        } else if (treeNode.val < val) {
            delete(treeNode.right, treeNode, val);
        } else {
            if (Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                if (Objects.isNull(parentNode)) {
                    return null;
                } else {
                    if (parentNode.left == treeNode) {
                        parentNode.left = null;
                    } else {
                        parentNode.right = null;
                    }
                }
            } else if (Objects.isNull(treeNode.left) && Objects.nonNull(treeNode.right)) {
                if (Objects.isNull(parentNode)) {
                    return treeNode.right;
                } else {
                    if (parentNode.left == treeNode) {
                        parentNode.left = treeNode.right;
                    } else {
                        parentNode.right = treeNode.right;
                    }
                }
            } else if (Objects.nonNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                if (Objects.isNull(parentNode)) {
                    return treeNode.left;
                } else {
                    if (parentNode.left == treeNode) {
                        parentNode.left = treeNode.left;
                    } else {
                        parentNode.right = treeNode.left;
                    }
                }
            } else if (Objects.nonNull(treeNode.left) && Objects.nonNull(treeNode.right)) {
                treeNode.val=treeNode.right.val;
                delete(treeNode.right,treeNode,treeNode.val);
            }
        }
        return treeNode;
    }


}
