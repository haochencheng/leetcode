package pers.cc.demo.leetcode.common;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-09 18:38
 **/
@ToString
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode EMPTY_TREENODE = new TreeNode();

    public TreeNode findByVal(int val) {
        return findByVal(val, this);
    }

    private TreeNode findByVal(int val, TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val == val) {
            return treeNode;
        }
        TreeNode left = findByVal(val, treeNode.left);
        if (left != null) {
            return left;
        }
        TreeNode right = findByVal(val, treeNode.right);
        if (right != null) {
            return right;
        }
        return null;
    }


    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        boolean offer = queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            // 构建左子树
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            // 构建右子树
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // 测试：前序遍历
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, null, 4, 5, 6};
        TreeNode root = buildTree(arr);
        preorder(root); // 输出: 1 2 4 3 5 6
    }


}
