package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-01 11:07
 **/
public class IsBalanced {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(3,9,20,null,null,15,7);
        List<Integer> list = Arrays.asList(1, null, 2, null, 3);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        IsBalanced isBalanced = new IsBalanced();
        System.out.println(isBalanced.isBalanced(treeNode));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        //左子树是平衡树，右子树也是平衡树并且深度差值不超过1
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(depth(root.left) - depth(root.right)) > 1 ? false : true);
    }

    /**
     * 计算层级
     *
     * @param root
     */
    public int depth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left),  depth(root.right)) + 1;
    }

}
