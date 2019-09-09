package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 513. 找树左下角的值
 * <p>
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * 输出:
 * 7
 *  
 * <p>
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-07 01:17
 **/
public class FindBottomLeftValue {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 3);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        FindBottomLeftValue findBottomLeftValue = new FindBottomLeftValue();
        int bottomLeftValue = findBottomLeftValue.findBottomLeftValue(treeNode);
        System.out.println(bottomLeftValue);
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.push(root);
        while (!linkedList.isEmpty()) {
            root = linkedList.pollLast();
            if (root.right != null) {
                linkedList.push(root.right);
            }
            if (root.left != null) {
                linkedList.push(root.left);
            }
        }
        return root.val;
    }

}
