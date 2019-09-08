package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * <p>
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-08 13:31
 **/
public class AverageOfLevels {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 9, 20, 15, 7);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        AverageOfLevels averageOfLevels = new AverageOfLevels();
        List<Double> doubles = averageOfLevels.averageOfLevels(treeNode);
        System.out.println(Arrays.toString(doubles.toArray()));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(1);
        }
        LinkedList<TreeNode> nodeStack = new LinkedList();
        LinkedList<Double> result = new LinkedList();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            int size = nodeStack.size();
            double cellSum=0;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeStack.pollLast();
                cellSum+=node.val;
                if (node.left != null) {
                    nodeStack.push(node.left);
                }
                if (node.right != null) {
                    nodeStack.push(node.right);
                }
            }
            result.add(cellSum/size);
        }
        return result;
    }


}
