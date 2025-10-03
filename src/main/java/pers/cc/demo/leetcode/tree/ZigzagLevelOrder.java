package pers.cc.demo.leetcode.tree;

import org.junit.Assert;
import pers.cc.demo.leetcode.common.ListUtils;
import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;

// 103. 二叉树的锯齿形层序遍历
//已解答
//中等
//相关标签
//premium lock icon
//相关企业
//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//
//
//示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
//示例 2：
//
//输入：root = [1]
//输出：[[1]]
//示例 3：
//
//输入：root = []
//输出：[]
//
//
//提示：
//
//树中节点数目在范围 [0, 2000] 内
//-100 <= Node.val <= 100
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,9,20,null,null,15,7);
        List<List<Integer>> listLambda = ListUtils.toListLambda(new int[][]{{3}, {20, 9}, {15, 7}});
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        Assert.assertTrue(listLambda.equals(zigzagLevelOrder(node)));
    }


}
