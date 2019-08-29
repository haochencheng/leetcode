package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: haochencheng
 * @create: 2019-08-28 08:44
 **/
public class IsValidBST {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 5, 23, 87, 56, 93, 25, 1);
        TreeNode treeNode = SearchTree.buildSearchTree(list);
        treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        List<Integer> list = new LinkedList<>();
        return dp(root, list,null);
    }

    private boolean dp(TreeNode root, List<Integer> integerList,Boolean left) {
        boolean isBST = integerList.stream().filter(val -> root.val >= val || root.val >= val).findAny().isPresent();
        if (isBST) {
            return false;
        }
        if (Objects.nonNull(root.left) && Objects.nonNull(root.right)
        ) {
            isBST = root.val <= root.left.val || root.val >= root.right.val;
            if (isBST) {
                return false;
            }
        } else if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return true;
        } else if (Objects.isNull(root.left) || Objects.isNull(root.right)) {
            isBST = Objects.isNull(root.left) ? root.val >= root.right.val : root.val <= root.left.val;
            if (isBST) {
                return false;
            }
        }
        if (left==null){
            integerList.add(root.val);
        }

        return dp(root.left, integerList,true) && dp(root.right,integerList,false);
    }

}
