package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 * 示例：
 * 输入:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-07 16:46
 **/
public class LargestValues {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, null, 2, null, 3);
        List<Integer> list = Arrays.asList(1, 3, 2, 5, 3, null, 9);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        LargestValues largestValues = new LargestValues();
        System.out.println(Arrays.toString(largestValues.largestValues(treeNode).toArray()));
    }


    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> linkedList = new LinkedList();
        LinkedList<Integer> res = new LinkedList();
        linkedList.push(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.pollLast();
                max = max > node.val ? max : node.val;
                if (node.right != null) {
                    linkedList.push(node.right);
                }
                if (node.left != null) {
                    linkedList.push(node.left);
                }
            }
            res.add(max);
        }
        return res;
    }

}
