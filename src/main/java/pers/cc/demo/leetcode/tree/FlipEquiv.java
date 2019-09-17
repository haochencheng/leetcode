package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 951. 翻转等价二叉树
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 * <p>
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 * <p>
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
 * <p>
 * 示例：
 * <p>
 * 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * 输出：true
 * 解释：We flipped at nodes with values 1, 3, and 5.
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 100 个节点。
 * 每棵树中的每个值都是唯一的、在 [0, 99] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-17 12:28
 **/
public class FlipEquiv {

    public static void main(String[] args) {
        //#1
//        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, null, null, null, 7, 8);
//        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, null, null, null, 7, 8);
//        TreeNode treeNode1 = TreeNodeUtil.fillTreeNodeWidth(list1);
//        TreeNode treeNode2 = TreeNodeUtil.fillTreeNodeWidth(list2);
//        #2
        List<Integer> list1 = Arrays.asList(0, 3, 1, null, null, null, 2);
        List<Integer> list2 = Arrays.asList(0, 3, 1, 2);
        TreeNode treeNode1 = TreeNodeUtil.fillTreeNodeWidth(list1);
        TreeNode treeNode2 = TreeNodeUtil.fillTreeNodeWidth(list2);
        FlipEquiv flipEquiv = new FlipEquiv();
        System.out.println(flipEquiv.flipEquiv(treeNode1, treeNode2));
    }

    private LinkedList<TreeNode> leftQueue = new LinkedList();
    private LinkedList<TreeNode> rightQueue = new LinkedList();


    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {

        } else {
            return false;
        }
        leftQueue.add(root1);
        rightQueue.add(root2);
        while (!leftQueue.isEmpty()) {
            int leftSize = leftQueue.size();
            int rightSize = rightQueue.size();
            if (leftSize != rightSize) {
                return false;
            }
            for (int i = 0; i < leftSize; i++) {
                TreeNode leftTreeNode = leftQueue.poll();
                for (int j = 0; j < rightSize; j++) {
                    TreeNode rightTreeNode = rightQueue.poll();
                    if (leftTreeNode.val != rightTreeNode.val) {
                        rightQueue.add(rightTreeNode);
                    } else {
                        //判断子节点是否一致
                        int q = 0;
                        if (leftTreeNode.left != null) {
                            q++;
                        }
                        if (leftTreeNode.right != null) {
                            q++;
                        }
                        int p = 0;
                        if (rightTreeNode.left != null) {
                            p++;
                        }
                        if (rightTreeNode.right != null) {
                            p++;
                        }
                        if (p != q) {
                            return false;
                        }
                        rightSize = rightQueue.size();
                        if (rightTreeNode.left != null) {
                            rightQueue.add(rightTreeNode.left);
                        }
                        if (rightTreeNode.right != null) {
                            rightQueue.add(rightTreeNode.right);
                        }
                        break;
                    }
                    if (j == rightSize - 1) {
                        return false;
                    }
                }
                if (leftTreeNode.left != null) {
                    leftQueue.add(leftTreeNode.left);
                }
                if (leftTreeNode.right != null) {
                    leftQueue.add(leftTreeNode.right);
                }
            }
        }
        return true;
    }


}
