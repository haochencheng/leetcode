package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-01 11:52
 **/
public class PathSum {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        TreeNode treeNode = TreeNodeUtll.fillTreeNodeWidth(list);
        PathSum pathSum = new PathSum();
        List<List<Integer>> lists = pathSum.pathSum(treeNode, 22);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    private List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new LinkedList<>();
        dfs(root, sum, list);
        return lists;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum-=root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && sum == 0){
            lists.add(new ArrayList<>(list));
        }
        dfs(root.left, sum, list);
        dfs(root.right, sum, list);
        list.remove(list.size() - 1);
    }


}
