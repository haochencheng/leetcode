package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-04 17:01
 **/
public class RightSideView {

    public static void main(String[] args) {
        // 134
//        List<Integer> list = Arrays.asList(1,2,3,null,5,null,4);
        // 12
//        List<Integer> list = Arrays.asList(1,2);
        // 134
//        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> list = Arrays.asList(1,2,3,null,5,null,4);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        RightSideView rightSideView = new RightSideView();
        System.out.println(Arrays.toString(rightSideView.rightSideView(node).toArray()));
    }

    private List linkedList = new LinkedList();
    private LinkedList<TreeNode> row = new LinkedList();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return linkedList;
        }
        row.add(root);
        while (!row.isEmpty()) {
            for (int i = row.size(); i > 0; i--) {
                TreeNode node = row.poll();
                if (node == null) {
                    continue;
                }
                if (i == 1) {
                    linkedList.add(node.val);
                }
                if (node.left != null) {
                    row.add(node.left);
                }
                if (node.right != null) {
                    row.add(node.right);
                }
            }
        }
        return linkedList;
    }

}
