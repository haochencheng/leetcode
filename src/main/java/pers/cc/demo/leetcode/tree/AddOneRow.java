package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 623. 在二叉树中增加一行
 * <p>
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * <p>
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * <p>
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * <p>
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * v = 1
 * <p>
 * d = 2
 * <p>
 * 输出:
 * 4
 * / \
 * 1   1
 * /     \
 * 2       6
 * / \     /
 * 3   1   5
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /
 * 2
 * / \
 * 3   1
 * <p>
 * v = 1
 * <p>
 * d = 3
 * <p>
 * 输出:
 * 4
 * /
 * 2
 * / \
 * 1   1
 * /     \
 * 3       1
 * 注意:
 * <p>
 * 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
 * 输入的二叉树至少有一个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-07 21:53
 **/
public class AddOneRow {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 6, 3, 1, 5);
//        List<Integer> list = Arrays.asList(4, 2, null, 3, 1);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        AddOneRow addOneRow = new AddOneRow();
        treeNode = addOneRow.addOneRow(treeNode, 1, 1);
        System.out.println(treeNode);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.add(root);
        int i = 0;
        outer:
        while (!linkedList.isEmpty()) {
            i++;
            int size = linkedList.size();
            for (int i1 = 0; i1 < size; i1++) {
                TreeNode node = linkedList.pollLast();
                if (d == 1) {
                    TreeNode treeNode=new TreeNode(v);
                    treeNode.left=root;
                    return treeNode;
                } else {
                    if (i + 1 == d) {
                        TreeNode treeNode = node;
                        //left
                        TreeNode left = treeNode.left;
                        TreeNode newNode = new TreeNode(v);
                        newNode.left = left;
                        treeNode.left = newNode;
                        // right
                        TreeNode right = treeNode.right;
                        TreeNode newRightNode = new TreeNode(v);
                        newRightNode.right = right;
                        treeNode.right = newRightNode;
                        if (i + 1 == d && i1 == size - 1) {
                            return root;
                        }
                    }
                    if (node.left != null) {
                        linkedList.push(node.left);
                    }
                    if (node.right != null) {
                        linkedList.push(node.right);
                    }
                }
            }
        }
        return root;
    }


}
